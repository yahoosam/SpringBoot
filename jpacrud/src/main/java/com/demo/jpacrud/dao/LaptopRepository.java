package com.demo.jpacrud.dao;

import com.demo.jpacrud.model.LaptopDeals;
import org.springframework.data.repository.CrudRepository;

public interface LaptopRepository extends CrudRepository<LaptopDeals, Long> {
}
