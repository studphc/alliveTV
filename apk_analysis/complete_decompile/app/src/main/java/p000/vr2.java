package p000;

import java.util.Comparator;
import java.util.SortedSet;

/* loaded from: classes.dex */
public class vr2 extends sr2 implements SortedSet {
    private static final long serialVersionUID = 0;

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        Comparator comparator;
        synchronized (this.f25273b) {
            comparator = mo4086e().comparator();
        }
        return comparator;
    }

    @Override // java.util.SortedSet
    public final Object first() {
        Object first;
        synchronized (this.f25273b) {
            first = mo4086e().first();
        }
        return first;
    }

    @Override // p000.sr2
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public SortedSet mo4086e() {
        return (SortedSet) super.mo4086e();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [pr2, java.util.SortedSet] */
    public SortedSet headSet(Object obj) {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(mo4086e().headSet(obj), this.f25273b);
        }
        return pr2Var;
    }

    @Override // java.util.SortedSet
    public final Object last() {
        Object last;
        synchronized (this.f25273b) {
            last = mo4086e().last();
        }
        return last;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [pr2, java.util.SortedSet] */
    public SortedSet subSet(Object obj, Object obj2) {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(mo4086e().subSet(obj, obj2), this.f25273b);
        }
        return pr2Var;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [pr2, java.util.SortedSet] */
    public SortedSet tailSet(Object obj) {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(mo4086e().tailSet(obj), this.f25273b);
        }
        return pr2Var;
    }
}
