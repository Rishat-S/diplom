package ru.netology.netologydiplom.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long size;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] fileBytes;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public File() {
    }
}
