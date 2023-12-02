package com.moehu.back.controller.app;

import com.alibaba.fastjson.JSONObject;
import com.moehu.back.annotation.AppRestController;
import com.moehu.back.dao.UserDao_new;
import com.moehu.back.model.ResultModel;
import com.moehu.back.model.salary.*;
import com.moehu.back.service.TokenService;
import com.moehu.back.utils.ResultUtils;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/user")
@AppRestController
@Api(tags = "User 用户相关的接口")
public class UserController{
    @Autowired
    UserDao_new userDao;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResultModel login(@RequestBody UserModel model){
        UserModel model1 = userDao.getuserbyiphone(model.getPhonenumber());
        if (model1==null){
            return ResultUtils.Error("没有此用户");
        }
        if (model1.getPassword().equals(model1.getPassword())){
            String token = tokenService.createdToken(model1.getUser_id());
            model1.setToken(token);
            return ResultUtils.Success(model1);
        }else {
            return ResultUtils.Error("登录失败");
        }
    }
    @PostMapping("/adddept")
    public ResultModel adddept(@RequestBody DeptModel model){
        userDao.adddept(model);
        return ResultUtils.Success("插入成功");
    }

    @PostMapping("/updatedept")
    public ResultModel updatedept(@RequestBody DeptModel model){
        userDao.updatedept(model);
        return ResultUtils.Success("修改成功");
    }

    @PostMapping("/getdeptbyid")
    public ResultModel getdeptbyid(@RequestBody Map<String,Integer>map){
        DeptModel model = userDao.getdeptbyid(map.get("dept_id"));
        return ResultUtils.Success(model);
    }

    @PostMapping("/getalldept")
    public ResultModel getalldept(){
        List<DeptModel> lists = userDao.getalldept();
        return ResultUtils.Success(lists);
    }

    @PostMapping("/adduser")
    public ResultModel adduser(@RequestBody UserModel model){
        userDao.adduser(model);
        return ResultUtils.Success("插入成功");
    }

    @PostMapping("/getuserbyid")
    public ResultModel adduser(@RequestBody Map<String,Integer>map){
        UserModel userModel = userDao.getuserbyid(map.get("user_id"));
        return ResultUtils.Success(userModel);
    }

    @PostMapping("/updateuser")
    public ResultModel updateuser(@RequestBody UserModel model){
        userDao.updateuser(model);
        return ResultUtils.Success("更新完成");
    }

    @PostMapping("/addLeave")
    public ResultModel addLeave(@RequestBody LeaveModel model){
        userDao.addLeave(model);
        return ResultUtils.Success("更新完成");
    }

    @PostMapping("/addovertime")
    public ResultModel addovertime(@RequestBody OverTimeModel model){
        userDao.addovertime(model);
        return ResultUtils.Success("更新完成");
    }

    @PostMapping("/addtrip")
    public ResultModel addtrip(@RequestBody TripModel model){
        userDao.addtrip(model);
        return ResultUtils.Success("添加成功");
    }
    @PostMapping("/getallleave")
    public ResultModel getallleave(){
        List<LeaveModel>lists = userDao.getallleave();
        for (int i = 0; i < lists.size(); i++) {
            UserModel model = userDao.getuserbyid(lists.get(i).getUser_id());
            lists.get(i).setUser_name(model.getUser_name());
        }
        return ResultUtils.Success(lists);
    }

    @PostMapping("/updateleavetatus")
    public ResultModel updateleavetatus(@RequestBody LeaveModel model){
        userDao.updateleavestatus(model);
        return ResultUtils.Success("修改状态成功");
    }

    @PostMapping("/getalluser")
    public ResultModel getalluser(){
        List<UserModel>lists = userDao.getalluser();
        for (int i = 0; i < lists.size(); i++) {
            DeptModel model = userDao.getdeptbyid(lists.get(i).getDept_id());
            lists.get(i).setDept_name(model.getDept_name());
        }
        return ResultUtils.Success(lists);
    }

    @PostMapping("/setgz")
    public ResultModel setgz(@RequestBody UserModel model){
         userDao.setgz(model);
        return ResultUtils.Success("设置成功");
    }

    @PostMapping("/getgz")
    public ResultModel getgz(){
        GZModel model = userDao.getgz();
        return ResultUtils.Success(model);
    }

    @PostMapping("/delectuser")
    public ResultModel delectuser(@RequestBody UserModel model){
        userDao.delectuser(model);
        return ResultUtils.Success("删除成功");
    }

