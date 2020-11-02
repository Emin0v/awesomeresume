package com.company.webservice;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);

        UserBuilder builder = null;
        if (user != null) {
            builder = withUsername(email);

            builder.disabled(false);
            builder.password(user.getPassword());

            String[] authoritiesArr = new String[]{"ADMIN","USER"};
            builder.authorities(authoritiesArr);

            return builder.build();
        }else {
            throw new UsernameNotFoundException("User not found");
        }

    }
}
