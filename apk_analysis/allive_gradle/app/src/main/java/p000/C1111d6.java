package p000;

import androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: d6 */
/* loaded from: classes.dex */
public final class C1111d6 extends ContinuationImpl {

    /* renamed from: d */
    public AdIdManagerImplCommon f16255d;

    /* renamed from: e */
    public /* synthetic */ Object f16256e;

    /* renamed from: f */
    public final /* synthetic */ AdIdManagerImplCommon f16257f;

    /* renamed from: g */
    public int f16258g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1111d6(AdIdManagerImplCommon adIdManagerImplCommon, Continuation continuation) {
        super(continuation);
        this.f16257f = adIdManagerImplCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16256e = obj;
        this.f16258g |= Integer.MIN_VALUE;
        return AdIdManagerImplCommon.m1570a(this.f16257f, this);
    }
}
