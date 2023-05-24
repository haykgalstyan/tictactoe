package galstyan.hayk.tictactoe.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.sqrt

@Composable
fun BoardLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content,
    ) { measurables, constraints ->
        val sideCount = sqrt(measurables.size.toFloat()).let {
            if (it % 1F != 0F) throw IllegalArgumentException("Unsupported child count")
            it.toInt()
        }
        val itemWidth = constraints.maxWidth / sideCount
        val itemHeight = constraints.maxHeight / sideCount
        val itemConstraints = constraints.copy(
            minWidth = itemWidth,
            maxWidth = itemWidth,
            minHeight = itemHeight,
            maxHeight = itemHeight,
        )
        val placeables = measurables.map { it.measure(itemConstraints) }

        layout(constraints.maxWidth, constraints.maxHeight) {
            var position = 0
            repeat(sideCount) { y ->
                repeat(sideCount) { x ->
                    placeables[position++].placeRelative(x * itemWidth, y * itemHeight)
                }
            }
        }
    }
}


@Preview
@Composable
fun BoardLayoutPreview() {
    BoardLayout(modifier = Modifier.aspectRatio(1F)) {
        repeat(9) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.LightGray,
                border = BorderStroke(1.dp, Color.Gray),
            ) {
                Box(
                    modifier = Modifier.background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = it.toString(),
                        fontSize = 64.sp
                    )
                }
            }
        }
    }
}