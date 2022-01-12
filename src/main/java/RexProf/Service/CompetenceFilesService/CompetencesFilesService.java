package RexProf.Service.CompetenceFilesService;

import RexProf.Entity.*;
import RexProf.Repository.*;
import RexProf.modelDto.*;
import RexProf.security.services.UserPrinciple;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CompetencesFilesService implements ICompetencesFilesService {
    @Autowired
    PostuleRepository postuleRepository;
    @Autowired
    CompetancesFilesRepository competancesFilesRepository;
    @Autowired
     SkillsRepository skillsRepository;
    @Autowired
    ExperiencesRepository experiencesRepository;
    @Autowired
    LanguagesRepository languagesRepository;
    @Autowired
    EcoleRepository ecoleRepository;
    @Autowired
    PosteRepository posteRepository;
    @Autowired
    private ModelMapper modelMapper ;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Override
    public void addCompetancesFiles(CompetanceFilesDto c) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       // UserPrinciple user = (UserPrinciple)authentication.getPrincipal();
        //Long userId = user.getId();
        CompetanceFiles cc = new CompetanceFiles();

        cc.setName(c.getName());
        cc.setMail(c.getMail());
        cc.setPhone(c.getPhone());
        cc.setDate(new Date());
        cc.setUsers(c.getUsers());


        cc = competancesFilesRepository.save(cc);
        for(String poste : c.getPoste()) {
            Poste s = new Poste();
            s.setName(poste);
            s.setCompetanceFiles(cc);
            posteRepository.save(s);
        }
        for(String ecole : c.getEcole()) {
            Ecole s = new Ecole();
            s.setName(ecole);
            s.setCompetanceFiles(cc);
            ecoleRepository.save(s);
        }
        for(String skill : c.getSkills()) {
            Skills s = new Skills();



            s.setName(skill);
            s.setCompetanceFiles(cc);
            skillsRepository.save(s);
        }
        for (String experiences : c.getExperiences()) {
            Experiences e = new Experiences();
            e.setTitle(experiences);
            e.setCompetanceFiles(cc);
            experiencesRepository.save(e);
        }

        for (String languages : c.getLanguages()) {
                Languages l = new Languages();

                l.setLang_name(languages);
                l.setCompetanceFiles(cc);
                languagesRepository.save(l);
            }

    }
    private CompetanceFilesWithSkillsDto convertToDto(CompetanceFiles post) {
        CompetanceFilesWithSkillsDto postDto = modelMapper.map(post, CompetanceFilesWithSkillsDto.class);
        return postDto;
    }
    private CompetanceFilesSkillsDto convertToDtoo(CompetanceFiles post) {
        CompetanceFilesSkillsDto SkillsDto = modelMapper.map(post, CompetanceFilesSkillsDto.class);
        return  SkillsDto;
    }
    @Override
    public List<CompetanceFilesSkillsDto> getCompetancesFilesSkills() {
        //return modelMapper.map(competancesFilesRepository.getALl() , (Type) CompetanceFilesSkillsDto.class);
        return (competancesFilesRepository.getALl()).stream()
                .map(this::convertToDtoo)
                .collect(Collectors.toList());
    }
    private PostuleDTO convertToDTO(Postule post) {
        PostuleDTO postule = modelMapper.map(post, PostuleDTO.class);
        return  postule;}
    @Override
    public List<Object[]> getAllCompetancesFiles(long id) {
        //return modelMapper.map(competancesFilesRepository.getALl() , (Type) CompetanceFilesSkillsDto.class);
        List<Object[]>  list= postuleRepository.getCvOfPost(id);

        return list;
    }

    /* @Override
    public List<Postule> getAllCompetancesFiles(long id, Integer pageNo, Integer pageSize ) {

        PageRequest paging = PageRequest.of(pageNo, pageSize);

        Page<Postule> pagedResult = postuleRepository.getCvOfPost( id,paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Postule>();
        }
    }*/
    @Override
    public List<CompetanceFilesWithSkillsDto> getMyCompetancesFiles(long id) {

        return (competancesFilesRepository.getMine(id)).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void accept(long id) {
        Postule p = postuleRepository.findById(id).get();
        p.setSelected(1);
        postuleRepository.save(p);
    }

    @Override
    public void reffuse(long id) {
        Postule p = postuleRepository.findById(id).get();
        p.setSelected(2);
        postuleRepository.save(p);
    }




    @Override
    public void UpdateCompetancesFiles(CompetanceFilesWithSkillsDto c) {
        CompetanceFiles cc = competancesFilesRepository.findById(c.getId()).get();

        cc.setName(c.getName());
        cc.setMail(c.getMail());
        cc.setPhone(c.getPhone());
        cc.setDate(new Date());
        competancesFilesRepository.save(cc);

        for(PosteDto poste : c.getPoste()) {
            Poste s = new Poste();


            if(poste.getId()==0 ){

                s.setName(poste.getName());
                s.setCompetanceFiles(cc);

            posteRepository.save(s);
            }else{
                if(poste.isDelete()){
                    //s.setId(poste.getId());
                    posteRepository.deleteById(poste.getId());
                }
            }
        }
        for(EcoleDto ecole : c.getEcole()) {
            Ecole s = new Ecole();

            if(ecole.getId()==0 ){


            s.setName(ecole.getName());
            s.setCompetanceFiles(cc);
            ecoleRepository.save(s);
            }else {if(ecole.isDelete()){
                ecoleRepository.deleteById(ecole.getId());
            }
            }
        }
        for(SkillsDto skill : c.getSkills()) {
            Skills s = new Skills();

            if(skill.getId()==0 ){


            s.setName(skill.getName());
            s.setCompetanceFiles(cc);
            skillsRepository.save(s);}
            else{
                if(skill.isDelete()){
                    //s.setId(poste.getId());
                    skillsRepository.deleteById(skill.getId());
                }
            }
        }
        for (ExperienceDto experiences : c.getExperiences()) {
            Experiences e = new Experiences();

            if(experiences.getId()==0 ){
            e.setTitle(experiences.getTitle());
            e.setCompetanceFiles(cc);
            experiencesRepository.save(e);}
            else{
                if(experiences.isDelete()){
                    //s.setId(poste.getId());
                    experiencesRepository.deleteById(experiences.getId());
                }
            }
        }

       for (LanguagesDto languages : c.getLanguages()) {
            Languages l = new Languages();

            if(languages.getId()==0 ){

            l.setLang_name(languages.getLang_name());
            l.setCompetanceFiles(cc);
            languagesRepository.save(l);}
            else{
                if(languages.isDelete()){
                    //s.setId(poste.getId());
                    languagesRepository.deleteById(languages.getId());
                }
            }
        }

    }
    @Override
    public CompetanceFilesWithSkillsDto getCV(long id) {
        return modelMapper.map(competancesFilesRepository.findbyId(id) , CompetanceFilesWithSkillsDto.class);



    }

    @Override
    public List<String> getskills(long id) {
        return skillsRepository.findskills(id);

    }


    @Override
    public void deleteCompetancesFiles(long id) {

        competancesFilesRepository.deleteById(id);

    }





}
