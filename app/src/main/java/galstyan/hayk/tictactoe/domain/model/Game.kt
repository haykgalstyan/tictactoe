package galstyan.hayk.tictactoe.domain.model

import galstyan.hayk.tictactoe.domain.model.Completion.Companion.check
import galstyan.hayk.tictactoe.domain.model.Player.Companion.next

data class Game(
    val board: Board,
    private val firstPlayer: Player,
) {

    private var player = firstPlayer

    private var completion: Completion? = null

    fun getPlayer() = player

    fun mark(position: Int) {
        if (board.spaces[position].mark != null)
            return

        board.mark(player.mark, position)

        completion = board.check()

        if (completion == null) {
            player = player.next()
        }
    }

    fun getCompletion() = completion
}