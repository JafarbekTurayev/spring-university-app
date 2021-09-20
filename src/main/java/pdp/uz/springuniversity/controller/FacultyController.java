package pdp.uz.springuniversity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.springuniversity.entity.Faculty;
import pdp.uz.springuniversity.entity.University;
import pdp.uz.springuniversity.payload.FacultyReq;
import pdp.uz.springuniversity.payload.Result;
import pdp.uz.springuniversity.payload.UniversityReq;
import pdp.uz.springuniversity.repository.FacultyRepository;
import pdp.uz.springuniversity.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;
    @Autowired
    FacultyRepository facultyRepository;
    @PostMapping("/add")
    public Result addFaculty(@RequestBody FacultyReq req) {
        return facultyService.addFaculty(req);
    }

    @GetMapping("/list")
    public List<Faculty> getFaculty(){
        List<Faculty> all = facultyRepository.findAll();
        return all;
    }
    @GetMapping("/one/{id}")
    public Result getById(@PathVariable int id){
        return facultyService.getOne(id);
    }

}
