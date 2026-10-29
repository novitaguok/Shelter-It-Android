package com.novitaguok.shelterit.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.novitaguok.shelterit.designsystem.R


/**
 * "Logo Mark" (page 1): 92dp square, radius-xl, 200° linear brand gradient, soft warm
 * drop shadow. Modifier.shadow() cannot offset a shadow, so the design's 12dp y-offset
 * is approximated with elevation plus a tinted spot/ambient colour.
 */
@Composable
fun ShelterItLogo(modifier: Modifier = Modifier) {
    val markGradient = listOf(Color(0xFFC4650F), Color(0xFF9C4A10), Color(0xFF6E2C04))
    val markShadowColor = Color(0x559C4A10)
    val shape = RoundedCornerShape(28.dp)

    Box(
        modifier = modifier
            .size(92.dp)
            .shadow(
                elevation = 12.dp,
                shape = shape,
                ambientColor = markShadowColor,
                spotColor = markShadowColor,
            )
            .clip(shape)
            .drawBehind {
                // 200° CCW from straight up -> down and slightly to the right.
                val dir = Offset(0.342f, 0.940f)
                val length = size.width * dir.x + size.height * dir.y
                val center = Offset(size.width / 2f, size.height / 2f)
                drawRect(
                    brush = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to markGradient[0],
                            0.55f to markGradient[1],
                            1f to markGradient[2],
                        ),
                        start = center - dir * (length / 2f),
                        end = center + dir * (length / 2f),
                    ),
                )
            },
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.ic_shelter_mark),
            contentDescription = null,
            modifier = Modifier.size(66.dp),
        )
    }
}
