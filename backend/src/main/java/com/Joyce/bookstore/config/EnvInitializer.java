
package com.Joyce.bookstore.config;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class EnvInitializer {
    @PostConstruct
    public void init() {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        System.setProperty("MONGODB_URI", dotenv.get("MONGODB_URI"));
        System.setProperty("MONGODB_DB", dotenv.get("MONGODB_DB"));
        System.setProperty("NYT_API_KEY", dotenv.get("NYT_API_KEY"));
        System.setProperty("GOOG_API_KEY", dotenv.get("GOOG_API_KEY"));
        System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET"));
    }
}
