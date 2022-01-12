package RexProf.Service.UsersService;

import RexProf.Entity.Users;
import RexProf.modelDto.AuthResult;
import RexProf.modelDto.CompetanceFilesDto;
import RexProf.modelDto.CompetanceFilesWithSkillsDto;
import RexProf.modelDto.UsersDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IUsersService {
    AuthResult DoLogin(String email, String pwd);
    List<UsersDto> getAllUsers();
    void addUser(UsersDto u, MultipartFile img)throws IOException ;
    void deleteUsers(long id);
    UsersDto getUser(long id);
    void UpdateUsers(UsersDto u, MultipartFile img)throws IOException;
    void bloque(long id );
    void activer(long id);
    int getNBRuser();
 int getNBRuserA();
 int getNBRuserD();
 int getNBRuserB();



}
