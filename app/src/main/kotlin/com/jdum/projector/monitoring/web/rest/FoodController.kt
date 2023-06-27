package com.jdum.projector.monitoring.web.rest

import com.fasterxml.jackson.databind.ObjectMapper
import com.jdum.projector.monitoring.config.RestEndpoints.FOOD_PATH
import com.jdum.projector.monitoring.domain.Food
import com.jdum.projector.monitoring.service.FoodService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(FOOD_PATH)
class FoodController(
        private val service: FoodService,
        private val mapper: ObjectMapper
) {
    private val log = LoggerFactory.getLogger(javaClass)


    @GetMapping
    fun getAll(): ResponseEntity<Food> {
        log.debug("Getting food menu")
        return ResponseEntity.ok(service.getAll())
    }

    @PostMapping
    fun add(@RequestBody payload: Food): ResponseEntity<Food> {
        log.debug("Adding food menu: {}", mapper.writeValueAsString(payload))
        return ResponseEntity.ok(service.add(payload))
    }
}
