package p000;

import com.google.common.collect.HashBiMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class jz0 implements Iterator {

    /* renamed from: a */
    public int f20690a;

    /* renamed from: b */
    public int f20691b;

    /* renamed from: c */
    public int f20692c;

    /* renamed from: d */
    public int f20693d;

    /* renamed from: e */
    public final /* synthetic */ kz0 f20694e;

    public jz0(kz0 kz0Var) {
        this.f20694e = kz0Var;
        HashBiMap hashBiMap = (HashBiMap) kz0Var.f22253b;
        this.f20690a = hashBiMap.f14650i;
        this.f20691b = -1;
        this.f20692c = hashBiMap.f14645d;
        this.f20693d = hashBiMap.f14644c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (((HashBiMap) this.f20694e.f22253b).f14645d == this.f20692c) {
            if (this.f20690a != -2 && this.f20693d > 0) {
                return true;
            }
            return false;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            int i = this.f20690a;
            kz0 kz0Var = this.f20694e;
            Object mo5027a = kz0Var.mo5027a(i);
            int i2 = this.f20690a;
            this.f20691b = i2;
            this.f20690a = ((HashBiMap) kz0Var.f22253b).f14653l[i2];
            this.f20693d--;
            return mo5027a;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z;
        kz0 kz0Var = this.f20694e;
        if (((HashBiMap) kz0Var.f22253b).f14645d == this.f20692c) {
            if (this.f20691b != -1) {
                z = true;
            } else {
                z = false;
            }
            p63.m6876t(z);
            HashBiMap hashBiMap = (HashBiMap) kz0Var.f22253b;
            int i = this.f20691b;
            hashBiMap.m3876p(i, o63.m6454N(hashBiMap.f14642a[i]));
            int i2 = this.f20690a;
            HashBiMap hashBiMap2 = (HashBiMap) kz0Var.f22253b;
            if (i2 == hashBiMap2.f14644c) {
                this.f20690a = this.f20691b;
            }
            this.f20691b = -1;
            this.f20692c = hashBiMap2.f14645d;
            return;
        }
        throw new ConcurrentModificationException();
    }
}
