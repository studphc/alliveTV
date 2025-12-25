package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public class SimpleExoPlayer extends BasePlayer implements ExoPlayer, ExoPlayer.AudioComponent, ExoPlayer.VideoComponent, ExoPlayer.TextComponent, ExoPlayer.DeviceComponent {

    /* renamed from: a */
    public final C0658d f9489a;

    /* renamed from: b */
    public final ConditionVariable f9490b;

    public SimpleExoPlayer(Builder builder) {
        this(builder.f9491a);
    }

    /* renamed from: a */
    public final void m2417a() {
        this.f9490b.blockUninterruptible();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addAnalyticsListener(AnalyticsListener analyticsListener) {
        m2417a();
        this.f9489a.addAnalyticsListener(analyticsListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        m2417a();
        this.f9489a.addAudioOffloadListener(audioOffloadListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(Player.Listener listener) {
        m2417a();
        this.f9489a.addListener(listener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(int i, List<MediaItem> list) {
        m2417a();
        this.f9489a.addMediaItems(i, list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSource(MediaSource mediaSource) {
        m2417a();
        this.f9489a.addMediaSource(mediaSource);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(List<MediaSource> list) {
        m2417a();
        this.f9489a.addMediaSources(list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void clearAuxEffectInfo() {
        m2417a();
        this.f9489a.clearAuxEffectInfo();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearCameraMotionListener(CameraMotionListener cameraMotionListener) {
        m2417a();
        this.f9489a.clearCameraMotionListener(cameraMotionListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        m2417a();
        this.f9489a.clearVideoFrameMetadataListener(videoFrameMetadataListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurface() {
        m2417a();
        this.f9489a.clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        m2417a();
        this.f9489a.clearVideoSurfaceHolder(surfaceHolder);
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        m2417a();
        this.f9489a.clearVideoSurfaceView(surfaceView);
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        m2417a();
        this.f9489a.clearVideoTextureView(textureView);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public PlayerMessage createMessage(PlayerMessage.Target target) {
        m2417a();
        return this.f9489a.createMessage(target);
    }

    @Override // com.google.android.exoplayer2.Player
    public void decreaseDeviceVolume() {
        m2417a();
        this.f9489a.decreaseDeviceVolume();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean experimentalIsSleepingForOffload() {
        m2417a();
        return this.f9489a.experimentalIsSleepingForOffload();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void experimentalSetOffloadSchedulingEnabled(boolean z) {
        m2417a();
        this.f9489a.experimentalSetOffloadSchedulingEnabled(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public AnalyticsCollector getAnalyticsCollector() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9898q;
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper getApplicationLooper() {
        m2417a();
        return this.f9489a.f9900r;
    }

    @Override // com.google.android.exoplayer2.Player
    public AudioAttributes getAudioAttributes() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9881h0;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    @Deprecated
    public ExoPlayer.AudioComponent getAudioComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    public DecoderCounters getAudioDecoderCounters() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9877f0;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    public Format getAudioFormat() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9858S;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public int getAudioSessionId() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9879g0;
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.Commands getAvailableCommands() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9854O;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        m2417a();
        return this.f9489a.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Clock getClock() {
        m2417a();
        return this.f9489a.f9908v;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        m2417a();
        return this.f9489a.getContentBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        m2417a();
        return this.f9489a.getContentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        m2417a();
        return this.f9489a.getCurrentAdGroupIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        m2417a();
        return this.f9489a.getCurrentAdIndexInAdGroup();
    }

    @Override // com.google.android.exoplayer2.Player
    public CueGroup getCurrentCues() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9887k0;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentMediaItemIndex() {
        m2417a();
        return this.f9489a.getCurrentMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        m2417a();
        return this.f9489a.getCurrentPeriodIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        m2417a();
        return this.f9489a.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        m2417a();
        return this.f9489a.getCurrentTimeline();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public TrackGroupArray getCurrentTrackGroups() {
        m2417a();
        return this.f9489a.getCurrentTrackGroups();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public TrackSelectionArray getCurrentTrackSelections() {
        m2417a();
        return this.f9489a.getCurrentTrackSelections();
    }

    @Override // com.google.android.exoplayer2.Player
    public Tracks getCurrentTracks() {
        m2417a();
        return this.f9489a.getCurrentTracks();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    @Deprecated
    public ExoPlayer.DeviceComponent getDeviceComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Player
    public DeviceInfo getDeviceInfo() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9903s0;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getDeviceVolume() {
        m2417a();
        return this.f9489a.getDeviceVolume();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        m2417a();
        return this.f9489a.getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getMaxSeekToPreviousPosition() {
        m2417a();
        this.f9489a.getMaxSeekToPreviousPosition();
        return C0643C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata getMediaMetadata() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9855P;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean getPauseAtEndOfMediaItems() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9853N;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        m2417a();
        return this.f9489a.getPlayWhenReady();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Looper getPlaybackLooper() {
        m2417a();
        return this.f9489a.f9884j.f10615j;
    }

    @Override // com.google.android.exoplayer2.Player
    public PlaybackParameters getPlaybackParameters() {
        m2417a();
        return this.f9489a.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        m2417a();
        return this.f9489a.getPlaybackState();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        m2417a();
        return this.f9489a.getPlaybackSuppressionReason();
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata getPlaylistMetadata() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9856Q;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Renderer getRenderer(int i) {
        m2417a();
        return this.f9489a.getRenderer(i);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getRendererCount() {
        m2417a();
        return this.f9489a.getRendererCount();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getRendererType(int i) {
        m2417a();
        return this.f9489a.getRendererType(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9844E;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getSeekBackIncrement() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9904t;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getSeekForwardIncrement() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9906u;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public SeekParameters getSeekParameters() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9851L;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9845F;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public boolean getSkipSilenceEnabled() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9885j0;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    @Deprecated
    public ExoPlayer.TextComponent getTextComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        m2417a();
        return this.f9489a.getTotalBufferedDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionParameters getTrackSelectionParameters() {
        m2417a();
        return this.f9489a.getTrackSelectionParameters();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public TrackSelector getTrackSelector() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9878g;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public int getVideoChangeFrameRateStrategy() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9869b0;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    @Deprecated
    public ExoPlayer.VideoComponent getVideoComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    public DecoderCounters getVideoDecoderCounters() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9875e0;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    public Format getVideoFormat() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9857R;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public int getVideoScalingMode() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9867a0;
    }

    @Override // com.google.android.exoplayer2.Player
    public VideoSize getVideoSize() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9905t0;
    }

    @Override // com.google.android.exoplayer2.Player
    public float getVolume() {
        m2417a();
        C0658d c0658d = this.f9489a;
        c0658d.m2506y();
        return c0658d.f9883i0;
    }

    @Override // com.google.android.exoplayer2.Player
    public void increaseDeviceVolume() {
        m2417a();
        this.f9489a.increaseDeviceVolume();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isDeviceMuted() {
        m2417a();
        return this.f9489a.isDeviceMuted();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        m2417a();
        return this.f9489a.isLoading();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        m2417a();
        return this.f9489a.isPlayingAd();
    }

    @Override // com.google.android.exoplayer2.Player
    public void moveMediaItems(int i, int i2, int i3) {
        m2417a();
        this.f9489a.moveMediaItems(i, i2, i3);
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
        m2417a();
        this.f9489a.prepare();
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        m2417a();
        this.f9489a.release();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void removeAnalyticsListener(AnalyticsListener analyticsListener) {
        m2417a();
        this.f9489a.removeAnalyticsListener(analyticsListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void removeAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        m2417a();
        this.f9489a.removeAudioOffloadListener(audioOffloadListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(Player.Listener listener) {
        m2417a();
        this.f9489a.removeListener(listener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeMediaItems(int i, int i2) {
        m2417a();
        this.f9489a.removeMediaItems(i, i2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void retry() {
        m2417a();
        this.f9489a.retry();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i, long j) {
        m2417a();
        this.f9489a.seekTo(i, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
        m2417a();
        this.f9489a.setAudioAttributes(audioAttributes, z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setAudioSessionId(int i) {
        m2417a();
        this.f9489a.setAudioSessionId(i);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        m2417a();
        this.f9489a.setAuxEffectInfo(auxEffectInfo);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setCameraMotionListener(CameraMotionListener cameraMotionListener) {
        m2417a();
        this.f9489a.setCameraMotionListener(cameraMotionListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setDeviceMuted(boolean z) {
        m2417a();
        this.f9489a.setDeviceMuted(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setDeviceVolume(int i) {
        m2417a();
        this.f9489a.setDeviceVolume(i);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setForegroundMode(boolean z) {
        m2417a();
        this.f9489a.setForegroundMode(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setHandleAudioBecomingNoisy(boolean z) {
        m2417a();
        this.f9489a.setHandleAudioBecomingNoisy(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void setHandleWakeLock(boolean z) {
        m2417a();
        this.f9489a.setHandleWakeLock(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list, boolean z) {
        m2417a();
        this.f9489a.setMediaItems(list, z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource) {
        m2417a();
        this.f9489a.setMediaSource(mediaSource);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list) {
        m2417a();
        this.f9489a.setMediaSources(list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setPauseAtEndOfMediaItems(boolean z) {
        m2417a();
        this.f9489a.setPauseAtEndOfMediaItems(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        m2417a();
        this.f9489a.setPlayWhenReady(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        m2417a();
        this.f9489a.setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        m2417a();
        this.f9489a.setPlaylistMetadata(mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager) {
        m2417a();
        this.f9489a.setPriorityTaskManager(priorityTaskManager);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i) {
        m2417a();
        this.f9489a.setRepeatMode(i);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setSeekParameters(@Nullable SeekParameters seekParameters) {
        m2417a();
        this.f9489a.setSeekParameters(seekParameters);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z) {
        m2417a();
        this.f9489a.setShuffleModeEnabled(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        m2417a();
        this.f9489a.setShuffleOrder(shuffleOrder);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setSkipSilenceEnabled(boolean z) {
        m2417a();
        this.f9489a.setSkipSilenceEnabled(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        m2417a();
        this.f9489a.setTrackSelectionParameters(trackSelectionParameters);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoChangeFrameRateStrategy(int i) {
        m2417a();
        this.f9489a.setVideoChangeFrameRateStrategy(i);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        m2417a();
        this.f9489a.setVideoFrameMetadataListener(videoFrameMetadataListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoScalingMode(int i) {
        m2417a();
        this.f9489a.setVideoScalingMode(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoSurface(@Nullable Surface surface) {
        m2417a();
        this.f9489a.setVideoSurface(surface);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        m2417a();
        this.f9489a.setVideoSurfaceHolder(surfaceHolder);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        m2417a();
        this.f9489a.setVideoSurfaceView(surfaceView);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoTextureView(@Nullable TextureView textureView) {
        m2417a();
        this.f9489a.setVideoTextureView(textureView);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVolume(float f) {
        m2417a();
        this.f9489a.setVolume(f);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setWakeMode(int i) {
        m2417a();
        this.f9489a.setWakeMode(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop() {
        m2417a();
        this.f9489a.stop();
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final ExoPlayer.Builder f9491a;

        @Deprecated
        public Builder(Context context) {
            this.f9491a = new ExoPlayer.Builder(context);
        }

        @Deprecated
        public SimpleExoPlayer build() {
            ExoPlayer.Builder builder = this.f9491a;
            Assertions.checkState(!builder.f9322B);
            builder.f9322B = true;
            return new SimpleExoPlayer(builder);
        }

        @Deprecated
        public Builder experimentalSetForegroundModeTimeoutMs(long j) {
            this.f9491a.experimentalSetForegroundModeTimeoutMs(j);
            return this;
        }

        @Deprecated
        public Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector) {
            this.f9491a.setAnalyticsCollector(analyticsCollector);
            return this;
        }

        @Deprecated
        public Builder setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
            this.f9491a.setAudioAttributes(audioAttributes, z);
            return this;
        }

        @Deprecated
        public Builder setBandwidthMeter(BandwidthMeter bandwidthMeter) {
            this.f9491a.setBandwidthMeter(bandwidthMeter);
            return this;
        }

        @VisibleForTesting
        @Deprecated
        public Builder setClock(Clock clock) {
            this.f9491a.setClock(clock);
            return this;
        }

        @Deprecated
        public Builder setDetachSurfaceTimeoutMs(long j) {
            this.f9491a.setDetachSurfaceTimeoutMs(j);
            return this;
        }

        @Deprecated
        public Builder setHandleAudioBecomingNoisy(boolean z) {
            this.f9491a.setHandleAudioBecomingNoisy(z);
            return this;
        }

        @Deprecated
        public Builder setLivePlaybackSpeedControl(LivePlaybackSpeedControl livePlaybackSpeedControl) {
            this.f9491a.setLivePlaybackSpeedControl(livePlaybackSpeedControl);
            return this;
        }

        @Deprecated
        public Builder setLoadControl(LoadControl loadControl) {
            this.f9491a.setLoadControl(loadControl);
            return this;
        }

        @Deprecated
        public Builder setLooper(Looper looper) {
            this.f9491a.setLooper(looper);
            return this;
        }

        @Deprecated
        public Builder setMediaSourceFactory(MediaSource.Factory factory) {
            this.f9491a.setMediaSourceFactory(factory);
            return this;
        }

        @Deprecated
        public Builder setPauseAtEndOfMediaItems(boolean z) {
            this.f9491a.setPauseAtEndOfMediaItems(z);
            return this;
        }

        @Deprecated
        public Builder setPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager) {
            this.f9491a.setPriorityTaskManager(priorityTaskManager);
            return this;
        }

        @Deprecated
        public Builder setReleaseTimeoutMs(long j) {
            this.f9491a.setReleaseTimeoutMs(j);
            return this;
        }

        @Deprecated
        public Builder setSeekBackIncrementMs(@IntRange(from = 1) long j) {
            this.f9491a.setSeekBackIncrementMs(j);
            return this;
        }

        @Deprecated
        public Builder setSeekForwardIncrementMs(@IntRange(from = 1) long j) {
            this.f9491a.setSeekForwardIncrementMs(j);
            return this;
        }

        @Deprecated
        public Builder setSeekParameters(SeekParameters seekParameters) {
            this.f9491a.setSeekParameters(seekParameters);
            return this;
        }

        @Deprecated
        public Builder setSkipSilenceEnabled(boolean z) {
            this.f9491a.setSkipSilenceEnabled(z);
            return this;
        }

        @Deprecated
        public Builder setTrackSelector(TrackSelector trackSelector) {
            this.f9491a.setTrackSelector(trackSelector);
            return this;
        }

        @Deprecated
        public Builder setUseLazyPreparation(boolean z) {
            this.f9491a.setUseLazyPreparation(z);
            return this;
        }

        @Deprecated
        public Builder setVideoChangeFrameRateStrategy(int i) {
            this.f9491a.setVideoChangeFrameRateStrategy(i);
            return this;
        }

        @Deprecated
        public Builder setVideoScalingMode(int i) {
            this.f9491a.setVideoScalingMode(i);
            return this;
        }

        @Deprecated
        public Builder setWakeMode(int i) {
            this.f9491a.setWakeMode(i);
            return this;
        }

        @Deprecated
        public Builder(Context context, RenderersFactory renderersFactory) {
            this.f9491a = new ExoPlayer.Builder(context, renderersFactory);
        }

        @Deprecated
        public Builder(Context context, ExtractorsFactory extractorsFactory) {
            this.f9491a = new ExoPlayer.Builder(context, new DefaultMediaSourceFactory(context, extractorsFactory));
        }

        @Deprecated
        public Builder(Context context, RenderersFactory renderersFactory, ExtractorsFactory extractorsFactory) {
            this.f9491a = new ExoPlayer.Builder(context, renderersFactory, new DefaultMediaSourceFactory(context, extractorsFactory));
        }

        @Deprecated
        public Builder(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSource.Factory factory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector) {
            this.f9491a = new ExoPlayer.Builder(context, renderersFactory, factory, trackSelector, loadControl, bandwidthMeter, analyticsCollector);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public ExoPlaybackException getPlayerError() {
        m2417a();
        return this.f9489a.getPlayerError();
    }

    @Deprecated
    public SimpleExoPlayer(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSource.Factory factory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, boolean z, Clock clock, Looper looper) {
        this(new ExoPlayer.Builder(context, renderersFactory, factory, trackSelector, loadControl, bandwidthMeter, analyticsCollector).setUseLazyPreparation(z).setClock(clock).setLooper(looper));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSource(int i, MediaSource mediaSource) {
        m2417a();
        this.f9489a.addMediaSource(i, mediaSource);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(int i, List<MediaSource> list) {
        m2417a();
        this.f9489a.addMediaSources(i, list);
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurface(@Nullable Surface surface) {
        m2417a();
        this.f9489a.clearVideoSurface(surface);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void prepare(MediaSource mediaSource) {
        m2417a();
        this.f9489a.prepare(mediaSource);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list, int i, long j) {
        m2417a();
        this.f9489a.setMediaItems(list, i, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource, boolean z) {
        m2417a();
        this.f9489a.setMediaSource(mediaSource, z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list, boolean z) {
        m2417a();
        this.f9489a.setMediaSources(list, z);
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void stop(boolean z) {
        m2417a();
        this.f9489a.stop(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        m2417a();
        this.f9489a.prepare(mediaSource, z, z2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(MediaSource mediaSource, long j) {
        m2417a();
        this.f9489a.setMediaSource(mediaSource, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list, int i, long j) {
        m2417a();
        this.f9489a.setMediaSources(list, i, j);
    }

    public SimpleExoPlayer(ExoPlayer.Builder builder) {
        ConditionVariable conditionVariable = new ConditionVariable();
        this.f9490b = conditionVariable;
        try {
            this.f9489a = new C0658d(builder, this);
            conditionVariable.open();
        } catch (Throwable th) {
            this.f9490b.open();
            throw th;
        }
    }
}
