package p000;

import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class so2 extends Lambda implements Function2 {

    /* renamed from: b */
    public final /* synthetic */ int f26509b;

    /* renamed from: c */
    public final /* synthetic */ boolean f26510c;

    /* renamed from: d */
    public final /* synthetic */ Object f26511d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ so2(Object obj, int i, boolean z) {
        super(2);
        this.f26509b = i;
        this.f26511d = obj;
        this.f26510c = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Pair m5637a;
        switch (this.f26509b) {
            case 0:
                CharSequence $receiver = (CharSequence) obj;
                int intValue = ((Number) obj2).intValue();
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                int indexOfAny = StringsKt__StringsKt.indexOfAny($receiver, (char[]) this.f26511d, intValue, this.f26510c);
                if (indexOfAny < 0) {
                    return null;
                }
                return TuplesKt.m5575to(Integer.valueOf(indexOfAny), 1);
            default:
                CharSequence $receiver2 = (CharSequence) obj;
                int intValue2 = ((Number) obj2).intValue();
                Intrinsics.checkNotNullParameter($receiver2, "$this$$receiver");
                m5637a = StringsKt__StringsKt.m5637a($receiver2, (List) this.f26511d, intValue2, this.f26510c, false);
                if (m5637a != null) {
                    return TuplesKt.m5575to(m5637a.getFirst(), Integer.valueOf(((String) m5637a.getSecond()).length()));
                }
                return null;
        }
    }
}
