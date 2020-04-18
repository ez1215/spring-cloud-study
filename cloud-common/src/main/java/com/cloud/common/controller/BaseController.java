package com.cloud.common.controller;

import com.cloud.common.model.ReturnData;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class BaseController {

    private static Integer SUCCESS_CODE = 1;
    private static Integer FAILURE_CODE = 0;

    /**
     * @Description 初始化成功返回Object和list结果
     */
    public <T> ReturnData<T> initSuccessObjectResult(T t, String msg) {
        ReturnData<T> rd = new ReturnData<>();
        rd.setCode(SUCCESS_CODE);
        rd.setDesc(StringUtils.isEmpty(msg)?"success":msg);
        rd.setData(t);
        return rd;
    }

    public <T> ReturnData<T> initSuccessObjectResult(T t) {
        ReturnData<T> rd = new ReturnData<>();
        rd.setCode(SUCCESS_CODE);
        rd.setDesc("success");
        rd.setData(t);
        return rd;
    }

    public <T> ReturnData<T> initSuccessListResult(List<T> list) {
        ReturnData<T> rd = new ReturnData<>();
        rd.setCode(SUCCESS_CODE);
        rd.setDesc("success");
        rd.setList(list);
        return rd;
    }

    public <T> ReturnData<T> initSuccessListResult(String msg, List<T> list) {
        ReturnData<T> rd = new ReturnData<>();
        rd.setCode(SUCCESS_CODE);
        rd.setDesc(msg);
        rd.setList(list);
        return rd;
    }

    public <T> ReturnData<T> initSuccessResult() {
        ReturnData<T> rd = new ReturnData<>();
        rd.setCode(SUCCESS_CODE);
        rd.setDesc("success");
        rd.setData(null);
        return rd;
    }

    /**
     * @Description 初始化失败
     */
    public <T> ReturnData<T> initErrorResult() {
        ReturnData<T> rd = new ReturnData<>();
        rd.setCode(FAILURE_CODE);
        rd.setDesc("服务不可用");
        return rd;
    }

    /**
     * @Description 初始化失败返回Object结果
     */
    public <T> ReturnData<T> initErrorObjectResult(String desc) {
        ReturnData<T> rd = new ReturnData<>();
        rd.setCode(FAILURE_CODE);
        rd.setDesc(desc);
        return rd;
    }
}
