package p000;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzhe;
import com.google.android.gms.measurement.internal.zzio;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class ob3 {

    /* renamed from: A */
    public Long f23713A;

    /* renamed from: B */
    public Long f23714B;

    /* renamed from: C */
    public long f23715C;

    /* renamed from: D */
    public String f23716D;

    /* renamed from: E */
    public int f23717E;

    /* renamed from: F */
    public int f23718F;

    /* renamed from: G */
    public long f23719G;

    /* renamed from: H */
    public String f23720H;

    /* renamed from: I */
    public byte[] f23721I;

    /* renamed from: J */
    public int f23722J;

    /* renamed from: K */
    public long f23723K;

    /* renamed from: L */
    public long f23724L;

    /* renamed from: M */
    public long f23725M;

    /* renamed from: N */
    public long f23726N;

    /* renamed from: O */
    public long f23727O;

    /* renamed from: P */
    public long f23728P;

    /* renamed from: Q */
    public String f23729Q;

    /* renamed from: R */
    public boolean f23730R;

    /* renamed from: S */
    public long f23731S;

    /* renamed from: T */
    public long f23732T;

    /* renamed from: a */
    public final zzio f23733a;

    /* renamed from: b */
    public final String f23734b;

    /* renamed from: c */
    public String f23735c;

    /* renamed from: d */
    public String f23736d;

    /* renamed from: e */
    public String f23737e;

    /* renamed from: f */
    public String f23738f;

    /* renamed from: g */
    public long f23739g;

    /* renamed from: h */
    public long f23740h;

    /* renamed from: i */
    public long f23741i;

    /* renamed from: j */
    public String f23742j;

    /* renamed from: k */
    public long f23743k;

    /* renamed from: l */
    public String f23744l;

    /* renamed from: m */
    public long f23745m;

    /* renamed from: n */
    public long f23746n;

    /* renamed from: o */
    public boolean f23747o;

    /* renamed from: p */
    public boolean f23748p;

    /* renamed from: q */
    public String f23749q;

    /* renamed from: r */
    public Boolean f23750r;

    /* renamed from: s */
    public long f23751s;

    /* renamed from: t */
    public ArrayList f23752t;

    /* renamed from: u */
    public String f23753u;

    /* renamed from: v */
    public boolean f23754v;

    /* renamed from: w */
    public long f23755w;

    /* renamed from: x */
    public long f23756x;

    /* renamed from: y */
    public int f23757y;

    /* renamed from: z */
    public boolean f23758z;

    public ob3(zzio zzioVar, String str) {
        Preconditions.checkNotNull(zzioVar);
        Preconditions.checkNotEmpty(str);
        this.f23733a = zzioVar;
        this.f23734b = str;
        zzioVar.zzaX().zzg();
    }

    /* renamed from: A */
    public final void m6527A(long j) {
        boolean z;
        boolean z2 = false;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f23733a.zzaX().zzg();
        boolean z3 = this.f23730R;
        if (this.f23739g != j) {
            z2 = true;
        }
        this.f23730R = z3 | z2;
        this.f23739g = j;
    }

    /* renamed from: B */
    public final void m6528B(long j) {
        boolean z;
        this.f23733a.zzaX().zzg();
        boolean z2 = this.f23730R;
        if (this.f23740h != j) {
            z = true;
        } else {
            z = false;
        }
        this.f23730R = z2 | z;
        this.f23740h = j;
    }

    /* renamed from: C */
    public final void m6529C(boolean z) {
        boolean z2;
        this.f23733a.zzaX().zzg();
        boolean z3 = this.f23730R;
        if (this.f23747o != z) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f23730R = z3 | z2;
        this.f23747o = z;
    }

    /* renamed from: D */
    public final void m6530D(String str) {
        this.f23733a.zzaX().zzg();
        this.f23730R |= !Objects.equals(this.f23737e, str);
        this.f23737e = str;
    }

    /* renamed from: E */
    public final void m6531E(List list) {
        ArrayList arrayList;
        this.f23733a.zzaX().zzg();
        if (!Objects.equals(this.f23752t, list)) {
            this.f23730R = true;
            if (list != null) {
                arrayList = new ArrayList(list);
            } else {
                arrayList = null;
            }
            this.f23752t = arrayList;
        }
    }

    /* renamed from: F */
    public final int m6532F() {
        this.f23733a.zzaX().zzg();
        return this.f23722J;
    }

    /* renamed from: G */
    public final long m6533G() {
        this.f23733a.zzaX().zzg();
        return this.f23743k;
    }

    /* renamed from: a */
    public final String m6534a() {
        this.f23733a.zzaX().zzg();
        return this.f23749q;
    }

    /* renamed from: b */
    public final String m6535b() {
        this.f23733a.zzaX().zzg();
        String str = this.f23729Q;
        m6558y(null);
        return str;
    }

    /* renamed from: c */
    public final String m6536c() {
        this.f23733a.zzaX().zzg();
        return this.f23734b;
    }

    /* renamed from: d */
    public final String m6537d() {
        this.f23733a.zzaX().zzg();
        return this.f23735c;
    }

    /* renamed from: e */
    public final String m6538e() {
        this.f23733a.zzaX().zzg();
        return this.f23742j;
    }

    /* renamed from: f */
    public final String m6539f() {
        this.f23733a.zzaX().zzg();
        return this.f23738f;
    }

    /* renamed from: g */
    public final String m6540g() {
        this.f23733a.zzaX().zzg();
        return this.f23736d;
    }

    /* renamed from: h */
    public final String m6541h() {
        this.f23733a.zzaX().zzg();
        return this.f23716D;
    }

    /* renamed from: i */
    public final void m6542i(long j) {
        zzio zzioVar = this.f23733a;
        zzioVar.zzaX().zzg();
        long j2 = this.f23739g + j;
        String str = this.f23734b;
        if (j2 > 2147483647L) {
            zzioVar.zzaW().zzk().zzb("Bundle index overflow. appId", zzhe.zzn(str));
            j2 = (-1) + j;
        }
        long j3 = this.f23719G + 1;
        if (j3 > 2147483647L) {
            zzioVar.zzaW().zzk().zzb("Delivery index overflow. appId", zzhe.zzn(str));
            j3 = 0;
        }
        this.f23730R = true;
        this.f23739g = j2;
        this.f23719G = j3;
    }

    /* renamed from: j */
    public final void m6543j(String str) {
        this.f23733a.zzaX().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f23730R |= true ^ Objects.equals(this.f23749q, str);
        this.f23749q = str;
    }

    /* renamed from: k */
    public final void m6544k(String str) {
        this.f23733a.zzaX().zzg();
        this.f23730R |= !Objects.equals(this.f23735c, str);
        this.f23735c = str;
    }

    /* renamed from: l */
    public final void m6545l(String str) {
        this.f23733a.zzaX().zzg();
        this.f23730R |= !Objects.equals(this.f23744l, str);
        this.f23744l = str;
    }

    /* renamed from: m */
    public final void m6546m(String str) {
        this.f23733a.zzaX().zzg();
        this.f23730R |= !Objects.equals(this.f23742j, str);
        this.f23742j = str;
    }

    /* renamed from: n */
    public final void m6547n(long j) {
        boolean z;
        this.f23733a.zzaX().zzg();
        boolean z2 = this.f23730R;
        if (this.f23743k != j) {
            z = true;
        } else {
            z = false;
        }
        this.f23730R = z2 | z;
        this.f23743k = j;
    }

    /* renamed from: o */
    public final void m6548o(long j) {
        boolean z;
        this.f23733a.zzaX().zzg();
        boolean z2 = this.f23730R;
        if (this.f23715C != j) {
            z = true;
        } else {
            z = false;
        }
        this.f23730R = z2 | z;
        this.f23715C = j;
    }

    /* renamed from: p */
    public final boolean m6549p() {
        this.f23733a.zzaX().zzg();
        return this.f23754v;
    }

    /* renamed from: q */
    public final void m6550q(long j) {
        boolean z;
        this.f23733a.zzaX().zzg();
        boolean z2 = this.f23730R;
        if (this.f23731S != j) {
            z = true;
        } else {
            z = false;
        }
        this.f23730R = z2 | z;
        this.f23731S = j;
    }

    /* renamed from: r */
    public final void m6551r(int i) {
        boolean z;
        this.f23733a.zzaX().zzg();
        boolean z2 = this.f23730R;
        if (this.f23718F != i) {
            z = true;
        } else {
            z = false;
        }
        this.f23730R = z2 | z;
        this.f23718F = i;
    }

    /* renamed from: s */
    public final void m6552s(long j) {
        boolean z;
        this.f23733a.zzaX().zzg();
        boolean z2 = this.f23730R;
        if (this.f23746n != j) {
            z = true;
        } else {
            z = false;
        }
        this.f23730R = z2 | z;
        this.f23746n = j;
    }

    /* renamed from: t */
    public final void m6553t(int i) {
        boolean z;
        this.f23733a.zzaX().zzg();
        boolean z2 = this.f23730R;
        if (this.f23717E != i) {
            z = true;
        } else {
            z = false;
        }
        this.f23730R = z2 | z;
        this.f23717E = i;
    }

    /* renamed from: u */
    public final void m6554u(long j) {
        boolean z;
        this.f23733a.zzaX().zzg();
        boolean z2 = this.f23730R;
        if (this.f23751s != j) {
            z = true;
        } else {
            z = false;
        }
        this.f23730R = z2 | z;
        this.f23751s = j;
    }

    /* renamed from: v */
    public final void m6555v(String str) {
        this.f23733a.zzaX().zzg();
        this.f23730R |= !Objects.equals(this.f23738f, str);
        this.f23738f = str;
    }

    /* renamed from: w */
    public final void m6556w(String str) {
        this.f23733a.zzaX().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f23730R |= true ^ Objects.equals(this.f23736d, str);
        this.f23736d = str;
    }

    /* renamed from: x */
    public final void m6557x(long j) {
        boolean z;
        this.f23733a.zzaX().zzg();
        boolean z2 = this.f23730R;
        if (this.f23745m != j) {
            z = true;
        } else {
            z = false;
        }
        this.f23730R = z2 | z;
        this.f23745m = j;
    }

    /* renamed from: y */
    public final void m6558y(String str) {
        this.f23733a.zzaX().zzg();
        this.f23730R |= !Objects.equals(this.f23729Q, str);
        this.f23729Q = str;
    }

    /* renamed from: z */
    public final void m6559z(long j) {
        boolean z;
        this.f23733a.zzaX().zzg();
        boolean z2 = this.f23730R;
        if (this.f23741i != j) {
            z = true;
        } else {
            z = false;
        }
        this.f23730R = z2 | z;
        this.f23741i = j;
    }
}
