package p000;

import com.google.common.base.Predicates;
import com.google.common.collect.C0855c3;
import com.google.common.collect.LinkedListMultimap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class v81 extends oh2 {

    /* renamed from: a */
    public final /* synthetic */ int f27669a;

    /* renamed from: b */
    public final /* synthetic */ Object f27670b;

    public /* synthetic */ v81(int i, Object obj) {
        this.f27669a = i;
        this.f27670b = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        switch (this.f27669a) {
            case 1:
                ((ig1) this.f27670b).m5239g(Predicates.alwaysTrue());
                return;
            default:
                super.clear();
                return;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f27669a) {
            case 0:
                return ((LinkedListMultimap) this.f27670b).containsKey(obj);
            default:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                ig1 ig1Var = (ig1) this.f27670b;
                C0855c3 c0855c3 = (C0855c3) ig1Var.f18405f;
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    if (!value.equals(c0855c3.get(key, ig1Var.f18404e))) {
                        return false;
                    }
                    return true;
                }
                c0855c3.getClass();
                return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        switch (this.f27669a) {
            case 1:
                ig1 ig1Var = (ig1) this.f27670b;
                return !((C0855c3) ig1Var.f18405f).containsColumn(ig1Var.f18404e);
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f27669a) {
            case 0:
                return new x81((LinkedListMultimap) this.f27670b);
            default:
                return new C0566bq((ig1) this.f27670b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean remove(Object obj) {
        boolean z;
        switch (this.f27669a) {
            case 0:
                return !((LinkedListMultimap) this.f27670b).removeAll(obj).isEmpty();
            default:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                ig1 ig1Var = (ig1) this.f27670b;
                C0855c3 c0855c3 = (C0855c3) ig1Var.f18405f;
                Object key = entry.getKey();
                Object value = entry.getValue();
                Object obj2 = ig1Var.f18404e;
                if (value != null) {
                    if (value.equals(c0855c3.get(key, obj2))) {
                        z = true;
                        if (z) {
                            return false;
                        }
                        c0855c3.remove(key, obj2);
                        return true;
                    }
                } else {
                    c0855c3.getClass();
                }
                z = false;
                if (z) {
                }
        }
    }

    @Override // p000.oh2, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        switch (this.f27669a) {
            case 1:
                return ((ig1) this.f27670b).m5239g(Predicates.not(Predicates.m3777in(collection)));
            default:
                return super.retainAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f27669a) {
            case 0:
                return ((LinkedListMultimap) this.f27670b).f14727h.size();
            default:
                ig1 ig1Var = (ig1) this.f27670b;
                Iterator it = ((C0855c3) ig1Var.f18405f).f14788c.values().iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (((Map) it.next()).containsKey(ig1Var.f18404e)) {
                        i++;
                    }
                }
                return i;
        }
    }
}
