package com.example.demo.controllers

import com.example.demo.models.PersonModel
import com.example.demo.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/person")
class PersonController {

    @Autowired
    private lateinit var service: PersonService
    // var service: PersonService = PersonService(), faz o mesmo que a linha acima, porém o autowired faz o tratamento necessário

    @GetMapping()
    fun getAll(): List<PersonModel> {
        return service.findAll()
    }

    @GetMapping(value = ["{id}"])
    fun getById(@PathVariable(value = "id") id: Long): PersonModel {
        return service.findById(id)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody person: PersonModel): PersonModel {
        return service.create(person)
    }

    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody person: PersonModel): PersonModel {
        return service.update(person)
    }

    @DeleteMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}