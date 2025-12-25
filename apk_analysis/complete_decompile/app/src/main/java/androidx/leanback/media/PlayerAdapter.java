package androidx.leanback.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class PlayerAdapter {

    /* renamed from: a */
    public Callback f5464a;

    /* loaded from: classes.dex */
    public static class Callback {
        public void onBufferedPositionChanged(@NonNull PlayerAdapter playerAdapter) {
        }

        public void onBufferingStateChanged(@NonNull PlayerAdapter playerAdapter, boolean z) {
        }

        public void onCurrentPositionChanged(@NonNull PlayerAdapter playerAdapter) {
        }

        public void onDurationChanged(@NonNull PlayerAdapter playerAdapter) {
        }

        public void onError(@NonNull PlayerAdapter playerAdapter, int i, @Nullable String str) {
        }

        public void onMetadataChanged(@NonNull PlayerAdapter playerAdapter) {
        }

        public void onPlayCompleted(@NonNull PlayerAdapter playerAdapter) {
        }

        public void onPlayStateChanged(@NonNull PlayerAdapter playerAdapter) {
        }

        public void onPreparedStateChanged(@NonNull PlayerAdapter playerAdapter) {
        }

        public void onVideoSizeChanged(@NonNull PlayerAdapter playerAdapter, int i, int i2) {
        }
    }

    public void fastForward() {
    }

    public long getBufferedPosition() {
        return 0L;
    }

    @Nullable
    public final Callback getCallback() {
        return this.f5464a;
    }

    public long getCurrentPosition() {
        return 0L;
    }

    public long getDuration() {
        return 0L;
    }

    public long getSupportedActions() {
        return 64L;
    }

    public boolean isPlaying() {
        return false;
    }

    public boolean isPrepared() {
        return true;
    }

    public void next() {
    }

    public void onAttachedToHost(@NonNull PlaybackGlueHost playbackGlueHost) {
    }

    public void onDetachedFromHost() {
    }

    public abstract void pause();

    public abstract void play();

    public void previous() {
    }

    public void rewind() {
    }

    public void seekTo(long j) {
    }

    public final void setCallback(@Nullable Callback callback) {
        this.f5464a = callback;
    }

    public void setProgressUpdatingEnabled(boolean z) {
    }

    public void setRepeatAction(int i) {
    }

    public void setShuffleAction(int i) {
    }
}
