package com.asnk.fdcentral.data.base

import com.asnk.fdcentral.domain.model.base.Model
import com.asnk.fdcentral.domain.model.base.ModelEntity

interface EntityMapper <M : Model, ME : ModelEntity> {

    fun mapToEntity(model: M): ME
}