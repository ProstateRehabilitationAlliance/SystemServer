package com.prostate.base.service.impl;

import com.prostate.base.mapper.read.DistrictsAndCountiesManageReadMapper;
import com.prostate.base.mapper.write.DistrictsAndCountiesManageWriteMapper;
import com.prostate.base.domain.CityDO;
import com.prostate.base.service.DistrictsAndCountiesManagerService;
import com.prostate.common.domain.Tree;
import com.prostate.common.utils.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 10:46 2018/5/14
 */
@Service
public class DistrictsAndCountiesManagerServiceImpl implements DistrictsAndCountiesManagerService {

    @Autowired
    private DistrictsAndCountiesManageWriteMapper districtsAndCountiesManageWriteMapper;


    @Autowired
    private DistrictsAndCountiesManageReadMapper districtsAndCountiesManageReadMapper;
    @Override
    public CityDO get(String id) {
        return districtsAndCountiesManageReadMapper.get(id);
    }

    @Override
    public List<CityDO> list(Map<String, Object> map) {
        return districtsAndCountiesManageReadMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return districtsAndCountiesManageReadMapper.count(map);
    }

    @Override
    public int save(CityDO city) {
        return districtsAndCountiesManageWriteMapper.save(city);
    }

    @Override
    public int update(CityDO city) {
        return districtsAndCountiesManageWriteMapper.update(city);
    }

    @Override
    public int remove(String id) {
        return 0;
    }

    @Override
    public int batchRemove(String[] ids) {
        return 0;
    }

    @Override
    public Tree<CityDO> getTree() {
        List<Tree<CityDO>> trees = new ArrayList<Tree<CityDO>>();
        List<CityDO> cityDOS = districtsAndCountiesManageReadMapper.getTree(new HashMap<String, Object>(16));
        for (CityDO cityDO:cityDOS){
            Tree<CityDO> tree = new Tree<CityDO>();
            tree.setId(cityDO.getId());
            tree.setParentId(cityDO.getParentCityId());
            tree.setText(cityDO.getCityName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", false);
            state.put("selected_arr",false);

            //state.put("mType", "dept");
            tree.setState(state);
            trees.add(tree);



        }
        Tree<CityDO> t = BuildTree.build(trees);
        return t;
    }

    @Override
    public List<CityDO> listByName(String name) {
        return districtsAndCountiesManageReadMapper.listByName(name);
    }
}

