package com.example.baitap.tuan3
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.baitap.viewmodel.TaskViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.baitap.R
import com.example.baitap.model.Task
import com.example.baitap.ui.theme.lightBlue
import com.example.baitap.ui.theme.lightRed
import com.example.baitap.ui.theme.lightYellow
import kotlin.random.Random

@Preview(
    showBackground = true,
)
@Composable
fun AppNavigation4() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") { TaskListScreen2(navController) }
        composable(
            route = "detail/{taskId}",
            arguments = listOf(navArgument("taskId") { type = NavType.IntType })
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt("taskId")
            if (taskId != null) {
                TaskDetailScreen2(navController, taskId)
            } else {
                Text(
                    text = "Task ID is missing",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}

@Composable
fun TaskListScreen2(navController: NavController, viewModel: TaskViewModel = viewModel()) {
    val tasks by viewModel.tasks.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                color = Color.Blue,
                textAlign = TextAlign.Center,
                text = "List",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth()
            )
        }

        if (isLoading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(top = 16.dp)
                )
            }
        } else if (tasks.isEmpty()) {
            item {
                Text(
                    text = "No tasks available",
                    modifier = Modifier
                        .padding(top = 16.dp),
                    textAlign = TextAlign.Center

                )
            }
        } else {
            for (id in 1..5) {
                items(tasks) { task ->
                    TaskCard2(navController, task)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskCard2(navController: NavController,task: Task) {
    val colorsList = listOf(
        lightBlue,
        lightYellow,
        lightRed,
//        Color.Green,
//        Color.Magenta
    )
    Card(
        onClick = {navController.navigate("detail/${task.id}")},
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = colorsList.random())
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .weight(1f) // Ensures text occupies proportional space
                    .padding(end = 16.dp)
            ) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black // Dark text for contrast
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = task.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray // Slightly lighter text
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.btnrightdirect),
                contentDescription = null, // Accessibility description
                modifier = Modifier.size(24.dp),
                tint = Color.Black // Ensure icon is clearly visible
            )
        }
    }
}