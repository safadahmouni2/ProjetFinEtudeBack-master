package RexProf.Service.UsersService;

import RexProf.Entity.CompetanceFiles;
import RexProf.Entity.Users;
import RexProf.Enum.CompeteEtat;
import RexProf.Repository.UsersRepository;
import RexProf.modelDto.AuthResult;
import RexProf.modelDto.CompetanceFilesWithSkillsDto;
import RexProf.modelDto.UsersDto;
import RexProf.security.jwt.JwtProvider;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService implements IUsersService{
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    private ModelMapper modelMapper ;


    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Value("${grokonez.app.jwtSecret}")
    private String jwtSecret;
    @Override
    public AuthResult DoLogin(String email, String pwd) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        pwd
                )
        );


        return responseLogin(authentication);



    }



    public AuthResult responseLogin(Authentication authentication){
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);

        AuthResult result=new AuthResult();
        result.setToken(jwt);
        return result;

//        return new JwtResponse(jwt,jwtProvider.getEmailFromJwtToken(jwt),jwtProvider.getRolefromToken(jwt),user);

    }

   /* @Override
    public AuthResult DoLogin(String email, String pwd) {
        Users e = new Users();
        List<Users> usersList=usersRepository.DoLogin(email, pwd);
        if (usersList != null){
            if(usersList.size()>0){
                e = usersList.get(0);
                AuthResult result=new AuthResult();
                result.setToken(getJWTToken(e));
                return result;
            }



        } /*else {
            if (usersRepository.findByEMail(email) != null){
                e = usersRepository.findByEMail(email);
                e.setToken("PASSWD");
            }else{
                e.setToken("UNKNOWN");
            }
        }

        AuthResult result=new AuthResult();
        result.setErrors("Errors");
        return result;


    }*/
    private UsersDto convertToDto(Users post) {
        UsersDto usersDto = modelMapper.map(post, UsersDto.class);
        return usersDto;}
    @Override
    public List<UsersDto> getAllUsers() {

        return (usersRepository.getAll()).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    public static byte[] convertToImg(String base64) throws IOException {
        return Base64.decodeBase64(base64);
    }
    @Override
    public void addUser(UsersDto u, MultipartFile img) throws IOException {

        /*Users cc = new Users();
        cc.setName_user(u.getName_user());
        cc.setFirst_name(u.getFirst_name());
        cc.setEmail(u.getEmail());
        cc.setTitle(u.getTitle());
        cc.setLogin(u.getLogin());
        cc.setPhone(u.getPhone());
        cc.setPwd(u.getPwd());
        cc.setGender(u.getGender());
        cc.setAge(u.getAge());
        cc.setDate_birth(u.getDate_birth());
        cc.setPicture(img.getBytes());
        cc.setEtat(CompeteEtat.DEACTIVE);
        //String base64=u.getPicture().substring(u.getPicture().indexOf(',')+1);
        //byte[] base64Val=convertToImg(base64);
       // writeByteToImageFile(base64Val, cc);

        cc = usersRepository.save(cc);*/

    }

    @Override
    public void deleteUsers(long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public UsersDto getUser(long id) {
        return modelMapper.map(usersRepository.findbyId(id) , UsersDto.class);

    }

    @Override
    public void UpdateUsers(UsersDto u,MultipartFile img) throws IOException {
        Users cc = usersRepository.findById(u.getId()).get();
        cc.setName_user(u.getName_user());
        cc.setFirst_name(u.getFirst_name());
        cc.setEmail(u.getEmail());
        cc.setTitle(u.getTitle());
        cc.setLogin(u.getLogin());
        cc.setPhone(u.getPhone());
        cc.setPwd(u.getPwd());
        cc.setGender(u.getGender());
        cc.setAge(u.getAge());
        cc.setDate_birth(u.getDate_birth());
        cc.setPicture(img.getBytes());
        cc = usersRepository.save(cc);

    }

    @Override
    public void bloque(long id) {
        Users cc = usersRepository.findById(id).get();
        cc.setEtat(CompeteEtat.BLOQUE);
        cc = usersRepository.save(cc);
    }

    @Override
    public void activer(long id ) {
        Users cc = usersRepository.findById(id).get();
        cc.setEtat(CompeteEtat.ACTIF);
        cc = usersRepository.save(cc);

    }
    @Override
    public int getNBRuser() {
        return  usersRepository.findNBR();
    }

    @Override
    public int getNBRuserA() {
        return  usersRepository.findNBRUserA();
    }

    @Override
    public int getNBRuserD() {
        return  usersRepository.findNBRUserD();
    }

    @Override
    public int getNBRuserB() {
        return  usersRepository.findNBRUserB();
    }




}
