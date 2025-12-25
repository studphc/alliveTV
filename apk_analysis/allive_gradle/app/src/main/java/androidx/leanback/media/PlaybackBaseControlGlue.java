package androidx.leanback.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.media.PlayerAdapter;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ControlButtonPresenterSelector;
import androidx.leanback.widget.OnActionClickedListener;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackRowPresenter;
import java.util.List;

/* loaded from: classes.dex */
public abstract class PlaybackBaseControlGlue<T extends PlayerAdapter> extends PlaybackGlue implements OnActionClickedListener, View.OnKeyListener {
    public static final int ACTION_CUSTOM_LEFT_FIRST = 1;
    public static final int ACTION_CUSTOM_RIGHT_FIRST = 4096;
    public static final int ACTION_FAST_FORWARD = 128;
    public static final int ACTION_PLAY_PAUSE = 64;
    public static final int ACTION_REPEAT = 512;
    public static final int ACTION_REWIND = 32;
    public static final int ACTION_SHUFFLE = 1024;
    public static final int ACTION_SKIP_TO_NEXT = 256;
    public static final int ACTION_SKIP_TO_PREVIOUS = 16;

    /* renamed from: d */
    public final PlayerAdapter f5426d;

    /* renamed from: e */
    public PlaybackControlsRow f5427e;

    /* renamed from: f */
    public PlaybackRowPresenter f5428f;

    /* renamed from: g */
    public PlaybackControlsRow.PlayPauseAction f5429g;

    /* renamed from: h */
    public boolean f5430h;

    /* renamed from: i */
    public boolean f5431i;

    /* renamed from: j */
    public CharSequence f5432j;

    /* renamed from: k */
    public CharSequence f5433k;

    /* renamed from: l */
    public Drawable f5434l;

    /* renamed from: m */
    public PlaybackGlueHost.PlayerCallback f5435m;

    /* renamed from: n */
    public boolean f5436n;

    /* renamed from: o */
    public int f5437o;

    /* renamed from: p */
    public int f5438p;

    /* renamed from: q */
    public boolean f5439q;

    /* renamed from: r */
    public int f5440r;

    /* renamed from: s */
    public String f5441s;

    public PlaybackBaseControlGlue(@NonNull Context context, T t) {
        super(context);
        this.f5430h = false;
        this.f5431i = true;
        this.f5436n = false;
        this.f5437o = 0;
        this.f5438p = 0;
        this.f5439q = false;
        C0307j c0307j = new C0307j(this);
        this.f5426d = t;
        t.setCallback(c0307j);
    }

    public static void notifyItemChanged(@NonNull ArrayObjectAdapter arrayObjectAdapter, @NonNull Object obj) {
        int indexOf = arrayObjectAdapter.indexOf(obj);
        if (indexOf >= 0) {
            arrayObjectAdapter.notifyArrayItemRangeChanged(indexOf, 1);
        }
    }

    @Nullable
    public Drawable getArt() {
        return this.f5434l;
    }

    public final long getBufferedPosition() {
        return this.f5426d.getBufferedPosition();
    }

    @Nullable
    public PlaybackControlsRow getControlsRow() {
        return this.f5427e;
    }

    public long getCurrentPosition() {
        return this.f5426d.getCurrentPosition();
    }

    public final long getDuration() {
        return this.f5426d.getDuration();
    }

    @Nullable
    public PlaybackRowPresenter getPlaybackRowPresenter() {
        return this.f5428f;
    }

    public final T getPlayerAdapter() {
        return (T) this.f5426d;
    }

    @Nullable
    public CharSequence getSubtitle() {
        return this.f5432j;
    }

    public long getSupportedActions() {
        return this.f5426d.getSupportedActions();
    }

    @Nullable
    public CharSequence getTitle() {
        return this.f5433k;
    }

