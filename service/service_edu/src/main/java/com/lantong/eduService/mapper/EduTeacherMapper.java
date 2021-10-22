package com.lantong.eduService.mapper;

import com.lantong.eduService.entity.EduTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author wangshipeng
 * @since 2021-08-13
 */
public interface EduTeacherMapper extends BaseMapper<EduTeacher> {
    public List<EduTeacher> findAll();

    public List<EduTeacher> findAllByPage(@Param(value = "current") long current,@Param(value = "limit") long limit);


}
