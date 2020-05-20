package ru.itis.sem1.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.sem1.Models.State;
import ru.itis.sem1.Models.User;
import ru.itis.sem1.Repositories.UserRepository;

import java.util.Optional;

@Service
public class AuthCheckServiceImpl implements AuthCheckService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean checkAuth(String uuid) {
        Optional<User> user = userRepository.findUserByUuid(uuid);
        if (user.isPresent()) {
            User user_obj = user.get();
            user_obj.setState(State.CONFIRMED);
            userRepository.save(user_obj);
            return true;
        }
        return false;
    }
}