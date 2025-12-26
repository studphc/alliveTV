package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.d20;
import p000.r82;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000e¨\u0006\""}, m5569d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "next", "()Lkotlin/ranges/IntRange;", "", "hasNext", "()Z", "", "a", "I", "getNextState", "()I", "setNextState", "(I)V", "nextState", "b", "getCurrentStartIndex", "setCurrentStartIndex", "currentStartIndex", "c", "getNextSearchIndex", "setNextSearchIndex", "nextSearchIndex", "d", "Lkotlin/ranges/IntRange;", "getNextItem", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextItem", "e", "getCounter", "setCounter", "counter", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker {

    /* renamed from: a, reason: from kotlin metadata */
    public int nextState = -1;

    /* renamed from: b, reason: from kotlin metadata */
    public int currentStartIndex;

    /* renamed from: c, reason: from kotlin metadata */
    public int nextSearchIndex;

    /* renamed from: d, reason: from kotlin metadata */
    public IntRange nextItem;

    /* renamed from: e, reason: from kotlin metadata */
    public int counter;

    /* renamed from: f */
    public final /* synthetic */ d20 f21348f;

    public DelimitedRangesSequence$iterator$1(d20 d20Var) {
        this.f21348f = d20Var;
        int coerceIn = r82.coerceIn(d20Var.f16218b, 0, d20Var.f16217a.length());
        this.currentStartIndex = coerceIn;
        this.nextSearchIndex = coerceIn;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if (r7 < r3) goto L9;
     */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5636a() {
        int i = this.nextSearchIndex;
        int i2 = 0;
        if (i < 0) {
            this.nextState = 0;
            this.nextItem = null;
            return;
        }
        d20 d20Var = this.f21348f;
        int i3 = d20Var.f16219c;
        CharSequence charSequence = d20Var.f16217a;
        if (i3 > 0) {
            int i4 = this.counter + 1;
            this.counter = i4;
        }
        if (i <= charSequence.length()) {
            Pair pair = (Pair) d20Var.f16220d.invoke(charSequence, Integer.valueOf(this.nextSearchIndex));
            if (pair == null) {
                this.nextItem = new IntRange(this.currentStartIndex, StringsKt__StringsKt.getLastIndex(charSequence));
                this.nextSearchIndex = -1;
            } else {
                int intValue = ((Number) pair.component1()).intValue();
                int intValue2 = ((Number) pair.component2()).intValue();
                this.nextItem = r82.until(this.currentStartIndex, intValue);
                int i5 = intValue + intValue2;
                this.currentStartIndex = i5;
                if (intValue2 == 0) {
                    i2 = 1;
                }
                this.nextSearchIndex = i5 + i2;
            }
            this.nextState = 1;
        }
        this.nextItem = new IntRange(this.currentStartIndex, StringsKt__StringsKt.getLastIndex(charSequence));
        this.nextSearchIndex = -1;
        this.nextState = 1;
    }

    public final int getCounter() {
        return this.counter;
    }

    public final int getCurrentStartIndex() {
        return this.currentStartIndex;
    }

    @Nullable
    public final IntRange getNextItem() {
        return this.nextItem;
    }

    public final int getNextSearchIndex() {
        return this.nextSearchIndex;
    }

    public final int getNextState() {
        return this.nextState;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextState == -1) {
            m5636a();
        }
        if (this.nextState == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setCounter(int i) {
        this.counter = i;
    }

    public final void setCurrentStartIndex(int i) {
        this.currentStartIndex = i;
    }

    public final void setNextItem(@Nullable IntRange intRange) {
        this.nextItem = intRange;
    }

    public final void setNextSearchIndex(int i) {
        this.nextSearchIndex = i;
    }

    public final void setNextState(int i) {
        this.nextState = i;
    }

    @Override // java.util.Iterator
    @NotNull
    public IntRange next() {
        if (this.nextState == -1) {
            m5636a();
        }
        if (this.nextState != 0) {
            IntRange intRange = this.nextItem;
            Intrinsics.checkNotNull(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.nextItem = null;
            this.nextState = -1;
            return intRange;
        }
        throw new NoSuchElementException();
    }
}
