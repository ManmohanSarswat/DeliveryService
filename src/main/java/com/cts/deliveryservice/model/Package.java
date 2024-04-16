package com.cts.deliveryservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Package {

    @Id
    private String packageId;
    @Embedded
    private Address address;
    @ElementCollection
    private List<Item> items;

    @Override
    public String toString() {
        return "Package{" +
                "packageId='" + packageId + '\'' +
                ", address=" + address +
                ", items=" + items +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return Objects.equals(packageId, aPackage.packageId) &&
                Objects.equals(address, aPackage.address) &&
                Objects.equals(items, aPackage.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageId, address, items);
    }
}