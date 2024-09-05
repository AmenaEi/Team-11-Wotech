package com.datorium.Datorium.API.Controllers;

import com.datorium.Datorium.API.DTOs.Cheese;
import com.datorium.Datorium.API.DTOs.UpdateCheeseDTO;
import com.datorium.Datorium.API.Services.CheeseShopService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cheese")
public class CheeseShopController {

    private CheeseShopService cheeseShopService;

    public CheeseShopController() {
        cheeseShopService = new CheeseShopService();
    }

    @PostMapping("/addCheese")
    public int addCheese(@RequestBody Cheese cheese) {
        return cheeseShopService.addCheese(cheese);
    }

    @GetMapping("/getCheeses")
    public ArrayList<Cheese> getCheeses() {
        return cheeseShopService.getCheeses();
    }

    @PostMapping("/updateCheese")
    public Cheese updateCheese(@RequestBody UpdateCheeseDTO updateCheeseDTO){
        return cheeseShopService.updateCheese(updateCheeseDTO.cheeseIndex, updateCheeseDTO.cheese);
    }
}
