package com.moehu.back.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.moehu.back.dao.ToolDao;
import com.moehu.back.model.ResultModel;
import com.moehu.back.model.SMSModel;
import com.moehu.back.model.UpdateModel;
import com.moehu.back.model.request.UpdateListRequest;
import com.moehu.back.service.ToolService;
import com.moehu.back.utils.ResultUtils;
import com.moehu.back.utils.Tool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ToolServiceImpl implements ToolService {

    @Autowired
    ToolDao toolDao;

    @Override
    public ResultModel getNewUpdate(String type, UpdateListRequest update) {
        // app端使用
        if (type == "one") {
            UpdateModel up = toolDao.getNewUpdate();
            if (up == null) {
                return ResultUtils.Error("没有数据");
            } else {
                return ResultUtils.Success(up);
            }
        // 管理后台获取所有版本列表
        } else if (type == "all") {
            Page pageLimt = PageHelper.startPage(update.getPage(), update.getCount());
            List<UpdateModel> all = toolDao.getAllUpdate(update);
            if (all.isEmpty()) {
                List a = new ArrayList();
                return ResultUtils.Success(a);
            } else {
                return ResultUtils.Success(Tool.CountPage(pageLimt, all));
            }
        } else {
            return ResultUtils.Error("参数错误");
        }
    }

    @Override
    public ResultModel addNewUpdate(UpdateModel update) {
        Integer ins = toolDao.addNewUpdate(update);
        if (ins == 0) {
            return ResultUtils.Error("发布失败");
        } else {
            return ResultUtils.SuccessStatus("发布成功");
        }
    }

    @Override
    public ResultModel addUpdateCount(UpdateModel update) {
        Integer ins = toolDao.addUpdateCount(update);
        if (ins == 0) {
            return ResultUtils.Error("计数失败");
        } else {
            return ResultUtils.SuccessStatus("计数成功");
        }
    }

    @Override
    public ResultModel deleteUpdate(Integer id) {
        Integer delId = toolDao.deleteUpdate(id);
        if (delId == 1) {
            return ResultUtils.SuccessStatus("删除成功");
        } else {
            return ResultUtils.SuccessStatus("删除失败");
        }
    }

    @Override
    public ResultModel addSMSYan(SMSModel smsModel) {
        Integer ins = toolDao.addSMSYan(smsModel);

        if (ins==0){
            return ResultUtils.Error("发送失败");
        }else {
            return ResultUtils.SuccessStatus("发送成功");
        }
    }

    @Override
    public SMSModel getSMSYan(String sms_iphone) {
        System.out.println("======getSMSYan========");
        System.out.println(sms_iphone);
        SMSModel smsModel = toolDao.getSMSYan(sms_iphone);
        return smsModel;
    }

    @Override
    public ResultModel deleteSMS(String sms_iphone) {
        System.out.println("正在删除验证码。。。");
        Integer ins = toolDao.dleSMSYan(sms_iphone);
        return null;
    }
}
