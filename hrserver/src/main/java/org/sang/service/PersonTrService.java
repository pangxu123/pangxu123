package org.sang.service;


import org.sang.bean.PerTr;
import org.sang.mapper.PersonTrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonTrService {
    @Autowired
    PersonTrMapper personTrMapper;
    public List<PerTr> getAllPersonsTr() {
        return personTrMapper.getAllPersonsTr();
    }

    public int addPersonTr(PerTr perTr) {

        return personTrMapper.addPersonTr(perTr);
    }

    public int updatePersonsTr(PerTr perTr) {
        System.out.println("数据更新！");
        return personTrMapper.updatePersonTr(perTr);
    }

    public int deletePersonsTr(String ids) {
        System.out.println("数据删除！");
        String[] split = ids.split(",");
        return personTrMapper.deletePersonTr(split);
    }
}
