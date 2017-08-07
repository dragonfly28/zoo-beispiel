/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.referenzarchitektur.example.zuchtregister.repository;

import de.muenchen.referenzarchitektur.example.zuchtregister.domain.Tier;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author robert.jasny
 */
public interface TierRepository extends CrudRepository<Tier, Long> {

    List<Tier> findByZooName(String zooName);
}
