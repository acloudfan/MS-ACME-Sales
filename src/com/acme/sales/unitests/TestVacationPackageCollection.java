package com.acme.sales.unitests;

import com.acme.sales.model.VacationPackage;
import com.acme.sales.repository.VacationPackageCollection;

import java.util.List;

/**
 * This is to test the functionality of the collection
 */
public class TestVacationPackageCollection {
    public static void main(String[] args){

        VacationPackageCollection repository = new VacationPackageCollection();

        // Create an instance of the package
//        repository.addVacationPackage(vacationPackage);

        System.out.println(repository.getAllVacationPackage());
    }

    private static void dump(List<VacationPackage> vp){
        for(int i = 0; i < vp.size(); i++){
            System.out.println(vp.get(i));
        }
    }
}
