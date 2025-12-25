package p000;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

/* renamed from: c4 */
/* loaded from: classes.dex */
public final class C0580c4 extends Drawable {

    /* renamed from: a */
    public final ActionBarContainer f8246a;

    public C0580c4(ActionBarContainer actionBarContainer) {
        this.f8246a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f8246a;
        if (actionBarContainer.f1025h) {
            Drawable drawable = actionBarContainer.f1024g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f1022e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Drawable drawable3 = actionBarContainer.f1023f;
        if (drawable3 != null && actionBarContainer.f1026i) {
            drawable3.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f8246a;
        if (actionBarContainer.f1025h) {
            if (actionBarContainer.f1024g != null) {
                actionBarContainer.f1022e.getOutline(outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f1022e;
            if (drawable != null) {
                drawable.getOutline(outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
