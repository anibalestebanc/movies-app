package com.example.network

import android.content.Context
import android.util.Log
import okhttp3.*
import java.lang.Exception
import java.net.URI

class FakeInterceptor(private val context: Context) : Interceptor {

    companion object {
        private const val MEDIA_TYPE = "application/json;charset-UTF-8"
        private const val FOLDER_BASE = "mockapi"
        private const val FILE_EXTENSION = ".json"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val uri = chain.request().url().uri()
        val fileName = getFileName(chain)
        val filePath = getFilePath(uri, fileName)
        val responseFile = readDummyFile(filePath)

        if (responseFile != null) {
            return Response.Builder()
                    .code(200)
                    .message(responseFile)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(ResponseBody.create(MediaType.parse(MEDIA_TYPE), responseFile))
                    .build()
        }
        return chain.proceed(chain.request())
    }

    private fun getFileName(chain: Interceptor.Chain): String {
        return chain.request().url().pathSegments().get(
                chain.request().url().pathSegments().size - 1
        ) + FILE_EXTENSION
    }

    private fun getFilePath(uri: URI, fileName: String): String {
        val path = uri.path
        val mockPath = path.substring(0, path.lastIndexOf("/") + 1)
        return FOLDER_BASE + mockPath + fileName
    }

    private fun readDummyFile(filePath: String): String? {
        return try {
            context.assets.open(filePath).bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            Log.d("error to read file", e.message)
            null
        }
    }
}