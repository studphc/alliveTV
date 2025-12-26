package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.VideoSize;
import java.util.List;

/* loaded from: classes.dex */
public class ForwardingPlayer implements Player {

    /* renamed from: a */
    public final Player f9385a;

    public ForwardingPlayer(Player player) {
        this.f9385a = player;
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(Player.Listener listener) {
        this.f9385a.addListener(new C0673g(this, listener));
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItem(MediaItem mediaItem) {
        this.f9385a.addMediaItem(mediaItem);
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(List<MediaItem> list) {
        this.f9385a.addMediaItems(list);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean canAdvertiseSession() {
        return this.f9385a.canAdvertiseSession();
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearMediaItems() {
        this.f9385a.clearMediaItems();
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurface() {
        this.f9385a.clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        this.f9385a.clearVideoSurfaceHolder(surfaceHolder);
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        this.f9385a.clearVideoSurfaceView(surfaceView);
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        this.f9385a.clearVideoTextureView(textureView);
    }

    @Override // com.google.android.exoplayer2.Player
    public void decreaseDeviceVolume() {
        this.f9385a.decreaseDeviceVolume();
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper getApplicationLooper() {
        return this.f9385a.getApplicationLooper();
    }

    @Override // com.google.android.exoplayer2.Player
    public AudioAttributes getAudioAttributes() {
        return this.f9385a.getAudioAttributes();
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.Commands getAvailableCommands() {
        return this.f9385a.getAvailableCommands();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getBufferedPercentage() {
        return this.f9385a.getBufferedPercentage();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        return this.f9385a.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        return this.f9385a.getContentBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentDuration() {
        return this.f9385a.getContentDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        return this.f9385a.getContentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        return this.f9385a.getCurrentAdGroupIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        return this.f9385a.getCurrentAdIndexInAdGroup();
    }

    @Override // com.google.android.exoplayer2.Player
    public CueGroup getCurrentCues() {
        return this.f9385a.getCurrentCues();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentLiveOffset() {
        return this.f9385a.getCurrentLiveOffset();
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public Object getCurrentManifest() {
        return this.f9385a.getCurrentManifest();
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public MediaItem getCurrentMediaItem() {
        return this.f9385a.getCurrentMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentMediaItemIndex() {
        return this.f9385a.getCurrentMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        return this.f9385a.getCurrentPeriodIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        return this.f9385a.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        return this.f9385a.getCurrentTimeline();
    }

    @Override // com.google.android.exoplayer2.Player
    public Tracks getCurrentTracks() {
        return this.f9385a.getCurrentTracks();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public int getCurrentWindowIndex() {
        return this.f9385a.getCurrentWindowIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public DeviceInfo getDeviceInfo() {
        return this.f9385a.getDeviceInfo();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getDeviceVolume() {
        return this.f9385a.getDeviceVolume();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        return this.f9385a.getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getMaxSeekToPreviousPosition() {
        return this.f9385a.getMaxSeekToPreviousPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaItem getMediaItemAt(int i) {
        return this.f9385a.getMediaItemAt(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getMediaItemCount() {
        return this.f9385a.getMediaItemCount();
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata getMediaMetadata() {
        return this.f9385a.getMediaMetadata();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getNextMediaItemIndex() {
        return this.f9385a.getNextMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public int getNextWindowIndex() {
        return this.f9385a.getNextWindowIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        return this.f9385a.getPlayWhenReady();
    }

    @Override // com.google.android.exoplayer2.Player
    public PlaybackParameters getPlaybackParameters() {
        return this.f9385a.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.f9385a.getPlaybackState();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        return this.f9385a.getPlaybackSuppressionReason();
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public PlaybackException getPlayerError() {
        return this.f9385a.getPlayerError();
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata getPlaylistMetadata() {
        return this.f9385a.getPlaylistMetadata();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPreviousMediaItemIndex() {
        return this.f9385a.getPreviousMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public int getPreviousWindowIndex() {
        return this.f9385a.getPreviousWindowIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        return this.f9385a.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getSeekBackIncrement() {
        return this.f9385a.getSeekBackIncrement();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getSeekForwardIncrement() {
        return this.f9385a.getSeekForwardIncrement();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        return this.f9385a.getShuffleModeEnabled();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        return this.f9385a.getTotalBufferedDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionParameters getTrackSelectionParameters() {
        return this.f9385a.getTrackSelectionParameters();
    }

    @Override // com.google.android.exoplayer2.Player
    public VideoSize getVideoSize() {
        return this.f9385a.getVideoSize();
    }

    @Override // com.google.android.exoplayer2.Player
    public float getVolume() {
        return this.f9385a.getVolume();
    }

    public Player getWrappedPlayer() {
        return this.f9385a;
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public boolean hasNext() {
        return this.f9385a.hasNext();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean hasNextMediaItem() {
        return this.f9385a.hasNextMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public boolean hasNextWindow() {
        return this.f9385a.hasNextWindow();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public boolean hasPrevious() {
        return this.f9385a.hasPrevious();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean hasPreviousMediaItem() {
        return this.f9385a.hasPreviousMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public boolean hasPreviousWindow() {
        return this.f9385a.hasPreviousWindow();
    }

    @Override // com.google.android.exoplayer2.Player
    public void increaseDeviceVolume() {
        this.f9385a.increaseDeviceVolume();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCommandAvailable(int i) {
        return this.f9385a.isCommandAvailable(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCurrentMediaItemDynamic() {
        return this.f9385a.isCurrentMediaItemDynamic();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCurrentMediaItemLive() {
        return this.f9385a.isCurrentMediaItemLive();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCurrentMediaItemSeekable() {
        return this.f9385a.isCurrentMediaItemSeekable();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public boolean isCurrentWindowDynamic() {
        return this.f9385a.isCurrentWindowDynamic();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public boolean isCurrentWindowLive() {
        return this.f9385a.isCurrentWindowLive();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public boolean isCurrentWindowSeekable() {
        return this.f9385a.isCurrentWindowSeekable();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isDeviceMuted() {
        return this.f9385a.isDeviceMuted();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        return this.f9385a.isLoading();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlaying() {
        return this.f9385a.isPlaying();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        return this.f9385a.isPlayingAd();
    }

    @Override // com.google.android.exoplayer2.Player
    public void moveMediaItem(int i, int i2) {
        this.f9385a.moveMediaItem(i, i2);
    }

    @Override // com.google.android.exoplayer2.Player
    public void moveMediaItems(int i, int i2, int i3) {
        this.f9385a.moveMediaItems(i, i2, i3);
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void next() {
        this.f9385a.next();
    }

    @Override // com.google.android.exoplayer2.Player
    public void pause() {
        this.f9385a.pause();
    }

    @Override // com.google.android.exoplayer2.Player
    public void play() {
        this.f9385a.play();
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
        this.f9385a.prepare();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void previous() {
        this.f9385a.previous();
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        this.f9385a.release();
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(Player.Listener listener) {
        this.f9385a.removeListener(new C0673g(this, listener));
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeMediaItem(int i) {
        this.f9385a.removeMediaItem(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeMediaItems(int i, int i2) {
        this.f9385a.removeMediaItems(i, i2);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekBack() {
        this.f9385a.seekBack();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekForward() {
        this.f9385a.seekForward();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(long j) {
        this.f9385a.seekTo(j);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToDefaultPosition() {
        this.f9385a.seekToDefaultPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToNext() {
        this.f9385a.seekToNext();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToNextMediaItem() {
        this.f9385a.seekToNextMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void seekToNextWindow() {
        this.f9385a.seekToNextWindow();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToPrevious() {
        this.f9385a.seekToPrevious();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToPreviousMediaItem() {
        this.f9385a.seekToPreviousMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void seekToPreviousWindow() {
        this.f9385a.seekToPreviousWindow();
    }

    @Override // com.google.android.exoplayer2.Player
    public void setDeviceMuted(boolean z) {
        this.f9385a.setDeviceMuted(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setDeviceVolume(int i) {
        this.f9385a.setDeviceVolume(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItem(MediaItem mediaItem) {
        this.f9385a.setMediaItem(mediaItem);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list) {
        this.f9385a.setMediaItems(list);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        this.f9385a.setPlayWhenReady(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.f9385a.setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackSpeed(float f) {
        this.f9385a.setPlaybackSpeed(f);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        this.f9385a.setPlaylistMetadata(mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i) {
        this.f9385a.setRepeatMode(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z) {
        this.f9385a.setShuffleModeEnabled(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        this.f9385a.setTrackSelectionParameters(trackSelectionParameters);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoSurface(@Nullable Surface surface) {
        this.f9385a.setVideoSurface(surface);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        this.f9385a.setVideoSurfaceHolder(surfaceHolder);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        this.f9385a.setVideoSurfaceView(surfaceView);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVideoTextureView(@Nullable TextureView textureView) {
        this.f9385a.setVideoTextureView(textureView);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVolume(float f) {
        this.f9385a.setVolume(f);
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop() {
        this.f9385a.stop();
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItem(int i, MediaItem mediaItem) {
        this.f9385a.addMediaItem(i, mediaItem);
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(int i, List<MediaItem> list) {
        this.f9385a.addMediaItems(i, list);
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearVideoSurface(@Nullable Surface surface) {
        this.f9385a.clearVideoSurface(surface);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i, long j) {
        this.f9385a.seekTo(i, j);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToDefaultPosition(int i) {
        this.f9385a.seekToDefaultPosition(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItem(MediaItem mediaItem, long j) {
        this.f9385a.setMediaItem(mediaItem, j);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list, boolean z) {
        this.f9385a.setMediaItems(list, z);
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void stop(boolean z) {
        this.f9385a.stop(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItem(MediaItem mediaItem, boolean z) {
        this.f9385a.setMediaItem(mediaItem, z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<MediaItem> list, int i, long j) {
        this.f9385a.setMediaItems(list, i, j);
    }
}
