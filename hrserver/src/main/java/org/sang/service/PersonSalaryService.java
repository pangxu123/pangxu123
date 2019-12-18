package org.sang.service;

import org.sang.bean.PerSalary;
import org.sang.mapper.PersonSalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonSalaryService {
    @Autowired
    PersonSalaryMapper personSalaryMapper;
    public List<PerSalary> getAllPersonsSalary() {
        return personSalaryMapper.getAllPersonsSalary();
    }

    public int addPersonSalary(PerSalary perSalary) {

        return personSalaryMapper.addPersonSalary(perSalary);
    }

    public int updatePersonsSalary(PerSalary perSalary) {
        System.out.println("数据更新！");
        return personSalaryMapper.updatePersonSalary(perSalary);
    }

    public int deletePersonsSalary(String ids) {
        System.out.println("数据删除！");
        String[] split = ids.split(",");
        return personSalaryMapper.deletePersonSalary(split);
    }
}
