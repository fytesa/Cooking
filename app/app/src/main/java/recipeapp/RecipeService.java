package recipeapp;

import java.security.AuthProvider;

// В RecipeModule (ядре) зависимость от интерфейса, а не Firebase
public class RecipeService {
    private final AuthProvider auth;

    public RecipeService(AuthProvider auth) {
        this.auth = auth;
    }

    public void showUserRecipes(String email, String password) {
        if (auth.login(email, password)) {
            System.out.println("Показ рецептов пользователя.");
        }
    }
}
