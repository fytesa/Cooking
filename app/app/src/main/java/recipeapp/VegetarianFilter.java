package recipeapp;

public class VegetarianFilter implements RecipeFilter {
    public boolean filter(String recipe) {
        return recipe.toLowerCase().contains("овощ");
    }
}
