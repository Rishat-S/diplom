package ru.netology.netologydiplom.entity;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomersFile extends BaseEntity {
    private String fileName;
    private String path;
    @ManyToOne
    @ToString.Exclude
    private Customer customer;


}
