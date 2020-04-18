package com.cloud.goods.service;

import com.cloud.goods.entity.Goods;

import java.util.List;

public interface GoodsFullService {
    void fullGoodsAttr(Goods goods);

    void fullGoodsAttrList(List<Goods> list);
}
