package com.cloud.goods.service.impl;

import com.cloud.common.exception.BusinessException;
import com.cloud.common.vo.GoodsVo;
import com.cloud.goods.entity.Goods;
import com.cloud.goods.entity.GoodsSku;
import com.cloud.goods.mapper.GoodsMapper;
import com.cloud.goods.mapper.GoodsSkuMapper;
import com.cloud.goods.service.GoodsFullService;
import com.cloud.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsSkuMapper goodsSkuMapper;

    @Autowired
    private GoodsFullService goodsFullService;


    @Override
    public List<Goods> allGoods() {

        List<Goods> list = goodsMapper.selectList(null);
        goodsFullService.fullGoodsAttrList(list);
        return list;
    }


    @Override
    public Double getGoodsPrice(Integer id) {
        GoodsSku goodsSku = goodsSkuMapper.selectById(id);
        if (null == goodsSku)
            throw new BusinessException("商品SKU不存在", -1);
        return goodsSku.getPrice();
    }

    @Transactional
    @Override
    public synchronized int deductStock(GoodsVo goodsVo) {
        GoodsSku sku = goodsSkuMapper.selectById(goodsVo.getGoodsSkuId());
        if (null == sku)
            throw new BusinessException("商品SKU不存在", -1);
        if (sku.getStock() <= 0)
            throw new BusinessException("商品库存不足", -1);

        GoodsSku goodsSku = new GoodsSku();
        goodsSku.setStock(sku.getStock() - goodsVo.getCount());
        goodsSku.setId(goodsVo.getGoodsSkuId());
        goodsSku.setUpdateTime(new Date());
        Goods goods = goodsMapper.selectById(sku.getGoodsId());
        if (null == goods)
            throw new BusinessException("商品数据异常", -1);
        int saleCount = goods.getSaleCount();
        goods = new Goods();
        goods.setSaleCount(goodsVo.getCount() + saleCount);
        goods.setId(sku.getGoodsId());
        goodsMapper.updateById(goods);
        return goodsSkuMapper.updateById(goodsSku);
    }
}
