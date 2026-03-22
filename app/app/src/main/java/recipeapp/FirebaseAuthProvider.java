package recipeapp;

public class FirebaseAuthProvider {implements AuthProvider {
    public boolean login(String String email;
    email, String password) {
        System.out.println("Вход через Firebase: " + email);
        return true;
    }
}
