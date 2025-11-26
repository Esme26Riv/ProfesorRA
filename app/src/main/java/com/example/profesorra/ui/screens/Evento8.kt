package com.example.profesorra.ui.screens

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
import com.example.profesorra.util.SoundVibrateHelper

@Composable
fun Evento8(onSiguiente: () -> Unit) {

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        val res = context.resources.getIdentifier("metal", "raw", context.packageName)
        if (res != 0) SoundVibrateHelper.playSound(context, res)
        SoundVibrateHelper.vibrateShort(context, 250)
    }

    val planRes = context.resources.getIdentifier("plan_digital", "drawable", context.packageName)

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
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text("Taller mecánico", fontSize = 28.sp, color = Color(0xFFEDEDED))
            Spacer(Modifier.height(16.dp))

            Text(
                "El profesor hablaba de un cuarto subterráneo aquí.",
                color = Color(0xFFCCCCCC), fontSize = 18.sp
            )

            Spacer(Modifier.height(18.dp))

            if (planRes != 0) {
                Image(
                    painter = painterResource(id = planRes),
                    contentDescription = "Plano digital",
                    modifier = Modifier.size(220.dp)
                )
                Spacer(Modifier.height(20.dp))
            }

            Button(
                onClick = onSiguiente,
                modifier = Modifier.fillMaxWidth().height(55.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF666666))
            ) {
                Text("Seguir investigando", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}
