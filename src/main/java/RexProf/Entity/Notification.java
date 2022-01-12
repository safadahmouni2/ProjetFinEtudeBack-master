package RexProf.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notifications")
public class Notification implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;

    private String message;

    private Date createdAt;

    private boolean isRead;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @ManyToOne
    private Users user;
    @OnDelete(action = OnDeleteAction.CASCADE)
@JoinColumn(name = "user_abonne")
    @JsonIgnore
    @ManyToOne
    private Users userAbonne;
}
