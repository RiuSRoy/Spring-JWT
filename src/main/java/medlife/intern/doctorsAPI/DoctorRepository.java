package medlife.intern.doctorsAPI;

import medlife.intern.doctorsAPI.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor,String> {

    public List<Doctor> findByIsLockedAndIsValidatedOrderByRankAsc(Boolean locked,Boolean validated);


}
