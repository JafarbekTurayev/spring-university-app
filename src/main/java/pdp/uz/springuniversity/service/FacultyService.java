package pdp.uz.springuniversity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.springuniversity.entity.Faculty;
import pdp.uz.springuniversity.entity.University;
import pdp.uz.springuniversity.payload.FacultyReq;
import pdp.uz.springuniversity.payload.Result;
import pdp.uz.springuniversity.repository.FacultyRepository;
import pdp.uz.springuniversity.repository.UniversityRepository;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class FacultyService {
    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    UniversityRepository universityRepository;

    public Result addFaculty(FacultyReq req) {

        Faculty faculty = new Faculty();
        faculty.setName(req.getName());
        faculty.setCode(String.valueOf(req
                .getName() + "-" + UUID.randomUUID()));

        Optional<University> optionalUniversity = universityRepository.findById(req.getUniversityId());
        if (!optionalUniversity.isPresent()) return new Result("Unv not found!", false);
        University university = optionalUniversity.get();
        faculty.setUniversity(university);

        facultyRepository.save(faculty);
        return new Result("Saved!", true);
    }
}
