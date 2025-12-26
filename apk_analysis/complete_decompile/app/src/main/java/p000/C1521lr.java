package p000;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: lr */
/* loaded from: classes.dex */
public final class C1521lr extends C1328ir {

    /* renamed from: k */
    public transient long[] f22645k;

    /* renamed from: l */
    public transient int f22646l;

    /* renamed from: m */
    public transient int f22647m;

    @Override // p000.C1328ir
    /* renamed from: c */
    public final int mo5342c(int i, int i2) {
        if (i >= size()) {
            return i2;
        }
        return i;
    }

    @Override // p000.C1328ir, java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (m5355r()) {
            return;
        }
        this.f22646l = -2;
        this.f22647m = -2;
        long[] jArr = this.f22645k;
        if (jArr != null) {
            Arrays.fill(jArr, 0, size(), 0L);
        }
        super.clear();
    }

    @Override // p000.C1328ir
    /* renamed from: e */
    public final int mo5343e() {
        int mo5343e = super.mo5343e();
        this.f22645k = new long[mo5343e];
        return mo5343e;
    }

    @Override // p000.C1328ir
    /* renamed from: f */
    public final Map mo5344f() {
        Map mo5344f = super.mo5344f();
        this.f22645k = null;
        return mo5344f;
    }

    @Override // p000.C1328ir
    /* renamed from: h */
    public final LinkedHashMap mo5345h(int i) {
        return new LinkedHashMap(i, 1.0f, false);
    }

    @Override // p000.C1328ir
    /* renamed from: j */
    public final int mo5347j() {
        return this.f22646l;
    }

    @Override // p000.C1328ir
    /* renamed from: k */
    public final int mo5348k(int i) {
        return ((int) m5974y()[i]) - 1;
    }

    @Override // p000.C1328ir
    /* renamed from: o */
    public final void mo5352o(int i) {
        super.mo5352o(i);
        this.f22646l = -2;
        this.f22647m = -2;
    }

    @Override // p000.C1328ir
    /* renamed from: p */
    public final void mo5353p(int i, Object obj, Object obj2, int i2, int i3) {
        super.mo5353p(i, obj, obj2, i2, i3);
        m5975z(this.f22647m, i);
        m5975z(i, -2);
    }

    @Override // p000.C1328ir
    /* renamed from: q */
    public final void mo5354q(int i, int i2) {
        int size = size() - 1;
        super.mo5354q(i, i2);
        m5975z(((int) (m5974y()[i] >>> 32)) - 1, mo5348k(i));
        if (i < size) {
            m5975z(((int) (m5974y()[size] >>> 32)) - 1, i);
            m5975z(i, mo5348k(size));
        }
        m5974y()[size] = 0;
    }

    @Override // p000.C1328ir
    /* renamed from: w */
    public final void mo5360w(int i) {
        super.mo5360w(i);
        this.f22645k = Arrays.copyOf(m5974y(), i);
    }

    /* renamed from: y */
    public final long[] m5974y() {
        long[] jArr = this.f22645k;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    /* renamed from: z */
    public final void m5975z(int i, int i2) {
        if (i == -2) {
            this.f22646l = i2;
        } else {
            m5974y()[i] = (m5974y()[i] & (-4294967296L)) | ((i2 + 1) & 4294967295L);
        }
        if (i2 == -2) {
            this.f22647m = i;
        } else {
            m5974y()[i2] = (4294967295L & m5974y()[i2]) | ((i + 1) << 32);
        }
    }

    @Override // p000.C1328ir
    /* renamed from: a */
    public final void mo5341a(int i) {
    }
}
