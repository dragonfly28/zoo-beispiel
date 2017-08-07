package de.muenchen.referenzarchitektur.example.zuchtregister.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class represents a Tier.
 */
@Entity
@Table(name = "tier")
public class Tier {

    // ========= //
    // Variables //
    // ========= //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "art")
    @NotNull
    @Size(min = 2, max = 30)
    private String art;

    @Column(name = "familie")
    @NotNull
    @Size(min = 2, max = 30)
    private String familie;

    @Column(name = "geschlecht")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex geschlecht;

    @Column(name = "zoo_name")
    @NotNull
    @Size(min = 2, max = 30)
    private String zooName;

    /**
     * Default Constructor for tier.
     */
    public Tier() {
    }

    // =================== //
    // Getters and Setters //
    // =================== //
    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getFamilie() {
        return familie;
    }

    public void setFamilie(String familie) {
        this.familie = familie;
    }

    public Sex getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(Sex geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getZooName() {
        return zooName;
    }

    public void setZooName(String zooName) {
        this.zooName = zooName;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other.getClass() == Tier.class)) {
            return false;
        }
        if (!super.equals(other)) {
            return false;
        }
        Tier tier = (Tier) other;
        if (getArt() != null ? !getArt().equals(tier.getArt()) : tier.getArt() != null) {
            return false;
        }
        if (getFamilie() != null ? !getFamilie().equals(tier.getFamilie()) : tier.getFamilie() != null) {
            return false;
        }
        if (getGeschlecht() != tier.getGeschlecht()) {
            return false;
        }
        if (getZooName() != null ? !getZooName().equals(tier.getZooName()) : tier.getZooName() != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getArt() != null ? getArt().hashCode() : 0);
        result = 31 * result + (getFamilie() != null ? getFamilie().hashCode() : 0);
        result = 31 * result + (getGeschlecht() != null ? getGeschlecht().hashCode() : 0);
        result = 31 * result + (getZooName() != null ? getZooName().hashCode() : 0);
        return result;
    }

    /**
     * Returns a String representation for this tier. The form is:
     * <EntityName>
     * <attribute1_Type> <attribute1_name>: <attribute1_value>
     * <attribute2_Type> <attribute2_name>: <attribute2_value>
     * ...
     */
    @Override
    public String toString() {
        String s = "tier";
        s += "\nString art:     " + getArt();
        s += "\nString familie: " + getFamilie();
        s += "\nSex geschlecht: " + getGeschlecht();
        s += "\nString zooName: " + getZooName();
        return s;
    }
}
