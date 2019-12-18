package org.sang.controller.person;

import org.sang.bean.PerTr;
import org.sang.bean.RespBean;
import org.sang.service.PersonTrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/person/tr")
public class PersonTrController {
    @Autowired
    PersonTrService personTrService;
    @RequestMapping(value = "/train", method = RequestMethod.POST)
    public RespBean addPersonCfgTr(PerTr perTr) {
        System.out.println("执行的添加！");
        if (personTrService.addPersonTr(perTr) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @RequestMapping(value = "/train", method = RequestMethod.GET)
    public List<PerTr> train() {
        System.out.println("执行的查询！");
        System.out.println(personTrService.getAllPersonsTr());
        return personTrService.getAllPersonsTr();
    }

    @RequestMapping(value = "/train", method = RequestMethod.PUT)
    public RespBean updatePersonsTr(PerTr perTr) {
        System.out.println("执行的更新！");
        if (personTrService.updatePersonsTr(perTr) == 1) {
            System.out.println("mapper没有错！");
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping(value = "/train/{ids}", method = RequestMethod.DELETE)
    public RespBean deletePersonsTr(@PathVariable String ids) {
        System.out.println("执行的删除！");
        if (personTrService.deletePersonsTr(ids) == 1) {
            System.out.println("mapper没有错！");
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
