package com.jdum.projector.monitoring.repository

import com.jdum.projector.monitoring.domain.Food
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodRepository : MongoRepository<Food, String> {

}
