package com.novitaguok.shelterit.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItTheme
import kotlin.math.abs
import androidx.compose.ui.graphics.lerp as colorLerp
import androidx.compose.ui.unit.lerp as dpLerp

/**
 * "Dots" — the active dot is a 22×7 primary pill, the others 7dp outlineVariant circles,
 * 6dp apart.
 *
 * The indicator is driven by the pager's *continuous* position
 * (`currentPage + currentPageOffsetFraction`) instead of a discrete index, so the pill
 * grows out of one dot and into the next while the finger is still dragging, and the
 * colour cross-fades over the same fraction. No animation state is needed: the pager
 * itself is the animation clock.
 */
@Composable
fun ShelterItPageIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    activeColor: Color = ShelterItTheme.colors.primary,
    inactiveColor: Color = ShelterItTheme.colors.outlineVariant,
) {
    val position by remember(pagerState) {
        derivedStateOf { pagerState.currentPage + pagerState.currentPageOffsetFraction }
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(pagerState.pageCount) { index ->
            // 1f when this dot is the current one, 0f once it is a full page away.
            val selected = (1f - abs(position - index)).coerceIn(0f, 1f)

            Box(
                modifier = Modifier
                    .size(width = dpLerp(7.dp, 22.dp, selected), height = 7.dp)
                    .clip(CircleShape)
                    .background(colorLerp(inactiveColor, activeColor, selected)),
            )
        }
    }
}