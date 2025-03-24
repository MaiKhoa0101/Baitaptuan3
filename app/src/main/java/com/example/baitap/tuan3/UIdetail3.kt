package com.example.baitap.tuan3

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.baitap.R
import com.example.baitap.viewmodel.TaskViewModel

@Composable
fun TaskDetailScreen3(
    navController3: NavController,
    taskId: Int,
    taskViewModel: TaskViewModel = viewModel()
) {
    // Fetch task details when the composable is launched
    LaunchedEffect(taskId) {
        taskViewModel.getDetailTasks(taskId)
    }
    println("Task id la:"+taskId)
    // Collect StateFlow values
    val taskDetails = taskViewModel.taskDetail.collectAsState().value
    val isLoading = taskViewModel.isLoading.collectAsState().value

// Display loading indicator first
    if (isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
        return
    }

// Check for task details AFTER loading is done
    if (taskDetails == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Back button and title
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    IconButton(onClick = { navController3.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrowback),
                            contentDescription = "Back",
                            modifier = Modifier.size(30.dp),
                            tint = Color.Unspecified
                        )
                    }
                    Text(
                        text = "Detail",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        color = Color.Cyan,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.blanktask),
                        contentDescription = "Ko co task",
                        modifier = Modifier.fillMaxWidth(),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 20.sp,
                        text = "No Task Yet!",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        fontSize= 20.sp,
                        text = "Stay productive-add something to do",
                        textAlign = TextAlign.Center
                    )
                }
            }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically, // Ensures vertical alignment
            horizontalArrangement = Arrangement.SpaceBetween // Spreads components evenly across the row
        ) {
            // Back button
            IconButton(
                onClick = { navController3.popBackStack() },
                modifier = Modifier.size(30.dp) // Ensures consistent size
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrowback),
                    contentDescription = "Back",
                    tint = Color.Unspecified
                )
            }

            // Title
            Text(
                text = "Detail",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Cyan,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f), // Centers the title horizontally
                maxLines = 1 // Ensures the title doesn't break vertically
            )

            // Bin button
            IconButton(
                onClick = { /* Handle delete action */ },
                modifier = Modifier.size(30.dp) // Ensures consistent size
            ) {
                Image(
                    painter = painterResource(id = R.drawable.binbtn),
                    contentDescription = "Bin Button"
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        // Task Title and Description
        Text(
            text = taskDetails.title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = taskDetails.description,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF2D8D8)) // Light pink background
                .padding(16.dp)
                .clip(RoundedCornerShape(8.dp)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Category Section
            InfoSection(
                iconRes = R.drawable.categoryicon, // Replace with your category icon
                label = "Category",
                value = "Work"
            )

            // Status Section
            InfoSection(
                iconRes = R.drawable.statusicon, // Replace with your status icon
                label = "Status",
                value = "In Progress"
            )

            // Priority Section
            InfoSection(
                iconRes = R.drawable.priorityicon, // Replace with your priority icon
                label = "Priority",
                value = "High"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Subtasks
        Text(
            text = "Subtasks",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            taskDetails.subtasks.forEach { subtask ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp))
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.untick), // Corrected syntax here
                        modifier = Modifier.size(25.dp),
                        contentDescription = "" // Optional: provide a meaningful description for accessibility
                    )

                    Spacer(modifier = Modifier.width(8.dp)) // Adds spacing between the image and text

                    Text(
                        text = subtask.title,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 14.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Attachments
        Text(
            text = "Attachments",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            taskDetails.attachments.forEach { attachment ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp))
                        .padding(12.dp)
                ) {
                    val context = LocalContext.current // Get the current context
                    Image(
                        painter = painterResource(id = R.drawable.linkicon), // Corrected syntax here
                        modifier = Modifier.size(25.dp),
                        contentDescription = "" // Optional: provide a meaningful description for accessibility
                    )

                    Spacer(modifier = Modifier.width(8.dp)) // Adds spacing between the image and text

                    TextButton(
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(attachment.fileUrl))
                            context.startActivity(intent) },
                    ){
                        Text(
                            text = AnnotatedString(attachment.fileName.toString()),
                            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black)
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun InfoSection(iconRes: Int, label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = Color.Black
        )
    }
}

