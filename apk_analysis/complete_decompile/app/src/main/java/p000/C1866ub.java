package p000;

import kotlin.UByteArray;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;

/* renamed from: ub */
/* loaded from: classes2.dex */
public final class C1866ub extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ int f27181b;

    /* renamed from: c */
    public final /* synthetic */ byte[] f27182c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1866ub(byte[] bArr, int i) {
        super(0);
        this.f27181b = i;
        this.f27182c = bArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f27181b) {
            case 0:
                return ArrayIteratorsKt.iterator(this.f27182c);
            default:
                return UByteArray.m8539iteratorimpl(this.f27182c);
        }
    }
}
