package p000;

import java.util.Iterator;
import java.util.NavigableMap;

/* renamed from: g2 */
/* loaded from: classes.dex */
public final class C1217g2 extends kg1 {

    /* renamed from: d */
    public final /* synthetic */ AbstractC1254h2 f17527d;

    public C1217g2(AbstractC1254h2 abstractC1254h2) {
        this.f17527d = abstractC1254h2;
    }

    @Override // p000.kg1
    /* renamed from: e */
    public final NavigableMap mo3861e() {
        return this.f17527d;
    }

    @Override // p000.kg1
    public final Iterator entryIterator() {
        return this.f17527d.mo85c();
    }
}
