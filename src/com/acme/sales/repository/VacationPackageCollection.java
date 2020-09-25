package com.acme.sales.repository;

import com.acme.sales.model.CustomerSpecification;
import com.acme.sales.model.VacationPackage;

import java.util.List;

/**
 * Pattern: Repository
 * Model: Acme Sales
 * Represents a collection of VacationPackage
 */

public interface VacationPackageCollection {

    // Adds a vacation package to the persistent store
    int  addVacationPackage(VacationPackage vacationPackage);

    // Get a vacation package by name
    VacationPackage getVacationPackage(String name);

    // Lookup vacation packages
    List<VacationPackage> findVacationPackage(CustomerSpecification customerSpecification);

}
