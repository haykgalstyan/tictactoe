package galstyan.hayk.tictactoe.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import galstyan.hayk.tictactoe.R
import galstyan.hayk.tictactoe.ui.components.BoardLayout
import galstyan.hayk.tictactoe.ui.components.game.BoardSpace
import galstyan.hayk.tictactoe.ui.theme.AppTheme


@Composable
fun GameBoard(
    modifier: Modifier = Modifier,
//    onClick: (x: Int, y: Int) -> Unit,
) {
    BoardLayout(modifier = modifier.aspectRatio(1F)) {
        repeat(9) {
            BoardSpace(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cross),
                    contentDescription = stringResource(id = R.string.app_name)
                )
            }
        }
    }
}


@Composable
@Preview
fun BoardPreview() {
    AppTheme {
        GameBoard(
            modifier = Modifier.fillMaxSize()
        )
    }
}