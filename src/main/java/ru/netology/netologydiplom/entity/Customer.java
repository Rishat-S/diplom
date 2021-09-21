package ru.netology.netologydiplom.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
public class Customer extends BaseEntity {
    private String login;
    private String email;
    private String name;
    private String surname;
    private String password;

}
