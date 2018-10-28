package sut.sa.g13.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Quere {
    @Id
    @SequenceGenerator(name="quere_seq",sequenceName="quere_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="quere_seq")
    @Column(name="Quere_ID")
    private @NonNull Long id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Band.class)
    @JoinColumn(name = "BQ_ID", insertable = true)
    private Band bandQuere;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CQ_ID", insertable = true)
    private Customer customerQuere;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Place.class)
    @JoinColumn(name = "PQ_ID", insertable = true)
    private Place placeQuere;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeWork.class)
    @JoinColumn(name = "TQ_ID", insertable = true)
    private TypeWork typeworkQuere;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Status.class)
    @JoinColumn(name = "SQ_ID", insertable = true)
    private Status statusQuere;
}