package de.muenchen.referenzarchitektur.example.zooverwaltung.domain;

import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * This class represents a Tier.
 */
@Entity
@Table(name = "Tier")
public class Tier {

    // ========= //
    // Variables //
    // ========= //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "gehege_id")
    @NotNull
    private Gehege gehege;
    
    @ManyToOne
    @JoinColumn(name = "tierpfleger_id")
    private Tierpfleger pfleger;

    @Column(name = "art")
    @NotNull
    private String art;

    @Column(name = "familie")
    @NotNull
    private String familie;

    @Column(name = "geschlecht")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex geschlecht;

    @Column(name = "rote_liste")
    @NotNull
    private boolean roteListe;

    /**
     * Default Constructor for tier.
     */
    public Tier() {
    }

    // =================== //
    // Getters and Setters //
    // =================== //

    public Gehege getGehege() {
        return gehege;
    }

    public void setGehege(Gehege gehege) {
        this.gehege = gehege;
    }

    public Tierpfleger getPfleger() {
        return pfleger;
    }

    public void setPfleger(Tierpfleger pfleger) {
        this.pfleger = pfleger;
    }
    
    
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

    public boolean isRoteListe() {
        return roteListe;
    }

    public void setRoteListe(boolean roteListe) {
        this.roteListe = roteListe;
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
        if (getGehege()!= null ? !getGehege().equals(tier.getGehege()) : tier.getGehege() != null) {
            return false;
        }
        if (getPfleger()!= null ? !getPfleger().equals(tier.getPfleger()) : tier.getPfleger() != null) {
            return false;
        }
        if (getArt() != null ? !getArt().equals(tier.getArt()) : tier.getArt() != null) {
            return false;
        }
        if (getFamilie() != null ? !getFamilie().equals(tier.getFamilie()) : tier.getFamilie() != null) {
            return false;
        }
        if (getGeschlecht() != tier.getGeschlecht()) {
            return false;
        }
        if (isRoteListe() != tier.isRoteListe()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getGehege() != null ? getGehege().hashCode() : 0);
        result = 31 * result + (getPfleger() != null ? getPfleger().hashCode() : 0);
        result = 31 * result + (getArt() != null ? getArt().hashCode() : 0);
        result = 31 * result + (getFamilie() != null ? getFamilie().hashCode() : 0);
        result = 31 * result + (getGeschlecht() != null ? getGeschlecht().hashCode() : 0);
        result = 31 * result + (isRoteListe() ? 1 : 0);
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
        s += "\n<Gehege> gehege: " + getGehege();
        s += "\n<Pfleger> pfleger: " + getPfleger();
        s += "\nString art: " + getArt();
        s += "\nString familie: " + getFamilie();
        s += "\n<Sex> geschlecht: " + getGeschlecht();
        s += "\nboolean roteListe: " + isRoteListe();
        return s;
    }
}
