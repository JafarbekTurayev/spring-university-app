package pdp.uz.springuniversity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.springuniversity.entity.Faculty;
import pdp.uz.springuniversity.entity.Group;
import pdp.uz.springuniversity.entity.University;
import pdp.uz.springuniversity.payload.FacultyReq;
import pdp.uz.springuniversity.payload.GroupReq;
import pdp.uz.springuniversity.payload.Result;
import pdp.uz.springuniversity.repository.FacultyRepository;
import pdp.uz.springuniversity.repository.GroupRepository;
import pdp.uz.springuniversity.repository.UniversityRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class GroupService {
    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    GroupRepository groupRepository;

    public Result addGroup(GroupReq req) {
        Group group = new Group();
        group.setName(req.getName());
        Optional<Faculty> facultyOptional = facultyRepository.findById(req.getFacultyId());
        if (!facultyOptional.isPresent()) return new Result("not found!", false);
        group.setFaculty(facultyOptional.get());
        groupRepository.save(group);
        return new Result("Saved!", true);
    }


}
