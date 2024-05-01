package com.example.demo.servies

import com.example.demo.models.PersonModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMapping
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
}