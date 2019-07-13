package by.epam.bean;

import java.util.HashMap;
import java.util.Map;

public class Candy {
    private String id;
    private String name;
    private String energy;
    private String type;
    private boolean isFilled;
    private Map<Ingredients, String> ingredients = new HashMap<>();
    private Map<Values, String> values = new HashMap<>();

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public void addIngredient(Ingredients key, String value) {
        ingredients.put(key, value);
    }

    public void addValues (Values key, String value) {
        values.put(key, value);
    }


    @Override
    public String toString() {
        return "Candy{" +
                "id='" + id + "'\n" +
                "- name='" + name + "'\n" +
                "- energy='" + energy + "'\n" +
                "- type='" + type + "'\n" +
                "- isFilled ='" + isFilled + "'\n" +
                "- ingredients=" + ingredients + "'\n" +
                "- values=" + values +
                '}' + "\n";
    }
}