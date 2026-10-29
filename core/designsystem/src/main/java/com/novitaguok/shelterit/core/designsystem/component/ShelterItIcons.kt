package com.novitaguok.shelterit.core.designsystem.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.VerifiedUser
import androidx.compose.ui.graphics.vector.ImageVector

object ShelterItIcons {
    val PawPrint: ImageVector = Icons.Rounded.Pets // lucide "paw-print"
    val Heart: ImageVector = Icons.Rounded.Favorite // lucide "heart" (filled)
    val HeartOutline: ImageVector = Icons.Rounded.FavoriteBorder
    val Search: ImageVector = Icons.Rounded.Search
    val Add: ImageVector = Icons.Rounded.Add // lucide "plus"
    val Home: ImageVector = Icons.Rounded.Home // lucide "house"
    val Person: ImageVector = Icons.Rounded.Person // lucide "user"
    val MapPin: ImageVector = Icons.Rounded.LocationOn
    val ChevronRight: ImageVector = Icons.Rounded.ChevronRight
    val Check: ImageVector = Icons.Rounded.Check
    val ArrowRight: ImageVector = Icons.AutoMirrored.Rounded.ArrowForward // lucide "arrow-right"
    val ShieldCheck: ImageVector = Icons.Rounded.VerifiedUser // lucide "shield-check"
    val Clock: ImageVector = Icons.Rounded.Schedule // lucide "clock"
}
