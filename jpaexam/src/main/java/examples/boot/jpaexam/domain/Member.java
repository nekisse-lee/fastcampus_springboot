package examples.boot.jpaexam.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @Column(name = "join_date")
    private LocalDateTime joinDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="member_member_role",
            joinColumns = @JoinColumn(name = "member_id",
                    referencedColumnName = "id" ),
            inverseJoinColumns = @JoinColumn(name = "member_role_id",
                    referencedColumnName = "id"
            )
    )
    public Set<MemberRole> memberRoles = new HashSet<>();





}
