package com.imagemaker.checkversion.data.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteAppConfigResponse(
    @SerializedName("current_app_version")
     val appVersion: String
)