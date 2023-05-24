package galstyan.hayk.tictactoe.domain.model

data class Player(
    val mark: Mark
) {
    companion object {
        val x = Player(Mark.Cross)
        val o = Player(Mark.Nought)
        fun Player.next() = if (this == x) o else x
    }
}