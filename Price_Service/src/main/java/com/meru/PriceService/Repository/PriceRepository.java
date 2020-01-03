package com.meru.PriceService.Repository;

import org.springframework.data.repository.CrudRepository;

import com.meru.PriceService.model.Price;

public interface PriceRepository extends CrudRepository<Price, Integer> {

}
