package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.PackageDto;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.exceptions.PackageException;

import java.util.List;

public interface PackageService {

    PackageDto createPackage(PackageDto packageDto, String key) throws PackageException, LoginException;

    PackageDto viewPackage(Integer packageId, String key) throws PackageException, LoginException;

    List<PackageDto> viewAllPackages(String key) throws PackageException, LoginException;

    PackageDto deletePackage(Integer packageId, String key) throws PackageException, LoginException;
}
