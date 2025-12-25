package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import p000.w41;
import p000.x41;

@GwtIncompatible
/* loaded from: classes.dex */
public final class Interners {

    /* loaded from: classes.dex */
    public static class InternerBuilder {

        /* renamed from: a */
        public final MapMaker f14721a = new MapMaker();

        /* renamed from: b */
        public boolean f14722b = true;

        public <E> Interner<E> build() {
            boolean z = this.f14722b;
            MapMaker mapMaker = this.f14721a;
            if (!z) {
                mapMaker.weakKeys();
            }
            return new x41(mapMaker);
        }

        public InternerBuilder concurrencyLevel(int i) {
            this.f14721a.concurrencyLevel(i);
            return this;
        }

        public InternerBuilder strong() {
            this.f14722b = true;
            return this;
        }

        @GwtIncompatible("java.lang.ref.WeakReference")
        public InternerBuilder weak() {
            this.f14722b = false;
            return this;
        }
    }

    public static <E> Function<E, E> asFunction(Interner<E> interner) {
        return new w41((Interner) Preconditions.checkNotNull(interner));
    }

    public static InternerBuilder newBuilder() {
        return new InternerBuilder();
    }

    public static <E> Interner<E> newStrongInterner() {
        return newBuilder().strong().build();
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public static <E> Interner<E> newWeakInterner() {
        return newBuilder().weak().build();
    }
}
