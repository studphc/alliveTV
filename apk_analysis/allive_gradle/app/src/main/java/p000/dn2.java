package p000;

import com.google.common.collect.C0855c3;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class dn2 extends ih1 {

    /* renamed from: d */
    public final /* synthetic */ int f16445d;

    /* renamed from: e */
    public final /* synthetic */ C0855c3 f16446e;

    public /* synthetic */ dn2(C0855c3 c0855c3, int i) {
        this.f16445d = i;
        this.f16446e = c0855c3;
    }

    @Override // p000.ih1
    /* renamed from: a */
    public final Set mo4593a() {
        switch (this.f16445d) {
            case 0:
                return new cn2(this);
            default:
                return new cn2(this, (byte) 0);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        switch (this.f16445d) {
            case 0:
                return this.f16446e.containsColumn(obj);
            default:
                return this.f16446e.containsRow(obj);
        }
    }

    @Override // p000.ih1
    /* renamed from: e */
    public Collection mo4594e() {
        switch (this.f16445d) {
            case 0:
                return new jd0(this, 2);
            default:
                return super.mo4594e();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        switch (this.f16445d) {
            case 0:
                C0855c3 c0855c3 = this.f16446e;
                if (c0855c3.containsColumn(obj)) {
                    Objects.requireNonNull(obj);
                    return c0855c3.column(obj);
                }
                return null;
            default:
                C0855c3 c0855c32 = this.f16446e;
                if (c0855c32.containsRow(obj)) {
                    Objects.requireNonNull(obj);
                    return c0855c32.row(obj);
                }
                return null;
        }
    }

    @Override // p000.ih1, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set keySet() {
        switch (this.f16445d) {
            case 0:
                return this.f16446e.columnKeySet();
            default:
                return super.keySet();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        switch (this.f16445d) {
            case 0:
                C0855c3 c0855c3 = this.f16446e;
                if (c0855c3.containsColumn(obj)) {
                    return C0855c3.m4085e(c0855c3, obj);
                }
                return null;
            default:
                if (obj == null) {
                    return null;
                }
                return (Map) this.f16446e.f14788c.remove(obj);
        }
    }
}
