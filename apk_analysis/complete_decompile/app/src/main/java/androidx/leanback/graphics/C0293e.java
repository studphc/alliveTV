package androidx.leanback.graphics;

import android.util.Property;
import androidx.leanback.graphics.BoundsRule;
import androidx.leanback.graphics.CompositeDrawable;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.leanback.graphics.e */
/* loaded from: classes.dex */
public final class C0293e extends Property {
    @Override // android.util.Property
    public final Object get(Object obj) {
        CompositeDrawable.ChildDrawable childDrawable = (CompositeDrawable.ChildDrawable) obj;
        if (childDrawable.getBoundsRule().top == null) {
            return Float.valueOf(RecyclerView.f7068F0);
        }
        return Float.valueOf(childDrawable.getBoundsRule().top.getFraction());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        CompositeDrawable.ChildDrawable childDrawable = (CompositeDrawable.ChildDrawable) obj;
        Float f = (Float) obj2;
        if (childDrawable.getBoundsRule().top == null) {
            childDrawable.getBoundsRule().top = BoundsRule.ValueRule.inheritFromParent(f.floatValue());
        } else {
            childDrawable.getBoundsRule().top.setFraction(f.floatValue());
        }
        childDrawable.recomputeBounds();
    }
}
