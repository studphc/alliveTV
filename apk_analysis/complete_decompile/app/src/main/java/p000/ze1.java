package p000;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class ze1 extends WeakReference implements cf1 {

    /* renamed from: a */
    public final int f29337a;

    /* renamed from: b */
    public final cf1 f29338b;

    public ze1(ReferenceQueue referenceQueue, Object obj, int i, cf1 cf1Var) {
        super(obj, referenceQueue);
        this.f29337a = i;
        this.f29338b = cf1Var;
    }

    @Override // p000.cf1
    /* renamed from: a */
    public final cf1 mo2229a() {
        return this.f29338b;
    }

    @Override // p000.cf1
    /* renamed from: c */
    public final int mo2230c() {
        return this.f29337a;
    }

    @Override // p000.cf1
    public final Object getKey() {
        return get();
    }
}
