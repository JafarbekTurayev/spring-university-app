package pdp.uz.springuniversity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.springuniversity.entity.Address;
import pdp.uz.springuniversity.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
