package androidx.leanback.app;

import android.view.SurfaceHolder;
import androidx.leanback.media.SurfaceHolderGlueHost;

@Deprecated
/* loaded from: classes.dex */
public class VideoFragmentGlueHost extends PlaybackFragmentGlueHost implements SurfaceHolderGlueHost {

    /* renamed from: d */
    public final VideoFragment f5310d;

    public VideoFragmentGlueHost(VideoFragment videoFragment) {
        super(videoFragment);
        this.f5310d = videoFragment;
    }

    @Override // androidx.leanback.media.SurfaceHolderGlueHost
    public void setSurfaceHolderCallback(SurfaceHolder.Callback callback) {
        this.f5310d.setSurfaceHolderCallback(callback);
    }
}
