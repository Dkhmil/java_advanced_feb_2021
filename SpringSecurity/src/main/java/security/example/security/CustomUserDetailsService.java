package security.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import security.example.model.User;
import security.example.model.UserRole;
import security.example.repository.UserRepository;
import security.example.repository.UserRoleRepository;
import security.example.security.model.CustomUserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("user with such name was not found : " + userName);
        }
        List<String> roles = new ArrayList<>();
        List<UserRole> userRoles = userRoleRepository.findUserRolesByUserId(user.getId());
        userRoles.forEach(userRole -> roles.add(userRole.getRole()));
        return new CustomUserDetails(roles, user);
    }
}
