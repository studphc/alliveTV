package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\f¨\u0006\u0010"}, m5569d2 = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "", "first", "last", "step", "<init>", "(III)V", "", "hasNext", "()Z", "nextInt", "()I", "a", "I", "getStep", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class IntProgressionIterator extends IntIterator {

    /* renamed from: a, reason: from kotlin metadata */
    public final int step;

    /* renamed from: b */
    public final int f21224b;

    /* renamed from: c */
    public boolean f21225c;

    /* renamed from: d */
    public int f21226d;

    public IntProgressionIterator(int i, int i2, int i3) {
        this.step = i3;
        this.f21224b = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.f21225c = z;
        this.f21226d = z ? i : i2;
    }

    public final int getStep() {
        return this.step;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f21225c;
    }

    @Override // kotlin.collections.IntIterator
    public int nextInt() {
        int i = this.f21226d;
        if (i == this.f21224b) {
            if (this.f21225c) {
                this.f21225c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f21226d = this.step + i;
        }
        return i;
    }
}
