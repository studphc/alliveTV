package androidx.leanback.graphics;

import android.util.Property;
import androidx.leanback.graphics.BoundsRule;
import androidx.leanback.graphics.CompositeDrawable;

/* renamed from: androidx.leanback.graphics.f */
/* loaded from: classes.dex */
public final class C0294f extends Property {
    @Override // android.util.Property
    public final Object get(Object obj) {
        CompositeDrawable.ChildDrawable childDrawable = (CompositeDrawable.ChildDrawable) obj;
        if (childDrawable.getBoundsRule().bottom == null) {
            return Float.valueOf(1.0f);
        }
        return Float.valueOf(childDrawable.getBoundsRule().bottom.getFraction());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        CompositeDrawable.ChildDrawable childDrawable = (CompositeDrawable.ChildDrawable) obj;
        Float f = (Float) obj2;
        if (childDrawable.getBoundsRule().bottom == null) {
            childDrawable.getBoundsRule().bottom = BoundsRule.ValueRule.inheritFromParent(f.floatValue());
        } else {
            childDrawable.getBoundsRule().bottom.setFraction(f.floatValue());
        }
        childDrawable.recomputeBounds();
    }
}
