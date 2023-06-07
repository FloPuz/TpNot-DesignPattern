package composite.recette;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Ingredient tomate = new Ingredient(0.3, "piece");
        Ingredient oignon = new Ingredient(0.1, "piece");
        Ingredient huile = new Ingredient(10, "litre");
        Ingredient farine = new Ingredient(2, "kg");
        Ingredient sel = new Ingredient(0.5, "kg");
        Ingredient eau = new Ingredient(0.1, "litre");
        Ingredient mozzarella = new Ingredient(3, "piece");
        Ingredient boeuf = new Ingredient(20, "kg");

        Recette boulette = new Recette();
        boulette.addComponent(0.1, boeuf);
        boulette.addComponent(0.01, huile);

        Recette sauceTomate = new Recette();
        sauceTomate.addComponent(3, tomate);
        sauceTomate.addComponent(1, oignon);
        sauceTomate.addComponent(0.1, huile);
        sauceTomate.addComponent(1, boulette);

        Recette pate = new Recette();
        pate.addComponent(0.250, farine);
        pate.addComponent(0.001, sel);
        pate.addComponent(0.250, eau);
        pate.addComponent(0.010, huile);

        Recette pizza = new Recette();
        pizza.addComponent(1, sauceTomate);
        pizza.addComponent(1, pate);
        pizza.addComponent(2, mozzarella);

        // 1. Calculer le prix d'une recette de manière naïve = sans le pattern Composite
        double prixTotal = calculerPrixRecette(pizza);
        System.out.println("Le prix total de la pizza est " + prixTotal);

        // 2. Calculer le prix d'une recette en utilisant le pattern
        //Globalement tous les add sont passé en addComponent => calculerPrixRecette devient obsolete
        Recette pizzaPattern = new Recette();
        pizzaPattern.addComponent(1, sauceTomate);
        pizzaPattern.addComponent(1, pate);
        pizzaPattern.addComponent(2, mozzarella);
        System.out.println("Le prix total de la pizza est " + pizzaPattern.getPrix());
    }

    // Méthode qui calcule le prix d'une recette
    // TODO a compléter !
    private static double calculerPrixRecette(Recette recette) {
        double prixTotal = 0;

        // Prix des ingredients
        Set<Ingredient> tousSesIngredientsDirects = recette.getIngredients().keySet();
        for (Ingredient ingredient : tousSesIngredientsDirects) {
            Double quantite = recette.getIngredients().get(ingredient);
            // TODO
            Double prix = ingredient.getPrixOld();
            prixTotal+= (quantite*prix);
        }

        // Prix des sous recettes
        Set<Recette> tousSesSousRecettesDirects = recette.getSousRecettes().keySet();
        for (Recette sousRecette : tousSesSousRecettesDirects) {
            Double quantite = recette.getSousRecettes().get(sousRecette);
            double prixUnitaireDeLaSousRecette = calculerPrixRecette(sousRecette);
            prixTotal+=quantite*prixUnitaireDeLaSousRecette;
        }

        //...
        prixTotal = recette.getPrix();
        return prixTotal;
    }
}