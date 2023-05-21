package galstyan.hayk.tictactoe.domain.model

sealed class Completion {
    object Draw : Completion()
    data class Winner(val player: Player) : Completion()

    companion object {
        fun winner(mark: Mark) = Winner(Player(mark))
    }
}