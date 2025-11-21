package com.example.profesorra.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.profesorra.util.SoundVibrateHelper

@Composable
fun Evento8(onSiguiente: () -> Unit) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        val res = context.resources.getIdentifier("metal", "raw", context.packageName)
        if (res != 0) SoundVibrateHelper.playSound(context, res)
        SoundVibrateHelper.vibrateShort(context, 200L)
    }

    val planRes = context.resources.getIdentifier("plan_digital", "drawable", context.packageName)

    Column(
        Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Taller mecánico", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))
        Text("El profesor hablaba de un cuarto subterráneo aquí.", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(12.dp))
        if (planRes != 0) {
            Image(painter = painterResource(id = planRes), contentDescription = "Plano digital", modifier = Modifier.size(220.dp))
            Spacer(Modifier.height(10.dp))
        }
        Button(onClick = onSiguiente, modifier = Modifier.fillMaxWidth()) {
            Text("Seguir investigando")
        }
    }
}
