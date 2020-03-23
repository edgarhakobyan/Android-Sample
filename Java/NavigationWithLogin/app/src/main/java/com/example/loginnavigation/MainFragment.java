package com.example.loginnavigation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class MainFragment extends Fragment {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        boolean isLoggedIn = false;

        if (getActivity() != null) {
            SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
            isLoggedIn = sharedPref.getBoolean("isLoggedIn", false);
        }


        Button button = getView().findViewById(R.id.viewProfileButton);
        final boolean finalIsLoggedIn = isLoggedIn;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (finalIsLoggedIn) {
                    Navigation.findNavController(view).navigate(MainFragmentDirections.actionMainToProfile());
                } else {
                    Navigation.findNavController(view).navigate(MainFragmentDirections.actionMainToLoginNavigation());
                }

            }
        });
    }

}
