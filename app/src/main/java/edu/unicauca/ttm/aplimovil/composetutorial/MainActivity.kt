package edu.unicauca.ttm.aplimovil.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.ttm.aplimovil.composetutorial.ui.theme.ComposeTutorialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme() {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Conversation(SampleData.conversationSample)
                    //MessageCard(Message("Kevin", "Bienvenido a android con Kotlin"))
                }
            }

        }
    }
}

data class Message(val autor: String, val cuerpo: String)

@Composable
fun MessageCard(mgs: Message) {

    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.peinado),
            contentDescription = "Imagen de perfil",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }


        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )


        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = mgs.autor,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(
                    text = mgs.cuerpo,
                    modifier = Modifier.padding(all = 8.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}


@Composable
fun Conversation(listMessage: List<Message>) {
    LazyColumn {
        items(listMessage) { message ->
            MessageCard(message)
        }
    }
}

//@Preview()
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Modo oscuro"
)


@Preview
@Composable
fun PreviewMessageCard() {
    ComposeTutorialTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            Conversation(SampleData.conversationSample)
            //MessageCard(Message("Kevin", "Bienvenido a android con Kotlin"))
        }
    }
}