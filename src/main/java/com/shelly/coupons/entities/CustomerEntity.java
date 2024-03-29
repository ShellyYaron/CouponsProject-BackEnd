package com.shelly.coupons.entities;

import com.shelly.coupons.dto.Customer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
@Setter
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "amount_of_children", nullable = false)
    private int amountOfChildren;
    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "customerEntity", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<PurchaseEntity> purchaseEntities;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId
    private UserEntity userEntity;

    public static CustomerEntity from(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setUserEntity(UserEntity.from(customer.getUser()));
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setAmountOfChildren(customer.getAmountOfChildren());
        return customerEntity;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", amountOfChildren=" + amountOfChildren +
                ", address='" + address + '\'' +
                ", purchaseEntities=" + purchaseEntities +
                ", userEntity=" + userEntity +
                '}';
    }
}
