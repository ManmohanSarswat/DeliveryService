package com.cts.deliveryservice.service;

import com.cts.deliveryservice.model.ItemAddress;
import com.cts.deliveryservice.model.Package;
import com.cts.deliveryservice.repository.PackageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PackageService {

    private final PackageRepository packageRepository;

    @Autowired
    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public List<Package> getPackages() {
        return packageRepository.findAll();
    }

    public Optional<Package> getPackageById(String id) {
        return packageRepository.findById(id);
    }

    public Package savePackage(Package aPackage) {
        return packageRepository.save(aPackage);
    }

    public void deletePackage(String id) {
        packageRepository.deleteById(id);
    }

    public void markItemsAsDelivered(List<ItemAddress> itemAddresses) {
        // Implement your logic here to mark the items as delivered
        log.info("Marking items as delivered: " + itemAddresses);
    }
}