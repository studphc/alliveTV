package p000;

import kotlin.jvm.internal.Intrinsics;
import kotlin.time.AbstractLongTimeSource;
import kotlin.time.ComparableTimeMark;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeMark;

/* renamed from: g1 */
/* loaded from: classes2.dex */
public final class C1216g1 implements ComparableTimeMark {

    /* renamed from: a */
    public final long f17515a;

    /* renamed from: b */
    public final AbstractLongTimeSource f17516b;

    /* renamed from: c */
    public final long f17517c;

    public C1216g1(long j, AbstractLongTimeSource timeSource, long j2) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.f17515a = j;
        this.f17516b = timeSource;
        this.f17517c = j2;
    }

    /* renamed from: a */
    public final long m4900a() {
        long j = this.f17517c;
        if (Duration.m8746isInfiniteimpl(j)) {
            return j;
        }
        DurationUnit unit = this.f17516b.getUnit();
        DurationUnit durationUnit = DurationUnit.MILLISECONDS;
        int compareTo = unit.compareTo(durationUnit);
        long j2 = this.f17515a;
        if (compareTo >= 0) {
            return Duration.m8750plusLRDsOJo(DurationKt.toDuration(j2, unit), j);
        }
        long convertDurationUnit = f70.convertDurationUnit(1L, durationUnit, unit);
        long j3 = j2 / convertDurationUnit;
        long j4 = j2 % convertDurationUnit;
        long m8740getInWholeSecondsimpl = Duration.m8740getInWholeSecondsimpl(j);
        return Duration.m8750plusLRDsOJo(Duration.m8750plusLRDsOJo(Duration.m8750plusLRDsOJo(DurationKt.toDuration(j4, unit), DurationKt.toDuration(Duration.m8742getNanosecondsComponentimpl(j) % 1000000, DurationUnit.NANOSECONDS)), DurationKt.toDuration(j3 + (r0 / 1000000), durationUnit)), DurationKt.toDuration(m8740getInWholeSecondsimpl, DurationUnit.SECONDS));
    }

    @Override // java.lang.Comparable
    public final int compareTo(ComparableTimeMark comparableTimeMark) {
        return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: elapsedNow-UwyO8pc */
    public final long mo8481elapsedNowUwyO8pc() {
        long j = this.f17517c;
        if (Duration.m8746isInfiniteimpl(j)) {
            return Duration.m8766unaryMinusUwyO8pc(j);
        }
        AbstractLongTimeSource abstractLongTimeSource = this.f17516b;
        return Duration.m8749minusLRDsOJo(DurationKt.toDuration(abstractLongTimeSource.getF21378b() - this.f17515a, abstractLongTimeSource.getUnit()), j);
    }

    @Override // kotlin.time.ComparableTimeMark
    public final boolean equals(Object obj) {
        if (obj instanceof C1216g1) {
            if (Intrinsics.areEqual(this.f17516b, ((C1216g1) obj).f17516b) && Duration.m8724equalsimpl0(mo8483minusUwyO8pc((ComparableTimeMark) obj), Duration.INSTANCE.m8795getZEROUwyO8pc())) {
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
        return Duration.m8744hashCodeimpl(m4900a());
    }

    @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
    /* renamed from: minus-LRDsOJo */
    public final ComparableTimeMark mo8482minusLRDsOJo(long j) {
        return ComparableTimeMark.DefaultImpls.m8716minusLRDsOJo(this, j);
    }

    @Override // kotlin.time.ComparableTimeMark
    /* renamed from: minus-UwyO8pc */
    public final long mo8483minusUwyO8pc(ComparableTimeMark other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof C1216g1) {
            C1216g1 c1216g1 = (C1216g1) other;
            AbstractLongTimeSource abstractLongTimeSource = c1216g1.f17516b;
            AbstractLongTimeSource abstractLongTimeSource2 = this.f17516b;
            if (Intrinsics.areEqual(abstractLongTimeSource2, abstractLongTimeSource)) {
                long j = c1216g1.f17517c;
                long j2 = this.f17517c;
                if (Duration.m8724equalsimpl0(j2, j) && Duration.m8746isInfiniteimpl(j2)) {
                    return Duration.INSTANCE.m8795getZEROUwyO8pc();
                }
                long m8749minusLRDsOJo = Duration.m8749minusLRDsOJo(j2, c1216g1.f17517c);
                long duration = DurationKt.toDuration(this.f17515a - c1216g1.f17515a, abstractLongTimeSource2.getUnit());
                if (Duration.m8724equalsimpl0(duration, Duration.m8766unaryMinusUwyO8pc(m8749minusLRDsOJo))) {
                    return Duration.INSTANCE.m8795getZEROUwyO8pc();
                }
                return Duration.m8750plusLRDsOJo(duration, m8749minusLRDsOJo);
            }
        }
        throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LongTimeMark(");
        sb.append(this.f17515a);
        AbstractLongTimeSource abstractLongTimeSource = this.f17516b;
        sb.append(g70.shortName(abstractLongTimeSource.getUnit()));
        sb.append(" + ");
        sb.append((Object) Duration.m8763toStringimpl(this.f17517c));
        sb.append(" (=");
        sb.append((Object) Duration.m8763toStringimpl(m4900a()));
        sb.append("), ");
        sb.append(abstractLongTimeSource);
        sb.append(')');
        return sb.toString();
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: minus-LRDsOJo */
    public final TimeMark mo8482minusLRDsOJo(long j) {
        return ComparableTimeMark.DefaultImpls.m8716minusLRDsOJo(this, j);
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: plus-LRDsOJo */
    public final ComparableTimeMark mo8484plusLRDsOJo(long j) {
        return new C1216g1(this.f17515a, this.f17516b, Duration.m8750plusLRDsOJo(this.f17517c, j));
    }

    @Override // kotlin.time.ComparableTimeMark
    public final int compareTo(ComparableTimeMark comparableTimeMark) {
        return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
    }
}
