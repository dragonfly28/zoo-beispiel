/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.referenzarchitektur.example.zooverwaltung.repository;

import de.muenchen.referenzarchitektur.example.zooverwaltung.domain.Tier;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface TierRepository extends CrudRepository<Tier, Long> {

}
