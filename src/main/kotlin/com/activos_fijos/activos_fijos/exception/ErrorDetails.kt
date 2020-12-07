package co.edu.uniajc.fixedAsset.exception

import java.util.*

class ErrorDetails(date: Date, message: String?, description: String) {
    private var timestamp: Date? = null
    private var message: String? = null
    private var details: String? = null

    fun getTimestamp(): Date? {
        return timestamp
    }

    fun getMessage(): String? {
        return message
    }

    fun getDetails(): String? {
        return details
    }
}