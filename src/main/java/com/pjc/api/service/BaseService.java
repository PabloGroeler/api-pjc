package com.pjc.api.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BaseService {

    protected Specification getSpecification(Specification specification) {
        if (specification == null) {
            return Specification.where(null);
        }

        return specification;
    }

    protected Sort.Direction GetOrder(Integer ordem) {
        switch (ordem) {
            case 0: return Sort.Direction.ASC;
            case 1: return Sort.Direction.DESC;
            default: throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ordenação inválida.");
        }
    }
}
