package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContentImage(
                        first = stringResource(R.string.heading),
                        second = stringResource(R.string.first_description),
                        third = stringResource(R.string.second_description),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// First Task
// Added all the text to the app and the styling
@Composable
fun ContentText(first: String,second: String,third: String, modifier: Modifier = Modifier) {
    Column{
        Text(
            text = first,
            modifier = modifier.padding(
                16.dp
            ),
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = second,
            modifier = modifier.padding(
                start = 16.dp,
                end = 16.dp
            ),
            textAlign = TextAlign.Justify
        )
        Text(
            text = third,
            modifier = modifier.padding(16.dp),
        )
    }
}

// Second Task
// Added the image to the app
@Composable
fun ContentImage(first: String,second: String,third: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column(
        modifier
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        ContentText(first = first, second = second, third = third, modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ContentImage(
            first = stringResource(R.string.heading),
            second = stringResource(R.string.first_description),
            third = stringResource(R.string.second_description)
        )
    }
}