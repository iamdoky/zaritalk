package callbus.zaritalk.service;

import callbus.zaritalk.dataaccesslayer.entity.Role;
import callbus.zaritalk.dataaccesslayer.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role save(Role role){
        return roleRepository.save(role);
    }

    public Role getUserRole() {
        Optional<Role> optionalRole = roleRepository.findByName(Role.ERole.ROLE_USER);
        return optionalRole.orElseGet(() -> save(new Role(Role.ERole.ROLE_USER)));
    }

    public Role getAdminRole() {
        Optional<Role> optionalRole = roleRepository.findByName(Role.ERole.ROLE_ADMIN);
        return optionalRole.orElseGet(() -> save(new Role(Role.ERole.ROLE_ADMIN)));
    }
}
