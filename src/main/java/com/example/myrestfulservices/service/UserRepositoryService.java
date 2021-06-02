package com.example.myrestfulservices.service;

import com.example.myrestfulservices.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserRepositoryService {

    public static List<User> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(new User(1, "Google", new Date(), "pass1", "701010-1111111"));
        users.add(new User(2, "Apple", new Date(), "pass2", "807010-2222222"));
        users.add(new User(3, "Samsung", new Date(), "pass3", "907010-3333333"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }

        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }
}
