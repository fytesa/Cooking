package recipeapp;

import java.util.ArrayList;
import java.util.List;

// === Singleton Pattern ===
class RecipeManager {
    private static RecipeManager instance;

    private RecipeManager() {}

    public static RecipeManager getInstance() {
        if (instance == null) {
            instance = new RecipeManager();
        }
        return instance;
    }

    public void loadRecipes() {
        System.out.println("Загрузка рецептов из базы...");
    }
}

// === Decorator Pattern ===
interface Recipe {
    String getDescription();
}

class BasicRecipe implements Recipe {
    public String getDescription() {
        return "Базовый рецепт";
    }
}

abstract class RecipeDecorator implements Recipe {
    protected Recipe decoratedRecipe;

    public RecipeDecorator(Recipe recipe) {
        this.decoratedRecipe = recipe;
    }

    public String getDescription() {
        return decoratedRecipe.getDescription();
    }
}

class VegetarianRecipe extends RecipeDecorator {
    public VegetarianRecipe(Recipe recipe) {
        super(recipe);
    }

    public String getDescription() {
        return super.getDescription() + " [вегетарианский]";
    }
}

// === Observer Pattern ===
interface Observer {
    void update(String recipeName);
}

interface Subject {
    void addObserver(Observer o);
    void notifyObservers(String recipeName);
}

class RecipePublisher implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(String recipeName) {
        for (Observer o : observers) {
            o.update(recipeName);
        }
    }

    public void addNewRecipe(String recipeName) {
        System.out.println("Добавлен новый рецепт: " + recipeName);
        notifyObservers(recipeName);
    }
}

class RecipeUser implements Observer {
    private String name;

    public RecipeUser(String name) {
        this.name = name;
    }

    public void update(String recipeName) {
        System.out.println(name + " получил уведомление: " + recipeName);
    }
}

// === Main ===
public class CookGuidePatterns {
    public static void main(String[] args) {
        // Singleton
        RecipeManager manager = RecipeManager.getInstance();
        manager.loadRecipes();

        // Decorator
        Recipe base = new BasicRecipe();
        Recipe veggie = new VegetarianRecipe(base);
        System.out.println("Описание рецепта: " + veggie.getDescription());

        // Observer
        RecipePublisher publisher = new RecipePublisher();
        publisher.addObserver(new RecipeUser("Андрей"));
        publisher.addObserver(new RecipeUser("Мария"));
        publisher.addNewRecipe("Паста с томатами");
    }
}
