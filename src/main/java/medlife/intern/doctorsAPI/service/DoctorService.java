package medlife.intern.doctorsAPI.service;

import medlife.intern.doctorsAPI.DoctorRepository;
import medlife.intern.doctorsAPI.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor getNext() {
        List<Doctor> list = doctorRepository.findByIsLockedAndIsValidatedOrderByRankAsc(Boolean.FALSE,Boolean.FALSE);
        if(list.size() == 0) {
            return null;
        }
        else {
            Doctor doc = list.get(0);
            doc.setAssignTime(new Date());
            doc.setIsLocked(Boolean.TRUE);
            doctorRepository.save(doc);
            return doc;
        }
    }

    public void findById(String doc_id , String username) {
        Optional<Doctor> doctor = doctorRepository.findById(doc_id);
        System.out.println("Doctor : "+doctor);
        doctor.get().setIsLocked(Boolean.FALSE);
        doctor.get().setSaveTime(new Date());
        doctor.get().setUpDatedBy(username);
        doctor.get().setIsValidated(Boolean.TRUE);
        doctorRepository.save(doctor.get());
    }
}
