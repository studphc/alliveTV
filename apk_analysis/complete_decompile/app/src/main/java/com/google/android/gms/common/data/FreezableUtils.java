package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import p000.zr2;

/* loaded from: classes.dex */
public final class FreezableUtils {
    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull ArrayList<E> arrayList) {
        zr2 zr2Var = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zr2Var.add(arrayList.get(i).freeze());
        }
        return zr2Var;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(@NonNull Iterable<E> iterable) {
        zr2 zr2Var = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            zr2Var.add(it.next().freeze());
        }
        return zr2Var;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull E[] eArr) {
        zr2 zr2Var = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            zr2Var.add(e.freeze());
        }
        return zr2Var;
    }
}
