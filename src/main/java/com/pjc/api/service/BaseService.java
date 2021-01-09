package com.pjc.api.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public class BaseService {

    protected Specification getSpecification(Specification specification) {
        if (specification == null) {
            return Specification.where(null);
        }

        return specification;
    }

    protected Sort.Direction GetOrder(Integer ordem) {
        if (ordem != null && ordem == 1) {
            return Sort.Direction.DESC;
        }

       return Sort.Direction.ASC;
    }
}
