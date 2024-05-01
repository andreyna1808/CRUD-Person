package com.example.demo.controllers

import com.example.demo.models.PersonModel
import com.example.demo.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var service: PersonService
    // var service: PersonService = PersonService(), faz o mesmo que a linha acima, porém o autowired faz o tratamento necessário

    @RequestMapping(value = ["{id}"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getById(@PathVariable(value = "id") id: Long): PersonModel {
        return service.findById(id)
    }

    @RequestMapping(method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll(): List<PersonModel> {
        return service.findAll()
    }

}