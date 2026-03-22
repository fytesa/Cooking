package recipeapp;


import java.util.List;

// Класс, отвечающий только за отображение рецептов
public class RecipePrinter {
    public void print(List<String> recipes) {
        for (String r : recipes) {
            System.out.println("Рецепт: " + r);
        }
    }
}

