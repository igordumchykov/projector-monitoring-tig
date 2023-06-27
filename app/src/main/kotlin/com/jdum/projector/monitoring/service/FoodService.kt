package com.jdum.projector.monitoring.service

import com.jdum.projector.monitoring.domain.Food
import com.jdum.projector.monitoring.repository.FoodRepository
import com.jdum.projector.monitoring.web.error.MenuNotFoundException
import org.springframework.stereotype.Service

@Service
class FoodService(
        private val repository: FoodRepository,
) {

    fun getAll(): Food =
            repository.findAll().getOrElse(0) { throw MenuNotFoundException("Food not found") }

    fun add(food: Food): Food {
        return repository.save(food)
    }
}
