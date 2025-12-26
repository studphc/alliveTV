package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import com.hisona.allive.CardPresenter;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(m5568d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$2\n*L\n1#1,328:1\n*E\n"})
/* loaded from: classes2.dex */
public final class ComparisonsKt__ComparisonsKt$thenBy$2<T> implements Comparator {

    /* renamed from: a */
    public final /* synthetic */ Comparator f21057a;

    /* renamed from: b */
    public final /* synthetic */ Comparator f21058b;

    /* renamed from: c */
    public final /* synthetic */ Function1 f21059c;

    public ComparisonsKt__ComparisonsKt$thenBy$2(Comparator<T> comparator, Comparator<Object> comparator2, Function1<? super T, Object> function1) {
        this.f21057a = comparator;
        this.f21058b = comparator2;
        this.f21059c = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compare = this.f21057a.compare(t, t2);
        if (compare == 0) {
            Function1 function1 = this.f21059c;
            return this.f21058b.compare(function1.invoke(t), function1.invoke(t2));
        }
        return compare;
    }
}
