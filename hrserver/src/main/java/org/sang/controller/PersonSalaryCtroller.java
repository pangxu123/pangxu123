package org.sang.controller;

import org.sang.bean.PerSalary;
import org.sang.bean.RespBean;
import org.sang.service.PersonSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/person/salary")
public class PersonSalaryCtroller {
    @Autowired
    PersonSalaryService personSalaryService;
    @RequestMapping(value = "/salaries", method = RequestMethod.POST)
    public RespBean addPersonCfgSalary(PerSalary perSalary) {
        System.out.println("执行的添加！");
        if (personSalaryService.addPersonSalary(perSalary) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @RequestMapping(value = "/salaries", method = RequestMethod.GET)
    public List<PerSalary> train() {
        System.out.println("执行的查询！");
        System.out.println(personSalaryService.getAllPersonsSalary());
        return personSalaryService.getAllPersonsSalary();
    }

    @RequestMapping(value = "/salaries", method = RequestMethod.PUT)
    public RespBean updateSalarySalary(PerSalary perSalary) {
        System.out.println("执行的更新！");
        if (personSalaryService.updatePersonsSalary(perSalary) == 1) {
            System.out.println("mapper没有错！");
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping(value = "/salaries/{ids}", method = RequestMethod.DELETE)
    public RespBean deleteSalarySalary(@PathVariable String ids) {
        System.out.println("执行的删除！");
        if (personSalaryService.deletePersonsSalary(ids) == 1) {
            System.out.println("mapper没有错！");
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
