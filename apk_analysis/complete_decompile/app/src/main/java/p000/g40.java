package p000;

import com.google.common.graph.C0963b;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class g40 extends AbstractSet {

    /* renamed from: a */
    public final /* synthetic */ int f17541a;

    /* renamed from: b */
    public final /* synthetic */ C0963b f17542b;

    public /* synthetic */ g40(C0963b c0963b, int i) {
        this.f17541a = i;
        this.f17542b = c0963b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f17541a) {
            case 0:
                return this.f17542b.f15046a.containsKey(obj);
            case 1:
                Object obj2 = this.f17542b.f15046a.get(obj);
                if (obj2 != C0963b.f15045e && !(obj2 instanceof k40)) {
                    return false;
                }
                return true;
            default:
                Object obj3 = this.f17542b.f15046a.get(obj);
                if (obj3 != C0963b.f15045e && obj3 != null) {
                    return true;
                }
                return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.AbstractCollection, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.AbstractCollection, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.AbstractCollection, java.util.List] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f17541a) {
            case 0:
                return new C0566bq(this.f17542b.f15047b.iterator(), new HashSet(), 1);
            case 1:
                C0963b c0963b = this.f17542b;
                ?? r1 = c0963b.f15047b;
                if (r1 == 0) {
                    return new C0528ap(c0963b.f15046a.entrySet().iterator(), 1);
                }
                return new C0528ap(r1.iterator(), 2);
            default:
                C0963b c0963b2 = this.f17542b;
                ?? r12 = c0963b2.f15047b;
                if (r12 == 0) {
                    return new C0528ap(c0963b2.f15046a.entrySet().iterator(), 3);
                }
                return new C0528ap(r12.iterator(), 4);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f17541a) {
            case 0:
                return this.f17542b.f15046a.size();
            case 1:
                return this.f17542b.f15048c;
            default:
                return this.f17542b.f15049d;
        }
    }
}
