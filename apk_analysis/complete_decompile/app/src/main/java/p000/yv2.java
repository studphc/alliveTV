package p000;

import com.google.common.graph.SuccessorsFunction;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class yv2 extends ge3 {

    /* renamed from: b */
    public final /* synthetic */ HashSet f29147b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yv2(SuccessorsFunction successorsFunction, HashSet hashSet) {
        super(successorsFunction);
        this.f29147b = hashSet;
    }

    @Override // p000.ge3
    /* renamed from: f */
    public final Object mo4946f(ArrayDeque arrayDeque) {
        Iterator it = (Iterator) arrayDeque.getFirst();
        while (it.hasNext()) {
            Object next = it.next();
            Objects.requireNonNull(next);
            if (this.f29147b.add(next)) {
                return next;
            }
        }
        arrayDeque.removeFirst();
        return null;
    }
}
