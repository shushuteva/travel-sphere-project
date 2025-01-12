package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.PackageDto;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.exceptions.PackageException;
import com.travelsphere.travelsphere.mapper.PackageMapper;
import com.travelsphere.travelsphere.model.CurrentSession;
import com.travelsphere.travelsphere.model.Package;
import com.travelsphere.travelsphere.repository.PackageRepo;
import com.travelsphere.travelsphere.repository.SessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageRepo packageRepo;

    @Autowired
    private SessionRepo sessionRepo;

    @Autowired
    private PackageMapper packageMapper;

    @Override
    public PackageDto createPackage(PackageDto packageDto, String key) throws PackageException, LoginException {
        validateAdminSession(key);

        Package newPackage = packageMapper.toEntity(packageDto);
        Package savedPackage = packageRepo.save(newPackage);

        return packageMapper.toDto(savedPackage);
    }

    @Override
    public PackageDto viewPackage(Integer packageId, String key) throws PackageException, LoginException {
        validateAdminSession(key);

        Package pack = packageRepo.findById(packageId).orElseThrow(() ->
                new PackageException("No package found with ID: " + packageId));

        return packageMapper.toDto(pack);
    }

    @Override
    public List<PackageDto> viewAllPackages(String key) throws PackageException, LoginException {
        validateAdminSession(key);

        List<Package> packages = packageRepo.findAll();
        if (packages.isEmpty()) {
            throw new PackageException("No packages available");
        }

        return packages.stream().map(packageMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PackageDto deletePackage(Integer packageId, String key) throws PackageException, LoginException {
        validateAdminSession(key);

        Package pack = packageRepo.findById(packageId).orElseThrow(() ->
                new PackageException("No package found with ID: " + packageId));

        packageRepo.delete(pack);

        return packageMapper.toDto(pack);
    }

    private void validateAdminSession(String key) throws LoginException {
        CurrentSession currentSession = sessionRepo.findByUuid(key).orElseThrow(() ->
                new LoginException("Invalid session key"));

        if (!"ADMIN".equals(currentSession.getUserType())) {
            throw new LoginException("You are not authorized");
        }
    }
}
