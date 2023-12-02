package com.moehu.back.dao;


import com.moehu.back.model.GWFileModel;
import com.moehu.back.model.GWModel;
import com.moehu.back.model.salary.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface UserDao_new {

    Integer adddept(DeptModel model);

    DeptModel getdeptbyid(Integer dept_id);

    Integer adduser(UserModel model);

    List<DeptModel> getalldept();

    UserModel getuserbyid(Integer user_id);

    Integer updatedept(DeptModel model);

    Integer updateuser(UserModel model);

    Integer addLeave(LeaveModel model);

    Integer addovertime(OverTimeModel model);

    Integer addtrip(TripModel model);
    List<LeaveModel> getallleave();

    Integer updateleavestatus(LeaveModel model);

    List<UserModel> getalluser();

    Integer setgz(UserModel model);

    Integer delectuser(UserModel model);

    UserModel getuserbyiphone(String phonenumber);

    GZModel getgz();

    Integer updategz(GZModel model);

    Integer delectdept(DeptModel model);

    Integer addclockin(ClockInModel model);

    List<LeaveModel> getallleavebyid(int user_id);

    List<OverTimeModel> getallovertimebyid(int user_id);

    List<TripModel> getalltripbyid(int user_id);

    int getcdbyid(int user_id);

    int addgzt(GZNewModel gzNewModel);

    List<GZNewModel> getgzt(Integer user_id);

    int updategzt(GZNewModel gzNewModel);

    List<GZNewModel> getmygzt(Integer user_id);

    int addgw(GWModel gwModel);

    List<GWModel> getallgw();

    List<GWModel> getmyallgw(Integer user_id);

    GWModel getGWById(int id);

    int delGWById(int id);

    int auditgw(GWModel model);

    int addfile(GWFileModel fileModel);

    GWFileModel getGWFileById(String id);

    List<GWModel> getmyreallgw(Integer user_id);
}

