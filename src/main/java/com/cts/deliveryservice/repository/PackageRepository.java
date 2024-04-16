package com.cts.deliveryservice.repository;

import com.cts.deliveryservice.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, String> {
}