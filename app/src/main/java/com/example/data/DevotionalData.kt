package com.example.data

data class DevotionalMedia(
    val id: String,
    val type: String, // "video" or "short"
    val title: String,
    val category: String,
    val tag: String,
    val thumbUrl: String,
    val youtubeUrl: String = "",
    val youtubeVideoId: String = "",
    val isFavorite: Boolean = false
)

data class AudioChantTrack(
    val id: String,
    val title: String,
    val deity: String,
    val duration: String,
    val streamUrl: String
)

data class SacredSloka(
    val sanskrit: String,
    val hindi: String,
    val english: String,
    val source: String
)

data class SacredFestival(
    val name: String,
    val monthPeriod: String,
    val deity: String,
    val description: String
)

data class PlatformLink(
    val name: String,
    val badge: String,
    val description: String,
    val url: String,
    val brandColorHex: Long
)

object DevotionalRepository {

    val initialMediaList = listOf(
        DevotionalMedia(
            id = "v1",
            type = "video",
            title = "Mahamrityunjaya Mantra - 108 Times Chanting",
            category = "Daily Mantras",
            tag = "Lord Shiva • 21:10",
            thumbUrl = "https://images.unsplash.com/photo-1545232979-fbf34f5ce757?auto=format&fit=crop&w=600&q=80",
            youtubeUrl = "https://www.youtube.com/watch?v=kXoY7_Yx2s8",
            youtubeVideoId = "kXoY7_Yx2s8"
        ),
        DevotionalMedia(
            id = "s1",
            type = "short",
            title = "Sacred Badrinath Temple Morning Darshan Reel",
            category = "Aarti & Stotra",
            tag = "Short Reel • Lord Vishnu",
            thumbUrl = "https://images.unsplash.com/photo-1620052581237-5d36667be337?auto=format&fit=crop&w=600&q=80",
            youtubeUrl = "https://www.youtube.com/shorts/sZ6K4L1d0-g",
            youtubeVideoId = "sZ6K4L1d0-g"
        ),
        DevotionalMedia(
            id = "v2",
            type = "video",
            title = "Achyutam Keshavam Krishna Damodaram Bhajan",
            category = "Bhakti Sangeet",
            tag = "Shri Krishna • 08:15",
            thumbUrl = "https://images.unsplash.com/photo-1609137144813-7d9921338f24?auto=format&fit=crop&w=600&q=80",
            youtubeUrl = "https://www.youtube.com/watch?v=5EqbAE3z670",
            youtubeVideoId = "5EqbAE3z670"
        ),
        DevotionalMedia(
            id = "s2",
            type = "short",
            title = "Quick 30-Sec Gayatri Mantra Chant Short",
            category = "Daily Mantras",
            tag = "Vedic Short • Savitr",
            thumbUrl = "https://images.unsplash.com/photo-1567157577867-05ccb1388e66?auto=format&fit=crop&w=600&q=80",
            youtubeUrl = "https://www.youtube.com/shorts/3XkL91mR2eQ",
            youtubeVideoId = "3XkL91mR2eQ"
        ),
        DevotionalMedia(
            id = "v3",
            type = "video",
            title = "Shri Hanuman Chalisa - Powerful Vedic Recitation",
            category = "Aarti & Stotra",
            tag = "Sankat Mochan • 09:40",
            thumbUrl = "https://images.unsplash.com/photo-1545232979-fbf34f5ce757?auto=format&fit=crop&w=600&q=80",
            youtubeUrl = "https://www.youtube.com/watch?v=AETFvQonfV8",
            youtubeVideoId = "AETFvQonfV8"
        ),
        DevotionalMedia(
            id = "s3",
            type = "short",
            title = "Kedarnath Jyotirlinga Evening Aarti Darshan",
            category = "Festival Special",
            tag = "Short Reel • Mahadev",
            thumbUrl = "https://images.unsplash.com/photo-1620052581237-5d36667be337?auto=format&fit=crop&w=600&q=80",
            youtubeUrl = "https://www.youtube.com/shorts/mKedarnath9",
            youtubeVideoId = "mKedarnath9"
        ),
        DevotionalMedia(
            id = "v4",
            type = "video",
            title = "Shiv Tandav Stotram by Ravana with Meaning",
            category = "Daily Mantras",
            tag = "Lord Shiva • 11:15",
            thumbUrl = "https://images.unsplash.com/photo-1609137144813-7d9921338f24?auto=format&fit=crop&w=600&q=80",
            youtubeUrl = "https://www.youtube.com/watch?v=hMBKmQgkDcE",
            youtubeVideoId = "hMBKmQgkDcE"
        ),
        DevotionalMedia(
            id = "s4",
            type = "short",
            title = "Ram Mandir Ayodhya Sanctum Sanctorum Aarti",
            category = "Katha & Pravachan",
            tag = "Short Reel • Shri Ram",
            thumbUrl = "https://images.unsplash.com/photo-1567157577867-05ccb1388e66?auto=format&fit=crop&w=600&q=80",
            youtubeUrl = "https://www.youtube.com/shorts/AyodhyaRam9",
            youtubeVideoId = "AyodhyaRam9"
        )
    )

