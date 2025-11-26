package com.example.profesorra.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profesorra.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaInicio(onComenzar: () -> Unit) {

    // Fondo con degradado oscuro
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF000000), Color(0xFF0B1F3D))
                )
            )
    ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    "El misterio del profesor RA",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )

                Spacer(Modifier.height(28.dp))

                Image(
                    painter = painterResource(id = R.drawable.fantasmita),
                    contentDescription = "Fantasmita",
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
                )

                Spacer(Modifier.height(28.dp))

                Text(
                    "Un juego de exploración en el campus. " +
                            "Recorre lugares, usa la cámara y el GPS para descubrir pistas.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFFCCCCCC)
                )

                Spacer(Modifier.height(36.dp))

                Button(
                    onClick = onComenzar,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF666666),
                        contentColor = Color.White
                    )
                ) {
                    Text("Comenzar")
                }
            }
        }
    }

