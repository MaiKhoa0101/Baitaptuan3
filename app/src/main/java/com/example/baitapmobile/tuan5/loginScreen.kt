package com.example.baitapmobile.tuan5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.baitapmobile.R
import com.example.baitapmobile.tuan4.RootScreen1
import com.example.baitapmobile.tuan4.TaskDetailScreen1
import com.example.baitapmobile.tuan4.TaskListScreen

@Composable
fun AppNavigation6() {
    val navController3 = rememberNavController()


    NavHost(navController = navController3, startDestination = "root1") {
        composable("root1") { TaskListScreen(navController3) }
        composable("list1") { TaskListScreen(navController3) }
        composable("detail") { TaskDetailScreen1(navController3) }
    }
}

@Composable
fun LoginScreen(navController: NavController, signInWithGoogle: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logotruong), // Logo UTH
            contentDescription = "UTH Logo",
            modifier = Modifier.size(150.dp)
        )

        Text(
            text = "SmartTasks",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { signInWithGoogle() },
            colors = ButtonDefaults.buttonColors(Color(0xFF4285F4))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logotruong),
                contentDescription = "Google Icon",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Sign in with Google", color = Color.White)
        }
    }
}
