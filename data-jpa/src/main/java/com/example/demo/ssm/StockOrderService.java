package com.example.demo.ssm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

/**
 * Created by Jason on 18/5/23.
 */
@Service
public class StockOrderService {

    @Autowired
    private StockRespository stockRespository;
    @Autowired
    private StockOrderRespository stockOrderRespository;

//    可以解决问题，但并发能力降低
    public synchronized int createOrder(int sid) {
        Stock stock = checkStock(sid);
        if (stock == null) {
            return 0;
        }
        saleStock(stock);
        return createOrder(stock);
    }

//    很多问题
//    数据库链接太多、超时
//    超卖
//    public int createOrder(int sid) {
//        Stock stock = checkStock(sid);
//        if (stock == null) {
//            return 0;
//        }
//        saleStock(stock);
//        return createOrder(stock);
//    }

    private Stock checkStock(int sid) {
        Stock stock = stockRespository.findById(sid);
        if (stock.getSale().equals(stock.getCount())) {
            return null;
        }
        return stock;

    }

    private void saleStock(Stock stock) {
        stock.setSale(stock.getSale() + 1);
        stockRespository.save(stock);
    }

    private int createOrder(Stock stock) {
        StockOrder stockOrder = new StockOrder();
        stockOrder.setSid(stock.getId());
        stockOrder.setName(stock.getName());

        stockOrder = stockOrderRespository.save(stockOrder);

        return stockOrder.getId();
    }
}
