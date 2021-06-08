package com.mc.jfaker.pojo;

import com.github.javafaker.Faker;
import com.mc.jfaker.JfakerApplicationTests;
import com.mc.jfaker.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mc
 * @create 2021-06-07 21:47
 **/
@Slf4j
public class UserTest extends JfakerApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void save() {
        Faker faker = new Faker(Locale.CHINA);
        ArrayList<User> list = new ArrayList<>();

        for (int i = 0; i < 5000000; i++) {
            User user = new User();
            user.setRealname(faker.name().fullName());
            user.setAge(faker.random().nextInt(10, 100));
            user.setCellphone(faker.phoneNumber().cellPhone());
            user.setUniversityname(faker.university().name());
            user.setCity(faker.address().city());
            user.setStreet(faker.address().streetAddress());
            userMapper.insert(user);

        }

    }
}
