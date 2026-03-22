package com.example.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class PanelActivity extends AppCompatActivity {

    LinearLayout navMap, navHome, navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile); // Используй activity_panel.xml

        // Привязка нижнего меню
        navMap = findViewById(R.id.bottom_navigation).findViewById(R.id.nav_map);
        navHome = findViewById(R.id.bottom_navigation).findViewById(R.id.nav_home);
        navProfile = findViewById(R.id.bottom_navigation).findViewById(R.id.nav_profile);

        // Обработка нажатий
        navMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход к карте
                Intent intent = new Intent(PanelActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход к базе рецептов
                Intent intent = new Intent(PanelActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        navProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Уже в профиле — можно оставить пустым или показать сообщение
            }
        });
    }
}
