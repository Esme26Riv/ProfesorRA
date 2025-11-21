package com.example.profesorra.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Evento1(onSiguiente: () -> Unit) {

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Aula 5V", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(10.dp))

        Text("Encuentras una frase en la pizarra: “El proyecto RA nunca debió continuar…”")

        Spacer(Modifier.height(40.dp))

        Button(onClick = onSiguiente) {
            Text("Siguiente pista")
        }
    }
}
