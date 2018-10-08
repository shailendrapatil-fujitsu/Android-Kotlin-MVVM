package com.android.arch.helper

import android.os.SystemClock
import android.support.v4.util.ArrayMap

import java.util.concurrent.TimeUnit

class RateLimiter<K>(timeout: Int, timeUnit: TimeUnit) {
    private val timestamps = ArrayMap<K, Long>()
    private val timeout: Long

    init {
        this.timeout = timeUnit.toMillis(timeout.toLong())
    }

    @Synchronized
    fun shouldFetch(key: K): Boolean {
        val lastFetched = timestamps[key]
        val now = now()
        if (lastFetched == null) {
            timestamps[key] = now
            return true
        }
        if (now - lastFetched > timeout) {
            timestamps[key] = now
            return true
        }
        return false
    }

    private fun now(): Long {
        return SystemClock.uptimeMillis()
    }

    @Synchronized
    fun reset(key: K) {
        timestamps.remove(key)
    }
}
