package p000;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.annotation.DoNotInline;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class s70 {
    @DoNotInline
    /* renamed from: a */
    public static EdgeEffect m7343a(Context context, AttributeSet attributeSet) {
        try {
            return new EdgeEffect(context, attributeSet);
        } catch (Throwable unused) {
            return new EdgeEffect(context);
        }
    }

    @DoNotInline
    /* renamed from: b */
    public static float m7344b(EdgeEffect edgeEffect) {
        try {
            return edgeEffect.getDistance();
        } catch (Throwable unused) {
            return RecyclerView.f7068F0;
        }
    }

    @DoNotInline
    /* renamed from: c */
    public static float m7345c(EdgeEffect edgeEffect, float f, float f2) {
        try {
            return edgeEffect.onPullDistance(f, f2);
        } catch (Throwable unused) {
            edgeEffect.onPull(f, f2);
            return RecyclerView.f7068F0;
        }
    }
}
