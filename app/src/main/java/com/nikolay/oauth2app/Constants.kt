package com.nikolay.oauth2app

class Constants {
    companion object {

        const val HTTP_HEADER_CHANEL = "EBank-Chanel"
        const val HTTP_HEADER_APPLICATION_VERSION = "EBank-App-Version"
        const val HTTP_HEADER_SCREEN = "EBank-Screen"
        const val HTTP_HEADER_DEVICE_ID = "EBank-Device-Id"
        const val HTTP_HEADER_ACCEPT_LANG = "Accept-Language"
        const val HTTP_HEADER_TIMESTAMP = "EBank-Client-Time"
        const val HTTP_HEADER_THEME = "EBank-Theme"
        const val HTTP_HEADER_CLIENT_VERSION = "EBank-Client-Version"
        const val HTTP_HEADER_ACCEPT = "Accept"
        const val HTTP_HEADER_CONTENT_TYPE = "Content-Type"
        const val HTTP_HEADER_AUTHORIZATION = "Authorization"

        const val SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"
        const val CHANEL = "Mobile-Android"

        const val CLIENT_SECRET = "android_secret"
        const val CLIENT_ID = "android"

        const val AUTH_TOKEN_BASIC_FORMAT = "Basic %s"


        const val STRING_EMPTY = ""
        const val NEW_LINE = "\n"
        val clientSecret = "android_secret"
        val clientId = "android"
        val contentType = "application/x-www-form-urlencoded"
        val TOKEN_URL = "https://myzxc.fibank.bg:443/oauth2-server/oauth/token"
        val OAUTH_APP_SCOPE = "read"
        val SCOPE = "scope"
        val EBANK_SYSTEM_ID = "MY-FIBANK.BG"
        val GRANT_TYPE_PASSWORD = "password"

        val HEADER_ACCEPT = "Accept"
        val HEADER_CONTENT_TYPE = "Content-Type"
        val AUTHORIZATION = "Authorization"
        val GRANT_TYPE = "grant_type"

    }
}