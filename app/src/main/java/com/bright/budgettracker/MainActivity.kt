package com.bright.budgettracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bright.budgettracker.ui.theme.BudgetTrackerTheme
import com.bright.budgettracker.ui.overview.OverviewScreen
import com.bright.budgettracker.ui.add_expense.AddExpenseScreen
import com.bright.budgettracker.ui.Screen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetTrackerTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.Overview.route
                ) {
                    composable(Screen.Overview.route) {
                        OverviewScreen(onNavigateToAdd = {
                            navController.navigate(Screen.AddExpense.route)
                        })
                    }
                    composable(Screen.AddExpense.route) {
                        AddExpenseScreen(onSave = {
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}


