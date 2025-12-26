package androidx.leanback.graphics;

import android.util.Property;
import androidx.leanback.graphics.BoundsRule;
import androidx.leanback.graphics.CompositeDrawable;

/* renamed from: androidx.leanback.graphics.a */
/* loaded from: classes.dex */
public final class C0289a extends Property {
    @Override // android.util.Property
    public final Object get(Object obj) {
        CompositeDrawable.ChildDrawable childDrawable = (CompositeDrawable.ChildDrawable) obj;
        if (childDrawable.getBoundsRule().top == null) {
            return Integer.valueOf(childDrawable.f5373d.getBounds().top);
        }
        return Integer.valueOf(childDrawable.getBoundsRule().top.getAbsoluteValue());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        CompositeDrawable.ChildDrawable childDrawable = (CompositeDrawable.ChildDrawable) obj;
        Integer num = (Integer) obj2;
        if (childDrawable.getBoundsRule().top == null) {
            childDrawable.getBoundsRule().top = BoundsRule.ValueRule.absoluteValue(num.intValue());
        } else {
            childDrawable.getBoundsRule().top.setAbsoluteValue(num.intValue());
        }
        childDrawable.recomputeBounds();
    }
}
