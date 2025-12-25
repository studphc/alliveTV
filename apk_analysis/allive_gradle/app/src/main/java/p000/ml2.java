package p000;

import com.google.common.collect.Ordering;
import java.util.List;

/* loaded from: classes.dex */
public enum ml2 extends pl2 {
    public ml2() {
        super("FIRST_PRESENT", 2);
    }

    @Override // p000.pl2
    /* renamed from: a */
    public final int mo5563a(Ordering ordering, Object obj, List list, int i) {
        int i2 = 0;
        while (i2 < i) {
            int i3 = (i2 + i) >>> 1;
            if (ordering.compare(list.get(i3), obj) < 0) {
                i2 = i3 + 1;
            } else {
                i = i3;
            }
        }
        return i2;
    }
}
