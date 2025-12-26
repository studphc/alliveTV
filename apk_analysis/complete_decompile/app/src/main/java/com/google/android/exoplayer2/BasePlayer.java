package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BasePlayer implements Player {
    protected final Timeline.Window window = new Timeline.Window();

    @Override // com.google.android.exoplayer2.Player
    public final void addMediaItem(int i, MediaItem mediaItem) {
        addMediaItems(i, Collections.singletonList(mediaItem));
    }

    @Override // com.google.android.exoplayer2.Player
    public final void addMediaItems(List<MediaItem> list) {
        addMediaItems(Integer.MAX_VALUE, list);
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean canAdvertiseSession() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Player
    public final void clearMediaItems() {
        removeMediaItems(0, Integer.MAX_VALUE);
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == C0643C.TIME_UNSET || duration == C0643C.TIME_UNSET) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getContentDuration() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return C0643C.TIME_UNSET;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).getDurationMs();
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getCurrentLiveOffset() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty() || currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).windowStartTimeMs == C0643C.TIME_UNSET) {
            return C0643C.TIME_UNSET;
        }
        return (this.window.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - getContentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public final Object getCurrentManifest() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).manifest;
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public final MediaItem getCurrentMediaItem() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).mediaItem;
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final int getCurrentWindowIndex() {
        return getCurrentMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public final MediaItem getMediaItemAt(int i) {
        return getCurrentTimeline().getWindow(i, this.window).mediaItem;
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getMediaItemCount() {
        return getCurrentTimeline().getWindowCount();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getNextMediaItemIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            repeatMode = 0;
        }
        return currentTimeline.getNextWindowIndex(currentMediaItemIndex, repeatMode, getShuffleModeEnabled());
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final int getNextWindowIndex() {
        return getNextMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getPreviousMediaItemIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            repeatMode = 0;
        }
        return currentTimeline.getPreviousWindowIndex(currentMediaItemIndex, repeatMode, getShuffleModeEnabled());
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final int getPreviousWindowIndex() {
        return getPreviousMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final boolean hasNext() {
        return hasNextMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean hasNextMediaItem() {
        if (getNextMediaItemIndex() != -1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final boolean hasNextWindow() {
        return hasNextMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final boolean hasPrevious() {
        return hasPreviousMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean hasPreviousMediaItem() {
        if (getPreviousMediaItemIndex() != -1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final boolean hasPreviousWindow() {
        return hasPreviousMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isCommandAvailable(int i) {
        return getAvailableCommands().contains(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isCurrentMediaItemDynamic() {
        Timeline currentTimeline = getCurrentTimeline();
        if (!currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isDynamic) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isCurrentMediaItemLive() {
        Timeline currentTimeline = getCurrentTimeline();
        if (!currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isLive()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isCurrentMediaItemSeekable() {
        Timeline currentTimeline = getCurrentTimeline();
        if (!currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isSeekable) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final boolean isCurrentWindowDynamic() {
        return isCurrentMediaItemDynamic();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final boolean isCurrentWindowLive() {
        return isCurrentMediaItemLive();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final boolean isCurrentWindowSeekable() {
        return isCurrentMediaItemSeekable();
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isPlaying() {
        if (getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Player
    public final void moveMediaItem(int i, int i2) {
        if (i != i2) {
            moveMediaItems(i, i + 1, i2);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final void next() {
        seekToNextMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void pause() {
        setPlayWhenReady(false);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void play() {
        setPlayWhenReady(true);
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final void previous() {
        seekToPreviousMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void removeMediaItem(int i) {
        removeMediaItems(i, i + 1);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekBack() {
        long currentPosition = getCurrentPosition() + (-getSeekBackIncrement());
        long duration = getDuration();
        if (duration != C0643C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekTo(Math.max(currentPosition, 0L));
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekForward() {
        long currentPosition = getCurrentPosition() + getSeekForwardIncrement();
        long duration = getDuration();
        if (duration != C0643C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekTo(Math.max(currentPosition, 0L));
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekTo(long j) {
        seekTo(getCurrentMediaItemIndex(), j);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentMediaItemIndex());
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToNext() {
        if (!getCurrentTimeline().isEmpty() && !isPlayingAd()) {
            if (hasNextMediaItem()) {
                seekToNextMediaItem();
            } else if (isCurrentMediaItemLive() && isCurrentMediaItemDynamic()) {
                seekToDefaultPosition();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToNextMediaItem() {
        int nextMediaItemIndex = getNextMediaItemIndex();
        if (nextMediaItemIndex != -1) {
            seekToDefaultPosition(nextMediaItemIndex);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final void seekToNextWindow() {
        seekToNextMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToPrevious() {
        if (!getCurrentTimeline().isEmpty() && !isPlayingAd()) {
            boolean hasPreviousMediaItem = hasPreviousMediaItem();
            if (isCurrentMediaItemLive() && !isCurrentMediaItemSeekable()) {
                if (hasPreviousMediaItem) {
                    seekToPreviousMediaItem();
                }
            } else if (hasPreviousMediaItem && getCurrentPosition() <= getMaxSeekToPreviousPosition()) {
                seekToPreviousMediaItem();
            } else {
                seekTo(0L);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToPreviousMediaItem() {
        int previousMediaItemIndex = getPreviousMediaItemIndex();
        if (previousMediaItemIndex != -1) {
            seekToDefaultPosition(previousMediaItemIndex);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final void seekToPreviousWindow() {
        seekToPreviousMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setMediaItem(MediaItem mediaItem) {
        setMediaItems(Collections.singletonList(mediaItem));
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setMediaItems(List<MediaItem> list) {
        setMediaItems(list, true);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setPlaybackSpeed(float f) {
        setPlaybackParameters(getPlaybackParameters().withSpeed(f));
    }

    @Override // com.google.android.exoplayer2.Player
    public final void addMediaItem(MediaItem mediaItem) {
        addMediaItems(Collections.singletonList(mediaItem));
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToDefaultPosition(int i) {
        seekTo(i, C0643C.TIME_UNSET);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setMediaItem(MediaItem mediaItem, long j) {
        setMediaItems(Collections.singletonList(mediaItem), 0, j);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setMediaItem(MediaItem mediaItem, boolean z) {
        setMediaItems(Collections.singletonList(mediaItem), z);
    }
}
