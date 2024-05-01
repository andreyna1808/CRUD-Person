package com.example.demo.repositories

import com.example.demo.models.PersonModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository<PersonModel, Long?> { // Long é passado pq a chave primaria ID é um Long
}