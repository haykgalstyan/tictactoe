package galstyan.hayk.tictactoe.domain.model

data class Player(
    val mark: Mark
) {

    fun swap() = next(this)

    companion object {
        val x = Player(Mark.Cross)
        val o = Player(Mark.Nought)
        fun next(current: Player) = if (current == x) o else x
        fun withMark(mark: Mark) = when (mark) {
            Mark.Cross -> x
            Mark.Nought -> o
        }
    }
}