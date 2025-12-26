package androidx.leanback.graphics;

import android.util.Property;
import androidx.leanback.graphics.BoundsRule;
import androidx.leanback.graphics.CompositeDrawable;

/* renamed from: androidx.leanback.graphics.c */
/* loaded from: classes.dex */
public final class C0291c extends Property {
    @Override // android.util.Property
    public final Object get(Object obj) {
        CompositeDrawable.ChildDrawable childDrawable = (CompositeDrawable.ChildDrawable) obj;
        if (childDrawable.getBoundsRule().left == null) {
            return Integer.valueOf(childDrawable.f5373d.getBounds().left);
        }
        return Integer.valueOf(childDrawable.getBoundsRule().left.getAbsoluteValue());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        CompositeDrawable.ChildDrawable childDrawable = (CompositeDrawable.ChildDrawable) obj;
        Integer num = (Integer) obj2;
        if (childDrawable.getBoundsRule().left == null) {
            childDrawable.getBoundsRule().left = BoundsRule.ValueRule.absoluteValue(num.intValue());
        } else {
            childDrawable.getBoundsRule().left.setAbsoluteValue(num.intValue());
        }
        childDrawable.recomputeBounds();
    }
}
