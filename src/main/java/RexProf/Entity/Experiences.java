package RexProf.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "experiences")
public class Experiences implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_experiences;
    private String title;
    @JsonIgnore
    @ManyToOne
    private CompetanceFiles competanceFiles;

    public Long getId_experiences() {
        return id_experiences;
    }

    public void setId_experiences(Long id_experiences) {
        this.id_experiences = id_experiences;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CompetanceFiles getCompetanceFiles() {
        return competanceFiles;
    }

    public void setCompetanceFiles(CompetanceFiles competanceFiles) {
        this.competanceFiles = competanceFiles;
    }
}
