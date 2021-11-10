package ru.netology.netologydiplom.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
public class TokenBlacklist {

    @Id
    private String token;
}