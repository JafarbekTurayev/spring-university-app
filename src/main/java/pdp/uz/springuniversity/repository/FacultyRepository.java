package pdp.uz.springuniversity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.springuniversity.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

}
