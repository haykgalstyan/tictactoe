package galstyan.hayk.tictactoe.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import galstyan.hayk.tictactoe.ui.theme.AppTheme
import java.lang.IllegalArgumentException
import kotlin.math.sqrt


@Composable
fun Board(
    modifier: Modifier = Modifier,
) {
    BoardLayout(modifier = modifier) {
        repeat(9) {
            Box(modifier = Modifier.fillMaxSize())
        }
    }
}


@Composable
fun BoardLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content,
    ) { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }
        val side = sqrt(placeables.size.toFloat()).let {
            if (it % 1F != 0F) throw IllegalArgumentException()
            it.toInt()
        }

        layout(constraints.maxWidth, constraints.maxHeight) {
            var position = 0
            repeat(side) {
                // place cols
                repeat(side) {
                    // place rows in cols
                }
            }
        }
    }
}


@Composable
@Preview
fun BoardPreview() {
    AppTheme {
        BoardLayout(
            Modifier
                .width(300.dp)
                .height(300.dp)
        )
    }
}