package com.example.viajesexpress;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.viajesexpress.ui.login.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Si es la primera vez que se abre la app, mostrar el LoginFragment
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, new LoginFragment())
                    .commit();
        }
    }
}
