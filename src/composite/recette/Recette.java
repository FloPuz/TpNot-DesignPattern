package composite.recette;

import composite.recette.interfaces.Component;

import java.util.*;

public class Recette implements Component {
    @Deprecated
    private Map<Ingredient, Double> ingredients = new HashMap<>();
    @Deprecated
    private Map<Recette, Double> sousRecettes = new HashMap<>();

    @Deprecated
    public void add(double quantite, Ingredient ingredient) {
        ingredients.put(ingredient, quantite);
    }

    @Deprecated
    public void addSousRecette(double quantite, Recette recette) {
        sousRecettes.put(recette, quantite);
    }

    public Map<Ingredient, Double> getIngredients() {
        return ingredients;
    }

    @Deprecated
    public Map<Recette, Double> getSousRecettes() {
        return sousRecettes;
    }


    /*Mon Code*/
    private Map<Component, Double> components = new HashMap<>();

    public void addComponent(double quantite, Component component) {
        components.put(component, quantite);
    }

    @Override
    public double getPrix() {
        double prixRecette = 0;
        for (Map.Entry<Component, Double> entry : components.entrySet()) {
            Component component = entry.getKey();
            double quantite = entry.getValue();
            double prixComponent = component.getPrix();
            prixRecette += prixComponent * quantite;
        }
        return prixRecette;
    }



    /*FIN Mon Code*/

}