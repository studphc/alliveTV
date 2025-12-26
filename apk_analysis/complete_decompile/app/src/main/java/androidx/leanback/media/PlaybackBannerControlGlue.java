package androidx.leanback.media;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.leanback.media.PlayerAdapter;
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackRowPresenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p000.x42;

/* loaded from: classes.dex */
public class PlaybackBannerControlGlue<T extends PlayerAdapter> extends PlaybackBaseControlGlue<T> {
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

    /* renamed from: A */
    public long f5415A;

    /* renamed from: B */
    public long f5416B;

    /* renamed from: C */
    public final boolean f5417C;

    /* renamed from: D */
    public final boolean f5418D;

    /* renamed from: t */
    public final int[] f5419t;

    /* renamed from: u */
    public final int[] f5420u;

    /* renamed from: v */
    public PlaybackControlsRow.SkipNextAction f5421v;

    /* renamed from: w */
    public PlaybackControlsRow.SkipPreviousAction f5422w;

    /* renamed from: x */
    public PlaybackControlsRow.FastForwardAction f5423x;

    /* renamed from: y */
    public PlaybackControlsRow.RewindAction f5424y;

    /* renamed from: z */
    public int f5425z;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ACTION_ {
    }

    public PlaybackBannerControlGlue(@NonNull Context context, @NonNull int[] iArr, T t) {
        this(context, iArr, iArr, t);
    }

