package p000;

import android.util.IntProperty;
import androidx.leanback.graphics.FitWidthBitmapDrawable;

/* loaded from: classes.dex */
public final class ke0 extends IntProperty {
    public ke0() {
        super("verticalOffset");
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        return Integer.valueOf(((FitWidthBitmapDrawable) obj).getVerticalOffset());
    }

    public final void setValue(Object obj, int i) {
        ((FitWidthBitmapDrawable) obj).setVerticalOffset(i);
    }
}
