package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.InlineMe;
import javax.annotation.CheckForNull;
import p000.C1369jw;
import p000.C1489kw;
import p000.C1526lw;
import p000.C1563mw;
import p000.C1600nw;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class Converter<A, B> implements Function<A, B> {

    /* renamed from: a */
    public transient C1600nw f14472a;

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new C1526lw(function, function2);
    }

    public static <T> Converter<T, T> identity() {
        return C1563mw.f23141b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public Object mo3761a(Object obj) {
        if (obj == 0) {
            return null;
        }
        return Preconditions.checkNotNull(doBackward(obj));
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return mo3763c(converter);
    }

    @Override // com.google.common.base.Function
    @CheckForNull
    @Deprecated
    @CanIgnoreReturnValue
    @InlineMe(replacement = "this.convert(a)")
    public final B apply(@CheckForNull A a) {
        return convert(a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public Object mo3762b(Object obj) {
        if (obj == 0) {
            return null;
        }
        return Preconditions.checkNotNull(doForward(obj));
    }

    /* renamed from: c */
    public Converter mo3763c(Converter converter) {
        return new C1489kw(this, (Converter) Preconditions.checkNotNull(converter));
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public final B convert(@CheckForNull A a) {
        return (B) mo3762b(a);
    }

    @CanIgnoreReturnValue
    public Iterable<B> convertAll(Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new C1369jw(0, this, iterable);
    }

    @ForOverride
    public abstract A doBackward(B b);

    @ForOverride
    public abstract B doForward(A a);

    @Override // com.google.common.base.Function
    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @CheckReturnValue
    public Converter<B, A> reverse() {
        C1600nw c1600nw = this.f14472a;
        if (c1600nw == null) {
            C1600nw c1600nw2 = new C1600nw(this);
            this.f14472a = c1600nw2;
            return c1600nw2;
        }
        return c1600nw;
    }
}
