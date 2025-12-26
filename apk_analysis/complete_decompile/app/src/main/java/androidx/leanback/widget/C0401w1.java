package androidx.leanback.widget;

import androidx.leanback.widget.Parallax;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* renamed from: androidx.leanback.widget.w1 */
/* loaded from: classes.dex */
public final class C0401w1 extends ParallaxEffect {
    @Override // androidx.leanback.widget.ParallaxEffect
    /* renamed from: a */
    public final Number mo1460a(Parallax parallax) {
        ArrayList arrayList = this.f5978a;
        if (arrayList.size() == 2) {
            if (((Parallax.PropertyMarkerValue) arrayList.get(0)).getProperty() == ((Parallax.PropertyMarkerValue) arrayList.get(1)).getProperty()) {
                int m1520a = ((C0393u1) arrayList.get(0)).m1520a(parallax);
                int m1520a2 = ((C0393u1) arrayList.get(1)).m1520a(parallax);
                if (m1520a > m1520a2) {
                    m1520a2 = m1520a;
                    m1520a = m1520a2;
                }
                Integer num = ((Parallax.IntProperty) ((Parallax.PropertyMarkerValue) arrayList.get(0)).getProperty()).get(parallax);
                if (num.intValue() < m1520a) {
                    return Integer.valueOf(m1520a);
                }
                if (num.intValue() > m1520a2) {
                    return Integer.valueOf(m1520a2);
                }
                return num;
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
        int i3 = 0;
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f5978a;
            if (i >= arrayList.size()) {
                return 1.0f;
            }
            C0393u1 c0393u1 = (C0393u1) arrayList.get(i);
            int index = ((Parallax.IntProperty) c0393u1.getProperty()).getIndex();
            int m1520a = c0393u1.m1520a(parallax);
            int i5 = parallax.f5972c[index];
            if (i == 0) {
                if (i5 >= m1520a) {
                    return RecyclerView.f7068F0;
                }
            } else {
                if (i2 == index && i3 < m1520a) {
                    throw new IllegalStateException("marker value of same variable must be descendant order");
                }
                if (i5 == Integer.MAX_VALUE) {
                    return m1462c((i3 - i4) / parallax.getMaxValue(), i);
                }
                if (i5 >= m1520a) {
                    if (i2 == index) {
                        maxValue = (i3 - i5) / (i3 - m1520a);
                    } else if (i4 != Integer.MIN_VALUE) {
                        int i6 = (i5 - i4) + i3;
                        maxValue = (i6 - i5) / (i6 - m1520a);
                    } else {
                        maxValue = 1.0f - ((i5 - m1520a) / parallax.getMaxValue());
                    }
                    return m1462c(maxValue, i);
                }
            }
            i++;
            i3 = m1520a;
            i2 = index;
            i4 = i5;
        }
    }
}
