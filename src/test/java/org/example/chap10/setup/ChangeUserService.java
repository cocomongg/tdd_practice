package org.example.chap10.setup;

import org.example.chap07.userregister.User;
import org.example.chap07.userregister.UserRepository;

public class ChangeUserService {

    private UserRepository userRepository;

    public ChangeUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void changeEmail(String id, String mail) {
        User user = userRepository.findById(id);
        user.setEmail(mail);
        userRepository.save(user);
    }

    public void changePw(String id, String newPw) {
        User user = userRepository.findById(id);
        user.setPassword(newPw);
        userRepository.save(user);
    }
}
