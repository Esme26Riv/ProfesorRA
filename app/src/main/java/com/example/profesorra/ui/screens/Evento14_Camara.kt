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
import com.example.profesorra.camera.CameraView
import com.example.profesorra.util.SoundVibrateHelper
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Evento14_Camara(onSiguiente: () -> Unit) {
    val context = LocalContext.current
    var showGhost by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(2000) // aparece después de 2s
        showGhost = true

        // sonido + vibración
        SoundVibrateHelper.playSound(
            context,
            context.resources.getIdentifier("metal", "raw", context.packageName)
        )
        SoundVibrateHelper.vibrateShort(context, 300L)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Regreso al Salón") }
            )
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            // Cámara de fondo
            CameraView(modifier = Modifier.fillMaxSize())

            // Fantasma superpuesto
            if (showGhost) {
                val ghostRes = context.resources.getIdentifier("event14_overlay", "drawable", context.packageName)
                if (ghostRes != 0) {
                    Image(
                        painter = painterResource(id = ghostRes),
                        contentDescription = "Fantasma",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(260.dp)
                    )
                }
            }

            // Botón
            Button(
                onClick = onSiguiente,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Text("Continuar")
            }
        }
    }
}
