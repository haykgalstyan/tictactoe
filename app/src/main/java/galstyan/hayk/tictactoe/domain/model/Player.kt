package galstyan.hayk.tictactoe.domain.model

data class Player(
    val mark: Mark
) {
    companion object {
        val x = Player(Mark.Cross)
        val o = Player(Mark.Nought)
        fun next(current: Player) = if (current == x) o else x
    }
}