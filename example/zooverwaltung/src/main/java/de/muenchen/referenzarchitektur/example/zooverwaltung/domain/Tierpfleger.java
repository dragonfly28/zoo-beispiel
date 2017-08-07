package de.muenchen.referenzarchitektur.example.zooverwaltung.domain;

import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class represents a Tierpfleger.
 */
@Entity
@Table(name = "tierpfleger")
public class Tierpfleger {

    // ========= //
    // Variables //
    // ========= //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "vorname")
    @NotNull
    private String vorname;

    @Column(name = "nachname")
    @NotNull
    private String nachname;

    @OneToMany(mappedBy = "pfleger")
    private java.util.List<Tier> tiere = new java.util.ArrayList<>();
    
    /**
     * Default Constructor for tierpfleger.
     */
    public Tierpfleger() {
    }

    // =================== //
    // Getters and Setters //
    // =================== //
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public java.util.List<Tier> getTiere() {
        return tiere;
    }

    public void setTiere(java.util.List<Tier> tiere) {
        this.tiere = tiere;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other.getClass() == Tierpfleger.class)) {
            return false;
        }
        if (!super.equals(other)) {
            return false;
        }
        Tierpfleger tierpfleger = (Tierpfleger) other;
        if (getVorname() != null ? !getVorname().equals(tierpfleger.getVorname()) : tierpfleger.getVorname() != null) {
            return false;
        }
        if (getNachname() != null ? !getNachname().equals(tierpfleger.getNachname()) : tierpfleger.getNachname() != null) {
            return false;
        }
        if (getTiere() != null ? !getTiere().equals(tierpfleger.getTiere()) : tierpfleger.getTiere() != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getVorname() != null ? getVorname().hashCode() : 0);
        result = 31 * result + (getNachname() != null ? getNachname().hashCode() : 0);
        result = 31 * result + (getTiere() != null ? getTiere().hashCode() : 0);
        return result;
    }

    /**
     * Returns a String representation for this tierpfleger. The form is:
     * <EntityName>
     * <attribute1_Type> <attribute1_name>: <attribute1_value>
     * <attribute2_Type> <attribute2_name>: <attribute2_value>
     * ...
     */
    @Override
    public String toString() {
        String s = "tierpfleger";
        s += "\nString vorname: " + getVorname();
        s += "\nString nachname: " + getNachname();
        s += "\njava.util.List<Tier> tiere: " + getTiere();
        return s;
    }
}
