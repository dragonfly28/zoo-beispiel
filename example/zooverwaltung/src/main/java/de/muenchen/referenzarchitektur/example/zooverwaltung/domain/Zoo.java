package de.muenchen.referenzarchitektur.example.zooverwaltung.domain;

import javax.persistence.CascadeType;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class represents a Zoo.
 */
@Entity
@Table(name = "Zoo")
public class Zoo {

    // ========= //
    // Variables //
    // ========= //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "zoo_name")
    @NotNull
    private String zooName;

    @OneToMany(mappedBy = "zoo")
    private java.util.List<Gehege> gehege = new java.util.ArrayList<>();

    /**
     * Default Constructor for zoo.
     */
    public Zoo() {
    }

    // =================== //
    // Getters and Setters //
    // =================== //
    public String getZooName() {
        return zooName;
    }

    public void setZooName(String zooName) {
        this.zooName = zooName;
    }

    public java.util.List<Gehege> getGehege() {
        return gehege;
    }

    public void setGehege(java.util.List<Gehege> gehege) {
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
        s += "\njava.util.List<Gehege_> gehege: " + getGehege();
        return s;
    }
}
