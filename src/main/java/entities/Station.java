package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "ss_station")
@Getter
@Setter
@ToString
public class Station extends BaseEntity {
    @Column(name = "time_stamp")
    protected long timeStamp;

    @Column(name = "lat")
    protected float lat;

    @Column(name = "lng")
    protected float lng;
    @Column(name = "title")
    protected String title;
    @OneToMany(mappedBy = "station")
    protected List<People> people;
}
