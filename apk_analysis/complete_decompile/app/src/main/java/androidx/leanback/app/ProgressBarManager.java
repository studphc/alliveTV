package androidx.leanback.app;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import p000.sn1;

/* loaded from: classes.dex */
public final class ProgressBarManager {

    /* renamed from: b */
    public ViewGroup f5200b;

    /* renamed from: c */
    public View f5201c;

    /* renamed from: f */
    public boolean f5204f;

    /* renamed from: g */
    public boolean f5205g;

    /* renamed from: a */
    public long f5199a = 1000;

    /* renamed from: d */
    public final Handler f5202d = new Handler();

    /* renamed from: e */
    public boolean f5203e = true;

    /* renamed from: h */
    public final sn1 f5206h = new sn1(4, this);

    public void disableProgressBar() {
        this.f5203e = false;
    }

    public void enableProgressBar() {
        this.f5203e = true;
    }

    public long getInitialDelay() {
        return this.f5199a;
    }

    public void hide() {
        this.f5205g = false;
        if (this.f5204f) {
            this.f5201c.setVisibility(4);
        } else {
            View view = this.f5201c;
            if (view != null) {
                this.f5200b.removeView(view);
                this.f5201c = null;
            }
        }
        this.f5202d.removeCallbacks(this.f5206h);
    }

    public void setInitialDelay(long j) {
        this.f5199a = j;
    }

    public void setProgressBarView(View view) {
        if (view != null && view.getParent() == null) {
            throw new IllegalArgumentException("Must have a parent");
        }
        this.f5201c = view;
        if (view != null) {
            view.setVisibility(4);
            this.f5204f = true;
        }
    }

    public void setRootView(ViewGroup viewGroup) {
        this.f5200b = viewGroup;
    }

    public void show() {
        if (this.f5203e) {
            this.f5205g = true;
            this.f5202d.postDelayed(this.f5206h, this.f5199a);
        }
    }
}
