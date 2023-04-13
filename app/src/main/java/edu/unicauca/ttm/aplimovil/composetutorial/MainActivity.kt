package edu.unicauca.ttm.aplimovil.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MassageCard(Mensage("Kevin", "Bienvenido a android con Kotlin"))

        }
    }
}

data class Mensage(val autor: String, val cuerpo: String)


@Composable
fun MassageCard(mgs: Mensage) {

    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.peinado),
            contentDescription = "Imagen de perfil",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(text = mgs.autor)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = mgs.cuerpo)

        }
    }

}

@Preview
@Composable
fun PreviewMessageCard() {
    MassageCard(Mensage("Kevin", "Bienvenido a android con Kotlin"))
}