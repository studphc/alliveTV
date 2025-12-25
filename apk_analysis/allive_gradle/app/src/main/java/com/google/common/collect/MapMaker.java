package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p000.dx0;
import p000.gf1;
import p000.hf1;
import p000.if1;
import p000.wd0;
import p000.we1;
import p000.zf1;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class MapMaker {

    /* renamed from: a */
    public boolean f14730a;

    /* renamed from: b */
    public int f14731b = -1;

    /* renamed from: c */
    public int f14732c = -1;

    /* renamed from: d */
    public if1 f14733d;

    /* renamed from: e */
    public if1 f14734e;

    /* renamed from: f */
    public Equivalence f14735f;

    /* renamed from: a */
    public final if1 m4043a() {
        return (if1) MoreObjects.firstNonNull(this.f14733d, if1.f18394a);
    }

    /* renamed from: b */
    public final if1 m4044b() {
        return (if1) MoreObjects.firstNonNull(this.f14734e, if1.f18394a);
    }

    @CanIgnoreReturnValue
    public MapMaker concurrencyLevel(int i) {
        boolean z;
        int i2 = this.f14732c;
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
        this.f14732c = i;
        return this;
    }

    @CanIgnoreReturnValue
    public MapMaker initialCapacity(int i) {
        boolean z;
        int i2 = this.f14731b;
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
        this.f14731b = i;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> makeMap() {
        if (!this.f14730a) {
            int i = this.f14731b;
            if (i == -1) {
                i = 16;
            }
            int i2 = this.f14732c;
            if (i2 == -1) {
                i2 = 4;
            }
            return new ConcurrentHashMap(i, 0.75f, i2);
        }
        we1 we1Var = zf1.f29349j;
        if1 m4043a = m4043a();
        gf1 gf1Var = if1.f18394a;
        if (m4043a == gf1Var && m4044b() == gf1Var) {
            return new zf1(this, dx0.f16573b);
        }
        if1 m4043a2 = m4043a();
        hf1 hf1Var = if1.f18395b;
        if (m4043a2 == gf1Var && m4044b() == hf1Var) {
            return new zf1(this, wd0.f28142c);
        }
        if (m4043a() == hf1Var && m4044b() == gf1Var) {
            return new zf1(this, wd0.f28143d);
        }
        if (m4043a() == hf1Var && m4044b() == hf1Var) {
            return new zf1(this, dx0.f16575d);
        }
        throw new AssertionError();
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        int i = this.f14731b;
        if (i != -1) {
            stringHelper.add("initialCapacity", i);
        }
        int i2 = this.f14732c;
        if (i2 != -1) {
            stringHelper.add("concurrencyLevel", i2);
        }
        if1 if1Var = this.f14733d;
        if (if1Var != null) {
            stringHelper.add("keyStrength", Ascii.toLowerCase(if1Var.toString()));
        }
        if1 if1Var2 = this.f14734e;
        if (if1Var2 != null) {
            stringHelper.add("valueStrength", Ascii.toLowerCase(if1Var2.toString()));
        }
        if (this.f14735f != null) {
            stringHelper.addValue("keyEquivalence");
        }
        return stringHelper.toString();
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker weakKeys() {
        boolean z;
        hf1 hf1Var = if1.f18395b;
        if1 if1Var = this.f14733d;
        if (if1Var == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Key strength was already set to %s", if1Var);
        this.f14733d = (if1) Preconditions.checkNotNull(hf1Var);
        this.f14730a = true;
        return this;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker weakValues() {
        boolean z;
        hf1 hf1Var = if1.f18395b;
        if1 if1Var = this.f14734e;
        if (if1Var == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Value strength was already set to %s", if1Var);
        this.f14734e = (if1) Preconditions.checkNotNull(hf1Var);
        this.f14730a = true;
        return this;
    }
}
