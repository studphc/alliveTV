package p000;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public abstract class sh2 extends rh2 {
    @NotNull
    public static <T> Set<T> emptySet() {
        return EmptySet.INSTANCE;
    }

    @NotNull
    public static final <T> HashSet<T> hashSetOf(@NotNull T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (HashSet) ArraysKt___ArraysKt.toCollection(elements, new HashSet(kh1.mapCapacity(elements.length)));
    }

    @NotNull
    public static final <T> LinkedHashSet<T> linkedSetOf(@NotNull T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (LinkedHashSet) ArraysKt___ArraysKt.toCollection(elements, new LinkedHashSet(kh1.mapCapacity(elements.length)));
    }

    @NotNull
    public static final <T> Set<T> mutableSetOf(@NotNull T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (Set) ArraysKt___ArraysKt.toCollection(elements, new LinkedHashSet(kh1.mapCapacity(elements.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> Set<T> optimizeReadOnlySet(@NotNull Set<? extends T> set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        int size = set.size();
        if (size != 0) {
            if (size == 1) {
                return rh2.setOf(set.iterator().next());
            }
            return set;
        }
        return emptySet();
    }

    @NotNull
    public static final <T> Set<T> setOf(@NotNull T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length > 0) {
            return ArraysKt___ArraysKt.toSet(elements);
        }
        return emptySet();
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Set<T> setOfNotNull(@Nullable T t) {
        return t != null ? rh2.setOf(t) : emptySet();
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Set<T> setOfNotNull(@NotNull T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (Set) ArraysKt___ArraysKt.filterNotNullTo(elements, new LinkedHashSet());
    }
}
