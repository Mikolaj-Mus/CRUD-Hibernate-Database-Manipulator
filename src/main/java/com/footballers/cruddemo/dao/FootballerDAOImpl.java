package com.footballers.cruddemo.dao;

import com.footballers.cruddemo.entity.Footballer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FootballerDAOImpl implements FootballerDAO {

    private EntityManager entityManager;

    @Autowired
    public FootballerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Footballer footballer) {
        entityManager.persist(footballer);
    }

    @Override
    public Footballer findById(int id) {
        return entityManager.find(Footballer.class, id);
    }

    @Override
    public List<Footballer> findAll() {
        TypedQuery<Footballer> query = entityManager.createQuery("FROM Footballer", Footballer.class);
        return query.getResultList();
    }
}
