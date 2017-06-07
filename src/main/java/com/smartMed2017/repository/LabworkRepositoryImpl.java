package com.smartMed2017.repository;

import com.smartMed2017.model.Labwork;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vladyour on 05.06.17.
 */
@Repository
public class LabworkRepositoryImpl implements LabworkRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addLabwork(Labwork labwork) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(labwork);
    }

    public Labwork getLabworkById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Labwork labwork = (Labwork) session.load(Labwork.class, new Integer(id));

        return labwork;
    }

    @SuppressWarnings("unchecked")
    public List<Labwork> getAllLabwork() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Labwork> labworkList = session.createQuery("from Labwork").list();

        return labworkList;
    }
}
