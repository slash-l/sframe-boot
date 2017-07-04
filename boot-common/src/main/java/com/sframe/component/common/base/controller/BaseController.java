package com.sframe.component.common.base.controller;

import com.sframe.component.common.base.service.ResponseService;
import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mumu
 * @vervion v1.0
 * @description base controller
 * @date 2017/7/4 2017, 下午11:50
 */
@Data
@RestController
public class BaseController {

    @Resource
    private ResponseService responseService;
}
