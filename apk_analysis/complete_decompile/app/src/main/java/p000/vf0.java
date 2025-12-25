package p000;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlinx.coroutines.DelayKt;

/* loaded from: classes2.dex */
public final class vf0 extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f27757b;

    /* renamed from: c */
    public final /* synthetic */ Function1 f27758c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ vf0(int i, Function1 function1) {
        super(1);
        this.f27757b = i;
        this.f27758c = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f27757b) {
            case 0:
                return Long.valueOf(DelayKt.m8850toDelayMillisLRDsOJo(((Duration) this.f27758c.invoke(obj)).getF21373a()));
            default:
                this.f27758c.invoke(obj);
                return obj;
        }
    }
}
