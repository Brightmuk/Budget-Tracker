package com.bright.budgettracker.ui

sealed class Screen(val route: String) {
    object Overview : Screen("overview")
    object AddExpense : Screen("add_expense")
}