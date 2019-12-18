package org.sang.controller.person;
import org.sang.bean.PerEc;
import org.sang.bean.RespBean;
import org.sang.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/person/ec")
public class PersonEcController {
    @Autowired
    PersonService personService;

//添加数据的id是主键，所以删除一个数据之后再次添加其id值，会从上一个删除的id值上加+1。alter table 表名 AUTO_INCREMENT=n
    @RequestMapping(value = "/rewards", method = RequestMethod.POST)
    public RespBean addPersonCfg(PerEc perEc) {
        if (personService.addPerson(perEc) == 1) {
            return RespBean.ok("添加成功!");
        }

        return RespBean.error("添加失败!");
    }

    @RequestMapping(value = "/rewards", method = RequestMethod.GET)
    public List<PerEc> rewards() {

        return personService.getAllPersons();
    }

    @RequestMapping(value = "/rewards", method = RequestMethod.PUT)
    public RespBean updateSalary(PerEc perEc) {
        if (personService.updateSalary(perEc) == 1) {
            System.out.println("mapper没有错！");
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping(value = "/rewards/{ids}", method = RequestMethod.DELETE)
    public RespBean deleteSalary(@PathVariable String ids) {
        System.out.println("开始删除！");
        if (personService.deleteSalary(ids) == 1) {
            System.out.println("mapper没有错！");
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
