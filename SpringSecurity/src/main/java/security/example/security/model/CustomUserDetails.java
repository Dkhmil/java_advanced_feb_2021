package security.example.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import security.example.model.User;

import java.util.Collection;
import java.util.List;

@Data
/*@AllArgsConstructor
@NoArgsConstructor*/
public class CustomUserDetails extends User implements UserDetails {
    private static final long serialVersionUID = 1L;
    private List<String> userRoles;
    private User user;


    public CustomUserDetails(List<String> userRoles, User user) {
        this.userRoles = userRoles;
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    public String getPassword() {
        return this.user.getPassword();
    }

    public String getUsername() {
        return this.user.getUserName();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
