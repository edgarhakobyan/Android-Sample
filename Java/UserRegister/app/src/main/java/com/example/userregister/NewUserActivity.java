package com.example.userregister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.userregister.databinding.ActivityNewUserBinding;

public class NewUserActivity extends AppCompatActivity {
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        user = new User();
        NewUserActivityClickHandlers handlers = new NewUserActivityClickHandlers(this);

        ActivityNewUserBinding activityNewUserBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_user);
        activityNewUserBinding.setUser(user);
        activityNewUserBinding.setClickHandler(handlers);
    }

    public class NewUserActivityClickHandlers {
        Context context;

        NewUserActivityClickHandlers(Context context) {
            this.context = context;
        }

        public void onSubmitClicked(View view) {
            if (user.getName() == null) {
                Toast.makeText(getApplicationContext(),"Name field cannot be empty",Toast.LENGTH_LONG).show();
            } else if(!EmailValidator.isValidEmail(user.getEmail())) {
                Toast.makeText(getApplicationContext(),"Wrong email format", Toast.LENGTH_LONG).show();
            } else {
                Intent intent=new Intent();
                intent.putExtra("NAME", user.getName());
                intent.putExtra("EMAIL", user.getEmail());
                intent.putExtra("COUNTRY", user.getCountry());
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}
