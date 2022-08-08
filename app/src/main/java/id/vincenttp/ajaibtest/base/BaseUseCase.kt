package id.vincenttp.ajaibtest.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class BaseUseCase<Entity, in Param> {

    abstract suspend fun build(params: Param): Entity

    suspend fun invoke(params: Param, context: CoroutineContext = Dispatchers.IO) =
        withContext(context) {
            either { build(params) }
        }
}

suspend fun <V> either(block: suspend () -> V): Result<V> = runCatching {
    Result.Success(block())
}.getOrElse {
    it.printStackTrace()
    Result.Error(Exception(it), "")
}