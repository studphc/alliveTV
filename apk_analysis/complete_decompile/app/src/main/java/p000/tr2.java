package p000;

import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import java.util.Set;

/* loaded from: classes.dex */
public class tr2 extends mr2 implements SetMultimap {
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public transient sr2 f26947h;

    @Override // p000.mr2
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public SetMultimap mo5783e() {
        return (SetMultimap) ((Multimap) this.f25272a);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [pr2, sr2] */
    @Override // p000.mr2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Set entries() {
        sr2 sr2Var;
        synchronized (this.f25273b) {
            try {
                if (this.f26947h == null) {
                    this.f26947h = new pr2(mo5783e().entries(), this.f25273b);
                }
                sr2Var = this.f26947h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sr2Var;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [pr2, java.util.Set] */
    @Override // p000.mr2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Set get(Object obj) {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(mo5783e().get((SetMultimap) obj), this.f25273b);
        }
        return pr2Var;
    }

    @Override // p000.mr2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Set removeAll(Object obj) {
        Set removeAll;
        synchronized (this.f25273b) {
            removeAll = mo5783e().removeAll(obj);
        }
        return removeAll;
    }

    @Override // p000.mr2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Set replaceValues(Object obj, Iterable iterable) {
        Set replaceValues;
        synchronized (this.f25273b) {
            replaceValues = mo5783e().replaceValues((SetMultimap) obj, iterable);
        }
        return replaceValues;
    }
}
