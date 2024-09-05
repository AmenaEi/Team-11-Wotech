package com.datorium.Datorium.API.Repo;

import com.datorium.Datorium.API.DTOs.Cheese;

import java.util.ArrayList;

public class CheeseShopRepo {

    private ArrayList<Cheese> cheeses = new ArrayList<>();          //Mocked DataBase

    public int addCheese(Cheese cheese) {
        cheeses.add(cheese);
        return cheeses.size();
    }

    public ArrayList<Cheese> getCheeses() {
        return cheeses;
    }

    public Cheese updateCheese(int cheeseIndex, Cheese updateCheeseDTO) {
        var cheese = cheeses.get(cheeseIndex);
        cheese.name = updateCheeseDTO.name;
        return cheese;
    }

}
