package umn.ac.id.exoplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_main.*

class PlayerActivity : AppCompatActivity() {

    private var player : SimpleExoPlayer? = null
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
    }

    private fun initializePlayer(){
        player = SimpleExoPlayer.Builder(this).build()
        video_view.setPlayer(player)
        var mediaItem : MediaItem = MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-0/play.mp3")
        player!!.setMediaItem(mediaItem)

        player!!.setPlayWhenReady(playWhenReady);
        player!!.seekTo(currentWindow, playbackPosition);
        player!!.prepare();
    }

    override fun onStart(){
        super.onStart()
        if(Util.SDK_INT >= 24){
            initializePlayer()
        }
    }

    override fun onResume() {
        super.onResume()
//        hideSystemUi()
        if (Util.SDK_INT < 24 || player == null) {
            initializePlayer()
        }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }

    private fun releasePlayer() {
        if (player != null) {
            playWhenReady = player!!.playWhenReady
            playbackPosition = player!!.currentPosition
            currentWindow = player!!.currentWindowIndex
            player!!.release()
            player = null
        }
    }
//    @SuppressLint("InlinedApi")
//    private fun hideSystemUi() {
//        player!!.setSystemUiVisibility(
//            View.SYSTEM_UI_FLAG_LOW_PROFILE
//                    or View.SYSTEM_UI_FLAG_FULLSCREEN
//                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//        )
//    }
}
