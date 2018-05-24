package com.example.demo.ssm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
//    public synchronized int createOrder(int sid) {
//        Stock stock = checkStock(sid);
//        if (stock == null) {
//            return 0;
//        }
//        saleStock(stock);
//        return createOrder(stock);
//    }

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


    //    Transactional 和 Version 可以保证 stock / order 数据库的一致性
//    Transactional 加在了 http响应函数上
//    Version加在了 stock上
//    但解决不了服务宕机的情况,
//    @Transactional
    public int createOrder(int sid) {
        try {
            Stock stock = checkStock(sid);
            if (stock == null) {
                return 0;
            }
            saleStock(stock);
            return createOrder(stock);
        } catch (Exception e) {
            System.out.println("Exception createorder");
            return 0;
        }

    }


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

        try {
            stockOrder = stockOrderRespository.save(stockOrder);
        } catch (ObjectOptimisticLockingFailureException e) {
            System.out.println("ObjectOptimisticLockingFailureException createorder stock");
            return 0;
        }


        return stockOrder.getId();
    }
}
