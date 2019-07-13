package by.epam.controller.builder.impl;

import by.epam.bean.Candy;
import by.epam.bean.Ingredients;
import by.epam.bean.Values;
import by.epam.controller.builder.TagHandler;

public class GeneralTagHandleOperations implements TagHandler {
    public void handle(Candy candy, String tag, String value){
        switch (tag) {
            case "name":
                candy.setName(value);
                break;
            case "energy":
                candy.setEnergy(value);
                break;
            case "filled":
                candy.setFilled(Boolean.valueOf(value));
                break;
            case "typeName":
                candy.setType(value);
                break;
            case "woter":
                candy.addIngredient(Ingredients.Woter, value);
                break;
            case "sugar":
                candy.addIngredient(Ingredients.Sugar, value);
                break;
            case "protein":
                candy.addValues(Values.Protein, value);
                break;
            case "fat":
                candy.addValues(Values.Fat, value);
                break;
            case "carbohydrates":
                candy.addValues(Values.Carbohydrates, value);
                break;
        }
    }
}
