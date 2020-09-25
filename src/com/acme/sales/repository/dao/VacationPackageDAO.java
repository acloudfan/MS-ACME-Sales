package com.acme.sales.repository.dao;

import com.acme.sales.model.CustomerSpecification;
import com.acme.sales.model.VacationPackage;

import java.util.List;

/**
 * Pattern: Data Access Object
 * Contains the logic for interactions with underlying database
 */
public interface VacationPackageDAO {

    // CRUD operations
    VacationPackage  createVacationPackage(VacationPackage vacationPackage);
    VacationPackage  getVacationPackage(CustomerSpecification customerSpecification);
    int              deleteVacationPackage(VacationPackage vacationPackage);
    int              updateVacationPackage(VacationPackage vacationPackage);

}
