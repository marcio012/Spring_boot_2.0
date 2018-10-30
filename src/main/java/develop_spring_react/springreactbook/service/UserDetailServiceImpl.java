package develop_spring_react.springreactbook.service;

import develop_spring_react.springreactbook.domain.UserRepository;
import develop_spring_react.springreactbook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usename) {
        User currentUser = userRepository.findByUsername(usename);
        UserDetails user = new org.springframework.security.core.userdetails.User(
                usename, currentUser.getPassword(), true, true,
                true, true,
                AuthorityUtils.createAuthorityList(currentUser.getRole()));

        return user;
    }


}