    /* renamed from: a */
    public final void m1360a(Action action, KeyEvent keyEvent) {
        boolean z;
        if (action == this.f5429g) {
            if (keyEvent != null && keyEvent.getKeyCode() != 85 && keyEvent.getKeyCode() != 126) {
                z = false;
            } else {
                z = true;
            }
            if (keyEvent == null || keyEvent.getKeyCode() == 85 || keyEvent.getKeyCode() == 127) {
                int i = this.f5425z;
                if (!z ? i != 0 : i == 1) {
                    pause();
                    m1362c(this.f5430h);
                    return;
                }
            }
            if (z && this.f5425z != 1) {
                play();
            }
            m1362c(this.f5430h);
            return;
        }
        if (action == this.f5421v) {
            next();
            return;
        }
        if (action == this.f5422w) {
            previous();
            return;
        }
        PlaybackControlsRow.FastForwardAction fastForwardAction = this.f5423x;
        boolean z2 = this.f5417C;
        PlayerAdapter playerAdapter = this.f5426d;
        if (action == fastForwardAction) {
            if (playerAdapter.isPrepared() && this.f5425z < this.f5419t.length + 9) {
                if (z2) {
                    this.f5430h = true;
                    playerAdapter.fastForward();
                } else {
                    this.f5430h = true;
                    this.f5416B = getCurrentPosition();
                    this.f5415A = System.currentTimeMillis();
                    super.pause();
                    m1361b();
                }
                int i2 = this.f5425z;
                switch (i2) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        this.f5425z = i2 + 1;
                        break;
                    default:
                        this.f5425z = 10;
                        break;
                }
                m1362c(this.f5430h);
                return;
            }
            return;
        }
        if (action == this.f5424y && playerAdapter.isPrepared() && this.f5425z > (-(this.f5420u.length + 9))) {
            if (z2) {
                this.f5430h = true;
                playerAdapter.rewind();
            } else {
                this.f5430h = true;
                this.f5416B = getCurrentPosition();
                this.f5415A = System.currentTimeMillis();
                super.pause();
                m1361b();
            }
            int i3 = this.f5425z;
            switch (i3) {
                case -13:
                case -12:
                case -11:
                case -10:
                    this.f5425z = i3 - 1;
                    break;
                default:
                    this.f5425z = -10;
                    break;
            }
            m1362c(this.f5430h);
        }
    }

    /* renamed from: b */
    public final void m1361b() {
        m1362c(this.f5430h);
    }

    /* renamed from: c */
    public final void m1362c(boolean z) {
        int i;
        if (this.f5427e == null) {
            return;
        }
        PlayerAdapter playerAdapter = this.f5426d;
        int i2 = 0;
        if (!z) {
            onUpdateProgress();
            playerAdapter.setProgressUpdatingEnabled(false);
        } else {
            playerAdapter.setProgressUpdatingEnabled(true);
        }
        if (this.f5431i && getHost() != null) {
            getHost().setControlsOverlayAutoHideEnabled(z);
        }
        ArrayObjectAdapter arrayObjectAdapter = (ArrayObjectAdapter) getControlsRow().getPrimaryActionsAdapter();
        PlaybackControlsRow.PlayPauseAction playPauseAction = this.f5429g;
        if (playPauseAction != null && playPauseAction.getIndex() != z) {
            this.f5429g.setIndex(z ? 1 : 0);
            PlaybackBaseControlGlue.notifyItemChanged(arrayObjectAdapter, this.f5429g);
        }
        PlaybackControlsRow.FastForwardAction fastForwardAction = this.f5423x;
        if (fastForwardAction != null) {
            int i3 = this.f5425z;
            if (i3 >= 10) {
                i = i3 - 9;
            } else {
                i = 0;
            }
            if (fastForwardAction.getIndex() != i) {
                this.f5423x.setIndex(i);
                PlaybackBaseControlGlue.notifyItemChanged(arrayObjectAdapter, this.f5423x);
            }
        }
        PlaybackControlsRow.RewindAction rewindAction = this.f5424y;
        if (rewindAction != null) {
            int i4 = this.f5425z;
            if (i4 <= -10) {
                i2 = (-i4) - 9;
            }
            if (rewindAction.getIndex() != i2) {
                this.f5424y.setIndex(i2);
                PlaybackBaseControlGlue.notifyItemChanged(arrayObjectAdapter, this.f5424y);
            }
        }
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public long getCurrentPosition() {
        int i;
        int i2 = this.f5425z;
        PlayerAdapter playerAdapter = this.f5426d;
        if (i2 != 0 && i2 != 1) {
            if (i2 >= 10) {
                if (this.f5417C) {
                    return playerAdapter.getCurrentPosition();
                }
                i = getFastForwardSpeeds()[i2 - 10];
            } else if (i2 <= -10) {
                if (this.f5418D) {
                    return playerAdapter.getCurrentPosition();
                }
                i = -getRewindSpeeds()[(-i2) - 10];
            } else {
                return -1L;
            }
            long currentTimeMillis = ((System.currentTimeMillis() - this.f5415A) * i) + this.f5416B;
            if (currentTimeMillis > getDuration()) {
                this.f5425z = 0;
                long duration = getDuration();
                playerAdapter.seekTo(duration);
                this.f5416B = 0L;
                pause();
                return duration;
            }
            if (currentTimeMillis < 0) {
                this.f5425z = 0;
                playerAdapter.seekTo(0L);
                this.f5416B = 0L;
                pause();
                return 0L;
            }
            return currentTimeMillis;
        }
        return playerAdapter.getCurrentPosition();
    }

    @NonNull
    public int[] getFastForwardSpeeds() {
        return this.f5419t;
    }

    @NonNull
    public int[] getRewindSpeeds() {
        return this.f5420u;
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue, androidx.leanback.widget.OnActionClickedListener
    public void onActionClicked(@NonNull Action action) {
        m1360a(action, null);
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void onCreatePrimaryActions(@NonNull ArrayObjectAdapter arrayObjectAdapter) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        long supportedActions = getSupportedActions();
        long j = 16 & supportedActions;
        if (j != 0 && this.f5422w == null) {
            PlaybackControlsRow.SkipPreviousAction skipPreviousAction = new PlaybackControlsRow.SkipPreviousAction(getContext());
            this.f5422w = skipPreviousAction;
            arrayObjectAdapter.add(skipPreviousAction);
        } else if (j == 0 && (obj = this.f5422w) != null) {
            arrayObjectAdapter.remove(obj);
            this.f5422w = null;
        }
        long j2 = 32 & supportedActions;
        if (j2 != 0 && this.f5424y == null) {
            PlaybackControlsRow.RewindAction rewindAction = new PlaybackControlsRow.RewindAction(getContext(), this.f5420u.length);
            this.f5424y = rewindAction;
            arrayObjectAdapter.add(rewindAction);
        } else if (j2 == 0 && (obj2 = this.f5424y) != null) {
            arrayObjectAdapter.remove(obj2);
            this.f5424y = null;
        }
        long j3 = 64 & supportedActions;
        if (j3 != 0 && this.f5429g == null) {
            this.f5429g = new PlaybackControlsRow.PlayPauseAction(getContext());
            PlaybackControlsRow.PlayPauseAction playPauseAction = new PlaybackControlsRow.PlayPauseAction(getContext());
            this.f5429g = playPauseAction;
            arrayObjectAdapter.add(playPauseAction);
        } else if (j3 == 0 && (obj3 = this.f5429g) != null) {
            arrayObjectAdapter.remove(obj3);
            this.f5429g = null;
        }
        long j4 = 128 & supportedActions;
        if (j4 != 0 && this.f5423x == null) {
            Context context = getContext();
            int[] iArr = this.f5419t;
            this.f5423x = new PlaybackControlsRow.FastForwardAction(context, iArr.length);
            PlaybackControlsRow.FastForwardAction fastForwardAction = new PlaybackControlsRow.FastForwardAction(getContext(), iArr.length);
            this.f5423x = fastForwardAction;
            arrayObjectAdapter.add(fastForwardAction);
        } else if (j4 == 0 && (obj4 = this.f5423x) != null) {
            arrayObjectAdapter.remove(obj4);
            this.f5423x = null;
        }
        long j5 = supportedActions & 256;
        if (j5 != 0 && this.f5421v == null) {
            PlaybackControlsRow.SkipNextAction skipNextAction = new PlaybackControlsRow.SkipNextAction(getContext());
            this.f5421v = skipNextAction;
            arrayObjectAdapter.add(skipNextAction);
        } else if (j5 == 0 && (obj5 = this.f5421v) != null) {
            arrayObjectAdapter.remove(obj5);
            this.f5421v = null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.leanback.widget.AbstractDetailsDescriptionPresenter, w42] */
    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    @NonNull
    public PlaybackRowPresenter onCreateRowPresenter() {
        return new x42(this, new AbstractDetailsDescriptionPresenter());
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue, android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 4 && i != 111) {
            switch (i) {
                case 19:
                case 20:
                case 21:
                case 22:
                    break;
                default:
                    Action actionForKeyCode = this.f5427e.getActionForKeyCode(this.f5427e.getPrimaryActionsAdapter(), i);
                    if (actionForKeyCode == null) {
                        PlaybackControlsRow playbackControlsRow = this.f5427e;
                        actionForKeyCode = playbackControlsRow.getActionForKeyCode(playbackControlsRow.getSecondaryActionsAdapter(), i);
                    }
                    if (actionForKeyCode == null) {
                        return false;
                    }
                    if (keyEvent.getAction() == 0) {
                        m1360a(actionForKeyCode, keyEvent);
                    }
                    return true;
            }
        }
        int i2 = this.f5425z;
        if (i2 < 10 && i2 > -10) {
            return false;
        }
        play();
        m1362c(this.f5430h);
        if (i == 4 || i == 111) {
            return true;
        }
        return false;
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void onPlayCompleted() {
        super.onPlayCompleted();
        this.f5430h = false;
        this.f5425z = 0;
        this.f5416B = getCurrentPosition();
        this.f5415A = System.currentTimeMillis();
        m1361b();
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void onPlayStateChanged() {
        m1361b();
        super.onPlayStateChanged();
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue, androidx.leanback.media.PlaybackGlue
    public void pause() {
        this.f5430h = false;
        this.f5425z = 0;
        this.f5416B = getCurrentPosition();
        this.f5415A = System.currentTimeMillis();
        super.pause();
        m1361b();
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue, androidx.leanback.media.PlaybackGlue
    public void play() {
        PlayerAdapter playerAdapter = this.f5426d;
        if (!playerAdapter.isPrepared()) {
            return;
        }
        if (this.f5425z == 0 && playerAdapter.getCurrentPosition() >= playerAdapter.getDuration()) {
            this.f5416B = 0L;
        } else {
            this.f5416B = getCurrentPosition();
        }
        this.f5415A = System.currentTimeMillis();
        this.f5430h = true;
        this.f5425z = 1;
        playerAdapter.seekTo(this.f5416B);
        super.play();
        m1361b();
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void setControlsRow(@NonNull PlaybackControlsRow playbackControlsRow) {
        super.setControlsRow(playbackControlsRow);
        m1361b();
    }

    public PlaybackBannerControlGlue(@NonNull Context context, @NonNull int[] iArr, @NonNull int[] iArr2, T t) {
        super(context, t);
        this.f5425z = 0;
        this.f5416B = 0L;
        if (iArr.length != 0 && iArr.length <= 5) {
            this.f5419t = iArr;
            if (iArr2.length != 0 && iArr2.length <= 5) {
                this.f5420u = iArr2;
                if ((this.f5426d.getSupportedActions() & 128) != 0) {
                    this.f5417C = true;
                }
                if ((this.f5426d.getSupportedActions() & 32) != 0) {
                    this.f5418D = true;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("invalid rewindSpeeds array size");
        }
        throw new IllegalArgumentException("invalid fastForwardSpeeds array size");
    }
}
