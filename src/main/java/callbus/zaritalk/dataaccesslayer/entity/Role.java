package callbus.zaritalk.dataaccesslayer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity {

    public enum ERole {
        ROLE_USER,
        ROLE_ADMIN
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private ERole name;
}