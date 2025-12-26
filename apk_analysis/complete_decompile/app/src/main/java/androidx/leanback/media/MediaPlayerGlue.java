package androidx.leanback.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import p000.RunnableC1104d;
import p000.am1;
import p000.bm1;
import p000.yl1;
import p000.zl1;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@Deprecated
/* loaded from: classes.dex */
public class MediaPlayerGlue extends PlaybackControlGlue implements OnItemViewSelectedListener {
    public static final int FAST_FORWARD_REWIND_REPEAT_DELAY = 200;
    public static final int FAST_FORWARD_REWIND_STEP = 10000;
    public static final int NO_REPEAT = 0;
    public static final int REPEAT_ALL = 2;
    public static final int REPEAT_ONE = 1;

    /* renamed from: A */
    public String f5402A;

    /* renamed from: B */
    public String f5403B;

    /* renamed from: C */
    public Drawable f5404C;
    protected final PlaybackControlsRow.ThumbsDownAction mThumbsDownAction;
    protected final PlaybackControlsRow.ThumbsUpAction mThumbsUpAction;

    /* renamed from: q */
    public final MediaPlayer f5405q;

    /* renamed from: r */
    public final PlaybackControlsRow.RepeatAction f5406r;

    /* renamed from: s */
    public RunnableC1104d f5407s;

    /* renamed from: t */
    public final Handler f5408t;

    /* renamed from: u */
    public boolean f5409u;

    /* renamed from: v */
    public Action f5410v;

    /* renamed from: w */
    public long f5411w;

    /* renamed from: x */
    public Uri f5412x;

    /* renamed from: y */
    public String f5413y;

    /* renamed from: z */
    public MediaPlayer.OnCompletionListener f5414z;

