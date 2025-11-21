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

@Composable
fun Evento9(onSiguiente: () -> Unit) {
    val context = LocalContext.current
    val imgRes = context.resources.getIdentifier("robot_image", "drawable", context.packageName)

    Column(
        Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Laboratorio de robótica", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))
        if (imgRes != 0) {
            Image(painter = painterResource(id = imgRes), contentDescription = "Robot", modifier = Modifier.size(220.dp))
            Spacer(Modifier.height(12.dp))
        }
        Text("El proyecto RA-01 podía pensar por sí mismo. Pista: Busca al guardia viejo (estacionamiento).", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(20.dp))
        Button(onClick = onSiguiente, modifier = Modifier.fillMaxWidth()) {
            Text("Ir al estacionamiento")
        }
    }
}
