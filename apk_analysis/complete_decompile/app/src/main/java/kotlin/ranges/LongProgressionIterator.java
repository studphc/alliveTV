package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\f¨\u0006\u0010"}, m5569d2 = {"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "", "first", "last", "step", "<init>", "(JJJ)V", "", "hasNext", "()Z", "nextLong", "()J", "a", "J", "getStep", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class LongProgressionIterator extends LongIterator {

    /* renamed from: a, reason: from kotlin metadata */
    public final long step;

    /* renamed from: b */
    public final long f21232b;

    /* renamed from: c */
    public boolean f21233c;

    /* renamed from: d */
    public long f21234d;

    public LongProgressionIterator(long j, long j2, long j3) {
        this.step = j3;
        this.f21232b = j2;
        boolean z = false;
        if (j3 <= 0 ? j >= j2 : j <= j2) {
            z = true;
        }
        this.f21233c = z;
        this.f21234d = z ? j : j2;
    }

    public final long getStep() {
        return this.step;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f21233c;
    }

    @Override // kotlin.collections.LongIterator
    public long nextLong() {
        long j = this.f21234d;
        if (j == this.f21232b) {
            if (this.f21233c) {
                this.f21233c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f21234d = this.step + j;
        }
        return j;
    }
}
