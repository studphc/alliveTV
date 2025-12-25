package p000;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class da3 {

    /* renamed from: a */
    public final String f16314a;

    /* renamed from: b */
    public final String f16315b;

    /* renamed from: c */
    public final long f16316c;

    /* renamed from: d */
    public final long f16317d;

    /* renamed from: e */
    public final long f16318e;

    /* renamed from: f */
    public final long f16319f;

    /* renamed from: g */
    public final long f16320g;

    /* renamed from: h */
    public final Long f16321h;

    /* renamed from: i */
    public final Long f16322i;

    /* renamed from: j */
    public final Long f16323j;

    /* renamed from: k */
    public final Boolean f16324k;

    public da3(String str, String str2, long j, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        boolean z;
        boolean z2;
        boolean z3;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        if (j3 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        Preconditions.checkArgument(j5 >= 0);
        this.f16314a = str;
        this.f16315b = str2;
        this.f16316c = j;
        this.f16317d = j2;
        this.f16318e = j3;
        this.f16319f = j4;
        this.f16320g = j5;
        this.f16321h = l;
        this.f16322i = l2;
        this.f16323j = l3;
        this.f16324k = bool;
    }

    /* renamed from: a */
    public final da3 m4566a(Long l, Long l2, Boolean bool) {
        return new da3(this.f16314a, this.f16315b, this.f16316c, this.f16317d, this.f16318e, this.f16319f, this.f16320g, this.f16321h, l, l2, bool);
    }

    /* renamed from: b */
    public final da3 m4567b(long j) {
        return new da3(this.f16314a, this.f16315b, this.f16316c, this.f16317d, this.f16318e, j, this.f16320g, this.f16321h, this.f16322i, this.f16323j, this.f16324k);
    }
}
