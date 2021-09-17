package pdp.uz.springuniversity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pdp.uz.springuniversity.entity.University;
import pdp.uz.springuniversity.payload.Result;
import pdp.uz.springuniversity.payload.UniversityReq;
import pdp.uz.springuniversity.service.UniversityService;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    UniversityService universityService;


    //    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @PostMapping("/add")
    public Result addUniversity(@RequestBody UniversityReq req) {
        return universityService.addUniver(req);
    }

    //list
    @GetMapping("/list")
    public List<University> getList() {
        return universityService.getAll();
    }

    //university/1
    @GetMapping("/{id}")
    public Result getOne(@PathVariable int id) {
        return universityService.getOneById(id);
    }

    //edit
    @PutMapping("/edit/{id}")
    public Result updateUniver(@PathVariable int id, @RequestBody UniversityReq req) {
        return universityService.edit(id, req);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public Result deleteUniver(@PathVariable int id) {
        return universityService.deleteUniver(id);
    }

}
