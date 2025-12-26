package androidx.privacysandbox.ads.adservices.adid;

import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1971x5;
import p000.C1111d6;
import p000.ExecutorC0582c6;
import p000.b51;

@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0097@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adid/AdIdManagerImplCommon;", "Landroidx/privacysandbox/ads/adservices/adid/AdIdManager;", "Landroid/adservices/adid/AdIdManager;", "mAdIdManager", "<init>", "(Landroid/adservices/adid/AdIdManager;)V", "Landroidx/privacysandbox/ads/adservices/adid/AdId;", "getAdId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"ClassVerificationFailure", "NewApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
@SourceDebugExtension({"SMAP\nAdIdManagerImplCommon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdIdManagerImplCommon.kt\nandroidx/privacysandbox/ads/adservices/adid/AdIdManagerImplCommon\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,53:1\n314#2,11:54\n*S KotlinDebug\n*F\n+ 1 AdIdManagerImplCommon.kt\nandroidx/privacysandbox/ads/adservices/adid/AdIdManagerImplCommon\n*L\n45#1:54,11\n*E\n"})
/* loaded from: classes.dex */
public class AdIdManagerImplCommon extends AdIdManager {

    /* renamed from: a */
    public final android.adservices.adid.AdIdManager f6756a;

    public AdIdManagerImplCommon(@NotNull android.adservices.adid.AdIdManager mAdIdManager) {
        Intrinsics.checkNotNullParameter(mAdIdManager, "mAdIdManager");
        this.f6756a = mAdIdManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
    @DoNotInline
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object m1570a(AdIdManagerImplCommon adIdManagerImplCommon, Continuation<? super AdId> continuation) {
        C1111d6 c1111d6;
        int i;
        String adId;
        boolean isLimitAdTrackingEnabled;
        if (continuation instanceof C1111d6) {
            c1111d6 = (C1111d6) continuation;
            int i2 = c1111d6.f16258g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1111d6.f16258g = i2 - Integer.MIN_VALUE;
                Object obj = c1111d6.f16256e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1111d6.f16258g;
                if (i == 0) {
                    if (i == 1) {
                        adIdManagerImplCommon = c1111d6.f16255d;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    c1111d6.f16255d = adIdManagerImplCommon;
                    c1111d6.f16258g = 1;
                    obj = adIdManagerImplCommon.m1571b(c1111d6);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                android.adservices.adid.AdId m8103b = AbstractC1971x5.m8103b(obj);
                adIdManagerImplCommon.getClass();
                adId = m8103b.getAdId();
                Intrinsics.checkNotNullExpressionValue(adId, "response.adId");
                isLimitAdTrackingEnabled = m8103b.isLimitAdTrackingEnabled();
                return new AdId(adId, isLimitAdTrackingEnabled);
            }
        }
        c1111d6 = new C1111d6(adIdManagerImplCommon, continuation);
        Object obj2 = c1111d6.f16256e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1111d6.f16258g;
        if (i == 0) {
        }
        android.adservices.adid.AdId m8103b2 = AbstractC1971x5.m8103b(obj2);
        adIdManagerImplCommon.getClass();
        adId = m8103b2.getAdId();
        Intrinsics.checkNotNullExpressionValue(adId, "response.adId");
        isLimitAdTrackingEnabled = m8103b2.isLimitAdTrackingEnabled();
        return new AdId(adId, isLimitAdTrackingEnabled);
    }

    /* renamed from: b */
    public final Object m1571b(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.f6756a.getAdId(new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // androidx.privacysandbox.ads.adservices.adid.AdIdManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
    @DoNotInline
    @Nullable
    public Object getAdId(@NotNull Continuation<? super AdId> continuation) {
        return m1570a(this, continuation);
    }
}
