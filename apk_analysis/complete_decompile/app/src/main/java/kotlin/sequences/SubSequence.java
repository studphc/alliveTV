package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m5569d2 = {"Lkotlin/sequences/SubSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "", "startIndex", "endIndex", "<init>", "(Lkotlin/sequences/Sequence;II)V", "n", "drop", "(I)Lkotlin/sequences/Sequence;", "take", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SubSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
/* loaded from: classes2.dex */
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* renamed from: a */
    public final Sequence f21305a;

    /* renamed from: b */
    public final int f21306b;

    /* renamed from: c */
    public final int f21307c;

    public SubSequence(@NotNull Sequence<? extends T> sequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.f21305a = sequence;
        this.f21306b = i;
        this.f21307c = i2;
        if (i >= 0) {
            if (i2 >= 0) {
                if (i2 >= i) {
                    return;
                } else {
                    throw new IllegalArgumentException(ye0.m8293m(i2, "endIndex should be not less than startIndex, but was ", " < ", i).toString());
                }
            }
            throw new IllegalArgumentException(ye0.m8291k(i2, "endIndex should be non-negative, but is ").toString());
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "startIndex should be non-negative, but is ").toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> drop(int n) {
        int i = this.f21307c;
        int i2 = this.f21306b;
        if (n >= i - i2) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new SubSequence(this.f21305a, i2 + n, i);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new SubSequence$iterator$1(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> take(int n) {
        int i = this.f21307c;
        int i2 = this.f21306b;
        if (n >= i - i2) {
            return this;
        }
        return new SubSequence(this.f21305a, i2, n + i2);
    }
}
