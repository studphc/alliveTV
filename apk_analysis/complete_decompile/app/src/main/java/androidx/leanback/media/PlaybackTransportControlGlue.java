package androidx.leanback.media;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.leanback.media.PlayerAdapter;
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.PlaybackSeekDataProvider;
import androidx.leanback.widget.PlaybackSeekUi;
import com.google.android.exoplayer2.ExoPlayer;
import java.lang.ref.WeakReference;
import p000.a62;
import p000.qo1;
import p000.z52;

/* loaded from: classes.dex */
public class PlaybackTransportControlGlue<T extends PlayerAdapter> extends PlaybackBaseControlGlue<T> {

    /* renamed from: x */
    public static final qo1 f5459x = new qo1(2);

    /* renamed from: t */
    public PlaybackSeekDataProvider f5460t;

    /* renamed from: u */
    public boolean f5461u;

    /* renamed from: v */
    public final WeakReference f5462v;

    /* renamed from: w */
    public final a62 f5463w;

    public PlaybackTransportControlGlue(Context context, T t) {
        super(context, t);
        this.f5462v = new WeakReference(this);
        this.f5463w = new a62(this);
    }

    /* renamed from: a */
    public final void m1368a(Action action, KeyEvent keyEvent) {
        boolean z;
        if (action instanceof PlaybackControlsRow.PlayPauseAction) {
            if (keyEvent != null && keyEvent.getKeyCode() != 85 && keyEvent.getKeyCode() != 126) {
                z = false;
            } else {
                z = true;
            }
            if ((keyEvent == null || keyEvent.getKeyCode() == 85 || keyEvent.getKeyCode() == 127) && this.f5430h) {
                this.f5430h = false;
                pause();
            } else if (z && !this.f5430h) {
                this.f5430h = true;
                play();
            }
            m1369b(this.f5430h);
            WeakReference weakReference = this.f5462v;
            qo1 qo1Var = f5459x;
            qo1Var.removeMessages(100, weakReference);
            qo1Var.sendMessageDelayed(qo1Var.obtainMessage(100, weakReference), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            return;
        }
        if (action instanceof PlaybackControlsRow.SkipNextAction) {
            next();
        } else if (action instanceof PlaybackControlsRow.SkipPreviousAction) {
            previous();
        }
    }

    /* renamed from: b */
    public final void m1369b(boolean z) {
        if (this.f5427e == null) {
            return;
        }
        PlayerAdapter playerAdapter = this.f5426d;
        if (!z) {
            onUpdateProgress();
            playerAdapter.setProgressUpdatingEnabled(this.f5463w.f59d);
        } else {
            playerAdapter.setProgressUpdatingEnabled(true);
        }
        if (this.f5431i && getHost() != null) {
            getHost().setControlsOverlayAutoHideEnabled(z);
        }
        PlaybackControlsRow.PlayPauseAction playPauseAction = this.f5429g;
        if (playPauseAction != null && playPauseAction.getIndex() != z) {
            this.f5429g.setIndex(z ? 1 : 0);
            PlaybackBaseControlGlue.notifyItemChanged((ArrayObjectAdapter) getControlsRow().getPrimaryActionsAdapter(), this.f5429g);
        }
    }

    public final PlaybackSeekDataProvider getSeekProvider() {
        return this.f5460t;
    }

    public final boolean isSeekEnabled() {
        return this.f5461u;
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue, androidx.leanback.widget.OnActionClickedListener
    public void onActionClicked(@NonNull Action action) {
        m1368a(action, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.leanback.media.PlaybackBaseControlGlue, androidx.leanback.media.PlaybackGlue
    public void onAttachedToHost(@NonNull PlaybackGlueHost playbackGlueHost) {
        super.onAttachedToHost(playbackGlueHost);
        if (playbackGlueHost instanceof PlaybackSeekUi) {
            ((PlaybackSeekUi) playbackGlueHost).setPlaybackSeekUiClient(this.f5463w);
        }
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void onCreatePrimaryActions(@NonNull ArrayObjectAdapter arrayObjectAdapter) {
        PlaybackControlsRow.PlayPauseAction playPauseAction = new PlaybackControlsRow.PlayPauseAction(getContext());
        this.f5429g = playPauseAction;
        arrayObjectAdapter.add(playPauseAction);
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    @NonNull
    public PlaybackRowPresenter onCreateRowPresenter() {
        AbstractDetailsDescriptionPresenter abstractDetailsDescriptionPresenter = new AbstractDetailsDescriptionPresenter();
        z52 z52Var = new z52(this);
        z52Var.setDescriptionPresenter(abstractDetailsDescriptionPresenter);
        return z52Var;
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue, androidx.leanback.media.PlaybackGlue
    public void onDetachedFromHost() {
        super.onDetachedFromHost();
        if (getHost() instanceof PlaybackSeekUi) {
            ((PlaybackSeekUi) getHost()).setPlaybackSeekUiClient(null);
        }
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue, android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 4 && i != 111) {
            switch (i) {
                default:
                    Action actionForKeyCode = this.f5427e.getActionForKeyCode(this.f5427e.getPrimaryActionsAdapter(), i);
                    if (actionForKeyCode == null) {
                        PlaybackControlsRow playbackControlsRow = this.f5427e;
                        actionForKeyCode = playbackControlsRow.getActionForKeyCode(playbackControlsRow.getSecondaryActionsAdapter(), i);
                    }
                    if (actionForKeyCode != null) {
                        if (keyEvent.getAction() == 0) {
                            m1368a(actionForKeyCode, keyEvent);
                            return true;
                        }
                        return true;
                    }
                case 19:
                case 20:
                case 21:
                case 22:
                    return false;
            }
        }
        return false;
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void onPlayStateChanged() {
        WeakReference weakReference = this.f5462v;
        qo1 qo1Var = f5459x;
        boolean hasMessages = qo1Var.hasMessages(100, weakReference);
        PlayerAdapter playerAdapter = this.f5426d;
        if (hasMessages) {
            qo1Var.removeMessages(100, weakReference);
            if (playerAdapter.isPlaying() != this.f5430h) {
                qo1Var.sendMessageDelayed(qo1Var.obtainMessage(100, weakReference), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            } else {
                boolean isPlaying = playerAdapter.isPlaying();
                this.f5430h = isPlaying;
                m1369b(isPlaying);
            }
        } else {
            boolean isPlaying2 = playerAdapter.isPlaying();
            this.f5430h = isPlaying2;
            m1369b(isPlaying2);
        }
        super.onPlayStateChanged();
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void onUpdateProgress() {
        if (!this.f5463w.f59d) {
            super.onUpdateProgress();
        }
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void setControlsRow(@NonNull PlaybackControlsRow playbackControlsRow) {
        super.setControlsRow(playbackControlsRow);
        f5459x.removeMessages(100, this.f5462v);
        boolean isPlaying = this.f5426d.isPlaying();
        this.f5430h = isPlaying;
        m1369b(isPlaying);
    }

    public final void setSeekEnabled(boolean z) {
        this.f5461u = z;
    }

    public final void setSeekProvider(PlaybackSeekDataProvider playbackSeekDataProvider) {
        this.f5460t = playbackSeekDataProvider;
    }
}
