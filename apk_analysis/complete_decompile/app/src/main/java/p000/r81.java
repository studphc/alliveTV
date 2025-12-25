package p000;

import com.google.common.collect.LinkedHashMultimap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public final class r81 extends oh2 implements s81 {

    /* renamed from: a */
    public final Object f25895a;

    /* renamed from: b */
    public p81[] f25896b;

    /* renamed from: c */
    public int f25897c = 0;

    /* renamed from: d */
    public int f25898d = 0;

    /* renamed from: e */
    public s81 f25899e = this;

    /* renamed from: f */
    public s81 f25900f = this;

    /* renamed from: g */
    public final /* synthetic */ LinkedHashMultimap f25901g;

    public r81(LinkedHashMultimap linkedHashMultimap, Object obj, int i) {
        this.f25901g = linkedHashMultimap;
        this.f25895a = obj;
        this.f25896b = new p81[o63.m6465h(1.0d, i)];
    }

    @Override // p000.s81
    /* renamed from: a */
    public final void mo6887a(s81 s81Var) {
        this.f25900f = s81Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [r81, s81] */
    /* JADX WARN: Type inference failed for: r1v5, types: [s81] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int m6454N = o63.m6454N(obj);
        p81[] p81VarArr = this.f25896b;
        int length = (p81VarArr.length - 1) & m6454N;
        p81 p81Var = p81VarArr[length];
        for (p81 p81Var2 = p81Var; p81Var2 != null; p81Var2 = p81Var2.f25062d) {
            if (p81Var2.m6890d(m6454N, obj)) {
                return false;
            }
        }
        p81 p81Var3 = new p81(this.f25895a, obj, m6454N, p81Var);
        s81 s81Var = this.f25900f;
        s81Var.mo6889c(p81Var3);
        p81Var3.mo6887a(s81Var);
        p81Var3.mo6889c(this);
        mo6887a(p81Var3);
        LinkedHashMultimap linkedHashMultimap = this.f25901g;
        p81 p81Var4 = linkedHashMultimap.f14724i.f25065g;
        Objects.requireNonNull(p81Var4);
        p81Var4.f25066h = p81Var3;
        p81Var3.f25065g = p81Var4;
        p81 p81Var5 = linkedHashMultimap.f14724i;
        p81Var3.f25066h = p81Var5;
        p81Var5.f25065g = p81Var3;
        p81[] p81VarArr2 = this.f25896b;
        p81VarArr2[length] = p81Var3;
        int i = this.f25897c + 1;
        this.f25897c = i;
        this.f25898d++;
        int length2 = p81VarArr2.length;
        if (i > 1.0d * length2 && length2 < 1073741824) {
            int length3 = p81VarArr2.length * 2;
            p81[] p81VarArr3 = new p81[length3];
            this.f25896b = p81VarArr3;
            int i2 = length3 - 1;
            for (p81 p81Var6 = this.f25899e; p81Var6 != this; p81Var6 = p81Var6.mo6888b()) {
                p81 p81Var7 = p81Var6;
                int i3 = p81Var7.f25061c & i2;
                p81Var7.f25062d = p81VarArr3[i3];
                p81VarArr3[i3] = p81Var7;
            }
        }
        return true;
    }

    @Override // p000.s81
    /* renamed from: b */
    public final s81 mo6888b() {
        return this.f25899e;
    }

    @Override // p000.s81
    /* renamed from: c */
    public final void mo6889c(s81 s81Var) {
        this.f25899e = s81Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        Arrays.fill(this.f25896b, (Object) null);
        this.f25897c = 0;
        for (s81 s81Var = this.f25899e; s81Var != this; s81Var = s81Var.mo6888b()) {
            p81 p81Var = (p81) s81Var;
            p81 p81Var2 = p81Var.f25065g;
            Objects.requireNonNull(p81Var2);
            p81 p81Var3 = p81Var.f25066h;
            Objects.requireNonNull(p81Var3);
            p81Var2.f25066h = p81Var3;
            p81Var3.f25065g = p81Var2;
        }
        mo6889c(this);
        mo6887a(this);
        this.f25898d++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int m6454N = o63.m6454N(obj);
        p81[] p81VarArr = this.f25896b;
        for (p81 p81Var = p81VarArr[(p81VarArr.length - 1) & m6454N]; p81Var != null; p81Var = p81Var.f25062d) {
            if (p81Var.m6890d(m6454N, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new q81(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int m6454N = o63.m6454N(obj);
        p81[] p81VarArr = this.f25896b;
        int length = (p81VarArr.length - 1) & m6454N;
        p81 p81Var = null;
        for (p81 p81Var2 = p81VarArr[length]; p81Var2 != null; p81Var2 = p81Var2.f25062d) {
            if (p81Var2.m6890d(m6454N, obj)) {
                if (p81Var == null) {
                    this.f25896b[length] = p81Var2.f25062d;
                } else {
                    p81Var.f25062d = p81Var2.f25062d;
                }
                s81 s81Var = p81Var2.f25063e;
                Objects.requireNonNull(s81Var);
                s81 mo6888b = p81Var2.mo6888b();
                s81Var.mo6889c(mo6888b);
                mo6888b.mo6887a(s81Var);
                p81 p81Var3 = p81Var2.f25065g;
                Objects.requireNonNull(p81Var3);
                p81 p81Var4 = p81Var2.f25066h;
                Objects.requireNonNull(p81Var4);
                p81Var3.f25066h = p81Var4;
                p81Var4.f25065g = p81Var3;
                this.f25897c--;
                this.f25898d++;
                return true;
            }
            p81Var = p81Var2;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f25897c;
    }
}
