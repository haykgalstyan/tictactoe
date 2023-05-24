package galstyan.hayk.tictactoe.domain.model


data class Board(
    val spaces: List<BoardSpace> = List(SIZE) { BoardSpace(null) }
) {
    fun mark(mark: Mark, position: Int) {
        spaces[position].mark = mark
    }

    companion object {
        const val SIZE = 9

        fun Board.getPositionsWith(mark: Mark) =
            spaces.mapIndexedNotNull { i, bs ->
                i.takeIf { bs.mark == mark }
            }
    }
}