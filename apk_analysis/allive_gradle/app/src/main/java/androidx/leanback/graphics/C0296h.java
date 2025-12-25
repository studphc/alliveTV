package androidx.leanback.graphics;

import android.util.Property;
import androidx.leanback.graphics.BoundsRule;
import androidx.leanback.graphics.CompositeDrawable;

/* renamed from: androidx.leanback.graphics.h */
/* loaded from: classes.dex */
public final class C0296h extends Property {
    @Override // android.util.Property
    public final Object get(Object obj) {
        CompositeDrawable.ChildDrawable childDrawable = (CompositeDrawable.ChildDrawable) obj;
        if (childDrawable.getBoundsRule().right == null) {
            return Float.valueOf(1.0f);
        }
        return Float.valueOf(childDrawable.getBoundsRule().right.getFraction());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        CompositeDrawable.ChildDrawable childDrawable = (CompositeDrawable.ChildDrawable) obj;
        Float f = (Float) obj2;
        if (childDrawable.getBoundsRule().right == null) {
            childDrawable.getBoundsRule().right = BoundsRule.ValueRule.inheritFromParent(f.floatValue());
        } else {
            childDrawable.getBoundsRule().right.setFraction(f.floatValue());
        }
        childDrawable.recomputeBounds();
    }
}
