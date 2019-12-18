package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.PerEc;

import java.util.List;

public interface PersonMapper {

    int addPerson(@Param("perec") PerEc perec);

    List<PerEc> getAllPersons();

    int updatePerson(@Param("perEc") PerEc perEc);

    int deletePerson(@Param("ids") String[] ids);

//    int deletePersonByEid(@Param("eid") Long eid);
//
//    int addSidAndEid(@Param("sid") Integer sid, @Param("eid") Long eid);
}
