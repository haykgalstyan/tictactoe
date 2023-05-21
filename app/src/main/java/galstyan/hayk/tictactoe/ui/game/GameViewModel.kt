package galstyan.hayk.tictactoe.ui.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import galstyan.hayk.tictactoe.domain.usecase.GetBoard
import galstyan.hayk.tictactoe.domain.usecase.GetCompletion
import galstyan.hayk.tictactoe.domain.usecase.GetPlayer
import galstyan.hayk.tictactoe.domain.usecase.PutMark
import galstyan.hayk.tictactoe.domain.usecase.StartGame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GameViewModel @Inject constructor(
    val startGame: StartGame,
    val getBoard: GetBoard,
    val getPlayer: GetPlayer,
    val putMark: PutMark,
    val getCompletion: GetCompletion,
) : ViewModel() {

    private val _uiState: MutableStateFlow<GameUiState> = MutableStateFlow(GameUiState.Loading)
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            startGame()
            val board = getBoard()
            val player = getPlayer()
            _uiState.value = GameUiState.Data(board, player)
        }
    }
}