package org.example.chap10.setup;

import org.example.chap07.userregister.MemoryUserRepository;
import org.example.chap07.userregister.User;
import org.example.chap07.userregister.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeServiceTest {
    private UserRepository memoryRepository = new MemoryUserRepository();
    private ChangeUserService changeService;

    @BeforeEach
    void setup() {
        changeService = new ChangeUserService(memoryRepository);
//        memoryRepository.save(new User("id", "pw", "email@email.com"));
    }

    @Test
    void changeEmail() {
        memoryRepository.save(new User("id", "pw", "email@email.com"));

        changeService.changeEmail("id", "email1@email.com");

        User user = memoryRepository.findById("id");
        assertEquals("email1@email.com", user.getEmail());
    }

    @Test
    void changePw() {
        memoryRepository.save(new User("id", "oldPw", "email@email.com"));

        changeService.changePw("id", "newPw");

        User user = memoryRepository.findById("id");
        assertTrue(user.matchPassword("newPw"));
    }
}
