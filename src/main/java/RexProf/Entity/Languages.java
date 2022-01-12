package RexProf.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "languages")
public class Languages implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_languages;
    private String lang_name;
    @JsonIgnore
    @ManyToOne
    private CompetanceFiles competanceFiles;

    public Long getId_languages() {
        return id_languages;
    }

    public void setId_languages(Long id_languages) {
        this.id_languages = id_languages;
    }

    public String getLang_name() {
        return lang_name;
    }

    public void setLang_name(String lang_name) {
        this.lang_name = lang_name;
    }

    public CompetanceFiles getCompetanceFiles() {
        return competanceFiles;
    }

    public void setCompetanceFiles(CompetanceFiles competanceFiles) {
        this.competanceFiles = competanceFiles;
    }
}
