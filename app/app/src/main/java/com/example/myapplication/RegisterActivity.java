package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText etName, etEmailPhone, etPassword;
    private CheckBox cbAgreement;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etEmailPhone = findViewById(R.id.etEmailPhone);
        etPassword = findViewById(R.id.etPassword);
        cbAgreement = findViewById(R.id.cbAgreement);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String emailPhone = etEmailPhone.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            boolean agreed = cbAgreement.isChecked();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(emailPhone) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!agreed) {
                Toast.makeText(this, "Необходимо принять пользовательское соглашение", Toast.LENGTH_SHORT).show();
                return;
            }

            // TODO: Здесь добавь регистрацию в базу данных или в SharedPreferences

            Toast.makeText(this, "Регистрация успешна!", Toast.LENGTH_SHORT).show();

            // После регистрации переходим на экран входа
            Intent intent = new Intent(com.example.myapplication.RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
