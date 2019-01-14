package com.chenjing.springcloud.apporder.controller;

import com.chenjing.springcloud.apporder.feignclient.UserControllerFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description：OrderController
 *
 * @author：chenjing
 * @version:1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController implements EnvironmentAware{

    private static Map ORDER_MAP = new ConcurrentHashMap();

    private static Environment environment;

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserControllerFeignClient userControllerFeignClient;

    @RequestMapping("/add")
//    @HystrixCommand(fallbackMethod = "addFallback")
    public Object add(String userId, String orderId, String orderName){
//1、用Rest+Ribbon的方法
//        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
//        requestEntity.add("userId", userId);

//通过ip地址调用
//        String userName = restTemplate.postForObject(
//                "http://localhost:9091/user/findById", requestEntity, String.class);

//通过服务名调用
//        String userName = restTemplate.postForObject(
//                "http://APP-USER/user/findById", requestEntity, String.class);

//2、用Feign的方法
        String userName = userControllerFeignClient.findById(userId);
        orderName = userName + "'s" + orderName;

        ORDER_MAP.put(orderId, orderName);

        System.out.println(OrderController.environment.getProperty("spring.application.name"));

        return orderId + " " + orderName + " " + UUID.randomUUID().toString();
    }
    public Object addFallback(String userId, String orderId, String orderName){
        return "888";
    }

    @Override
    public void setEnvironment(Environment environment) {
        OrderController.environment = environment;
    }
}
