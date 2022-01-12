package RexProf.Controller;

import RexProf.Entity.Groups;
import RexProf.Entity.Roles;
import RexProf.Entity.Users;
import RexProf.Enum.CompeteEtat;
import RexProf.Repository.GroupsRepository;
import RexProf.Repository.RolesRepository;
import RexProf.Repository.UserRepository;
import RexProf.Repository.UsersRepository;
import RexProf.modelDto.GroupsRoleDto;
import RexProf.security.jwt.JwtProvider;
import RexProf.security.message.request.LoginForm;
import RexProf.security.message.request.SignUpForm;
import RexProf.security.message.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    GroupsRepository groupsRepository;
    @Autowired
    RolesRepository rolesRepository;


    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getLogin(),
                        loginRequest.getPwd()
                )
        );


        //System.out.print(jwtProvider.getRolefromToken(jwt));
        return ResponseEntity.ok(responseLogin(authentication));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Validated @RequestPart("u") final SignUpForm signUpRequest, @RequestPart(value="file",required=true)  final MultipartFile file) throws IOException {
       /* if(userRepository.existsByUsername(signUpRequest.getFirst_name())) {
            return new ResponseEntity<String>("Fail -> First_name is already taken!",
                    HttpStatus.BAD_REQUEST);
        }*/

        if(userRepository.existsByLogin(signUpRequest.getLogin())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",

                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Users cc = new Users();
        cc.setName_user(signUpRequest.getName_user());
                cc.setFirst_name(signUpRequest.getFirst_name());
                cc.setEmail(signUpRequest.getEmail());
                cc.setTitle(signUpRequest.getTitle());
                cc.setLogin(signUpRequest.getLogin());
                cc.setPwd(encoder.encode(signUpRequest.getPwd()));
                cc.setGender(signUpRequest.getGender());
                cc.setAge(signUpRequest.getAge());
                cc.setPhone(signUpRequest.getPhone());
                cc.setDate_birth(signUpRequest.getDate_birth());
                cc.setDescription(signUpRequest.getDescription());
                cc.setPicture(file.getBytes());
                cc.setPays(signUpRequest.getPays());
                cc.setEtat(CompeteEtat.ACTIF);







       /* Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
        	switch(role) {
	    		case "admin":
	    			Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	    			roles.add(adminRole);
	    			
	    			break;
	    		case "pm":
	            	Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	            	roles.add(pmRole);
	            	
	    			break;
	    		default:
	        		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	        		roles.add(userRole);        			
        	}
        });
        
        user.setRoles(roles);*/
        userRepository.save(cc);

        return ResponseEntity.ok().body("User registered successfully!");
    }
    public JwtResponse responseLogin(Authentication authentication){
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);


        Users user = userRepository.findByLogin(jwtProvider.getLoginFromJwtToken(jwt))
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with ->  email : ")
                );
        return new JwtResponse(jwt,jwtProvider.getLoginFromJwtToken(jwt),jwtProvider.getRolefromToken(jwt));

    }
}