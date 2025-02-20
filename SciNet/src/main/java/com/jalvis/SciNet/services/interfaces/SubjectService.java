package com.jalvis.SciNet.services.interfaces;

import com.jalvis.SciNet.entities.Subject;

import java.util.List;

public interface SubjectService {
    public Subject getSubjectById(Long id);
    public List<Subject> getAllSubjects();
    public void addSubject(Subject subject);
    public void updateSubject(Subject subject);
    public void deleteSubject(Long id);
}
