package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m5569d2 = {"Lkotlin/sequences/DropSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "", "count", "<init>", "(Lkotlin/sequences/Sequence;I)V", "n", "drop", "(I)Lkotlin/sequences/Sequence;", "take", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/DropSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
/* loaded from: classes2.dex */
public final class DropSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* renamed from: a */
    public final Sequence f21253a;

    /* renamed from: b */
    public final int f21254b;

    public DropSequence(@NotNull Sequence<? extends T> sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.f21253a = sequence;
        this.f21254b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> drop(int n) {
        int i = this.f21254b + n;
        if (i < 0) {
            return new DropSequence(this, n);
        }
        return new DropSequence(this.f21253a, i);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new DropSequence$iterator$1(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> take(int n) {
        int i = this.f21254b;
        int i2 = i + n;
        if (i2 < 0) {
            return new TakeSequence(this, n);
        }
        return new SubSequence(this.f21253a, i, i2);
    }
}
