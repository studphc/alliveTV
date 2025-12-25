package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m5569d2 = {"Lkotlin/sequences/ConstrainedOnceSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "sequence", "<init>", "(Lkotlin/sequences/Sequence;)V", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ConstrainedOnceSequence<T> implements Sequence<T> {

    /* renamed from: a */
    public final AtomicReference f21250a;

    public ConstrainedOnceSequence(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.f21250a = new AtomicReference(sequence);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        Sequence sequence = (Sequence) this.f21250a.getAndSet(null);
        if (sequence != null) {
            return sequence.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
