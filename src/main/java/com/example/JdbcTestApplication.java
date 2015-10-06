package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.dao.UserDao;

@SpringBootApplication
public class JdbcTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JdbcTestApplication.class, args);

        UserDao userJdbcDao = context.getBeansOfType(UserDao.class).get("userJdbcDao");
        String nom = "Jennish";
        System.out
                .println(String.format("There are %s user(s) whose name is %s.", userJdbcDao.countUserByNom(nom), nom));
    }

}
