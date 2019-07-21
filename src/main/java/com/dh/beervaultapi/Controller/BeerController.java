package com.dh.beervaultapi.Controller;

import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.domain.Beer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BeerController {

    private BeerDAO beerDao;

    public BeerController(BeerDAO beerDao) {
        this.beerDao = beerDao;
    }

    @GetMapping("/beers")
    public List<Beer> getBeers() {
        return this.beerDao.getBeers();
    }

    @GetMapping("/beers/{beerId}")
    public Beer getBeerById(@PathVariable String beerId) {
        return this.beerDao.getBeerById(beerId);
    }
}
