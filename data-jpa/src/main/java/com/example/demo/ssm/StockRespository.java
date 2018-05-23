package com.example.demo.ssm;

import com.example.demo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jason on 18/5/23.
 */
public interface StockRespository extends CrudRepository<Stock, Integer> {
    Stock findById(int id);
}
