package galstyan.hayk.tictactoe.domain.model

data class Game(
    val board: Board,
    private val firstPlayer: Player,
) {

    private var player = firstPlayer

    private var completion: Completion? = null

    fun getPlayer() = player

    fun mark(boardPosition: BoardPosition) {
        board.mark(player.mark, boardPosition)

        completion = checkCompletion()
        if (completion == null) {
            player = Player.next(player)
        }
    }

    fun getCompletion(): Completion? {
        return completion
    }

    private fun checkCompletion(): Completion? {
        val spaces = board.spaces

        var empty = 0
        var position = 0
        var irow = 0
        var limk: Mark? = null
        for (i in 0..2) {
            val imk = spaces[position++].getMark()
            if (imk == null) {
                empty++
                continue
            }
            if (limk == imk) irow++
            else irow = 0
            limk = imk

            if (irow == 2) {
                return Completion.winner(imk)
            }

            var jrow = 0
            var ljmk: Mark? = null
            for (j in 0..2) {
                val jmk = spaces[position++].getMark()
                if (jmk == null) {
                    empty++
                    continue
                }
                if (ljmk == jmk) jrow++
                else jrow = 0
                ljmk = jmk

                if (jrow == 2) {
                    return Completion.winner(jmk)
                }
            }
        }

        return if (empty == 0) Completion.Draw else null
    }
}