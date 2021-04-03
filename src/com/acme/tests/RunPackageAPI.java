package com.acme.tests;

import com.acme.products.api.PackageRestAPIController;
import com.acme.products.model.Package;
import com.acme.products.api.PackageFakeRepo;
import com.acme.products.model.PackageRepo;
import org.springframework.boot.SpringApplication;

public class RunPackageAPI {

    public static void main(String[] args){
        // Create a fake repository
        PackageRepo packageRepo = new PackageFakeRepo();
        packageRepo.addPackage(new Package(1001,"BAH03CRUISE","This is a 3 night package","Bahamas",3));
        packageRepo.addPackage(new Package(1002,"BAH07CRUISE","This is a 7 night package","Bahamas",7));
        packageRepo.addPackage(new Package(1003,"DISNEY05RESORT","This is a 5 night get away to Disney in FL","Florida",5));
        packageRepo.addPackage(new Package(1004,"JAMAICA07RESORT","This is a 7 night resort package","Jamaica",7));

//        SpringApplication.run(new PackageRestAPIController(packageRepo), args);
        SpringApplication.run(PackageRestAPIController.class, args);

    }
}
