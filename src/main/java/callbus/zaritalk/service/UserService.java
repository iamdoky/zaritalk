package callbus.zaritalk.service;

import callbus.zaritalk.dataaccesslayer.entity.User;
import callbus.zaritalk.dataaccesslayer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    UserRepository userRepository;

    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("User not found %s", id)));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException(String.format("User was not found by email and user type: %s, %s", email)));
    }
}
