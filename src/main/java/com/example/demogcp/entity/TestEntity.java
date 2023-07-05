package com.example.demogcp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.ToString;

@Entity
@Table(name = "entries")
@ToString
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entryid")
    private Integer entryId;

    @Column(name = "guestname")
    private String guestName;

    @Column(name = "content")
    private String content;

}