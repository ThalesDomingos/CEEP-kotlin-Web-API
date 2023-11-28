package br.com.alura.ceep.webclient

import android.util.Log
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.services.NotaService

private const val TAG = "NotaWebClient"

class NotaWebClient {

    private val notaService: NotaService =
        RetrofitInicializador().notaService

    suspend fun BuscaTodas(): List<Nota>? {
        return try {
            val notasResposta = notaService
                .buscaTodas()
            notasResposta.map { notaResposta ->
                notaResposta.nota
            }
        } catch (e: Exception) {
            Log.e(TAG, "BuscaTodas: ", e)
            null
        }
    }
}