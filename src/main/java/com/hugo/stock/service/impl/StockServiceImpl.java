package com.hugo.stock.service.impl;

import com.hugo.stock.entity.Stock;
import com.hugo.stock.mapper.StockMapper;
import com.hugo.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stockService")
public class StockServiceImpl implements StockService {

    @Autowired
    private StockMapper stockMapper;

    @Override
    public List<Stock> findAll() {
        return stockMapper.findAll();
    }

    @Override
    public List<Stock> findById(Long id) {
        return stockMapper.findById(id);
    }

    @Override
    public void create(Stock stock) {
        stockMapper.create(stock);
    }

    @Override
    public void delete(Long... ids) {
        for (Long id : ids){
            stockMapper.delete(id);
        }
    }

    @Override
    public void update(Stock stock) {
        stockMapper.update(stock);
    }
}
