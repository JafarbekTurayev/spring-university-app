package pdp.uz.springuniversity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.springuniversity.entity.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {

}
