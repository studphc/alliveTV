package androidx.privacysandbox.ads.adservices.adselection;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.core.os.OutcomeReceiverKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1971x5;
import p000.C1537m6;
import p000.C1574n6;
import p000.C1611o6;
import p000.ExecutorC0582c6;
import p000.b51;

@Metadata(m5568d1 = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0087@¢\u0006\u0004\b\u0007\u0010\bJ \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0087@¢\u0006\u0004\b\f\u0010\rJ \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0087@¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m5569d2 = {"androidx/privacysandbox/ads/adservices/adselection/AdSelectionManagerImplCommon$Ext10Impl$Companion", "", "Landroid/adservices/adselection/AdSelectionManager;", "adSelectionManager", "Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest;", "getAdSelectionDataRequest", "Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataOutcome;", "getAdSelectionData", "(Landroid/adservices/adselection/AdSelectionManager;Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/privacysandbox/ads/adservices/adselection/PersistAdSelectionResultRequest;", "persistAdSelectionResultRequest", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionOutcome;", "persistAdSelectionResult", "(Landroid/adservices/adselection/AdSelectionManager;Landroidx/privacysandbox/ads/adservices/adselection/PersistAdSelectionResultRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionFromOutcomesConfig;", "adSelectionFromOutcomesConfig", "selectAds", "(Landroid/adservices/adselection/AdSelectionManager;Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionFromOutcomesConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nAdSelectionManagerImplCommon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdSelectionManagerImplCommon.kt\nandroidx/privacysandbox/ads/adservices/adselection/AdSelectionManagerImplCommon$Ext10Impl$Companion\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,230:1\n314#2,11:231\n314#2,11:242\n314#2,11:253\n*S KotlinDebug\n*F\n+ 1 AdSelectionManagerImplCommon.kt\nandroidx/privacysandbox/ads/adservices/adselection/AdSelectionManagerImplCommon$Ext10Impl$Companion\n*L\n146#1:231,11\n165#1:242,11\n182#1:253,11\n*E\n"})
/* loaded from: classes.dex */
public final class AdSelectionManagerImplCommon$Ext10Impl$Companion {
    public AdSelectionManagerImplCommon$Ext10Impl$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getAdSelectionData(@NotNull android.adservices.adselection.AdSelectionManager adSelectionManager, @NotNull GetAdSelectionDataRequest getAdSelectionDataRequest, @NotNull Continuation<? super GetAdSelectionDataOutcome> continuation) {
        C1537m6 c1537m6;
        int i;
        if (continuation instanceof C1537m6) {
            c1537m6 = (C1537m6) continuation;
            int i2 = c1537m6.f22821g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1537m6.f22821g = i2 - Integer.MIN_VALUE;
                Object obj = c1537m6.f22819e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1537m6.f22821g;
                if (i == 0) {
                    if (i == 1) {
                        AbstractC1971x5.m8127z(c1537m6.f22818d);
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    c1537m6.f22818d = adSelectionManager;
                    c1537m6.f22821g = 1;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(c1537m6), 1);
                    cancellableContinuationImpl.initCancellability();
                    adSelectionManager.getAdSelectionData(getAdSelectionDataRequest.convertToAdServices$ads_adservices_release(), new ExecutorC0582c6(1), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
                    obj = cancellableContinuationImpl.getResult();
                    if (obj == b51.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(c1537m6);
                    }
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return new GetAdSelectionDataOutcome((android.adservices.adselection.GetAdSelectionDataOutcome) obj);
            }
        }
        c1537m6 = new C1537m6(this, continuation);
        Object obj2 = c1537m6.f22819e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1537m6.f22821g;
        if (i == 0) {
        }
        return new GetAdSelectionDataOutcome((android.adservices.adselection.GetAdSelectionDataOutcome) obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object persistAdSelectionResult(@NotNull android.adservices.adselection.AdSelectionManager adSelectionManager, @NotNull PersistAdSelectionResultRequest persistAdSelectionResultRequest, @NotNull Continuation<? super AdSelectionOutcome> continuation) {
        C1574n6 c1574n6;
        int i;
        if (continuation instanceof C1574n6) {
            c1574n6 = (C1574n6) continuation;
            int i2 = c1574n6.f23239g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1574n6.f23239g = i2 - Integer.MIN_VALUE;
                Object obj = c1574n6.f23237e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1574n6.f23239g;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    c1574n6.f23236d = adSelectionManager;
                    c1574n6.f23239g = 1;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(c1574n6), 1);
                    cancellableContinuationImpl.initCancellability();
                    adSelectionManager.persistAdSelectionResult(persistAdSelectionResultRequest.convertToAdServices$ads_adservices_release(), new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
                    obj = cancellableContinuationImpl.getResult();
                    if (obj == b51.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(c1574n6);
                    }
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return new AdSelectionOutcome((android.adservices.adselection.AdSelectionOutcome) obj);
            }
        }
        c1574n6 = new C1574n6(this, continuation);
        Object obj2 = c1574n6.f23237e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1574n6.f23239g;
        if (i == 0) {
        }
        return new AdSelectionOutcome((android.adservices.adselection.AdSelectionOutcome) obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object selectAds(@NotNull android.adservices.adselection.AdSelectionManager adSelectionManager, @NotNull AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig, @NotNull Continuation<? super AdSelectionOutcome> continuation) {
        C1611o6 c1611o6;
        int i;
        if (continuation instanceof C1611o6) {
            c1611o6 = (C1611o6) continuation;
            int i2 = c1611o6.f23614g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1611o6.f23614g = i2 - Integer.MIN_VALUE;
                Object obj = c1611o6.f23612e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1611o6.f23614g;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    c1611o6.f23611d = adSelectionManager;
                    c1611o6.f23614g = 1;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(c1611o6), 1);
                    cancellableContinuationImpl.initCancellability();
                    adSelectionManager.selectAds(adSelectionFromOutcomesConfig.convertToAdServices$ads_adservices_release(), new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
                    obj = cancellableContinuationImpl.getResult();
                    if (obj == b51.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(c1611o6);
                    }
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return new AdSelectionOutcome((android.adservices.adselection.AdSelectionOutcome) obj);
            }
        }
        c1611o6 = new C1611o6(this, continuation);
        Object obj2 = c1611o6.f23612e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1611o6.f23614g;
        if (i == 0) {
        }
        return new AdSelectionOutcome((android.adservices.adselection.AdSelectionOutcome) obj2);
    }
}
