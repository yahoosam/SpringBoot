package com.demo.jpacrud.service;

import com.demo.jpacrud.dao.LaptopRepository;
import com.demo.jpacrud.model.LaptopDeals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealsServiceImpl implements DealsService {
    @Autowired
    LaptopRepository laptoprepo;

    @Override
    public LaptopDeals createdeal(LaptopDeals laptopDeals) {
        laptoprepo.save(laptopDeals);
        return laptoprepo.findById(laptopDeals.getUpc()).orElse(new LaptopDeals());
    }

    @Override
    public LaptopDeals readdeal(long upc) {
        return laptoprepo.findById(upc).orElse(new LaptopDeals());
    }

    @Override
    public LaptopDeals updatedeal(LaptopDeals laptopDeals) {
        laptoprepo.save(laptopDeals);
        return laptoprepo.findById(laptopDeals.getUpc()).orElse(new LaptopDeals());
    }

    @Override
    public void deletedeal(long upc) {
        laptoprepo.deleteById(upc);
    }
}
