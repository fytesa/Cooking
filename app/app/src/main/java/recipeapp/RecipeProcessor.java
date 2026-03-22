package recipeapp;

import java.util.List;

public class RecipeProcessor {
    private RecipeFilter filter;

    public RecipeProcessor(RecipeFilter filter) {
        this.filter = filter;
    }

    public void process(List<String> recipes) {
        for (String r : recipes) {
            if (filter.filter(r)) {
                System.out.println("Подходит: " + r);
            }
        }
    }
}