    val audioPlaylist = listOf(
        AudioChantTrack(
            id = "a1",
            title = "Gayatri Mantra (108 Times Chanting)",
            deity = "Surya / Savitr • Indian Bhakti Dhara",
            duration = "108 Japa",
            streamUrl = "https://cdn.pixabay.com/download/audio/2022/05/27/audio_1808fbf07a.mp3?filename=meditation-om-chant-112776.mp3"
        ),
        AudioChantTrack(
            id = "a2",
            title = "Shiva Dhun Om Namah Shivaya",
            deity = "Lord Shiva • Vedic Peace Chants",
            duration = "Peace Loop",
            streamUrl = "https://cdn.pixabay.com/download/audio/2021/08/09/audio_8843236315.mp3?filename=om-shanti-ambient-11200.mp3"
        ),
        AudioChantTrack(
            id = "a3",
            title = "Peaceful Krishna Flute Meditation",
            deity = "Lord Krishna • Divine Resonance",
            duration = "Flute Meditation",
            streamUrl = "https://cdn.pixabay.com/download/audio/2022/03/24/audio_345f1b1b3b.mp3?filename=indian-flute-meditation-109265.mp3"
        ),
        AudioChantTrack(
            id = "a4",
            title = "Mahamrityunjaya Sanjeevani Chanting",
            deity = "Rudra • Healing & Protection",
            duration = "Sacred Japa",
            streamUrl = "https://cdn.pixabay.com/download/audio/2022/05/27/audio_1808fbf07a.mp3?filename=meditation-om-chant-112776.mp3"
        )
    )

    val sacredSlokas = listOf(
        SacredSloka(
            sanskrit = "कर्मण्येवाधिकारस्ते मा फलेषु कदाचन।\nमा कर्मफलहेतुर्भूर्मा ते सङ्गोऽस्त्वकर्मणि॥",
            hindi = "आपको केवल कर्म करने का अधिकार है, उसके फलों पर कभी नहीं। कर्मफल के प्रति आसक्त न हों और न ही अकर्मण्यता में रुचि रखें।",
            english = "You have a right to perform your prescribed duty, but you are not entitled to the fruits of action. Never consider yourself the cause of results, nor be attached to inaction.",
            source = "— श्रीमद्भगवद्गीता (2.47)"
        ),
        SacredSloka(
            sanskrit = "यदा यदा हि धर्मस्य ग्लानिर्भवति भारत।\nअभ्युत्थानमधर्मस्य तदात्मानं सृजाम्यहम्॥",
            hindi = "हे भारत (अर्जुन)! जब-जब धर्म की हानि और अधर्म की वृद्धि होती है, तब-तब मैं स्वयं को प्रकट करता हूँ।",
            english = "Whenever there is a decline in righteousness and an increase in unrighteousness, O Bharata, I manifest Myself.",
            source = "— श्रीमद्भगवद्गीता (4.7)"
        ),
        SacredSloka(
            sanskrit = "सर्वधर्मान्परित्यज्य मामेकं शरणं व्रज।\nअहं त्वां सर्वपापेभ्यो मोक्षयिष्यामि मा शुचः॥",
            hindi = "सम्पूर्ण धर्मों के आश्रय को त्यागकर केवल मेरी शरण में आओ। मैं तुम्हें सभी पापों से मुक्त कर दूँगा, शोक मत करो।",
            english = "Abandon all varieties of dharmas and surrender solely unto Me. I shall deliver you from all sinful reactions; do not grieve.",
            source = "— श्रीमद्भगवद्गीता (18.66)"
        ),
        SacredSloka(
            sanskrit = "ॐ त्र्यम्बकं यजामहे सुगन्धिं पुष्टिवर्धनम्।\nउर्वारुकमिव बन्धनान्मृत्योर्मुक्षीय मामृतात्॥",
            hindi = "हम सुगंधित और पुष्टि वर्धक त्रिनेत्र भगवान शिव की आराधना करते हैं। जिस प्रकार खरबूजा पकने पर बेल से मुक्त हो जाता है, वैसे ही हम मृत्यु से मुक्त हों, अमरता से नहीं।",
            english = "We worship the three-eyed Lord Shiva who is fragrant and nourishes all beings. May He liberate us from death for immortality, even as a cucumber is severed from its bondage.",
            source = "— ऋग्वेद (7.59.12) / यजुर्वेद"
        ),
        SacredSloka(
            sanskrit = "सङ्गच्छध्वं संवदध्वं सं वो मनांसि जानताम्।\nदेवा भागं यथा पूर्वे सञ्जानाना उपासते॥",
            hindi = "साथ चलो, साथ बोलो और तुम्हारे मन एक समान विचार करें, जैसे प्राचीन काल में ज्ञानी जन एकजुट होकर अपने कर्तव्य का पालन करते थे।",
            english = "May you walk together, speak together, and let your minds be in harmony, just as the ancient wise ones worked together in sacred unity.",
            source = "— ऋग्वेद (10.191.2)"
        )
    )

