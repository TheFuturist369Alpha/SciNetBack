package com.jalvis.SciNet.repos.crud.interfaces.custom;

import com.jalvis.SciNet.entities.Subject;

import java.util.List;

public interface SubjectCustomRepo {
    public Subject getSubjectById(Long id);
    public List<Subject> getSubjects();
    public void addSubject(Subject subject);
    public void updateSubject( Subject subject);
    public void deleteSubject(Long id);
}
