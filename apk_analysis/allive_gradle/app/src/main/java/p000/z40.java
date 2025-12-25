package p000;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Queue;

/* loaded from: classes.dex */
public final class z40 extends a50 {

    /* renamed from: a */
    public final C1851tx f29242a = new C1851tx(1);

    /* renamed from: b */
    public final C1851tx f29243b = new C1851tx(2);

    @Override // p000.a50
    /* renamed from: a */
    public final void mo20a(Iterator it, Object obj) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(it);
        C1851tx c1851tx = this.f29242a;
        Queue queue = (Queue) c1851tx.get();
        queue.offer(new y40(it, obj));
        C1851tx c1851tx2 = this.f29243b;
        if (!((Boolean) c1851tx2.get()).booleanValue()) {
            c1851tx2.set(Boolean.TRUE);
            while (true) {
                try {
                    y40 y40Var = (y40) queue.poll();
                    if (y40Var != null) {
                        Iterator it2 = y40Var.f28836b;
                        while (it2.hasNext()) {
                            aq2 aq2Var = (aq2) it2.next();
                            Object obj2 = y40Var.f28835a;
                            aq2Var.getClass();
                            aq2Var.f7714d.execute(new wg2(2, aq2Var, obj2));
                        }
                    } else {
                        return;
                    }
                } finally {
                    c1851tx2.remove();
                    c1851tx.remove();
                }
            }
        }
    }
}
