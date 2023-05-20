package galstyan.hayk.tictactoe.model

data class Game(
    private val board: Board,
    private val firstPlayer: Player,
) {

    private var currentPlayer = firstPlayer


    fun getCurrentPlayer() = currentPlayer

    fun mark(boardPosition: BoardPosition) {
        board.mark(currentPlayer.mark, boardPosition)

        // check game end

        currentPlayer = Player.next(currentPlayer)
    }

    fun result() {

    }
}