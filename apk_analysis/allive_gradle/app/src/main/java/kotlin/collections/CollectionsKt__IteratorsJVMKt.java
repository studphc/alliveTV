package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1204fq;

/* loaded from: classes2.dex */
public abstract class CollectionsKt__IteratorsJVMKt extends AbstractC1204fq {
    @NotNull
    public static final <T> Iterator<T> iterator(@NotNull Enumeration<T> enumeration) {
        Intrinsics.checkNotNullParameter(enumeration, "<this>");
        return new CollectionsKt__IteratorsJVMKt$iterator$1(enumeration);
    }
}
