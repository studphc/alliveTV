package p000;

import com.google.gson.internal.LinkedTreeMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class c91 implements Iterator {

    /* renamed from: a */
    public e91 f8294a;

    /* renamed from: b */
    public e91 f8295b = null;

    /* renamed from: c */
    public int f8296c;

    /* renamed from: d */
    public final /* synthetic */ LinkedTreeMap f8297d;

    /* renamed from: e */
    public final /* synthetic */ int f8298e;

    public c91(LinkedTreeMap linkedTreeMap, int i) {
        this.f8298e = i;
        this.f8297d = linkedTreeMap;
        this.f8294a = linkedTreeMap.f15734f.f16720d;
        this.f8296c = linkedTreeMap.f15733e;
    }

    /* renamed from: a */
    public final Object m2210a() {
        return m2211b();
    }

    /* renamed from: b */
    public final e91 m2211b() {
        e91 e91Var = this.f8294a;
        LinkedTreeMap linkedTreeMap = this.f8297d;
        if (e91Var != linkedTreeMap.f15734f) {
            if (linkedTreeMap.f15733e == this.f8296c) {
                this.f8294a = e91Var.f16720d;
                this.f8295b = e91Var;
                return e91Var;
            }
            throw new ConcurrentModificationException();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f8294a != this.f8297d.f15734f) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.f8298e) {
            case 1:
                return m2211b().f16722f;
            default:
                return m2210a();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        e91 e91Var = this.f8295b;
        if (e91Var != null) {
            LinkedTreeMap linkedTreeMap = this.f8297d;
            linkedTreeMap.m4423e(e91Var, true);
            this.f8295b = null;
            this.f8296c = linkedTreeMap.f15733e;
            return;
        }
        throw new IllegalStateException();
    }
}
