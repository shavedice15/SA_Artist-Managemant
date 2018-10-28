package sut.sa.g13.entity;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Band.class)
    @JoinColumn(name = "AB_ID", insertable = true)
    private Band band;
}