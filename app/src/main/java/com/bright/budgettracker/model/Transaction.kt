package com.bright.budgettracker.model

data class Transaction(
    val id: Int,
    val title: String,
    val amount: Double,
    val category: String,
    val date: String
)

val dummyTransactions = listOf<Transaction>(
    Transaction(1, "Grocery Shopping", -45.50, "Food", "Today"),
    Transaction(2, "Freelance Pay", 1200.00, "Income", "Yesterday"),
    Transaction(3, "Netflix Subscription", -15.99, "Entertainment", "Oct 12")
)