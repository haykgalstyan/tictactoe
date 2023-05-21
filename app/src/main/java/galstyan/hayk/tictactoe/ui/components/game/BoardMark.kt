package galstyan.hayk.tictactoe.ui.components.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import galstyan.hayk.tictactoe.R
import galstyan.hayk.tictactoe.domain.model.Mark
import galstyan.hayk.tictactoe.ui.theme.AppTheme

@Composable
fun BoardMark(
    mark: Mark,
    modifier: Modifier
) {
    val imageRes: Int
    val descriptionRes: Int
    if (mark is Mark.Cross) {
        imageRes = R.drawable.cross
        descriptionRes = R.string.cross
    } else {
        imageRes = R.drawable.nought
        descriptionRes = R.string.nought
    }
    Image(
        modifier = modifier,
        painter = painterResource(id = imageRes),
        contentDescription = stringResource(id = descriptionRes)
    )
}


@Preview
@Composable
fun BoardMarkPreview() {
    AppTheme {
        BoardMark(
            mark = Mark.Cross,
            modifier = Modifier
                .width(480.dp)
                .height(480.dp)
        )
    }
}