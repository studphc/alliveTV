package p000;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class xf1 extends WeakReference implements wf1 {

    /* renamed from: a */
    public final cf1 f28537a;

    public xf1(ReferenceQueue referenceQueue, Object obj, cf1 cf1Var) {
        super(obj, referenceQueue);
        this.f28537a = cf1Var;
    }

    @Override // p000.wf1
    /* renamed from: a */
    public final cf1 mo8054a() {
        return this.f28537a;
    }

    @Override // p000.wf1
    /* renamed from: b */
    public final wf1 mo8055b(ReferenceQueue referenceQueue, vf1 vf1Var) {
        return new xf1(referenceQueue, get(), vf1Var);
    }
}
