package galstyan.hayk.tictactoe.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun StartScreen(
    startGame: () -> Unit,
) {
    Button(onClick = { startGame() }) {
        Text(text = "Start")
    }
}