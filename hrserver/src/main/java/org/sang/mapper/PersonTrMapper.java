package org.sang.mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.PerTr;

import java.util.List;

public interface PersonTrMapper {

    int addPersonTr(@Param("pertr") PerTr pertr);


    List<PerTr> getAllPersonsTr();

    int updatePersonTr(@Param("perTr") PerTr perTr);

    int deletePersonTr(@Param("ids") String[] ids);
}
