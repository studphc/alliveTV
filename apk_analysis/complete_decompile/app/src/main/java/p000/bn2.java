package p000;

import com.google.common.base.Preconditions;
import java.util.Map;

/* loaded from: classes.dex */
public final class bn2 extends AbstractC2041z1 {

    /* renamed from: a */
    public final /* synthetic */ Map.Entry f8102a;

    /* renamed from: b */
    public final /* synthetic */ C0566bq f8103b;

    public bn2(C0566bq c0566bq, Map.Entry entry) {
        this.f8103b = c0566bq;
        this.f8102a = entry;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f8102a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return ((Map) this.f8102a.getValue()).get(((ig1) this.f8103b.f8125e).f18404e);
    }

    @Override // p000.AbstractC2041z1, java.util.Map.Entry
    public final Object setValue(Object obj) {
        return ((Map) this.f8102a.getValue()).put(((ig1) this.f8103b.f8125e).f18404e, Preconditions.checkNotNull(obj));
    }
}
