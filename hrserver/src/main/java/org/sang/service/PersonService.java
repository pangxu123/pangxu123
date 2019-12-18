package org.sang.service;


import org.sang.bean.PerEc;
import org.sang.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class PersonService {
    @Autowired
    PersonMapper personMapper;
    public List<PerEc> getAllPersons() {
        return personMapper.getAllPersons();
    }

    public int addPerson(PerEc perEc) {
        System.out.println("添加数据！");
        return personMapper.addPerson(perEc);
    }

    public int updateSalary(PerEc perEc) {
        System.out.println("数据更新！");
        return personMapper.updatePerson(perEc);
    }

    public int deleteSalary(String ids) {
        System.out.println("数据删除！");
        String[] split = ids.split(",");
        return personMapper.deletePerson(split);
    }
}
