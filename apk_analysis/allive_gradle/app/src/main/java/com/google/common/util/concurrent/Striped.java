package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import p000.C1153ec;
import p000.ap2;
import p000.cp2;
import p000.e10;
import p000.wo2;
import p000.xo2;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class Striped<L> {
    /* renamed from: b */
    public static ap2 m4345b(int i, Supplier supplier) {
        if (i < 1024) {
            return new cp2(i, supplier);
        }
        return new xo2(i, supplier);
    }

    public static Striped<Lock> lazyWeakLock(int i) {
        return m4345b(i, new e10(4));
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int i) {
        return m4345b(i, new e10(2));
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int i, int i2) {
        return m4345b(i, new C1153ec(i2, 3));
    }

    public static Striped<Lock> lock(int i) {
        return new wo2(i, new e10(3));
    }

    public static Striped<ReadWriteLock> readWriteLock(int i) {
        return new wo2(i, new e10(5));
    }

    public static Striped<Semaphore> semaphore(int i, int i2) {
        return new wo2(i, new C1153ec(i2, 2));
    }

    /* renamed from: a */
    public abstract int mo1957a(Object obj);

    public Iterable<L> bulkGet(Iterable<? extends Object> iterable) {
        ArrayList newArrayList = Lists.newArrayList(iterable);
        if (newArrayList.isEmpty()) {
            return ImmutableList.m3902of();
        }
        int[] iArr = new int[newArrayList.size()];
        for (int i = 0; i < newArrayList.size(); i++) {
            iArr[i] = mo1957a(newArrayList.get(i));
        }
        Arrays.sort(iArr);
        int i2 = iArr[0];
        newArrayList.set(0, getAt(i2));
        for (int i3 = 1; i3 < newArrayList.size(); i3++) {
            int i4 = iArr[i3];
            if (i4 == i2) {
                newArrayList.set(i3, newArrayList.get(i3 - 1));
            } else {
                newArrayList.set(i3, getAt(i4));
                i2 = i4;
            }
        }
        return Collections.unmodifiableList(newArrayList);
    }

    public abstract L get(Object obj);

    public abstract L getAt(int i);

    public abstract int size();
}
