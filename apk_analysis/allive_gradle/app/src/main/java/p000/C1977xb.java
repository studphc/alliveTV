package p000;

import kotlin.ULongArray;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;

/* renamed from: xb */
/* loaded from: classes2.dex */
public final class C1977xb extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ int f28492b;

    /* renamed from: c */
    public final /* synthetic */ long[] f28493c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1977xb(long[] jArr, int i) {
        super(0);
        this.f28492b = i;
        this.f28493c = jArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f28492b) {
            case 0:
                return ArrayIteratorsKt.iterator(this.f28493c);
            default:
                return ULongArray.m8587iteratorimpl(this.f28493c);
        }
    }
}
