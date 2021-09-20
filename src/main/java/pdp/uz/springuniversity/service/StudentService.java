package pdp.uz.springuniversity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.springuniversity.entity.Student;
import pdp.uz.springuniversity.entity.Subject;
import pdp.uz.springuniversity.payload.Result;
import pdp.uz.springuniversity.payload.StudentSubjectReq;
import pdp.uz.springuniversity.repository.StudentRepository;
import pdp.uz.springuniversity.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    //field
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;

    public Result selectSubjects(StudentSubjectReq req) {
        Optional<Student> optionalStudent = studentRepository.findById(req.getStudentId());
        if (!optionalStudent.isPresent()) return new Result("Xato", false);
        List<Subject> list = subjectRepository.findAllById(req.getSubjectIds());

        Student student = optionalStudent.get();

        student.setSubjectList(list);
        studentRepository.save(student);
        return new Result("Success", true, student);

    }

}
