package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1676p6;
import p000.AbstractC1713q6;
import p000.AbstractC1971x5;
import p000.C1750r6;
import p000.ExecutorC0582c6;
import p000.b51;

@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
@Metadata(m5568d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001:\u0002()B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0097@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0097@¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0097@¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0097@¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0097@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0097@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0097@¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionManagerImplCommon;", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionManager;", "Landroid/adservices/adselection/AdSelectionManager;", "mAdSelectionManager", "<init>", "(Landroid/adservices/adselection/AdSelectionManager;)V", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "adSelectionConfig", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionOutcome;", "selectAds", "(Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionFromOutcomesConfig;", "adSelectionFromOutcomesConfig", "(Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionFromOutcomesConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/privacysandbox/ads/adservices/adselection/ReportImpressionRequest;", "reportImpressionRequest", "", "reportImpression", "(Landroidx/privacysandbox/ads/adservices/adselection/ReportImpressionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/privacysandbox/ads/adservices/adselection/ReportEventRequest;", "reportEventRequest", "reportEvent", "(Landroidx/privacysandbox/ads/adservices/adselection/ReportEventRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/privacysandbox/ads/adservices/adselection/UpdateAdCounterHistogramRequest;", "updateAdCounterHistogramRequest", "updateAdCounterHistogram", "(Landroidx/privacysandbox/ads/adservices/adselection/UpdateAdCounterHistogramRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest;", "getAdSelectionDataRequest", "Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataOutcome;", "getAdSelectionData", "(Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/privacysandbox/ads/adservices/adselection/PersistAdSelectionResultRequest;", "persistAdSelectionResultRequest", "persistAdSelectionResult", "(Landroidx/privacysandbox/ads/adservices/adselection/PersistAdSelectionResultRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Landroid/adservices/adselection/AdSelectionManager;", "getMAdSelectionManager", "()Landroid/adservices/adselection/AdSelectionManager;", "p6", "q6", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
@SourceDebugExtension({"SMAP\nAdSelectionManagerImplCommon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdSelectionManagerImplCommon.kt\nandroidx/privacysandbox/ads/adservices/adselection/AdSelectionManagerImplCommon\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,230:1\n314#2,11:231\n314#2,11:242\n*S KotlinDebug\n*F\n+ 1 AdSelectionManagerImplCommon.kt\nandroidx/privacysandbox/ads/adservices/adselection/AdSelectionManagerImplCommon\n*L\n50#1:231,11\n70#1:242,11\n*E\n"})
/* loaded from: classes.dex */
public class AdSelectionManagerImplCommon extends AdSelectionManager {

    /* renamed from: a, reason: from kotlin metadata */
    public final android.adservices.adselection.AdSelectionManager mAdSelectionManager;

    public AdSelectionManagerImplCommon(@NotNull android.adservices.adselection.AdSelectionManager mAdSelectionManager) {
        Intrinsics.checkNotNullParameter(mAdSelectionManager, "mAdSelectionManager");
        this.mAdSelectionManager = mAdSelectionManager;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    /* renamed from: a */
    public static /* synthetic */ Object m1572a(AdSelectionManagerImplCommon adSelectionManagerImplCommon, GetAdSelectionDataRequest getAdSelectionDataRequest, Continuation<? super GetAdSelectionDataOutcome> continuation) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() < 10 && adServicesInfo.extServicesVersionS() < 10) {
            throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
        }
        return AbstractC1676p6.f25045a.getAdSelectionData(adSelectionManagerImplCommon.mAdSelectionManager, getAdSelectionDataRequest, continuation);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    /* renamed from: b */
    public static /* synthetic */ Object m1573b(AdSelectionManagerImplCommon adSelectionManagerImplCommon, PersistAdSelectionResultRequest persistAdSelectionResultRequest, Continuation<? super AdSelectionOutcome> continuation) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() < 10 && adServicesInfo.extServicesVersionS() < 10) {
            throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
        }
        return AbstractC1676p6.f25045a.persistAdSelectionResult(adSelectionManagerImplCommon.mAdSelectionManager, persistAdSelectionResultRequest, continuation);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    /* renamed from: c */
    public static /* synthetic */ Object m1574c(AdSelectionManagerImplCommon adSelectionManagerImplCommon, ReportEventRequest reportEventRequest, Continuation<? super Unit> continuation) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() < 8 && adServicesInfo.extServicesVersionS() < 9) {
            throw new UnsupportedOperationException("API is unsupported. Min version is API 33 ext 8 or API 31/32 ext 9");
        }
        Object reportEvent = AbstractC1713q6.f25458a.reportEvent(adSelectionManagerImplCommon.mAdSelectionManager, reportEventRequest, continuation);
        if (reportEvent == b51.getCOROUTINE_SUSPENDED()) {
            return reportEvent;
        }
        return Unit.INSTANCE;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    /* renamed from: d */
    public static /* synthetic */ Object m1575d(AdSelectionManagerImplCommon adSelectionManagerImplCommon, ReportImpressionRequest reportImpressionRequest, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        adSelectionManagerImplCommon.getMAdSelectionManager().reportImpression(reportImpressionRequest.convertToAdServices$ads_adservices_release(), new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object m1576e(AdSelectionManagerImplCommon adSelectionManagerImplCommon, AdSelectionConfig adSelectionConfig, Continuation<? super AdSelectionOutcome> continuation) {
        C1750r6 c1750r6;
        int i;
        if (continuation instanceof C1750r6) {
            c1750r6 = (C1750r6) continuation;
            int i2 = c1750r6.f25877f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1750r6.f25877f = i2 - Integer.MIN_VALUE;
                Object obj = c1750r6.f25875d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1750r6.f25877f;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    android.adservices.adselection.AdSelectionConfig convertToAdServices$ads_adservices_release = adSelectionConfig.convertToAdServices$ads_adservices_release();
                    c1750r6.f25877f = 1;
                    obj = adSelectionManagerImplCommon.m1579g(convertToAdServices$ads_adservices_release, c1750r6);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return new AdSelectionOutcome(AbstractC1971x5.m8115n(obj));
            }
        }
        c1750r6 = new C1750r6(adSelectionManagerImplCommon, continuation);
        Object obj2 = c1750r6.f25875d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1750r6.f25877f;
        if (i == 0) {
        }
        return new AdSelectionOutcome(AbstractC1971x5.m8115n(obj2));
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    /* renamed from: f */
    public static /* synthetic */ Object m1577f(AdSelectionManagerImplCommon adSelectionManagerImplCommon, AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig, Continuation<? super AdSelectionOutcome> continuation) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() < 10 && adServicesInfo.extServicesVersionS() < 10) {
            throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
        }
        return AbstractC1676p6.f25045a.selectAds(adSelectionManagerImplCommon.mAdSelectionManager, adSelectionFromOutcomesConfig, continuation);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    /* renamed from: h */
    public static /* synthetic */ Object m1578h(AdSelectionManagerImplCommon adSelectionManagerImplCommon, UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, Continuation<? super Unit> continuation) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() < 8 && adServicesInfo.extServicesVersionS() < 9) {
            throw new UnsupportedOperationException("API is unsupported. Min version is API 33 ext 8 or API 31/32 ext 9");
        }
        Object updateAdCounterHistogram = AbstractC1713q6.f25458a.updateAdCounterHistogram(adSelectionManagerImplCommon.mAdSelectionManager, updateAdCounterHistogramRequest, continuation);
        if (updateAdCounterHistogram == b51.getCOROUTINE_SUSPENDED()) {
            return updateAdCounterHistogram;
        }
        return Unit.INSTANCE;
    }

    /* renamed from: g */
    public final Object m1579g(android.adservices.adselection.AdSelectionConfig adSelectionConfig, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        getMAdSelectionManager().selectAds(adSelectionConfig, new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @Nullable
    public Object getAdSelectionData(@NotNull GetAdSelectionDataRequest getAdSelectionDataRequest, @NotNull Continuation<? super GetAdSelectionDataOutcome> continuation) {
        return m1572a(this, getAdSelectionDataRequest, continuation);
    }

    @NotNull
    public final android.adservices.adselection.AdSelectionManager getMAdSelectionManager() {
        return this.mAdSelectionManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @Nullable
    public Object persistAdSelectionResult(@NotNull PersistAdSelectionResultRequest persistAdSelectionResultRequest, @NotNull Continuation<? super AdSelectionOutcome> continuation) {
        return m1573b(this, persistAdSelectionResultRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @Nullable
    public Object reportEvent(@NotNull ReportEventRequest reportEventRequest, @NotNull Continuation<? super Unit> continuation) {
        return m1574c(this, reportEventRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @Nullable
    public Object reportImpression(@NotNull ReportImpressionRequest reportImpressionRequest, @NotNull Continuation<? super Unit> continuation) {
        return m1575d(this, reportImpressionRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @Nullable
    public Object selectAds(@NotNull AdSelectionConfig adSelectionConfig, @NotNull Continuation<? super AdSelectionOutcome> continuation) {
        return m1576e(this, adSelectionConfig, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @Nullable
    public Object updateAdCounterHistogram(@NotNull UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, @NotNull Continuation<? super Unit> continuation) {
        return m1578h(this, updateAdCounterHistogramRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @Nullable
    public Object selectAds(@NotNull AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig, @NotNull Continuation<? super AdSelectionOutcome> continuation) {
        return m1577f(this, adSelectionFromOutcomesConfig, continuation);
    }
}
