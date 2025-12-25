package p000;

import kotlin.UIntArray;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;

/* renamed from: wb */
/* loaded from: classes2.dex */
public final class C1940wb extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ int f28123b;

    /* renamed from: c */
    public final /* synthetic */ int[] f28124c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1940wb(int[] iArr, int i) {
        super(0);
        this.f28123b = i;
        this.f28124c = iArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f28123b) {
            case 0:
                return ArrayIteratorsKt.iterator(this.f28124c);
            default:
                return UIntArray.m8563iteratorimpl(this.f28124c);
        }
    }
}
