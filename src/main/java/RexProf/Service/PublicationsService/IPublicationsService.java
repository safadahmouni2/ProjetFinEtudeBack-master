package RexProf.Service.PublicationsService;

import RexProf.Entity.Publications;
import RexProf.modelDto.PublicationsDto;
import RexProf.modelDto.UsersDto;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.List;

public interface IPublicationsService {
    List<PublicationsDto> getAllWord(Integer pageNo, Integer pageSize);
    List<Publications> getAllPub();
    List<Publications> getMesPub(long id,Integer pageNo, Integer pageSize);
    void addPub(PublicationsDto u)throws IOException;
    void addPubV(PublicationsDto u, MultipartFile vd)throws IOException;
    void addPubI(PublicationsDto u, MultipartFile img)throws IOException;
    void signaler(long id );

    void deletePub(long id);
    PublicationsDto getPub(long id);
    void UpdatePub(PublicationsDto u, MultipartFile img)throws IOException;
}
