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
public class Band {
    @Id
    @SequenceGenerator(name="band_seq",sequenceName="band_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="band_seq")
    @Column(name="Band_ID")
    private @NonNull Long bandId;

    private @NonNull String bandname;
    private @NonNull int price;
    private @NonNull String typeMusic;
}
