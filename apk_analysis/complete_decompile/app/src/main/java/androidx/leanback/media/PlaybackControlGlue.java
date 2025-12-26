package androidx.leanback.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ControlButtonPresenterSelector;
import androidx.leanback.widget.OnActionClickedListener;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackControlsRowPresenter;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.SparseArrayObjectAdapter;
import com.google.android.exoplayer2.ExoPlayer;
import java.lang.ref.WeakReference;
import java.util.List;
import okhttp3.internal.http.HttpStatusCodesKt;
import p000.qo1;
import p000.z42;

/* loaded from: classes.dex */
public abstract class PlaybackControlGlue extends PlaybackGlue implements OnActionClickedListener, View.OnKeyListener {
    public static final int ACTION_CUSTOM_LEFT_FIRST = 1;
    public static final int ACTION_CUSTOM_RIGHT_FIRST = 4096;
    public static final int ACTION_FAST_FORWARD = 128;
    public static final int ACTION_PLAY_PAUSE = 64;
    public static final int ACTION_REWIND = 32;
    public static final int ACTION_SKIP_TO_NEXT = 256;
    public static final int ACTION_SKIP_TO_PREVIOUS = 16;
    public static final int PLAYBACK_SPEED_FAST_L0 = 10;
    public static final int PLAYBACK_SPEED_FAST_L1 = 11;
    public static final int PLAYBACK_SPEED_FAST_L2 = 12;
    public static final int PLAYBACK_SPEED_FAST_L3 = 13;
    public static final int PLAYBACK_SPEED_FAST_L4 = 14;
    public static final int PLAYBACK_SPEED_INVALID = -1;
    public static final int PLAYBACK_SPEED_NORMAL = 1;
    public static final int PLAYBACK_SPEED_PAUSED = 0;

    /* renamed from: p */
    public static final qo1 f5442p = new qo1(1);

    /* renamed from: d */
    public final int[] f5443d;

    /* renamed from: e */
    public final int[] f5444e;

    /* renamed from: f */
    public PlaybackControlsRow f5445f;

    /* renamed from: g */
    public PlaybackRowPresenter f5446g;

    /* renamed from: h */
    public PlaybackControlsRow.PlayPauseAction f5447h;

    /* renamed from: i */
    public PlaybackControlsRow.SkipNextAction f5448i;

    /* renamed from: j */
    public PlaybackControlsRow.SkipPreviousAction f5449j;

    /* renamed from: k */
    public PlaybackControlsRow.FastForwardAction f5450k;

    /* renamed from: l */
    public PlaybackControlsRow.RewindAction f5451l;

    /* renamed from: m */
    public int f5452m;

    /* renamed from: n */
    public boolean f5453n;

    /* renamed from: o */
    public final WeakReference f5454o;

    public PlaybackControlGlue(Context context, int[] iArr) {
        this(context, iArr, iArr);
    }

