package p000;

import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public final class tf1 extends ze1 implements vf1 {

    /* renamed from: c */
    public volatile wf1 f26802c;

    public tf1(ReferenceQueue referenceQueue, Object obj, int i, tf1 tf1Var) {
        super(referenceQueue, obj, i, tf1Var);
        this.f26802c = zf1.f29349j;
    }

    @Override // p000.vf1
    /* renamed from: b */
    public final wf1 mo6348b() {
        return this.f26802c;
    }

    @Override // p000.cf1
    public final Object getValue() {
        return this.f26802c.get();
    }
}
