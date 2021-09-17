package ru.netology.netologydiplom.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
public class CustomersFile extends BaseEntity {
    @Column
    private String fileName;
    @Column
    private String path;
    @Column
    private String owner;


}
