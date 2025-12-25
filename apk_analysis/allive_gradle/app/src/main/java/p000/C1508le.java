package p000;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

/* renamed from: le */
/* loaded from: classes.dex */
public class C1508le extends Drawable {

    /* renamed from: a */
    public C1388ke f22474a;

    /* renamed from: b */
    public boolean f22475b;

    public C1508le(Bitmap bitmap, Matrix matrix) {
        this.f22474a = new C1388ke(bitmap, matrix);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        C1388ke c1388ke = this.f22474a;
        if (c1388ke.f20832a == null) {
            return;
        }
        if (c1388ke.f20834c.getAlpha() < 255 && this.f22474a.f20834c.getColorFilter() != null) {
            throw new IllegalStateException("Can't draw with translucent alpha and color filter");
        }
        C1388ke c1388ke2 = this.f22474a;
        canvas.drawBitmap(c1388ke2.f20832a, c1388ke2.f20833b, c1388ke2.f20834c);
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f22474a.f20834c.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f22474a;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.f22475b) {
            this.f22475b = true;
            this.f22474a = new C1388ke(this.f22474a);
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        mutate();
        if (this.f22474a.f20834c.getAlpha() != i) {
            this.f22474a.f20834c.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        mutate();
        this.f22474a.f20834c.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
