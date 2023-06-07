package composite.recette;

import composite.recette.interfaces.Component;

public class Ingredient implements Component {
    private double prix;
    private String unite;

    public Ingredient(double prix, String unite) {
        this.prix = prix;
        this.unite = unite;
    }

    @Deprecated
    public double getPrixOld() {
        return prix;
    }

    /****
     *
     * @return prix
     */
    @Override
    public double getPrix() {
        return this.prix;
    }
}