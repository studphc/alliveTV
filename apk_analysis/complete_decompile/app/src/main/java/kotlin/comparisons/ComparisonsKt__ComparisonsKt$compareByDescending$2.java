package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import com.hisona.allive.CardPresenter;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(m5568d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$2\n*L\n1#1,328:1\n*E\n"})
/* loaded from: classes2.dex */
public final class ComparisonsKt__ComparisonsKt$compareByDescending$2<T> implements Comparator {

    /* renamed from: a */
    public final /* synthetic */ Comparator f21053a;

    /* renamed from: b */
    public final /* synthetic */ Function1 f21054b;

    public ComparisonsKt__ComparisonsKt$compareByDescending$2(Comparator<Object> comparator, Function1<? super T, Object> function1) {
        this.f21053a = comparator;
        this.f21054b = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Function1 function1 = this.f21054b;
        return this.f21053a.compare(function1.invoke(t2), function1.invoke(t));
    }
}
