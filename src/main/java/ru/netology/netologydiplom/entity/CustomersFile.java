package ru.netology.netologydiplom.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@ToString
public class CustomersFile extends BaseEntity {
    private String fileName;
    private String path;
    @ManyToOne
    @ToString.Exclude
    private Customer customer;


}
