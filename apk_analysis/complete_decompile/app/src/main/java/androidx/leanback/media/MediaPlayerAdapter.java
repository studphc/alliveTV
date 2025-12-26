package androidx.leanback.media;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.leanback.media.PlayerAdapter;
import java.io.IOException;
import p000.wl1;
import p000.xl1;
import p000.yl1;

/* loaded from: classes.dex */
public class MediaPlayerAdapter extends PlayerAdapter {

    /* renamed from: b */
    public final Context f5385b;

    /* renamed from: d */
    public SurfaceHolderGlueHost f5387d;

    /* renamed from: i */
    public boolean f5392i;

    /* renamed from: j */
    public long f5393j;

    /* renamed from: r */
    public boolean f5401r;

    /* renamed from: c */
    public final MediaPlayer f5386c = new MediaPlayer();

    /* renamed from: e */
    public final RunnableC0300c f5388e = new RunnableC0300c(this);

    /* renamed from: f */
    public final Handler f5389f = new Handler();

    /* renamed from: g */
    public boolean f5390g = false;

    /* renamed from: h */
    public Uri f5391h = null;

    /* renamed from: k */
    public final C0301d f5394k = new C0301d(this);

    /* renamed from: l */
    public final C0302e f5395l = new C0302e(this);

    /* renamed from: m */
    public final C0303f f5396m = new C0303f(this);

    /* renamed from: n */
    public final C0304g f5397n = new C0304g(this);

    /* renamed from: o */
    public final C0305h f5398o = new C0305h(this);

    /* renamed from: p */
    public final wl1 f5399p = new wl1(this);

    /* renamed from: q */
    public final xl1 f5400q = new xl1(this);

    public MediaPlayerAdapter(Context context) {
        this.f5385b = context;
    }

    /* renamed from: a */
    public final void m1356a() {
        boolean z;
        PlayerAdapter.Callback callback = getCallback();
        if (!this.f5401r && this.f5390g) {
            z = false;
        } else {
            z = true;
        }
        callback.onBufferingStateChanged(this, z);
    }

    /* renamed from: b */
    public final void m1357b(SurfaceHolder surfaceHolder) {
        boolean z;
        boolean z2 = this.f5392i;
        if (surfaceHolder != null) {
            z = true;
        } else {
            z = false;
        }
        this.f5392i = z;
        if (z2 == z) {
            return;
        }
        this.f5386c.setDisplay(surfaceHolder);
        if (this.f5392i) {
            if (this.f5390g) {
                getCallback().onPreparedStateChanged(this);
            }
        } else if (this.f5390g) {
            getCallback().onPreparedStateChanged(this);
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getBufferedPosition() {
        return this.f5393j;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getCurrentPosition() {
        if (this.f5390g) {
            return this.f5386c.getCurrentPosition();
        }
        return -1L;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getDuration() {
        if (this.f5390g) {
            return this.f5386c.getDuration();
        }
        return -1L;
    }

    public final MediaPlayer getMediaPlayer() {
        return this.f5386c;
    }

    public int getProgressUpdatingInterval() {
        return 16;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public boolean isPlaying() {
        if (this.f5390g && this.f5386c.isPlaying()) {
            return true;
        }
        return false;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public boolean isPrepared() {
        if (this.f5390g && (this.f5387d == null || this.f5392i)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.leanback.media.PlayerAdapter
    public void onAttachedToHost(@NonNull PlaybackGlueHost playbackGlueHost) {
        if (playbackGlueHost instanceof SurfaceHolderGlueHost) {
            SurfaceHolderGlueHost surfaceHolderGlueHost = (SurfaceHolderGlueHost) playbackGlueHost;
            this.f5387d = surfaceHolderGlueHost;
            surfaceHolderGlueHost.setSurfaceHolderCallback(new yl1(0, this));
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void onDetachedFromHost() {
        SurfaceHolderGlueHost surfaceHolderGlueHost = this.f5387d;
        if (surfaceHolderGlueHost != null) {
            surfaceHolderGlueHost.setSurfaceHolderCallback(null);
            this.f5387d = null;
        }
        reset();
        release();
    }

    public boolean onError(int i, int i2) {
        return false;
    }

    public boolean onInfo(int i, int i2) {
        return false;
    }

    public void onSeekComplete() {
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void pause() {
        if (isPlaying()) {
            this.f5386c.pause();
            getCallback().onPlayStateChanged(this);
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void play() {
        if (this.f5390g) {
            MediaPlayer mediaPlayer = this.f5386c;
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                getCallback().onPlayStateChanged(this);
                getCallback().onCurrentPositionChanged(this);
            }
        }
    }

    public void release() {
        if (this.f5390g) {
            this.f5390g = false;
            m1356a();
            if (this.f5392i) {
                getCallback().onPreparedStateChanged(this);
            }
        }
        this.f5392i = false;
        this.f5386c.release();
    }

    public void reset() {
        if (this.f5390g) {
            this.f5390g = false;
            m1356a();
            if (this.f5392i) {
                getCallback().onPreparedStateChanged(this);
            }
        }
        this.f5386c.reset();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void seekTo(long j) {
        if (!this.f5390g) {
            return;
        }
        this.f5386c.seekTo((int) j);
    }

    public boolean setDataSource(Uri uri) {
        Uri uri2 = this.f5391h;
        if (uri2 != null) {
            if (uri2.equals(uri)) {
                return false;
            }
        } else if (uri == null) {
            return false;
        }
        this.f5391h = uri;
        reset();
        try {
            Uri uri3 = this.f5391h;
            if (uri3 != null) {
                MediaPlayer mediaPlayer = this.f5386c;
                mediaPlayer.setDataSource(this.f5385b, uri3);
                mediaPlayer.setAudioStreamType(3);
                mediaPlayer.setOnPreparedListener(this.f5394k);
                mediaPlayer.setOnVideoSizeChangedListener(this.f5397n);
                mediaPlayer.setOnErrorListener(this.f5398o);
                mediaPlayer.setOnSeekCompleteListener(this.f5399p);
                mediaPlayer.setOnCompletionListener(this.f5395l);
                mediaPlayer.setOnInfoListener(this.f5400q);
                mediaPlayer.setOnBufferingUpdateListener(this.f5396m);
                m1356a();
                mediaPlayer.prepareAsync();
                getCallback().onPlayStateChanged(this);
                return true;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setProgressUpdatingEnabled(boolean z) {
        Handler handler = this.f5389f;
        RunnableC0300c runnableC0300c = this.f5388e;
        handler.removeCallbacks(runnableC0300c);
        if (!z) {
            return;
        }
        handler.postDelayed(runnableC0300c, getProgressUpdatingInterval());
    }
}
