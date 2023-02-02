package callbus.zaritalk.dataaccesslayer;


import callbus.zaritalk.dataaccesslayer.entity.EAccountType;
import callbus.zaritalk.dataaccesslayer.entity.Users;
import callbus.zaritalk.dataaccesslayer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class H2DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    public void run(ApplicationArguments args) {

        userRepository.save(Users.builder()
                .nickName("임차인")
                .accountType(EAccountType.LESSEE)
                .quit(true)
                .build());

        userRepository.save(Users.builder()
                .nickName("임대인")
                .accountType(EAccountType.LESSOR)
                .quit(true)
                .build());

        userRepository.save(Users.builder()
                .nickName("중개사")
                .accountType(EAccountType.REALTOR)
                .quit(true)
                .build());
    }
}
