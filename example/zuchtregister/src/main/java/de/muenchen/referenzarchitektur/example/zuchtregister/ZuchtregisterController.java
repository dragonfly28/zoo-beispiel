/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.referenzarchitektur.example.zuchtregister;

import de.muenchen.referenzarchitektur.example.zuchtregister.domain.Tier;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import de.muenchen.referenzarchitektur.example.zuchtregister.repository.TierRepository;

/**
 * REST-API for our <b>Zuchtregister<b>.
 * @author robert.jasny
 */
@RestController
@RequestMapping("/tiere")
public class ZuchtregisterController {

    @Autowired
    private TierRepository repository;

    // GET: http://localhost:35198/tiere
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Tier>> getAllTiere() {
        return new ResponseEntity<>((Collection<Tier>) repository.findAll(), HttpStatus.OK);
    }

    // z.B. GET: http://localhost:35198/tiere/1
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Tier> getTierWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    // z.B. GET: http://localhost:35198/tiere/?zooname=Tierpark Hellabrunn
    @RequestMapping(method = RequestMethod.GET, params = {"zooname"})
    public ResponseEntity<Collection<Tier>> findTiereByZooName(@RequestParam(value = "zooname") String zooName) {
        return new ResponseEntity<>(repository.findByZooName(zooName), HttpStatus.OK);
    }

    // z.B. POST: http://localhost:35198/tiere
    // Im Body:
    // {
    //     "art": "Krokofant",
    //     "familie": "Pelikane",
    //     "geschlecht": "weiblich",
    //     "zooName": "Tierpark Hellabrunn"
    // }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addTier(@RequestBody Tier input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }

}
