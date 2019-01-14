package com.chenjing.springcloud.apporder.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description：UserControllerFeignClient
 *
 * @author：chenjing
 * @version:1.0
 */
@FeignClient(name = "app-user",fallback = UserControllerFeignClientFallback.class)
public interface UserControllerFeignClient {
    @RequestMapping("/user/findById")
    String findById(@RequestParam("userId") String userId);
}
