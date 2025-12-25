package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001c"}, m5569d2 = {"Lkotlin/text/MatchGroup;", "", "", "value", "Lkotlin/ranges/IntRange;", "range", "<init>", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "component1", "()Ljava/lang/String;", "component2", "()Lkotlin/ranges/IntRange;", "copy", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)Lkotlin/text/MatchGroup;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getValue", "b", "Lkotlin/ranges/IntRange;", "getRange", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MatchGroup {

    /* renamed from: a, reason: from kotlin metadata */
    public final String value;

    /* renamed from: b, reason: from kotlin metadata */
    public final IntRange range;

    public MatchGroup(@NotNull String value, @NotNull IntRange range) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(range, "range");
        this.value = value;
        this.range = range;
    }

    public static /* synthetic */ MatchGroup copy$default(MatchGroup matchGroup, String str, IntRange intRange, int i, Object obj) {
        if ((i & 1) != 0) {
            str = matchGroup.value;
        }
        if ((i & 2) != 0) {
            intRange = matchGroup.range;
        }
        return matchGroup.copy(str, intRange);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final IntRange getRange() {
        return this.range;
    }

    @NotNull
    public final MatchGroup copy(@NotNull String value, @NotNull IntRange range) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(range, "range");
        return new MatchGroup(value, range);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatchGroup)) {
            return false;
        }
        MatchGroup matchGroup = (MatchGroup) other;
        return Intrinsics.areEqual(this.value, matchGroup.value) && Intrinsics.areEqual(this.range, matchGroup.range);
    }

    @NotNull
    public final IntRange getRange() {
        return this.range;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.range.hashCode() + (this.value.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.range + ')';
    }
}
