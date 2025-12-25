package p000;

import com.google.common.collect.AbstractIterator;
import com.google.common.graph.SuccessorsFunction;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class aw2 extends AbstractIterator {

    /* renamed from: c */
    public final /* synthetic */ ArrayDeque f7772c;

    /* renamed from: d */
    public final /* synthetic */ int f7773d;

    /* renamed from: e */
    public final /* synthetic */ ge3 f7774e;

    public aw2(ge3 ge3Var, ArrayDeque arrayDeque, int i) {
        this.f7774e = ge3Var;
        this.f7772c = arrayDeque;
        this.f7773d = i;
    }

    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        ArrayDeque arrayDeque;
        do {
            arrayDeque = this.f7772c;
            ge3 ge3Var = this.f7774e;
            Object mo4946f = ge3Var.mo4946f(arrayDeque);
            if (mo4946f != null) {
                Iterator it = ((SuccessorsFunction) ge3Var.f17677a).successors(mo4946f).iterator();
                if (it.hasNext()) {
                    if (this.f7773d != 1) {
                        arrayDeque.addLast(it);
                    } else {
                        arrayDeque.addFirst(it);
                    }
                }
                return mo4946f;
            }
        } while (!arrayDeque.isEmpty());
        return endOfData();
    }
}
