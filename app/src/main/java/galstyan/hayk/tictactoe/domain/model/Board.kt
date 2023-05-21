package galstyan.hayk.tictactoe.domain.model


data class Board(
    val spaces: List<BoardSpace> = List(9) { BoardSpace() }
) {

    fun mark(mark: Mark, position: BoardPosition) {
        spaces[position.x * position.y].setMark(mark) // will this work, lol?
    }
}