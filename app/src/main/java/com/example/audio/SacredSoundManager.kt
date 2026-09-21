package com.example.audio

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.media.MediaPlayer
import android.net.Uri
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.exp
import kotlin.math.sin

object SacredSoundManager {

    private var mediaPlayer: MediaPlayer? = null
    private var isAudioPlaying = false
    private var currentPlayingId: String? = null

    /**
     * Plays a synthesized pure temple bell (Ghanti) sound with harmonics and natural reverberation
     */
    fun playTempleBell() {
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val sampleRate = 44100
                val durationSec = 2.0
                val numSamples = (sampleRate * durationSec).toInt()
                val buffer = ShortArray(numSamples)

                val baseFreq = 1450.0 // Bell resonance
                val overtone1 = baseFreq * 1.52
                val overtone2 = baseFreq * 2.76
                val strikeFreq = baseFreq * 4.1

                for (i in 0 until numSamples) {
                    val t = i.toDouble() / sampleRate
                    // Rapid initial attack, gentle exponential decay
                    val envMain = exp(-3.2 * t)
                    val envHigh = exp(-8.0 * t)

                    val sampleVal = (
                        0.50 * sin(2.0 * Math.PI * baseFreq * t) * envMain +
                        0.25 * sin(2.0 * Math.PI * overtone1 * t) * envMain +
                        0.15 * sin(2.0 * Math.PI * overtone2 * t) * envMain +
                        0.10 * sin(2.0 * Math.PI * strikeFreq * t) * envHigh
                    )
                    buffer[i] = (sampleVal * 32767).toInt().coerceIn(-32768, 32767).toShort()
                }

                val audioTrack = AudioTrack.Builder()
                    .setAudioAttributes(
                        AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                            .build()
                    )
                    .setAudioFormat(
                        AudioFormat.Builder()
                            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                            .setSampleRate(sampleRate)
                            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                            .build()
                    )
                    .setBufferSizeInBytes(numSamples * 2)
                    .setTransferMode(AudioTrack.MODE_STATIC)
                    .build()

                audioTrack.write(buffer, 0, numSamples)
                audioTrack.play()
                delay((durationSec * 1000).toLong() + 200)
                audioTrack.release()
            } catch (_: Exception) {}
        }
    }

    /**
     * Plays a synthesized sacred conch (Shankh Naad) tone
     */
    fun playShankhNaad() {
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val sampleRate = 44100
                val durationSec = 2.5
                val numSamples = (sampleRate * durationSec).toInt()
                val buffer = ShortArray(numSamples)

                val baseFreq = 230.0 // Deep resonance of Shankh

                for (i in 0 until numSamples) {
                    val t = i.toDouble() / sampleRate
                    // Swell and taper
                    val envelope = when {
                        t < 0.4 -> (t / 0.4)
                        t > 1.8 -> exp(-3.0 * (t - 1.8))
                        else -> 1.0
                    }

                    // Slight vibrato
                    val vibrato = 1.0 + 0.015 * sin(2.0 * Math.PI * 5.5 * t)
                    val freq = baseFreq * vibrato

                    val sampleVal = (
                        0.45 * sin(2.0 * Math.PI * freq * t) +
                        0.30 * sin(2.0 * Math.PI * freq * 2.0 * t) +
                        0.15 * sin(2.0 * Math.PI * freq * 3.0 * t) +
                        0.10 * sin(2.0 * Math.PI * freq * 4.0 * t)
                    ) * envelope * 0.85

                    buffer[i] = (sampleVal * 32767).toInt().coerceIn(-32768, 32767).toShort()
                }

                val audioTrack = AudioTrack.Builder()
                    .setAudioAttributes(
                        AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .build()
                    )
                    .setAudioFormat(
                        AudioFormat.Builder()
                            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                            .setSampleRate(sampleRate)
                            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                            .build()
                    )
                    .setBufferSizeInBytes(numSamples * 2)
                    .setTransferMode(AudioTrack.MODE_STATIC)
                    .build()

                audioTrack.write(buffer, 0, numSamples)
                audioTrack.play()
                delay((durationSec * 1000).toLong() + 200)
                audioTrack.release()
            } catch (_: Exception) {}
        }
    }

    /**
     * Plays a soft tactile bead click for 108 Japa counting
     */
    fun playMalaBeadClick() {
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val sampleRate = 44100
                val durationSec = 0.06
                val numSamples = (sampleRate * durationSec).toInt()
                val buffer = ShortArray(numSamples)

                val freq = 880.0
                for (i in 0 until numSamples) {
                    val t = i.toDouble() / sampleRate
                    val env = exp(-60.0 * t)
                    val sampleVal = sin(2.0 * Math.PI * freq * t) * env * 0.4
                    buffer[i] = (sampleVal * 32767).toInt().toShort()
                }

                val audioTrack = AudioTrack.Builder()
                    .setAudioAttributes(
                        AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                            .build()
                    )
                    .setAudioFormat(
                        AudioFormat.Builder()
                            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                            .setSampleRate(sampleRate)
                            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                            .build()
                    )
                    .setBufferSizeInBytes(numSamples * 2)
                    .setTransferMode(AudioTrack.MODE_STATIC)
                    .build()

                audioTrack.write(buffer, 0, numSamples)
                audioTrack.play()
                delay(80)
                audioTrack.release()
            } catch (_: Exception) {}
        }
    }

    fun playTrack(context: Context, url: String, trackId: String, onStateChange: (Boolean) -> Unit) {
        try {
            if (mediaPlayer != null && currentPlayingId == trackId) {
                if (mediaPlayer!!.isPlaying) {
                    mediaPlayer!!.pause()
                    isAudioPlaying = false
                    onStateChange(false)
                } else {
                    mediaPlayer!!.start()
                    isAudioPlaying = true
                    onStateChange(true)
                }
                return
            }

            mediaPlayer?.release()
            mediaPlayer = MediaPlayer().apply {
                setAudioStreamType(AudioManager.STREAM_MUSIC)
                setDataSource(context, Uri.parse(url))
                setOnPreparedListener {
                    start()
                    isAudioPlaying = true
                    currentPlayingId = trackId
                    onStateChange(true)
                }
                setOnCompletionListener {
                    isAudioPlaying = false
                    onStateChange(false)
                }
                setOnErrorListener { _, _, _ ->
                    isAudioPlaying = false
                    onStateChange(false)
                    true
                }
                prepareAsync()
            }
        } catch (_: Exception) {
            isAudioPlaying = false
            onStateChange(false)
        }
    }

    fun pauseTrack(onStateChange: (Boolean) -> Unit) {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.pause()
                isAudioPlaying = false
                onStateChange(false)
            }
        }
    }

    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
        isAudioPlaying = false
    }
}
