package p000;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: o6 */
/* loaded from: classes.dex */
public final class C1611o6 extends ContinuationImpl {

    /* renamed from: d */
    public Object f23611d;

    /* renamed from: e */
    public /* synthetic */ Object f23612e;

    /* renamed from: f */
    public final /* synthetic */ AdSelectionManagerImplCommon$Ext10Impl$Companion f23613f;

    /* renamed from: g */
    public int f23614g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1611o6(AdSelectionManagerImplCommon$Ext10Impl$Companion adSelectionManagerImplCommon$Ext10Impl$Companion, Continuation continuation) {
        super(continuation);
        this.f23613f = adSelectionManagerImplCommon$Ext10Impl$Companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f23612e = obj;
        this.f23614g |= Integer.MIN_VALUE;
        return this.f23613f.selectAds(null, null, this);
    }
}
