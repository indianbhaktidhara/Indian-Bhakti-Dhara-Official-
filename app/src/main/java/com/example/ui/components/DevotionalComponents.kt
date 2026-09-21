package com.example.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.OpenInBrowser
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.audio.SacredSoundManager
import com.example.data.AudioChantTrack
import com.example.data.DevotionalMedia
import com.example.data.DevotionalRepository
import com.example.data.PlatformLink
import com.example.data.SacredFestival
import com.example.data.SacredSloka
import com.example.ui.theme.DarkTextSecondary
import com.example.ui.theme.EmeraldAuspicious
import com.example.ui.theme.GoldAccent
import com.example.ui.theme.GoldDark
import com.example.ui.theme.GoldLight
import com.example.ui.theme.MaroonCard
import com.example.ui.theme.MaroonDeep
import com.example.ui.theme.MaroonSurface
import com.example.ui.theme.SacredIvory
import com.example.ui.theme.SacredIvoryMuted
import com.example.ui.theme.SaffronDark
import com.example.ui.theme.SaffronGlow
import com.example.ui.theme.SaffronLight
import com.example.ui.theme.SaffronPrimary
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TopSacredBar(
    onRingBell: () -> Unit,
    onBlowShankh: () -> Unit,
    onToggleDiya: () -> Unit,
    isDiyaLit: Boolean,
    onOpenAbout: () -> Unit,
    onAddMedia: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaroonCard.copy(alpha = 0.95f)),
        border = BorderStroke(1.dp, GoldAccent.copy(alpha = 0.35f)),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                // Sacred Om Emblem
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.radialGradient(
                                colors = listOf(SaffronLight, SaffronDark)
                            )
                        )
                        .border(1.5.dp, GoldAccent, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "ॐ",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = SacredIvory
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = "Indian Bhakti Dhara",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = GoldLight,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "Sacred Devotional Hub & Sanatan Wisdom",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = SaffronGlow,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                // Ghanti / Temple Bell Sound button
                IconButton(
                    onClick = onRingBell,
                    modifier = Modifier
                        .size(36.dp)
                        .background(GoldAccent.copy(alpha = 0.12f), CircleShape)
                        .border(1.dp, GoldAccent.copy(alpha = 0.4f), CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Temple Bell",
                        tint = GoldAccent,
                        modifier = Modifier.size(18.dp)
                    )
                }

                Spacer(modifier = Modifier.width(6.dp))

                // Shankh / Conch button
                IconButton(
                    onClick = onBlowShankh,
                    modifier = Modifier
                        .size(36.dp)
                        .background(SaffronPrimary.copy(alpha = 0.15f), CircleShape)
                        .border(1.dp, SaffronPrimary.copy(alpha = 0.4f), CircleShape)
                ) {
                    Text(
                        text = "🐚",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.width(6.dp))

                // Diya toggle button
                IconButton(
                    onClick = onToggleDiya,
                    modifier = Modifier
                        .size(36.dp)
                        .background(
                            if (isDiyaLit) SaffronPrimary.copy(alpha = 0.3f) else MaroonSurface,
                            CircleShape
                        )
                        .border(
                            1.dp,
                            if (isDiyaLit) GoldAccent else GoldAccent.copy(alpha = 0.3f),
                            CircleShape
                        )
                ) {
                    Text(
                        text = if (isDiyaLit) "🪔" else "🕯️",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.width(6.dp))

                // Add content button
                IconButton(
                    onClick = onAddMedia,
                    modifier = Modifier
                        .size(36.dp)
                        .background(
                            Brush.horizontalGradient(listOf(SaffronPrimary, GoldDark)),
                            CircleShape
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Media",
                        tint = MaroonDeep,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun VirtualDiyaBanner(
    isLit: Boolean,
    onToggle: () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "flame")
    val flameScale by infiniteTransition.animateFloat(
        initialValue = 0.92f,
        targetValue = 1.15f,
        animationSpec = infiniteRepeatable(
            animation = tween(400, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "flameScale"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaroonSurface.copy(alpha = 0.85f)),
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(1.dp, GoldDark.copy(alpha = 0.35f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clickable { onToggle() },
                    contentAlignment = Alignment.Center
                ) {
                    if (isLit) {
                        // Radiant halo
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .scale(flameScale)
                                .clip(CircleShape)
                                .background(
                                    Brush.radialGradient(
                                        colors = listOf(
                                            GoldLight.copy(alpha = 0.8f),
                                            SaffronPrimary.copy(alpha = 0.4f),
                                            Color.Transparent
                                        )
                                    )
                                )
                        )
                        Text(
                            text = "🪔",
                            fontSize = 26.sp,
                            modifier = Modifier.scale(flameScale)
                        )
                    } else {
                        Text(
                            text = "🪔",
                            fontSize = 24.sp,
                            modifier = Modifier.alpha(0.6f)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = if (isLit) "ॐ दीपज्योतिः परंब्रह्म दीपो ज्योतिर्जनार्दनः" else "Pavitra Akhand Diya",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = GoldLight
                    )
                    Text(
                        text = if (isLit) "Blessed Eternal Flame Lit • Har Har Mahadev" else "Tap diya to light up and receive divine blessings",
                        fontSize = 11.sp,
                        color = SacredIvoryMuted
                    )
                }
            }

            OutlinedButton(
                onClick = onToggle,
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, GoldAccent.copy(alpha = 0.6f)),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = GoldLight
                ),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text(
                    text = if (isLit) "Extinguish" else "Light Diya",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun MediaStudioScreen(
    mediaList: List<DevotionalMedia>,
    onToggleFavorite: (String) -> Unit,
    onDeleteMedia: (String) -> Unit,
    onWatchDirect: (DevotionalMedia) -> Unit,
    onOpenAddModal: () -> Unit
) {
    var selectedTypeFilter by remember { mutableStateOf("all") } // "all", "video", "short"
    var selectedCategory by remember { mutableStateOf("all") }
    var selectedLibraryFilter by remember { mutableStateOf("all") } // "all", "favorites"
    var searchQuery by remember { mutableStateOf("") }
    var categoryExpanded by remember { mutableStateOf(false) }

    val categories = listOf(
        "all",
        "Aarti & Stotra",
        "Bhakti Sangeet",
        "Daily Mantras",
        "Katha & Pravachan",
        "Festival Special"
    )

    val filteredList = mediaList.filter { item ->
        val matchType = selectedTypeFilter == "all" || item.type == selectedTypeFilter
        val matchCategory = selectedCategory == "all" || item.category == selectedCategory
        val matchFavorite = selectedLibraryFilter == "all" || (selectedLibraryFilter == "favorites" && item.isFavorite)
        val matchSearch = searchQuery.isBlank() ||
                item.title.contains(searchQuery, ignoreCase = true) ||
                item.category.contains(searchQuery, ignoreCase = true) ||
                item.tag.contains(searchQuery, ignoreCase = true)
        matchType && matchCategory && matchFavorite && matchSearch
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        // Search and Add Header
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaroonCard.copy(alpha = 0.9f)),
                border = BorderStroke(1.dp, GoldAccent.copy(alpha = 0.25f)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            placeholder = {
                                Text(
                                    "Search Shiva, Krishna, Gayatri...",
                                    fontSize = 12.sp,
                                    color = SacredIvoryMuted
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Search,
                                    contentDescription = null,
                                    tint = GoldAccent,
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            trailingIcon = {
                                if (searchQuery.isNotEmpty()) {
                                    IconButton(onClick = { searchQuery = "" }) {
                                        Icon(
                                            Icons.Default.Clear,
                                            contentDescription = "Clear",
                                            tint = GoldAccent,
                                            modifier = Modifier.size(16.dp)
                                        )
                                    }
                                }
                            },
                            singleLine = true,
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = GoldAccent,
                                unfocusedBorderColor = GoldDark.copy(alpha = 0.4f),
                                focusedTextColor = SacredIvory,
                                unfocusedTextColor = SacredIvory,
                                focusedContainerColor = MaroonSurface,
                                unfocusedContainerColor = MaroonSurface
                            )
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        ElevatedButton(
                            onClick = onOpenAddModal,
                            shape = RoundedCornerShape(24.dp),
                            colors = ButtonDefaults.elevatedButtonColors(
                                containerColor = SaffronPrimary,
                                contentColor = MaroonDeep
                            ),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
                        ) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Add", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Type Filter Chips: All, Long Videos, Sacred Shorts
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        FilterChip(
                            selected = selectedTypeFilter == "all",
                            onClick = { selectedTypeFilter = "all" },
                            label = { Text("All (${mediaList.size})", fontSize = 11.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = GoldAccent,
                                selectedLabelColor = MaroonDeep,
                                containerColor = MaroonSurface,
                                labelColor = SacredIvory
                            ),
                            border = FilterChipDefaults.filterChipBorder(
                                enabled = true,
                                selected = selectedTypeFilter == "all",
                                borderColor = GoldAccent.copy(alpha = 0.5f),
                                selectedBorderColor = GoldAccent
                            )
                        )

                        FilterChip(
                            selected = selectedTypeFilter == "video",
                            onClick = { selectedTypeFilter = "video" },
                            label = {
                                Text(
                                    "Long Videos (${mediaList.count { it.type == "video" }})",
                                    fontSize = 11.sp
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = GoldAccent,
                                selectedLabelColor = MaroonDeep,
                                containerColor = MaroonSurface,
                                labelColor = SacredIvory
                            ),
                            border = FilterChipDefaults.filterChipBorder(
                                enabled = true,
                                selected = selectedTypeFilter == "video",
                                borderColor = GoldAccent.copy(alpha = 0.5f),
                                selectedBorderColor = GoldAccent
                            )
                        )

                        FilterChip(
                            selected = selectedTypeFilter == "short",
                            onClick = { selectedTypeFilter = "short" },
                            label = {
                                Text(
                                    "Sacred Shorts (${mediaList.count { it.type == "short" }})",
                                    fontSize = 11.sp
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = GoldAccent,
                                selectedLabelColor = MaroonDeep,
                                containerColor = MaroonSurface,
                                labelColor = SacredIvory
                            ),
                            border = FilterChipDefaults.filterChipBorder(
                                enabled = true,
                                selected = selectedTypeFilter == "short",
                                borderColor = GoldAccent.copy(alpha = 0.5f),
                                selectedBorderColor = GoldAccent
                            )
                        )

                        FilterChip(
                            selected = selectedLibraryFilter == "favorites",
                            onClick = {
                                selectedLibraryFilter = if (selectedLibraryFilter == "favorites") "all" else "favorites"
                            },
                            label = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        Icons.Default.Bookmark,
                                        contentDescription = null,
                                        modifier = Modifier.size(13.dp)
                                    )
                                    Spacer(modifier = Modifier.width(3.dp))
                                    Text(
                                        "Saved (${mediaList.count { it.isFavorite }})",
                                        fontSize = 11.sp
                                    )
                                }
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = SaffronPrimary,
                                selectedLabelColor = MaroonDeep,
                                containerColor = MaroonSurface,
                                labelColor = SacredIvory
                            ),
                            border = FilterChipDefaults.filterChipBorder(
                                enabled = true,
                                selected = selectedLibraryFilter == "favorites",
                                borderColor = SaffronPrimary.copy(alpha = 0.5f),
                                selectedBorderColor = SaffronPrimary
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    // Category Selector
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Category: ${if (selectedCategory == "all") "All Categories" else selectedCategory}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = SaffronGlow
                        )

                        Box {
                            TextButton(onClick = { categoryExpanded = true }) {
                                Icon(
                                    Icons.Default.FilterList,
                                    contentDescription = null,
                                    tint = GoldAccent,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Filter", color = GoldAccent, fontSize = 11.sp)
                            }

                            DropdownMenu(
                                expanded = categoryExpanded,
                                onDismissRequest = { categoryExpanded = false },
                                modifier = Modifier.background(MaroonSurface)
                            ) {
                                categories.forEach { cat ->
                                    DropdownMenuItem(
                                        text = {
                                            Text(
                                                text = if (cat == "all") "All Categories" else cat,
                                                color = if (selectedCategory == cat) GoldAccent else SacredIvory,
                                                fontSize = 12.sp,
                                                fontWeight = if (selectedCategory == cat) FontWeight.Bold else FontWeight.Normal
                                            )
                                        },
                                        onClick = {
                                            selectedCategory = cat
                                            categoryExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // Media Item Cards
        if (filteredList.isEmpty()) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaroonSurface.copy(alpha = 0.7f)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "🕉️", fontSize = 36.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "No devotional items found",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = GoldLight
                        )
                        Text(
                            text = "Try adjusting your search or tap '+ Add' to publish a new video or short.",
                            fontSize = 12.sp,
                            color = DarkTextSecondary,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        } else {
            items(filteredList, key = { it.id }) { item ->
                DevotionalMediaCard(
                    item = item,
                    onToggleFavorite = { onToggleFavorite(item.id) },
                    onDelete = { onDeleteMedia(item.id) },
                    onWatch = { onWatchDirect(item) }
                )
            }
        }
    }
}

@Composable
fun DevotionalMediaCard(
    item: DevotionalMedia,
    onToggleFavorite: () -> Unit,
    onDelete: () -> Unit,
    onWatch: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaroonCard),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, GoldDark.copy(alpha = 0.3f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            // Thumbnail with Play overlay and Tag
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(if (item.type == "short") 16f / 9f else 16f / 9f)
                    .background(Color.Black)
                    .clickable { onWatch() }
            ) {
                AsyncImage(
                    model = item.thumbUrl,
                    contentDescription = item.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Dark gradient overlay
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    MaroonDeep.copy(alpha = 0.85f)
                                )
                            )
                        )
                )

                // Type Badge: Sacred Short or Long Video
                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                if (item.type == "short") SaffronDark else Color(0xFFC62828),
                                RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = if (item.type == "short") "📱 SACRED SHORT" else "▶ LONG VIDEO",
                            color = Color.White,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.5.sp
                        )
                    }
                }

                // Play Button Icon in Center
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .align(Alignment.Center)
                        .clip(CircleShape)
                        .background(SaffronPrimary.copy(alpha = 0.9f))
                        .border(1.5.dp, GoldLight, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play",
                        tint = MaroonDeep,
                        modifier = Modifier.size(28.dp)
                    )
                }

                // Bottom Bar Tag
                Text(
                    text = item.tag,
                    color = GoldLight,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(8.dp)
                )
            }

            // Info Content
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = item.category.uppercase(),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = SaffronLight,
                    letterSpacing = 0.5.sp
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = item.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = SacredIvory,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider(color = GoldDark.copy(alpha = 0.2f))
                Spacer(modifier = Modifier.height(6.dp))

                // Actions row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = onWatch,
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = SaffronPrimary,
                            contentColor = MaroonDeep
                        ),
                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp)
                    ) {
                        Icon(
                            Icons.Default.PlayArrow,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Watch Direct",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = onToggleFavorite) {
                            Icon(
                                imageVector = if (item.isFavorite) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                                contentDescription = "Favorite",
                                tint = if (item.isFavorite) SaffronPrimary else DarkTextSecondary,
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        IconButton(onClick = onDelete) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete",
                                tint = DarkTextSecondary.copy(alpha = 0.7f),
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MalaSanctuaryScreen(
    currentTrack: AudioChantTrack,
    isPlaying: Boolean,
    onTogglePlayTrack: () -> Unit,
    onNextTrack: () -> Unit,
    onPrevTrack: () -> Unit,
    onSelectTrack: (AudioChantTrack) -> Unit
) {
    var malaBeadCount by remember { mutableIntStateOf(0) }
    var malaCycleCount by remember { mutableIntStateOf(0) }
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    val infiniteTransition = rememberInfiniteTransition(label = "equalizer")
    val bar1 by infiniteTransition.animateFloat(
        initialValue = 0.3f, targetValue = 1.0f,
        animationSpec = infiniteRepeatable(tween(350, easing = LinearEasing), RepeatMode.Reverse),
        label = "b1"
    )
    val bar2 by infiniteTransition.animateFloat(
        initialValue = 0.5f, targetValue = 0.9f,
        animationSpec = infiniteRepeatable(tween(250, easing = LinearEasing), RepeatMode.Reverse),
        label = "b2"
    )
    val bar3 by infiniteTransition.animateFloat(
        initialValue = 0.2f, targetValue = 0.85f,
        animationSpec = infiniteRepeatable(tween(420, easing = LinearEasing), RepeatMode.Reverse),
        label = "b3"
    )
    val bar4 by infiniteTransition.animateFloat(
        initialValue = 0.6f, targetValue = 1.0f,
        animationSpec = infiniteRepeatable(tween(310, easing = LinearEasing), RepeatMode.Reverse),
        label = "b4"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        // 108 Mala Japa Interactive Engine
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaroonCard),
                shape = RoundedCornerShape(22.dp),
                border = BorderStroke(1.dp, GoldAccent.copy(alpha = 0.4f)),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "📿", fontSize = 18.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "108 Mala Japa Sanctuary",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = SaffronLight
                            )
                        }

                        IconButton(
                            onClick = {
                                malaBeadCount = 0
                                malaCycleCount = 0
                                Toast.makeText(context, "Mala counter reset", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.size(30.dp)
                        ) {
                            Icon(
                                Icons.Default.Refresh,
                                contentDescription = "Reset",
                                tint = DarkTextSecondary,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Circular / Bead Display
                    Box(
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.radialGradient(
                                    colors = listOf(
                                        MaroonSurface,
                                        MaroonDeep
                                    )
                                )
                            )
                            .border(2.dp, GoldAccent, CircleShape)
                            .clickable {
                                malaBeadCount++
                                SacredSoundManager.playMalaBeadClick()
                                if (malaBeadCount >= 108) {
                                    malaBeadCount = 0
                                    malaCycleCount++
                                    SacredSoundManager.playTempleBell()
                                    Toast.makeText(
                                        context,
                                        "ॐ 108 Mala Cycle Completed! Har Har Mahadev!",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "$malaBeadCount",
                                fontSize = 38.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = GoldLight
                            )
                            Text(
                                text = "of 108 Beads",
                                fontSize = 11.sp,
                                color = SaffronGlow,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = "TAP TO CHANT",
                                fontSize = 9.sp,
                                color = DarkTextSecondary,
                                letterSpacing = 1.sp,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Cycle Counter Banner
                    Row(
                        modifier = Modifier
                            .background(GoldAccent.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                            .border(1.dp, GoldAccent.copy(alpha = 0.3f), RoundedCornerShape(12.dp))
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Completed Malas: ",
                            fontSize = 12.sp,
                            color = SacredIvoryMuted
                        )
                        Text(
                            text = "$malaCycleCount",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = GoldLight
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "(${malaCycleCount * 108 + malaBeadCount} Total Chants)",
                            fontSize = 11.sp,
                            color = SaffronLight
                        )
                    }
                }
            }
        }

        // Ambient Audio Chanting Sanctuary Player
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaroonCard),
                shape = RoundedCornerShape(22.dp),
                border = BorderStroke(1.dp, GoldAccent.copy(alpha = 0.4f)),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "VEDIC AUDIO CHANT PLAYER",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = SaffronLight,
                            letterSpacing = 1.sp
                        )

                        // Equalizer bars
                        Row(
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.spacedBy(3.dp),
                            modifier = Modifier.height(18.dp)
                        ) {
                            val active = isPlaying
                            Box(
                                modifier = Modifier
                                    .width(3.dp)
                                    .height(if (active) (18 * bar1).dp else 4.dp)
                                    .background(GoldAccent, RoundedCornerShape(2.dp))
                            )
                            Box(
                                modifier = Modifier
                                    .width(3.dp)
                                    .height(if (active) (18 * bar2).dp else 6.dp)
                                    .background(SaffronPrimary, RoundedCornerShape(2.dp))
                            )
                            Box(
                                modifier = Modifier
                                    .width(3.dp)
                                    .height(if (active) (18 * bar3).dp else 8.dp)
                                    .background(GoldLight, RoundedCornerShape(2.dp))
                            )
                            Box(
                                modifier = Modifier
                                    .width(3.dp)
                                    .height(if (active) (18 * bar4).dp else 5.dp)
                                    .background(SaffronLight, RoundedCornerShape(2.dp))
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = currentTrack.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = GoldLight,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = currentTrack.deity,
                        fontSize = 12.sp,
                        color = SacredIvoryMuted
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Player Controls
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = onPrevTrack,
                            modifier = Modifier.size(44.dp)
                        ) {
                            Icon(
                                Icons.Default.SkipPrevious,
                                contentDescription = "Previous",
                                tint = GoldLight,
                                modifier = Modifier.size(28.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(CircleShape)
                                .background(
                                    Brush.radialGradient(
                                        colors = listOf(SaffronLight, SaffronPrimary)
                                    )
                                )
                                .border(2.dp, GoldLight, CircleShape)
                                .clickable { onTogglePlayTrack() },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                                contentDescription = if (isPlaying) "Pause" else "Play",
                                tint = MaroonDeep,
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        IconButton(
                            onClick = onNextTrack,
                            modifier = Modifier.size(44.dp)
                        ) {
                            Icon(
                                Icons.Default.SkipNext,
                                contentDescription = "Next",
                                tint = GoldLight,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalDivider(color = GoldDark.copy(alpha = 0.25f))
                    Spacer(modifier = Modifier.height(12.dp))

                    // Playlist selection
                    Text(
                        text = "Sacred Playlist",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = SaffronLight
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    DevotionalRepository.audioPlaylist.forEach { track ->
                        val isSelected = track.id == currentTrack.id
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(
                                    if (isSelected) GoldAccent.copy(alpha = 0.15f) else MaroonSurface.copy(alpha = 0.6f)
                                )
                                .border(
                                    1.dp,
                                    if (isSelected) GoldAccent else Color.Transparent,
                                    RoundedCornerShape(12.dp)
                                )
                                .clickable { onSelectTrack(track) }
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = if (isSelected && isPlaying) "🔊" else "🎵",
                                    fontSize = 14.sp
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Text(
                                        text = track.title,
                                        fontSize = 12.sp,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                        color = if (isSelected) GoldLight else SacredIvory
                                    )
                                    Text(
                                        text = track.deity,
                                        fontSize = 10.sp,
                                        color = SacredIvoryMuted
                                    )
                                }
                            }

                            Text(
                                text = track.duration,
                                fontSize = 10.sp,
                                color = SaffronLight,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PanchangAndSlokaScreen() {
    val clipboardManager = LocalClipboardManager.current
    val context = LocalContext.current
    var currentSlokaIndex by remember { mutableIntStateOf(0) }
    val slokas = DevotionalRepository.sacredSlokas
    val currentSloka = slokas[currentSlokaIndex % slokas.size]

    val currentDateFormatted = remember {
        val sdf = SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.ENGLISH)
        sdf.format(Date())
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        // Daily Vedic Panchang
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaroonCard),
                shape = RoundedCornerShape(22.dp),
                border = BorderStroke(1.dp, GoldAccent.copy(alpha = 0.4f)),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "AUSPICIOUS TIMINGS",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = SaffronLight,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "Daily Vedic Panchang",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = GoldLight
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(38.dp)
                                .clip(CircleShape)
                                .background(GoldAccent.copy(alpha = 0.15f))
                                .border(1.dp, GoldAccent.copy(alpha = 0.5f), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "☀️", fontSize = 18.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    PanchangRow(icon = "📅", label = "Today's Date", value = currentDateFormatted)
                    HorizontalDivider(color = GoldDark.copy(alpha = 0.15f), modifier = Modifier.padding(vertical = 6.dp))

                    PanchangRow(icon = "🌙", label = "Tithi (Lunar Phase)", value = "Shukla Paksha Ekadashi")
                    HorizontalDivider(color = GoldDark.copy(alpha = 0.15f), modifier = Modifier.padding(vertical = 6.dp))

                    PanchangRow(icon = "⭐", label = "Nakshatra", value = "Rohini Nakshatra")
                    HorizontalDivider(color = GoldDark.copy(alpha = 0.15f), modifier = Modifier.padding(vertical = 6.dp))

                    PanchangRow(icon = "☸️", label = "Yoga", value = "Siddhi Yoga (Auspicious)")
                    HorizontalDivider(color = GoldDark.copy(alpha = 0.15f), modifier = Modifier.padding(vertical = 6.dp))

                    PanchangRow(icon = "⏳", label = "Abhijit Muhurat", value = "11:54 AM - 12:42 PM", isHighlight = true)
                    HorizontalDivider(color = GoldDark.copy(alpha = 0.15f), modifier = Modifier.padding(vertical = 6.dp))

                    PanchangRow(icon = "⚠️", label = "Rahu Kaal", value = "04:30 PM - 06:00 PM")
                    HorizontalDivider(color = GoldDark.copy(alpha = 0.15f), modifier = Modifier.padding(vertical = 6.dp))

                    PanchangRow(icon = "🌅", label = "Sunrise / Sunset", value = "06:12 AM / 06:34 PM")
                }
            }
        }

        // Daily Vedic Mantra of the Day
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaroonCard),
                shape = RoundedCornerShape(22.dp),
                border = BorderStroke(1.dp, GoldAccent.copy(alpha = 0.4f)),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "VEDIC MANTRA OF THE DAY",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = SaffronLight,
                            letterSpacing = 1.sp
                        )

                        OutlinedButton(
                            onClick = { currentSlokaIndex++ },
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(1.dp, GoldAccent.copy(alpha = 0.5f)),
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Icon(
                                Icons.Default.Refresh,
                                contentDescription = null,
                                tint = GoldLight,
                                modifier = Modifier.size(13.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Next Mantra", fontSize = 11.sp, color = GoldLight)
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Sanskrit verses
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaroonDeep, RoundedCornerShape(14.dp))
                            .border(1.dp, GoldAccent.copy(alpha = 0.3f), RoundedCornerShape(14.dp))
                            .padding(14.dp)
                    ) {
                        Text(
                            text = currentSloka.sanskrit,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = GoldLight,
                            lineHeight = 24.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Hindi Translation
                    Text(
                        text = "हिंदी अनुवाद:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = SaffronLight
                    )
                    Text(
                        text = currentSloka.hindi,
                        fontSize = 12.sp,
                        color = SacredIvory,
                        lineHeight = 18.sp,
                        modifier = Modifier.padding(top = 2.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // English Translation
                    Text(
                        text = "English Meaning:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = SaffronLight
                    )
                    Text(
                        text = currentSloka.english,
                        fontSize = 12.sp,
                        color = SacredIvoryMuted,
                        lineHeight = 18.sp,
                        modifier = Modifier.padding(top = 2.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = currentSloka.source,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = GoldAccent,
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Copy Sloka button
                    Button(
                        onClick = {
                            val textToCopy = "${currentSloka.sanskrit}\n\n${currentSloka.hindi}\n\n${currentSloka.english}\n\n${currentSloka.source}"
                            clipboardManager.setText(AnnotatedString(textToCopy))
                            Toast.makeText(context, "Mantra copied to clipboard!", Toast.LENGTH_SHORT).show()
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaroonSurface,
                            contentColor = GoldLight
                        ),
                        border = BorderStroke(1.dp, GoldAccent.copy(alpha = 0.4f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            Icons.Default.ContentCopy,
                            contentDescription = "Copy",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Copy Mantra & Meaning", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun PanchangRow(
    icon: String,
    label: String,
    value: String,
    isHighlight: Boolean = false
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = icon, fontSize = 14.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = label,
                fontSize = 12.sp,
                color = SacredIvoryMuted
            )
        }
        Text(
            text = value,
            fontSize = 12.sp,
            fontWeight = if (isHighlight) FontWeight.Bold else FontWeight.Medium,
            color = if (isHighlight) EmeraldAuspicious else GoldLight
        )
    }
}

@Composable
fun PlatformsHubScreen() {
    val context = LocalContext.current
    val platforms = DevotionalRepository.officialPlatforms

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaroonCard),
                shape = RoundedCornerShape(18.dp),
                border = BorderStroke(1.dp, GoldAccent.copy(alpha = 0.35f))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "11+ OFFICIAL PLATFORMS HUB",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = SaffronLight,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "Connect With Indian Bhakti Dhara",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = GoldLight
                    )
                    Text(
                        text = "Join our expanding global Sanatan community across YouTube, Instagram, WhatsApp, Telegram, and more.",
                        fontSize = 11.sp,
                        color = SacredIvoryMuted,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }

        items(platforms, key = { it.name }) { platform ->
            PlatformCard(
                platform = platform,
                onOpen = {
                    try {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(platform.url))
                        context.startActivity(intent)
                    } catch (_: Exception) {
                        Toast.makeText(context, "Could not open link", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }
}

@Composable
fun PlatformCard(
    platform: PlatformLink,
    onOpen: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaroonCard),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, GoldDark.copy(alpha = 0.25f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(Color(platform.brandColorHex).copy(alpha = 0.2f))
                        .border(1.5.dp, Color(platform.brandColorHex).copy(alpha = 0.6f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = platform.name.take(1),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(platform.brandColorHex)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = platform.name,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = GoldLight
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .background(SaffronPrimary.copy(alpha = 0.2f), RoundedCornerShape(6.dp))
                                .border(1.dp, SaffronPrimary.copy(alpha = 0.4f), RoundedCornerShape(6.dp))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = platform.badge,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = SaffronLight
                            )
                        }
                    }

                    Text(
                        text = platform.description,
                        fontSize = 11.sp,
                        color = SacredIvoryMuted,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(
                onClick = onOpen,
                modifier = Modifier
                    .size(36.dp)
                    .background(MaroonSurface, CircleShape)
                    .border(1.dp, GoldAccent.copy(alpha = 0.4f), CircleShape)
            ) {
                Icon(
                    Icons.Default.OpenInBrowser,
                    contentDescription = "Open",
                    tint = GoldLight,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

@Composable
fun ParvCalendarScreen() {
    val festivals = DevotionalRepository.upcomingFestivals

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaroonCard),
                shape = RoundedCornerShape(18.dp),
                border = BorderStroke(1.dp, GoldAccent.copy(alpha = 0.35f))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "SANATAN PARV",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = SaffronLight,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "Upcoming Sacred Hindu Festivals",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = GoldLight
                    )
                    Text(
                        text = "Major auspicious tithis, divine celebrations, and Vedic rituals throughout the sacred calendar year.",
                        fontSize = 11.sp,
                        color = SacredIvoryMuted,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }

        items(festivals, key = { it.name }) { festival ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaroonCard),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, GoldDark.copy(alpha = 0.3f)),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(SaffronPrimary.copy(alpha = 0.2f))
                            .border(1.dp, GoldAccent.copy(alpha = 0.5f), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "🕉️", fontSize = 18.sp)
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = festival.name,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = GoldLight
                            )
                            Text(
                                text = festival.monthPeriod,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = SaffronLight
                            )
                        }

                        Text(
                            text = "Deity: ${festival.deity}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = GoldDark,
                            modifier = Modifier.padding(top = 2.dp)
                        )

                        Text(
                            text = festival.description,
                            fontSize = 11.sp,
                            color = SacredIvoryMuted,
                            lineHeight = 16.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AddMediaDialog(
    onDismiss: () -> Unit,
    onAddMedia: (DevotionalMedia) -> Unit
) {
    var type by remember { mutableStateOf("video") }
    var title by remember { mutableStateOf("") }
    var youtubeUrl by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("Daily Mantras") }
    var tag by remember { mutableStateOf("") }
    val context = LocalContext.current

    val categories = listOf(
        "Daily Mantras",
        "Aarti & Stotra",
        "Bhakti Sangeet",
        "Katha & Pravachan",
        "Festival Special"
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Add Devotional Content",
                color = GoldLight,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Type selector: Video or Short
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable { type = "video" }
                    ) {
                        RadioButton(
                            selected = type == "video",
                            onClick = { type = "video" },
                            colors = RadioButtonDefaults.colors(selectedColor = GoldAccent)
                        )
                        Text("Long Video", fontSize = 12.sp, color = SacredIvory)
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable { type = "short" }
                    ) {
                        RadioButton(
                            selected = type == "short",
                            onClick = { type = "short" },
                            colors = RadioButtonDefaults.colors(selectedColor = GoldAccent)
                        )
                        Text("Sacred Short", fontSize = 12.sp, color = SacredIvory)
                    }
                }

                // Title
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title (e.g. Shiva Mahamrityunjaya)", fontSize = 11.sp) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = GoldAccent,
                        unfocusedBorderColor = GoldDark.copy(alpha = 0.5f),
                        focusedTextColor = SacredIvory,
                        unfocusedTextColor = SacredIvory
                    )
                )

                // YouTube URL
                OutlinedTextField(
                    value = youtubeUrl,
                    onValueChange = { youtubeUrl = it },
                    label = { Text("YouTube or Short URL / Video ID", fontSize = 11.sp) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = GoldAccent,
                        unfocusedBorderColor = GoldDark.copy(alpha = 0.5f),
                        focusedTextColor = SacredIvory,
                        unfocusedTextColor = SacredIvory
                    )
                )

                // Tag
                OutlinedTextField(
                    value = tag,
                    onValueChange = { tag = it },
                    label = { Text("Tag (e.g. Lord Shiva • 15:00)", fontSize = 11.sp) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = GoldAccent,
                        unfocusedBorderColor = GoldDark.copy(alpha = 0.5f),
                        focusedTextColor = SacredIvory,
                        unfocusedTextColor = SacredIvory
                    )
                )

                // Category selector
                Text(
                    text = "Category:",
                    fontSize = 11.sp,
                    color = SaffronLight,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    categories.forEach { cat ->
                        FilterChip(
                            selected = category == cat,
                            onClick = { category = cat },
                            label = { Text(cat, fontSize = 10.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = GoldAccent,
                                selectedLabelColor = MaroonDeep,
                                containerColor = MaroonSurface,
                                labelColor = SacredIvory
                            )
                        )
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (title.isBlank()) {
                        Toast.makeText(context, "Please enter a title", Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    val extractedId = DevotionalRepository.extractYouTubeId(youtubeUrl)
                    val thumbUrl = if (extractedId.isNotEmpty()) {
                        "https://img.youtube.com/vi/$extractedId/hqdefault.jpg"
                    } else {
                        "https://images.unsplash.com/photo-1545232979-fbf34f5ce757?auto=format&fit=crop&w=600&q=80"
                    }

                    val newMedia = DevotionalMedia(
                        id = "user_${System.currentTimeMillis()}",
                        type = type,
                        title = title.trim(),
                        category = category,
                        tag = if (tag.isNotBlank()) tag.trim() else if (type == "short") "Sacred Short" else "Devotional Video",
                        thumbUrl = thumbUrl,
                        youtubeUrl = youtubeUrl.trim(),
                        youtubeVideoId = extractedId
                    )
                    onAddMedia(newMedia)
                    onDismiss()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = SaffronPrimary,
                    contentColor = MaroonDeep
                )
            ) {
                Text("Publish to Studio", fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel", color = SacredIvoryMuted, fontSize = 12.sp)
            }
        },
        containerColor = MaroonCard
    )
}
