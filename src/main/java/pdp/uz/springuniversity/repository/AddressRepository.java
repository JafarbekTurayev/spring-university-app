package pdp.uz.springuniversity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.springuniversity.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
