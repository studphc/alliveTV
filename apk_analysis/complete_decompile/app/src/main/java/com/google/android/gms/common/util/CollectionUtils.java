package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000.ye0;

@KeepForSdk
/* loaded from: classes.dex */
public final class CollectionUtils {
    /* renamed from: a */
    public static Map m3201a(int i) {
        if (i <= 256) {
            return new ArrayMap(i);
        }
        return new HashMap(i, 1.0f);
    }

    /* renamed from: b */
    public static Set m3202b(int i, boolean z) {
        int i2;
        float f;
        if (true != z) {
            i2 = 256;
        } else {
            i2 = 128;
        }
        if (i <= i2) {
            return new ArraySet(i);
        }
        if (true != z) {
            f = 1.0f;
        } else {
            f = 0.75f;
        }
        return new HashSet(i, f);
    }

    @KeepForSdk
    public static boolean isEmpty(@Nullable Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@NonNull K k, @NonNull V v, @NonNull K k2, @NonNull V v2, @NonNull K k3, @NonNull V v3) {
        Map m3201a = m3201a(3);
        m3201a.put(k, v);
        m3201a.put(k2, v2);
        m3201a.put(k3, v3);
        return Collections.unmodifiableMap(m3201a);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOfKeyValueArrays(@NonNull K[] kArr, @NonNull V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length == length2) {
            if (length != 0) {
                if (length != 1) {
                    Map m3201a = m3201a(length);
                    for (int i = 0; i < kArr.length; i++) {
                        m3201a.put(kArr[i], vArr[i]);
                    }
                    return Collections.unmodifiableMap(m3201a);
                }
                return Collections.singletonMap(kArr[0], vArr[0]);
            }
            return Collections.emptyMap();
        }
        throw new IllegalArgumentException(ye0.m8293m(length, "Key and values array lengths not equal: ", " != ", length2));
    }

    @NonNull
    @KeepForSdk
    public static <T> Set<T> mutableSetOfWithSize(int i) {
        if (i == 0) {
            return new ArraySet();
        }
        return m3202b(i, true);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@NonNull T t, @NonNull T t2, @NonNull T t3) {
        Set m3202b = m3202b(3, false);
        m3202b.add(t);
        m3202b.add(t2);
        m3202b.add(t3);
        return Collections.unmodifiableSet(m3202b);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@NonNull T t) {
        return Collections.singletonList(t);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@NonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return Collections.singletonList(tArr[0]);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@NonNull K k, @NonNull V v, @NonNull K k2, @NonNull V v2, @NonNull K k3, @NonNull V v3, @NonNull K k4, @NonNull V v4, @NonNull K k5, @NonNull V v5, @NonNull K k6, @NonNull V v6) {
        Map m3201a = m3201a(6);
        m3201a.put(k, v);
        m3201a.put(k2, v2);
        m3201a.put(k3, v3);
        m3201a.put(k4, v4);
        m3201a.put(k5, v5);
        m3201a.put(k6, v6);
        return Collections.unmodifiableMap(m3201a);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@NonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t = tArr[0];
            T t2 = tArr[1];
            Set m3202b = m3202b(2, false);
            m3202b.add(t);
            m3202b.add(t2);
            return Collections.unmodifiableSet(m3202b);
        }
        if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        }
        if (length != 4) {
            Set m3202b2 = m3202b(length, false);
            Collections.addAll(m3202b2, tArr);
            return Collections.unmodifiableSet(m3202b2);
        }
        T t3 = tArr[0];
        T t4 = tArr[1];
        T t5 = tArr[2];
        T t6 = tArr[3];
        Set m3202b3 = m3202b(4, false);
        m3202b3.add(t3);
        m3202b3.add(t4);
        m3202b3.add(t5);
        m3202b3.add(t6);
        return Collections.unmodifiableSet(m3202b3);
    }
}
