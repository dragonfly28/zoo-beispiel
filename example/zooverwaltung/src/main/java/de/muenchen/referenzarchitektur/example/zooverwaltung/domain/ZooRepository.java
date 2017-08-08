/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.referenzarchitektur.example.zooverwaltung.domain;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Bob
 */
public interface ZooRepository extends JpaRepository<Zoo, Long> {

    Collection<Zoo> findByZooName(String zooName);
}
