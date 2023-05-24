package galstyan.hayk.tictactoe.domain.model

import galstyan.hayk.tictactoe.domain.model.Board.Companion.getPositionsWith

sealed class Completion {
    object Draw : Completion()
    data class Winner(val player: Player) : Completion()

    companion object {
        fun Board.check(): Completion? {
            val markPositions =
                listOf(Mark.Cross, Mark.Nought).associateWith { getPositionsWith(it) }

            for (mp in markPositions)
                for (wc in winCombos)
                    if (mp.value.containsAll(wc))
                        return Winner(Player(mp.key))

            return if (spaces.all { it.mark != null }) Draw else null
        }

        private val winCombos = listOf(
            listOf(0, 1, 2),
            listOf(3, 4, 5),
            listOf(6, 7, 8),

            listOf(0, 3, 6),
            listOf(1, 4, 7),
            listOf(2, 5, 8),

            listOf(0, 4, 8),
            listOf(2, 4, 6),
        )
    }
}