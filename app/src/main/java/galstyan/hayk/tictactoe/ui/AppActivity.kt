package galstyan.hayk.tictactoe.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import galstyan.hayk.tictactoe.ui.game.GameScreen
import galstyan.hayk.tictactoe.ui.game.GameViewModel
import galstyan.hayk.tictactoe.ui.theme.AppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppNavHost()
            }
        }
    }
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.Start
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(Destinations.Start) {
            StartScreen(startGame = { navController.navigate(Destinations.Game) })
        }
        composable(Destinations.Game) {
            val viewModel = hiltViewModel<GameViewModel>()
            GameScreen(viewModel)
        }
    }
}


object Destinations {
    const val Start: String = "start"
    const val Game: String = "game"
}