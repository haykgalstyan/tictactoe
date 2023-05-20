package galstyan.hayk.tictactoe.model

sealed class Mark {
    object Cross : Mark()
    object Nought : Mark()
}