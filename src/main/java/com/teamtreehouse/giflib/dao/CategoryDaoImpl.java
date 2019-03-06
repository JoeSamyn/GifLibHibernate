package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Category;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> findAll() {
        //Open a session
        Session session = sessionFactory.openSession();

        // Get all categories with Hibernate criteria.
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> criteriaQuery = builder.createQuery(Category.class);
        criteriaQuery.from(Category.class);
        List<Category> categories = session.createQuery(criteriaQuery).getResultList();

        //Close hibernate session
        session.close();

        return categories;
    }

    @Override
    public Category findById(Long id) {
        Session session = sessionFactory.openSession();
        Category category = session.get(Category.class, id);
        // Makes sure gifs collection is initialized before the session is closed.
        Hibernate.initialize(category.getGifs());
        session.close();
        return category;
    }

    @Override
    public void saveCategory(Category category) {
        // open session
        Session session = sessionFactory.openSession();

        // begin transaction
        Transaction tx = session.beginTransaction();
        // save category
        session.saveOrUpdate(category);

        //commit transaction
        session.getTransaction().commit();

        // close session
        session.close();

    }

    @Override
    public void deleteCategory(Category category) {

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        session.delete(category);

        tx.commit();

        session.close();

    }
}