    val upcomingFestivals = listOf(
        SacredFestival(
            name = "Maha Shivratri",
            monthPeriod = "Phalguna (Feb / Mar)",
            deity = "Lord Shiva",
            description = "Great Night of Shiva celebrated with whole night vigil, Rudrabhishekam, and chanting of Om Namah Shivaya."
        ),
        SacredFestival(
            name = "Chaitra Navratri & Rama Navami",
            monthPeriod = "Chaitra (Mar / Apr)",
            deity = "Maa Durga & Lord Rama",
            description = "Nine nights of Goddess Durga worship followed by the celebration of Lord Rama's advent with Ram Charit Manas recital."
        ),
        SacredFestival(
            name = "Hanuman Janmotsav",
            monthPeriod = "Chaitra Purnima (April)",
            deity = "Shri Hanuman",
            description = "Celebration of Sankat Mochan Hanuman with sundarkand path, sindoor arpan, and chanting of Hanuman Chalisa."
        ),
        SacredFestival(
            name = "Guru Purnima",
            monthPeriod = "Ashadha (July)",
            deity = "Sage Ved Vyasa & Gurus",
            description = "Day of revering spiritual teachers, masters, and the compiler of the Vedas, Maharishi Ved Vyasa."
        ),
        SacredFestival(
            name = "Shri Krishna Janmashtami",
            monthPeriod = "Bhadrapada (Aug / Sep)",
            deity = "Lord Krishna",
            description = "Midnight celebration of Lord Krishna's birth with Makhan-Mishri bhog, Bhagavad Gita slokas, and joyful kirtans."
        ),
        SacredFestival(
            name = "Ganesh Chaturthi",
            monthPeriod = "Bhadrapada (Aug / Sep)",
            deity = "Lord Ganesha",
            description = "Welcoming the remover of obstacles with Modak offering, Ganapati Atharvashirsha chants, and daily Aarti."
        ),
        SacredFestival(
            name = "Sharad Navratri & Dussehra",
            monthPeriod = "Ashwin (Oct)",
            deity = "Maa Durga & Lord Rama",
            description = "Victory of divine righteousness over evil forces, celebrating Maa Durga's triumph and Lord Rama's victory."
        ),
        SacredFestival(
            name = "Deepavali & Dhanteras",
            monthPeriod = "Kartika (Oct / Nov)",
            deity = "Maa Lakshmi & Lord Ganesha",
            description = "Festival of divine lights, inner illumination, auspicious wealth, and triumph of light over spiritual darkness."
        )
    )

