package com.example.exoplayerwithviewpager2

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.annotation.OptIn
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.media3.common.util.UnstableApi
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

@OptIn(UnstableApi::class)
class MainActivity : AppCompatActivity() {

    var videosRv : ViewPager2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window?.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window?.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
        supportActionBar?.hide()
        requestedOrientation =
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        videosRv = findViewById<ViewPager2>(R.id.videos_rv)
        val videoAdapter = VideoAdapter(this)
        videosRv?.apply {
            adapter = videoAdapter
        }
        videosRv?.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                playCurrentItem()
            }
        })
    }
    fun playCurrentItem(){
        getViewHolder(videosRv?.currentItem!!)?.videoView?.player?.play()
    }
    fun pauseCurrentItem(){
        getViewHolder(videosRv?.currentItem!!)?.videoView?.player?.pause()
    }

    fun getViewHolder(position: Int): VideoAdapter.MyViewHolder? =
        (videosRv?.getChildAt(0) as? RecyclerView)?.let {
            it.findViewHolderForAdapterPosition(position)?.let { mediaViewHolder ->
                (mediaViewHolder as? VideoAdapter.MyViewHolder)
            }
        }
    override fun onPause() {
        super.onPause()
        pauseCurrentItem()
    }
    override fun onResume() {
        super.onResume()
        playCurrentItem()
    }

}