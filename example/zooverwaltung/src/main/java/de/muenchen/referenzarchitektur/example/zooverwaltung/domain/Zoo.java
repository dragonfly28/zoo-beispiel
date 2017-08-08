package de.muenchen.referenzarchitektur.example.zooverwaltung.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class represents a Zoo.
 */
@Entity
public class Zoo {

    // ========= //
    // Variables //
    // ========= //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String zooName;

    @OneToMany(mappedBy = "zoo")
    private Set<Gehege> gehege = new HashSet<>();

    /**
     * Default Constructor for zoo.
     */
    public Zoo() {
    }
    
    public Zoo(String zooName, Set<Gehege> gehege) {
        this.zooName = zooName;
        this.gehege = gehege;
    }

    // =================== //
    // Getters and Setters //
    // =================== //
    public Long getId() {
        return id;
    }
    
    public String getZooName() {
        return zooName;
    }

    public void setZooName(String zooName) {
        this.zooName = zooName;
    }

    public Set<Gehege> getGehege() {
        return gehege;
    }

    public void setGehege(Set<Gehege> gehege) {
        this.gehege = gehege;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other.getClass() == Zoo.class)) {
            return false;
        }
        if (!super.equals(other)) {
            return false;
        }
        Zoo zoo = (Zoo) other;
        if (getZooName() != null ? !getZooName().equals(zoo.getZooName()) : zoo.getZooName() != null) {
            return false;
        }
        if (getGehege() != null ? !getGehege().equals(zoo.getGehege()) : zoo.getGehege() != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getZooName() != null ? getZooName().hashCode() : 0);
        result = 31 * result + (getGehege() != null ? getGehege().hashCode() : 0);
        return result;
    }

    /**
     * Returns a String representation for this zoo. The form is:
     * <EntityName>
     * <attribute1_Type> <attribute1_name>: <attribute1_value>
     * <attribute2_Type> <attribute2_name>: <attribute2_value>
     * ...
     */
    @Override
    public String toString() {
        String s = "zoo";
        s += "\nString zooName: " + getZooName();
        s += "\nSet<Gehege> gehege: " + getGehege();
        return s;
    }
}
