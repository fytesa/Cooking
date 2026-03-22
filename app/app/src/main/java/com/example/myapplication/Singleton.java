package com.example.myapplication;

public class RecipeManager {
    private static RecipeManager instance;

    private RecipeManager() {
        // приватный конструктор
    }

    public static RecipeManager getInstance() {
        if (instance == null) {
            instance = new RecipeManager();
        }
        return instance;
    }

    public void loadRecipes() {
        System.out.println("Загрузка рецептов...");
    }
}
import java.util.ArrayList;
        import java.util.List;

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
        System.out.println(name + " получил уведомление о новом рецепте: " + recipeName);
    }
}
