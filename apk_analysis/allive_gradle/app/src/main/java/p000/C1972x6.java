package p000;

import android.os.SystemClock;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.common.collect.ImmutableList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeMark;

/* renamed from: x6 */
/* loaded from: classes2.dex */
public final class C1972x6 implements TimeMark {

    /* renamed from: a */
    public final /* synthetic */ int f28445a;

    /* renamed from: b */
    public long f28446b;

    /* renamed from: c */
    public Object f28447c;

    public C1972x6(TimeMark mark, long j) {
        this.f28445a = 0;
        Intrinsics.checkNotNullParameter(mark, "mark");
        this.f28447c = mark;
        this.f28446b = j;
    }

    /* renamed from: a */
    public void m8137a(int i) {
        if (i >= 64) {
            C1972x6 c1972x6 = (C1972x6) this.f28447c;
            if (c1972x6 != null) {
                c1972x6.m8137a(i - 64);
                return;
            }
            return;
        }
        this.f28446b &= ~(1 << i);
    }

    /* renamed from: b */
    public int m8138b(int i) {
        C1972x6 c1972x6 = (C1972x6) this.f28447c;
        if (c1972x6 == null) {
            if (i >= 64) {
                return Long.bitCount(this.f28446b);
            }
            return Long.bitCount(this.f28446b & ((1 << i) - 1));
        }
        if (i < 64) {
            return Long.bitCount(this.f28446b & ((1 << i) - 1));
        }
        return Long.bitCount(this.f28446b) + c1972x6.m8138b(i - 64);
    }

    /* renamed from: c */
    public void m8139c() {
        if (((C1972x6) this.f28447c) == null) {
            this.f28447c = new C1972x6(1);
        }
    }

    /* renamed from: d */
    public boolean m8140d(int i) {
        if (i >= 64) {
            m8139c();
            return ((C1972x6) this.f28447c).m8140d(i - 64);
        }
        if ((this.f28446b & (1 << i)) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public void m8141e(int i, boolean z) {
        boolean z2;
        if (i >= 64) {
            m8139c();
            ((C1972x6) this.f28447c).m8141e(i - 64, z);
            return;
        }
        long j = this.f28446b;
        if ((Long.MIN_VALUE & j) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        long j2 = (1 << i) - 1;
        this.f28446b = ((j & (~j2)) << 1) | (j & j2);
        if (z) {
            m8144h(i);
        } else {
            m8137a(i);
        }
        if (z2 || ((C1972x6) this.f28447c) != null) {
            m8139c();
            ((C1972x6) this.f28447c).m8141e(0, z2);
        }
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: elapsedNow-UwyO8pc */
    public long mo8481elapsedNowUwyO8pc() {
        return Duration.m8749minusLRDsOJo(((TimeMark) this.f28447c).mo8481elapsedNowUwyO8pc(), this.f28446b);
    }

    /* renamed from: f */
    public boolean m8142f(int i) {
        boolean z;
        if (i >= 64) {
            m8139c();
            return ((C1972x6) this.f28447c).m8142f(i - 64);
        }
        long j = 1 << i;
        long j2 = this.f28446b;
        if ((j2 & j) != 0) {
            z = true;
        } else {
            z = false;
        }
        long j3 = j2 & (~j);
        this.f28446b = j3;
        long j4 = j - 1;
        this.f28446b = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
        C1972x6 c1972x6 = (C1972x6) this.f28447c;
        if (c1972x6 != null) {
            if (c1972x6.m8140d(0)) {
                m8144h(63);
            }
            ((C1972x6) this.f28447c).m8142f(0);
        }
        return z;
    }

    /* renamed from: g */
    public void m8143g() {
        this.f28446b = 0L;
        C1972x6 c1972x6 = (C1972x6) this.f28447c;
        if (c1972x6 != null) {
            c1972x6.m8143g();
        }
    }

    /* renamed from: h */
    public void m8144h(int i) {
        if (i >= 64) {
            m8139c();
            ((C1972x6) this.f28447c).m8144h(i - 64);
        } else {
            this.f28446b |= 1 << i;
        }
    }

    @Override // kotlin.time.TimeMark
    public boolean hasNotPassedNow() {
        return TimeMark.DefaultImpls.hasNotPassedNow(this);
    }

    @Override // kotlin.time.TimeMark
    public boolean hasPassedNow() {
        return TimeMark.DefaultImpls.hasPassedNow(this);
    }

    /* renamed from: i */
    public void m8145i(Exception exc) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (((Exception) this.f28447c) == null) {
            this.f28447c = exc;
            this.f28446b = 100 + elapsedRealtime;
        }
        if (elapsedRealtime >= this.f28446b) {
            Exception exc2 = (Exception) this.f28447c;
            if (exc2 != exc) {
                exc2.addSuppressed(exc);
            }
            Exception exc3 = (Exception) this.f28447c;
            this.f28447c = null;
            throw exc3;
        }
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: minus-LRDsOJo */
    public TimeMark mo8482minusLRDsOJo(long j) {
        return TimeMark.DefaultImpls.m8824minusLRDsOJo(this, j);
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: plus-LRDsOJo */
    public TimeMark mo8484plusLRDsOJo(long j) {
        return new C1972x6((TimeMark) this.f28447c, Duration.m8750plusLRDsOJo(this.f28446b, j));
    }

    public String toString() {
        switch (this.f28445a) {
            case 1:
                if (((C1972x6) this.f28447c) == null) {
                    return Long.toBinaryString(this.f28446b);
                }
                return ((C1972x6) this.f28447c).toString() + "xx" + Long.toBinaryString(this.f28446b);
            default:
                return super.toString();
        }
    }

    public C1972x6(Clock clock) {
        this.f28445a = 4;
        Preconditions.checkNotNull(clock);
        this.f28447c = clock;
    }

    public C1972x6(long j, ImmutableList immutableList) {
        this.f28445a = 3;
        this.f28446b = j;
        this.f28447c = immutableList;
    }

    public C1972x6(int i) {
        this.f28445a = i;
        switch (i) {
            case 2:
                return;
            default:
                this.f28446b = 0L;
                return;
        }
    }
}
