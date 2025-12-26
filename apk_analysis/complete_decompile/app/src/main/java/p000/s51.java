package p000;

import java.util.Enumeration;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class s51 implements Enumeration {

    /* renamed from: a */
    public final /* synthetic */ Iterator f26249a;

    public s51(Iterator it) {
        this.f26249a = it;
    }

    @Override // java.util.Enumeration
    public final boolean hasMoreElements() {
        return this.f26249a.hasNext();
    }

    @Override // java.util.Enumeration
    public final Object nextElement() {
        return this.f26249a.next();
    }
}
