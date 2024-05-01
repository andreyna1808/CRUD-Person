package com.example.demo.services

import com.example.demo.models.PersonModel
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {
    private val counter:AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)
    // logger o que está acontecendo na nossa aplicação

    fun findById(id: Long): PersonModel {
        logger.info("Finding one person by id")

        val person = PersonModel()
        person.id = counter.incrementAndGet()
        person.firstName= "Andreyna"
        person.lastName = "Carvalho"
        person.address = "Mato Grosso"
        person.gender = "Female"
        return person
    }

    fun findAll(): List<PersonModel> {
        logger.info("Finding all people")

        val persons: MutableList<PersonModel> = ArrayList()
        for (i in 0..7){
            val person = mockPersonModel(i)
            persons.add(person)
        }
        return persons
    }

    private fun mockPersonModel(i: Int): PersonModel {
        val person = PersonModel()
        person.id = counter.incrementAndGet()
        person.firstName= "First Name $i"
        person.lastName = "Last Name $i"
        person.address = "Some Address in Brazil"
        person.gender = "Female"
        return person
    }
}