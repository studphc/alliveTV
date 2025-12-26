package p000;

import com.google.android.exoplayer2.util.Util;

/* renamed from: pk */
/* loaded from: classes.dex */
public final class C1690pk implements Comparable {

    /* renamed from: a */
    public long f25203a;

    /* renamed from: b */
    public long f25204b;

    /* renamed from: c */
    public int f25205c;

    public C1690pk(long j, long j2) {
        this.f25203a = j;
        this.f25204b = j2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Util.compareLong(this.f25203a, ((C1690pk) obj).f25203a);
    }
}
