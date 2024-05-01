package com.example.demo.services

import br.com.erudio.exceptions.ResourceNotFoundException
import com.example.demo.models.PersonModel
import com.example.demo.repositories.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)
    // logger o que está acontecendo na nossa aplicação

    fun findAll(): List<PersonModel> {
        logger.info("Finding all people")
        return repository.findAll()
    }

    fun findById(id: Long): PersonModel {
        logger.info("Finding one person by id")
        return repository.findById(id).orElseThrow { ResourceNotFoundException("No records found for this ID") }
    }

    fun create(person: PersonModel): PersonModel {
        logger.info("Created one person with name = ${person.firstName}")
        return repository.save(person)
    }

    fun update(person: PersonModel): PersonModel {
        logger.info("Updated one person with id = ${person.id}")
        val entity =
            repository.findById(person.id).orElseThrow { ResourceNotFoundException("No records found for this ID") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return repository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Deleted one person with id = $id")
        val entity = repository.findById(id).orElseThrow { ResourceNotFoundException("No records found for this ID") }
        repository.delete(entity)
    }

}