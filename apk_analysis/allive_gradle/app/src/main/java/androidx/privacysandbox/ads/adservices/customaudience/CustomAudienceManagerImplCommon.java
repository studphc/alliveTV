package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.common.AdSelectionSignals;
import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.common.AdData;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1248gx;
import p000.AbstractC1285hx;
import p000.AbstractC1861u6;
import p000.ExecutorC0582c6;
import p000.b51;

@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
@Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0097@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000bH\u0097@¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000eH\u0097@¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudienceManagerImplCommon;", "Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudienceManager;", "Landroid/adservices/customaudience/CustomAudienceManager;", "customAudienceManager", "<init>", "(Landroid/adservices/customaudience/CustomAudienceManager;)V", "Landroidx/privacysandbox/ads/adservices/customaudience/JoinCustomAudienceRequest;", "request", "", "joinCustomAudience", "(Landroidx/privacysandbox/ads/adservices/customaudience/JoinCustomAudienceRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/privacysandbox/ads/adservices/customaudience/FetchAndJoinCustomAudienceRequest;", "fetchAndJoinCustomAudience", "(Landroidx/privacysandbox/ads/adservices/customaudience/FetchAndJoinCustomAudienceRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/privacysandbox/ads/adservices/customaudience/LeaveCustomAudienceRequest;", "leaveCustomAudience", "(Landroidx/privacysandbox/ads/adservices/customaudience/LeaveCustomAudienceRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Landroid/adservices/customaudience/CustomAudienceManager;", "getCustomAudienceManager", "()Landroid/adservices/customaudience/CustomAudienceManager;", "hx", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
@SourceDebugExtension({"SMAP\nCustomAudienceManagerImplCommon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomAudienceManagerImplCommon.kt\nandroidx/privacysandbox/ads/adservices/customaudience/CustomAudienceManagerImplCommon\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,148:1\n314#2,11:149\n314#2,11:160\n*S KotlinDebug\n*F\n+ 1 CustomAudienceManagerImplCommon.kt\nandroidx/privacysandbox/ads/adservices/customaudience/CustomAudienceManagerImplCommon\n*L\n44#1:149,11\n67#1:160,11\n*E\n"})
/* loaded from: classes.dex */
public class CustomAudienceManagerImplCommon extends CustomAudienceManager {

    /* renamed from: a, reason: from kotlin metadata */
    public final android.adservices.customaudience.CustomAudienceManager customAudienceManager;

    public CustomAudienceManagerImplCommon(@NotNull android.adservices.customaudience.CustomAudienceManager customAudienceManager) {
        Intrinsics.checkNotNullParameter(customAudienceManager, "customAudienceManager");
        this.customAudienceManager = customAudienceManager;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    /* renamed from: a */
    public static /* synthetic */ Object m1583a(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, Continuation<? super Unit> continuation) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() < 10 && adServicesInfo.extServicesVersionS() < 10) {
            throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
        }
        Object fetchAndJoinCustomAudience = AbstractC1285hx.f18207a.fetchAndJoinCustomAudience(customAudienceManagerImplCommon.customAudienceManager, fetchAndJoinCustomAudienceRequest, continuation);
        if (fetchAndJoinCustomAudience == b51.getCOROUTINE_SUSPENDED()) {
            return fetchAndJoinCustomAudience;
        }
        return Unit.INSTANCE;
    }

    public static final android.adservices.customaudience.JoinCustomAudienceRequest access$convertJoinRequest(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, JoinCustomAudienceRequest joinCustomAudienceRequest) {
        CustomAudience.Builder activationTime;
        CustomAudience.Builder ads;
        CustomAudience.Builder biddingLogicUri;
        CustomAudience.Builder buyer;
        CustomAudience.Builder dailyUpdateUri;
        CustomAudience.Builder expirationTime;
        CustomAudience.Builder name;
        TrustedBiddingData.Builder trustedBiddingKeys;
        TrustedBiddingData.Builder trustedBiddingUri;
        android.adservices.customaudience.TrustedBiddingData build;
        CustomAudience.Builder trustedBiddingData;
        CustomAudience.Builder userBiddingSignals;
        android.adservices.customaudience.CustomAudience build2;
        JoinCustomAudienceRequest.Builder customAudience;
        android.adservices.customaudience.JoinCustomAudienceRequest build3;
        customAudienceManagerImplCommon.getClass();
        JoinCustomAudienceRequest.Builder m5001e = AbstractC1248gx.m5001e();
        CustomAudience customAudience2 = joinCustomAudienceRequest.getCustomAudience();
        activationTime = AbstractC1248gx.m4999c().setActivationTime(customAudience2.getActivationTime());
        List<AdData> ads2 = customAudience2.getAds();
        ArrayList arrayList = new ArrayList();
        Iterator<AdData> it = ads2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().convertToAdServices$ads_adservices_release());
        }
        ads = activationTime.setAds(arrayList);
        biddingLogicUri = ads.setBiddingLogicUri(customAudience2.getBiddingLogicUri());
        buyer = biddingLogicUri.setBuyer(customAudience2.getBuyer().convertToAdServices$ads_adservices_release());
        dailyUpdateUri = buyer.setDailyUpdateUri(customAudience2.getDailyUpdateUri());
        expirationTime = dailyUpdateUri.setExpirationTime(customAudience2.getExpirationTime());
        name = expirationTime.setName(customAudience2.getCom.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty.NAME java.lang.String());
        TrustedBiddingData trustedBiddingSignals = customAudience2.getTrustedBiddingSignals();
        AdSelectionSignals adSelectionSignals = null;
        if (trustedBiddingSignals != null) {
            trustedBiddingKeys = AbstractC1861u6.m7595u().setTrustedBiddingKeys(trustedBiddingSignals.getTrustedBiddingKeys());
            trustedBiddingUri = trustedBiddingKeys.setTrustedBiddingUri(trustedBiddingSignals.getTrustedBiddingUri());
            build = trustedBiddingUri.build();
        } else {
            build = null;
        }
        trustedBiddingData = name.setTrustedBiddingData(build);
        androidx.privacysandbox.ads.adservices.common.AdSelectionSignals userBiddingSignals2 = customAudience2.getUserBiddingSignals();
        if (userBiddingSignals2 != null) {
            adSelectionSignals = userBiddingSignals2.convertToAdServices$ads_adservices_release();
        }
        userBiddingSignals = trustedBiddingData.setUserBiddingSignals(adSelectionSignals);
        build2 = userBiddingSignals.build();
        Intrinsics.checkNotNullExpressionValue(build2, "Builder()\n            .s…s())\n            .build()");
        customAudience = m5001e.setCustomAudience(build2);
        build3 = customAudience.build();
        Intrinsics.checkNotNullExpressionValue(build3, "Builder()\n            .s…ce))\n            .build()");
        return build3;
    }

    public static final android.adservices.customaudience.LeaveCustomAudienceRequest access$convertLeaveRequest(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, LeaveCustomAudienceRequest leaveCustomAudienceRequest) {
        LeaveCustomAudienceRequest.Builder buyer;
        LeaveCustomAudienceRequest.Builder name;
        android.adservices.customaudience.LeaveCustomAudienceRequest build;
        customAudienceManagerImplCommon.getClass();
        buyer = AbstractC1861u6.m7591q().setBuyer(leaveCustomAudienceRequest.getBuyer().convertToAdServices$ads_adservices_release());
        name = buyer.setName(leaveCustomAudienceRequest.getCom.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty.NAME java.lang.String());
        build = name.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…ame)\n            .build()");
        return build;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    /* renamed from: b */
    public static /* synthetic */ Object m1584b(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, JoinCustomAudienceRequest joinCustomAudienceRequest, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        customAudienceManagerImplCommon.getCustomAudienceManager().joinCustomAudience(access$convertJoinRequest(customAudienceManagerImplCommon, joinCustomAudienceRequest), new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    /* renamed from: c */
    public static /* synthetic */ Object m1585c(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, LeaveCustomAudienceRequest leaveCustomAudienceRequest, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        customAudienceManagerImplCommon.getCustomAudienceManager().leaveCustomAudience(access$convertLeaveRequest(customAudienceManagerImplCommon, leaveCustomAudienceRequest), new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @Nullable
    public Object fetchAndJoinCustomAudience(@NotNull FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, @NotNull Continuation<? super Unit> continuation) {
        return m1583a(this, fetchAndJoinCustomAudienceRequest, continuation);
    }

    @NotNull
    public final android.adservices.customaudience.CustomAudienceManager getCustomAudienceManager() {
        return this.customAudienceManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @Nullable
    public Object joinCustomAudience(@NotNull JoinCustomAudienceRequest joinCustomAudienceRequest, @NotNull Continuation<? super Unit> continuation) {
        return m1584b(this, joinCustomAudienceRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @Nullable
    public Object leaveCustomAudience(@NotNull LeaveCustomAudienceRequest leaveCustomAudienceRequest, @NotNull Continuation<? super Unit> continuation) {
        return m1585c(this, leaveCustomAudienceRequest, continuation);
    }
}
