package p000;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.ConcurrentMapC0840e;
import com.google.common.cache.ForwardingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.Weigher;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ob1 extends ForwardingCache implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public final ub1 f23698a;

    /* renamed from: b */
    public final ub1 f23699b;

    /* renamed from: c */
    public final Equivalence f23700c;

    /* renamed from: d */
    public final Equivalence f23701d;

    /* renamed from: e */
    public final long f23702e;

    /* renamed from: f */
    public final long f23703f;

    /* renamed from: g */
    public final long f23704g;

    /* renamed from: h */
    public final Weigher f23705h;

    /* renamed from: i */
    public final int f23706i;

    /* renamed from: j */
    public final RemovalListener f23707j;

    /* renamed from: k */
    public final Ticker f23708k;

    /* renamed from: l */
    public final CacheLoader f23709l;

    /* renamed from: m */
    public transient Cache f23710m;

    public ob1(ConcurrentMapC0840e concurrentMapC0840e) {
        this.f23698a = concurrentMapC0840e.f14593g;
        this.f23699b = concurrentMapC0840e.f14594h;
        this.f23700c = concurrentMapC0840e.f14591e;
        this.f23701d = concurrentMapC0840e.f14592f;
        this.f23702e = concurrentMapC0840e.f14598l;
        this.f23703f = concurrentMapC0840e.f14597k;
        this.f23704g = concurrentMapC0840e.f14595i;
        this.f23705h = concurrentMapC0840e.f14596j;
        this.f23706i = concurrentMapC0840e.f14590d;
        this.f23707j = concurrentMapC0840e.f14601o;
        Ticker systemTicker = Ticker.systemTicker();
        Ticker ticker = concurrentMapC0840e.f14602p;
        this.f23708k = (ticker == systemTicker || ticker == CacheBuilder.f14524t) ? null : ticker;
        this.f23709l = concurrentMapC0840e.f14605s;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f23710m = m6526e().build();
    }

    private Object readResolve() {
        return this.f23710m;
    }

    @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
    public final Cache delegate() {
        return this.f23710m;
    }

    /* renamed from: e */
    public final CacheBuilder m6526e() {
        boolean z;
        boolean z2;
        CacheBuilder<Object, Object> newBuilder = CacheBuilder.newBuilder();
        ub1 ub1Var = newBuilder.f14532g;
        boolean z3 = true;
        if (ub1Var == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Key strength was already set to %s", ub1Var);
        newBuilder.f14532g = (ub1) Preconditions.checkNotNull(this.f23698a);
        newBuilder.m3790b(this.f23699b);
        Equivalence equivalence = newBuilder.f14537l;
        if (equivalence == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2, "key equivalence was already set to %s", equivalence);
        newBuilder.f14537l = (Equivalence) Preconditions.checkNotNull(this.f23700c);
        Equivalence equivalence2 = newBuilder.f14538m;
        if (equivalence2 != null) {
            z3 = false;
        }
        Preconditions.checkState(z3, "value equivalence was already set to %s", equivalence2);
        newBuilder.f14538m = (Equivalence) Preconditions.checkNotNull(this.f23701d);
        CacheBuilder<K1, V1> removalListener = newBuilder.concurrencyLevel(this.f23706i).removalListener(this.f23707j);
        removalListener.f14526a = false;
        long j = this.f23702e;
        if (j > 0) {
            removalListener.expireAfterWrite(j, TimeUnit.NANOSECONDS);
        }
        long j2 = this.f23703f;
        if (j2 > 0) {
            removalListener.expireAfterAccess(j2, TimeUnit.NANOSECONDS);
        }
        EnumC1985xj enumC1985xj = EnumC1985xj.f28583a;
        long j3 = this.f23704g;
        Weigher weigher = this.f23705h;
        if (weigher != enumC1985xj) {
            removalListener.weigher(weigher);
            if (j3 != -1) {
                removalListener.maximumWeight(j3);
            }
        } else if (j3 != -1) {
            removalListener.maximumSize(j3);
        }
        Ticker ticker = this.f23708k;
        if (ticker != null) {
            removalListener.ticker(ticker);
        }
        return removalListener;
    }

    @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return this.f23710m;
    }
}
