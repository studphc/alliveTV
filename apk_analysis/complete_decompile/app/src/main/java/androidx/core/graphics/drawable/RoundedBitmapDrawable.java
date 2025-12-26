package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class RoundedBitmapDrawable extends Drawable {

    /* renamed from: a */
    public final Bitmap f3652a;

    /* renamed from: b */
    public int f3653b;

    /* renamed from: e */
    public final BitmapShader f3656e;

    /* renamed from: g */
    public float f3658g;

    /* renamed from: k */
    public boolean f3662k;

    /* renamed from: l */
    public int f3663l;

    /* renamed from: m */
    public int f3664m;

    /* renamed from: c */
    public int f3654c = 119;

    /* renamed from: d */
    public final Paint f3655d = new Paint(3);

    /* renamed from: f */
    public final Matrix f3657f = new Matrix();

    /* renamed from: h */
    public final Rect f3659h = new Rect();

    /* renamed from: i */
    public final RectF f3660i = new RectF();

    /* renamed from: j */
    public boolean f3661j = true;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        this.f3653b = 160;
        if (resources != null) {
            this.f3653b = resources.getDisplayMetrics().densityDpi;
        }
        this.f3652a = bitmap;
        if (bitmap != null) {
            this.f3663l = bitmap.getScaledWidth(this.f3653b);
            this.f3664m = bitmap.getScaledHeight(this.f3653b);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f3656e = new BitmapShader(bitmap, tileMode, tileMode);
            return;
        }
        this.f3664m = -1;
        this.f3663l = -1;
        this.f3656e = null;
    }

    /* renamed from: a */
    public void mo848a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public final void m849b() {
        if (this.f3661j) {
            boolean z = this.f3662k;
            Rect rect = this.f3659h;
            if (z) {
                int min = Math.min(this.f3663l, this.f3664m);
                mo848a(this.f3654c, min, min, getBounds(), this.f3659h);
                int min2 = Math.min(rect.width(), rect.height());
                rect.inset(Math.max(0, (rect.width() - min2) / 2), Math.max(0, (rect.height() - min2) / 2));
                this.f3658g = min2 * 0.5f;
            } else {
                mo848a(this.f3654c, this.f3663l, this.f3664m, getBounds(), this.f3659h);
            }
            RectF rectF = this.f3660i;
            rectF.set(rect);
            BitmapShader bitmapShader = this.f3656e;
            if (bitmapShader != null) {
                Matrix matrix = this.f3657f;
                matrix.setTranslate(rectF.left, rectF.top);
                float width = rectF.width();
                Bitmap bitmap = this.f3652a;
                matrix.preScale(width / bitmap.getWidth(), rectF.height() / bitmap.getHeight());
                bitmapShader.setLocalMatrix(matrix);
                this.f3655d.setShader(bitmapShader);
            }
            this.f3661j = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap = this.f3652a;
        if (bitmap == null) {
            return;
        }
        m849b();
        Paint paint = this.f3655d;
        if (paint.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f3659h, paint);
            return;
        }
        RectF rectF = this.f3660i;
        float f = this.f3658g;
        canvas.drawRoundRect(rectF, f, f, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f3655d.getAlpha();
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.f3652a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f3655d.getColorFilter();
    }

    public float getCornerRadius() {
        return this.f3658g;
    }

    public int getGravity() {
        return this.f3654c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f3664m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f3663l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        if (this.f3654c != 119 || this.f3662k || (bitmap = this.f3652a) == null || bitmap.hasAlpha() || this.f3655d.getAlpha() < 255 || this.f3658g > 0.05f) {
            return -3;
        }
        return -1;
    }

    @NonNull
    public final Paint getPaint() {
        return this.f3655d;
    }

    public boolean hasAntiAlias() {
        return this.f3655d.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public boolean isCircular() {
        return this.f3662k;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        if (this.f3662k) {
            this.f3658g = Math.min(this.f3664m, this.f3663l) / 2;
        }
        this.f3661j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.f3655d;
        if (i != paint.getAlpha()) {
            paint.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z) {
        this.f3655d.setAntiAlias(z);
        invalidateSelf();
    }

    public void setCircular(boolean z) {
        this.f3662k = z;
        this.f3661j = true;
        if (z) {
            this.f3658g = Math.min(this.f3664m, this.f3663l) / 2;
            this.f3655d.setShader(this.f3656e);
            invalidateSelf();
            return;
        }
        setCornerRadius(RecyclerView.f7068F0);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3655d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setCornerRadius(float f) {
        if (this.f3658g == f) {
            return;
        }
        boolean z = false;
        this.f3662k = false;
        if (f > 0.05f) {
            z = true;
        }
        Paint paint = this.f3655d;
        if (z) {
            paint.setShader(this.f3656e);
        } else {
            paint.setShader(null);
        }
        this.f3658g = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f3655d.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f3655d.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setGravity(int i) {
        if (this.f3654c != i) {
            this.f3654c = i;
            this.f3661j = true;
            invalidateSelf();
        }
    }

    public void setMipMap(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(@NonNull Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public void setTargetDensity(@NonNull DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }

    public void setTargetDensity(int i) {
        if (this.f3653b != i) {
            if (i == 0) {
                i = 160;
            }
            this.f3653b = i;
            Bitmap bitmap = this.f3652a;
            if (bitmap != null) {
                this.f3663l = bitmap.getScaledWidth(i);
                this.f3664m = bitmap.getScaledHeight(this.f3653b);
            }
            invalidateSelf();
        }
    }
}
