package p000;

import com.google.common.collect.BiMap;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public final class yz2 extends AbstractC1218g3 {
    @Override // p000.mr1
    /* renamed from: a */
    public final Set mo6243a() {
        return Collections.unmodifiableSet(((BiMap) this.f17536a).values());
    }

    @Override // p000.mr1
    /* renamed from: k */
    public final Set mo6050k(Object obj) {
        return new x70(((BiMap) this.f17536a).inverse(), obj);
    }
}
