package com.example.kitchenlexicon.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface DataRepository {
  val utensils: Flow<List<Utensil>>
}

class DefaultDataRepository : DataRepository {
  override val utensils: Flow<List<Utensil>> = flow { emit(UtensilDb.utensils) }
}
