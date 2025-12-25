package p000;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class to2 extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f26912b;

    /* renamed from: c */
    public final /* synthetic */ CharSequence f26913c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ to2(int i, CharSequence charSequence) {
        super(1);
        this.f26912b = i;
        this.f26913c = charSequence;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f26912b) {
            case 0:
                IntRange it = (IntRange) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                return StringsKt__StringsKt.substring(this.f26913c, it);
            default:
                IntRange it2 = (IntRange) obj;
                Intrinsics.checkNotNullParameter(it2, "it");
                return StringsKt__StringsKt.substring(this.f26913c, it2);
        }
    }
}
