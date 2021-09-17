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
public class Customer extends BaseEntity{
    @Column
    private String login;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String role;

}
