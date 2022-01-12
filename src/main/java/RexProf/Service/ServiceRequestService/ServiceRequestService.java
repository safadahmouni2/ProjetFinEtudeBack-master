package RexProf.Service.ServiceRequestService;

import RexProf.Entity.*;
import RexProf.Repository.CompetancesFilesRepository;
import RexProf.Repository.MatchingRepository;
import RexProf.Repository.PostuleRepository;
import RexProf.Repository.ServicesRequestRepository;
import RexProf.modelDto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class ServiceRequestService implements IServiceRequestService {


    @Autowired
    CompetancesFilesRepository competancesFilesRepository;
    @Autowired
    ServicesRequestRepository requestRepository;
    @Autowired
    MatchingRepository matchingRepository;
    @Autowired
    PostuleRepository postuleRepository;
    @Autowired
    private ModelMapper modelMapper ;




    private ServiceRequestDto convertToDto(ServiceRequest serviceRequest) {
        ServiceRequestDto requestDto = modelMapper.map(serviceRequest, ServiceRequestDto.class);
        return requestDto;}
    @Override
    public List<ServiceRequest> getAlldem(Integer pageNo, Integer pageSize)
    {
        PageRequest paging = PageRequest.of(pageNo, pageSize);

        Page<ServiceRequest> pagedResult = requestRepository.findAll( paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ServiceRequest>();
        }

    }
    @Override
    public List<ServiceRequest> getMesDem(long id,Integer pageNo, Integer pageSize) {
        PageRequest paging = PageRequest.of(pageNo, pageSize);

        Page<ServiceRequest> pagedResult = requestRepository.getMesDem( id,paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ServiceRequest>();
        }
    }
    @Override
    public List<matchingOffre> getMesDemMatche(long id,Integer pageNo, Integer pageSize) {
        PageRequest paging = PageRequest.of(pageNo, pageSize);

        Page<matchingOffre> pagedResult = matchingRepository.getMesDemMatche( id,paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<matchingOffre>();
        }
    }

    @Override
    public List<Postule> getMesPostule(long id, Integer pageNo, Integer pageSize) {
        PageRequest paging = PageRequest.of(pageNo, pageSize);

        Page<Postule> pagedResult = postuleRepository.getMesPostule( id,paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Postule>();
        }
    }

    @Override
    public long addSer(ServiceRequestDto s) {
    ServiceRequest ss = new ServiceRequest();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = s.getClosing_date();
        Date secondDate = s.getStart_date();

        int diffInMillies = (int) Math.abs(secondDate.getTime() - firstDate.getTime());
        int diff = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);


        ss.setVisibility(false);
        ss.setEnable(true);
        ss.setTitle(s.getTitle());
        ss.setDescription(s.getDescription());
        ss.setLink(s.getLink());
        ss.setDuration(diff);
        ss.setStart_date(s.getStart_date());
        ss.setClosing_date(s.getClosing_date());
        ss.setDateCreation(new Date());
        ss.setUser(s.getUsers());
        ServiceRequest x=requestRepository.save(ss);
        //return requestRepository.findIdDemande(ss.getId());
        return ss.getId();

    }

    @Override
    public void deleteSer(long id) {

    }

    @Override
    public ServiceRequestDto getSer(long id) {
        return modelMapper.map(requestRepository.findbyId(id) , ServiceRequestDto.class);
    }

    @Override
    public void UpdateSer(ServiceRequestDto s) {

    }
    @Override
    public void affectation(inputPostuleDto g ) {
        Postule postule=new Postule();
        postule.setServiceRequest(requestRepository.findById(g.getServId()).get());
        postule.setCompetanceFiles(competancesFilesRepository.findById(g.getCompId()).get());
        postuleRepository.save(postule);


    }

    @Override
    public List<matchingOffre> getdemMatching(Integer pageNo, Integer pageSize) {
        PageRequest paging = PageRequest.of(pageNo, pageSize);

        Page<matchingOffre> pagedResult = matchingRepository.findAll( paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<matchingOffre>();
        }
    }
}
