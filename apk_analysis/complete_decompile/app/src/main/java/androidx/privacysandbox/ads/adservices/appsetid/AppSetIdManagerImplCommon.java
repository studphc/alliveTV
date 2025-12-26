package androidx.privacysandbox.ads.adservices.appsetid;

import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
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
import p000.AbstractC1861u6;
import p000.C1828ta;
import p000.ExecutorC0582c6;
import p000.b51;

@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0097@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManagerImplCommon;", "Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManager;", "Landroid/adservices/appsetid/AppSetIdManager;", "mAppSetIdManager", "<init>", "(Landroid/adservices/appsetid/AppSetIdManager;)V", "Landroidx/privacysandbox/ads/adservices/appsetid/AppSetId;", "getAppSetId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"ClassVerificationFailure", "NewApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
@SourceDebugExtension({"SMAP\nAppSetIdManagerImplCommon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppSetIdManagerImplCommon.kt\nandroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManagerImplCommon\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,53:1\n314#2,11:54\n*S KotlinDebug\n*F\n+ 1 AppSetIdManagerImplCommon.kt\nandroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManagerImplCommon\n*L\n42#1:54,11\n*E\n"})
/* loaded from: classes.dex */
public class AppSetIdManagerImplCommon extends AppSetIdManager {

    /* renamed from: a */
    public final android.adservices.appsetid.AppSetIdManager f6793a;

    public AppSetIdManagerImplCommon(@NotNull android.adservices.appsetid.AppSetIdManager mAppSetIdManager) {
        Intrinsics.checkNotNullParameter(mAppSetIdManager, "mAppSetIdManager");
        this.f6793a = mAppSetIdManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @DoNotInline
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object m1580a(AppSetIdManagerImplCommon appSetIdManagerImplCommon, Continuation<? super AppSetId> continuation) {
        C1828ta c1828ta;
        int i;
        int scope;
        String id;
        String id2;
        if (continuation instanceof C1828ta) {
            c1828ta = (C1828ta) continuation;
            int i2 = c1828ta.f26738g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1828ta.f26738g = i2 - Integer.MIN_VALUE;
                Object obj = c1828ta.f26736e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1828ta.f26738g;
                if (i == 0) {
                    if (i == 1) {
                        appSetIdManagerImplCommon = c1828ta.f26735d;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    c1828ta.f26735d = appSetIdManagerImplCommon;
                    c1828ta.f26738g = 1;
                    obj = appSetIdManagerImplCommon.m1581b(c1828ta);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                android.adservices.appsetid.AppSetId m7576b = AbstractC1861u6.m7576b(obj);
                appSetIdManagerImplCommon.getClass();
                scope = m7576b.getScope();
                if (scope != 1) {
                    id2 = m7576b.getId();
                    Intrinsics.checkNotNullExpressionValue(id2, "response.id");
                    return new AppSetId(id2, 1);
                }
                id = m7576b.getId();
                Intrinsics.checkNotNullExpressionValue(id, "response.id");
                return new AppSetId(id, 2);
            }
        }
        c1828ta = new C1828ta(appSetIdManagerImplCommon, continuation);
        Object obj2 = c1828ta.f26736e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1828ta.f26738g;
        if (i == 0) {
        }
        android.adservices.appsetid.AppSetId m7576b2 = AbstractC1861u6.m7576b(obj2);
        appSetIdManagerImplCommon.getClass();
        scope = m7576b2.getScope();
        if (scope != 1) {
        }
    }

    /* renamed from: b */
    public final Object m1581b(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.f6793a.getAppSetId(new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager
    @DoNotInline
    @Nullable
    public Object getAppSetId(@NotNull Continuation<? super AppSetId> continuation) {
        return m1580a(this, continuation);
    }
}
