package com.example.jogododado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jogododado.ui.theme.JogoDoDadoTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JogoDoDadoTheme {
                JogoDoDado(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                )
            }
        }
    }
}

@Composable
fun JogoDoDado(modifier: Modifier = Modifier) {

    var dado1 by remember { mutableStateOf(1) }
    var dado2 by remember { mutableStateOf(1) }

    val soma = dado1 + dado2

    var total by remember { mutableStateOf(0) }

    val imagemDado1 = when (dado1) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    val imagemDado2 = when (dado2) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Soma")
            Text(text = soma.toString())
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(imagemDado1),
                contentDescription = "Dado 1"
            )

            Image(
                painter = painterResource(imagemDado2),
                contentDescription = "Dado 2"
            )
        }

        Button(
            onClick = {
                dado1 = Random.nextInt(1, 7)
                dado2 = Random.nextInt(1, 7)

                total += (dado1 + dado2)
            }
        ) {
            Text(text = stringResource(R.string.roll))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = {
                    total = 0
                    dado1 = 1
                    dado2 = 1
                }
            ) {
                Text(text = "Resetar")
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(text = "Total")
                Text(text = total.toString())
            }
        }
    }
}
