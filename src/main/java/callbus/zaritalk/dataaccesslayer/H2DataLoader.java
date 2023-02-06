package callbus.zaritalk.dataaccesslayer;


import callbus.zaritalk.dataaccesslayer.entity.Community;
import callbus.zaritalk.dataaccesslayer.entity.EAccountType;
import callbus.zaritalk.dataaccesslayer.entity.Role;
import callbus.zaritalk.dataaccesslayer.entity.User;
import callbus.zaritalk.dataaccesslayer.repository.CommunityRepository;
import callbus.zaritalk.dataaccesslayer.repository.UserRepository;
import callbus.zaritalk.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Component
@Slf4j
@RequiredArgsConstructor
public class H2DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommunityRepository communityRepository;

    @Autowired
    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    public void run(ApplicationArguments args) {

        Role userRole = roleService.getUserRole();
        Role adminRole = roleService.getAdminRole();
        Set<Role> role = new HashSet<Role>();
        role.add(userRole);

        User lessee = userRepository.save(User.builder()
                .nickName("임차인")
                .accountType(EAccountType.LESSEE)
                .phone("01055559999")
                .email("lessee@test.com")
                .password(passwordEncoder.encode("pass"))
                .userStatus(User.EUserStatus.NORMAL)
                .roles(role)
                .build());

        User lessor = userRepository.save(User.builder()
                .nickName("임대인")
                .accountType(EAccountType.LESSOR)
                .phone("01011112222")
                .email("lessor@test.com")
                .password(passwordEncoder.encode("pass"))
                .userStatus(User.EUserStatus.NORMAL)
                .roles(role)
                .build());

        User realtor = userRepository.save(User.builder()
                .nickName("중개사")
                .accountType(EAccountType.REALTOR)
                .phone("01055557777")
                .email("realtor@test.com")
                .password(passwordEncoder.encode("pass"))
                .userStatus(User.EUserStatus.NORMAL)
                .roles(role)
                .build());

        Community community = communityRepository.save(Community.builder()
                .writer(realtor)
                .writerName(realtor.getNickName())
                .communityTitle("[K-중개사] 서울시에서 제일 안전한 중개사")
                .communityContent("서울시 집을 소개 합니다.")
                .likeCount(0)
                .isDeleted(false)
                .build());
    }
}