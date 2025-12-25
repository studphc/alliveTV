package androidx.leanback.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.leanback.R;
import p000.ou0;
import p000.yl1;

@Deprecated
/* loaded from: classes.dex */
public class VideoFragment extends PlaybackFragment {

    /* renamed from: V */
    public SurfaceView f5307V;

    /* renamed from: W */
    public SurfaceHolder.Callback f5308W;

    /* renamed from: X */
    public int f5309X = 0;

    public SurfaceView getSurfaceView() {
        return this.f5307V;
    }

    @Override // androidx.leanback.app.PlaybackFragment, android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) super.onCreateView(layoutInflater, viewGroup, bundle);
        SurfaceView surfaceView = (SurfaceView) LayoutInflater.from(ou0.m6729a(this)).inflate(R.layout.lb_video_surface, viewGroup2, false);
        this.f5307V = surfaceView;
        viewGroup2.addView(surfaceView, 0);
        this.f5307V.getHolder().addCallback(new yl1(2, this));
        setBackgroundType(2);
        return viewGroup2;
    }

    @Override // androidx.leanback.app.PlaybackFragment, android.app.Fragment
    public void onDestroyView() {
        this.f5307V = null;
        this.f5309X = 0;
        super.onDestroyView();
    }

    @Override // androidx.leanback.app.PlaybackFragment
    public void onVideoSizeChanged(int i, int i2) {
        int width = getView().getWidth();
        int height = getView().getHeight();
        ViewGroup.LayoutParams layoutParams = this.f5307V.getLayoutParams();
        int i3 = width * i2;
        int i4 = i * height;
        if (i3 > i4) {
            layoutParams.height = height;
            layoutParams.width = i4 / i2;
        } else {
            layoutParams.width = width;
            layoutParams.height = i3 / i;
        }
        this.f5307V.setLayoutParams(layoutParams);
    }

    public void setSurfaceHolderCallback(SurfaceHolder.Callback callback) {
        this.f5308W = callback;
        if (callback != null && this.f5309X == 1) {
            callback.surfaceCreated(this.f5307V.getHolder());
        }
    }
}
