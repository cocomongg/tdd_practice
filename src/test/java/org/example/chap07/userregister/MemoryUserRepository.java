package org.example.chap07.userregister;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements UserRepository {
    Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }
}
