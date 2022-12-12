package projeto.pdm.terceiraprova.api

import projeto.pdm.terceiraprova.model.Pokemon
import projeto.pdm.terceiraprova.model.PokemonType

data class ApiResult (
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)

data class PokemonApiResult(
    val id: Int,
    val name: String,
    val types: List<PokemonTypeSlot>
)

data class PokemonTypeSlot(
    val slot: Int,
    val type: PokemonType
)