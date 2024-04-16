package com.cts.deliveryservice.controller;

import com.cts.deliveryservice.model.ItemAddress;
import com.cts.deliveryservice.model.Package;
import com.cts.deliveryservice.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackageController {

    private final PackageService packageService;

    @Autowired
    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping
    public ResponseEntity<List<Package>> getAllPackages() {
        return new ResponseEntity<>(packageService.getPackages(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Package> getPackageById(@PathVariable String id) {
        return packageService.getPackageById(id)
                .map(pkg -> new ResponseEntity<>(pkg, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Package> createPackage(@RequestBody Package aPackage) {
        return new ResponseEntity<>(packageService.savePackage(aPackage), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable String id) {
        packageService.deletePackage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/courier")
    public ResponseEntity<Void> markItemsAsDelivered(@RequestBody List<ItemAddress> itemAddresses) {
        packageService.markItemsAsDelivered(itemAddresses);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}