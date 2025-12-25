package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000.C1911vj;
import p000.tb1;
import p000.ub1;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class CacheBuilder<K, V> {

    /* renamed from: q */
    public static final Supplier f14521q = Suppliers.ofInstance(new Object());

    /* renamed from: r */
    public static final CacheStats f14522r = new CacheStats(0, 0, 0, 0, 0, 0);

    /* renamed from: s */
    public static final C0837b f14523s = new Object();

    /* renamed from: t */
    public static final C1911vj f14524t = new Ticker();

    /* renamed from: u */
    public static final Logger f14525u = Logger.getLogger(CacheBuilder.class.getName());

    /* renamed from: a */
    public boolean f14526a;

    /* renamed from: b */
    public int f14527b;

    /* renamed from: c */
    public int f14528c;

    /* renamed from: d */
    public long f14529d;

    /* renamed from: e */
    public long f14530e;

    /* renamed from: f */
    public Weigher f14531f;

    /* renamed from: g */
    public ub1 f14532g;

    /* renamed from: h */
    public ub1 f14533h;

    /* renamed from: i */
    public long f14534i;

    /* renamed from: j */
    public long f14535j;

    /* renamed from: k */
    public long f14536k;

    /* renamed from: l */
    public Equivalence f14537l;

    /* renamed from: m */
    public Equivalence f14538m;

    /* renamed from: n */
    public RemovalListener f14539n;

    /* renamed from: o */
    public Ticker f14540o;

    /* renamed from: p */
    public Supplier f14541p;

    @CheckReturnValue
    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(CacheBuilderSpec cacheBuilderSpec) {
        cacheBuilderSpec.getClass();
        CacheBuilder<Object, Object> newBuilder = newBuilder();
        Integer num = cacheBuilderSpec.f14545a;
        if (num != null) {
            newBuilder.initialCapacity(num.intValue());
        }
        Long l = cacheBuilderSpec.f14546b;
        if (l != null) {
            newBuilder.maximumSize(l.longValue());
        }
        Long l2 = cacheBuilderSpec.f14547c;
        if (l2 != null) {
            newBuilder.maximumWeight(l2.longValue());
        }
        Integer num2 = cacheBuilderSpec.f14548d;
        if (num2 != null) {
            newBuilder.concurrencyLevel(num2.intValue());
        }
        tb1 tb1Var = cacheBuilderSpec.f14549e;
        if (tb1Var != null) {
            if (tb1Var.ordinal() == 2) {
                newBuilder.weakKeys();
            } else {
                throw new AssertionError();
            }
        }
        ub1 ub1Var = cacheBuilderSpec.f14550f;
        if (ub1Var != null) {
            int ordinal = ub1Var.ordinal();
            if (ordinal == 1) {
                newBuilder.softValues();
            } else if (ordinal == 2) {
                newBuilder.weakValues();
            } else {
                throw new AssertionError();
            }
        }
        Boolean bool = cacheBuilderSpec.f14551g;
        if (bool != null && bool.booleanValue()) {
            newBuilder.recordStats();
        }
        TimeUnit timeUnit = cacheBuilderSpec.f14553i;
        if (timeUnit != null) {
            newBuilder.expireAfterWrite(cacheBuilderSpec.f14552h, timeUnit);
        }
        TimeUnit timeUnit2 = cacheBuilderSpec.f14555k;
        if (timeUnit2 != null) {
            newBuilder.expireAfterAccess(cacheBuilderSpec.f14554j, timeUnit2);
        }
        TimeUnit timeUnit3 = cacheBuilderSpec.f14557m;
        if (timeUnit3 != null) {
            newBuilder.refreshAfterWrite(cacheBuilderSpec.f14556l, timeUnit3);
        }
        newBuilder.f14526a = false;
        return newBuilder;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.common.cache.CacheBuilder, com.google.common.cache.CacheBuilder<java.lang.Object, java.lang.Object>] */
    @CheckReturnValue
    public static CacheBuilder<Object, Object> newBuilder() {
        ?? obj = new Object();
        obj.f14526a = true;
        obj.f14527b = -1;
        obj.f14528c = -1;
        obj.f14529d = -1L;
        obj.f14530e = -1L;
        obj.f14534i = -1L;
        obj.f14535j = -1L;
        obj.f14536k = -1L;
        obj.f14541p = f14521q;
        return obj;
    }

    /* renamed from: a */
    public final void m3789a() {
        boolean z = false;
        if (this.f14531f == null) {
            if (this.f14530e == -1) {
                z = true;
            }
            Preconditions.checkState(z, "maximumWeight requires weigher");
        } else if (this.f14526a) {
            if (this.f14530e != -1) {
                z = true;
            }
            Preconditions.checkState(z, "weigher requires maximumWeight");
        } else if (this.f14530e == -1) {
            f14525u.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    /* renamed from: b */
    public final void m3790b(ub1 ub1Var) {
        boolean z;
        ub1 ub1Var2 = this.f14533h;
        if (ub1Var2 == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Value strength was already set to %s", ub1Var2);
        this.f14533h = (ub1) Preconditions.checkNotNull(ub1Var);
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> cacheLoader) {
        m3789a();
        return (LoadingCache<K1, V1>) new C0838c(new ConcurrentMapC0840e(this, (CacheLoader) Preconditions.checkNotNull(cacheLoader)));
    }

    public CacheBuilder<K, V> concurrencyLevel(int i) {
        boolean z;
        int i2 = this.f14528c;
        boolean z2 = false;
        if (i2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "concurrency level was already set to %s", i2);
        if (i > 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2);
        this.f14528c = i;
        return this;
    }

    public CacheBuilder<K, V> expireAfterAccess(long j, TimeUnit timeUnit) {
        boolean z;
        long j2 = this.f14535j;
        boolean z2 = false;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "expireAfterAccess was already set to %s ns", j2);
        if (j >= 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "duration cannot be negative: %s %s", j, timeUnit);
        this.f14535j = timeUnit.toNanos(j);
        return this;
    }

    public CacheBuilder<K, V> expireAfterWrite(long j, TimeUnit timeUnit) {
        boolean z;
        long j2 = this.f14534i;
        boolean z2 = false;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "expireAfterWrite was already set to %s ns", j2);
        if (j >= 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "duration cannot be negative: %s %s", j, timeUnit);
        this.f14534i = timeUnit.toNanos(j);
        return this;
    }

    public CacheBuilder<K, V> initialCapacity(int i) {
        boolean z;
        int i2 = this.f14527b;
        boolean z2 = false;
        if (i2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "initial capacity was already set to %s", i2);
        if (i >= 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2);
        this.f14527b = i;
        return this;
    }

    public CacheBuilder<K, V> maximumSize(long j) {
        boolean z;
        boolean z2;
        boolean z3;
        long j2 = this.f14529d;
        boolean z4 = false;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "maximum size was already set to %s", j2);
        long j3 = this.f14530e;
        if (j3 == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2, "maximum weight was already set to %s", j3);
        if (this.f14531f == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "maximum size can not be combined with weigher");
        if (j >= 0) {
            z4 = true;
        }
        Preconditions.checkArgument(z4, "maximum size must not be negative");
        this.f14529d = j;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> maximumWeight(long j) {
        boolean z;
        boolean z2;
        long j2 = this.f14530e;
        boolean z3 = false;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "maximum weight was already set to %s", j2);
        long j3 = this.f14529d;
        if (j3 == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2, "maximum size was already set to %s", j3);
        if (j >= 0) {
            z3 = true;
        }
        Preconditions.checkArgument(z3, "maximum weight must not be negative");
        this.f14530e = j;
        return this;
    }

    public CacheBuilder<K, V> recordStats() {
        this.f14541p = f14523s;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> refreshAfterWrite(long j, TimeUnit timeUnit) {
        boolean z;
        Preconditions.checkNotNull(timeUnit);
        long j2 = this.f14536k;
        boolean z2 = false;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "refresh was already set to %s ns", j2);
        if (j > 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "duration must be positive: %s %s", j, timeUnit);
        this.f14536k = timeUnit.toNanos(j);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> removalListener) {
        boolean z;
        if (this.f14539n == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        this.f14539n = (RemovalListener) Preconditions.checkNotNull(removalListener);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> softValues() {
        m3790b(ub1.f27186b);
        return this;
    }

    public CacheBuilder<K, V> ticker(Ticker ticker) {
        boolean z;
        if (this.f14540o == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        this.f14540o = (Ticker) Preconditions.checkNotNull(ticker);
        return this;
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        int i = this.f14527b;
        if (i != -1) {
            stringHelper.add("initialCapacity", i);
        }
        int i2 = this.f14528c;
        if (i2 != -1) {
            stringHelper.add("concurrencyLevel", i2);
        }
        long j = this.f14529d;
        if (j != -1) {
            stringHelper.add("maximumSize", j);
        }
        long j2 = this.f14530e;
        if (j2 != -1) {
            stringHelper.add("maximumWeight", j2);
        }
        long j3 = this.f14534i;
        if (j3 != -1) {
            StringBuilder sb = new StringBuilder(22);
            sb.append(j3);
            sb.append("ns");
            stringHelper.add("expireAfterWrite", sb.toString());
        }
        long j4 = this.f14535j;
        if (j4 != -1) {
            StringBuilder sb2 = new StringBuilder(22);
            sb2.append(j4);
            sb2.append("ns");
            stringHelper.add("expireAfterAccess", sb2.toString());
        }
        ub1 ub1Var = this.f14532g;
        if (ub1Var != null) {
            stringHelper.add("keyStrength", Ascii.toLowerCase(ub1Var.toString()));
        }
        ub1 ub1Var2 = this.f14533h;
        if (ub1Var2 != null) {
            stringHelper.add("valueStrength", Ascii.toLowerCase(ub1Var2.toString()));
        }
        if (this.f14537l != null) {
            stringHelper.addValue("keyEquivalence");
        }
        if (this.f14538m != null) {
            stringHelper.addValue("valueEquivalence");
        }
        if (this.f14539n != null) {
            stringHelper.addValue("removalListener");
        }
        return stringHelper.toString();
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakKeys() {
        boolean z;
        tb1 tb1Var = ub1.f27187c;
        ub1 ub1Var = this.f14532g;
        if (ub1Var == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Key strength was already set to %s", ub1Var);
        this.f14532g = (ub1) Preconditions.checkNotNull(tb1Var);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakValues() {
        m3790b(ub1.f27187c);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> weigher) {
        boolean z;
        boolean z2 = false;
        if (this.f14531f == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (this.f14526a) {
            long j = this.f14529d;
            if (j == -1) {
                z2 = true;
            }
            Preconditions.checkState(z2, "weigher can not be combined with maximum size", j);
        }
        this.f14531f = (Weigher) Preconditions.checkNotNull(weigher);
        return this;
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        m3789a();
        Preconditions.checkState(this.f14536k == -1, "refreshAfterWrite requires a LoadingCache");
        return new C0838c(new ConcurrentMapC0840e(this, null));
    }

    @CheckReturnValue
    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(String str) {
        return from(CacheBuilderSpec.parse(str));
    }
}
