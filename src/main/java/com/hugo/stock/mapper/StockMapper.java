package com.hugo.stock.mapper;

import com.hugo.stock.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper {
    List<Stock> findAll();

    List<Stock> findById(Long id);

    void create(Stock stock);

    void delete(Long id);

    void update(Stock stock);
}
