package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;
import p000.AbstractC1726qj;
import p000.C1851tx;
import p000.C1925vx;
import p000.C1999xx;
import p000.InterfaceC1888ux;

@CanIgnoreReturnValue
@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public class CycleDetectingLockFactory {

    /* renamed from: b */
    public static final ConcurrentMap f15308b = new MapMaker().weakKeys().makeMap();

    /* renamed from: c */
    public static final Logger f15309c = Logger.getLogger(CycleDetectingLockFactory.class.getName());

    /* renamed from: d */
    public static final C1851tx f15310d = new C1851tx(0);

    /* renamed from: a */
    public final Policy f15311a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Beta
    /* loaded from: classes2.dex */
    public static abstract class Policies implements Policy {
        public static final Policies DISABLED;
        public static final Policies THROW;
        public static final Policies WARN;

        /* renamed from: a */
        public static final /* synthetic */ Policies[] f15312a;

        static {
            C1021t0 c1021t0 = new C1021t0();
            THROW = c1021t0;
            C1023u0 c1023u0 = new C1023u0();
            WARN = c1023u0;
            C1025v0 c1025v0 = new C1025v0();
            DISABLED = c1025v0;
            f15312a = new Policies[]{c1021t0, c1023u0, c1025v0};
        }

        public static Policies valueOf(String str) {
            return (Policies) Enum.valueOf(Policies.class, str);
        }

        public static Policies[] values() {
            return (Policies[]) f15312a.clone();
        }
    }

    @Beta
    /* loaded from: classes2.dex */
    public interface Policy {
        void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);
    }

    @Beta
    /* loaded from: classes2.dex */
    public static final class PotentialDeadlockException extends C1017r0 {

        /* renamed from: c */
        public final C1017r0 f15313c;

        public PotentialDeadlockException(C1019s0 c1019s0, C1019s0 c1019s02, C1017r0 c1017r0) {
            super(c1019s0, c1019s02);
            this.f15313c = c1017r0;
            initCause(c1017r0);
        }

        public C1017r0 getConflictingStackTrace() {
            return this.f15313c;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            String message = super.getMessage();
            Objects.requireNonNull(message);
            StringBuilder sb = new StringBuilder(message);
            for (Throwable th = this.f15313c; th != null; th = th.getCause()) {
                sb.append(", ");
                sb.append(th.getMessage());
            }
            return sb.toString();
        }
    }

    @Beta
    /* loaded from: classes2.dex */
    public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory {

        /* renamed from: e */
        public final Map f15314e;

        public WithExplicitOrdering(Policy policy, Map map) {
            super(policy);
            this.f15314e = map;
        }

        public ReentrantLock newReentrantLock(E e) {
            return newReentrantLock((WithExplicitOrdering<E>) e, false);
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E e) {
            return newReentrantReadWriteLock((WithExplicitOrdering<E>) e, false);
        }

        public ReentrantLock newReentrantLock(E e, boolean z) {
            if (this.f15311a == Policies.DISABLED) {
                return new ReentrantLock(z);
            }
            C1019s0 c1019s0 = (C1019s0) this.f15314e.get(e);
            Objects.requireNonNull(c1019s0);
            return new C1925vx(this, c1019s0, z);
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E e, boolean z) {
            if (this.f15311a == Policies.DISABLED) {
                return new ReentrantReadWriteLock(z);
            }
            C1019s0 c1019s0 = (C1019s0) this.f15314e.get(e);
            Objects.requireNonNull(c1019s0);
            return new C1999xx(this, c1019s0, z);
        }
    }

    public CycleDetectingLockFactory(Policy policy) {
        this.f15311a = (Policy) Preconditions.checkNotNull(policy);
    }

    /* renamed from: a */
    public static void m4324a(CycleDetectingLockFactory cycleDetectingLockFactory, InterfaceC1888ux interfaceC1888ux) {
        cycleDetectingLockFactory.getClass();
        if (!interfaceC1888ux.mo7781b()) {
            ArrayList arrayList = (ArrayList) f15310d.get();
            C1019s0 mo7780a = interfaceC1888ux.mo7780a();
            mo7780a.m4355a(cycleDetectingLockFactory.f15311a, arrayList);
            arrayList.add(mo7780a);
        }
    }

    /* renamed from: b */
    public static void m4325b(InterfaceC1888ux interfaceC1888ux) {
        if (!interfaceC1888ux.mo7781b()) {
            ArrayList arrayList = (ArrayList) f15310d.get();
            C1019s0 mo7780a = interfaceC1888ux.mo7780a();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size) == mo7780a) {
                    arrayList.remove(size);
                    return;
                }
            }
        }
    }

    public static CycleDetectingLockFactory newInstance(Policy policy) {
        return new CycleDetectingLockFactory(policy);
    }

    public static <E extends Enum<E>> WithExplicitOrdering<E> newInstanceWithExplicitOrdering(Class<E> cls, Policy policy) {
        int i;
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(policy);
        ConcurrentMap concurrentMap = f15308b;
        Map map = (Map) concurrentMap.get(cls);
        if (map == null) {
            EnumMap newEnumMap = Maps.newEnumMap(cls);
            E[] enumConstants = cls.getEnumConstants();
            int length = enumConstants.length;
            ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(length);
            int length2 = enumConstants.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    break;
                }
                E e = enumConstants[i3];
                String simpleName = e.getDeclaringClass().getSimpleName();
                String name = e.name();
                C1019s0 c1019s0 = new C1019s0(AbstractC1726qj.m7059o(simpleName, ".", name, AbstractC1726qj.m7052h(simpleName.length() + 1, name)));
                newArrayListWithCapacity.add(c1019s0);
                newEnumMap.put((EnumMap) e, (E) c1019s0);
                i3++;
            }
            for (i = 1; i < length; i++) {
                ((C1019s0) newArrayListWithCapacity.get(i)).m4355a(Policies.THROW, newArrayListWithCapacity.subList(0, i));
            }
            while (i2 < length - 1) {
                i2++;
                ((C1019s0) newArrayListWithCapacity.get(i2)).m4355a(Policies.DISABLED, newArrayListWithCapacity.subList(i2, length));
            }
            Map unmodifiableMap = Collections.unmodifiableMap(newEnumMap);
            map = (Map) MoreObjects.firstNonNull((Map) concurrentMap.putIfAbsent(cls, unmodifiableMap), unmodifiableMap);
        }
        return new WithExplicitOrdering<>(policy, map);
    }

    public ReentrantLock newReentrantLock(String str) {
        return newReentrantLock(str, false);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String str) {
        return newReentrantReadWriteLock(str, false);
    }

    public ReentrantLock newReentrantLock(String str, boolean z) {
        if (this.f15311a == Policies.DISABLED) {
            return new ReentrantLock(z);
        }
        return new C1925vx(this, new C1019s0(str), z);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String str, boolean z) {
        if (this.f15311a == Policies.DISABLED) {
            return new ReentrantReadWriteLock(z);
        }
        return new C1999xx(this, new C1019s0(str), z);
    }
}
