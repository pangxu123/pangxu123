package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.PerSalary;

import java.util.List;

public interface PersonSalaryMapper {
    int addPersonSalary(@Param("perSalary") PerSalary perSalary);


    List<PerSalary> getAllPersonsSalary();

    int updatePersonSalary(@Param("perSalary") PerSalary perSalary);

    int deletePersonSalary(@Param("ids") String[] ids);
}
