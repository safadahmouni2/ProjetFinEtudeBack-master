package RexProf.security.services;

import RexProf.Entity.Users;
import RexProf.Repository.UserRepository;
import RexProf.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
    	
        Users user = userRepository.findByLogin(login)
                	.orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with -> username or email : " + login)
        );

        return Users.build(user);
    }
}