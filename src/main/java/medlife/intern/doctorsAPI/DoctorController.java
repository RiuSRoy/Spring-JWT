package medlife.intern.doctorsAPI;

import io.jsonwebtoken.Jwts;
import medlife.intern.doctorsAPI.model.Doctor;
import medlife.intern.doctorsAPI.model.JwtUser;
import medlife.intern.doctorsAPI.security.JwtGenerator;
import medlife.intern.doctorsAPI.service.CustomUserDetailService;
import medlife.intern.doctorsAPI.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static medlife.intern.doctorsAPI.security.JwtValidator.USERNAME;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @RequestMapping(value = "/medlife/getNext")
    public Optional<Doctor> getNext() {
        return (Optional.ofNullable(doctorService.getNext()));
    }

    @RequestMapping(value = "/medlife/save/{doc_id}",method = RequestMethod.PUT)
    public void checkout(@PathVariable("doc_id") String doc_id) {
        doctorService.findById(doc_id , USERNAME);
    }

    @RequestMapping(value = "/signin" , method = RequestMethod.POST)
    public String signin(@RequestBody  JwtUser jwtUser) {
        return "Token "+customUserDetailService.authenticateUser(jwtUser);
    }
}
