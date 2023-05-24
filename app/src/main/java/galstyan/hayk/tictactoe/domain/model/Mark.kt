package galstyan.hayk.tictactoe.domain.model

sealed class Mark {
    object Cross : Mark() {
        override fun toString() = "X"
    }

    object Nought : Mark() {
        override fun toString() = "O"
    }
}