package androidx.core.view;

import android.os.Build;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import androidx.core.view.WindowInsetsAnimationCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import p000.u53;

/* renamed from: androidx.core.view.j */
/* loaded from: classes.dex */
public final class C0214j extends WindowInsetsAnimation$Callback {

    /* renamed from: a */
    public final WindowInsetsAnimationCompat.Callback f3994a;

    /* renamed from: b */
    public List f3995b;

    /* renamed from: c */
    public ArrayList f3996c;

    /* renamed from: d */
    public final HashMap f3997d;

    public C0214j(WindowInsetsAnimationCompat.Callback callback) {
        super(callback.getDispatchMode());
        this.f3997d = new HashMap();
        this.f3994a = callback;
    }

    /* renamed from: a */
    public final WindowInsetsAnimationCompat m958a(WindowInsetsAnimation windowInsetsAnimation) {
        WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) this.f3997d.get(windowInsetsAnimation);
        if (windowInsetsAnimationCompat == null) {
            windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                windowInsetsAnimationCompat.f3935a = new C0215k(windowInsetsAnimation);
            }
            this.f3997d.put(windowInsetsAnimation, windowInsetsAnimationCompat);
        }
        return windowInsetsAnimationCompat;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        this.f3994a.onEnd(m958a(windowInsetsAnimation));
        this.f3997d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        this.f3994a.onPrepare(m958a(windowInsetsAnimation));
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        float fraction;
        ArrayList arrayList = this.f3996c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f3996c = arrayList2;
            this.f3995b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation m7554j = u53.m7554j(list.get(size));
            WindowInsetsAnimationCompat m958a = m958a(m7554j);
            fraction = m7554j.getFraction();
            m958a.setFraction(fraction);
            this.f3996c.add(m958a);
        }
        return this.f3994a.onProgress(WindowInsetsCompat.toWindowInsetsCompat(windowInsets), this.f3995b).toWindowInsets();
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        return this.f3994a.onStart(m958a(windowInsetsAnimation), WindowInsetsAnimationCompat.BoundsCompat.toBoundsCompat(bounds)).toBounds();
    }
}
