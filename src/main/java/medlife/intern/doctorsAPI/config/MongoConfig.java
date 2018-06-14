package medlife.intern.doctorsAPI.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient createConnection() {
        return new MongoClient("127.0.0.1:27017");
    }
}
