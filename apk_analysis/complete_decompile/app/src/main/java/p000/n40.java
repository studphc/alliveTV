package p000;

import com.google.common.collect.BiMap;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public final class n40 extends AbstractC2039z {
    @Override // p000.mr1
    /* renamed from: b */
    public final Set mo4902b() {
        return Collections.unmodifiableSet(((BiMap) this.f29204b).values());
    }

    @Override // p000.mr1
    /* renamed from: c */
    public final Set mo4903c() {
        return Collections.unmodifiableSet(((BiMap) this.f29203a).values());
    }

    @Override // p000.mr1
    /* renamed from: k */
    public final Set mo6050k(Object obj) {
        return new x70(((BiMap) this.f29204b).inverse(), obj);
    }
}
