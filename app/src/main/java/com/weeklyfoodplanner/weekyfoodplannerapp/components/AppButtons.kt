package com.weeklyfoodplanner.weekyfoodplannerapp.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.weeklyfoodplanner.weekyfoodplannerapp.R

@Composable
fun AppPrimaryButton( text: String, onClick: () -> Unit) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .width(300.dp)
            .height(65.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(25.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Text(text = text, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.background)
    }
}

@Composable
fun AppMainButton( text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .border(1.dp, color = Color.White, shape = RoundedCornerShape(25.dp))
            .width(300.dp)
            .height(65.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(25.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Text(text = text, style = MaterialTheme.typography.titleMedium, color = Color.White)
    }
}
