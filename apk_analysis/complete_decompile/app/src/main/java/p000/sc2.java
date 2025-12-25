package p000;

import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;

/* loaded from: classes.dex */
public final class sc2 extends RoundedBitmapDrawable {
    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    /* renamed from: a */
    public final void mo848a(int i, int i2, int i3, Rect rect, Rect rect2) {
        Gravity.apply(i, i2, i3, rect, rect2, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        m849b();
        outline.setRoundRect(this.f3659h, getCornerRadius());
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public final boolean hasMipMap() {
        Bitmap bitmap = this.f3652a;
        if (bitmap != null && bitmap.hasMipMap()) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public final void setMipMap(boolean z) {
        Bitmap bitmap = this.f3652a;
        if (bitmap != null) {
            bitmap.setHasMipMap(z);
            invalidateSelf();
        }
    }
}
