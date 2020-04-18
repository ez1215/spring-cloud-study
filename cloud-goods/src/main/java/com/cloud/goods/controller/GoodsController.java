package com.cloud.goods.controller;

import com.cloud.common.controller.BaseController;
import com.cloud.common.exception.BusinessException;
import com.cloud.common.model.ReturnData;
import com.cloud.common.vo.GoodsVo;
import com.cloud.goods.entity.Goods;
import com.cloud.goods.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
@Slf4j
public class GoodsController extends BaseController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/allGoods")
    public ReturnData<Goods> allGoods() {
        return initSuccessListResult(goodsService.allGoods());
    }

    @PostMapping("/getGoodsPrice")
    public Double getGoodsPrice(@RequestBody Integer skuId) {
        return goodsService.getGoodsPrice(skuId);
    }

    @PostMapping("/deductStock")
    public ReturnData deductStock(@RequestBody GoodsVo goodsVo) {
        try {
            int res = goodsService.deductStock(goodsVo);
            if (res > 0)
                return initSuccessResult();
            return initErrorResult();
        }catch (BusinessException be){
            log.error(be.getMessage(),be);
            return initErrorObjectResult(be.getMessage());
        }catch (Exception e) {
            log.error(e.getMessage(),e);
            return initErrorResult();
        }
    }
}
