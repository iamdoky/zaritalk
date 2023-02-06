package callbus.zaritalk.service;

import callbus.zaritalk.dataaccesslayer.entity.User;
import callbus.zaritalk.dataaccesslayer.entity.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        String[] userNameAndType = username.split("/");
        User user = userService.getUserByEmail(userNameAndType[0]);
        return UserDetailsImpl.build(user);
    }

    @Transactional
    public UserDetails loadUserByEmail(String email) {
        return UserDetailsImpl.build(userService.getUserByEmail(email));
    }
}