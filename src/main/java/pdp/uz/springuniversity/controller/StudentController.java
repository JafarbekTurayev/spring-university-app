package pdp.uz.springuniversity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pdp.uz.springuniversity.entity.Student;
import pdp.uz.springuniversity.entity.Subject;
import pdp.uz.springuniversity.payload.Result;
import pdp.uz.springuniversity.payload.StudentSubjectReq;
import pdp.uz.springuniversity.repository.StudentRepository;
import pdp.uz.springuniversity.repository.SubjectRepository;
import pdp.uz.springuniversity.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public Result addStudent(@RequestBody Student student) {
        studentRepository.save(student);//shu jarayonda serial
        return new Result("Saved!", true);
    }

    @PostMapping("/selectSubject")
    public Result selectSub(@RequestBody StudentSubjectReq req) {
        return studentService.selectSubjects(req);
    }

}
