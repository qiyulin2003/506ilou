package com.moehu.back.service;
import com.moehu.back.model.ResultModel;
import com.moehu.back.model.SMSModel;
import com.moehu.back.model.UpdateModel;
import com.moehu.back.model.request.UpdateListRequest;
import org.springframework.stereotype.Component;

@Component
public interface ToolService {
    ResultModel getNewUpdate(String type, UpdateListRequest update);
    ResultModel addNewUpdate(UpdateModel update);
    ResultModel addUpdateCount(UpdateModel update);
    ResultModel deleteUpdate(Integer id);

    ResultModel addSMSYan(SMSModel smsModel);

    SMSModel getSMSYan(String sms_iphone);

    ResultModel deleteSMS(String sms_iphone);

}
