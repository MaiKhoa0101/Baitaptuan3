package com.example.baitap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
            //AppNavigation2()
        }
    }
}

@Composable
fun UIComponentsList(navController: NavController) { // Nhận NavController từ AppNavigation
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = "UI Components List",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        SectionTitle("Display")
        ComponentCard("Text", "Displays text") { navController.navigate("text") }
        ComponentCard("Image", "Displays an image") { navController.navigate("image") }

        SectionTitle("Input")
        ComponentCard("TextField", "Input field for text") { navController.navigate("textfield") }
        ComponentCard("PasswordField", "Input field for passwords") { navController.navigate("passwordfield") }

        SectionTitle("Layout")
        ComponentCard("Collumn, Row, Box", "Arranges elements by 3 layout") { navController.navigate("layout") }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 16.dp)
    )
}

@Composable
fun ComponentCard(title: String, description: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        ) {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = description, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { UIComponentsList(navController) } // Truyền navController vào UIComponentsList
        composable("text") { TextScreen(navController) }
        composable("image") { ImageScreen(navController) }
        composable("textfield") { TextFieldScreen(navController) }
        composable("passwordfield") { PassFieldScreen(navController) }
        composable("layout") { LayoutScreen(navController) }

    }

}

@Composable
fun AppNavigation2() {
    val navController2 = rememberNavController()

    NavHost(navController = navController2, startDestination = "splash") {
        composable("splash") { SplashScreen(navController2) } // Truyền navController vào UIComponentsList
        composable("getStarted1") { GetStarted1(navController2) } // Truyền navController vào UIComponentsList
        composable("getStarted2") { GetStarted2(navController2) }
        composable("getStarted3") { GetStarted3(navController2) }
    }

}


