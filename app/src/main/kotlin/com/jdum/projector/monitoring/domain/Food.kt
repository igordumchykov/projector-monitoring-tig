package com.jdum.projector.monitoring.domain

import com.jdum.projector.monitoring.config.TableNames
import org.springframework.data.mongodb.core.mapping.Document

@Document(TableNames.FOOD)
class Food(
        id: String? = null,
        name: LangString? = LangString(),
        description: LangString? = LangString(),
        imageUrl: String?,
        groups: ArrayList<MenuGroup>?
) : BaseMenu(id, name, description, imageUrl, groups)
