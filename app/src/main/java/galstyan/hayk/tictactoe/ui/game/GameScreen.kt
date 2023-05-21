package galstyan.hayk.tictactoe.ui.game

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import galstyan.hayk.tictactoe.domain.model.Completion
import galstyan.hayk.tictactoe.ui.components.Loading
import galstyan.hayk.tictactoe.ui.components.game.GameBoard
import galstyan.hayk.tictactoe.ui.theme.AppTheme

@Composable
fun GameScreen(
    viewModel: GameViewModel = viewModel()
) {
    val gameUiState by viewModel.uiState.collectAsState()

    when (val state = gameUiState) {
        is GameUiState.Loading -> {
            Loading()
        }

        is GameUiState.Data -> {
            GameBoard(
                board = state.board,
                onClick = { viewModel.putMark(it) },
                modifier = Modifier.fillMaxWidth()
            )
        }

        is GameUiState.Completed -> {
            Text(
                text = when (val completion = state.completion) {
                    is Completion.Winner -> "${completion.player} is the winner!"
                    is Completion.Draw -> "It's a draw!"
                }
            )
        }
    }
}


@Preview
@Composable
fun GameScreenPreview() {
    AppTheme {
        GameScreen()
    }
}