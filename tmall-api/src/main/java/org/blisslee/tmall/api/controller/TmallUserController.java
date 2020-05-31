package org.blisslee.tmall.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.blisslee.tmall.api.entity.dto.TmallUser.*;
import org.blisslee.tmall.api.entity.model.TmallUser;
import org.blisslee.tmall.api.service.TmallUserService;
import org.blisslee.tmall.common.BeanMapper;
import org.blisslee.tmall.common.JsonResult;
import org.blisslee.tmall.common.Message;
import org.blisslee.tmall.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 3:54 下午
 */
@Api(tags = "user API",value = "TmallUserController")
@RestController
@CrossOrigin
@RequestMapping("/user")
public class TmallUserController {
    private final TmallUserService tmallUserService;

    @Autowired
    public TmallUserController(TmallUserService tmallUserService) {
        this.tmallUserService = tmallUserService;
    }

    @ApiOperation(value = "用户登陆", notes = "用户登陆", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public JsonResult login(@Valid @RequestBody UserLoginInputDTO input) throws Exception {
        JsonResult<UserDTO> jsonResult = new JsonResult<>();

        HashMap<String, Object> params = new HashMap<>();
        params.put("userName",input.getUserName());
        params.put("password",input.getPassword());
        TmallUser user = tmallUserService.login(params);
        if (user == null) {
            throw new BusinessException(new Message("CM.DB.NO_RESULT", "用户"));
        }
        UserDTO userDTO = BeanMapper.map(user,UserDTO.class);
        jsonResult.setData(userDTO);
        jsonResult.setMessage("登陆成功");
        return jsonResult;
    }

    @ApiOperation(value = "用户数据列表获取", notes = "用户数据列表获取", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JsonResult A01(@Valid UserA01InputDTO input) {
        JsonResult<List<TmallUser>> jsonResult = new JsonResult<>();

        HashMap<String, Object> params = new HashMap<>();
        params.put("offset", (input.getPage() - 1) * input.getPageSize());
        params.put("pageSize", input.getPageSize());

        List<TmallUser> tmallUserList = tmallUserService.getAll(params);
        Integer totalCount = tmallUserService.countGetAll(params);

        jsonResult.setPage(input.getPage());
        jsonResult.setPageSize(input.getPageSize());
        jsonResult.setTotalCount(totalCount);
        jsonResult.setData(tmallUserList);
        return jsonResult;
    }


    @ApiOperation(value = "新增用户提交", notes = "新增用户提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JsonResult A02(@Valid @RequestBody UserA02InputDTO input) throws Exception {
        JsonResult<TmallUser> jsonResult = new JsonResult<>();

        TmallUser tmallUser = BeanMapper.map(input, TmallUser.class);
        boolean success = tmallUserService.insert(tmallUser);

        if (!success) {
            throw new BusinessException(new Message("CM.DB.CREATE_CONFLICT", "用户"));
        }
        jsonResult.setMessage(new Message("CM.DB.CREATE_SUCCESS", "用户"));
        return jsonResult;
    }

    @ApiOperation(value = "删除用户", notes = "删除指定ID的用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JsonResult A03(@Valid @RequestBody UserA03InputDTO input) throws BusinessException {
        JsonResult jsonResult = new JsonResult();

        boolean success = tmallUserService.deleteById(input.getId());
        if (!success) {
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "用户"));
        }
        jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "用户"));

        return jsonResult;
    }

    @ApiOperation(value = "用户编辑提交", notes = "用户编辑提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JsonResult A04(@Valid @RequestBody UserA04InputDTO input) throws BusinessException {
        JsonResult jsonResult = new JsonResult();

        TmallUser tmallUser = BeanMapper.map(input, TmallUser.class);
        boolean success = tmallUserService.update(tmallUser);
        if (!success) {
            throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "用户"));
        }
        jsonResult.setMessage(new Message("CM.DB.UPDATE_SUCCESS", "用户"));
        return jsonResult;
    }

    @ApiOperation(value = "用户查询", notes = "用户详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JsonResult A05(@Valid UserA03InputDTO input) throws BusinessException {
        JsonResult<TmallUser> jsonResult = new JsonResult<>();

        TmallUser tmallUser = tmallUserService.queryById(input.getId());
        if (tmallUser == null) {
            throw new BusinessException(new Message("CM.DB.NO_RESULT", "用户"));
        }
        jsonResult.setData(tmallUser);
        return jsonResult;
    }
}
