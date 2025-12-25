package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.m50;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m5569d2 = {"Lkotlin/sequences/DistinctSequence;", ExifInterface.GPS_DIRECTION_TRUE, "K", "Lkotlin/sequences/Sequence;", FirebaseAnalytics.Param.SOURCE, "Lkotlin/Function1;", "keySelector", "<init>", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DistinctSequence<T, K> implements Sequence<T> {

    /* renamed from: a */
    public final Sequence f21251a;

    /* renamed from: b */
    public final Function1 f21252b;

    public DistinctSequence(@NotNull Sequence<? extends T> source, @NotNull Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        this.f21251a = source;
        this.f21252b = keySelector;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new m50(this.f21251a.iterator(), this.f21252b);
    }
}
