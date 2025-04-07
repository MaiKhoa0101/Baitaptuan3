package com.example.baitapmobile.tuan4
import androidx.compose.foundation.Image
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
import com.example.baitapmobile.viewmodel.TaskViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.baitapmobile.R
import com.example.baitapmobile.model.Task
import com.example.baitapmobile.ui.theme.lightBlue
import com.example.baitapmobile.ui.theme.lightRed
import com.example.baitapmobile.ui.theme.lightYellow

@Preview(
    showBackground = true,
)
@Composable
fun AppNavigation5() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") { TaskListScreen3(navController) }
        composable(
            route = "detail/{taskId}",
            arguments = listOf(navArgument("taskId") { type = NavType.IntType })
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt("taskId")
            if (taskId != null) {
                TaskDetailScreen3(navController, taskId)
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
fun TaskListScreen3(navController: NavController, viewModel: TaskViewModel = viewModel()) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController) {
                // Handle Floating Action Button click here
            }
        }
    ) { paddingValues ->
        val tasks by viewModel.tasks.collectAsState()
        val isLoading by viewModel.isLoading.collectAsState()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logotruong),
                        contentDescription = "Logo",
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(14.dp))
                    Column() {
                        Text(
                            color = Color.Blue,
                            textAlign = TextAlign.Start,
                            text = "SmartTasks",
                            style = MaterialTheme.typography.headlineMedium,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            color = Color.Blue,
                            textAlign = TextAlign.Start,
                            text = "A simple and efficient to-do app",
                            style = MaterialTheme.typography.headlineMedium,
                            fontSize = 10.sp
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.noticebell),
                        contentDescription = "Logo",
                        modifier = Modifier.fillMaxWidth().height(30.dp),
                        alignment = Alignment.TopEnd
                    )

                }
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
                        TaskCard3(navController, task)
                    }
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskCard3(navController: NavController,task: Task) {
    val colorsList = listOf(
        lightBlue,
        lightYellow,
        lightRed,
//        Color.Green,
//        Color.Magenta
    )
    Card(
        onClick = { navController.navigate("detail/${task.id}") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = colorsList.random())
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Checkbox(
                    checked = false, // Adjust this based on task completion
                    onCheckedChange = { /* Handle checkbox logic */ },
                    modifier = Modifier.padding(end = 8.dp)
                )

                Column(
                    modifier = Modifier
                        .weight(1f) // Allows proportional space for task details
                        .padding(end = 16.dp)
                ) {
                    Text(
                        text = task.title,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Black, // Dark text for contrast
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = task.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.DarkGray // Slightly lighter text
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    text = "Status: ${task.status}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black, // Status in a lighter tone
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                    )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = task.dueDate,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    textAlign = TextAlign.End,
                    fontSize = 14.sp
                )
            }
        }
    }

}