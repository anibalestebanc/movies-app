package cl.imagemaker.login.data.remote.model

import com.google.gson.annotations.SerializedName

data class DataLoginResponse(
        @SerializedName("status")
        private val status : String
)