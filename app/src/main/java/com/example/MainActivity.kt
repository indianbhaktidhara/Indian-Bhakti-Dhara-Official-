package com.example

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.audio.SacredSoundManager
import com.example.data.AudioChantTrack
import com.example.data.DevotionalMedia
import com.example.data.DevotionalRepository
import com.example.ui.components.AddMediaDialog
import com.example.ui.components.MalaSanctuaryScreen
import com.example.ui.components.MediaStudioScreen
import com.example.ui.components.PanchangAndSlokaScreen
import com.example.ui.components.ParvCalendarScreen
import com.example.ui.components.PlatformsHubScreen
import com.example.ui.components.TopSacredBar
import com.example.ui.components.VirtualDiyaBanner
import com.example.ui.theme.DarkTextSecondary
import com.example.ui.theme.GoldAccent
import com.example.ui.theme.GoldLight
import com.example.ui.theme.MaroonCard
import com.example.ui.theme.MaroonDeep
import com.example.ui.theme.MaroonSurface
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.SacredIvory
import com.example.ui.theme.SacredIvoryMuted
import com.example.ui.theme.SaffronLight
import com.example.ui.theme.SaffronPrimary

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                IndianBhaktiDharaApp()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        SacredSoundManager.release()
    }
}

/**
 * Kept for existing test compatibility
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

@Composable
fun IndianBhaktiDharaApp() {
    val context = LocalContext.current
    val sharedPrefs = remember {
        context.getSharedPreferences("ibd_preferences", Context.MODE_PRIVATE)
    }

    // Load saved media or defaults
    val mediaItems = remember {
        mutableStateListOf<DevotionalMedia>().apply {
            val savedFavorites = sharedPrefs.getStringSet("favorite_ids", emptySet()) ?: emptySet()
            val initial = DevotionalRepository.initialMediaList.map { item ->
                if (savedFavorites.contains(item.id)) item.copy(isFavorite = true) else item
            }
            addAll(initial)
        }
    }

    var selectedTabIndex by remember { mutableIntStateOf(0) }
    var isDiyaLit by remember { mutableStateOf(true) }
    var isShowAddModal by remember { mutableStateOf(false) }
    var isShowAboutModal by remember { mutableStateOf(false) }

    // Audio Player State
    var currentTrackIndex by remember { mutableIntStateOf(0) }
    val playlist = DevotionalRepository.audioPlaylist
    val currentTrack = playlist[currentTrackIndex % playlist.size]
    var isAudioPlaying by remember { mutableStateOf(false) }

    fun saveFavorites() {
        val favSet = mediaItems.filter { it.isFavorite }.map { it.id }.toSet()
        sharedPrefs.edit().putStringSet("favorite_ids", favSet).apply()
    }

    DisposableEffect(Unit) {
        onDispose {
            SacredSoundManager.release()
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaroonDeep,
        topBar = {
            Column {
                TopSacredBar(
                    onRingBell = {
                        SacredSoundManager.playTempleBell()
                        Toast.makeText(context, "🔔 Temple Ghanti Rung", Toast.LENGTH_SHORT).show()
                    },
                    onBlowShankh = {
                        SacredSoundManager.playShankhNaad()
                        Toast.makeText(context, "🐚 Sacred Shankh Naad", Toast.LENGTH_SHORT).show()
                    },
                    onToggleDiya = {
                        isDiyaLit = !isDiyaLit
                        if (isDiyaLit) {
                            SacredSoundManager.playTempleBell()
                            Toast.makeText(context, "🪔 Holy Diya Lit • Divine Blessings", Toast.LENGTH_SHORT).show()
                        }
                    },
                    isDiyaLit = isDiyaLit,
                    onOpenAbout = { isShowAboutModal = true },
                    onAddMedia = { isShowAddModal = true }
                )

                VirtualDiyaBanner(
                    isLit = isDiyaLit,
                    onToggle = {
                        isDiyaLit = !isDiyaLit
                        if (isDiyaLit) {
                            SacredSoundManager.playTempleBell()
                            Toast.makeText(context, "🪔 Holy Diya Lit • Divine Blessings", Toast.LENGTH_SHORT).show()
                        }
                    }
                )
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaroonCard,
                tonalElevation = 8.dp
            ) {
                NavigationBarItem(
                    selected = selectedTabIndex == 0,
                    onClick = { selectedTabIndex = 0 },
                    icon = {
                        Icon(
                            Icons.Default.VideoLibrary,
                            contentDescription = "Studio",
                            tint = if (selectedTabIndex == 0) GoldAccent else DarkTextSecondary
                        )
                    },
                    label = {
                        Text(
                            "Studio",
                            fontSize = 10.sp,
                            fontWeight = if (selectedTabIndex == 0) FontWeight.Bold else FontWeight.Normal,
                            color = if (selectedTabIndex == 0) GoldLight else DarkTextSecondary
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaroonSurface
                    )
                )

                NavigationBarItem(
                    selected = selectedTabIndex == 1,
                    onClick = { selectedTabIndex = 1 },
                    icon = {
                        Icon(
                            Icons.Default.SelfImprovement,
                            contentDescription = "108 Mala",
                            tint = if (selectedTabIndex == 1) GoldAccent else DarkTextSecondary
                        )
                    },
                    label = {
                        Text(
                            "108 Mala",
                            fontSize = 10.sp,
                            fontWeight = if (selectedTabIndex == 1) FontWeight.Bold else FontWeight.Normal,
                            color = if (selectedTabIndex == 1) GoldLight else DarkTextSecondary
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaroonSurface
                    )
                )

                NavigationBarItem(
                    selected = selectedTabIndex == 2,
                    onClick = { selectedTabIndex = 2 },
                    icon = {
                        Icon(
                            Icons.Default.CalendarToday,
                            contentDescription = "Panchang",
                            tint = if (selectedTabIndex == 2) GoldAccent else DarkTextSecondary
                        )
                    },
                    label = {
                        Text(
                            "Panchang",
                            fontSize = 10.sp,
                            fontWeight = if (selectedTabIndex == 2) FontWeight.Bold else FontWeight.Normal,
                            color = if (selectedTabIndex == 2) GoldLight else DarkTextSecondary
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaroonSurface
                    )
                )

                NavigationBarItem(
                    selected = selectedTabIndex == 3,
                    onClick = { selectedTabIndex = 3 },
                    icon = {
                        Icon(
                            Icons.Default.Groups,
                            contentDescription = "11 Platforms",
                            tint = if (selectedTabIndex == 3) GoldAccent else DarkTextSecondary
                        )
                    },
                    label = {
                        Text(
                            "Platforms",
                            fontSize = 10.sp,
                            fontWeight = if (selectedTabIndex == 3) FontWeight.Bold else FontWeight.Normal,
                            color = if (selectedTabIndex == 3) GoldLight else DarkTextSecondary
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaroonSurface
                    )
                )

                NavigationBarItem(
                    selected = selectedTabIndex == 4,
                    onClick = { selectedTabIndex = 4 },
                    icon = {
                        Text(
                            text = "🕉️",
                            fontSize = 18.sp
                        )
                    },
                    label = {
                        Text(
                            "Parv",
                            fontSize = 10.sp,
                            fontWeight = if (selectedTabIndex == 4) FontWeight.Bold else FontWeight.Normal,
                            color = if (selectedTabIndex == 4) GoldLight else DarkTextSecondary
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaroonSurface
                    )
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (selectedTabIndex) {
                0 -> MediaStudioScreen(
                    mediaList = mediaItems,
                    onToggleFavorite = { id ->
                        val idx = mediaItems.indexOfFirst { it.id == id }
                        if (idx != -1) {
                            val item = mediaItems[idx]
                            mediaItems[idx] = item.copy(isFavorite = !item.isFavorite)
                            saveFavorites()
                            Toast.makeText(
                                context,
                                if (!item.isFavorite) "Saved to favorites" else "Removed from favorites",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    onDeleteMedia = { id ->
                        mediaItems.removeAll { it.id == id }
                        saveFavorites()
                        Toast.makeText(context, "Item removed from studio", Toast.LENGTH_SHORT).show()
                    },
                    onWatchDirect = { item ->
                        val url = if (item.youtubeUrl.isNotBlank()) {
                            item.youtubeUrl
                        } else if (item.youtubeVideoId.isNotBlank()) {
                            "https://www.youtube.com/watch?v=${item.youtubeVideoId}"
                        } else {
                            "https://www.youtube.com/@indianbhaktidhara"
                        }

                        try {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent)
                        } catch (_: Exception) {
                            Toast.makeText(context, "Opening devotional link...", Toast.LENGTH_SHORT).show()
                        }
                    },
                    onOpenAddModal = { isShowAddModal = true }
                )

                1 -> MalaSanctuaryScreen(
                    currentTrack = currentTrack,
                    isPlaying = isAudioPlaying,
                    onTogglePlayTrack = {
                        SacredSoundManager.playTrack(
                            context = context,
                            url = currentTrack.streamUrl,
                            trackId = currentTrack.id,
                            onStateChange = { playing -> isAudioPlaying = playing }
                        )
                    },
                    onNextTrack = {
                        currentTrackIndex = (currentTrackIndex + 1) % playlist.size
                        val next = playlist[currentTrackIndex]
                        SacredSoundManager.playTrack(
                            context = context,
                            url = next.streamUrl,
                            trackId = next.id,
                            onStateChange = { playing -> isAudioPlaying = playing }
                        )
                    },
                    onPrevTrack = {
                        currentTrackIndex = (currentTrackIndex - 1 + playlist.size) % playlist.size
                        val prev = playlist[currentTrackIndex]
                        SacredSoundManager.playTrack(
                            context = context,
                            url = prev.streamUrl,
                            trackId = prev.id,
                            onStateChange = { playing -> isAudioPlaying = playing }
                        )
                    },
                    onSelectTrack = { track ->
                        val idx = playlist.indexOfFirst { it.id == track.id }
                        if (idx != -1) {
                            currentTrackIndex = idx
                            SacredSoundManager.playTrack(
                                context = context,
                                url = track.streamUrl,
                                trackId = track.id,
                                onStateChange = { playing -> isAudioPlaying = playing }
                            )
                        }
                    }
                )

                2 -> PanchangAndSlokaScreen()
                3 -> PlatformsHubScreen()
                4 -> ParvCalendarScreen()
            }
        }
    }

    // Add Media Dialog
    if (isShowAddModal) {
        AddMediaDialog(
            onDismiss = { isShowAddModal = false },
            onAddMedia = { newMedia ->
                mediaItems.add(0, newMedia)
                Toast.makeText(context, "Devotional content added!", Toast.LENGTH_SHORT).show()
            }
        )
    }

    // About Dialog
    if (isShowAboutModal) {
        AlertDialog(
            onDismissRequest = { isShowAboutModal = false },
            title = {
                Text(
                    text = "Indian Bhakti Dhara",
                    fontWeight = FontWeight.Bold,
                    color = GoldLight,
                    fontSize = 18.sp
                )
            },
            text = {
                Column {
                    Text(
                        text = "Sacred Devotional Hub & Sanatan Wisdom portal.",
                        fontSize = 13.sp,
                        color = SacredIvory
                    )
                    Text(
                        text = "Official Website: https://indianbhaktidhara.github.io/indianbhaktidhara/",
                        fontSize = 11.sp,
                        color = SaffronLight,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "Curate sacred Aartis, Mantras, Kathas, and vertical shorts across 11 official platforms for Indian Bhakti Dhara.",
                        fontSize = 11.sp,
                        color = SacredIvoryMuted,
                        modifier = Modifier.padding(top = 6.dp)
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        try {
                            val intent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://indianbhaktidhara.github.io/indianbhaktidhara/")
                            )
                            context.startActivity(intent)
                        } catch (_: Exception) {}
                        isShowAboutModal = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = SaffronPrimary,
                        contentColor = MaroonDeep
                    )
                ) {
                    Text("Visit Official Web", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { isShowAboutModal = false }) {
                    Text("Close", color = SacredIvoryMuted, fontSize = 12.sp)
                }
            },
            containerColor = MaroonCard
        )
    }
}
