package androidx.leanback.widget;

import androidx.leanback.widget.Parallax;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* renamed from: androidx.leanback.widget.v1 */
/* loaded from: classes.dex */
public final class C0397v1 extends ParallaxEffect {
    @Override // androidx.leanback.widget.ParallaxEffect
    /* renamed from: a */
    public final Number mo1460a(Parallax parallax) {
        ArrayList arrayList = this.f5978a;
        if (arrayList.size() == 2) {
            if (((Parallax.PropertyMarkerValue) arrayList.get(0)).getProperty() == ((Parallax.PropertyMarkerValue) arrayList.get(1)).getProperty()) {
                float m1519a = ((C0389t1) arrayList.get(0)).m1519a(parallax);
                float m1519a2 = ((C0389t1) arrayList.get(1)).m1519a(parallax);
                if (m1519a > m1519a2) {
                    m1519a2 = m1519a;
                    m1519a = m1519a2;
                }
                Float f = ((Parallax.FloatProperty) ((Parallax.PropertyMarkerValue) arrayList.get(0)).getProperty()).get(parallax);
                if (f.floatValue() < m1519a) {
                    return Float.valueOf(m1519a);
                }
                if (f.floatValue() > m1519a2) {
                    return Float.valueOf(m1519a2);
                }
                return f;
            }
            throw new RuntimeException("Marker value must use same Property for direct mapping");
        }
        throw new RuntimeException("Must use two marker values for direct mapping");
    }

    @Override // androidx.leanback.widget.ParallaxEffect
    /* renamed from: b */
    public final float mo1461b(Parallax parallax) {
        float maxValue;
        int i = 0;
        int i2 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        while (true) {
            ArrayList arrayList = this.f5978a;
            if (i >= arrayList.size()) {
                return 1.0f;
            }
            C0389t1 c0389t1 = (C0389t1) arrayList.get(i);
            int index = ((Parallax.FloatProperty) c0389t1.getProperty()).getIndex();
            float m1519a = c0389t1.m1519a(parallax);
            float f3 = parallax.f5973d[index];
            if (i == 0) {
                if (f3 >= m1519a) {
                    return RecyclerView.f7068F0;
                }
            } else {
                if (i2 == index && f < m1519a) {
                    throw new IllegalStateException("marker value of same variable must be descendant order");
                }
                if (f3 == Float.MAX_VALUE) {
                    return m1462c((f - f2) / parallax.getMaxValue(), i);
                }
                if (f3 >= m1519a) {
                    if (i2 == index) {
                        maxValue = (f - f3) / (f - m1519a);
                    } else if (f2 != -3.4028235E38f) {
                        float f4 = (f3 - f2) + f;
                        maxValue = (f4 - f3) / (f4 - m1519a);
                    } else {
                        maxValue = 1.0f - ((f3 - m1519a) / parallax.getMaxValue());
                    }
                    return m1462c(maxValue, i);
                }
            }
            i++;
            f = m1519a;
            i2 = index;
            f2 = f3;
        }
    }
}
