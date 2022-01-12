package RexProf.Service.ServiceRequestService;

import RexProf.Entity.Postule;
import RexProf.Entity.Publications;
import RexProf.Entity.ServiceRequest;
import RexProf.Entity.matchingOffre;
import RexProf.modelDto.DemandeCompDto;
import RexProf.modelDto.PublicationsDto;
import RexProf.modelDto.ServiceRequestDto;
import RexProf.modelDto.inputPostuleDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IServiceRequestService {
    List<ServiceRequest> getAlldem(Integer pageNo, Integer pageSize);
    List<ServiceRequest> getMesDem(long id,Integer pageNo, Integer pageSize);
    List<Postule> getMesPostule(long id, Integer pageNo, Integer pageSize);
    List<matchingOffre> getMesDemMatche(long id,Integer pageNo, Integer pageSize);

    long addSer(ServiceRequestDto s);
    void deleteSer(long id);
    ServiceRequestDto getSer(long id);
    void UpdateSer(ServiceRequestDto s);
    void affectation(inputPostuleDto g);
    List<matchingOffre> getdemMatching(Integer pageNo, Integer pageSize);

}
