package p000;

import com.google.gson.internal.LinkedTreeMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class d91 extends AbstractSet {

    /* renamed from: a */
    public final /* synthetic */ int f16300a;

    /* renamed from: b */
    public final /* synthetic */ LinkedTreeMap f16301b;

    public /* synthetic */ d91(LinkedTreeMap linkedTreeMap, int i) {
        this.f16300a = i;
        this.f16301b = linkedTreeMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f16300a) {
            case 0:
                this.f16301b.clear();
                return;
            default:
                this.f16301b.clear();
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean contains(Object obj) {
        e91 m4421a;
        switch (this.f16300a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                LinkedTreeMap linkedTreeMap = this.f16301b;
                linkedTreeMap.getClass();
                Object key = entry.getKey();
                e91 e91Var = null;
                if (key != null) {
                    try {
                        m4421a = linkedTreeMap.m4421a(key, false);
                    } catch (ClassCastException unused) {
                    }
                    if (m4421a != null && Objects.equals(m4421a.f16724h, entry.getValue())) {
                        e91Var = m4421a;
                    }
                    if (e91Var != null) {
                        return false;
                    }
                    return true;
                }
                m4421a = null;
                if (m4421a != null) {
                    e91Var = m4421a;
                }
                if (e91Var != null) {
                }
            default:
                return this.f16301b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f16300a) {
            case 0:
                return new c91(this.f16301b, 0);
            default:
                return new c91(this.f16301b, 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean remove(Object obj) {
        e91 m4421a;
        switch (this.f16300a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                LinkedTreeMap linkedTreeMap = this.f16301b;
                linkedTreeMap.getClass();
                Object key = entry.getKey();
                e91 e91Var = null;
                if (key != null) {
                    try {
                        m4421a = linkedTreeMap.m4421a(key, false);
                    } catch (ClassCastException unused) {
                    }
                    if (m4421a != null && Objects.equals(m4421a.f16724h, entry.getValue())) {
                        e91Var = m4421a;
                    }
                    if (e91Var != null) {
                        return false;
                    }
                    linkedTreeMap.m4423e(e91Var, true);
                    return true;
                }
                m4421a = null;
                if (m4421a != null) {
                    e91Var = m4421a;
                }
                if (e91Var != null) {
                }
            default:
                LinkedTreeMap linkedTreeMap2 = this.f16301b;
                linkedTreeMap2.getClass();
                e91 e91Var2 = null;
                if (obj != null) {
                    try {
                        e91Var2 = linkedTreeMap2.m4421a(obj, false);
                    } catch (ClassCastException unused2) {
                    }
                }
                if (e91Var2 != null) {
                    linkedTreeMap2.m4423e(e91Var2, true);
                }
                if (e91Var2 == null) {
                    return false;
                }
                return true;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f16300a) {
            case 0:
                return this.f16301b.f15732d;
            default:
                return this.f16301b.f15732d;
        }
    }
}
