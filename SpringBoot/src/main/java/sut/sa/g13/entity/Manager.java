package sut.sa.g13.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Manager {
    @Id
    @SequenceGenerator(name="manager_seq",sequenceName="manager_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="manager_seq")
    @Column(name="Manager_ID")
    private @NonNull  Long id;

    private @NonNull  String username;
    private @NonNull String password;
    private @NonNull  String managerName;
    private  String email;
    private  String tel;
}
