package p000;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ed0 extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f16766b;

    /* renamed from: c */
    public final /* synthetic */ ArrayList f16767c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ed0(ArrayList arrayList, int i) {
        super(1);
        this.f16766b = i;
        this.f16767c = arrayList;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f16766b) {
            case 0:
                String it = (String) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                this.f16767c.add(it);
                return Unit.INSTANCE;
            default:
                String it2 = (String) obj;
                Intrinsics.checkNotNullParameter(it2, "it");
                this.f16767c.add(it2);
                return Unit.INSTANCE;
        }
    }
}
