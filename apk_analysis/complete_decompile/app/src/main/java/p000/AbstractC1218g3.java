package p000;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: g3 */
/* loaded from: classes2.dex */
public abstract class AbstractC1218g3 implements mr1 {

    /* renamed from: a */
    public final Map f17536a;

    public AbstractC1218g3(Map map) {
        this.f17536a = (Map) Preconditions.checkNotNull(map);
    }

    @Override // p000.mr1
    /* renamed from: b */
    public final Set mo4902b() {
        return mo6243a();
    }

    @Override // p000.mr1
    /* renamed from: c */
    public final Set mo4903c() {
        return mo6243a();
    }

    @Override // p000.mr1
    /* renamed from: d */
    public Object mo4904d(Object obj, boolean z) {
        if (!z) {
            return mo4908h(obj);
        }
        return null;
    }

    @Override // p000.mr1
    /* renamed from: e */
    public final Set mo4905e() {
        return Collections.unmodifiableSet(this.f17536a.keySet());
    }

    @Override // p000.mr1
    /* renamed from: f */
    public final Object mo4906f(Object obj) {
        Object obj2 = this.f17536a.get(obj);
        Objects.requireNonNull(obj2);
        return obj2;
    }

    @Override // p000.mr1
    /* renamed from: g */
    public final Set mo4907g() {
        return mo4905e();
    }

    @Override // p000.mr1
    /* renamed from: h */
    public Object mo4908h(Object obj) {
        Object remove = this.f17536a.remove(obj);
        Objects.requireNonNull(remove);
        return remove;
    }

    @Override // p000.mr1
    /* renamed from: i */
    public final Set mo4909i() {
        return mo4905e();
    }

    @Override // p000.mr1
    /* renamed from: j */
    public void mo4910j(Object obj, Object obj2) {
        boolean z;
        if (this.f17536a.put(obj, obj2) == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
    }

    @Override // p000.mr1
    /* renamed from: l */
    public void mo4911l(Object obj, Object obj2, boolean z) {
        if (!z) {
            mo4910j(obj, obj2);
        }
    }
}
