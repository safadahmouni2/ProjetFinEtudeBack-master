package RexProf.Service.aimeService;

import RexProf.Entity.Aime;
import RexProf.Entity.Groups;
import RexProf.Entity.Postule;
import RexProf.Entity.Publications;
import RexProf.Repository.*;
import RexProf.modelDto.GroupsDto;
import RexProf.modelDto.GroupsRoleDto;
import RexProf.modelDto.aimeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AimeService implements IAimeService {
@Autowired
    AimeRepository aimeRepository;
    @Autowired
    PublicationsRepository publicationsRepository;
    @Autowired
    UsersRepository usersRepository;
    @Override
    public int getNBRAime(long id) {
        return  aimeRepository.findNBRAime(id);
    }

    @Override
    public void aime(aimeDto g) {
        Aime aime=new Aime();
        aime.setPublications(publicationsRepository.findById(g.getPubId()).get());
        aime.setUsers(usersRepository.findById(g.getUserId()).get());
        aime.setEtat(1);
        aimeRepository.save(aime);
        Publications cc = publicationsRepository.findById(g.getPubId()).get();
        cc.setAimes(cc.getAimes()+1);
        cc = publicationsRepository.save(cc);
    }

    @Override
    public void aimepas(long id,long idP) {

        aimeRepository.deleteAimeByUser(id,idP);
        Publications cc = publicationsRepository.findByUser(idP);
        cc.setAimes(cc.getAimes()-1);
        cc = publicationsRepository.save(cc);
    }
}
