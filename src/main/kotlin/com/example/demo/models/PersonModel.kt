package com.example.demo.models

import jakarta.persistence.*

@Entity
@Table(name = "person")
data class PersonModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "first_name", nullable = false, length = 80) // Isso significa que será um campo obrigatório
    var firstName: String = "",

    @Column(name = "last_name", nullable = false, length = 80) // length limita o tamanho de caracteres
    var lastName: String = "",

    @Column
    var address: String = "",

    @Column(nullable = false)
    var gender: String = "",
)