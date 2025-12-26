package androidx.leanback.widget;

import android.util.Property;
import androidx.leanback.widget.PagingIndicator;

/* renamed from: androidx.leanback.widget.s1 */
/* loaded from: classes.dex */
public final class C0385s1 extends Property {
    @Override // android.util.Property
    public final Object get(Object obj) {
        return Float.valueOf(((PagingIndicator.Dot) obj).getTranslationX());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ((PagingIndicator.Dot) obj).setTranslationX(((Float) obj2).floatValue());
    }
}
