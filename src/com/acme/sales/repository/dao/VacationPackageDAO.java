package com.acme.sales.repository.dao;

import com.acme.sales.model.CustomerSpecification;
import com.acme.sales.model.VacationPackage;

import java.util.List;

/**
 * Pattern: Data Access Object
 * Contains the logic for interactions with underlying database
 */
public interface VacationPackageDAO {

    /* Creates the vacation package */
    VacationPackage  createVacationPackage(VacationPackage vacationPackage);

    /* Returns the vacation packages that are active **/
    List<VacationPackage>  retrieveActiveVacationPackage();

    /* Delete the specified package **/
    int              deleteVacationPackage(VacationPackage vacationPackage);

    /* Update the Vacation package */
    int              updateVacationPackage(VacationPackage vacationPackage);

}
