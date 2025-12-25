package p000;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* renamed from: jq */
/* loaded from: classes2.dex */
public abstract class AbstractC1363jq extends AbstractC1327iq {
    public static final int access$reverseElementIndex(List list, int i) {
        if (new IntRange(0, CollectionsKt__CollectionsKt.getLastIndex(list)).contains(i)) {
            return CollectionsKt__CollectionsKt.getLastIndex(list) - i;
        }
        StringBuilder m8299s = ye0.m8299s(i, "Element index ", " must be in range [");
        m8299s.append(new IntRange(0, CollectionsKt__CollectionsKt.getLastIndex(list)));
        m8299s.append("].");
        throw new IndexOutOfBoundsException(m8299s.toString());
    }

    public static final int access$reversePositionIndex(List list, int i) {
        if (new IntRange(0, list.size()).contains(i)) {
            return list.size() - i;
        }
        StringBuilder m8299s = ye0.m8299s(i, "Position index ", " must be in range [");
        m8299s.append(new IntRange(0, list.size()));
        m8299s.append("].");
        throw new IndexOutOfBoundsException(m8299s.toString());
    }

    @NotNull
    public static final <T> List<T> asReversed(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return new qc2(list);
    }

    @JvmName(name = "asReversedMutable")
    @NotNull
    public static final <T> List<T> asReversedMutable(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return new pc2(list);
    }
}
