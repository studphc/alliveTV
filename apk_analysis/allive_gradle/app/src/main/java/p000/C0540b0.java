package p000;

import kotlin.jvm.internal.Intrinsics;
import kotlin.time.AbstractDoubleTimeSource;
import kotlin.time.ComparableTimeMark;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.TimeMark;

/* renamed from: b0 */
/* loaded from: classes2.dex */
public final class C0540b0 implements ComparableTimeMark {

    /* renamed from: a */
    public final double f7824a;

    /* renamed from: b */
    public final AbstractDoubleTimeSource f7825b;

    /* renamed from: c */
    public final long f7826c;

    public C0540b0(double d, AbstractDoubleTimeSource timeSource, long j) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.f7824a = d;
        this.f7825b = timeSource;
        this.f7826c = j;
    }

    @Override // java.lang.Comparable
    public final int compareTo(ComparableTimeMark comparableTimeMark) {
        return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
    public final long mo8481elapsedNowUwyO8pc() {
        AbstractDoubleTimeSource abstractDoubleTimeSource = this.f7825b;
        return Duration.m8749minusLRDsOJo(DurationKt.toDuration(abstractDoubleTimeSource.read() - this.f7824a, abstractDoubleTimeSource.getUnit()), this.f7826c);
    }

    @Override // kotlin.time.ComparableTimeMark
    public final boolean equals(Object obj) {
        if (obj instanceof C0540b0) {
            if (Intrinsics.areEqual(this.f7825b, ((C0540b0) obj).f7825b) && Duration.m8724equalsimpl0(mo8483minusUwyO8pc((ComparableTimeMark) obj), Duration.INSTANCE.m8795getZEROUwyO8pc())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.time.TimeMark
    public final boolean hasNotPassedNow() {
        return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
    }

    @Override // kotlin.time.TimeMark
    public final boolean hasPassedNow() {
        return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
    }

    @Override // kotlin.time.ComparableTimeMark
    public final int hashCode() {
        return Duration.m8744hashCodeimpl(Duration.m8750plusLRDsOJo(DurationKt.toDuration(this.f7824a, this.f7825b.getUnit()), this.f7826c));
    }

    @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public final ComparableTimeMark mo8482minusLRDsOJo(long j) {
        return ComparableTimeMark.DefaultImpls.m8716minusLRDsOJo(this, j);
    }

    @Override // kotlin.time.ComparableTimeMark
    /* renamed from: minus-UwyO8pc, reason: not valid java name */
    public final long mo8483minusUwyO8pc(ComparableTimeMark other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof C0540b0) {
            C0540b0 c0540b0 = (C0540b0) other;
            AbstractDoubleTimeSource abstractDoubleTimeSource = c0540b0.f7825b;
            AbstractDoubleTimeSource abstractDoubleTimeSource2 = this.f7825b;
            if (Intrinsics.areEqual(abstractDoubleTimeSource2, abstractDoubleTimeSource)) {
                long j = c0540b0.f7826c;
                long j2 = this.f7826c;
                if (Duration.m8724equalsimpl0(j2, j) && Duration.m8746isInfiniteimpl(j2)) {
                    return Duration.INSTANCE.m8795getZEROUwyO8pc();
                }
                long m8749minusLRDsOJo = Duration.m8749minusLRDsOJo(j2, c0540b0.f7826c);
                long duration = DurationKt.toDuration(this.f7824a - c0540b0.f7824a, abstractDoubleTimeSource2.getUnit());
                if (Duration.m8724equalsimpl0(duration, Duration.m8766unaryMinusUwyO8pc(m8749minusLRDsOJo))) {
                    return Duration.INSTANCE.m8795getZEROUwyO8pc();
                }
                return Duration.m8750plusLRDsOJo(duration, m8749minusLRDsOJo);
            }
        }
        throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DoubleTimeMark(");
        sb.append(this.f7824a);
        AbstractDoubleTimeSource abstractDoubleTimeSource = this.f7825b;
        sb.append(g70.shortName(abstractDoubleTimeSource.getUnit()));
        sb.append(" + ");
        sb.append((Object) Duration.m8763toStringimpl(this.f7826c));
        sb.append(", ");
        sb.append(abstractDoubleTimeSource);
        sb.append(')');
        return sb.toString();
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: minus-LRDsOJo */
    public final TimeMark mo8482minusLRDsOJo(long j) {
        return ComparableTimeMark.DefaultImpls.m8716minusLRDsOJo(this, j);
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public final ComparableTimeMark mo8484plusLRDsOJo(long j) {
        return new C0540b0(this.f7824a, this.f7825b, Duration.m8750plusLRDsOJo(this.f7826c, j));
    }

    @Override // kotlin.time.ComparableTimeMark
    public final int compareTo(ComparableTimeMark comparableTimeMark) {
        return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
    }
}
