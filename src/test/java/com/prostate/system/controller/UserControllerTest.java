package com.prostate.system.controller;

import com.prostate.system.SystemApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @Author: bianyakun
 * @Date: 2018/4/19 15:08
 * @Todo:  UserController 的测试类
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SystemApplication.class})
@WebAppConfiguration//启动tomcat,webApplicationcontext容器对象
public class UserControllerTest {

    @Autowired
    private  UseController useController;

    //发送MVC请求，获取响应结果
    MockMvc mockMvc = null;

    @Before//每次执行@Test方法前都会调用init方法
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(useController).build();
    }

    @Test
    public  void regist1()throws Exception{
        //发送一个post请求
        MockHttpServletRequestBuilder postRequest =
                MockMvcRequestBuilders.post("/user/regist")
                        .param("username", "bian")
                        .param("password", "123456")
                        .param("email", "123456@qq.com")
                        .param("sex", "man")
                        .param("phone","19999999999");
        //执行请求
        MvcResult result = mockMvc.perform(postRequest).andReturn();
        //获取返回结果内容
        String body = result.getResponse().getContentAsString();
        System.out.println(body);
    }
}
