package pdp.uz.springuniversity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.springuniversity.entity.Address;
import pdp.uz.springuniversity.entity.University;
import pdp.uz.springuniversity.payload.Result;
import pdp.uz.springuniversity.payload.UniversityReq;
import pdp.uz.springuniversity.repository.AddressRepository;
import pdp.uz.springuniversity.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    AddressRepository addressRepository;

    public Result addUniver(UniversityReq universityReq) {
        Address address = new Address();
        address.setCity(universityReq.getCity());
        address.setStreet(universityReq.getStreet());
        address.setHome(universityReq.getHome());

        Address save = addressRepository.save(address);

        University university = new University();
        university.setName(universityReq.getName());
        university.setAddress(save);

        universityRepository.save(university);
        return new Result("Saved", true, university);
    }

    public List<University> getAll() {
        return universityRepository.findAll();
    }

    public Result getOneById(int id) {

        //1-usul
//        Optional<University> byId = universityRepository.findById(id);
//        if (byId.isPresent()) {
//            University university = byId.get();
//            return new Result("Ok", true, university);
//        } else {
//            return new Result("NOT found!", false, null);
//        }

        //2-usul
        Optional<University> byId = universityRepository.findById(id);
        if (!byId.isPresent()) return new Result("NOT found!", false, null);
        return new Result("Ok", true, byId.get());
    }

    public Result edit(int id, UniversityReq universityReq) {
        Optional<University> byId = universityRepository.findById(id);
        if (!byId.isPresent()) return new Result("NOT found!", false, null);

        University university = byId.get();
        if (universityReq.getName() != null) {
            university.setName(universityReq.getName());
        }

        Optional<Address> optionalAddress = addressRepository.findById(byId.get().getAddress().getId());

        if (!optionalAddress.isPresent()) return new Result("Xato address", false);
        if (universityReq.getCity() != null) optionalAddress.get().setCity(universityReq.getCity());
        if (universityReq.getStreet() != null) optionalAddress.get().setStreet(universityReq.getStreet());
        if (universityReq.getHome() != null) optionalAddress.get().setHome(universityReq.getHome());

        if (universityReq.getCity() != null && universityReq.getStreet() != null && universityReq.getHome() != null) {
            Address save = addressRepository.save(optionalAddress.get());
            university.setAddress(save);
        }
        universityRepository.save(university);
        return new Result("Updated!", true, null);
    }

    public Result deleteUniver(int id) {

        Optional<University> byId = universityRepository.findById(id);

        if (!byId.isPresent()) return new Result("Xatolik", false);

        universityRepository.deleteById(id);
        addressRepository.deleteById(byId.get().getAddress().getId());
        return new Result("Deleted!", true);
    }
}
