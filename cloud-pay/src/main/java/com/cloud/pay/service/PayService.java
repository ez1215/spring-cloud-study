package com.cloud.pay.service;

import com.cloud.common.model.ReturnData;

public interface PayService {
    public ReturnData payOrder(String orderNo);
}
