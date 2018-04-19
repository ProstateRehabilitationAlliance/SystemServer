package com.prostate.doctor.mapper;

import java.util.List;

public interface BaseMapper<E>{

    int insertSelective(E e);

    int updateSelective(E e);

    E selectById(String id);

    List<E> selectByParams(E e);

    int deleteById(String id);
}