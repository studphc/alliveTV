package androidx.leanback.graphics;

import android.util.Property;
import androidx.leanback.graphics.BoundsRule;
import androidx.leanback.graphics.CompositeDrawable;

/* renamed from: androidx.leanback.graphics.b */
/* loaded from: classes.dex */
public final class C0290b extends Property {
    @Override // android.util.Property
    public final Object get(Object obj) {
        CompositeDrawable.ChildDrawable childDrawable = (CompositeDrawable.ChildDrawable) obj;
        if (childDrawable.getBoundsRule().bottom == null) {
            return Integer.valueOf(childDrawable.f5373d.getBounds().bottom);
        }
        return Integer.valueOf(childDrawable.getBoundsRule().bottom.getAbsoluteValue());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        CompositeDrawable.ChildDrawable childDrawable = (CompositeDrawable.ChildDrawable) obj;
        Integer num = (Integer) obj2;
        if (childDrawable.getBoundsRule().bottom == null) {
            childDrawable.getBoundsRule().bottom = BoundsRule.ValueRule.absoluteValue(num.intValue());
        } else {
            childDrawable.getBoundsRule().bottom.setAbsoluteValue(num.intValue());
        }
        childDrawable.recomputeBounds();
    }
}
