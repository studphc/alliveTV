package androidx.leanback.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.R;
import p000.yl1;

/* loaded from: classes.dex */
public class VideoSupportFragment extends PlaybackSupportFragment {

    /* renamed from: Z0 */
    public SurfaceView f5311Z0;

    /* renamed from: a1 */
    public SurfaceHolder.Callback f5312a1;

    /* renamed from: b1 */
    public int f5313b1 = 0;

    public SurfaceView getSurfaceView() {
        return this.f5311Z0;
    }

    @Override // androidx.leanback.app.PlaybackSupportFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) super.onCreateView(layoutInflater, viewGroup, bundle);
        SurfaceView surfaceView = (SurfaceView) LayoutInflater.from(getContext()).inflate(R.layout.lb_video_surface, viewGroup2, false);
        this.f5311Z0 = surfaceView;
        viewGroup2.addView(surfaceView, 0);
        this.f5311Z0.getHolder().addCallback(new yl1(3, this));
        setBackgroundType(2);
        return viewGroup2;
    }

    @Override // androidx.leanback.app.PlaybackSupportFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f5311Z0 = null;
        this.f5313b1 = 0;
        super.onDestroyView();
    }

    @Override // androidx.leanback.app.PlaybackSupportFragment
    public void onVideoSizeChanged(int i, int i2) {
        int width = getView().getWidth();
        int height = getView().getHeight();
        ViewGroup.LayoutParams layoutParams = this.f5311Z0.getLayoutParams();
        int i3 = width * i2;
        int i4 = i * height;
        if (i3 > i4) {
            layoutParams.height = height;
            layoutParams.width = i4 / i2;
        } else {
            layoutParams.width = width;
            layoutParams.height = i3 / i;
        }
        this.f5311Z0.setLayoutParams(layoutParams);
    }

    public void setSurfaceHolderCallback(SurfaceHolder.Callback callback) {
        this.f5312a1 = callback;
        if (callback != null && this.f5313b1 == 1) {
            callback.surfaceCreated(this.f5311Z0.getHolder());
        }
    }
}
