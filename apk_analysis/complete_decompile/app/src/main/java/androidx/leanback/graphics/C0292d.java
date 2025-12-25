package androidx.leanback.graphics;

import android.util.Property;
import androidx.leanback.graphics.BoundsRule;
import androidx.leanback.graphics.CompositeDrawable;

/* renamed from: androidx.leanback.graphics.d */
/* loaded from: classes.dex */
public final class C0292d extends Property {
    @Override // android.util.Property
    public final Object get(Object obj) {
        CompositeDrawable.ChildDrawable childDrawable = (CompositeDrawable.ChildDrawable) obj;
        if (childDrawable.getBoundsRule().right == null) {
            return Integer.valueOf(childDrawable.f5373d.getBounds().right);
        }
        return Integer.valueOf(childDrawable.getBoundsRule().right.getAbsoluteValue());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        CompositeDrawable.ChildDrawable childDrawable = (CompositeDrawable.ChildDrawable) obj;
        Integer num = (Integer) obj2;
        if (childDrawable.getBoundsRule().right == null) {
            childDrawable.getBoundsRule().right = BoundsRule.ValueRule.absoluteValue(num.intValue());
        } else {
            childDrawable.getBoundsRule().right.setAbsoluteValue(num.intValue());
        }
        childDrawable.recomputeBounds();
    }
}
