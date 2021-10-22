package com.lantong.eduService.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lantong.eduService.entity.EduTeacher;
import com.lantong.eduService.entity.vo.TeacherQuery;
import com.lantong.eduService.service.EduTeacherService;
import com.lantong.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author wangshipeng
 * @since 2021-08-13
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduService/teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("findAll")
    @ApiOperation("查询所有讲师")
    public Result findAll(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return Result.ok().data("items", list);
    }


    @GetMapping("findAllByPage/{current}/{limit}")
    @ApiOperation("分页查询讲师列表")
    public Result findAllByPage(@ApiParam(name = "current",value = "起始页",required = true)
                                @PathVariable long current
                                ,@ApiParam(name = "limit",value = "每页条数",required = true)
                                 @PathVariable long limit
                                )
    {
        Page<EduTeacher> page = new Page<>(current,limit);
        eduTeacherService.page(page, null);
        return  Result.ok().data("items",page);
    }

    @PostMapping("findByExampleAndPage/{current}/{limit}")
    @ApiOperation("根据条件查询讲师并分页")
    public Result addTeacher(@RequestBody TeacherQuery teacherQuery,
                             @ApiParam(name = "current",value = "起始页",required = true) @PathVariable long current,
                             @ApiParam(name = "limit",value = "每页条数",required = true) @PathVariable long limit
    ){
        Page<EduTeacher> page  = new Page<>(current,limit);
        QueryWrapper<EduTeacher> wrapper =new QueryWrapper<>();
        if(!StringUtils.isEmpty(teacherQuery.getName())){
            wrapper.like("name", teacherQuery.getName());
        } if(!StringUtils.isEmpty(teacherQuery.getLevel())){
            wrapper.eq("level", teacherQuery.getLevel());
        } if(!StringUtils.isEmpty(teacherQuery.getBegin())){
            wrapper.ge("gmt_create", teacherQuery.getBegin());
        } if(!StringUtils.isEmpty(teacherQuery.getEnd())){
            wrapper.le("gmt_modified", teacherQuery.getEnd());
        }
        eduTeacherService.page(page,wrapper );
        return  Result.ok().data("items", page);
    }

    @PostMapping("addTeacher")
    @ApiOperation("新增讲师")
    public Result addTeacher(@RequestBody EduTeacher eduTeacher){
        return eduTeacherService.save(eduTeacher)?Result.ok():Result.error();
    }


    @GetMapping("findTeacherById/{id}")
    @ApiOperation("根据id查询讲师")
    public Result findTeacherById(@ApiParam(name="id",value = "讲师ID",required = true) @PathVariable String id){
        EduTeacher teacher = eduTeacherService.getById(id);
        return Result.ok().data("items",teacher);

    }

    @PostMapping("updateTeacher")
    @ApiOperation("修改讲师信息")
    public Result updateTeacher(@RequestBody EduTeacher eduTeacher){
        return eduTeacherService.updateById(eduTeacher)?Result.ok():Result.error();
    }


    @DeleteMapping("{id}")
    @ApiOperation("根据讲师id逻辑删除讲师")
    public Result deleteById(@ApiParam(name = "id",value = "讲师ID",required = true) @PathVariable String id){
        boolean flag = eduTeacherService.removeById(id);
        return flag?Result.ok():Result.error();
    }


}

