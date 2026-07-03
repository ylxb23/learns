package com.zero.learns.cache;

import java.util.HashSet;
import java.util.Set;

public class UserService {
    public static final User EMPTY_USER = new User();
    private static Set<User> users = new HashSet<>();
    static {
        users.add(new User("小二", 23));
        users.add(new User("小三", 21));
        users.add(new User("小五", 20));
        users.add(new User("小六", 17));
        users.add(new User("小九", 16));
    }
    public static User getByName(String name) {
        if(name == null) {
            return null;
        }
        for(User user : users) {
            if(name.equals(user.getName())) {
                return user;
            }
        }
        return null;
    }
}
