package entities;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "id", updatable = false, nullable = false)
    protected UUID id;

    @Column(name = "deleted")
    protected boolean deleted = false;

    @Column(name = "create_at")
    public Instant createdAt;

    @PrePersist
    public void setCreatedAt() {
        createdAt = Instant.now();
    }

}
