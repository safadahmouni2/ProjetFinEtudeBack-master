package RexProf.Entity;

import RexProf.Enum.CompeteEtat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "users",uniqueConstraints = {
        @UniqueConstraint(columnNames = {
        "email"
        })})
public class Users implements UserDetails {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Transient
    private String token;
    private String name_user;
    private String first_name;
    private String email;
    private String title;
    private String login;
    private String pwd;
    private String gender;
    private int age;
    private String pays;
    private String phone;
    private Date date_birth;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private CompeteEtat etat;
    @Temporal(TemporalType.DATE)
    private Date last_connexion;
    private byte[] picture;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @OneToMany(cascade = {
            CascadeType.ALL
    },mappedBy = "users")
    private Set<matchingOffre> matchingOffres;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @OneToMany(cascade = {
            CascadeType.ALL
    },mappedBy = "users")
    private Set<Commentaire> commentaire;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @OneToMany(cascade = {
            CascadeType.ALL
    },mappedBy = "users")
    private Set<Aime> aime;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @ManyToMany(cascade = {
            CascadeType.ALL
    },mappedBy = "users")
    private Set<Groups> groups;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="users",fetch=FetchType.LAZY)
    private Set<CompetanceFiles> competanceFiles;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="users",fetch=FetchType.LAZY)
    private Set<Publications> publications;
    //*******jointure table elle meme*********

    //id_abonnee
    //id_abonnement
   /*@ManyToOne(optional = true, fetch = FetchType.LAZY)

    @JoinTable(name = "Abonnees",
            joinColumns = { @JoinColumn(name = "id_abonnee", referencedColumnName = "id", insertable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "prestataire", referencedColumnName = "id", insertable = false, updatable = false) } )
    private Users user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Abonnees",
            joinColumns = { @JoinColumn(name = "id_abonnee", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "prestataire", referencedColumnName = "id") } )
    private List<Users> users;*/

    //*******jointure table elle meme*********
    @Transient
     private Collection<? extends GrantedAuthority> authorities;

    public Users() {

    }
    public Users(Long id, String name_user, String first_name, String email,
                         String title, String login, String pwd, String gender,
                         int age, String phone, Date date_birth,String description,
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
        this.description = description;
        this.etat = etat;
        this.picture = picture;
        this.authorities = authorities;
    }

    public static Users build(Users user) {
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

        return new Users(
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
                user.getDescription(),
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

