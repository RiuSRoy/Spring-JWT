package medlife.intern.doctorsAPI.service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import medlife.intern.doctorsAPI.DoctorController;
import medlife.intern.doctorsAPI.model.JwtUser;
import medlife.intern.doctorsAPI.model.JwtUserDetails;
import medlife.intern.doctorsAPI.security.JwtGenerator;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailService{

    @Autowired
    private MongoClient mongoClient;

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public String authenticateUser(JwtUser jwtUser) throws RuntimeException{
        MongoDatabase database = mongoClient.getDatabase("medlife");
        MongoCollection<Document> collection = database.getCollection("User");

        Document document = collection.find(Filters.eq("username",jwtUser.getUsername())).first();

        if(document != null) {
            if(PASSWORD_ENCODER.matches(document.get("password").toString() , jwtUser.getPassword())) {
            //if(document.get("password").equals(jwtUser.getPassword())) {
                JwtGenerator jwtGenerator = new JwtGenerator();
                return jwtGenerator.generate(jwtUser);
            }
            else {
                throw new RuntimeException("Wrong Password...Not you?");
            }
        }
        else {
            throw new RuntimeException("username not found!!");
        }
    }
}
