package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;
import p000.C0560bk;
import p000.C0596ck;
import p000.C1161ek;
import p000.C2022yj;
import p000.C2059zj;
import p000.InterfaceC1125dk;
import p000.tb1;
import p000.ub1;

@GwtIncompatible
/* loaded from: classes.dex */
public final class CacheBuilderSpec {

    /* renamed from: o */
    public static final Splitter f14542o = Splitter.m3782on(',').trimResults();

    /* renamed from: p */
    public static final Splitter f14543p = Splitter.m3782on('=').trimResults();

    /* renamed from: q */
    public static final ImmutableMap f14544q = ImmutableMap.builder().put("initialCapacity", new C2059zj(1)).put("maximumSize", new C0596ck(0)).put("maximumWeight", new C0596ck(1)).put("concurrencyLevel", new C2059zj(0)).put("weakKeys", new C0560bk(0)).put("softValues", new C1161ek(ub1.f27186b)).put("weakValues", new C1161ek(ub1.f27187c)).put("recordStats", new C0560bk(1)).put("expireAfterAccess", new C2022yj(0)).put("expireAfterWrite", new C2022yj(2)).put("refreshAfterWrite", new C2022yj(1)).put("refreshInterval", new C2022yj(1)).buildOrThrow();

    /* renamed from: a */
    public Integer f14545a;

    /* renamed from: b */
    public Long f14546b;

    /* renamed from: c */
    public Long f14547c;

    /* renamed from: d */
    public Integer f14548d;

    /* renamed from: e */
    public tb1 f14549e;

    /* renamed from: f */
    public ub1 f14550f;

    /* renamed from: g */
    public Boolean f14551g;

    /* renamed from: h */
    public long f14552h;

    /* renamed from: i */
    public TimeUnit f14553i;

    /* renamed from: j */
    public long f14554j;

    /* renamed from: k */
    public TimeUnit f14555k;

    /* renamed from: l */
    public long f14556l;

    /* renamed from: m */
    public TimeUnit f14557m;

    /* renamed from: n */
    public final String f14558n;

    public CacheBuilderSpec(String str) {
        this.f14558n = str;
    }

    /* renamed from: a */
    public static Long m3791a(long j, TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return Long.valueOf(timeUnit.toNanos(j));
    }

    public static CacheBuilderSpec disableCaching() {
        return parse("maximumSize=0");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static CacheBuilderSpec parse(String str) {
        boolean z;
        String str2;
        CacheBuilderSpec cacheBuilderSpec = new CacheBuilderSpec(str);
        if (!str.isEmpty()) {
            for (String str3 : f14542o.split(str)) {
                ImmutableList copyOf = ImmutableList.copyOf(f14543p.split(str3));
                Preconditions.checkArgument(!copyOf.isEmpty(), "blank key-value pair");
                boolean z2 = false;
                if (copyOf.size() <= 2) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "key-value pair %s with more than one equals sign", str3);
                String str4 = (String) copyOf.get(0);
                InterfaceC1125dk interfaceC1125dk = (InterfaceC1125dk) f14544q.get(str4);
                if (interfaceC1125dk != null) {
                    z2 = true;
                }
                Preconditions.checkArgument(z2, "unknown key %s", str4);
                if (copyOf.size() == 1) {
                    str2 = null;
                } else {
                    str2 = (String) copyOf.get(1);
                }
                interfaceC1125dk.mo105a(cacheBuilderSpec, str4, str2);
            }
        }
        return cacheBuilderSpec;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec) obj;
        if (Objects.equal(this.f14545a, cacheBuilderSpec.f14545a) && Objects.equal(this.f14546b, cacheBuilderSpec.f14546b) && Objects.equal(this.f14547c, cacheBuilderSpec.f14547c) && Objects.equal(this.f14548d, cacheBuilderSpec.f14548d) && Objects.equal(this.f14549e, cacheBuilderSpec.f14549e) && Objects.equal(this.f14550f, cacheBuilderSpec.f14550f) && Objects.equal(this.f14551g, cacheBuilderSpec.f14551g) && Objects.equal(m3791a(this.f14552h, this.f14553i), m3791a(cacheBuilderSpec.f14552h, cacheBuilderSpec.f14553i)) && Objects.equal(m3791a(this.f14554j, this.f14555k), m3791a(cacheBuilderSpec.f14554j, cacheBuilderSpec.f14555k)) && Objects.equal(m3791a(this.f14556l, this.f14557m), m3791a(cacheBuilderSpec.f14556l, cacheBuilderSpec.f14557m))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f14545a, this.f14546b, this.f14547c, this.f14548d, this.f14549e, this.f14550f, this.f14551g, m3791a(this.f14552h, this.f14553i), m3791a(this.f14554j, this.f14555k), m3791a(this.f14556l, this.f14557m));
    }

    public String toParsableString() {
        return this.f14558n;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(toParsableString()).toString();
    }
}
