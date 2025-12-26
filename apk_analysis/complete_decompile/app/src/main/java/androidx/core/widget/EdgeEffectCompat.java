package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import p000.r70;
import p000.s70;

/* loaded from: classes.dex */
public final class EdgeEffectCompat {

    /* renamed from: a */
    public final EdgeEffect f4049a;

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.f4049a = new EdgeEffect(context);
    }

    @NonNull
    public static EdgeEffect create(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 31) {
            return s70.m7343a(context, attributeSet);
        }
        return new EdgeEffect(context);
    }

    public static float getDistance(@NonNull EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return s70.m7344b(edgeEffect);
        }
        return RecyclerView.f7068F0;
    }

    public static float onPullDistance(@NonNull EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return s70.m7345c(edgeEffect, f, f2);
        }
        onPull(edgeEffect, f, f2);
        return f;
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.f4049a.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.f4049a.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.f4049a.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i) {
        this.f4049a.onAbsorb(i);
        return true;
    }

    @Deprecated
    public boolean onPull(float f) {
        this.f4049a.onPull(f);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        EdgeEffect edgeEffect = this.f4049a;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int i, int i2) {
        this.f4049a.setSize(i, i2);
    }

    @Deprecated
    public boolean onPull(float f, float f2) {
        onPull(this.f4049a, f, f2);
        return true;
    }

    public static void onPull(@NonNull EdgeEffect edgeEffect, float f, float f2) {
        r70.m7226a(edgeEffect, f, f2);
    }
}
