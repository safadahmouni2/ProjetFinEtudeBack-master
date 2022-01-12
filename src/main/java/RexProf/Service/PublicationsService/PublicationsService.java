package RexProf.Service.PublicationsService;

import RexProf.Entity.Publications;
import RexProf.Entity.Users;
import RexProf.Enum.CompeteEtat;
import RexProf.Repository.AimeRepository;
import RexProf.Repository.PublicationsRepository;
import RexProf.modelDto.PublicationsDto;
import RexProf.modelDto.UsersDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationsService implements IPublicationsService {
    @Autowired
    PublicationsRepository publicationsRepository;
    @Autowired
    private ModelMapper modelMapper ;
    @Autowired
    AimeRepository aimeRepository;
    private PublicationsDto convertToDto(Publications post) {
        PublicationsDto publicationsDto = modelMapper.map(post, PublicationsDto.class);
        return publicationsDto;}


    @Override
    public List<Publications> getAllPub() {
        return (List<Publications>) publicationsRepository.findAll();   }


    @Override
    public List<Publications> getMesPub(long id,Integer pageNo, Integer pageSize) {

            PageRequest paging = PageRequest.of(pageNo, pageSize);

            Page<Publications> pagedResult = publicationsRepository.getMesPub( id,paging);

            if(pagedResult.hasContent()) {
                return pagedResult.getContent();
            } else {
                return new ArrayList<Publications>();
            }

        }


    @Override
    public void addPub(PublicationsDto u) throws IOException {
        Publications p= new Publications();
       // Users uu= new Users();
        p.setUsers(modelMapper.map(u.getUsers(), Users.class));
        p.setAimes(aimeRepository.findNBRAime(p.getUsers().getId()));

        p.setStatus(u.getStatus());
         p.setSignaler(0);
      //  p.setVideo(vd.getBytes());
        p.setStart_date(new Date());
        p.setVisibility(false);

        publicationsRepository.save(p);
    }

    @Override
    public void addPubV( PublicationsDto u,MultipartFile vd) throws IOException {
        Publications p= new Publications();
        p.setStatus(u.getStatus());
        p.setSignaler(0);
        p.setVideo(vd.getBytes());
        p.setStart_date(new Date());
        p.setVisibility(false);
        p.setUsers(modelMapper.map(u.getUsers(), Users.class));
        p.setAimes(aimeRepository.findNBRAime(p.getUsers().getId()));

        publicationsRepository.save(p);
    }

    @Override
    public void addPubI(PublicationsDto u,MultipartFile img) throws IOException {
        Publications p= new Publications();
       p.setStatus(u.getStatus());
        p.setImage(img.getBytes());
        p.setSignaler(0);
        p.setStart_date(new Date());
        p.setVisibility(false);
        p.setUsers(modelMapper.map(u.getUsers(), Users.class));
        p.setAimes(aimeRepository.findNBRAime(p.getUsers().getId()));

        publicationsRepository.save(p);
    }

    @Override
    public void signaler(long id) {
        Publications cc = publicationsRepository.findById(id).get();
        cc.setSignaler(cc.getSignaler()+1);
        cc = publicationsRepository.save(cc);
    }


    @Override
    public void deletePub(long id) {

    }

    @Override
    public PublicationsDto getPub(long id) {
        return null;
    }

    @Override
    public void UpdatePub(PublicationsDto u, MultipartFile img) throws IOException {

    }
    @Override
    public List<PublicationsDto> getAllWord(Integer pageNo, Integer pageSize)
            {
                PageRequest paging = PageRequest.of(pageNo, pageSize);

                Page<Publications> pagedResult = publicationsRepository.findAll( paging);

                List<PublicationsDto> listPublicationsDto=new ArrayList<>();



                //PublicationsDto publicationsDto = modelMapper.map(post, PublicationsDto.class);




                if(pagedResult.hasContent()) {
                    for(Publications pub: pagedResult.getContent()){
                        PublicationsDto publicationsDto = modelMapper.map(pub, PublicationsDto.class);

                        publicationsDto.setLikes(aimeRepository.findLikesOfPub(publicationsDto.getId()));

                        listPublicationsDto.add(publicationsDto);

                    }
            } /*else {
                return new ArrayList<Publications>();
            }*/
                return listPublicationsDto;

        }
}
