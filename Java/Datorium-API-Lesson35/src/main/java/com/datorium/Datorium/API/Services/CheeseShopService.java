package com.datorium.Datorium.API.Services;

import com.datorium.Datorium.API.DTOs.Cheese;
import com.datorium.Datorium.API.Repo.CheeseShopRepo;

import java.util.ArrayList;

public class CheeseShopService {
    private CheeseShopRepo cheeseShopRepo;
    public CheeseShopService(){
        cheeseShopRepo = new CheeseShopRepo();
    }

    public int addCheese(Cheese cheese) {
        return cheeseShopRepo.addCheese(cheese);
    }

    public ArrayList<Cheese> getCheeses() {
        return cheeseShopRepo.getCheeses();
    }

    public Cheese updateCheese(int cheeseIndex, Cheese updateCheeseDTO) {
        return cheeseShopRepo.updateCheese(cheeseIndex, updateCheeseDTO);
    }
}
