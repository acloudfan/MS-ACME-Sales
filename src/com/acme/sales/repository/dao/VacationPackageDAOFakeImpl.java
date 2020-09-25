package com.acme.sales.repository.dao;

import com.acme.sales.model.CustomerSpecification;
import com.acme.sales.model.VacationPackage;

public class VacationPackageDAOFakeImpl implements VacationPackageDAO{

    /* This is where the database interactions will be Isolated **/
    public VacationPackage createVacationPackage(VacationPackage vacationPackage) {
        return null;
    }


    public VacationPackage getVacationPackage(CustomerSpecification customerSpecification) {
        return null;
    }


    public int deleteVacationPackage(VacationPackage vacationPackage) {
        return 0;
    }


    public int updateVacationPackage(VacationPackage vacationPackage) {
        return 0;
    }
}
