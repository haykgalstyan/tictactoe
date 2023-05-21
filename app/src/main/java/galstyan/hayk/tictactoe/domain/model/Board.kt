package galstyan.hayk.tictactoe.domain.model


data class Board(
    val spaces: List<BoardSpace> = List(SIZE) { BoardSpace(null) }
) {
    fun mark(mark: Mark, position: Int) {
        spaces[position].setMark(mark)
    }

    companion object {
        const val SIZE = 9
    }
}