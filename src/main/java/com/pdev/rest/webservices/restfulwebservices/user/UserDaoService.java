package com.pdev.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();
    private static int userCount = 0;
    static {
        users.add(new User(++userCount,"John", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount,"Ram", LocalDate.now().minusYears(55)));
        users.add(new User(++userCount,"Shyam", LocalDate.now().minusYears(32)));
        users.add(new User(++userCount,"Geeta", LocalDate.now().minusYears(28)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        Predicate<? super User> predicate;
        predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id){
        Predicate<? super User> predicate;
        predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
    
    public User saveUser(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
