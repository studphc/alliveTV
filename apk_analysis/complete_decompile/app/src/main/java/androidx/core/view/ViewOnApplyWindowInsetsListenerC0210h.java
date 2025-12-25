package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import p000.b12;
import p000.t53;

/* renamed from: androidx.core.view.h */
/* loaded from: classes.dex */
public final class ViewOnApplyWindowInsetsListenerC0210h implements View.OnApplyWindowInsetsListener {

    /* renamed from: a */
    public final WindowInsetsAnimationCompat.Callback f3985a;

    /* renamed from: b */
    public WindowInsetsCompat f3986b;

    public ViewOnApplyWindowInsetsListenerC0210h(View view, WindowInsetsAnimationCompat.Callback callback) {
        WindowInsetsCompat windowInsetsCompat;
        this.f3985a = callback;
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        if (rootWindowInsets != null) {
            windowInsetsCompat = new WindowInsetsCompat.Builder(rootWindowInsets).build();
        } else {
            windowInsetsCompat = null;
        }
        this.f3986b = windowInsetsCompat;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        Interpolator interpolator;
        if (!view.isLaidOut()) {
            this.f3986b = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
            return C0211i.m955k(view, windowInsets);
        }
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
        if (this.f3986b == null) {
            this.f3986b = ViewCompat.getRootWindowInsets(view);
        }
        if (this.f3986b == null) {
            this.f3986b = windowInsetsCompat;
            return C0211i.m955k(view, windowInsets);
        }
        WindowInsetsAnimationCompat.Callback m956l = C0211i.m956l(view);
        if (m956l != null && Objects.equals(m956l.f3938a, windowInsets)) {
            return C0211i.m955k(view, windowInsets);
        }
        WindowInsetsCompat windowInsetsCompat2 = this.f3986b;
        int i = 0;
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if (!windowInsetsCompat.getInsets(i2).equals(windowInsetsCompat2.getInsets(i2))) {
                i |= i2;
            }
        }
        if (i == 0) {
            return C0211i.m955k(view, windowInsets);
        }
        WindowInsetsCompat windowInsetsCompat3 = this.f3986b;
        if ((i & 8) != 0) {
            if (windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime()).bottom > windowInsetsCompat3.getInsets(WindowInsetsCompat.Type.ime()).bottom) {
                interpolator = C0211i.f3987f;
            } else {
                interpolator = C0211i.f3988g;
            }
        } else {
            interpolator = C0211i.f3989h;
        }
        WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(i, interpolator, 160L);
        windowInsetsAnimationCompat.setFraction(RecyclerView.f7068F0);
        ValueAnimator duration = ValueAnimator.ofFloat(RecyclerView.f7068F0, 1.0f).setDuration(windowInsetsAnimationCompat.getDurationMillis());
        Insets insets = windowInsetsCompat.getInsets(i);
        Insets insets2 = windowInsetsCompat3.getInsets(i);
        WindowInsetsAnimationCompat.BoundsCompat boundsCompat = new WindowInsetsAnimationCompat.BoundsCompat(Insets.m828of(Math.min(insets.left, insets2.left), Math.min(insets.top, insets2.top), Math.min(insets.right, insets2.right), Math.min(insets.bottom, insets2.bottom)), Insets.m828of(Math.max(insets.left, insets2.left), Math.max(insets.top, insets2.top), Math.max(insets.right, insets2.right), Math.max(insets.bottom, insets2.bottom)));
        C0211i.m952h(view, windowInsetsAnimationCompat, windowInsets, false);
        duration.addUpdateListener(new t53(windowInsetsAnimationCompat, windowInsetsCompat, windowInsetsCompat3, i, view));
        duration.addListener(new b12(windowInsetsAnimationCompat, view, 3));
        OneShotPreDrawListener.add(view, new RunnableC0209g(view, windowInsetsAnimationCompat, boundsCompat, duration));
        this.f3986b = windowInsetsCompat;
        return C0211i.m955k(view, windowInsets);
    }
}
