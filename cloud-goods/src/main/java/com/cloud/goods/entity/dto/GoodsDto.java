package com.cloud.goods.entity.dto;

import com.cloud.goods.entity.Goods;
import com.cloud.goods.entity.GoodsSku;
import lombok.Data;

import java.util.List;

@Data
public class GoodsDto extends Goods {
    private static final long serialVersionUID = -2596408615836602516L;

    private List<GoodsSku> goodsSkuList;
}
