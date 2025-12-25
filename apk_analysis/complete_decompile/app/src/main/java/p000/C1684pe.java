package p000;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.leanback.app.BackgroundManager;
import java.lang.ref.WeakReference;

/* renamed from: pe */
/* loaded from: classes.dex */
public final class C1684pe extends LayerDrawable {

    /* renamed from: a */
    public C1582ne[] f25128a;

    /* renamed from: b */
    public int f25129b;

    /* renamed from: c */
    public boolean f25130c;

    /* renamed from: d */
    public WeakReference f25131d;

    /* renamed from: a */
    public final void m6911a(int i, Context context) {
        for (int i2 = 0; i2 < getNumberOfLayers(); i2++) {
            if (getId(i2) == i) {
                this.f25128a[i2] = null;
                if (!(getDrawable(i2) instanceof C1619oe)) {
                    context.getResources();
                    super.setDrawableByLayerId(i, new C1508le(null, null));
                    return;
                }
                return;
            }
        }
    }

    /* renamed from: b */
    public final C1582ne m6912b(int i, Drawable drawable) {
        super.setDrawableByLayerId(i, drawable);
        for (int i2 = 0; i2 < getNumberOfLayers(); i2++) {
            if (getId(i2) == i) {
                C1582ne c1582ne = new C1582ne(drawable);
                C1582ne[] c1582neArr = this.f25128a;
                c1582neArr[i2] = c1582ne;
                invalidateSelf();
                return c1582neArr[i2];
            }
        }
        return null;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        int i3 = 0;
        while (true) {
            C1582ne[] c1582neArr = this.f25128a;
            if (i3 < c1582neArr.length) {
                C1582ne c1582ne = c1582neArr[i3];
                if (c1582ne != null && (drawable = (Drawable) c1582ne.f23337b) != null) {
                    int alpha = DrawableCompat.getAlpha(drawable);
                    int i4 = this.f25129b;
                    if (i4 < 255) {
                        i2 = i4 * alpha;
                        i = 1;
                    } else {
                        i = 0;
                        i2 = alpha;
                    }
                    int i5 = c1582neArr[i3].f23336a;
                    if (i5 < 255) {
                        i2 *= i5;
                        i++;
                    }
                    if (i == 0) {
                        drawable.draw(canvas);
                    } else {
                        if (i == 1) {
                            i2 /= 255;
                        } else if (i == 2) {
                            i2 /= 65025;
                        }
                        try {
                            this.f25130c = true;
                            drawable.setAlpha(i2);
                            drawable.draw(canvas);
                            drawable.setAlpha(alpha);
                        } finally {
                            this.f25130c = false;
                        }
                    }
                }
                i3++;
            } else {
                return;
            }
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f25129b;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        if (!this.f25130c) {
            super.invalidateDrawable(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [ne, java.lang.Object] */
    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable mutate = super.mutate();
        int numberOfLayers = getNumberOfLayers();
        for (int i = 0; i < numberOfLayers; i++) {
            C1582ne[] c1582neArr = this.f25128a;
            C1582ne c1582ne = c1582neArr[i];
            if (c1582ne != 0) {
                Drawable drawable = getDrawable(i);
                ?? obj = new Object();
                obj.f23336a = 255;
                obj.f23337b = drawable;
                obj.f23336a = c1582ne.f23336a;
                c1582neArr[i] = obj;
            }
        }
        return mutate;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.f25129b != i) {
            this.f25129b = i;
            invalidateSelf();
            BackgroundManager backgroundManager = (BackgroundManager) this.f25131d.get();
            if (backgroundManager != null) {
                backgroundManager.m1256c();
            }
        }
    }

    @Override // android.graphics.drawable.LayerDrawable
    public final boolean setDrawableByLayerId(int i, Drawable drawable) {
        if (m6912b(i, drawable) != null) {
            return true;
        }
        return false;
    }
}
