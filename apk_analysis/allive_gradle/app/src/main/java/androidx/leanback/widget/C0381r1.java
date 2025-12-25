package androidx.leanback.widget;

import android.util.Property;
import androidx.leanback.widget.PagingIndicator;

/* renamed from: androidx.leanback.widget.r1 */
/* loaded from: classes.dex */
public final class C0381r1 extends Property {
    @Override // android.util.Property
    public final Object get(Object obj) {
        return Float.valueOf(((PagingIndicator.Dot) obj).getDiameter());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ((PagingIndicator.Dot) obj).setDiameter(((Float) obj2).floatValue());
    }
}