    @PostMapping("/delectdept")
    public ResultModel delectdept(@RequestBody DeptModel model){
        userDao.delectdept(model);
        return ResultUtils.Success("删除成功");
    }


    @PostMapping("/updategz")
    public ResultModel updategz(@RequestBody GZModel model){
        userDao.updategz(model);
        return ResultUtils.Success("修改成功");
    }

    @PostMapping("/addclockin")
    public ResultModel addclockin(@RequestBody ClockInModel model){
        userDao.addclockin(model);
        return ResultUtils.Success("添加成功");
    }

    @PostMapping("/getgzt")
    public ResultModel getgzt(@RequestBody Map<String,Integer>map){
        List<GZNewModel>gzNewModels = userDao.getgzt(map.get("user_id"));
        return ResultUtils.Success(gzNewModels);
    }

    @PostMapping("/getmygzt")
    public ResultModel getmygzt(@RequestBody Map<String,Integer>map){
        List<GZNewModel>gzNewModels = userDao.getmygzt(map.get("user_id"));
        return ResultUtils.Success(gzNewModels);
    }

    @PostMapping("/updategzt")
    public ResultModel updategzt(@RequestBody GZNewModel gzNewModel){
        userDao.updategzt(gzNewModel);
        return ResultUtils.Success("更新成功");
    }
    @PostMapping("/calculetegz")
    public ResultModel calculetegz(@RequestBody UserModel userModel){
        JSONObject result = new JSONObject();
        float allprice = 0;
        UserModel model = userDao.getuserbyid(userModel.getUser_id());
        result.put("user_id",model.getUser_id());
        result.put("user_name",model.getUser_name());
        //每月基本
        float gz = model.getGz();
        result.put("gz",gz);
        allprice += gz ;
        GZModel gzModel = userDao.getgz();
        //获取请假情况
        List<LeaveModel>leave=userDao.getallleavebyid(userModel.getUser_id());
        if (leave.size()==0){
            result.put("qj",0);
            result.put("mq",gzModel.getQuanqin());
            allprice += gzModel.getQuanqin() ;
        }else {
            float time_num = 0;
            for (int i = 0; i < leave.size(); i++) {
                time_num += leave.get(i).getTime_num();
            }
            float v = gz/30/8 * time_num;
            result.put("qj",v);
            result.put("qj_num",time_num);
            result.put("mq",0);

            allprice -= v;
        }

        List<OverTimeModel>overtime=userDao.getallovertimebyid(userModel.getUser_id());
        if (overtime.size()==0){
            result.put("jb",0);
        }else {
            float time_num = 0;
            for (int i = 0; i < overtime.size(); i++) {
                time_num += overtime.get(i).getTime_num();
            }
            float v = gzModel.getJbbu() * time_num;
            result.put("jb",v);
            result.put("jb_num",time_num);
            allprice += v;
        }

        List<TripModel>trip=userDao.getalltripbyid(userModel.getUser_id());
        if (trip.size()==0){
            result.put("cc",0);
        }else {
            float time_num = 0;
            for (int i = 0; i < trip.size(); i++) {
                time_num += trip.get(i).getTime_num();
            }
            float v = gzModel.getChaibu() * time_num;
            result.put("cc",v);
            allprice += v;
            result.put("cc_num",time_num);
        }
        int cd_count = userDao.getcdbyid(userModel.getUser_id());
        float cd = gzModel.getChidao() * cd_count;
        result.put("cd",cd);
        allprice -= cd;
        result.put("cd_num",cd_count);

        result.put("jt",gzModel.getJiaobu());
        result.put("cb",gzModel.getFanbu());
//        result.put("wx",gzModel.getWx());
        allprice += gzModel.getFanbu();
        allprice += gzModel.getJiaobu();
        //获取创建时间
        Date date = model.getCreate_time();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy");
        int gl = Integer.parseInt(sdf.format(new Date())) - Integer.parseInt(sdf.format(date));
        result.put("gl",gl*gzModel.getGlbu());
        result.put("gl_num",gl);
        result.put("rc",gzModel.getCaibu());
        allprice += gl*gzModel.getGlbu();
        allprice += gzModel.getCaibu();
        Map map = cal(allprice);
        result.put("wx",map.get("wx"));
        result.put("sx",map.get("sx"));
        result.put("ns",map.get("ns"));
        result.put("sh",map.get("sh"));
        return ResultUtils.Success(result);
    }

