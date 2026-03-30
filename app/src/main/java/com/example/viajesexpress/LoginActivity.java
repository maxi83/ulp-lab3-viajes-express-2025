package com.example.viajesexpress;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.viajesexpress.ui.login.RegistroFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void irAMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void irARegistro() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.login_nav_host, new RegistroFragment())
                .addToBackStack(null)
                .commit();
    }
}