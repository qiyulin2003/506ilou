package com.moehu.back.utils;

import com.moehu.back.model.ResultModel;

public class ResultUtils {

    /**
     * 请求成功
     * @param par 具体的数据
     * @return
     */
    public static ResultModel Success (Object par) {
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(200);
        resultModel.setMessage(null);
        resultModel.setData(par);
        return resultModel;
    }

    /**
     * 请求成功和操作都成功，但是不需要返回数据给前端，只是返回一个操作状态的文字提示
     * @param message 具体信息
     * @return
     */
    public static ResultModel SuccessStatus (String message) {
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(100);
        resultModel.setMessage(message);
        resultModel.setData(null);
        return resultModel;
    }

    /**
     * 请求失败
     * @param message 错误信息
     * @return
     */
    public static ResultModel Error(String message) {
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(404);
        resultModel.setMessage(message);
        resultModel.setData(null);
        return resultModel;
    }

    /**
     * 请求失败
     * @param message 错误信息
     * @return
     */
    public static ResultModel ErrorToken(String message) {
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(101);
        resultModel.setMessage(message);
        resultModel.setData(null);
        return resultModel;
    }
}
