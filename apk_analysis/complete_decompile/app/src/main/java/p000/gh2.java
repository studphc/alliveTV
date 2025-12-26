package p000;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.C0855c3;
import com.google.common.collect.C0928r2;
import com.google.common.collect.C0940u2;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.SuccessorsFunction;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class gh2 extends AbstractIterator {

    /* renamed from: c */
    public final /* synthetic */ int f17697c;

    /* renamed from: d */
    public Object f17698d;

    /* renamed from: e */
    public Object f17699e;

    /* renamed from: f */
    public final Object f17700f;

    public /* synthetic */ gh2(Object obj, Object obj2, Object obj3, int i) {
        this.f17697c = i;
        this.f17700f = obj;
        this.f17698d = obj2;
        this.f17699e = obj3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0002. Please report as an issue. */
    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        Object next;
        C0940u2 c0940u2;
        Object next2;
        Object next3;
        E next4;
        Object obj;
        switch (this.f17697c) {
            case 0:
                Iterator it = (Iterator) this.f17698d;
                if (it.hasNext()) {
                    return it.next();
                }
                do {
                    Iterator it2 = (Iterator) this.f17699e;
                    if (it2.hasNext()) {
                        next = it2.next();
                    } else {
                        return endOfData();
                    }
                } while (((C0928r2) this.f17700f).f14948a.contains(next));
                return next;
            case 1:
                do {
                    Iterator it3 = (Iterator) this.f17698d;
                    boolean hasNext = it3.hasNext();
                    c0940u2 = (C0940u2) this.f17700f;
                    if (hasNext) {
                        next3 = it3.next();
                    } else {
                        do {
                            Iterator it4 = (Iterator) this.f17699e;
                            if (it4.hasNext()) {
                                next2 = it4.next();
                            } else {
                                return endOfData();
                            }
                        } while (c0940u2.f14973a.contains(next2));
                        return next2;
                    }
                } while (c0940u2.f14974b.contains(next3));
                return next3;
            case 2:
                while (true) {
                    if (((Iterator) this.f17699e).hasNext()) {
                        Map.Entry entry = (Map.Entry) ((Iterator) this.f17699e).next();
                        Object key = entry.getKey();
                        Map map = (Map) this.f17700f;
                        if (!map.containsKey(key)) {
                            map.put(entry.getKey(), entry.getValue());
                            return entry.getKey();
                        }
                    } else {
                        Iterator it5 = (Iterator) this.f17698d;
                        if (it5.hasNext()) {
                            this.f17699e = ((Map) it5.next()).entrySet().iterator();
                        } else {
                            return endOfData();
                        }
                    }
                }
            case 3:
                ge3 ge3Var = (ge3) this.f17700f;
                ArrayDeque arrayDeque = (ArrayDeque) this.f17698d;
                while (true) {
                    Object mo4946f = ge3Var.mo4946f(arrayDeque);
                    ArrayDeque arrayDeque2 = (ArrayDeque) this.f17699e;
                    if (mo4946f != null) {
                        Iterator it6 = ((SuccessorsFunction) ge3Var.f17677a).successors(mo4946f).iterator();
                        if (it6.hasNext()) {
                            arrayDeque.addFirst(it6);
                            arrayDeque2.push(mo4946f);
                        } else {
                            return mo4946f;
                        }
                    } else {
                        if (!arrayDeque2.isEmpty()) {
                            return arrayDeque2.pop();
                        }
                        return endOfData();
                    }
                }
            case 4:
                do {
                    UnmodifiableIterator unmodifiableIterator = (UnmodifiableIterator) this.f17699e;
                    if (unmodifiableIterator.hasNext()) {
                        next4 = unmodifiableIterator.next();
                        obj = this.f17698d;
                        if (obj != null) {
                        }
                        this.f17698d = next4;
                        return next4;
                    }
                    this.f17698d = null;
                    return endOfData();
                } while (((Comparator) this.f17700f).compare(next4, obj) == 0);
                this.f17698d = next4;
                return next4;
            default:
                Iterator it7 = (Iterator) this.f17698d;
                if (!it7.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range = (Range) it7.next();
                if (((AbstractC1814sx) this.f17699e).mo6741h(range.f14747a)) {
                    return (Map.Entry) endOfData();
                }
                Range intersection = range.intersection(((pw2) this.f17700f).f25326b);
                return Maps.immutableEntry(intersection.f14747a, intersection);
        }
    }

    public gh2(UnmodifiableIterator unmodifiableIterator, Comparator comparator) {
        this.f17697c = 4;
        this.f17699e = unmodifiableIterator;
        this.f17700f = comparator;
    }

    public gh2(C0928r2 c0928r2) {
        this.f17697c = 0;
        this.f17700f = c0928r2;
        this.f17698d = c0928r2.f14948a.iterator();
        this.f17699e = c0928r2.f14949b.iterator();
    }

    public gh2(C0855c3 c0855c3) {
        this.f17697c = 2;
        this.f17700f = (Map) c0855c3.f14789d.get();
        this.f17698d = c0855c3.f14788c.values().iterator();
        this.f17699e = z51.f29250d;
    }
}
