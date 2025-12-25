package p000;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public abstract class jh1 {
    @PublishedApi
    @JvmName(name = "getOrImplicitDefaultNullable")
    public static final <K, V> V getOrImplicitDefaultNullable(@NotNull Map<K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map instanceof dg1) {
            return (V) ((dg1) map).mo4580b(k);
        }
        V v = map.get(k);
        if (v == null && !map.containsKey(k)) {
            throw new NoSuchElementException("Key " + k + " is missing in the map.");
        }
        return v;
    }

    @NotNull
    public static final <K, V> Map<K, V> withDefault(@NotNull Map<K, ? extends V> map, @NotNull Function1<? super K, ? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (map instanceof dg1) {
            return withDefault(((dg1) map).mo4581d(), defaultValue);
        }
        return new eg1(map, defaultValue);
    }

    @JvmName(name = "withDefaultMutable")
    @NotNull
    public static final <K, V> Map<K, V> withDefaultMutable(@NotNull Map<K, V> map, @NotNull Function1<? super K, ? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (map instanceof sq1) {
            return withDefaultMutable(((sq1) map).f26533a, defaultValue);
        }
        return new sq1(map, defaultValue);
    }
}
