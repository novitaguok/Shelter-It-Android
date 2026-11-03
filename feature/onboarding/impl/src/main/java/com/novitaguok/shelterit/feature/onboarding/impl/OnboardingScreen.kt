package com.novitaguok.shelterit.feature.onboarding.impl

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.novitaguok.shelterit.core.designsystem.component.ShelterItFilledButton
import com.novitaguok.shelterit.core.designsystem.component.ShelterItIcons
import com.novitaguok.shelterit.core.designsystem.component.ShelterItLogo
import com.novitaguok.shelterit.core.designsystem.component.ShelterItPageIndicator
import com.novitaguok.shelterit.core.designsystem.theme.Inter
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItSpacing.spaceMd
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItSpacing.spaceSm
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItSpacing.spaceXl
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItTheme
import com.novitaguok.shelterit.feature.onboarding.impl.model.DefaultOnboardingPages
import com.novitaguok.shelterit.feature.onboarding.impl.model.OnboardingPage
import com.novitaguok.shelterit.feature.onboarding.impl.model.SecondaryAction
import kotlinx.coroutines.launch

private val PhotoShadowColor = Color(0x40000000)

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    pages: List<OnboardingPage> = DefaultOnboardingPages,
    onFinish: () -> Unit = {},
    onSkip: () -> Unit = {},
    onSignIn: () -> Unit = {},
) {
    val background = Brush.verticalGradient(
        colors = listOf(
            ShelterItTheme.extendedColors.bgGradientTop,
            ShelterItTheme.extendedColors.bgGradientBottom
        ),
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })
    val scope = rememberCoroutineScope()
    val currentPageData = pages[pagerState.currentPage]
    val isLastPage = pagerState.currentPage == pages.lastIndex

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(background)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        // Onboard Hero
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(28.dp),
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) { index ->
                OnboardingPageContent(pages[index])
            }

            ShelterItPageIndicator(pagerState)
        }

        // Onboard CTA
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(spaceXl),
            verticalArrangement = Arrangement.spacedBy(spaceSm),
        ) {
            ShelterItFilledButton(
                text = currentPageData.ctaLabel,
                icon = ShelterItIcons.ArrowRight,
                onClick = {
                    if (isLastPage) {
                        onFinish()
                    } else {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
            )

            TextButton(
                onClick = {
                    when (currentPageData.secondaryAction) {
                        SecondaryAction.SKIP -> onSkip()
                        SecondaryAction.SIGN_IN -> onSignIn()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = spaceMd),
            ) {
                Text(
                    text = currentPageData.secondaryLabel,
                    color = ShelterItTheme.colors.primary,
                    style = ShelterItTheme.typography.bodyMedium,
                )
            }
        }
    }
}

/**
 * Page body: art, headline and sub copy, bottom-anchored inside the pager page so the
 * copy block keeps its 28dp rhythm no matter how tall the device is.
 */
@Composable
private fun OnboardingPageContent(
    page: OnboardingPage,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(28.dp, Alignment.Bottom),
    ) {
        if (page.photoUrl == null) {
            ShelterItLogo()
        } else {
            ProofPhoto(url = page.photoUrl, icon = page.chipIcon, label = page.chipLabel)
        }

        Text(
            text = page.headline,
            modifier = Modifier.fillMaxWidth(),
            color = ShelterItTheme.colors.onSurface,
            textAlign = TextAlign.Center,
            style = ShelterItTheme.typography.displayLarge
        )

        Text(
            text = page.body,
            modifier = Modifier.fillMaxWidth(),
            color = ShelterItTheme.colors.onSurfaceVariant,
            textAlign = TextAlign.Center,
            style = ShelterItTheme.typography.bodyMedium,
        )
    }
}

/**
 * Photo wrap (pages 2 and 3)
 * TODO(later move is reusable)
 */
@Composable
private fun ProofPhoto(
    url: String,
    icon: ImageVector?,
    label: String?,
    modifier: Modifier = Modifier,
) {
    val shape = RoundedCornerShape(26.dp)

    Box(
        modifier = modifier
            .size(200.dp)
            .shadow(
                elevation = 18.dp,
                shape = shape,
                ambientColor = PhotoShadowColor,
                spotColor = PhotoShadowColor,
            )
            .clip(shape)
            .background(ShelterItTheme.colors.surfaceVariant),
    ) {
        AsyncImage(
            model = url,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )

        if (icon != null && label != null) {
            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 12.dp, bottom = 23.dp)
                    .background(ShelterItTheme.colors.surface, CircleShape)
                    .padding(horizontal = 10.dp, vertical = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = ShelterItTheme.colors.secondary,
                    modifier = Modifier.size(12.dp),
                )
                Text(
                    text = label,
                    color = ShelterItTheme.colors.onSurface,
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 11.sp,
                    ),
                )
            }
        }
    }
}

@Preview(name = "Onboarding — light", showBackground = true)
@Composable
private fun OnboardingScreenLightPreview() {
    ShelterItTheme(darkTheme = false) { OnboardingScreen() }
}

@Preview(name = "Onboarding — dark", showBackground = true)
@Composable
private fun OnboardingScreenDarkPreview() {
    ShelterItTheme(darkTheme = true) { OnboardingScreen() }
}
