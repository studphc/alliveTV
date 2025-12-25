package p000;

import android.view.ViewGroup;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class i33 {
    @DoNotInline
    /* renamed from: a */
    public static int m5159a(ViewGroup viewGroup) {
        return viewGroup.getNestedScrollAxes();
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m5160b(ViewGroup viewGroup) {
        return viewGroup.isTransitionGroup();
    }

    @DoNotInline
    /* renamed from: c */
    public static void m5161c(ViewGroup viewGroup, boolean z) {
        viewGroup.setTransitionGroup(z);
    }
}
