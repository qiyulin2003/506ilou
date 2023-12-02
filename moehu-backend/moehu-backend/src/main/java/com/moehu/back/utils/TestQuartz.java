package com.moehu.back.utils;

import com.moehu.back.dao.UserDao_new;
import com.moehu.back.model.salary.*;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestQuartz  extends QuartzJobBean {
    /**
     * 执行定时任务
     * @param jobExecutionContext
     * @throws JobExecutionException
     */

    @Autowired
    UserDao_new userDao;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }
    public Map  cal(float wages){
        Map map = new HashMap();
//接收用户输入的税前工资，这里我定义成整数
//        int wages = maps.get("money");
//接着定义一个变量保存五险一金的额度
        float insurance = (float) (wages * 0.1);
//接着我们定义一个变量保存扣除五险一金后的工资部分
        float money = wages - insurance;
        //还需要定义一个变量来表示超出5000元的部分
        float money1 = money - 5000;
//我们再定义一个变量用来保存纳税金额，初始值为0
        float dockwages = 0;
//再定义一个变量保存税后工资,初始值为0；
        float afterTaxWages = 0;
//使用if语句判断输入的工资是否大于零，提升程序的健壮性
        //使用f语句判断扣除五险一金后工资是否达到纳税标准
        if (money > 5000) {
            //使用if...else if ...else 分支嵌套语句判断纳税的梯度，并计算纳税额度以及税后工资然后输出
            if (money1 > 0 && money1 <= 3000) {
                dockwages = (float) (money1 * 0.03);
                afterTaxWages = money - dockwages;
                //输出结果
                System.out.println("您输入的税前工资为：" + wages);
                System.out.println("您的五险一金额度为：" + insurance);
                System.out.println("您的纳税金额为：" + dockwages);
                System.out.println("您的税后工资为：" + afterTaxWages);
            } else if (money1 > 3000 && money1 <= 12000) {
                dockwages = (float) ((money1 - 3000) * 0.1 + 3000 * 0.03);
                afterTaxWages = money - dockwages;
                //输出结果
                System.out.println("您输入的税前工资为：" + wages);
                System.out.println("您的五险一金额度为：" + insurance);
                System.out.println("您的纳税金额为：" + dockwages);
                System.out.println("您的税后工资为：" + afterTaxWages);
            } else if (money1 > 12000 && money1 <= 25000) {
                dockwages = (float) ((money1 - 12000) * 0.2 + 3000 * 0.03 + 9000 * 0.1);
                afterTaxWages = money - dockwages;
                //输出结果
                System.out.println("您输入的税前工资为：" + wages);
                System.out.println("您的五险一金额度为：" + insurance);
                System.out.println("您的纳税金额为：" + dockwages);
                System.out.println("您的税后工资为：" + afterTaxWages);
            } else if (money1 > 25000 && money1 <= 35000) {
                dockwages = (float) ((money1 - 25000) * 0.25 + 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2);
                afterTaxWages = money - dockwages;
                //输出结果
                System.out.println("您输入的税前工资为：" + wages);
                System.out.println("您的五险一金额度为：" + insurance);
                System.out.println("您的纳税金额为：" + dockwages);
                System.out.println("您的税后工资为：" + afterTaxWages);
            } else if (money1 > 35000 && money1 <= 55000) {
                dockwages = (float) ((money1 - 35000) * 0.3 + 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + 10000 * 0.25);
                afterTaxWages = money - dockwages;
                //输出结果
                System.out.println("您输入的税前工资为：" + wages);
                System.out.println("您的五险一金额度为：" + insurance);
                System.out.println("您的纳税金额为：" + dockwages);
                System.out.println("您的税后工资为：" + afterTaxWages);
            } else if (money1 > 55000 && money1 <= 80000) {
                dockwages = (float) ((money1 - 55000) * 0.35 + 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + 10000 * 0.25 + 20000 * 0.3);
                afterTaxWages = money - dockwages;
                //输出结果
                System.out.println("您输入的税前工资为：" + wages);
                System.out.println("您的五险一金额度为：" + insurance);
                System.out.println("您的纳税金额为：" + dockwages);
                System.out.println("您的税后工资为：" + afterTaxWages);
            } else {
                dockwages = (float) ((money1 - 80000) * 0.45 + 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + 10000 * 0.25 + 20000 * 0.3 + 25000 * 0.35);
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
