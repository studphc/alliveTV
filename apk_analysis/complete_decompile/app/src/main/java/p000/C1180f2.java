package p000;

import com.google.common.collect.AbstractC0856d;
import com.google.common.collect.Multiset;
import java.util.Iterator;

/* renamed from: f2 */
/* loaded from: classes.dex */
public final class C1180f2 extends iq1 {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0856d f17084a;

    public C1180f2(AbstractC0856d abstractC0856d) {
        this.f17084a = abstractC0856d;
    }

    @Override // p000.iq1
    /* renamed from: d */
    public final Multiset mo3860d() {
        return this.f17084a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.f17084a.mo3839c();
    }
}
