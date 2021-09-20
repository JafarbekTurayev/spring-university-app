package pdp.uz.springuniversity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pdp.uz.springuniversity.entity.Subject;
import pdp.uz.springuniversity.payload.Result;
import pdp.uz.springuniversity.repository.SubjectRepository;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;

    @PostMapping("/add")
    public Result addSubject(@RequestBody Subject subject) {
        subjectRepository.save(subject);
        return new Result("Saved!", true);
    }

}
