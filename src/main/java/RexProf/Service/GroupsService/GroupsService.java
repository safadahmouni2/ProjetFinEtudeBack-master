package RexProf.Service.GroupsService;

import RexProf.Entity.*;
import RexProf.Repository.GroupsRepository;
import RexProf.Repository.RolesRepository;
import RexProf.modelDto.*;
import org.apache.catalina.Group;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import javax.management.relation.RoleStatus;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GroupsService implements IGroupsService{
    @Autowired
    GroupsRepository groupsRepository;
    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    private ModelMapper modelMapper ;
    @Override
    public int getNBRGroup() {
        return  groupsRepository.findNBRGroupe();
    }

    @Override
    public int getNBRGroupA() {
        return  groupsRepository.findNBRGroupA();
    }

    @Override
    public int getNBRGroupD() {
        return  groupsRepository.findNBRGroupD();
    }




    @Override
    public void affectation(GroupsRoleDto g ) {

            Groups newRole = groupsRepository.findById(g.getId()).get();
           // newRole.setName_grp(g.getName());
            newRole.setRoles(g.getRoles());
            newRole.setUsers(g.getUsers());

            Groups savedRole = groupsRepository.save(newRole);


    }

    @Override
    public void addGroup(GroupsDto g) {



        Groups gg = new Groups();
        gg.setName_grp(g.getName_grp());
        gg.setDesc_grp(g.getDesc_grp());
        gg.setCondition(false);
        gg.setCreation_date(new Date());
       // gg.setRoles(g.getRoles());
        groupsRepository.save(gg);
       /* for(RolesDto poste : g.getRoles()) {
            Roles cc = rolesRepository.findById(poste.getId()).get();
         //   List<Groups> ggg = new List<>();

            cc.setGroups(gg);
            rolesRepository.save(cc);

        }*/



    }
    @Override
    public GroupsDto getGroup(long id) {
        return modelMapper.map(groupsRepository.findbyId(id) , GroupsDto.class);

    }

    @Override
    public GroupsDto getidgroup(long id) {
        return modelMapper.map(groupsRepository.findbyUserid(id) , GroupsDto.class);    }

    private GroupsDto convertToDto(Groups groups) {
        GroupsDto groupsDto = modelMapper.map(groups, GroupsDto.class);
        return groupsDto;}
    @Override
    public List<GroupsDto> getAllGroups() {
        return (groupsRepository.getAll()).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    @Override
    public void change(long id) {
        Groups cc = groupsRepository.findById(id).get();
        if(cc.isCondition()){
            cc.setCondition(false);
        }else {
            cc.setCondition(true);

        }
        cc = groupsRepository.save(cc);

    }

    @Override
    public void deleteGroupes(long id) {
        groupsRepository.deleteById(id);

    }

    @Override
    public void UpdateGroupes(GroupsDto g) {
        Groups gg = groupsRepository.findById(g.getId()).get();
        gg.setName_grp(g.getName_grp());
        gg.setDesc_grp(g.getDesc_grp());
        gg.setCondition(false);

       // gg.setRoles(g.getRoles() );
        gg.setCreation_date(new Date());
        groupsRepository.save(gg);
    }
}
