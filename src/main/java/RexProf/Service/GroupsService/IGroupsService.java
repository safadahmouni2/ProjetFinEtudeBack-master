package RexProf.Service.GroupsService;

import RexProf.modelDto.*;

import java.util.List;

public interface IGroupsService {
    int getNBRGroup();
    int getNBRGroupA();
    int getNBRGroupD();
    void affectation(GroupsRoleDto g );

    void addGroup(GroupsDto g);
    GroupsDto getGroup(long id);
    GroupsDto getidgroup(long id);

    List<GroupsDto> getAllGroups();
    void change(long id) ;
    void deleteGroupes(long id);
    void UpdateGroupes(GroupsDto g);

}
