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

    var result by remember { mutableStateOf(1) }

    val imagemResult = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(imagemResult),
            contentDescription = "Dado"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                result = Random.nextInt(1, 7)
            }
        ) {
            Text(text = stringResource(R.string.roll))
        }
    }
}
