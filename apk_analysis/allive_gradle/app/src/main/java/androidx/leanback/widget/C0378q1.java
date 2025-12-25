package androidx.leanback.widget;

import android.util.Property;
import androidx.leanback.widget.PagingIndicator;

/* renamed from: androidx.leanback.widget.q1 */
/* loaded from: classes.dex */
public final class C0378q1 extends Property {
    @Override // android.util.Property
    public final Object get(Object obj) {
        return Float.valueOf(((PagingIndicator.Dot) obj).getAlpha());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ((PagingIndicator.Dot) obj).setAlpha(((Float) obj2).floatValue());
    }
}
