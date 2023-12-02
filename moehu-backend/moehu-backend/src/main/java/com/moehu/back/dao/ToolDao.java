package com.moehu.back.dao;
import com.moehu.back.model.SMSModel;
import com.moehu.back.model.UpdateModel;
import com.moehu.back.model.request.UpdateListRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ToolDao {
    UpdateModel getNewUpdate();
    List<UpdateModel> getAllUpdate(UpdateListRequest update);
    Integer addNewUpdate(UpdateModel update);
    Integer addUpdateCount(UpdateModel update);
    Integer deleteUpdate(Integer id);

    Integer addSMSYan(SMSModel smsModel);
    SMSModel getSMSYan(String sms_iphone);

    Integer dleSMSYan(String sms_iphone);

    Integer addBackImg();


}
