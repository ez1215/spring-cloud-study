package com.cloud.goods.service;

import com.cloud.common.vo.GoodsVo;
import com.cloud.goods.entity.Goods;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GoodsService {
    public List<Goods> allGoods();

    Double getGoodsPrice(Integer id);

    @Transactional
    int deductStock(GoodsVo goodsVo);
}
