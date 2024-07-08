package com.learnmonilithic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
//    private final RedisTemplate<Object, Object> redisTemplate;
//    @GetMapping("/redis")
//    public ResponseEntity<String> testRedis() {
//        redisTemplate.opsForValue().set("key", "value");
//        String result = "Value of key: " + redisTemplate.opsForValue().get("key");
//        return ResponseEntity.ok(result);
//    }
}
