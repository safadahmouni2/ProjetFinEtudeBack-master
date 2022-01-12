package RexProf.Service.RolesService;

import RexProf.Entity.Roles;
import RexProf.Entity.Users;
import RexProf.Enum.CompeteEtat;
import RexProf.Repository.RolesRepository;
import RexProf.modelDto.RolesDto;
import RexProf.modelDto.UsersDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolesService implements IRolesService {
    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    private ModelMapper modelMapper ;
    @Override
    public void addRole(String nom,String des) {
        Roles s = new Roles();
        s.setName_roles(nom);
        s.setDesc_roles(des);
        s.setCondition(true);

        rolesRepository.save(s);

    }
    @Override
    public RolesDto getRole(long id) {
        return modelMapper.map(rolesRepository.findbyId(id) , RolesDto.class);

    }

    private RolesDto convertToDto(Roles role) {
        RolesDto rolesDto = modelMapper.map(role, RolesDto.class);
        return rolesDto;}
    @Override
    public List<RolesDto> getAllRoles() {
        return (rolesRepository.getAll()).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRole(long id) {

        rolesRepository.deleteById(id);

    }

    @Override
    public void Active(long id) {
        Roles cc = rolesRepository.findById(id).get();
        cc.setCondition(true);
        cc = rolesRepository.save(cc);
    }

    @Override
    public void change(long id) {
        Roles cc = rolesRepository.findById(id).get();
if(cc.isCondition()){
    cc.setCondition(false);
}else {
    cc.setCondition(true);

}
        cc = rolesRepository.save(cc);

    }

    @Override
    public void desactive(long id) {
        Roles cc = rolesRepository.findById(id).get();
        cc.setCondition(false);
        cc = rolesRepository.save(cc);
    }

    @Override
    public void UpdateRoles(Roles r)  {
        Roles fichier = rolesRepository.findById(r.getId()).get();
        fichier.setDesc_roles(r.getDesc_roles());
        fichier.setName_roles(r.getName_roles());
        fichier.setCondition(false);

        rolesRepository.save(fichier);
    }
    @Override
    public int getNBRole() {
        return  rolesRepository.findNBRRole();
    }

    @Override
    public int getNBRoleA() {
        return  rolesRepository.findNBRRoleA();    }

    @Override
    public int getNBRoleD() {
        return  rolesRepository.findNBRRoleD();    }

}
