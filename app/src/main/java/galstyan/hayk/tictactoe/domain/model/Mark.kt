package galstyan.hayk.tictactoe.domain.model

sealed class Mark {
    object Cross : Mark()
    object Nought : Mark()
}