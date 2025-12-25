package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.MinMaxPriorityQueue;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class ho1 implements Iterator {

    /* renamed from: a */
    public int f18111a = -1;

    /* renamed from: b */
    public int f18112b = -1;

    /* renamed from: c */
    public int f18113c;

    /* renamed from: d */
    public ArrayDeque f18114d;

    /* renamed from: e */
    public ArrayList f18115e;

    /* renamed from: f */
    public Object f18116f;

    /* renamed from: g */
    public boolean f18117g;

    /* renamed from: h */
    public final /* synthetic */ MinMaxPriorityQueue f18118h;

    public ho1(MinMaxPriorityQueue minMaxPriorityQueue) {
        this.f18118h = minMaxPriorityQueue;
        this.f18113c = minMaxPriorityQueue.f14741f;
    }

    /* renamed from: a */
    public static boolean m5119a(AbstractCollection abstractCollection, Object obj) {
        Iterator it = abstractCollection.iterator();
        while (it.hasNext()) {
            if (it.next() == obj) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final void m5120b(int i) {
        if (this.f18112b < i) {
            if (this.f18115e != null) {
                while (true) {
                    MinMaxPriorityQueue minMaxPriorityQueue = this.f18118h;
                    if (i >= minMaxPriorityQueue.size() || !m5119a(this.f18115e, minMaxPriorityQueue.m4054a(i))) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            this.f18112b = i;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        MinMaxPriorityQueue minMaxPriorityQueue = this.f18118h;
        if (minMaxPriorityQueue.f14741f == this.f18113c) {
            m5120b(this.f18111a + 1);
            if (this.f18112b < minMaxPriorityQueue.size()) {
                return true;
            }
            ArrayDeque arrayDeque = this.f18114d;
            if (arrayDeque != null && !arrayDeque.isEmpty()) {
                return true;
            }
            return false;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final Object next() {
        MinMaxPriorityQueue minMaxPriorityQueue = this.f18118h;
        if (minMaxPriorityQueue.f14741f == this.f18113c) {
            m5120b(this.f18111a + 1);
            if (this.f18112b < minMaxPriorityQueue.size()) {
                int i = this.f18112b;
                this.f18111a = i;
                this.f18117g = true;
                return minMaxPriorityQueue.m4054a(i);
            }
            if (this.f18114d != null) {
                this.f18111a = minMaxPriorityQueue.size();
                Object poll = this.f18114d.poll();
                this.f18116f = poll;
                if (poll != null) {
                    this.f18117g = true;
                    return poll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        p63.m6876t(this.f18117g);
        MinMaxPriorityQueue minMaxPriorityQueue = this.f18118h;
        int i = minMaxPriorityQueue.f14741f;
        int i2 = this.f18113c;
        if (i == i2) {
            boolean z = false;
            this.f18117g = false;
            this.f18113c = i2 + 1;
            if (this.f18111a < minMaxPriorityQueue.size()) {
                ag1 m4057d = minMaxPriorityQueue.m4057d(this.f18111a);
                if (m4057d != null) {
                    if (this.f18114d == null || this.f18115e == null) {
                        this.f18114d = new ArrayDeque();
                        this.f18115e = new ArrayList(3);
                    }
                    ArrayList arrayList = this.f18115e;
                    Object obj = m4057d.f180a;
                    if (!m5119a(arrayList, obj)) {
                        this.f18114d.add(obj);
                    }
                    ArrayDeque arrayDeque = this.f18114d;
                    Object obj2 = m4057d.f181b;
                    if (!m5119a(arrayDeque, obj2)) {
                        this.f18115e.add(obj2);
                    }
                }
                this.f18111a--;
                this.f18112b--;
                return;
            }
            Object obj3 = this.f18116f;
            Objects.requireNonNull(obj3);
            int i3 = 0;
            while (true) {
                if (i3 >= minMaxPriorityQueue.f14740e) {
                    break;
                }
                if (minMaxPriorityQueue.f14739d[i3] == obj3) {
                    minMaxPriorityQueue.m4057d(i3);
                    z = true;
                    break;
                }
                i3++;
            }
            Preconditions.checkState(z);
            this.f18116f = null;
            return;
        }
        throw new ConcurrentModificationException();
    }
}
