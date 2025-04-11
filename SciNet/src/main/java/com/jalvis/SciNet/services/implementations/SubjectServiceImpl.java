package com.jalvis.SciNet.services.implementations;

import com.jalvis.SciNet.repos.crud.implementations.SubjectRepoImpl;
import com.jalvis.SciNet.entities.Subject;
import com.jalvis.SciNet.services.interfaces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepoImpl dao;


    @Override
    public Subject getSubjectById(Long id) {
        return dao.getSubjectById(id);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return dao.getSubjects();
    }

    @Override
    public void addSubject(Subject subject) {
            dao.addSubject(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
     dao.updateSubject(subject);
    }

    @Override
    public void deleteSubject(Long id) {
     dao.deleteSubject(id);
    }
}
