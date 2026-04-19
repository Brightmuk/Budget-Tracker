package com.bright.budgettracker.ui.components

import com.bright.budgettracker.model.Transaction
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TransactionItem(transaction: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = transaction.title, style = MaterialTheme.typography.titleMedium)
                Text(text = transaction.category, style = MaterialTheme.typography.bodySmall)
            }
            Text(
                text = if (transaction.amount > 0) "+$${transaction.amount}" else "$${transaction.amount}",
                color = if (transaction.amount > 0) Color(0xFF4CAF50) else Color(0xFFF44336),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}