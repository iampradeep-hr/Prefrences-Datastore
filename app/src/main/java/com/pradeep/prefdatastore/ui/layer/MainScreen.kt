package com.pradeep.prefdatastore.ui.layer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(viewModel:MainViewModel) {

    val username = viewModel.userName.collectAsState()
    val text = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "<-- Saved Name -->",
            style = MaterialTheme.typography.body1,
            color = Color.Green
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = username.value,
            style = MaterialTheme.typography.body1,
            color = Color.Green,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = text.value, onValueChange = {
                text.value = it
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Yellow,
                cursorColor = Color.Yellow
            )

        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            viewModel.saveData(text.value)
        }) {
            Text(text = "Save")
        }
    }
}