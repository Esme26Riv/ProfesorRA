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
fun Evento11(onSiguiente: () -> Unit) {
    val context = LocalContext.current
    val docRes = context.resources.getIdentifier("doc_confidencial", "drawable", context.packageName)

    Column(
        Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Dirección de IADA", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))
        if (docRes != 0) {
            Image(painter = painterResource(id = docRes), contentDescription = "Documento", modifier = Modifier.size(260.dp))
            Spacer(Modifier.height(12.dp))
        }
        Text("Proyecto RA-01 — Confidencial.\nEl experimento se salió de control.", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(20.dp))
        Button(onClick = onSiguiente, modifier = Modifier.fillMaxWidth()) {
            Text("Continuar")
        }
    }
}
