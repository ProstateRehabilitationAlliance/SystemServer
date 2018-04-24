package com.prostate.system.service.impl;


import com.prostate.system.entity.Education;
import com.prostate.system.mapper.EducationMapper;
import com.prostate.system.service.Educationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/23 15:04
 * @Todo:edcation服务的实现类
 */
@Transactional
@Service
public class EducationServiceImpl implements Educationservice {



    @Autowired
    private EducationMapper educationMapper;

    @Override
    public List<Education> selectByName(String educationName) {
        return educationMapper.selectByeducationName(educationName);
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/23 16:02
     * @todo: 新增学历信息
     * @param:   学历对象
     */
    @Override
    public int insertSelective(Education education) {
        int r = educationMapper.insertSelective(education);
        return r;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/23 16:03
     * @todo: 修改学历信息
     * @param:   * @param null
     */
    @Override
    public int updateSelective(Education education) {
        int r = educationMapper.updateByPrimaryKeySelective(education);
        return r;
    }


    /**
     * @Author: bianyakun
     * @Date: 2018/4/23 16:04
     * @todo: 根据id查询学历信息
     * @param:   学历id
     */
    @Override
    public Education selectById(String id) {
        Education education = educationMapper.selectByPrimaryKey(id);
        return education;
    }

    @Override
    public List<Education> selectByParams(Education education) {
        return null;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/23 16:04
     * @todo: 查询所有学历信息
     * @param:   null
     */
    @Override
    public List<Education> selectByParams() {
       List<Education> educations = educationMapper.selectAllEducation();
       return educations;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/23 16:05
     * @todo: 删除学历信息
     * @param:   学历id
     */
    @Override
    public int deleteById(String id) {
        int r = educationMapper.deleteByPrimaryKey(id);
        return r;
    }
}
