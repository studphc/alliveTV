package p000;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.widget.DetailsParallax;
import androidx.leanback.widget.Parallax;
import androidx.leanback.widget.ParallaxEffect;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class m20 {

    /* renamed from: a */
    public final DetailsParallax f22770a;

    /* renamed from: b */
    public final ParallaxEffect f22771b;

    /* renamed from: d */
    public ValueAnimator f22773d;

    /* renamed from: e */
    public final Drawable f22774e;

    /* renamed from: c */
    public int f22772c = 0;

    /* renamed from: h */
    public final l20 f22777h = new l20(this);

    /* renamed from: f */
    public PlaybackGlue f22775f = null;

    /* renamed from: g */
    public boolean f22776g = true;

    public m20(DetailsParallax detailsParallax, Drawable drawable) {
        this.f22770a = detailsParallax;
        this.f22774e = drawable;
        drawable.setAlpha(255);
        if (this.f22771b == null) {
            Parallax.IntProperty overviewRowTop = detailsParallax.getOverviewRowTop();
            this.f22771b = detailsParallax.addEffect(overviewRowTop.atFraction(1.0f), overviewRowTop.atFraction(RecyclerView.f7068F0)).target(new j20(this));
            detailsParallax.updateValues();
        }
    }

    /* renamed from: a */
    public final void m6008a() {
        int i = this.f22772c;
        l20 l20Var = this.f22777h;
        if (i != 1) {
            if (i == 2) {
                m6009b(false, false);
                PlaybackGlue playbackGlue = this.f22775f;
                if (playbackGlue != null) {
                    playbackGlue.removePlayerCallback(l20Var);
                    this.f22775f.pause();
                    return;
                }
                return;
            }
            return;
        }
        PlaybackGlue playbackGlue2 = this.f22775f;
        if (playbackGlue2 != null) {
            if (playbackGlue2.isPrepared()) {
                PlaybackGlue playbackGlue3 = this.f22775f;
                if (playbackGlue3 != null) {
                    playbackGlue3.play();
                }
                this.f22770a.getRecyclerView().postDelayed(new RunnableC1104d(11, this), 1000L);
                return;
            }
            this.f22775f.addPlayerCallback(l20Var);
            return;
        }
        m6009b(false, false);
    }

    /* renamed from: b */
    public final void m6009b(boolean z, boolean z2) {
        float f;
        int i = 0;
        boolean z3 = !z;
        boolean z4 = this.f22776g;
        Drawable drawable = this.f22774e;
        if (z4 == z3) {
            if (z2) {
                ValueAnimator valueAnimator = this.f22773d;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.f22773d = null;
                }
                if (drawable != null) {
                    if (!z) {
                        i = 255;
                    }
                    drawable.setAlpha(i);
                    return;
                }
                return;
            }
            return;
        }
        this.f22776g = z3;
        ValueAnimator valueAnimator2 = this.f22773d;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f22773d = null;
        }
        float f2 = RecyclerView.f7068F0;
        if (z) {
            f = 1.0f;
        } else {
            f = 0.0f;
        }
        if (!z) {
            f2 = 1.0f;
        }
        if (drawable == null) {
            return;
        }
        if (z2) {
            if (!z) {
                i = 255;
            }
            drawable.setAlpha(i);
        } else {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
            this.f22773d = ofFloat;
            ofFloat.setDuration(500L);
            this.f22773d.addUpdateListener(new C1303ie(1, this));
            this.f22773d.addListener(new k20(this));
            this.f22773d.start();
        }
    }
}
