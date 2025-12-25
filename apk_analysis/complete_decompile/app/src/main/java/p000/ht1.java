package p000;

import com.google.common.collect.C0869f2;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class ht1 extends C0869f2 {

    /* renamed from: i */
    public transient long[] f18166i;

    /* renamed from: j */
    public transient int f18167j;

    /* renamed from: k */
    public transient int f18168k;

    @Override // com.google.common.collect.C0869f2
    /* renamed from: a */
    public final void mo4089a() {
        super.mo4089a();
        this.f18167j = -2;
        this.f18168k = -2;
    }

    @Override // com.google.common.collect.C0869f2
    /* renamed from: c */
    public final int mo4091c() {
        int i = this.f18167j;
        if (i == -2) {
            return -1;
        }
        return i;
    }

    @Override // com.google.common.collect.C0869f2
    /* renamed from: h */
    public final void mo4096h(int i) {
        super.mo4096h(i);
        this.f18167j = -2;
        this.f18168k = -2;
        long[] jArr = new long[i];
        this.f18166i = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.C0869f2
    /* renamed from: i */
    public final void mo4097i(int i, int i2, int i3, Object obj) {
        super.mo4097i(i, i2, i3, obj);
        m5130r(this.f18168k, i);
        m5130r(i, -2);
    }

    @Override // com.google.common.collect.C0869f2
    /* renamed from: j */
    public final void mo4098j(int i) {
        int i2 = this.f14821c - 1;
        long j = this.f18166i[i];
        m5130r((int) (j >>> 32), (int) j);
        if (i < i2) {
            m5130r((int) (this.f18166i[i2] >>> 32), i);
            m5130r(i, (int) this.f18166i[i2]);
        }
        super.mo4098j(i);
    }

    @Override // com.google.common.collect.C0869f2
    /* renamed from: k */
    public final int mo4099k(int i) {
        int i2 = (int) this.f18166i[i];
        if (i2 == -2) {
            return -1;
        }
        return i2;
    }

    @Override // com.google.common.collect.C0869f2
    /* renamed from: l */
    public final int mo4100l(int i, int i2) {
        if (i == this.f14821c) {
            return i2;
        }
        return i;
    }

    @Override // com.google.common.collect.C0869f2
    /* renamed from: p */
    public final void mo4104p(int i) {
        super.mo4104p(i);
        long[] jArr = this.f18166i;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        this.f18166i = copyOf;
        Arrays.fill(copyOf, length, i, -1L);
    }

    /* renamed from: r */
    public final void m5130r(int i, int i2) {
        if (i == -2) {
            this.f18167j = i2;
        } else {
            long[] jArr = this.f18166i;
            jArr[i] = (jArr[i] & (-4294967296L)) | (i2 & 4294967295L);
        }
        if (i2 == -2) {
            this.f18168k = i;
        } else {
            long[] jArr2 = this.f18166i;
            jArr2[i2] = (4294967295L & jArr2[i2]) | (i << 32);
        }
    }
}
