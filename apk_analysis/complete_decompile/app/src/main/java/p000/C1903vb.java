package p000;

import kotlin.UShortArray;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;

/* renamed from: vb */
/* loaded from: classes2.dex */
public final class C1903vb extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ int f27724b;

    /* renamed from: c */
    public final /* synthetic */ short[] f27725c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1903vb(short[] sArr, int i) {
        super(0);
        this.f27724b = i;
        this.f27725c = sArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f27724b) {
            case 0:
                return ArrayIteratorsKt.iterator(this.f27725c);
            default:
                return UShortArray.m8611iteratorimpl(this.f27725c);
        }
    }
}