    public boolean isControlsOverlayAutoHideEnabled() {
        return this.f5431i;
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public final boolean isPlaying() {
        return this.f5426d.isPlaying();
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public final boolean isPrepared() {
        return this.f5426d.isPrepared();
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void next() {
        this.f5426d.next();
    }

    public abstract void onActionClicked(@NonNull Action action);

    @Override // androidx.leanback.media.PlaybackGlue
    public void onAttachedToHost(@NonNull PlaybackGlueHost playbackGlueHost) {
        int i;
        super.onAttachedToHost(playbackGlueHost);
        playbackGlueHost.setOnKeyInterceptListener(this);
        playbackGlueHost.setOnActionClickedListener(this);
        if (this.f5427e == null) {
            setControlsRow(new PlaybackControlsRow(this));
        }
        if (this.f5428f == null) {
            setPlaybackRowPresenter(onCreateRowPresenter());
        }
        playbackGlueHost.setPlaybackRowPresenter(getPlaybackRowPresenter());
        playbackGlueHost.setPlaybackRow(getControlsRow());
        PlaybackGlueHost.PlayerCallback playerCallback = playbackGlueHost.getPlayerCallback();
        this.f5435m = playerCallback;
        if (playerCallback != null) {
            int i2 = this.f5437o;
            if (i2 != 0 && (i = this.f5438p) != 0) {
                playerCallback.onVideoSizeChanged(i2, i);
            }
            if (this.f5439q) {
                this.f5435m.onError(this.f5440r, this.f5441s);
            }
            this.f5435m.onBufferingStateChanged(this.f5436n);
        }
        this.f5426d.onAttachedToHost(playbackGlueHost);
    }

    public void onCreatePrimaryActions(@NonNull ArrayObjectAdapter arrayObjectAdapter) {
    }

    @NonNull
    public abstract PlaybackRowPresenter onCreateRowPresenter();

    public void onCreateSecondaryActions(@NonNull ArrayObjectAdapter arrayObjectAdapter) {
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void onDetachedFromHost() {
        this.f5439q = false;
        this.f5440r = 0;
        this.f5441s = null;
        PlaybackGlueHost.PlayerCallback playerCallback = this.f5435m;
        if (playerCallback != null) {
            playerCallback.onBufferingStateChanged(false);
        }
        this.f5435m = null;
        PlayerAdapter playerAdapter = this.f5426d;
        playerAdapter.onDetachedFromHost();
        playerAdapter.setProgressUpdatingEnabled(false);
        super.onDetachedFromHost();
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void onHostStart() {
        this.f5426d.setProgressUpdatingEnabled(true);
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void onHostStop() {
        this.f5426d.setProgressUpdatingEnabled(false);
    }

    public abstract boolean onKey(View view, int i, KeyEvent keyEvent);

    public void onMetadataChanged() {
        PlaybackControlsRow playbackControlsRow = this.f5427e;
        if (playbackControlsRow == null) {
            return;
        }
        playbackControlsRow.setImageDrawable(getArt());
        this.f5427e.setDuration(getDuration());
        this.f5427e.setCurrentPosition(getCurrentPosition());
        if (getHost() != null) {
            getHost().notifyPlaybackRowChanged();
        }
    }

    @CallSuper
    public void onPlayCompleted() {
        List<PlaybackGlue.PlayerCallback> playerCallbacks = getPlayerCallbacks();
        if (playerCallbacks != null) {
            int size = playerCallbacks.size();
            for (int i = 0; i < size; i++) {
                playerCallbacks.get(i).onPlayCompleted(this);
            }
        }
    }

    @CallSuper
    public void onPlayStateChanged() {
        List<PlaybackGlue.PlayerCallback> playerCallbacks = getPlayerCallbacks();
        if (playerCallbacks != null) {
            int size = playerCallbacks.size();
            for (int i = 0; i < size; i++) {
                playerCallbacks.get(i).onPlayStateChanged(this);
            }
        }
    }

    @CallSuper
    public void onPreparedStateChanged() {
        onUpdateDuration();
        List<PlaybackGlue.PlayerCallback> playerCallbacks = getPlayerCallbacks();
        if (playerCallbacks != null) {
            int size = playerCallbacks.size();
            for (int i = 0; i < size; i++) {
                playerCallbacks.get(i).onPreparedStateChanged(this);
            }
        }
    }

    @CallSuper
    public void onUpdateBufferedProgress() {
        PlaybackControlsRow playbackControlsRow = this.f5427e;
        if (playbackControlsRow != null) {
            playbackControlsRow.setBufferedPosition(this.f5426d.getBufferedPosition());
        }
    }

    @CallSuper
    public void onUpdateDuration() {
        long j;
        PlaybackControlsRow playbackControlsRow = this.f5427e;
        if (playbackControlsRow != null) {
            PlayerAdapter playerAdapter = this.f5426d;
            if (playerAdapter.isPrepared()) {
                j = playerAdapter.getDuration();
            } else {
                j = -1;
            }
            playbackControlsRow.setDuration(j);
        }
    }

    @CallSuper
    public void onUpdateProgress() {
        long j;
        PlaybackControlsRow playbackControlsRow = this.f5427e;
        if (playbackControlsRow != null) {
            if (this.f5426d.isPrepared()) {
                j = getCurrentPosition();
            } else {
                j = -1;
            }
            playbackControlsRow.setCurrentPosition(j);
        }
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void pause() {
        this.f5426d.pause();
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void play() {
        this.f5426d.play();
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void previous() {
        this.f5426d.previous();
    }

    public final void seekTo(long j) {
        this.f5426d.seekTo(j);
    }

    public void setArt(@Nullable Drawable drawable) {
        if (this.f5434l == drawable) {
            return;
        }
        this.f5434l = drawable;
        this.f5427e.setImageDrawable(drawable);
        if (getHost() != null) {
            getHost().notifyPlaybackRowChanged();
        }
    }

    public void setControlsOverlayAutoHideEnabled(boolean z) {
        this.f5431i = z;
        if (!z && getHost() != null) {
            getHost().setControlsOverlayAutoHideEnabled(false);
        }
    }

    public void setControlsRow(@NonNull PlaybackControlsRow playbackControlsRow) {
        this.f5427e = playbackControlsRow;
        playbackControlsRow.setCurrentPosition(-1L);
        this.f5427e.setDuration(-1L);
        this.f5427e.setBufferedPosition(-1L);
        if (this.f5427e.getPrimaryActionsAdapter() == null) {
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new ControlButtonPresenterSelector());
            onCreatePrimaryActions(arrayObjectAdapter);
            this.f5427e.setPrimaryActionsAdapter(arrayObjectAdapter);
        }
        if (this.f5427e.getSecondaryActionsAdapter() == null) {
            ArrayObjectAdapter arrayObjectAdapter2 = new ArrayObjectAdapter(new ControlButtonPresenterSelector());
            onCreateSecondaryActions(arrayObjectAdapter2);
            getControlsRow().setSecondaryActionsAdapter(arrayObjectAdapter2);
        }
        onMetadataChanged();
    }

    public void setPlaybackRowPresenter(@Nullable PlaybackRowPresenter playbackRowPresenter) {
        this.f5428f = playbackRowPresenter;
    }

    public void setSubtitle(@Nullable CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f5432j)) {
            return;
        }
        this.f5432j = charSequence;
        if (getHost() != null) {
            getHost().notifyPlaybackRowChanged();
        }
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f5433k)) {
            return;
        }
        this.f5433k = charSequence;
        if (getHost() != null) {
            getHost().notifyPlaybackRowChanged();
        }
    }
}
