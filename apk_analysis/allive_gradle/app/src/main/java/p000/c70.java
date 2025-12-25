package p000;

import android.graphics.Canvas;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;

/* loaded from: classes.dex */
public final class c70 extends DrawableWrapperCompat {

    /* renamed from: b */
    public boolean f8281b;

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.f8281b) {
            super.draw(canvas);
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public final void setHotspot(float f, float f2) {
        if (this.f8281b) {
            super.setHotspot(f, f2);
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f8281b) {
            super.setHotspotBounds(i, i2, i3, i4);
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        if (this.f8281b) {
            return super.setState(iArr);
        }
        return false;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        if (this.f8281b) {
            return super.setVisible(z, z2);
        }
        return false;
    }
}
