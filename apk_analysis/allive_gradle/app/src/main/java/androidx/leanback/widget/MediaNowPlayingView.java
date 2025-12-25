package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import com.google.android.exoplayer2.ExoPlayer;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MediaNowPlayingView extends LinearLayout {

    /* renamed from: a */
    public final ImageView f5912a;

    /* renamed from: b */
    public final ImageView f5913b;

    /* renamed from: c */
    public final ImageView f5914c;

    /* renamed from: d */
    public final ObjectAnimator f5915d;

    /* renamed from: e */
    public final ObjectAnimator f5916e;

    /* renamed from: f */
    public final ObjectAnimator f5917f;
    protected final LinearInterpolator mLinearInterpolator;

    public MediaNowPlayingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.mLinearInterpolator = linearInterpolator;
        LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_playback_now_playing_bars, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(androidx.leanback.R.id.bar1);
        this.f5912a = imageView;
        ImageView imageView2 = (ImageView) findViewById(androidx.leanback.R.id.bar2);
        this.f5913b = imageView2;
        ImageView imageView3 = (ImageView) findViewById(androidx.leanback.R.id.bar3);
        this.f5914c = imageView3;
        imageView.setPivotY(imageView.getDrawable().getIntrinsicHeight());
        imageView2.setPivotY(imageView2.getDrawable().getIntrinsicHeight());
        imageView3.setPivotY(imageView3.getDrawable().getIntrinsicHeight());
        setDropScale(imageView);
        setDropScale(imageView2);
        setDropScale(imageView3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleY", 0.41666666f, 0.25f, 0.41666666f, 0.5833333f, 0.75f, 0.8333333f, 0.9166667f, 1.0f, 0.9166667f, 1.0f, 0.8333333f, 0.6666667f, 0.5f, 0.33333334f, 0.16666667f, 0.33333334f, 0.5f, 0.5833333f, 0.75f, 0.9166667f, 0.75f, 0.5833333f, 0.41666666f, 0.25f, 0.41666666f, 0.6666667f, 0.41666666f, 0.25f, 0.33333334f, 0.41666666f);
        this.f5915d = ofFloat;
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(2320L);
        ofFloat.setInterpolator(linearInterpolator);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, "scaleY", 1.0f, 0.9166667f, 0.8333333f, 0.9166667f, 1.0f, 0.9166667f, 0.75f, 0.5833333f, 0.75f, 0.9166667f, 1.0f, 0.8333333f, 0.6666667f, 0.8333333f, 1.0f, 0.9166667f, 0.75f, 0.41666666f, 0.25f, 0.41666666f, 0.6666667f, 0.8333333f, 1.0f, 0.8333333f, 0.75f, 0.6666667f, 1.0f);
        this.f5916e = ofFloat2;
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setDuration(2080L);
        ofFloat2.setInterpolator(linearInterpolator);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView3, "scaleY", 0.6666667f, 0.75f, 0.8333333f, 1.0f, 0.9166667f, 0.75f, 0.5833333f, 0.41666666f, 0.5833333f, 0.6666667f, 0.75f, 1.0f, 0.9166667f, 1.0f, 0.75f, 0.5833333f, 0.75f, 0.9166667f, 1.0f, 0.8333333f, 0.6666667f, 0.75f, 0.5833333f, 0.41666666f, 0.25f, 0.6666667f);
        this.f5917f = ofFloat3;
        ofFloat3.setRepeatCount(-1);
        ofFloat3.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        ofFloat3.setInterpolator(linearInterpolator);
    }

    public static void setDropScale(View view) {
        view.setScaleY(0.083333336f);
    }

    /* renamed from: a */
    public final void m1450a() {
        ObjectAnimator objectAnimator = this.f5915d;
        if (!objectAnimator.isStarted()) {
            objectAnimator.start();
        }
        ObjectAnimator objectAnimator2 = this.f5916e;
        if (!objectAnimator2.isStarted()) {
            objectAnimator2.start();
        }
        ObjectAnimator objectAnimator3 = this.f5917f;
        if (!objectAnimator3.isStarted()) {
            objectAnimator3.start();
        }
        this.f5912a.setVisibility(0);
        this.f5913b.setVisibility(0);
        this.f5914c.setVisibility(0);
    }

    /* renamed from: b */
    public final void m1451b() {
        ObjectAnimator objectAnimator = this.f5915d;
        boolean isStarted = objectAnimator.isStarted();
        ImageView imageView = this.f5912a;
        if (isStarted) {
            objectAnimator.cancel();
            setDropScale(imageView);
        }
        ObjectAnimator objectAnimator2 = this.f5916e;
        boolean isStarted2 = objectAnimator2.isStarted();
        ImageView imageView2 = this.f5913b;
        if (isStarted2) {
            objectAnimator2.cancel();
            setDropScale(imageView2);
        }
        ObjectAnimator objectAnimator3 = this.f5917f;
        boolean isStarted3 = objectAnimator3.isStarted();
        ImageView imageView3 = this.f5914c;
        if (isStarted3) {
            objectAnimator3.cancel();
            setDropScale(imageView3);
        }
        imageView.setVisibility(8);
        imageView2.setVisibility(8);
        imageView3.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            m1450a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1451b();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 8) {
            m1451b();
        } else {
            m1450a();
        }
    }
}
