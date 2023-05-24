package galstyan.hayk.tictactoe.domain.model

import galstyan.hayk.tictactoe.domain.model.Board.Companion.getPositionsOf

sealed class Completion {
    object Draw : Completion()
    data class Winner(val player: Player) : Completion()

    companion object {
        fun winner(mark: Mark) = Winner(Player(mark))

        val winPositions = listOf(
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

    fun Board.check(): Completion? {
        val markPositions = listOf(Mark.Cross, Mark.Nought).associateWith { getPositionsOf(it) }

        for (mp in markPositions)
            for (winCombination in winPositions)
                if (mp.value.containsAll(winCombination))
                    return winner(mp.key)

        return if (spaces.all { it.mark != null }) Draw else null
    }
}