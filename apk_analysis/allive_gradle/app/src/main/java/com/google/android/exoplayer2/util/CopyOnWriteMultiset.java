package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class CopyOnWriteMultiset<E> implements Iterable<E> {

    /* renamed from: a */
    public final Object f12677a = new Object();

    /* renamed from: b */
    public final HashMap f12678b = new HashMap();

    /* renamed from: c */
    public Set f12679c = Collections.emptySet();

    /* renamed from: d */
    public List f12680d = Collections.emptyList();

    public void add(E e) {
        synchronized (this.f12677a) {
            try {
                ArrayList arrayList = new ArrayList(this.f12680d);
                arrayList.add(e);
                this.f12680d = Collections.unmodifiableList(arrayList);
                Integer num = (Integer) this.f12678b.get(e);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.f12679c);
                    hashSet.add(e);
                    this.f12679c = Collections.unmodifiableSet(hashSet);
                }
                HashMap hashMap = this.f12678b;
                int i = 1;
                if (num != null) {
                    i = 1 + num.intValue();
                }
                hashMap.put(e, Integer.valueOf(i));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int count(E e) {
        int i;
        synchronized (this.f12677a) {
            try {
                if (this.f12678b.containsKey(e)) {
                    i = ((Integer) this.f12678b.get(e)).intValue();
                } else {
                    i = 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public Set<E> elementSet() {
        Set<E> set;
        synchronized (this.f12677a) {
            set = this.f12679c;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.f12677a) {
            it = this.f12680d.iterator();
        }
        return it;
    }

    public void remove(E e) {
        synchronized (this.f12677a) {
            try {
                Integer num = (Integer) this.f12678b.get(e);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.f12680d);
                arrayList.remove(e);
                this.f12680d = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.f12678b.remove(e);
                    HashSet hashSet = new HashSet(this.f12679c);
                    hashSet.remove(e);
                    this.f12679c = Collections.unmodifiableSet(hashSet);
                } else {
                    this.f12678b.put(e, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
