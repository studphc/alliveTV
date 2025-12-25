package androidx.leanback.widget;

import androidx.leanback.widget.Parallax;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.leanback.widget.u1 */
/* loaded from: classes.dex */
public final class C0393u1 extends Parallax.PropertyMarkerValue {

    /* renamed from: b */
    public final int f6420b;

    /* renamed from: c */
    public final float f6421c;

    public C0393u1(Parallax.IntProperty intProperty, int i, float f) {
        super(intProperty);
        this.f6420b = i;
        this.f6421c = f;
    }

    /* renamed from: a */
    public final int m1520a(Parallax parallax) {
        float f = this.f6421c;
        int i = this.f6420b;
        if (f != RecyclerView.f7068F0) {
            return i + Math.round(parallax.getMaxValue() * f);
        }
        return i;
    }
}
