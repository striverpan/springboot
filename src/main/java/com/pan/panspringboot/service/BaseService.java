package com.pan.panspringboot.service;

import java.util.List;

public interface BaseService<T> {

     void add(T object);
     void delete(Integer id);
     void update(T object);
     void selectById(Integer id);
     List<T> list();
}
