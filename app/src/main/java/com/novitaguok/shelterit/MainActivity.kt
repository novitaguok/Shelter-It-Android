package com.novitaguok.shelterit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItTheme
import com.novitaguok.shelterit.ui.ShelterItApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            ShelterItTheme {
                ShelterItApp()
            }
        }
    }
}

data class ThemeSettings(
    val darkTheme: Boolean,
    val dynamicColor: Boolean,
)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShelterItTheme {
        Greeting("Android")
    }
}
