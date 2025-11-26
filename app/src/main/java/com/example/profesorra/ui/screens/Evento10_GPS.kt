package com.example.profesorra.ui.screens

import android.location.Location
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profesorra.gps.GpsManager
import kotlin.math.roundToInt

@Composable
fun Evento10_GPS(onSiguiente: () -> Unit) {

    val context = LocalContext.current
    val gps = remember { GpsManager(context) }

    val targetLat = 31.6787
    val targetLng = -106.4243

    var current by remember { mutableStateOf<Location?>(null) }
    var dist by remember { mutableStateOf("Calculando...") }
    var bearing by remember { mutableStateOf("—") }

    DisposableEffect(Unit) {
        gps.startUpdates { loc ->
            current = loc
            val res = FloatArray(1)
            Location.distanceBetween(loc.latitude, loc.longitude, targetLat, targetLng, res)
            dist = "${res[0].roundToInt()} m"

            val t = Location("target").apply {
                latitude = targetLat
                longitude = targetLng
            }
            bearing = "${loc.bearingTo(t).roundToInt()}°"
        }
        onDispose { gps.stopUpdates() }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF000000), Color(0xFF0B1F3D))
                )
            )
    ) {

        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text("Estacionamiento", fontSize = 28.sp, color = Color(0xFFEDEDED))
            Spacer(Modifier.height(18.dp))

            Text("Ubicación actual:", color = Color(0xFFCCCCCC), fontSize = 18.sp)
            Spacer(Modifier.height(8.dp))

            Text(
                text = current?.let { "${it.latitude}, ${it.longitude}" } ?: "Obteniendo...",
                color = Color.White
            )

            Spacer(Modifier.height(18.dp))

            Text("Distancia al objetivo: $dist", color = Color(0xFFCCCCCC), fontSize = 18.sp)
            Spacer(Modifier.height(8.dp))

            Text("Dirección: $bearing", color = Color(0xFFCCCCCC), fontSize = 18.sp)

            Spacer(Modifier.height(26.dp))

            val arrowRes = context.resources.getIdentifier("arrow", "drawable", context.packageName)
            if (arrowRes != 0) {
                Image(
                    painter = painterResource(id = arrowRes),
                    contentDescription = "Flecha",
                    modifier = Modifier.size(120.dp)
                )
            }

            Spacer(Modifier.height(30.dp))

            Button(
                onClick = onSiguiente,
                modifier = Modifier.fillMaxWidth().height(55.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF666666))
            ) {
                Text("Continuar", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}
