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
import com.example.baitap.R

@Preview(
    showBackground = true,
)
@Composable
fun AppNavigation3() {
    val navController3 = rememberNavController()

    NavHost(navController = navController3, startDestination = "root1") {
        composable("root1") { RootScreen1(navController3) }
        composable("list1") { TaskListScreen(navController3) }
        composable("detail") { TaskDetailScreen1(navController3) }
    }
}

@Composable
fun TaskListScreen(navController3: NavController, viewModel: TaskViewModel = viewModel()) {
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
                text = "Lazy Column",
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
            items(tasks) { task ->
                TaskCard(navController3,task.title, task.description)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskCard(navController3: NavController,title: String, description: String) {
    Card(
        onClick = {navController3.navigate("detail")},
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround) {
            Column(modifier = Modifier.padding(10.dp).width(250.dp)) {
                Text(text = title, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = description, style = MaterialTheme.typography.bodyMedium)

            }
            Icon(
                painter = painterResource(id = R.drawable.btnrightdirect),
                contentDescription = null, // Describe the icon for accessibility
                modifier = Modifier.size(24.dp),

            )
        }
    }
}