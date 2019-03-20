package com.pan.panspringboot.service.impl;

import com.pan.panspringboot.common.aspect.SystemServiceLog;
import com.pan.panspringboot.common.exception.GeneralException;
import com.pan.panspringboot.common.result.ResultEnum;
import com.pan.panspringboot.domain.DiUser;
import com.pan.panspringboot.resposity.DiUserMapper;
import com.pan.panspringboot.service.BaseService;
import com.pan.panspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DiUserMapper diUserMapper;

    @SystemServiceLog(description = "service添加用户")
    @Override
    public void add(DiUser object) {
        try {
            diUserMapper.insert(object);
            throw new NullPointerException();//测试事务
        } catch (Exception e) {
           throw new GeneralException("user add exception",e, ResultEnum.OPERATION_FAILED);
        }

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(DiUser object) {

    }

    @Override
    public void selectById(Integer id) {

    }

    @Override
    public List<DiUser> list() {
        return null;
    }
}
