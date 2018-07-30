package com.prostate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.prostate.*.mapper")
@SpringBootApplication
@EnableCaching
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
        

        System.out.println(    "                   _ooOoo_"+"\n"+
                "                  o8888888o"+"\n"+
                "                  88\" . \"88"+"\n"+
                "                  (| -_- |)"+"\n"+
                "                  O\\  =  /O"+"\n"+
                "               ____/`---'\\____"+"\n"+
                "             .'  \\\\|     |//  `."+"\n"+
                "            /  \\\\|||  :  |||//  \\"+"\n"+
                "           /  _||||| -:- |||||-  \\"+"\n"+
                "           |   | \\\\\\  -  /// |   |"+"\n"+
                "           | \\_|  ''\\---/''  |   |"+"\n"+
                "           \\  .-\\__  `-`  ___/-. /"+"\n"+
                "         ___`. .'  /--.--\\  `. . __"+"\n"+
                "      .\"\" '<  `.___\\_<|>_/___.'  >'\"\"."+"\n"+
                "     | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |"+"\n"+
                "     \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /"+"\n"+
                "======`-.____`-.___\\_____/___.-`____.-'======"+"\n"+
                "                   `=---='"+"\n"+
                "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+"\n"+
                "         佛祖保佑       永无BUG");
    }
}
