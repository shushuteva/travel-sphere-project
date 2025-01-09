package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.exceptions.*;
import com.travelsphere.travelsphere.model.Package;

import java.util.List;

public interface PackageService {

    public Package createPackage(Package pack,String key) throws PackageException, RouteException, LoginException ;

    public Package searchPackage(Integer packageId) throws PackageException;

    public List<Package> viewAllPackages() throws PackageException;

}
