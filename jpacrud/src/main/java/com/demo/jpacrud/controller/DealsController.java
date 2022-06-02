package com.demo.jpacrud.controller;

import com.demo.jpacrud.model.LaptopDeals;
import com.demo.jpacrud.service.DealsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DealsController {
    @Autowired
    DealsServiceImpl dealsServiceImpl;

    private static final Logger logger = LoggerFactory.getLogger(DealsController.class);

    @GetMapping("/createdeal")
    public String createdeal(LaptopDeals laptopdeals) {
        logger.info("Inside createuser method..");
        return dealsServiceImpl.createdeal(laptopdeals).toString();
    }

    @GetMapping("/readdeal")
    public String readdeal(@RequestParam long upc) {
        logger.info("Inside readdeal method.." + upc);
        return dealsServiceImpl.readdeal(upc).toString();
    }

    @GetMapping("/updatedeal")
    public String updatedeal(LaptopDeals laptopdeals) {
        logger.info("Inside updatedeal method..");
        return dealsServiceImpl.updatedeal(laptopdeals).toString();
    }

    @GetMapping("/deletedeal")
    public String deletedeal(@RequestParam long upc) {
        logger.info("Inside deletedeal method..");
        dealsServiceImpl.deletedeal(upc);
        return "deal deleted..";
    }
}
