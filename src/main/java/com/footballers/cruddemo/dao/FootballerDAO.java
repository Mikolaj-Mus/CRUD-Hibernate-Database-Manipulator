package com.footballers.cruddemo.dao;

import com.footballers.cruddemo.entity.Footballer;

import java.util.List;


public interface FootballerDAO {

    void save(Footballer footballer);
    Footballer findById(int id);
    List<Footballer> findAll();
    List<Footballer> findByLastName(String lastName);
    void update(Footballer footballer);
    void delete(int id);
    int deleteAll();
}