    /* renamed from: a */
    public final void m1363a(Action action, KeyEvent keyEvent) {
        int i;
        boolean z;
        if (action == this.f5447h) {
            if (keyEvent != null && keyEvent.getKeyCode() != 85 && keyEvent.getKeyCode() != 126) {
                z = false;
            } else {
                z = true;
            }
            if (keyEvent == null || keyEvent.getKeyCode() == 85 || keyEvent.getKeyCode() == 127) {
                int i2 = this.f5452m;
                if (!z ? i2 != 0 : i2 == 1) {
                    this.f5452m = 0;
                    pause();
                    m1366d();
                    return;
                }
            }
            if (z && this.f5452m != 1) {
                this.f5452m = 1;
                play(1);
            }
            m1366d();
            return;
        }
        if (action == this.f5448i) {
            next();
            return;
        }
        if (action == this.f5449j) {
            previous();
            return;
        }
        if (action == this.f5450k) {
            int i3 = this.f5452m;
            if (i3 < this.f5443d.length + 9) {
                switch (i3) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        this.f5452m = i3 + 1;
                        break;
                    default:
                        this.f5452m = 10;
                        break;
                }
                play(this.f5452m);
                m1366d();
                return;
            }
            return;
        }
        if (action == this.f5451l && (i = this.f5452m) > (-(this.f5444e.length + 9))) {
            switch (i) {
                case -13:
                case -12:
                case -11:
                case -10:
                    this.f5452m = i - 1;
                    break;
                default:
                    this.f5452m = -10;
                    break;
            }
            play(this.f5452m);
            m1366d();
        }
    }

    /* renamed from: b */
    public final void m1364b() {
        if (hasValidMedia()) {
            int currentSpeedId = getCurrentSpeedId();
            this.f5452m = currentSpeedId;
            m1365c(currentSpeedId);
        }
    }

    /* renamed from: c */
    public final void m1365c(int i) {
        int i2;
        boolean z;
        if (this.f5445f == null) {
            return;
        }
        SparseArrayObjectAdapter sparseArrayObjectAdapter = (SparseArrayObjectAdapter) getControlsRow().getPrimaryActionsAdapter();
        PlaybackControlsRow.FastForwardAction fastForwardAction = this.f5450k;
        if (fastForwardAction != null) {
            int i3 = i >= 10 ? i - 9 : 0;
            if (fastForwardAction.getIndex() != i3) {
                this.f5450k.setIndex(i3);
                int indexOf = sparseArrayObjectAdapter.indexOf(this.f5450k);
                if (indexOf >= 0) {
                    sparseArrayObjectAdapter.notifyArrayItemRangeChanged(indexOf, 1);
                }
            }
        }
        PlaybackControlsRow.RewindAction rewindAction = this.f5451l;
        if (rewindAction != null) {
            int i4 = i <= -10 ? (-i) - 9 : 0;
            if (rewindAction.getIndex() != i4) {
                this.f5451l.setIndex(i4);
                int indexOf2 = sparseArrayObjectAdapter.indexOf(this.f5451l);
                if (indexOf2 >= 0) {
                    sparseArrayObjectAdapter.notifyArrayItemRangeChanged(indexOf2, 1);
                }
            }
        }
        if (i == 0) {
            updateProgress();
            enableProgressUpdating(false);
        } else {
            enableProgressUpdating(true);
        }
        if (this.f5453n && getHost() != null) {
            PlaybackGlueHost host = getHost();
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            host.setControlsOverlayAutoHideEnabled(z);
        }
        PlaybackControlsRow.PlayPauseAction playPauseAction = this.f5447h;
        if (playPauseAction != null) {
            if (i == 0) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (playPauseAction.getIndex() != i2) {
                this.f5447h.setIndex(i2);
                int indexOf3 = sparseArrayObjectAdapter.indexOf(this.f5447h);
                if (indexOf3 >= 0) {
                    sparseArrayObjectAdapter.notifyArrayItemRangeChanged(indexOf3, 1);
                }
            }
        }
        List<PlaybackGlue.PlayerCallback> playerCallbacks = getPlayerCallbacks();
        if (playerCallbacks != null) {
            int size = playerCallbacks.size();
            for (int i5 = 0; i5 < size; i5++) {
                playerCallbacks.get(i5).onPlayStateChanged(this);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public SparseArrayObjectAdapter createPrimaryActionsAdapter(PresenterSelector presenterSelector) {
        SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(presenterSelector);
        onCreatePrimaryActions(sparseArrayObjectAdapter);
        return sparseArrayObjectAdapter;
    }

    /* renamed from: d */
    public final void m1366d() {
        m1365c(this.f5452m);
        WeakReference weakReference = this.f5454o;
        qo1 qo1Var = f5442p;
        qo1Var.removeMessages(100, weakReference);
        qo1Var.sendMessageDelayed(qo1Var.obtainMessage(100, weakReference), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    /* renamed from: e */
    public final void m1367e() {
        if (this.f5445f == null) {
            return;
        }
        if (!hasValidMedia()) {
            this.f5445f.setImageDrawable(null);
            this.f5445f.setTotalTime(0);
            this.f5445f.setCurrentTime(0);
        } else {
            this.f5445f.setImageDrawable(getMediaArt());
            this.f5445f.setTotalTime(getMediaDuration());
            this.f5445f.setCurrentTime(getCurrentPosition());
        }
        if (getHost() != null) {
            getHost().notifyPlaybackRowChanged();
        }
    }

    public void enableProgressUpdating(boolean z) {
    }

    public PlaybackControlsRow getControlsRow() {
        return this.f5445f;
    }

    @Deprecated
    public PlaybackControlsRowPresenter getControlsRowPresenter() {
        PlaybackRowPresenter playbackRowPresenter = this.f5446g;
        if (playbackRowPresenter instanceof PlaybackControlsRowPresenter) {
            return (PlaybackControlsRowPresenter) playbackRowPresenter;
        }
        return null;
    }

    public abstract int getCurrentPosition();

    public abstract int getCurrentSpeedId();

    public int[] getFastForwardSpeeds() {
        return this.f5443d;
    }

    public abstract Drawable getMediaArt();

    public abstract int getMediaDuration();

    public abstract CharSequence getMediaSubtitle();

    public abstract CharSequence getMediaTitle();

    public PlaybackRowPresenter getPlaybackRowPresenter() {
        return this.f5446g;
    }

    public int[] getRewindSpeeds() {
        return this.f5444e;
    }

    public abstract long getSupportedActions();

    public int getUpdatePeriod() {
        return HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR;
    }

    public abstract boolean hasValidMedia();

    public boolean isFadingEnabled() {
        return this.f5453n;
    }

    public abstract boolean isMediaPlaying();

    @Override // androidx.leanback.media.PlaybackGlue
    public boolean isPlaying() {
        return isMediaPlaying();
    }

    public void onActionClicked(Action action) {
        m1363a(action, null);
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void onAttachedToHost(@NonNull PlaybackGlueHost playbackGlueHost) {
        super.onAttachedToHost(playbackGlueHost);
        playbackGlueHost.setOnKeyInterceptListener(this);
        playbackGlueHost.setOnActionClickedListener(this);
        if (getControlsRow() == null || getPlaybackRowPresenter() == null) {
            onCreateControlsRowAndPresenter();
        }
        playbackGlueHost.setPlaybackRowPresenter(getPlaybackRowPresenter());
        playbackGlueHost.setPlaybackRow(getControlsRow());
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.leanback.widget.AbstractDetailsDescriptionPresenter, y42] */
    public void onCreateControlsRowAndPresenter() {
        if (getControlsRow() == null) {
            setControlsRow(new PlaybackControlsRow(this));
        }
        if (getPlaybackRowPresenter() == null) {
            setPlaybackRowPresenter(new z42(this, new AbstractDetailsDescriptionPresenter()));
        }
    }

    public void onCreatePrimaryActions(SparseArrayObjectAdapter sparseArrayObjectAdapter) {
    }

    public void onCreateSecondaryActions(ArrayObjectAdapter arrayObjectAdapter) {
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void onDetachedFromHost() {
        enableProgressUpdating(false);
        super.onDetachedFromHost();
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void onHostStart() {
        enableProgressUpdating(true);
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void onHostStop() {
        enableProgressUpdating(false);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 4 && i != 111) {
            switch (i) {
                case 19:
                case 20:
                case 21:
                case 22:
                    break;
                default:
                    SparseArrayObjectAdapter sparseArrayObjectAdapter = (SparseArrayObjectAdapter) this.f5445f.getPrimaryActionsAdapter();
                    Action actionForKeyCode = this.f5445f.getActionForKeyCode(sparseArrayObjectAdapter, i);
                    if (actionForKeyCode == null || (actionForKeyCode != sparseArrayObjectAdapter.lookup(64) && actionForKeyCode != sparseArrayObjectAdapter.lookup(32) && actionForKeyCode != sparseArrayObjectAdapter.lookup(128) && actionForKeyCode != sparseArrayObjectAdapter.lookup(16) && actionForKeyCode != sparseArrayObjectAdapter.lookup(256))) {
                        return false;
                    }
                    if (keyEvent.getAction() == 0) {
                        m1363a(actionForKeyCode, keyEvent);
                    }
                    return true;
            }
        }
        int i2 = this.f5452m;
        if (i2 < 10 && i2 > -10) {
            return false;
        }
        this.f5452m = 1;
        play(1);
        m1366d();
        if (i != 4 && i != 111) {
            return false;
        }
        return true;
    }

    public void onMetadataChanged() {
        m1367e();
    }

    public void onStateChanged() {
        if (!hasValidMedia()) {
            return;
        }
        WeakReference weakReference = this.f5454o;
        qo1 qo1Var = f5442p;
        if (qo1Var.hasMessages(100, weakReference)) {
            qo1Var.removeMessages(100, weakReference);
            if (getCurrentSpeedId() != this.f5452m) {
                qo1Var.sendMessageDelayed(qo1Var.obtainMessage(100, weakReference), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                return;
            } else {
                m1364b();
                return;
            }
        }
        m1364b();
    }

    public void play(int i) {
    }

    public void setControlsRow(PlaybackControlsRow playbackControlsRow) {
        this.f5445f = playbackControlsRow;
        playbackControlsRow.setPrimaryActionsAdapter(createPrimaryActionsAdapter(new ControlButtonPresenterSelector()));
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new ControlButtonPresenterSelector());
        onCreateSecondaryActions(arrayObjectAdapter);
        getControlsRow().setSecondaryActionsAdapter(arrayObjectAdapter);
        m1367e();
        SparseArrayObjectAdapter sparseArrayObjectAdapter = (SparseArrayObjectAdapter) getControlsRow().getPrimaryActionsAdapter();
        long supportedActions = getSupportedActions();
        long j = 16 & supportedActions;
        if (j != 0 && this.f5449j == null) {
            PlaybackControlsRow.SkipPreviousAction skipPreviousAction = new PlaybackControlsRow.SkipPreviousAction(getContext());
            this.f5449j = skipPreviousAction;
            sparseArrayObjectAdapter.set(16, skipPreviousAction);
        } else if (j == 0 && this.f5449j != null) {
            sparseArrayObjectAdapter.clear(16);
            this.f5449j = null;
        }
        long j2 = 32 & supportedActions;
        if (j2 != 0 && this.f5451l == null) {
            PlaybackControlsRow.RewindAction rewindAction = new PlaybackControlsRow.RewindAction(getContext(), this.f5444e.length);
            this.f5451l = rewindAction;
            sparseArrayObjectAdapter.set(32, rewindAction);
        } else if (j2 == 0 && this.f5451l != null) {
            sparseArrayObjectAdapter.clear(32);
            this.f5451l = null;
        }
        long j3 = 64 & supportedActions;
        if (j3 != 0 && this.f5447h == null) {
            PlaybackControlsRow.PlayPauseAction playPauseAction = new PlaybackControlsRow.PlayPauseAction(getContext());
            this.f5447h = playPauseAction;
            sparseArrayObjectAdapter.set(64, playPauseAction);
        } else if (j3 == 0 && this.f5447h != null) {
            sparseArrayObjectAdapter.clear(64);
            this.f5447h = null;
        }
        long j4 = 128 & supportedActions;
        if (j4 != 0 && this.f5450k == null) {
            PlaybackControlsRow.FastForwardAction fastForwardAction = new PlaybackControlsRow.FastForwardAction(getContext(), this.f5443d.length);
            this.f5450k = fastForwardAction;
            sparseArrayObjectAdapter.set(128, fastForwardAction);
        } else if (j4 == 0 && this.f5450k != null) {
            sparseArrayObjectAdapter.clear(128);
            this.f5450k = null;
        }
        long j5 = supportedActions & 256;
        if (j5 != 0 && this.f5448i == null) {
            PlaybackControlsRow.SkipNextAction skipNextAction = new PlaybackControlsRow.SkipNextAction(getContext());
            this.f5448i = skipNextAction;
            sparseArrayObjectAdapter.set(256, skipNextAction);
        } else if (j5 == 0 && this.f5448i != null) {
            sparseArrayObjectAdapter.clear(256);
            this.f5448i = null;
        }
        f5442p.removeMessages(100, this.f5454o);
        m1364b();
    }

    @Deprecated
    public void setControlsRowPresenter(PlaybackControlsRowPresenter playbackControlsRowPresenter) {
        this.f5446g = playbackControlsRowPresenter;
    }

    public void setFadingEnabled(boolean z) {
        this.f5453n = z;
        if (!z && getHost() != null) {
            getHost().setControlsOverlayAutoHideEnabled(false);
        }
    }

    public void setPlaybackRowPresenter(PlaybackRowPresenter playbackRowPresenter) {
        this.f5446g = playbackRowPresenter;
    }

    public void updateProgress() {
        int currentPosition = getCurrentPosition();
        PlaybackControlsRow playbackControlsRow = this.f5445f;
        if (playbackControlsRow != null) {
            playbackControlsRow.setCurrentTime(currentPosition);
        }
    }

    public PlaybackControlGlue(Context context, int[] iArr, int[] iArr2) {
        super(context);
        this.f5452m = 1;
        this.f5453n = true;
        this.f5454o = new WeakReference(this);
        if (iArr.length != 0 && iArr.length <= 5) {
            this.f5443d = iArr;
            if (iArr2.length != 0 && iArr2.length <= 5) {
                this.f5444e = iArr2;
                return;
            }
            throw new IllegalStateException("invalid rewindSpeeds array size");
        }
        throw new IllegalStateException("invalid fastForwardSpeeds array size");
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public final void play() {
        play(1);
    }
}
