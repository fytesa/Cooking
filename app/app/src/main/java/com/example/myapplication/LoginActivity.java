package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmailPhone, etPassword;
    private Button btnLogin, btnGoToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmailPhone = findViewById(R.id.etEmailPhone);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoToRegister = findViewById(R.id.btnGoToRegister);

        btnLogin.setOnClickListener(v -> {
            String emailPhone = etEmailPhone.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (TextUtils.isEmpty(emailPhone) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Введите email/телефон и пароль", Toast.LENGTH_SHORT).show();
                return;
            }

            // TODO: Здесь добавь проверку логина и пароля из базы или SharedPreferences

            // Если всё успешно — открываем Dashboard
            Intent intent = new Intent(com.example.myapplication.LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        });

        btnGoToRegister.setOnClickListener(v -> {
            Intent intent = new Intent(com.example.myapplication.LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
