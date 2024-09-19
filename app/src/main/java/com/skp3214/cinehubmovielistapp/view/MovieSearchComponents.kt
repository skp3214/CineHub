package com.skp3214.cinehubmovielistapp.view
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MovieSearchComponent(onSearchClicked: (query: String) -> Unit) {
    var query by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(Color(0xFF000000)),

            value = query,
            onValueChange = {
                if (it.isNotBlank()) {
                    errorMessage = ""
                }
                query = it
            },
            singleLine = true,
            placeholder = { Text("Enter a movie title", color = Color(0xFF363131)) },
            isError = errorMessage.isNotBlank(),
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (query.isNotBlank()) {
                            onSearchClicked(query)
                        } else {
                            errorMessage = "Enter a query first"
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color(0xFF183D3D)
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color(0xFF183D3D),
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color(0xFF183D3D),
                unfocusedIndicatorColor = Color(0xFF183D3D)
            )
        )
        if (errorMessage.isNotBlank()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}
