package RexProf.Service.RolesService;

import RexProf.Entity.Roles;
import RexProf.modelDto.RolesDto;

import javax.management.relation.Role;
import java.io.IOException;
import java.util.List;

public interface IRolesService {
    void addRole(String nom,String des);
    List<RolesDto> getAllRoles();
    void deleteRole(long id);
    void Active(long id) ;
    void change(long id) ;
    int getNBRole();
    int getNBRoleA();
    int getNBRoleD();

    void desactive(long id) ;
    RolesDto getRole(long id);
    void UpdateRoles(Roles roles) ;


}
