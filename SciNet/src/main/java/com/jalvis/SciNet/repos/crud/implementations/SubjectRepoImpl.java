package com.jalvis.SciNet.repos.crud.implementations;

import com.jalvis.SciNet.repos.crud.interfaces.custom.SubjectCustomRepo;
import com.jalvis.SciNet.entities.Subject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectRepoImpl implements SubjectCustomRepo {

    private EntityManager manager;

    @Autowired
    public SubjectRepoImpl(EntityManager manager){
        this.manager=manager;
    }

    @Override
    @Transactional
    public Subject getSubjectById(Long id) {
        return manager.find(Subject.class,id);
    }

    @Override
    public List<Subject> getSubjects() {
        TypedQuery<Subject> query=manager.createQuery("FROM Subject", Subject.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void addSubject(Subject subject) {
    manager.persist(subject);
    }

    @Override
    @Transactional
    public void updateSubject(Subject subject) {
    manager.merge(subject);
    }

    @Override
    @Transactional
    public void deleteSubject(Long id) {
        Subject subject=manager.find(Subject.class, id);
        manager.remove(subject);
    }
}
