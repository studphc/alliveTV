package p000;

import com.google.android.gms.internal.measurement.zzmr;
import com.google.android.gms.internal.measurement.zznh;
import java.util.Map;

/* loaded from: classes.dex */
public final class jd3 implements Map.Entry {

    /* renamed from: a */
    public final Map.Entry f20475a;

    public /* synthetic */ jd3(Map.Entry entry) {
        this.f20475a = entry;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f20475a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((zzmr) this.f20475a.getValue()) == null) {
            return null;
        }
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zznh) {
            return ((zzmr) this.f20475a.getValue()).zzc((zznh) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
