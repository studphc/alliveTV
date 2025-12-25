package androidx.leanback.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import androidx.annotation.NonNull;
import p000.je0;
import p000.ke0;
import p000.le0;

/* loaded from: classes.dex */
public class FitWidthBitmapDrawable extends Drawable {
    public static final Property<FitWidthBitmapDrawable, Integer> PROPERTY_VERTICAL_OFFSET;

    /* renamed from: a */
    public final Rect f5374a;

    /* renamed from: b */
    public le0 f5375b;

    /* renamed from: c */
    public boolean f5376c;

    static {
        if (Build.VERSION.SDK_INT >= 24) {
            PROPERTY_VERTICAL_OFFSET = new ke0();
        } else {
            PROPERTY_VERTICAL_OFFSET = new je0("verticalOffset", 0, Integer.class);
        }
    }

    public FitWidthBitmapDrawable() {
        this.f5374a = new Rect();
        this.f5376c = false;
        this.f5375b = new le0();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f5375b.f22477b != null) {
            Rect bounds = getBounds();
            Rect rect = this.f5374a;
            rect.left = 0;
            rect.top = this.f5375b.f22480e;
            rect.right = bounds.width();
            le0 le0Var = this.f5375b;
            Rect rect2 = le0Var.f22478c;
            if (rect2 == null) {
                rect2 = le0Var.f22479d;
            }
            rect.bottom = rect.top + ((int) (rect2.height() * (bounds.width() / rect2.width())));
            int save = canvas.save();
            canvas.clipRect(bounds);
            le0 le0Var2 = this.f5375b;
            canvas.drawBitmap(le0Var2.f22477b, rect2, rect, le0Var2.f22476a);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5375b.f22476a.getAlpha();
    }

    public Bitmap getBitmap() {
        return this.f5375b.f22477b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f5375b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap = this.f5375b.f22477b;
        if (bitmap != null && !bitmap.hasAlpha() && this.f5375b.f22476a.getAlpha() >= 255) {
            return -1;
        }
        return -3;
    }

    public Rect getSource() {
        return this.f5375b.f22478c;
    }

    public int getVerticalOffset() {
        return this.f5375b.f22480e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f5376c && super.mutate() == this) {
            this.f5375b = new le0(this.f5375b);
            this.f5376c = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f5375b.f22476a.getAlpha()) {
            this.f5375b.f22476a.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setBitmap(Bitmap bitmap) {
        le0 le0Var = this.f5375b;
        le0Var.f22477b = bitmap;
        if (bitmap != null) {
            le0Var.f22479d.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        } else {
            le0Var.f22479d.set(0, 0, 0, 0);
        }
        this.f5375b.f22478c = null;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5375b.f22476a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setSource(Rect rect) {
        this.f5375b.f22478c = rect;
    }

    public void setVerticalOffset(int i) {
        this.f5375b.f22480e = i;
        invalidateSelf();
    }

    public FitWidthBitmapDrawable(le0 le0Var) {
        this.f5374a = new Rect();
        this.f5376c = false;
        this.f5375b = le0Var;
    }
}
