package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import p000.g70;

@SinceKotlin(version = "1.3")
@Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m5569d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "<init>", "()V", "", "read", "()J", "Lkotlin/time/Duration;", TypedValues.TransitionType.S_DURATION, "", "plusAssign-LRDsOJo", "(J)V", "plusAssign", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalTime
/* loaded from: classes2.dex */
public final class TestTimeSource extends AbstractLongTimeSource {

    /* renamed from: b */
    public long f21378b;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
    }

    /* renamed from: a */
    public final void m5651a(long j) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.f21378b + g70.shortName(getUnit()) + " is advanced by " + ((Object) Duration.m8763toStringimpl(j)) + '.');
    }

    /* renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m8823plusAssignLRDsOJo(long duration) {
        long j;
        long m8760toLongimpl = Duration.m8760toLongimpl(duration, getUnit());
        if (m8760toLongimpl != Long.MIN_VALUE && m8760toLongimpl != Long.MAX_VALUE) {
            long j2 = this.f21378b;
            j = j2 + m8760toLongimpl;
            if ((m8760toLongimpl ^ j2) >= 0 && (j2 ^ j) < 0) {
                m5651a(duration);
                throw null;
            }
        } else {
            double m8757toDoubleimpl = this.f21378b + Duration.m8757toDoubleimpl(duration, getUnit());
            if (m8757toDoubleimpl <= 9.223372036854776E18d && m8757toDoubleimpl >= -9.223372036854776E18d) {
                j = (long) m8757toDoubleimpl;
            } else {
                m5651a(duration);
                throw null;
            }
        }
        this.f21378b = j;
    }

    @Override // kotlin.time.AbstractLongTimeSource
    /* renamed from: read, reason: from getter */
    public long getF21378b() {
        return this.f21378b;
    }
}