    val officialPlatforms = listOf(
        PlatformLink(
            name = "YouTube",
            badge = "Official Channel",
            description = "Soulful Bhajans, Mantras, Aartis, Katha and Devotional Sacred Shorts.",
            url = "https://youtube.com/@indianbhaktidhara?si=damzIAmIa5rWUJkX",
            brandColorHex = 0xFFFF0000
        ),
        PlatformLink(
            name = "Instagram",
            badge = "Reels & Darshan",
            description = "Daily Sloka Reels, Temple Darshan, and Inspiring Vedic Quotes.",
            url = "https://www.instagram.com/indianbhaktidhara",
            brandColorHex = 0xFFE1306C
        ),
        PlatformLink(
            name = "WhatsApp",
            badge = "Direct Channel",
            description = "Private devotional updates, festival reminders, and daily morning chants.",
            url = "https://whatsapp.com/channel/0029Vb5YARhLNSaE4zCscQ38",
            brandColorHex = 0xFF25D366
        ),
        PlatformLink(
            name = "Telegram",
            badge = "Sangha Broadcast",
            description = "Daily MP3 Chants, High-Res Wallpapers, and Sacred PDF Scriptures.",
            url = "https://t.me/indianbhaktidhara",
            brandColorHex = 0xFF0088CC
        ),
        PlatformLink(
            name = "Facebook",
            badge = "Devotional Page",
            description = "Spiritual community discussions, Katha satsangs, and festival events.",
            url = "https://www.facebook.com/share/1CoXdpRr1S/",
            brandColorHex = 0xFF1877F2
        ),
        PlatformLink(
            name = "Threads",
            badge = "Vedic Wisdom",
            description = "Short wisdom reflections, daily stotras, and Sanatan philosophy bites.",
            url = "https://www.threads.com/@indianbhaktidhara",
            brandColorHex = 0xFF424242
        ),
        PlatformLink(
            name = "Dailymotion",
            badge = "Video Library",
            description = "Full-length spiritual documentaries, Pravachans, and Aarti series.",
            url = "https://dailymotion.com/indianbhaktidhara",
            brandColorHex = 0xFF0066DC
        ),
        PlatformLink(
            name = "Substack",
            badge = "Sacred Gazette",
            description = "In-depth scriptural essays, Upanishadic commentaries, and newsletters.",
            url = "https://substack.com/@indianbhaktidhara",
            brandColorHex = 0xFFFF6719
        ),
        PlatformLink(
            name = "ShareChat",
            badge = "Desi Regional",
            description = "Bhakti video status in Hindi and regional Indian languages.",
            url = "https://sharechat.com/profile/indianbhaktidhara?d=n",
            brandColorHex = 0xFF00A859
        ),
        PlatformLink(
            name = "Reddit",
            badge = "Sangha Community",
            description = "Participate in discussions about Hindu scriptures, practices, and history.",
            url = "https://www.reddit.com/user/Indian_Bhakti_Dhara/",
            brandColorHex = 0xFFFF4500
        ),
        PlatformLink(
            name = "DailyHunt",
            badge = "Devotional News",
            description = "Spiritual articles, pilgrimage news, and festival coverage.",
            url = "https://profile.dailyhunt.in/indianbhaktidhara",
            brandColorHex = 0xFF0080FF
        ),
        PlatformLink(
            name = "Moj",
            badge = "Short Clips",
            description = "Trending temple darshan shorts and quick devotional status clips.",
            url = "https://mojapp.in/@indianbhaktidhara",
            brandColorHex = 0xFFFF7700
        ),
        PlatformLink(
            name = "Pinterest",
            badge = "Sacred Art Gallery",
            description = "High-definition deity artwork, temple photography, and sloka pins.",
            url = "https://www.pinterest.com/indianbhaktidhara",
            brandColorHex = 0xFFBD081C
        ),
        PlatformLink(
            name = "Google Sites",
            badge = "Official Portal",
            description = "Comprehensive archival knowledge base of Indian Bhakti Dhara.",
            url = "https://sites.google.com",
            brandColorHex = 0xFFF4B400
        )
    )

    fun extractYouTubeId(url: String): String {
        val trimmed = url.trim()
        if (trimmed.length == 11 && trimmed.matches(Regex("^[a-zA-Z0-9_-]{11}$"))) {
            return trimmed
        }
        if (trimmed.contains("studio.youtube.com/video/")) {
            val part = trimmed.substringAfter("studio.youtube.com/video/").substringBefore("/").substringBefore("?")
            if (part.length == 11) return part
        }
        if (trimmed.contains("youtu.be/")) {
            val part = trimmed.substringAfter("youtu.be/").substringBefore("?").substringBefore("/")
            if (part.length == 11) return part
        }
        if (trimmed.contains("youtube.com/shorts/")) {
            val part = trimmed.substringAfter("youtube.com/shorts/").substringBefore("?").substringBefore("/")
            if (part.length == 11) return part
        }
        if (trimmed.contains("v=")) {
            val part = trimmed.substringAfter("v=").substringBefore("&")
            if (part.length == 11) return part
        }
        return ""
    }
}
