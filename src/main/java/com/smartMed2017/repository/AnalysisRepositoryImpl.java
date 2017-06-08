package com.smartMed2017.repository;

import com.smartMed2017.model.Analysis;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vladyour on 05.06.17.
 */
@Repository
public class AnalysisRepositoryImpl implements AnalysisRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAnalysis(Analysis analysis) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(analysis);
    }

    public Analysis getAnalysisById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Analysis analysis = (Analysis) session.get(Analysis.class, new Integer(id));

        return analysis;
    }

    @SuppressWarnings("unchecked")
    public List<Analysis> getAllAnalysis() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Analysis> analysisList = session.createQuery("from Analysis").list();

        return analysisList;
    }
}
