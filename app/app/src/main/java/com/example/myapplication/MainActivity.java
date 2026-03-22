package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import recipeapp.RecipeDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private RecipeDatabaseHelper dbHelper;
    private EditText etRecipeName, etIngredients;
    private Button btnAddRecipe, btnShowRecipes;
    private TextView tvRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new RecipeDatabaseHelper(this);
        etRecipeName = findViewById(R.id.etRecipeName);
        etIngredients = findViewById(R.id.etIngredients);
        btnAddRecipe = findViewById(R.id.btnAddRecipe);
        btnShowRecipes = findViewById(R.id.btnShowRecipes);
        tvRecipes = findViewById(R.id.tvRecipes);

        btnAddRecipe.setOnClickListener(v -> addRecipe());
        btnShowRecipes.setOnClickListener(v -> showRecipes());
    }

    private void addRecipe() {
        String recipeName = etRecipeName.getText().toString();
        String ingredients = etIngredients.getText().toString();

        if (!recipeName.isEmpty() && !ingredients.isEmpty()) {
            boolean inserted = dbHelper.addRecipe(recipeName, ingredients);
            if (inserted) {
                Toast.makeText(this, "Рецепт добавлен", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Ошибка при добавлении", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showRecipes() {
        Cursor cursor = dbHelper.getAllRecipes();
        StringBuilder recipes = new StringBuilder();
        while (cursor.moveToNext()) {
            recipes.append("Name: ").append(cursor.getString(1)).append("\n");
            recipes.append("Ingredients: ").append(cursor.getString(2)).append("\n\n");
        }
        tvRecipes.setText(recipes.toString());
    }
}
