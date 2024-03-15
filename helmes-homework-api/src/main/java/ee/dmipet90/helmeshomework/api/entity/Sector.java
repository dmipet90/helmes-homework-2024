package ee.dmipet90.helmeshomework.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sector")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private long id;

    @Column(unique = true)
    private String sectorId;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sector parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private Set<Sector> children;

    @ManyToMany(mappedBy = "sectors")
    private Set<User> users = new HashSet<>();
}
