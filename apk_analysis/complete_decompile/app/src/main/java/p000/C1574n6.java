package p000;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: n6 */
/* loaded from: classes.dex */
public final class C1574n6 extends ContinuationImpl {

    /* renamed from: d */
    public Object f23236d;

    /* renamed from: e */
    public /* synthetic */ Object f23237e;

    /* renamed from: f */
    public final /* synthetic */ AdSelectionManagerImplCommon$Ext10Impl$Companion f23238f;

    /* renamed from: g */
    public int f23239g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1574n6(AdSelectionManagerImplCommon$Ext10Impl$Companion adSelectionManagerImplCommon$Ext10Impl$Companion, Continuation continuation) {
        super(continuation);
        this.f23238f = adSelectionManagerImplCommon$Ext10Impl$Companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f23237e = obj;
        this.f23239g |= Integer.MIN_VALUE;
        return this.f23238f.persistAdSelectionResult(null, null, this);
    }
}
