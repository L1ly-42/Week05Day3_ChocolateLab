package com.bnta.chocolate.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    EstateService estateService;

    @Autowired
    ChocolateService chocolateService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Estate estate1 = new Estate("Thortons", "United Kingdom");
        Estate estate2 = new Estate("Hotel Chocolat", "United Kingdom");
        Estate estate3 = new Estate("Chocolala", "Estonia");
        Estate estate4 = new Estate("Hershey's", "United States");


        estateService.saveEstate(estate1);
        estateService.saveEstate(estate2);
        estateService.saveEstate(estate3);
        estateService.saveEstate(estate4);

        Chocolate chocolate1 = new Chocolate("Thortons Continental", 40, estate1);
        Chocolate chocolate2 = new Chocolate("Rocky Road Easter Egg", 55, estate2);
        Chocolate chocolate3 = new Chocolate("Luxury Chocolate", 65, estate3);
        Chocolate chocolate4 = new Chocolate("Hershey's Kisses", 20, estate4);
        Chocolate chocolate5 = new Chocolate("Hershey's Cookies and Cream", 10, estate4);

        chocolateService.saveChocolate(chocolate1);
        chocolateService.saveChocolate(chocolate2);
        chocolateService.saveChocolate(chocolate3);
        chocolateService.saveChocolate(chocolate4);
        chocolateService.saveChocolate(chocolate5);

    }

}












