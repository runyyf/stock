package com.hugo.stock.mapper;

import com.hugo.stock.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper {
    /**
     * 查询所有
     *
     * @return
     */
    List<Stock> findAll();

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    List<Stock> findById(Long id);

    /**
     * 添加
     *
     * @param t
     */
    void create(Stock t);

    /**
     * 删除（批量）
     *
     * @param ids
     */
    void delete(Long... ids);

    /**
     * 修改
     *
     * @param t
     */
    void update(Stock t);
}
