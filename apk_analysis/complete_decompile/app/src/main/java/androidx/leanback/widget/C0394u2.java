package androidx.leanback.widget;

import android.util.Property;

/* renamed from: androidx.leanback.widget.u2 */
/* loaded from: classes.dex */
public final class C0394u2 extends Property {
    @Override // android.util.Property
    public final Object get(Object obj) {
        return Integer.valueOf(((StreamingTextView) obj).getStreamPosition());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ((StreamingTextView) obj).setStreamPosition(((Integer) obj2).intValue());
    }
}
