package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;
import p000.C1967x1;
import p000.o63;
import p000.p63;

/* renamed from: com.google.common.collect.b */
/* loaded from: classes.dex */
public abstract class AbstractC0846b extends AbstractC0856d implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    public transient C0869f2 f14773c;

    /* renamed from: d */
    public transient long f14774d;

    public AbstractC0846b(int i) {
        this.f14773c = mo3881e(i);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        this.f14773c = mo3881e(3);
        AbstractC0924q2.m4161d(this, objectInputStream, readInt);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        AbstractC0924q2.m4164g(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int add(Object obj, int i) {
        boolean z;
        if (i == 0) {
            return count(obj);
        }
        boolean z2 = true;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "occurrences cannot be negative: %s", i);
        int m4095g = this.f14773c.m4095g(obj);
        if (m4095g == -1) {
            this.f14773c.m4101m(i, obj);
            this.f14774d += i;
            return 0;
        }
        int m4094f = this.f14773c.m4094f(m4095g);
        long j = i;
        long j2 = m4094f + j;
        if (j2 > 2147483647L) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "too many occurrences: %s", j2);
        C0869f2 c0869f2 = this.f14773c;
        Preconditions.checkElementIndex(m4095g, c0869f2.f14821c);
        c0869f2.f14820b[m4095g] = (int) j2;
        this.f14774d += j;
        return m4094f;
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: b */
    public final int mo3838b() {
        return this.f14773c.f14821c;
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: c */
    public final Iterator mo3839c() {
        return new C1967x1(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f14773c.mo4089a();
        this.f14774d = 0L;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(@CheckForNull Object obj) {
        return this.f14773c.m4092d(obj);
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: d */
    public final Iterator mo3840d() {
        return new C0841a(this);
    }

    /* renamed from: e */
    public abstract C0869f2 mo3881e(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator<Object> iterator() {
        return Multisets.m4062c(this);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int remove(@CheckForNull Object obj, int i) {
        boolean z;
        if (i == 0) {
            return count(obj);
        }
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "occurrences cannot be negative: %s", i);
        int m4095g = this.f14773c.m4095g(obj);
        if (m4095g == -1) {
            return 0;
        }
        int m4094f = this.f14773c.m4094f(m4095g);
        if (m4094f > i) {
            C0869f2 c0869f2 = this.f14773c;
            Preconditions.checkElementIndex(m4095g, c0869f2.f14821c);
            c0869f2.f14820b[m4095g] = m4094f - i;
        } else {
            this.f14773c.m4103o(m4095g);
            i = m4094f;
        }
        this.f14774d -= i;
        return m4094f;
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int setCount(Object obj, int i) {
        int m4101m;
        p63.m6869m(i, "count");
        C0869f2 c0869f2 = this.f14773c;
        if (i == 0) {
            c0869f2.getClass();
            m4101m = c0869f2.m4102n(obj, o63.m6454N(obj));
        } else {
            m4101m = c0869f2.m4101m(i, obj);
        }
        this.f14774d += i - m4101m;
        return m4101m;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return Ints.saturatedCast(this.f14774d);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public final boolean setCount(Object obj, int i, int i2) {
        p63.m6869m(i, "oldCount");
        p63.m6869m(i2, "newCount");
        int m4095g = this.f14773c.m4095g(obj);
        if (m4095g == -1) {
            if (i != 0) {
                return false;
            }
            if (i2 > 0) {
                this.f14773c.m4101m(i2, obj);
                this.f14774d += i2;
            }
            return true;
        }
        if (this.f14773c.m4094f(m4095g) != i) {
            return false;
        }
        if (i2 == 0) {
            this.f14773c.m4103o(m4095g);
            this.f14774d -= i;
        } else {
            C0869f2 c0869f2 = this.f14773c;
            Preconditions.checkElementIndex(m4095g, c0869f2.f14821c);
            c0869f2.f14820b[m4095g] = i2;
            this.f14774d += i2 - i;
        }
        return true;
    }
}
