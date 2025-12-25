package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import com.hisona.allive.CardPresenter;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(m5568d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenComparator$1\n*L\n1#1,328:1\n*E\n"})
/* loaded from: classes2.dex */
public final class ComparisonsKt__ComparisonsKt$thenComparator$1<T> implements Comparator {

    /* renamed from: a */
    public final /* synthetic */ Comparator f21065a;

    /* renamed from: b */
    public final /* synthetic */ Function2 f21066b;

    public ComparisonsKt__ComparisonsKt$thenComparator$1(Comparator<T> comparator, Function2<? super T, ? super T, Integer> function2) {
        this.f21065a = comparator;
        this.f21066b = function2;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compare = this.f21065a.compare(t, t2);
        if (compare == 0) {
            return ((Number) this.f21066b.invoke(t, t2)).intValue();
        }
        return compare;
    }
}
