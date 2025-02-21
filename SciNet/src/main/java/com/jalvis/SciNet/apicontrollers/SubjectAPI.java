package com.jalvis.SciNet.apicontrollers;

import com.jalvis.SciNet.entities.Book;
import com.jalvis.SciNet.entities.Subject;
import com.jalvis.SciNet.services.interfaces.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/subjectapi")
public class SubjectAPI {
    private SubjectService service;

    SubjectAPI(SubjectService service){
        this.service=service;
    }

    @GetMapping("/getsubjects")
    public List<Subject> subjects(){
        return service.getAllSubjects();
    }



    @GetMapping("/getsubjectbyid")
    public Subject subject(@RequestParam Long id){
        return service.getSubjectById(id);
    }
    @PostMapping("/createsubject")
    public void createSubject(@RequestBody Subject subject){
        service.addSubject(subject);
    }
    @PutMapping("/updatesubject")
    public void updateSubject(@RequestBody Subject subject){
        service.updateSubject(subject);
    }
    @DeleteMapping("/deletesubject")
    public void deleteSubject( @RequestParam Long id){
        service.deleteSubject(id);
    }


}
