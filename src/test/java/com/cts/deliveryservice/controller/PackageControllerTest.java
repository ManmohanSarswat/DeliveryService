package com.cts.deliveryservice.controller;

import com.cts.deliveryservice.model.ItemAddress;
import com.cts.deliveryservice.model.Package;
import com.cts.deliveryservice.service.PackageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class PackageControllerTest {

    @Mock
    private PackageService packageService;

    @InjectMocks
    private PackageController packageController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPackages() {
        Package aPackage = new Package();
        List<Package> expectedPackages = Arrays.asList(aPackage);

        when(packageService.getPackages()).thenReturn(expectedPackages);

        ResponseEntity<List<Package>> response = packageController.getAllPackages();

        assertEquals(expectedPackages, response.getBody());
    }

    @Test
    public void testGetPackageById() {
        Package aPackage = new Package();
        String id = "1";

        when(packageService.getPackageById(id)).thenReturn(Optional.of(aPackage));

        ResponseEntity<Package> response = packageController.getPackageById(id);

        assertEquals(aPackage, response.getBody());
    }

    @Test
    public void testCreatePackage() {
        Package aPackage = new Package();

        when(packageService.savePackage(aPackage)).thenReturn(aPackage);

        ResponseEntity<Package> response = packageController.createPackage(aPackage);

        assertEquals(aPackage, response.getBody());
    }

    @Test
    public void testDeletePackage() {
        String id = "1";

        doNothing().when(packageService).deletePackage(id);

        ResponseEntity<Void> response = packageController.deletePackage(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void testMarkItemsAsDelivered() {
        List<ItemAddress> itemAddresses = new ArrayList<>();
        ItemAddress itemAddress = new ItemAddress();
        itemAddresses.add(itemAddress);

        doNothing().when(packageService).markItemsAsDelivered(itemAddresses);

        ResponseEntity<Void> response = packageController.markItemsAsDelivered(itemAddresses);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}