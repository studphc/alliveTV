package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p000.me1;

/* loaded from: classes.dex */
public class LruCache<T, Y> {

    /* renamed from: a */
    public final LinkedHashMap f9172a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b */
    public final long f9173b;

    /* renamed from: c */
    public long f9174c;

    /* renamed from: d */
    public long f9175d;

    public LruCache(long j) {
        this.f9173b = j;
        this.f9174c = j;
    }

    public void clearMemory() {
        trimToSize(0L);
    }

    public synchronized boolean contains(@NonNull T t) {
        return this.f9172a.containsKey(t);
    }

    @Nullable
    public synchronized Y get(@NonNull T t) {
        Y y;
        me1 me1Var = (me1) this.f9172a.get(t);
        if (me1Var != null) {
            y = (Y) me1Var.f22915a;
        } else {
            y = null;
        }
        return y;
    }

    public synchronized int getCount() {
        return this.f9172a.size();
    }

    public synchronized long getCurrentSize() {
        return this.f9175d;
    }

    public synchronized long getMaxSize() {
        return this.f9174c;
    }

    public int getSize(@Nullable Y y) {
        return 1;
    }

    public void onItemEvicted(@NonNull T t, @Nullable Y y) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public synchronized Y put(@NonNull T t, @Nullable Y y) {
        me1 me1Var;
        int size = getSize(y);
        long j = size;
        Y y2 = null;
        if (j >= this.f9174c) {
            onItemEvicted(t, y);
            return null;
        }
        if (y != null) {
            this.f9175d += j;
        }
        LinkedHashMap linkedHashMap = this.f9172a;
        if (y == null) {
            me1Var = null;
        } else {
            me1Var = new me1(size, y);
        }
        me1 me1Var2 = (me1) linkedHashMap.put(t, me1Var);
        if (me1Var2 != null) {
            this.f9175d -= me1Var2.f22916b;
            if (!me1Var2.f22915a.equals(y)) {
                onItemEvicted(t, me1Var2.f22915a);
            }
        }
        trimToSize(this.f9174c);
        if (me1Var2 != null) {
            y2 = (Y) me1Var2.f22915a;
        }
        return y2;
    }

    @Nullable
    public synchronized Y remove(@NonNull T t) {
        me1 me1Var = (me1) this.f9172a.remove(t);
        if (me1Var == null) {
            return null;
        }
        this.f9175d -= me1Var.f22916b;
        return (Y) me1Var.f22915a;
    }

    public synchronized void setSizeMultiplier(float f) {
        if (f >= RecyclerView.f7068F0) {
            long round = Math.round(((float) this.f9173b) * f);
            this.f9174c = round;
            trimToSize(round);
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void trimToSize(long j) {
        while (this.f9175d > j) {
            Iterator it = this.f9172a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            me1 me1Var = (me1) entry.getValue();
            this.f9175d -= me1Var.f22916b;
            Object key = entry.getKey();
            it.remove();
            onItemEvicted(key, me1Var.f22915a);
        }
    }
}
