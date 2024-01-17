package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ss_people")
@Getter @Setter @ToString
public class People extends BaseEntity {

    @Column(name = "full_name")
    protected String fullName;

    @Column(name = "station_id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    protected UUID stationId;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "station_id")
    protected Station station;
}
