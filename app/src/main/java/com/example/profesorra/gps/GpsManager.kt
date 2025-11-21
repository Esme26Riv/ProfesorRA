package com.example.profesorra.gps

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.*

class GpsManager(context: Context) {

    private val fused = LocationServices.getFusedLocationProviderClient(context)

    private val locationRequest = LocationRequest.create().apply {
        interval = 3000L
        fastestInterval = 2000L
        priority = Priority.PRIORITY_HIGH_ACCURACY
    }

    private var callback: ((Location) -> Unit)? = null

    private val locCallback = object : LocationCallback() {
        override fun onLocationResult(result: LocationResult) {
            result.lastLocation?.let { location ->
                callback?.invoke(location)
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun startUpdates(onLocation: (Location) -> Unit) {
        callback = onLocation
        fused.requestLocationUpdates(locationRequest, locCallback, null)
    }

    fun stopUpdates() {
        fused.removeLocationUpdates(locCallback)
        callback = null
    }

    @SuppressLint("MissingPermission")
    fun getLastLocation(onResult: (Location?) -> Unit) {
        fused.lastLocation.addOnSuccessListener { onResult(it) }.addOnFailureListener { onResult(null) }
    }
}
