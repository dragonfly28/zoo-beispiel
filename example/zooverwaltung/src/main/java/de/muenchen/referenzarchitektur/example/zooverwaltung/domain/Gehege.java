package de.muenchen.referenzarchitektur.example.zooverwaltung.domain;

import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * This class represents a Gehege.
 */
@Entity
@Table(name = "Gehege")
public class Gehege {

    // ========= //
    // Variables //
    // ========= //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "gehege_name")
    @NotNull
    private String gehegeName;

    @ManyToOne
    @JoinColumn(name = "zoo_id")
    @NotNull
    private Zoo zoo;
    
    @OneToMany(mappedBy = "gehege")
    private java.util.List<Tier> tiere = new java.util.ArrayList<>();

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
