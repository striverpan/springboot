package com.pan.panspringboot.resposity;

import com.pan.panspringboot.domain.DiUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DiUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DiUser record);

    int insertSelective(DiUser record);

    DiUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DiUser record);

    int updateByPrimaryKey(DiUser record);
}