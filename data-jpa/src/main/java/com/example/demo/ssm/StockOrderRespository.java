package com.example.demo.ssm;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jason on 18/5/23.
 */
public interface StockOrderRespository extends CrudRepository<StockOrder, Integer> {
}
