package com.dh.beervaultapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dh.beervaultapi.dao.DistributionCenterDAO;
import com.dh.beervaultapi.domain.DistributionCenter;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DistributionCenterQueryResolver implements GraphQLQueryResolver {
    private DistributionCenterDAO distributionCenterDao;

    public List<DistributionCenter> distributionCenters() {
        return this.distributionCenterDao.getDistributionCenters();
    }
}
