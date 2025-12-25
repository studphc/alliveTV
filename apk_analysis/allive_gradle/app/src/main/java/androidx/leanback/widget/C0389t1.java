package androidx.leanback.widget;

import androidx.leanback.widget.Parallax;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.leanback.widget.t1 */
/* loaded from: classes.dex */
public final class C0389t1 extends Parallax.PropertyMarkerValue {

    /* renamed from: b */
    public final float f6415b;

    /* renamed from: c */
    public final float f6416c;

    public C0389t1(Parallax.FloatProperty floatProperty, float f, float f2) {
        super(floatProperty);
        this.f6415b = f;
        this.f6416c = f2;
    }

    /* renamed from: a */
    public final float m1519a(Parallax parallax) {
        float f = this.f6416c;
        float f2 = this.f6415b;
        if (f != RecyclerView.f7068F0) {
            return f2 + (parallax.getMaxValue() * f);
        }
        return f2;
    }
}
