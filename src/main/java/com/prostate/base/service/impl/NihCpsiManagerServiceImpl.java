package com.prostate.base.service.impl;

import com.prostate.base.dao.NihCpsiDao;
import com.prostate.base.dao.NihCpsiManagerDao;
import com.prostate.base.domain.NihCpsiDO;
import com.prostate.base.service.NihCpsiManagerService;
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
 * @Date: Created in 11:59 2018/5/21
 */
@Service
public class NihCpsiManagerServiceImpl implements NihCpsiManagerService {
    @Autowired
    private NihCpsiManagerDao nihCpsiManagerDao;
    @Override
    public NihCpsiDO get(String id) {
        return nihCpsiManagerDao.get(id);
    }

    @Override
    public List<NihCpsiDO> list(Map<String, Object> map) {
        return nihCpsiManagerDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return nihCpsiManagerDao.count(map);
    }

    @Override
    public int save(NihCpsiDO scaleDO) {
        return nihCpsiManagerDao.save(scaleDO);
    }

    @Override
    public int update(NihCpsiDO scaleDO) {
        return nihCpsiManagerDao.update(scaleDO);
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
    public Tree<NihCpsiDO> getTree() {
        List<Tree<NihCpsiDO>> trees = new ArrayList<Tree<NihCpsiDO>>();
        List<NihCpsiDO> nihCpsiDOS = nihCpsiManagerDao.getTree(new HashMap<String, Object>(16));
        for (NihCpsiDO nihCpsiDO:nihCpsiDOS){
            Tree<NihCpsiDO> tree = new Tree<NihCpsiDO>();
            tree.setId(nihCpsiDO.getId());
            tree.setParentId(nihCpsiDO.getParentId());
            tree.setText(nihCpsiDO.getNihCpsiTitle());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", false);
            state.put("selected_arr",false);

            //state.put("mType", "dept");
            tree.setState(state);
            trees.add(tree);



        }
        System.out.println("========>"+trees);
        Tree<NihCpsiDO> t = BuildTree.build(trees);
        return t;
    }

    @Override
    public List<NihCpsiDO> listByName(String name) {
        return nihCpsiManagerDao.listByName(name);
    }
}