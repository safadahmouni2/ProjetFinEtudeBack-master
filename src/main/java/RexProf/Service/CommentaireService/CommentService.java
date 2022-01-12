package RexProf.Service.CommentaireService;

import RexProf.Entity.Aime;
import RexProf.Entity.Commentaire;
import RexProf.Entity.Publications;
import RexProf.Repository.AimeRepository;
import RexProf.Repository.CommentRepository;
import RexProf.Repository.PublicationsRepository;
import RexProf.Repository.UsersRepository;
import RexProf.modelDto.aimeDto;
import RexProf.modelDto.commentaireDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentService implements ICommentService {
@Autowired
CommentRepository commentRepository;
    @Autowired
    PublicationsRepository publicationsRepository;
    @Autowired
    UsersRepository usersRepository;

    @Override
    public void comment(commentaireDto g) {
        Commentaire commentaire=new Commentaire();
        commentaire.setPublications(publicationsRepository.findById(g.getPubId()).get());
        commentaire.setUsers(usersRepository.findById(g.getUserId()).get());
        commentaire.setText(g.getText());
        commentaire.setDate(new Date());

        commentRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> getCommentaires(long id, Integer pageNo, Integer pageSize) {
        PageRequest paging = PageRequest.of(pageNo, pageSize);

        Page<Commentaire> pagedResult = commentRepository.getComment( id,paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Commentaire>();
        }    }

}
