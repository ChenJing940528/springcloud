package com.chenjing.springcloud.apporder.feignclient;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description：UserControllerFeignClientFallback
 *
 * @author：chenjing
 * @version:1.0
 */
@Component
public class UserControllerFeignClientFallback implements UserControllerFeignClient {
    @Override
    public String findById(@RequestParam("UserId") String userId) {
        return "fallback";
    }
}
