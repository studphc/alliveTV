package androidx.leanback.media;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class PlaybackGlue {

    /* renamed from: a */
    public final Context f5455a;

    /* renamed from: b */
    public PlaybackGlueHost f5456b;

    /* renamed from: c */
    public ArrayList f5457c;

    /* loaded from: classes.dex */
    public static abstract class PlayerCallback {
        public void onPlayCompleted(@NonNull PlaybackGlue playbackGlue) {
        }

        public void onPlayStateChanged(@NonNull PlaybackGlue playbackGlue) {
        }

        public void onPreparedStateChanged(@NonNull PlaybackGlue playbackGlue) {
        }
    }

    public PlaybackGlue(@NonNull Context context) {
        this.f5455a = context;
    }

    public void addPlayerCallback(@NonNull PlayerCallback playerCallback) {
        if (this.f5457c == null) {
            this.f5457c = new ArrayList();
        }
        this.f5457c.add(playerCallback);
    }

    @NonNull
    public Context getContext() {
        return this.f5455a;
    }

    @Nullable
    public PlaybackGlueHost getHost() {
        return this.f5456b;
    }

    @Nullable
    @SuppressLint({"NullableCollection"})
    public List<PlayerCallback> getPlayerCallbacks() {
        if (this.f5457c == null) {
            return null;
        }
        return new ArrayList(this.f5457c);
    }

    public boolean isPlaying() {
        return false;
    }

    public boolean isPrepared() {
        return true;
    }

    public void next() {
    }

    @CallSuper
    public void onAttachedToHost(@NonNull PlaybackGlueHost playbackGlueHost) {
        this.f5456b = playbackGlueHost;
        playbackGlueHost.setHostCallback(new C0309l(this));
    }

    @CallSuper
    public void onDetachedFromHost() {
        PlaybackGlueHost playbackGlueHost = this.f5456b;
        if (playbackGlueHost != null) {
            playbackGlueHost.setHostCallback(null);
            this.f5456b = null;
        }
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public void onHostStart() {
    }

    public void onHostStop() {
    }

    public void pause() {
    }

    public void play() {
    }

    public void playWhenPrepared() {
        if (isPrepared()) {
            play();
        } else {
            addPlayerCallback(new C0308k(this));
        }
    }

    public void previous() {
    }

    public void removePlayerCallback(@NonNull PlayerCallback playerCallback) {
        ArrayList arrayList = this.f5457c;
        if (arrayList != null) {
            arrayList.remove(playerCallback);
        }
    }

    public final void setHost(@Nullable PlaybackGlueHost playbackGlueHost) {
        PlaybackGlueHost playbackGlueHost2 = this.f5456b;
        if (playbackGlueHost2 == playbackGlueHost) {
            return;
        }
        if (playbackGlueHost2 != null) {
            PlaybackGlue playbackGlue = playbackGlueHost2.f5458a;
            if (playbackGlue != null) {
                playbackGlue.onDetachedFromHost();
            }
            playbackGlueHost2.f5458a = null;
        }
        this.f5456b = playbackGlueHost;
        if (playbackGlueHost != null) {
            PlaybackGlue playbackGlue2 = playbackGlueHost.f5458a;
            if (playbackGlue2 != null) {
                playbackGlue2.onDetachedFromHost();
            }
            playbackGlueHost.f5458a = this;
            onAttachedToHost(playbackGlueHost);
        }
    }
}
