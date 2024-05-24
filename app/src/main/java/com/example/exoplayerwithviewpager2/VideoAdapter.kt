package com.example.exoplayerwithviewpager2

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.database.DatabaseProvider
import androidx.media3.database.StandaloneDatabaseProvider
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.datasource.cache.CacheDataSource
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor
import androidx.media3.datasource.cache.SimpleCache
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector
import androidx.media3.ui.PlayerView
import androidx.recyclerview.widget.RecyclerView
import java.io.File

@UnstableApi
class VideoAdapter(private val context: Context) :
    RecyclerView.Adapter<VideoAdapter.MyViewHolder?>() {

    private var player: ExoPlayer? = null
    private var simpleCache: SimpleCache
    private var playDrawable : Drawable? = null
    private var pauseDrawable : Drawable? = null

    init {
        val evict = LeastRecentlyUsedCacheEvictor((100 * 1024 * 1024).toLong())
        val databaseProvider: DatabaseProvider = StandaloneDatabaseProvider(context)
        simpleCache = SimpleCache(File(context.cacheDir, "media"), evict, databaseProvider)
        playDrawable= AppCompatResources.getDrawable(context,R.drawable.ic_play)
        pauseDrawable= AppCompatResources.getDrawable(context,R.drawable.ic_pause)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.video_layout, parent, false)
        return MyViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder){
            val videoElement = DummyData.videoList.get(position)
            val trackSelector = DefaultTrackSelector(context).apply {
                setParameters(buildUponParameters().setMaxVideoSizeSd())
            }
            player =
                ExoPlayer.Builder(context).setTrackSelector(trackSelector).build().also { exoPlayer ->
                    videoView.player = exoPlayer
                    val mediaItem = MediaItem.fromUri(Uri.parse(videoElement))
                    val httpDataSourceFactory =
                        DefaultHttpDataSource.Factory().setAllowCrossProtocolRedirects(true)
                    val defaultDataSourceFactory =
                        DefaultDataSource.Factory(context, httpDataSourceFactory)
                    val cacheDataSourceFactory = CacheDataSource.Factory().setCache(simpleCache)
                        .setUpstreamDataSourceFactory(defaultDataSourceFactory)
                        .setFlags(CacheDataSource.FLAG_IGNORE_CACHE_ON_ERROR)
                    val mediaSource = ProgressiveMediaSource.Factory(cacheDataSourceFactory)
                        .createMediaSource(mediaItem)
                    exoPlayer.setMediaSource(mediaSource)
                    exoPlayer.playWhenReady = false
                    exoPlayer.repeatMode = ExoPlayer.REPEAT_MODE_ONE
                    exoPlayer.prepare()
                }

            playPauseView.setOnClickListener {
                if (videoView.player!!.isPlaying){
                    videoView.player?.pause()
                    startAnimation(pauseImg)
                }
                else{
                    videoView.player?.play()
                    startAnimation(playImg)
                }
            }
        }
    }

    private fun startAnimation(view : View){
        val fadeOut = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        fadeOut.setDuration(700)
        val fadeIn = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f)
        fadeIn.setDuration(1000)

        val mAnimationSet = AnimatorSet()
        mAnimationSet.play(fadeIn).after(fadeOut)

        mAnimationSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                view.visibility=View.VISIBLE
            }
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                view.visibility= View.GONE
            }
        })
        mAnimationSet.start()
    }

    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        super.onViewAttachedToWindow(holder)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        Log.d("Yt Shorts", "Player Released onDetach")
        player?.release()
        simpleCache.release()
    }
    override fun onViewRecycled(holder: MyViewHolder) {
        super.onViewRecycled(holder)
        holder.videoView.player?.release()
    }
    override fun onViewDetachedFromWindow(holder: MyViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.videoView.player?.pause()
    }

    override fun getItemCount(): Int = DummyData.videoList.size
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val videoView = itemView.findViewById<PlayerView>(R.id.video_view)
        val playImg = itemView.findViewById<ImageView>(R.id.play_img)
        val pauseImg = itemView.findViewById<ImageView>(R.id.pause_img)
        val playPauseView = itemView.findViewById<View>(R.id.play_pause_view)
    }

}