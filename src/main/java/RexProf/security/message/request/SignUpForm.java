package RexProf.security.message.request;

import RexProf.Entity.Groups;
import RexProf.Enum.CompeteEtat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
@Getter
@Setter
public class SignUpForm {
    private long id;

    private String name_user;
    private String first_name;
    private String email;
    private String title;
    private String login;
    private String pwd;
    private String pays;

    private String gender;
    private int age;
    private String phone;
    private Date date_birth;
    private String description;
  //  private CompeteEtat etat;
  private Set<Groups> groups;
    private byte[] picture;
}