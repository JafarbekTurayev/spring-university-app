package pdp.uz.springuniversity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.springuniversity.entity.University;
import pdp.uz.springuniversity.payload.FacultyReq;
import pdp.uz.springuniversity.payload.Result;
import pdp.uz.springuniversity.payload.UniversityReq;
import pdp.uz.springuniversity.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @PostMapping("/add")
    public Result addFaculty(@RequestBody FacultyReq req) {
        return facultyService.addFaculty(req);
    }

}
