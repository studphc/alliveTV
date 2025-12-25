package p000;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class uf0 extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ long f27246b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uf0(long j) {
        super(1);
        this.f27246b = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Long.valueOf(this.f27246b);
    }
}
