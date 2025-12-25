package p000;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: r6 */
/* loaded from: classes.dex */
public final class C1750r6 extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f25875d;

    /* renamed from: e */
    public final /* synthetic */ AdSelectionManagerImplCommon f25876e;

    /* renamed from: f */
    public int f25877f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1750r6(AdSelectionManagerImplCommon adSelectionManagerImplCommon, Continuation continuation) {
        super(continuation);
        this.f25876e = adSelectionManagerImplCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f25875d = obj;
        this.f25877f |= Integer.MIN_VALUE;
        return AdSelectionManagerImplCommon.m1576e(this.f25876e, null, this);
    }
}
