package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public final class x40 extends a50 {

    /* renamed from: a */
    public final ConcurrentLinkedQueue f28437a = Queues.newConcurrentLinkedQueue();

    @Override // p000.a50
    /* renamed from: a */
    public final void mo20a(Iterator it, Object obj) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Preconditions.checkNotNull(obj);
        while (true) {
            boolean hasNext = it.hasNext();
            concurrentLinkedQueue = this.f28437a;
            if (!hasNext) {
                break;
            } else {
                concurrentLinkedQueue.add(new w40(obj, (aq2) it.next()));
            }
        }
        while (true) {
            w40 w40Var = (w40) concurrentLinkedQueue.poll();
            if (w40Var != null) {
                aq2 aq2Var = w40Var.f28067b;
                aq2Var.getClass();
                aq2Var.f7714d.execute(new wg2(2, aq2Var, w40Var.f28066a));
            } else {
                return;
            }
        }
    }
}
