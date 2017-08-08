/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.referenzarchitektur.example.zooverwaltung;

import de.muenchen.referenzarchitektur.example.zooverwaltung.domain.ZooRepository;
import de.muenchen.referenzarchitektur.example.zooverwaltung.domain.Zoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Bob
 */
@RestController
@RequestMapping("/")
public class ZooverwaltungController {

    private final ZooRepository zooRepository;

    @Autowired
    ZooverwaltungController(ZooRepository zooRepository) {
        this.zooRepository = zooRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<Zoo> readZoos() {
        return this.zooRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody Zoo input) {
        if (zooRepository.findByZooName(input.getZooName()).isEmpty()) {
            Zoo zoo = zooRepository.save(new Zoo(input.getZooName(), input.getGehege()));
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(zoo.getId()).toUri();

             return ResponseEntity.created(location).build();
        } else {
            return ResponseEntity.noContent().build();
        }

    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{zooId}")
	Zoo readZoo(@PathVariable Long zooId) {
		return this.zooRepository.findOne(zooId);
	}
}
