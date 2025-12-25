package p000;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* renamed from: ke */
/* loaded from: classes.dex */
public final class C1388ke extends Drawable.ConstantState {

    /* renamed from: a */
    public final Bitmap f20832a;

    /* renamed from: b */
    public final Matrix f20833b;

    /* renamed from: c */
    public final Paint f20834c;

    public C1388ke(Bitmap bitmap, Matrix matrix) {
        Paint paint = new Paint();
        this.f20834c = paint;
        this.f20832a = bitmap;
        this.f20833b = matrix == null ? new Matrix() : matrix;
        paint.setFilterBitmap(true);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [le, android.graphics.drawable.Drawable] */
    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        ?? drawable = new Drawable();
        drawable.f22474a = this;
        return drawable;
    }

    public C1388ke(C1388ke c1388ke) {
        Paint paint = new Paint();
        this.f20834c = paint;
        this.f20832a = c1388ke.f20832a;
        this.f20833b = c1388ke.f20833b != null ? new Matrix(c1388ke.f20833b) : new Matrix();
        if (c1388ke.f20834c.getAlpha() != 255) {
            paint.setAlpha(c1388ke.f20834c.getAlpha());
        }
        if (c1388ke.f20834c.getColorFilter() != null) {
            paint.setColorFilter(c1388ke.f20834c.getColorFilter());
        }
        paint.setFilterBitmap(true);
    }
}
