package com.jalvis.SciNet.daocrud.interfaces;

import com.jalvis.SciNet.entities.Subject;

import java.util.List;

public interface SubjectDAO {
    public Subject getSubjectById(Long id);
    public List<Subject> getSubjects();
    public void addSubject(Subject subject);
    public void updateSubject( Subject subject);
    public void deleteSubject(Long id);
}
