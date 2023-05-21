package galstyan.hayk.tictactoe.data

import galstyan.hayk.tictactoe.domain.model.Board
import galstyan.hayk.tictactoe.domain.model.Game
import galstyan.hayk.tictactoe.domain.model.Player
import javax.inject.Inject
import kotlin.random.Random


class GameRepository @Inject constructor() {

    private var game = createNewGame()

    fun startGame() {
        game = createNewGame()
    }

    fun putMark(position: Int) {
        game.mark(position)
    }

    fun getPlayer() = game.getPlayer()

    fun getBoard() = game.board

    fun getGameCompletion() = game.getCompletion()


    private fun createNewGame() = Game(
        board = Board(),
        firstPlayer = if (Random.nextBoolean()) Player.x else Player.o
    )
}