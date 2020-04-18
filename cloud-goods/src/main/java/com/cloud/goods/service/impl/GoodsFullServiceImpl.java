package com.cloud.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.goods.entity.GoodsAttr;
import com.cloud.goods.entity.GoodsAttrVal;
import com.cloud.goods.service.GoodsFullService;
import com.cloud.goods.entity.Goods;
import com.cloud.goods.entity.GoodsSku;
import com.cloud.goods.mapper.GoodsAttrMapper;
import com.cloud.goods.mapper.GoodsAttrValMapper;
import com.cloud.goods.mapper.GoodsSkuMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsFullServiceImpl implements GoodsFullService {

    @Autowired
    private GoodsAttrMapper goodsAttrMapper;

    @Autowired
    private GoodsAttrValMapper goodsAttrValMapper;

    @Autowired
    private GoodsSkuMapper goodsSkuMapper;


    @Override
    public void fullGoodsAttr(Goods goods) {
        QueryWrapper<GoodsSku> queryWrapper = new QueryWrapper<>();
        GoodsSku goodsSku = new GoodsSku();
        goodsSku.setGoodsId(goods.getId());
        queryWrapper.setEntity(goodsSku);
        List<GoodsSku> goodsSkuList = goodsSkuMapper.selectList(queryWrapper);
        if (null == goodsSkuList || goodsSkuList.size() == 0)
            return;
        //解析属性
        for (GoodsSku gs : goodsSkuList){
            String attr = gs.getAttrId();
            if (StringUtils.isBlank(attr))
                return;
            String arr[] = attr.split(",");
            List<GoodsAttrVal> valList = new ArrayList<>();
            for (String a : arr) {
                String k = a.split(":")[0];
                String v = a.split(":")[1];
                GoodsAttr ga = goodsAttrMapper.selectById(k);
                GoodsAttrVal gav = goodsAttrValMapper.selectById(v);
                gav.setAttrName(ga.getAttrName());
                valList.add(gav);
            }
            gs.setGoodsAttrValList(valList);
        }
        goods.setGoodsSkuList(goodsSkuList);
    }

    @Override
    public void fullGoodsAttrList(List<Goods> list) {
        for (Goods goods : list) {
            QueryWrapper<GoodsSku> queryWrapper = new QueryWrapper<>();
            GoodsSku goodsSku = new GoodsSku();
            goodsSku.setGoodsId(goods.getId());
            queryWrapper.setEntity(goodsSku);
            List<GoodsSku> goodsSkuList = goodsSkuMapper.selectList(queryWrapper);
            if (null == goodsSkuList || goodsSkuList.size() == 0)
                return;
            //解析属性
            for (GoodsSku gs : goodsSkuList){
                String attr = gs.getAttrId();
                if (StringUtils.isBlank(attr))
                    return;
                String arr[] = attr.split(",");
                List<GoodsAttrVal> valList = new ArrayList<>();
                for (String a : arr) {
                    String k = a.split(":")[0];
                    String v = a.split(":")[1];
                    GoodsAttr ga = goodsAttrMapper.selectById(k);
                    GoodsAttrVal gav = goodsAttrValMapper.selectById(v);
                    gav.setAttrName(ga.getAttrName());
                    valList.add(gav);
                }
                gs.setGoodsAttrValList(valList);
            }
            goods.setGoodsSkuList(goodsSkuList);
        }
    }
}
