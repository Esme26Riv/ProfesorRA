package com.example.profesorra.ui

import androidx.compose.runtime.*
import androidx.compose.material3.*
import com.example.profesorra.ui.screens.*

@Composable
fun AppPrincipal() {

    var pantalla by remember { mutableStateOf("inicio") }

    when (pantalla) {

        // -------------------------------------------------------
        // PANTALLA DE INICIO
        // -------------------------------------------------------
        "inicio" -> PantallaInicio(
            onComenzar = { pantalla = "instrucciones" }
        )

        // -------------------------------------------------------
        // INSTRUCCIONES
        // -------------------------------------------------------
        "instrucciones" -> PantallaInstrucciones(
            onSiguiente = { pantalla = "evento1" }
        )

        // -------------------------------------------------------
        // EVENTO 1
        // -------------------------------------------------------
        "evento1" -> Evento1(
            onSiguiente = { pantalla = "evento2" }
        )

        // -------------------------------------------------------
        // EVENTO 2
        // -------------------------------------------------------
        "evento2" -> Evento2(
            onSiguiente = { pantalla = "evento3" }
        )

        // -------------------------------------------------------
        // EVENTO 3
        // -------------------------------------------------------
        "evento3" -> Evento3(
            onSiguiente = { pantalla = "evento4" }
        )

        // -------------------------------------------------------
        // EVENTO 4
        // -------------------------------------------------------
        "evento4" -> Evento4(
            onSiguiente = { pantalla = "evento5" }
        )

        // -------------------------------------------------------
        // EVENTO 5
        // -------------------------------------------------------
        "evento5" -> Evento5(
            onSiguiente = { pantalla = "evento6" }
        )

        // -------------------------------------------------------
        // EVENTO 6
        // -------------------------------------------------------
        "evento6" -> Evento6(
            onSiguiente = { pantalla = "evento7" }
        )

        // -------------------------------------------------------
        // EVENTO 7 (USA CÁMARA)
        // -------------------------------------------------------
        "evento7" -> Evento7_Camara(
            onSiguiente = { pantalla = "evento8" }
        )

        // -------------------------------------------------------
        // EVENTO 8
        // -------------------------------------------------------
        "evento8" -> Evento8(
            onSiguiente = { pantalla = "evento9" }
        )

        // -------------------------------------------------------
        // EVENTO 9
        // -------------------------------------------------------
        "evento9" -> Evento9(
            onSiguiente = { pantalla = "evento10" }
        )

        // -------------------------------------------------------
        // EVENTO 10 (USA GPS)
        // -------------------------------------------------------
        "evento10" -> Evento10_GPS(
            onSiguiente = { pantalla = "evento11" }
        )

        // -------------------------------------------------------
        // EVENTO 11
        // -------------------------------------------------------
        "evento11" -> Evento11(
            onSiguiente = { pantalla = "evento12" }
        )

        // -------------------------------------------------------
        // EVENTO 12
        // -------------------------------------------------------
        "evento12" -> Evento12(
            onSiguiente = { pantalla = "evento13" }
        )

        // -------------------------------------------------------
        // EVENTO 13
        // -------------------------------------------------------
        "evento13" -> Evento13(
            onSiguiente = { pantalla = "evento14" }
        )

        // -------------------------------------------------------
        // EVENTO 14 (USA CÁMARA)
        // -------------------------------------------------------
        "evento14" -> Evento14_Camara(
            onSiguiente = { pantalla = "evento15" }
        )

        // -------------------------------------------------------
        // EVENTO FINAL
        // -------------------------------------------------------
        "evento15" -> Evento15_Final(
            onReiniciar = { pantalla = "inicio" }
        )
    }
}
