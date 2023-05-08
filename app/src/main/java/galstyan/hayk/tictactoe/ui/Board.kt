package galstyan.hayk.tictactoe.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import galstyan.hayk.tictactoe.ui.components.VerticalGrid
import galstyan.hayk.tictactoe.ui.theme.AppTheme

@Composable
fun Board(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .width(300.dp)
            .height(300.dp)
    ) {
        repeat(3) {
            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                border = BorderStroke(4.dp, Color.Green)
            ) {

            }
        }
    }
}


@Composable
@Preview
fun BoardPreview() {
    AppTheme {
        Board(Modifier.fillMaxSize())
    }
}