package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAppTheme {
                AppScreen()

            }
        }

    }

}

@Composable
fun AppScreen() {
    val isClicked = rememberSaveable { mutableStateOf(false) }
    Box {
        Image(
            painter = painterResource(id = R.drawable.bg2),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .rotate(180f),

            contentScale = ContentScale.Crop,
            alpha=.7f,

//           colorFilter= ColorFilter.tint(
//                color= Color.Green,
//                blendMode = BlendMode.Lighten,
//            )

          )

        val offsetY = if (isClicked.value) (-20).dp else 0.dp
        Column (
            horizontalAlignment= Alignment.CenterHorizontally,
            modifier= Modifier
                .align(Alignment.BottomCenter)
                .offset(y = offsetY)
        ){
            Image(
                painter = painterResource(id = R.drawable.bg3),
                contentDescription = null,
                modifier = Modifier
                    //.align(Alignment.TopCenter)
                    .size(200.dp)
                    // .scale(2f}
                    .offset(y = offsetY)
            )
            AnimatedVisibility(visible = isClicked.value) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "Hello! Welcome to the world of Android Development")
            }
      }
        Button(
            onClick = { isClicked.value = !isClicked.value },
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top =64.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.hsl(347f, 0.9f, 0.83f),
                contentColor = Color.Black
            )
        )
        {
            Text(text = "Click me!")

        }

    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppScreenPreview() {
    FirstAppTheme {
        AppScreen()
    }
}





