package com.cts.deliveryservice.service;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.cts.deliveryservice.model.ItemAddress;
import com.cts.deliveryservice.model.Package;
import com.cts.deliveryservice.repository.PackageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PackageServiceTest {

    @Mock
    private PackageRepository packageRepository;

    @InjectMocks
    private PackageService packageService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPackages() {
        Package aPackage = new Package();
        List<Package> expectedPackages = Arrays.asList(aPackage);

        when(packageRepository.findAll()).thenReturn(expectedPackages);

        List<Package> actualPackages = packageService.getPackages();

        assertEquals(expectedPackages, actualPackages);
    }

    @Test
    public void testGetPackageById() {
        Package aPackage = new Package();
        String id = "1";

        when(packageRepository.findById(id)).thenReturn(Optional.of(aPackage));

        Optional<Package> actualPackage = packageService.getPackageById(id);

        assertEquals(aPackage, actualPackage.orElse(null));
    }

    @Test
    public void testSavePackage() {
        Package aPackage = new Package();

        when(packageRepository.save(aPackage)).thenReturn(aPackage);

        Package actualPackage = packageService.savePackage(aPackage);

        assertEquals(aPackage, actualPackage);
    }

    @Test
    public void testDeletePackage() {
        String id = "1";

        doNothing().when(packageRepository).deleteById(id);

        packageService.deletePackage(id);

        verify(packageRepository, times(1)).deleteById(id);
    }

    @Test
    public void testMarkItemsAsDelivered() {
        List<ItemAddress> itemAddresses = new ArrayList<>();
        ItemAddress itemAddress = new ItemAddress();
        itemAddresses.add(itemAddress);

        // Get the logger belonging to the class
        ch.qos.logback.classic.Logger logger = (Logger) LoggerFactory.getLogger(PackageService.class);

        // Create and start a ListAppender
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();

        // Add the appender to the logger
        logger.addAppender(listAppender);

        // Call the method under test
        packageService.markItemsAsDelivered(itemAddresses);

        // Check the logs
        List<ILoggingEvent> logsList = listAppender.list;
        assertEquals(1, logsList.size());
        assertEquals("Marking items as delivered: " + itemAddresses, logsList.get(0).getFormattedMessage());
        assertEquals(Level.INFO, logsList.get(0).getLevel());
    }
}