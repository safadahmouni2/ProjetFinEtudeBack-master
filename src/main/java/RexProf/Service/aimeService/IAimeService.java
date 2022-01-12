package RexProf.Service.aimeService;

import RexProf.modelDto.GroupsDto;
import RexProf.modelDto.GroupsRoleDto;
import RexProf.modelDto.aimeDto;

import java.util.List;

public interface IAimeService {
    int getNBRAime(long id);
    void aime(aimeDto g);
    void aimepas(long id,long idP);



}
