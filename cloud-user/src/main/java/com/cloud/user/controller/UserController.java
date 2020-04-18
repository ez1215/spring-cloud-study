package com.cloud.user.controller;

import com.cloud.common.controller.BaseController;
import com.cloud.common.exception.BusinessException;
import com.cloud.common.model.ReturnData;
import com.cloud.common.vo.UserVo;
import com.cloud.user.entity.User;
import com.cloud.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping("/deduct")
    public ReturnData deduct(@RequestBody UserVo userVo) {
        log.info("扣减用户余额:{}", userVo.toString());
        try {
            int result = userService.updateBalance(userVo);
            if (result > 0)
                return initSuccessResult();
            return initErrorResult();
        } catch (BusinessException e) {
            log.error(e.getMessage(), e);
            return initErrorObjectResult(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return initErrorResult();
        }
    }

    @RequestMapping("/users")
    public ReturnData<User> userList() {
        return initSuccessListResult(userService.getUsers());
    }

    @RequestMapping("/user/id/{id}")
    public ReturnData<User> userList(@PathVariable("id") Integer id) {
        return initSuccessObjectResult(userService.getById(id));
    }

    @RequestMapping("/user/name/{name}")
    public ReturnData<User> userList(@PathVariable("name") String name) {
        return initSuccessObjectResult(userService.getByName(name));
    }
}
