package com.com.liuxun.controller;

import com.liuxun.model.user.UserVo;
import com.liuxun.util.helper.JwtHelper;
import com.liuxun.util.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxun
 * @create 2023-08-08 12:52
 * @description
 */
@RestController
@RequestMapping("/rbda")
public class LoginController {
    @PostMapping("/login")
    Result Login(UserVo userVo){
        String token=JwtHelper.createToken(userVo);
        return Result.ok(token);
    }
}
