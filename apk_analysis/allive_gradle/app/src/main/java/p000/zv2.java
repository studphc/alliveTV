package p000;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class zv2 extends ge3 {
    @Override // p000.ge3
    /* renamed from: f */
    public final Object mo4946f(ArrayDeque arrayDeque) {
        Iterator it = (Iterator) arrayDeque.getFirst();
        if (it.hasNext()) {
            return Preconditions.checkNotNull(it.next());
        }
        arrayDeque.removeFirst();
        return null;
    }
}
