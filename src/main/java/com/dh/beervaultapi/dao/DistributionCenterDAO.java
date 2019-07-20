package com.dh.beervaultapi.dao;

import com.dh.beervaultapi.domain.DistributionCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@AllArgsConstructor
@Slf4j
public class DistributionCenterDAO {

    private List<DistributionCenter> distributionCenters;

    public List<DistributionCenter> getDistributionCenters() {
        return this.distributionCenters;
    }

    public DistributionCenter getDistributionCenterById(String id) {
        log.debug("Getting DistributionCenter by Id {}", id);
        return distributionCenters.stream().filter(distributionCenter -> id.equals(distributionCenter.getId())).findAny().orElse(null);
    }
}
