package galstyan.hayk.tictactoe.ui.game

import galstyan.hayk.tictactoe.domain.model.Board
import galstyan.hayk.tictactoe.domain.model.Player

sealed class GameUiState {
    object Loading : GameUiState()
    data class Data(
        val board: Board,
        val player: Player,
    ) : GameUiState()
}