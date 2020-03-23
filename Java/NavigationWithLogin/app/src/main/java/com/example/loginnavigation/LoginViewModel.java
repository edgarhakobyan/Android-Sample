package com.example.loginnavigation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    public enum AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED,          // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }

    private final MutableLiveData<AuthenticationState> authenticationState = new MutableLiveData<>();
    private String username = "";

//    public LoginViewModel() {
//        authenticationState.setValue(AuthenticationState.UNAUTHENTICATED);
//        username = "";
//    }


    MutableLiveData<AuthenticationState> getAuthenticationState() {
        return authenticationState;
    }

    public String getUsername() {
        return username;
    }

    void authenticate(String username, String password) {
        if (passwordIsValidForUsername(username, password)) {
            this.username = username;
            authenticationState.setValue(AuthenticationState.AUTHENTICATED);
        } else {
            authenticationState.setValue(AuthenticationState.INVALID_AUTHENTICATION);
        }
    }

    void refuseAuthentication() {
        authenticationState.setValue(AuthenticationState.UNAUTHENTICATED);
    }

    private boolean passwordIsValidForUsername(String username, String password) {
        return username.equals(password);
    }
}
