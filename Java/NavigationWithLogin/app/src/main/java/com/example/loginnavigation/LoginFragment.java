package com.example.loginnavigation;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    private EditText username;
    private EditText password;
    private Button login;
    private Button register;

    private LoginViewModel loginViewModel;

    public LoginFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);

        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        login = view.findViewById(R.id.loginBtn);
        register = view.findViewById(R.id.goToRegisterPage);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginViewModel.authenticate(username.getText().toString(), password.getText().toString());
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(LoginFragmentDirections.actionLoginToRegister());
            }
        });

        final NavController navController = Navigation.findNavController(view);

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        loginViewModel.refuseAuthentication();
                        navController.popBackStack(R.id.mainFragment, false);
                    }
                });

        if (getActivity() != null) {
            final SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);


            loginViewModel.getAuthenticationState().observe(getViewLifecycleOwner(), new Observer<LoginViewModel.AuthenticationState>() {
                @Override
                public void onChanged(LoginViewModel.AuthenticationState authenticationState) {
                    switch (authenticationState) {
                        case AUTHENTICATED:
                            final SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putBoolean("isLoggedIn", true);
                            editor.putString("userName", username.getText().toString());
                            editor.putString("password", password.getText().toString());
                            editor.apply();
                            Navigation.findNavController(view).navigate(LoginFragmentDirections.actionGlobalProfile());
                            break;
                        case INVALID_AUTHENTICATION:
                            Snackbar.make(view, R.string.invalid_credentials, Snackbar.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
