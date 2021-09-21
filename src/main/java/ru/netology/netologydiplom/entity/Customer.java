package ru.netology.netologydiplom.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Customer extends BaseEntity {
    private String login;
    private String email;
    private String name;
    private String surname;
    private String password;

}
