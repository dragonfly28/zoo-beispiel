package de.muenchen.referenzarchitektur.example.zooverwaltung.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * This class represents a Gehege.
 */
@Entity
public class Gehege {

    // ========= //
    // Variables //
    // ========= //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Zoo zoo;

    @OneToMany(mappedBy = "gehege")
    private Set<Tier> tiere = new HashSet<>();

    private String gehegeName;

    /**
     * Default Constructor for gehege.
     */
    public Gehege() {
    }

    // =================== //
    // Getters and Setters //
    // =================== //
    public String getGehegeName() {
        return gehegeName;
    }

    public void setGehegeName(String gehegeName) {
        this.gehegeName = gehegeName;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other.getClass() == Gehege.class)) {
            return false;
        }
        if (!super.equals(other)) {
            return false;
        }
        Gehege gehege = (Gehege) other;
        if (getGehegeName() != null ? !getGehegeName().equals(gehege.getGehegeName()) : gehege.getGehegeName() != null) {
            return false;
        }
        if (getZoo() != null ? !getZoo().equals(gehege.getZoo()) : gehege.getZoo() != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getGehegeName() != null ? getGehegeName().hashCode() : 0);
        result = 31 * result + (getZoo() != null ? getZoo().hashCode() : 0);
        return result;
    }

    /**
     * Returns a String representation for this gehege. The form is:
     * <EntityName>
     * <attribute1_Type> <attribute1_name>: <attribute1_value>
     * <attribute2_Type> <attribute2_name>: <attribute2_value>
     * ...
     */
    @Override
    public String toString() {
        String s = "gehege";
        s += "\nString gehegeName: " + getGehegeName();
        s += "\n<Zoo> zoo: " + getZoo();
        return s;
    }
}
