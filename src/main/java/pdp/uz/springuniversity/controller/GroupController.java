package pdp.uz.springuniversity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pdp.uz.springuniversity.entity.Faculty;
import pdp.uz.springuniversity.entity.Group;
import pdp.uz.springuniversity.payload.Result;
import pdp.uz.springuniversity.repository.GroupRepository;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @PostMapping("/add")
    public Result addGroup(@RequestBody Group group) {
        groupRepository.save(group);
        return new Result("Saved!", true);
    }

}
