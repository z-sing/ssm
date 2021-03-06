package com.xust.controller;

import com.xust.common.api.CommonResult;
import com.xust.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "UmsMemberController")
@RequestMapping("/sso")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("获取验证码")
    @ResponseBody
    @RequestMapping(value = "/getAuthCode",method = RequestMethod.GET)
    public CommonResult getAuthCode(@RequestParam String telephone){
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("验证码校验")
    @ResponseBody
    @RequestMapping(value = "/verifyAuthCode",method =RequestMethod.POST )
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode){
        return memberService.verifyAuthCode(telephone,authCode);
    }
}
