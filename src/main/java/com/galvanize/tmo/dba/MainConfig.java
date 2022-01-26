package com.galvanize.tmo.dba;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.commons.dbcp.BasicDataSource;


//public class MainConfig {
//}

@Configuration
//@ComponentScan(basePackages = "com.heroku.example")
public class MainConfig {

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI("postgres://veispagpezfbqa:fa4e0735ffa8b87c62da80b81d381d86399a8edca2e464bbd10ebb03ca00c919@ec2-3-224-157-224.compute-1.amazonaws.com:5432/db0cnkddvbo840");

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath()+"?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

}
