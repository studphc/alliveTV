package androidx.leanback.app;

import android.view.SurfaceHolder;
import androidx.leanback.media.SurfaceHolderGlueHost;

/* loaded from: classes.dex */
public class VideoSupportFragmentGlueHost extends PlaybackSupportFragmentGlueHost implements SurfaceHolderGlueHost {

    /* renamed from: d */
    public final VideoSupportFragment f5314d;

    public VideoSupportFragmentGlueHost(VideoSupportFragment videoSupportFragment) {
        super(videoSupportFragment);
        this.f5314d = videoSupportFragment;
    }

    @Override // androidx.leanback.media.SurfaceHolderGlueHost
    public void setSurfaceHolderCallback(SurfaceHolder.Callback callback) {
        this.f5314d.setSurfaceHolderCallback(callback);
    }
}
