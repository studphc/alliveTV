package p000;

import com.google.common.util.concurrent.AbstractC1022u;
import java.util.Set;

/* renamed from: i7 */
/* loaded from: classes2.dex */
public final class C1296i7 extends p63 {
    @Override // p000.p63
    /* renamed from: v */
    public final void mo5038v(AbstractC1022u abstractC1022u, Set set) {
        synchronized (abstractC1022u) {
            if (abstractC1022u.f15435h == null) {
                abstractC1022u.f15435h = set;
            }
        }
    }

    @Override // p000.p63
    /* renamed from: y */
    public final int mo5039y(AbstractC1022u abstractC1022u) {
        int i;
        synchronized (abstractC1022u) {
            i = abstractC1022u.f15436i - 1;
            abstractC1022u.f15436i = i;
        }
        return i;
    }
}
