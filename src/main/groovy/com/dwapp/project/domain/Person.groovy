package com.dwapp.project.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by Mohsan on 03-05-2014.
 */
@Entity
@Table(name = "person")
class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    @Column(name = "name", nullable = false)
    String name

    @Column(name = "age", nullable = false)
    int age
}
