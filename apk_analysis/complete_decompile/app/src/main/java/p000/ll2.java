package p000;

import com.google.common.collect.Ordering;
import java.util.List;

/* loaded from: classes.dex */
public enum ll2 extends pl2 {
    public ll2() {
        super("LAST_PRESENT", 1);
    }

    @Override // p000.pl2
    /* renamed from: a */
    public final int mo5563a(Ordering ordering, Object obj, List list, int i) {
        int size = list.size() - 1;
        while (i < size) {
            int i2 = ((i + size) + 1) >>> 1;
            if (ordering.compare(list.get(i2), obj) > 0) {
                size = i2 - 1;
            } else {
                i = i2;
            }
        }
        return i;
    }
}