    public Map  cal(float wages){
        Map map = new HashMap();
//接收用户输入的税前工资，这里我定义成整数
//        int wages = maps.get("money");
//接着定义一个变量保存五险一金的额度
        double insurance = wages * 0.1;
//接着我们定义一个变量保存扣除五险一金后的工资部分
        double money = wages - insurance;
        //还需要定义一个变量来表示超出5000元的部分
        double money1 = money - 5000;
//我们再定义一个变量用来保存纳税金额，初始值为0
        double dockwages = 0;
//再定义一个变量保存税后工资,初始值为0；
        double afterTaxWages = 0;
//使用if语句判断输入的工资是否大于零，提升程序的健壮性
            //使用f语句判断扣除五险一金后工资是否达到纳税标准
            if (money > 5000) {
                //使用if...else if ...else 分支嵌套语句判断纳税的梯度，并计算纳税额度以及税后工资然后输出
                if (money1 > 0 && money1 <= 3000) {
                    dockwages = money1 * 0.03;
                    afterTaxWages = money - dockwages;
                    //输出结果
                    System.out.println("您输入的税前工资为：" + wages);
                    System.out.println("您的五险一金额度为：" + insurance);
                    System.out.println("您的纳税金额为：" + dockwages);
                    System.out.println("您的税后工资为：" + afterTaxWages);
                } else if (money1 > 3000 && money1 <= 12000) {
                    dockwages = (money1 - 3000) * 0.1 + 3000 * 0.03;
                    afterTaxWages = money - dockwages;
                    //输出结果
                    System.out.println("您输入的税前工资为：" + wages);
                    System.out.println("您的五险一金额度为：" + insurance);
                    System.out.println("您的纳税金额为：" + dockwages);
                    System.out.println("您的税后工资为：" + afterTaxWages);
                } else if (money1 > 12000 && money1 <= 25000) {
                    dockwages = (money1 - 12000) * 0.2 + 3000 * 0.03 + 9000 * 0.1;
                    afterTaxWages = money - dockwages;
                    //输出结果
                    System.out.println("您输入的税前工资为：" + wages);
                    System.out.println("您的五险一金额度为：" + insurance);
                    System.out.println("您的纳税金额为：" + dockwages);
                    System.out.println("您的税后工资为：" + afterTaxWages);
                } else if (money1 > 25000 && money1 <= 35000) {
                    dockwages = (money1 - 25000) * 0.25 + 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2;
                    afterTaxWages = money - dockwages;
                    //输出结果
                    System.out.println("您输入的税前工资为：" + wages);
                    System.out.println("您的五险一金额度为：" + insurance);
                    System.out.println("您的纳税金额为：" + dockwages);
                    System.out.println("您的税后工资为：" + afterTaxWages);
                } else if (money1 > 35000 && money1 <= 55000) {
                    dockwages = (money1 - 35000) * 0.3 + 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + 10000 * 0.25;
                    afterTaxWages = money - dockwages;
                    //输出结果
                    System.out.println("您输入的税前工资为：" + wages);
                    System.out.println("您的五险一金额度为：" + insurance);
                    System.out.println("您的纳税金额为：" + dockwages);
                    System.out.println("您的税后工资为：" + afterTaxWages);
                } else if (money1 > 55000 && money1 <= 80000) {
                    dockwages = (money1 - 55000) * 0.35 + 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + 10000 * 0.25 + 20000 * 0.3;
                    afterTaxWages = money - dockwages;
                    //输出结果
                    System.out.println("您输入的税前工资为：" + wages);
                    System.out.println("您的五险一金额度为：" + insurance);
                    System.out.println("您的纳税金额为：" + dockwages);
                    System.out.println("您的税后工资为：" + afterTaxWages);
                } else {
                    dockwages = (money1 - 80000) * 0.45 + 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + 10000 * 0.25 + 20000 * 0.3 + 25000 * 0.35;
                    afterTaxWages = money - dockwages;
                    //输出结果
                    System.out.println("您输入的税前工资为：" + wages);
                    System.out.println("您的五险一金额度为：" + insurance);
                    System.out.println("您的纳税金额为：" + dockwages);
                    System.out.println("您的税后工资为：" + afterTaxWages);
                }

                map.put("sx",wages);
                map.put("wx",insurance);
                map.put("ns",dockwages);
                map.put("sh",afterTaxWages);

            } else {
                //给出提示信息
                System.out.println("您的工资扣除五险一金后不足五千，不用缴纳个税！您的税前工资是：" + wages + "元，您的五险一金额度是：" + insurance + "元，您的到手工资应为：" + money + "元。");
                map.put("sx",wages);
                map.put("wx",insurance);
                map.put("ns",0);
                map.put("sh",money);
            }
        return map;
    }

}
