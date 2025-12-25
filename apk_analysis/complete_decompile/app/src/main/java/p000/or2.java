package p000;

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes.dex */
public final class or2 extends vr2 implements NavigableSet {
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    public transient or2 f24882c;

    @Override // java.util.NavigableSet
    public final Object ceiling(Object obj) {
        Object ceiling;
        synchronized (this.f25273b) {
            ceiling = ((NavigableSet) super.mo4086e()).ceiling(obj);
        }
        return ceiling;
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return ((NavigableSet) super.mo4086e()).descendingIterator();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [pr2, java.util.NavigableSet, or2] */
    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        synchronized (this.f25273b) {
            try {
                or2 or2Var = this.f24882c;
                if (or2Var == null) {
                    ?? pr2Var = new pr2(((NavigableSet) super.mo4086e()).descendingSet(), this.f25273b);
                    this.f24882c = pr2Var;
                    return pr2Var;
                }
                return or2Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.vr2, p000.sr2, p000.gr2
    /* renamed from: e */
    public final Collection mo4086e() {
        return (NavigableSet) super.mo4086e();
    }

    @Override // p000.vr2, p000.sr2
    /* renamed from: f */
    public final Set mo4086e() {
        return (NavigableSet) super.mo4086e();
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object obj) {
        Object floor;
        synchronized (this.f25273b) {
            floor = ((NavigableSet) super.mo4086e()).floor(obj);
        }
        return floor;
    }

    @Override // p000.vr2
    /* renamed from: g */
    public final SortedSet mo4086e() {
        return (NavigableSet) super.mo4086e();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [pr2, java.util.NavigableSet] */
    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z) {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(((NavigableSet) super.mo4086e()).headSet(obj, z), this.f25273b);
        }
        return pr2Var;
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object obj) {
        Object higher;
        synchronized (this.f25273b) {
            higher = ((NavigableSet) super.mo4086e()).higher(obj);
        }
        return higher;
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object obj) {
        Object lower;
        synchronized (this.f25273b) {
            lower = ((NavigableSet) super.mo4086e()).lower(obj);
        }
        return lower;
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        Object pollFirst;
        synchronized (this.f25273b) {
            pollFirst = ((NavigableSet) super.mo4086e()).pollFirst();
        }
        return pollFirst;
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        Object pollLast;
        synchronized (this.f25273b) {
            pollLast = ((NavigableSet) super.mo4086e()).pollLast();
        }
        return pollLast;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [pr2, java.util.NavigableSet] */
    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(((NavigableSet) super.mo4086e()).subSet(obj, z, obj2, z2), this.f25273b);
        }
        return pr2Var;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [pr2, java.util.NavigableSet] */
    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z) {
        ?? pr2Var;
        synchronized (this.f25273b) {
            pr2Var = new pr2(((NavigableSet) super.mo4086e()).tailSet(obj, z), this.f25273b);
        }
        return pr2Var;
    }

    @Override // p000.vr2, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override // p000.vr2, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // p000.vr2, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }
}
