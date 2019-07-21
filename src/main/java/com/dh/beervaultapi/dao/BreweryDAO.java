package com.dh.beervaultapi.dao;

import com.dh.beervaultapi.domain.Brewery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@AllArgsConstructor
@Slf4j
public class BreweryDAO {

    private List<Brewery> breweries;

    public List<Brewery> getBreweries() {
        return this.breweries;
    }

    public Brewery getBreweryById(String id) {
        log.debug("Getting Brewery by Id {}", id);
        return this.breweries.stream().filter(brewery -> id.equals(brewery.getId())).findAny().orElse(null);
    }
}
