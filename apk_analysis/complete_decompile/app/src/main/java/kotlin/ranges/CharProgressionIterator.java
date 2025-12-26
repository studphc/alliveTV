package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m5569d2 = {"Lkotlin/ranges/CharProgressionIterator;", "Lkotlin/collections/CharIterator;", "", "first", "last", "", "step", "<init>", "(CCI)V", "", "hasNext", "()Z", "nextChar", "()C", "a", "I", "getStep", "()I", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class CharProgressionIterator extends CharIterator {

    /* renamed from: a, reason: from kotlin metadata */
    public final int step;

    /* renamed from: b */
    public final int f21216b;

    /* renamed from: c */
    public boolean f21217c;

    /* renamed from: d */
    public int f21218d;

    public CharProgressionIterator(char c, char c2, int i) {
        this.step = i;
        this.f21216b = c2;
        boolean z = false;
        if (i <= 0 ? Intrinsics.compare((int) c, (int) c2) >= 0 : Intrinsics.compare((int) c, (int) c2) <= 0) {
            z = true;
        }
        this.f21217c = z;
        this.f21218d = z ? c : c2;
    }

    public final int getStep() {
        return this.step;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f21217c;
    }

    @Override // kotlin.collections.CharIterator
    public char nextChar() {
        int i = this.f21218d;
        if (i == this.f21216b) {
            if (this.f21217c) {
                this.f21217c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f21218d = this.step + i;
        }
        return (char) i;
    }
}