    public MediaPlayerGlue(Context context) {
        this(context, new int[]{1}, new int[]{1});
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public void enableProgressUpdating(boolean z) {
        RunnableC1104d runnableC1104d = this.f5407s;
        Handler handler = this.f5408t;
        if (runnableC1104d != null) {
            handler.removeCallbacks(runnableC1104d);
        }
        if (!z) {
            return;
        }
        if (this.f5407s == null) {
            this.f5407s = new RunnableC1104d(28, this);
        }
        handler.postDelayed(this.f5407s, getUpdatePeriod());
    }

    /* renamed from: f */
    public final void m1358f() {
        if (this.f5409u) {
            this.f5409u = false;
            List<PlaybackGlue.PlayerCallback> playerCallbacks = getPlayerCallbacks();
            if (playerCallbacks != null) {
                Iterator<PlaybackGlue.PlayerCallback> it = playerCallbacks.iterator();
                while (it.hasNext()) {
                    it.next().onPreparedStateChanged(this);
                }
            }
        }
    }

    /* renamed from: g */
    public final void m1359g() {
        reset();
        try {
            Uri uri = this.f5412x;
            MediaPlayer mediaPlayer = this.f5405q;
            if (uri != null) {
                mediaPlayer.setDataSource(getContext(), this.f5412x);
            } else {
                String str = this.f5413y;
                if (str != null) {
                    mediaPlayer.setDataSource(str);
                } else {
                    return;
                }
            }
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.setOnPreparedListener(new C0306i(this));
            MediaPlayer.OnCompletionListener onCompletionListener = this.f5414z;
            if (onCompletionListener != null) {
                mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
            mediaPlayer.setOnBufferingUpdateListener(new bm1(this));
            mediaPlayer.prepareAsync();
            onStateChanged();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getCurrentPosition() {
        if (this.f5409u) {
            return this.f5405q.getCurrentPosition();
        }
        return 0;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getCurrentSpeedId() {
        return isMediaPlaying() ? 1 : 0;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public Drawable getMediaArt() {
        return this.f5404C;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getMediaDuration() {
        if (this.f5409u) {
            return this.f5405q.getDuration();
        }
        return 0;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public CharSequence getMediaSubtitle() {
        String str = this.f5402A;
        if (str == null) {
            return "N/a";
        }
        return str;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public CharSequence getMediaTitle() {
        String str = this.f5403B;
        if (str == null) {
            return "N/a";
        }
        return str;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public long getSupportedActions() {
        return 224L;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public boolean hasValidMedia() {
        if (this.f5403B != null && (this.f5413y != null || this.f5412x != null)) {
            return true;
        }
        return false;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public boolean isMediaPlaying() {
        if (this.f5409u && this.f5405q.isPlaying()) {
            return true;
        }
        return false;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue, androidx.leanback.media.PlaybackGlue
    public boolean isPlaying() {
        return isMediaPlaying();
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public boolean isPrepared() {
        return this.f5409u;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue, androidx.leanback.widget.OnActionClickedListener
    public void onActionClicked(Action action) {
        super.onActionClicked(action);
        if (action instanceof PlaybackControlsRow.RepeatAction) {
            ((PlaybackControlsRow.RepeatAction) action).nextIndex();
        } else {
            PlaybackControlsRow.ThumbsUpAction thumbsUpAction = this.mThumbsUpAction;
            if (action == thumbsUpAction) {
                if (thumbsUpAction.getIndex() == 0) {
                    this.mThumbsUpAction.setIndex(1);
                } else {
                    this.mThumbsUpAction.setIndex(0);
                    this.mThumbsDownAction.setIndex(1);
                }
            } else {
                PlaybackControlsRow.ThumbsDownAction thumbsDownAction = this.mThumbsDownAction;
                if (action == thumbsDownAction) {
                    if (thumbsDownAction.getIndex() == 0) {
                        this.mThumbsDownAction.setIndex(1);
                    } else {
                        this.mThumbsDownAction.setIndex(0);
                        this.mThumbsUpAction.setIndex(1);
                    }
                }
            }
        }
        onMetadataChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.leanback.media.PlaybackControlGlue, androidx.leanback.media.PlaybackGlue
    public void onAttachedToHost(@NonNull PlaybackGlueHost playbackGlueHost) {
        super.onAttachedToHost(playbackGlueHost);
        if (playbackGlueHost instanceof SurfaceHolderGlueHost) {
            ((SurfaceHolderGlueHost) playbackGlueHost).setSurfaceHolderCallback(new yl1(1, this));
        }
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public void onCreateSecondaryActions(ArrayObjectAdapter arrayObjectAdapter) {
        arrayObjectAdapter.add(this.f5406r);
        arrayObjectAdapter.add(this.mThumbsDownAction);
        arrayObjectAdapter.add(this.mThumbsUpAction);
    }

    @Override // androidx.leanback.media.PlaybackControlGlue, androidx.leanback.media.PlaybackGlue
    public void onDetachedFromHost() {
        if (getHost() instanceof SurfaceHolderGlueHost) {
            ((SurfaceHolderGlueHost) getHost()).setSurfaceHolderCallback(null);
        }
        reset();
        release();
        super.onDetachedFromHost();
    }

    @Override // androidx.leanback.media.PlaybackControlGlue, android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        Action action = this.f5410v;
        if (((action instanceof PlaybackControlsRow.RewindAction) || (action instanceof PlaybackControlsRow.FastForwardAction)) && this.f5409u && keyEvent.getKeyCode() == 23 && keyEvent.getAction() == 0 && System.currentTimeMillis() - this.f5411w > 200) {
            this.f5411w = System.currentTimeMillis();
            int currentPosition = getCurrentPosition() + 10000;
            if (this.f5410v instanceof PlaybackControlsRow.RewindAction) {
                currentPosition = getCurrentPosition() - 10000;
            }
            if (currentPosition < 0) {
                currentPosition = 0;
            }
            if (currentPosition > getMediaDuration()) {
                currentPosition = getMediaDuration();
            }
            seekTo(currentPosition);
            return true;
        }
        return super.onKey(view, i, keyEvent);
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void pause() {
        if (isMediaPlaying()) {
            this.f5405q.pause();
            onStateChanged();
        }
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public void play(int i) {
        if (this.f5409u) {
            MediaPlayer mediaPlayer = this.f5405q;
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                onMetadataChanged();
                onStateChanged();
                updateProgress();
            }
        }
    }

    public void release() {
        m1358f();
        this.f5405q.release();
    }

    public void reset() {
        m1358f();
        this.f5405q.reset();
    }

    public void seekTo(int i) {
        if (!this.f5409u) {
            return;
        }
        this.f5405q.seekTo(i);
    }

    public void setArtist(String str) {
        this.f5402A = str;
    }

    public void setCover(Drawable drawable) {
        this.f5404C = drawable;
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.f5405q.setDisplay(surfaceHolder);
    }

    public boolean setMediaSource(Uri uri) {
        Uri uri2 = this.f5412x;
        if (uri2 != null) {
            if (uri2.equals(uri)) {
                return false;
            }
        } else if (uri == null) {
            return false;
        }
        this.f5412x = uri;
        this.f5413y = null;
        m1359g();
        return true;
    }

    public void setMode(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.f5414z = new am1(this);
                    return;
                }
                return;
            }
            this.f5414z = new zl1(this);
            return;
        }
        this.f5414z = null;
    }

    public void setTitle(String str) {
        this.f5403B = str;
    }

    public void setVideoUrl(String str) {
        setMediaSource(str);
        onMetadataChanged();
    }

    public MediaPlayerGlue(Context context, int[] iArr, int[] iArr2) {
        super(context, iArr, iArr2);
        this.f5405q = new MediaPlayer();
        this.f5408t = new Handler();
        this.f5409u = false;
        this.f5411w = 0L;
        this.f5412x = null;
        this.f5413y = null;
        this.f5406r = new PlaybackControlsRow.RepeatAction(getContext());
        PlaybackControlsRow.ThumbsDownAction thumbsDownAction = new PlaybackControlsRow.ThumbsDownAction(getContext());
        this.mThumbsDownAction = thumbsDownAction;
        PlaybackControlsRow.ThumbsUpAction thumbsUpAction = new PlaybackControlsRow.ThumbsUpAction(getContext());
        this.mThumbsUpAction = thumbsUpAction;
        thumbsDownAction.setIndex(1);
        thumbsUpAction.setIndex(1);
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof Action) {
            this.f5410v = (Action) obj;
        } else {
            this.f5410v = null;
        }
    }

    public boolean setMediaSource(String str) {
        String str2 = this.f5413y;
        if (str2 != null) {
            if (str2.equals(str)) {
                return false;
            }
        } else if (str == null) {
            return false;
        }
        this.f5412x = null;
        this.f5413y = str;
        m1359g();
        return true;
    }
}
