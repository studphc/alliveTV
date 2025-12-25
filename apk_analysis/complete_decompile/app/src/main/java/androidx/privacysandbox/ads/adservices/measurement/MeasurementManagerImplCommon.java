package androidx.privacysandbox.ads.adservices.measurement;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ExecutorC0582c6;
import p000.b51;
import p000.ok1;

@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 5), @RequiresExtension(extension = 31, version = 9)})
@Metadata(m5568d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0097@¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0097@¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0097@¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0097@¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0018H\u0097@¢\u0006\u0004\b\u000f\u0010\u0019J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u001aH\u0097@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dH\u0097@¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/MeasurementManagerImplCommon;", "Landroidx/privacysandbox/ads/adservices/measurement/MeasurementManager;", "Landroid/adservices/measurement/MeasurementManager;", "mMeasurementManager", "<init>", "(Landroid/adservices/measurement/MeasurementManager;)V", "Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest;", "deletionRequest", "", "deleteRegistrations", "(Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/net/Uri;", "attributionSource", "Landroid/view/InputEvent;", "inputEvent", "registerSource", "(Landroid/net/Uri;Landroid/view/InputEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trigger", "registerTrigger", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;", "request", "registerWebSource", "(Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/privacysandbox/ads/adservices/measurement/SourceRegistrationRequest;", "(Landroidx/privacysandbox/ads/adservices/measurement/SourceRegistrationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerRegistrationRequest;", "registerWebTrigger", "(Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerRegistrationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getMeasurementApiStatus", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Landroid/adservices/measurement/MeasurementManager;", "getMMeasurementManager", "()Landroid/adservices/measurement/MeasurementManager;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
@SourceDebugExtension({"SMAP\nMeasurementManagerImplCommon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MeasurementManagerImplCommon.kt\nandroidx/privacysandbox/ads/adservices/measurement/MeasurementManagerImplCommon\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,130:1\n314#2,11:131\n314#2,11:142\n314#2,11:153\n314#2,11:164\n314#2,11:175\n314#2,11:186\n*S KotlinDebug\n*F\n+ 1 MeasurementManagerImplCommon.kt\nandroidx/privacysandbox/ads/adservices/measurement/MeasurementManagerImplCommon\n*L\n44#1:131,11\n56#1:142,11\n69#1:153,11\n81#1:164,11\n111#1:175,11\n123#1:186,11\n*E\n"})
/* loaded from: classes.dex */
public class MeasurementManagerImplCommon extends MeasurementManager {

    /* renamed from: a, reason: from kotlin metadata */
    public final android.adservices.measurement.MeasurementManager mMeasurementManager;

    public MeasurementManagerImplCommon(@NotNull android.adservices.measurement.MeasurementManager mMeasurementManager) {
        Intrinsics.checkNotNullParameter(mMeasurementManager, "mMeasurementManager");
        this.mMeasurementManager = mMeasurementManager;
    }

    @DoNotInline
    /* renamed from: a */
    public static /* synthetic */ Object m1586a(MeasurementManagerImplCommon measurementManagerImplCommon, DeletionRequest deletionRequest, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        measurementManagerImplCommon.getMMeasurementManager().deleteRegistrations(deletionRequest.convertToAdServices$ads_adservices_release(), new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    /* renamed from: b */
    public static /* synthetic */ Object m1587b(MeasurementManagerImplCommon measurementManagerImplCommon, Continuation<? super Integer> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        measurementManagerImplCommon.getMMeasurementManager().getMeasurementApiStatus(new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    /* renamed from: c */
    public static /* synthetic */ Object m1588c(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, InputEvent inputEvent, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        measurementManagerImplCommon.getMMeasurementManager().registerSource(uri, inputEvent, new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @ExperimentalFeatures.RegisterSourceOptIn
    /* renamed from: d */
    public static /* synthetic */ Object m1589d(MeasurementManagerImplCommon measurementManagerImplCommon, SourceRegistrationRequest sourceRegistrationRequest, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ok1(measurementManagerImplCommon, sourceRegistrationRequest, null), continuation);
        if (coroutineScope == b51.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    /* renamed from: e */
    public static /* synthetic */ Object m1590e(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        measurementManagerImplCommon.getMMeasurementManager().registerTrigger(uri, new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    /* renamed from: f */
    public static /* synthetic */ Object m1591f(MeasurementManagerImplCommon measurementManagerImplCommon, WebSourceRegistrationRequest webSourceRegistrationRequest, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        measurementManagerImplCommon.getMMeasurementManager().registerWebSource(webSourceRegistrationRequest.convertToAdServices$ads_adservices_release(), new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    /* renamed from: g */
    public static /* synthetic */ Object m1592g(MeasurementManagerImplCommon measurementManagerImplCommon, WebTriggerRegistrationRequest webTriggerRegistrationRequest, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        measurementManagerImplCommon.getMMeasurementManager().registerWebTrigger(webTriggerRegistrationRequest.convertToAdServices$ads_adservices_release(), new ExecutorC0582c6(0), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @DoNotInline
    @Nullable
    public Object deleteRegistrations(@NotNull DeletionRequest deletionRequest, @NotNull Continuation<? super Unit> continuation) {
        return m1586a(this, deletionRequest, continuation);
    }

    @NotNull
    public final android.adservices.measurement.MeasurementManager getMMeasurementManager() {
        return this.mMeasurementManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @Nullable
    public Object getMeasurementApiStatus(@NotNull Continuation<? super Integer> continuation) {
        return m1587b(this, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @Nullable
    public Object registerSource(@NotNull Uri uri, @Nullable InputEvent inputEvent, @NotNull Continuation<? super Unit> continuation) {
        return m1588c(this, uri, inputEvent, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @Nullable
    public Object registerTrigger(@NotNull Uri uri, @NotNull Continuation<? super Unit> continuation) {
        return m1590e(this, uri, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @Nullable
    public Object registerWebSource(@NotNull WebSourceRegistrationRequest webSourceRegistrationRequest, @NotNull Continuation<? super Unit> continuation) {
        return m1591f(this, webSourceRegistrationRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @Nullable
    public Object registerWebTrigger(@NotNull WebTriggerRegistrationRequest webTriggerRegistrationRequest, @NotNull Continuation<? super Unit> continuation) {
        return m1592g(this, webTriggerRegistrationRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @Nullable
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @ExperimentalFeatures.RegisterSourceOptIn
    public Object registerSource(@NotNull SourceRegistrationRequest sourceRegistrationRequest, @NotNull Continuation<? super Unit> continuation) {
        return m1589d(this, sourceRegistrationRequest, continuation);
    }
}
