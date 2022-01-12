package RexProf.security.services;

import RexProf.Entity.Groups;
import RexProf.Entity.Roles;
import RexProf.Entity.Users;
import RexProf.Enum.CompeteEtat;
import RexProf.Repository.GroupsRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;
@Getter
@Setter
public class UserPrinciple implements UserDetails {
    @Autowired
    private static GroupsRepository groupsRepository;
	private static final long serialVersionUID = 1L;

	private Long id;
   private String name_user;
    private String first_name;
    private String email;
    private String title;
    private String login;
    @JsonIgnore
    private String pwd;
    private String gender;
    private int age;
    private String phone;
    private Date date_birth;
    private CompeteEtat etat;

    private byte[]  picture;
    private Collection<? extends GrantedAuthority> authorities;




    public UserPrinciple(Long id, String name_user, String first_name, String email,
                         String title, String login, String pwd, String gender,
                         int age, String phone, Date date_birth,
                         CompeteEtat etat, byte[] picture, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name_user = name_user;
        this.first_name = first_name;
        this.email = email;
        this.title = title;
        this.login = login;
        this.pwd = pwd;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.date_birth = date_birth;
        this.etat = etat;
        this.picture = picture;
        this.authorities = authorities;
    }

    public static UserPrinciple build(Users user) {
        System.out.println(".?????§§§§§§§§§§§§§§§§§§§§§§§§§§§" + user.getName_user());

        Set<Roles> roles = new HashSet<>();
      Set<Groups> group = user.getGroups();
        System.out.println(".?????§§§§§§§§§§§§§§§§§§§§§§§§§§§" + group.size());

        for (Groups g : group){
            System.out.println(".?????§§§§§§§§§§§§§§§§§§§§§§§§§§§" + g.getName_grp());
            for (Roles r: g.getRoles()){
                roles.add(r);
            }
        }

        List<GrantedAuthority> authorities =
                roles.stream().map(role ->
                new SimpleGrantedAuthority(role.getName_roles())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                user.getId(),
                user.getName_user(),
                user.getFirst_name(),
                user.getEmail(),
                user.getTitle(),
                user.getLogin(),
                user.getPwd(),
                user.getGender(),
                user.getAge(),
                user.getPhone(),
                user.getDate_birth(),
                user.getEtat(),
                user.getPicture(),

                authorities
        );
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return pwd;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}