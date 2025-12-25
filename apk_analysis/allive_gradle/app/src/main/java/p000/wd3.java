package p000;

import com.google.android.gms.internal.measurement.zznh;

/* loaded from: classes.dex */
public final class wd3 {

    /* renamed from: a */
    public final zznh f28151a;

    /* renamed from: b */
    public final String f28152b;

    /* renamed from: c */
    public final Object[] f28153c;

    /* renamed from: d */
    public final int f28154d;

    public wd3(zznh zznhVar, String str, Object[] objArr) {
        this.f28151a = zznhVar;
        this.f28152b = str;
        this.f28153c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f28154d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 1;
        int i3 = 13;
        while (true) {
            int i4 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                i |= (charAt2 & 8191) << i3;
                i3 += 13;
                i2 = i4;
            } else {
                this.f28154d = i | (charAt2 << i3);
                return;
            }
        }
    }

    /* renamed from: a */
    public final zznh m8049a() {
        return this.f28151a;
    }

    /* renamed from: b */
    public final int m8050b() {
        int i = this.f28154d;
        if ((i & 1) != 0) {
            return 1;
        }
        if ((i & 4) == 4) {
            return 3;
        }
        return 2;
    }

    /* renamed from: c */
    public final String m8051c() {
        return this.f28152b;
    }

    /* renamed from: d */
    public final Object[] m8052d() {
        return this.f28153c;
    }
}
