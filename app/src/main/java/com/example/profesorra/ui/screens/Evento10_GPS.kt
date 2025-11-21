package com.example.profesorra.ui.screens

import android.location.Location
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.profesorra.gps.GpsManager
import com.example.profesorra.util.SoundVibrateHelper
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Evento10_GPS(onSiguiente: () -> Unit) {
    val context = LocalContext.current
    val gps = remember { GpsManager(context) }

    // ejemplo: coordenadas del objetivo (reemplaza por reales)
    val targetLat = 31.6787
    val targetLng = -106.4243

    var currentLocation by remember { mutableStateOf<Location?>(null) }
    var distanceText by remember { mutableStateOf("Calculando...") }
    var bearingText by remember { mutableStateOf("—") }

    DisposableEffect(Unit) {
        gps.startUpdates { loc ->
            currentLocation = loc
            val results = FloatArray(1)
            Location.distanceBetween(loc.latitude, loc.longitude, targetLat, targetLng, results)
            val meters = results[0]
            distanceText = "${meters.roundToInt()} m"

            // calcular bearing usando Location APIs
            val locTarget = Location("target").apply {
                latitude = targetLat
                longitude = targetLng
            }
            val bearing = loc.bearingTo(locTarget)
            bearingText = "${bearing.roundToInt()}°"
        }
        onDispose { gps.stopUpdates() }
    }

    Scaffold(topBar = { CenterAlignedTopAppBar(title = { Text("Estacionamiento") }) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Ubicación actual:", style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(8.dp))
            Text(
                text = if (currentLocation != null) "${currentLocation!!.latitude}, ${currentLocation!!.longitude}" else "Obteniendo...",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(Modifier.height(12.dp))
            Text("Distancia al objetivo: $distanceText", style = MaterialTheme.typography.bodyLarge)
            Spacer(Modifier.height(8.dp))
            Text("Dirección: $bearingText", style = MaterialTheme.typography.bodyLarge)
            Spacer(Modifier.height(12.dp))

            // Flecha (rota según bearing) - simple muestra estática si no quieres rotación
            val arrowRes = context.resources.getIdentifier("arrow", "drawable", context.packageName)
            if (arrowRes != 0) {
                Image(painter = painterResource(id = arrowRes), contentDescription = "Flecha", modifier = Modifier.size(120.dp))
                // Para rotación real necesitarás obtener compass azimuth del dispositivo y rotar la imagen.
            }

            Spacer(Modifier.height(20.dp))

            Button(onClick = {
                // si distancia menor a 25 m, desbloquea
                val loc = currentLocation
                if (loc != null) {
                    val results = FloatArray(1)
                    Location.distanceBetween(loc.latitude, loc.longitude, targetLat, targetLng, results)
                    if (results[0] <= 25f) {
                        SoundVibrateHelper.playSound(context, context.resources.getIdentifier("alarm", "raw", context.packageName))
                        SoundVibrateHelper.vibrateShort(context, 700L)
                    }
                }
                onSiguiente()
            }, modifier = Modifier.fillMaxWidth()) {
                Text("Continuar")
            }
        }
    }
}
