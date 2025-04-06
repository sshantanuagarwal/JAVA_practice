package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

enum  AddressType {
    PERMANENT,
    TEMPORARY
}
class Address {
    String doorNo;
    String addressLine;
    String streetName;
    AddressType addressType;

    @Override
    public String toString() {
        return "Address{" +
                "doorNo='" + doorNo + '\'' +
                ", addressLine='" + addressLine + '\'' +
                ", streetName='" + streetName + '\'' +
                ", addressType=" + addressType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(doorNo, address.doorNo) &&
                Objects.equals(streetName, address.streetName) &&
                addressType == address.addressType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(doorNo, streetName, addressType);
    }
}
public class Employee {
    List<Address> addresses;

    public Employee(List<Address> address) {
        this.addresses = address;
    }

    public void isMatch() {
        List<Address> otherAddress = addresses.stream().filter(a -> a.addressType != AddressType.PERMANENT)
                .collect(Collectors.toList());
        Address permanentAddress =  addresses.stream().filter(a -> a.addressType == AddressType.PERMANENT)
                .collect(Collectors.toList()).get(0);
//
//        for (Address address : otherAddress) {
//            if address.equals(permanentAddress);
//        }
    }
}
