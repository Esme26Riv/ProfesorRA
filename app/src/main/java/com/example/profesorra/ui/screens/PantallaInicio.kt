package com.example.profesorra.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaInicio(onComenzar: () -> Unit) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("El misterio del profesor RA") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("El misterio del profesor RA", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(28.dp))
            Text(
                "Un juego de exploración en el campus. Recorre lugares, usa la cámara y el GPS para descubrir pistas.",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(Modifier.height(36.dp))
            Button(onClick = onComenzar, modifier = Modifier.fillMaxWidth()) {
                Text("Comenzar")
            }
        }
    }
}
