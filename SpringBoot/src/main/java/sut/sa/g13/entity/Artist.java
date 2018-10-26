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
public class Artist {
    @Id
    @SequenceGenerator(name="artist_seq",sequenceName="artist_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="artist_seq")
    @Column(name="Artist_ID")
    private @NonNull Long artistId;

    private @NonNull String artistname;
    private @NonNull int price;
    private @NonNull String typeMusic;
}