package galstyan.hayk.tictactoe.ui.components.game

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import galstyan.hayk.tictactoe.domain.model.Board
import galstyan.hayk.tictactoe.domain.model.BoardSpace
import galstyan.hayk.tictactoe.domain.model.Mark
import galstyan.hayk.tictactoe.ui.components.BoardLayout
import galstyan.hayk.tictactoe.ui.theme.AppTheme
import galstyan.hayk.tictactoe.ui.components.game.BoardSpace as BoardSpaceComponent

@Composable
fun GameBoard(
    board: Board,
    modifier: Modifier = Modifier,
    // onClick: (x: Int, y: Int) -> Unit,
) {
    BoardLayout(modifier = modifier.aspectRatio(1F)) {
        board.spaces.forEach { space ->
            BoardSpaceComponent(
                modifier = Modifier.fillMaxSize()
            ) {
                val mark = space.getMark()
                if (mark != null) {
                    BoardMark(mark, Modifier.fillMaxSize())
                }
            }
        }
    }
}


@Preview
@Composable
fun GameBoardPreview() {
    AppTheme {
        GameBoard(
            board = Board(
                spaces = listOf(
                    BoardSpace(Mark.Cross), BoardSpace(null), BoardSpace(Mark.Nought),
                    BoardSpace(null), BoardSpace(null), BoardSpace(null),
                    BoardSpace(Mark.Nought), BoardSpace(null), BoardSpace(Mark.Cross),
                )
            ),
            modifier = Modifier.fillMaxSize(),
        )
    }
}