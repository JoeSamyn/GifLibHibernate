package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Gif;
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
public class GifDaoImpl implements GifDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Gif> findAll() {
        // Open session
        Session session = sessionFactory.openSession();
        // set criteria
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Gif> cq = builder.createQuery(Gif.class);
        cq.from(Gif.class);
        List<Gif> gifs = session.createQuery(cq).getResultList();
        //close session
        session.close();
        //return gif list
        return gifs;
    }

    @Override
    public Gif findById(Long Id) {

        // Open Session
        Session session = sessionFactory.openSession();
        //Create criteria
        Gif gif = session.get(Gif.class, Id);
        Hibernate.initialize(gif);
        session.close();

        //return proper gif

        return gif;
    }

    @Override
    public void save(Gif gif) {
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(gif);

        tx.commit();

        session.close();
    }

    @Override
    public void deleteGif(Gif gif) {
        //open session
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        session.delete(gif);

        tx.commit();

        session.close();
    }
}
