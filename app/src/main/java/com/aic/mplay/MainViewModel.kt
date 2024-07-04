package com.aic.mplay


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer


    class MainViewModel(application: Application) : AndroidViewModel(application) {

        private val _player1 = MutableLiveData<SimpleExoPlayer>()
        val player1: LiveData<SimpleExoPlayer> get() = _player1

        private val _player2 = MutableLiveData<SimpleExoPlayer>()
        val player2: LiveData<SimpleExoPlayer> get() = _player2

        private val _player3 = MutableLiveData<SimpleExoPlayer>()
        val player3: LiveData<SimpleExoPlayer> get() = _player3

        private val _player4 = MutableLiveData<SimpleExoPlayer>()
        val player4: LiveData<SimpleExoPlayer> get() = _player4

        private val _player5 = MutableLiveData<SimpleExoPlayer>()
        val player5: LiveData<SimpleExoPlayer> get() = _player5

        private val _player6 = MutableLiveData<SimpleExoPlayer>()
        val player6: LiveData<SimpleExoPlayer> get() = _player6


        private val _webUrls = MutableLiveData<List<String>>()
        val webUrls: LiveData<List<String>> get() = _webUrls

        init {
            initializePlayers()
            initUrl()
        }




        private val imageUrls = arrayOf(
            "https://www.flipthetruck.com/wp-content/uploads/2014/05/X-Men-Days-of-Future-Past-banner.jpg",
            "https://dyn1.heritagestatic.com/lf?set=path%5B2%2F2%2F3%2F6%2F3%2F22363856%5D%2Csizedata%5B850x600%5D&call=url%5Bfile%3Aproduct.chain%5D",
            "https://thesecondtake.com/wp-content/uploads/2014/05/Wallpaper_Latino_Transformers4_Mxtrailers.jpg",
            "https://movirulz.info/wp-content/uploads/2024/03/MoviRulz-42.jpg",
            "https://cdn.daily-sun.com/public/news_images/2020/05/05/Daily-sun-25.jpg"
        )


        private val _currentImageUrl = MutableLiveData<String>()
        val currentImageUrl: LiveData<String>
            get() = _currentImageUrl


        private var currentImageIndex = 0

        init {

            _currentImageUrl.value = imageUrls[currentImageIndex]
        }


        private fun initializePlayers() {
            val context = getApplication<Application>().applicationContext

            val player1 = SimpleExoPlayer.Builder(context).build().apply {
                val mediaItem1 = MediaItem.fromUri("https://www.classicgaming.cc/classics/dragons-lair/files/videos/stranger-things-season-2-trailer.mp4")
                setMediaItem(mediaItem1)
                prepare()
                playWhenReady = true
            }

            val player2 = SimpleExoPlayer.Builder(context).build().apply {
                val mediaItem2 = MediaItem.fromUri("https://previews.customer.envatousercontent.com/h264-video-previews/1c67bf17-b0b0-444d-be9a-7369313bda2a/599548.mp4?_=2")
                setMediaItem(mediaItem2)
                prepare()
                playWhenReady = true
            }

            val player3 = SimpleExoPlayer.Builder(context).build().apply {
                val mediaItem3 = MediaItem.fromUri("https://www.classicgaming.cc/classics/dragons-lair/files/videos/Dragons-Lair-Intro.mp4")
                setMediaItem(mediaItem3)
                prepare()
                playWhenReady = true
            }

            val player4 = SimpleExoPlayer.Builder(context).build().apply {
                val mediaItem2 = MediaItem.fromUri("https://previews.customer.envatousercontent.com/h264-video-previews/1c67bf17-b0b0-444d-be9a-7369313bda2a/599548.mp4?_=2")
                setMediaItem(mediaItem2)
                prepare()
                playWhenReady = true
            }

            val player5 = SimpleExoPlayer.Builder(context).build().apply {
                val mediaItem3 = MediaItem.fromUri("https://www.classicgaming.cc/classics/dragons-lair/files/videos/Dragons-Lair-Intro.mp4")
                setMediaItem(mediaItem3)
                prepare()
                playWhenReady = true
            }

            val player6 = SimpleExoPlayer.Builder(context).build().apply {
                val mediaItem1 = MediaItem.fromUri("https://www.classicgaming.cc/classics/dragons-lair/files/videos/stranger-things-season-2-trailer.mp4")
                setMediaItem(mediaItem1)
                prepare()
                playWhenReady = true
            }


            _player1.value = player1
            _player2.value = player2
            _player3.value = player3
            _player4.value = player4
            _player5.value = player5
            _player6.value = player6
        }

        override fun onCleared() {
            super.onCleared()
            _player1.value?.release()
            _player2.value?.release()
            _player3.value?.release()
            _player4.value?.release()
            _player5.value?.release()
            _player6.value?.release()
        }


        fun getNextImageUrl() {
            currentImageIndex++
            if (currentImageIndex >= imageUrls.size) {
                currentImageIndex = 0
            }
            _currentImageUrl.value = imageUrls[currentImageIndex]
        }



        private fun initUrl(){
            _webUrls.value = listOf(
                "https://www.youtube.com/watch?v=wJGJN6YiJNs",
                "https://www.youtube.com/watch?v=MGaNfzZgq1I",
                "https://www.youtube.com/watch?v=BJ3Yv572V1A",
                "https://www.youtube.com/watch?v=PLR6KdmyTho",
                "https://www.youtube.com/results?search_query=tech+live",
                "https://www.youtube.com/watch?v=ZxKyegYarI0")
        }

    }








