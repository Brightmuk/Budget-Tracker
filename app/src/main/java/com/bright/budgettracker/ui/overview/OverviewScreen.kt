package com.bright.budgettracker.ui.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bright.budgettracker.model.dummyTransactions
import com.bright.budgettracker.ui.components.TransactionItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OverviewScreen(onNavigateToAdd: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Expense Tracker") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {onNavigateToAdd() }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            item {
                SummaryHeader(totalBalance = 1138.51) // A custom component
            }
            items(dummyTransactions) { transaction ->
                TransactionItem(transaction = transaction)
            }
        }
    }
}

@Composable
fun SummaryHeader(totalBalance: Double) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Total Balance", style = MaterialTheme.typography.labelLarge)
            Text(
                "$${totalBalance}",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
@Preview
@Composable
fun OverviewScreenPreview() {
    OverviewScreen(onNavigateToAdd = {})
}