package galstyan.hayk.tictactoe.model

data class Board(
    private val spaces: List<BoardSpace>
) {

    fun mark(mark: Mark, position: BoardPosition) {
        spaces[position.x * position.y].setMark(mark)
    }
}