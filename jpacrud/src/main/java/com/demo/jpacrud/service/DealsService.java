package com.demo.jpacrud.service;

import com.demo.jpacrud.model.LaptopDeals;

public interface DealsService {
    LaptopDeals createdeal(LaptopDeals laptopDeals);

    LaptopDeals readdeal(long upc);

    LaptopDeals updatedeal(LaptopDeals laptopDeals);

    void deletedeal(long upc);
}
