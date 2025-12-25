package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;
import p000.p40;
import p000.p63;
import p000.q40;
import p000.r40;
import p000.ye0;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class DiscreteDomain<C extends Comparable> {

    /* renamed from: a */
    public final boolean f14626a;

    public DiscreteDomain() {
        this(false);
    }

    public static DiscreteDomain<BigInteger> bigIntegers() {
        return p40.f25026b;
    }

    public static DiscreteDomain<Integer> integers() {
        return q40.f25430b;
    }

    public static DiscreteDomain<Long> longs() {
        return r40.f25864b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public Comparable mo3849a(Comparable comparable, long j) {
        p63.m6870n(j);
        C c = comparable;
        for (long j2 = 0; j2 < j; j2++) {
            c = next(c);
            if (c == null) {
                String valueOf = String.valueOf(comparable);
                StringBuilder sb = new StringBuilder(valueOf.length() + 51);
                sb.append("overflowed computing offset(");
                sb.append(valueOf);
                sb.append(", ");
                throw new IllegalArgumentException(ye0.m8297q(sb, j, ")"));
            }
        }
        return c;
    }

    public abstract long distance(C c, C c2);

    @CanIgnoreReturnValue
    public C maxValue() {
        throw new NoSuchElementException();
    }

    @CanIgnoreReturnValue
    public C minValue() {
        throw new NoSuchElementException();
    }

    @CheckForNull
    public abstract C next(C c);

    @CheckForNull
    public abstract C previous(C c);

    public DiscreteDomain(boolean z) {
        this.f14626a = z;
    }
}
