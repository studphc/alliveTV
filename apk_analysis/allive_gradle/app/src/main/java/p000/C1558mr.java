package p000;

import com.google.common.collect.ObjectArrays;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;

/* renamed from: mr */
/* loaded from: classes.dex */
public final class C1558mr extends C1484kr {

    /* renamed from: f */
    public transient int[] f23075f;

    /* renamed from: g */
    public transient int[] f23076g;

    /* renamed from: h */
    public transient int f23077h;

    /* renamed from: i */
    public transient int f23078i;

    @Override // p000.C1484kr
    /* renamed from: a */
    public final int mo5766a(int i, int i2) {
        if (i >= size()) {
            return i2;
        }
        return i;
    }

    @Override // p000.C1484kr
    /* renamed from: b */
    public final int mo5767b() {
        int mo5767b = super.mo5767b();
        this.f23075f = new int[mo5767b];
        this.f23076g = new int[mo5767b];
        return mo5767b;
    }

    @Override // p000.C1484kr
    /* renamed from: c */
    public final LinkedHashSet mo5768c() {
        LinkedHashSet mo5768c = super.mo5768c();
        this.f23075f = null;
        this.f23076g = null;
        return mo5768c;
    }

    @Override // p000.C1484kr, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        if (m5775k()) {
            return;
        }
        this.f23077h = -2;
        this.f23078i = -2;
        int[] iArr = this.f23075f;
        if (iArr != null && this.f23076g != null) {
            Arrays.fill(iArr, 0, size(), 0);
            Arrays.fill(this.f23076g, 0, size(), 0);
        }
        super.clear();
    }

    @Override // p000.C1484kr
    /* renamed from: f */
    public final int mo5770f() {
        return this.f23077h;
    }

    @Override // p000.C1484kr
    /* renamed from: g */
    public final int mo5771g(int i) {
        Objects.requireNonNull(this.f23076g);
        return r0[i] - 1;
    }

    @Override // p000.C1484kr
    /* renamed from: h */
    public final void mo5772h(int i) {
        super.mo5772h(i);
        this.f23077h = -2;
        this.f23078i = -2;
    }

    @Override // p000.C1484kr
    /* renamed from: i */
    public final void mo5773i(int i, int i2, int i3, Object obj) {
        super.mo5773i(i, i2, i3, obj);
        m6242p(this.f23078i, i);
        m6242p(i, -2);
    }

    @Override // p000.C1484kr
    /* renamed from: j */
    public final void mo5774j(int i, int i2) {
        int size = size() - 1;
        super.mo5774j(i, i2);
        Objects.requireNonNull(this.f23075f);
        m6242p(r4[i] - 1, mo5771g(i));
        if (i < size) {
            Objects.requireNonNull(this.f23075f);
            m6242p(r4[size] - 1, i);
            m6242p(i, mo5771g(size));
        }
        int[] iArr = this.f23075f;
        Objects.requireNonNull(iArr);
        iArr[size] = 0;
        int[] iArr2 = this.f23076g;
        Objects.requireNonNull(iArr2);
        iArr2[size] = 0;
    }

    @Override // p000.C1484kr
    /* renamed from: n */
    public final void mo5778n(int i) {
        super.mo5778n(i);
        int[] iArr = this.f23075f;
        Objects.requireNonNull(iArr);
        this.f23075f = Arrays.copyOf(iArr, i);
        int[] iArr2 = this.f23076g;
        Objects.requireNonNull(iArr2);
        this.f23076g = Arrays.copyOf(iArr2, i);
    }

    /* renamed from: p */
    public final void m6242p(int i, int i2) {
        if (i == -2) {
            this.f23077h = i2;
        } else {
            int[] iArr = this.f23076g;
            Objects.requireNonNull(iArr);
            iArr[i] = i2 + 1;
        }
        if (i2 == -2) {
            this.f23078i = i;
            return;
        }
        int[] iArr2 = this.f23075f;
        Objects.requireNonNull(iArr2);
        iArr2[i2] = i + 1;
    }

    @Override // p000.C1484kr, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        Object[] objArr = new Object[size()];
        ObjectArrays.m4066b(this, objArr);
        return objArr;
    }

    @Override // p000.C1484kr, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        return ObjectArrays.m4067c(this, objArr);
    }
}
