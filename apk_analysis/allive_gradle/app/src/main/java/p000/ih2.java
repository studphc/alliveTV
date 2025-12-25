package p000;

import com.google.common.collect.ImmutableMap;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class ih2 extends AbstractSet {

    /* renamed from: a */
    public final /* synthetic */ int f18414a = 0;

    /* renamed from: b */
    public final ImmutableMap f18415b;

    /* renamed from: c */
    public final int f18416c;

    public ih2(ImmutableMap immutableMap, int i) {
        this.f18415b = immutableMap;
        this.f18416c = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f18414a) {
            case 0:
                if (!(obj instanceof Set)) {
                    return false;
                }
                Set set = (Set) obj;
                if (set.size() != this.f18416c || !this.f18415b.keySet().containsAll(set)) {
                    return false;
                }
                return true;
            default:
                Integer num = (Integer) this.f18415b.get(obj);
                if (num != null && ((1 << num.intValue()) & this.f18416c) != 0) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f18414a) {
            case 0:
                return new C0566bq(this);
            default:
                return new u51(this);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f18414a) {
            case 0:
                return IntMath.binomial(this.f18415b.size(), this.f18416c);
            default:
                return Integer.bitCount(this.f18416c);
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        switch (this.f18414a) {
            case 0:
                String valueOf = String.valueOf(this.f18415b.keySet());
                StringBuilder sb = new StringBuilder(valueOf.length() + 32);
                sb.append("Sets.combinations(");
                sb.append(valueOf);
                sb.append(", ");
                sb.append(this.f18416c);
                sb.append(")");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public ih2(int i, ImmutableMap immutableMap) {
        this.f18416c = i;
        this.f18415b = immutableMap;
    }
}
