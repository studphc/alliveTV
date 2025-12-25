package p000;

import android.view.SurfaceHolder;
import androidx.leanback.app.VideoFragment;
import androidx.leanback.app.VideoSupportFragment;
import androidx.leanback.media.MediaPlayerAdapter;
import androidx.leanback.media.MediaPlayerGlue;

/* loaded from: classes.dex */
public final class yl1 implements SurfaceHolder.Callback {

    /* renamed from: a */
    public final /* synthetic */ int f29013a;

    /* renamed from: b */
    public final /* synthetic */ Object f29014b;

    public /* synthetic */ yl1(int i, Object obj) {
        this.f29013a = i;
        this.f29014b = obj;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        switch (this.f29013a) {
            case 0:
            case 1:
                return;
            case 2:
                SurfaceHolder.Callback callback = ((VideoFragment) this.f29014b).f5308W;
                if (callback != null) {
                    callback.surfaceChanged(surfaceHolder, i, i2, i3);
                    return;
                }
                return;
            default:
                SurfaceHolder.Callback callback2 = ((VideoSupportFragment) this.f29014b).f5312a1;
                if (callback2 != null) {
                    callback2.surfaceChanged(surfaceHolder, i, i2, i3);
                    return;
                }
                return;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        switch (this.f29013a) {
            case 0:
                ((MediaPlayerAdapter) this.f29014b).m1357b(surfaceHolder);
                return;
            case 1:
                ((MediaPlayerGlue) this.f29014b).setDisplay(surfaceHolder);
                return;
            case 2:
                VideoFragment videoFragment = (VideoFragment) this.f29014b;
                SurfaceHolder.Callback callback = videoFragment.f5308W;
                if (callback != null) {
                    callback.surfaceCreated(surfaceHolder);
                }
                videoFragment.f5309X = 1;
                return;
            default:
                VideoSupportFragment videoSupportFragment = (VideoSupportFragment) this.f29014b;
                SurfaceHolder.Callback callback2 = videoSupportFragment.f5312a1;
                if (callback2 != null) {
                    callback2.surfaceCreated(surfaceHolder);
                }
                videoSupportFragment.f5313b1 = 1;
                return;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        switch (this.f29013a) {
            case 0:
                ((MediaPlayerAdapter) this.f29014b).m1357b(null);
                return;
            case 1:
                ((MediaPlayerGlue) this.f29014b).setDisplay(null);
                return;
            case 2:
                VideoFragment videoFragment = (VideoFragment) this.f29014b;
                SurfaceHolder.Callback callback = videoFragment.f5308W;
                if (callback != null) {
                    callback.surfaceDestroyed(surfaceHolder);
                }
                videoFragment.f5309X = 0;
                return;
            default:
                VideoSupportFragment videoSupportFragment = (VideoSupportFragment) this.f29014b;
                SurfaceHolder.Callback callback2 = videoSupportFragment.f5312a1;
                if (callback2 != null) {
                    callback2.surfaceDestroyed(surfaceHolder);
                }
                videoSupportFragment.f5313b1 = 0;
                return;
        }
    }

    /* renamed from: a */
    private final void m8308a(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    /* renamed from: b */
    private final void m8309b(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }
}
