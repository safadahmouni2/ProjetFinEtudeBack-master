package RexProf.Service.matching;

import RexProf.Entity.Commentaire;
import RexProf.Entity.matchingOffre;
import RexProf.Repository.*;
import RexProf.modelDto.MatchingDto;
import RexProf.modelDto.commentaireDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MatchingService implements IMatchingService {
@Autowired
MatchingRepository matchingRepository;
    @Autowired
    ServicesRequestRepository servicesRequestRepository;
    @Autowired
    UsersRepository usersRepository;

    @Override
    public void addMatch(MatchingDto g) {
        matchingOffre match=new matchingOffre();
        match.setScore(g.getScore());
        match.setUsers(usersRepository.findById(g.getUserId()).get());
        match.setServiceRequest(servicesRequestRepository.findById(g.getServId()).get());

        matchingRepository.save(match);
    }

    /*@Override
    public List<Commentaire> getCommentaires(long id, Integer pageNo, Integer pageSize) {
        PageRequest paging = PageRequest.of(pageNo, pageSize);

        Page<Commentaire> pagedResult = commentRepository.getComment( id,paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Commentaire>();
        }    }*/

}
