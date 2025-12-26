package kotlinx.coroutines.selects;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.s32;

@Metadata(m5568d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aG\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0006\u0010\u0007\"\u001a\u0010\r\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f*Â\u0001\b\u0007\u0010\u0017\"[\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u00010\u000e2[\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u00010\u000eB\u0002\b\u0016*¦\u0001\b\u0007\u0010\u001a\"M\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e2M\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000eB\u0002\b\u0016*¦\u0001\b\u0007\u0010\u001b\"M\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\u000e2M\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\u000eB\u0002\b\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m5569d2 = {"R", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "select", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "f", "Lkotlinx/coroutines/internal/Symbol;", "getPARAM_CLAUSE_0", "()Lkotlinx/coroutines/internal/Symbol;", "PARAM_CLAUSE_0", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "param", "internalResult", "", "Lkotlinx/coroutines/InternalCoroutinesApi;", "OnCancellationConstructor", "clauseObject", "clauseResult", "ProcessResultFunction", "RegistrationFunction", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class SelectKt {

    /* renamed from: a */
    public static final s32 f22101a = s32.f26230e;

    /* renamed from: b */
    public static final Symbol f22102b = new Symbol("STATE_REG");

    /* renamed from: c */
    public static final Symbol f22103c = new Symbol("STATE_COMPLETED");

    /* renamed from: d */
    public static final Symbol f22104d = new Symbol("STATE_CANCELLED");

    /* renamed from: e */
    public static final Symbol f22105e = new Symbol("NO_RESULT");

    /* renamed from: f */
    public static final Symbol f22106f = new Symbol("PARAM_CLAUSE_0");

    @InternalCoroutinesApi
    public static /* synthetic */ void OnCancellationConstructor$annotations() {
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void ProcessResultFunction$annotations() {
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void RegistrationFunction$annotations() {
    }

    public static final TrySelectDetailedResult access$TrySelectDetailedResult(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return TrySelectDetailedResult.ALREADY_SELECTED;
                    }
                    throw new IllegalStateException(("Unexpected internal result: " + i).toString());
                }
                return TrySelectDetailedResult.CANCELLED;
            }
            return TrySelectDetailedResult.REREGISTER;
        }
        return TrySelectDetailedResult.SUCCESSFUL;
    }

    public static final /* synthetic */ Symbol access$getNO_RESULT$p() {
        return f22105e;
    }

    public static final /* synthetic */ Symbol access$getSTATE_CANCELLED$p() {
        return f22104d;
    }

    public static final /* synthetic */ Symbol access$getSTATE_COMPLETED$p() {
        return f22103c;
    }

    public static final /* synthetic */ Symbol access$getSTATE_REG$p() {
        return f22102b;
    }

    public static final boolean access$tryResume(CancellableContinuation cancellableContinuation, Function1 function1) {
        Object tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, null, function1);
        if (tryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(tryResume);
        return true;
    }

    @NotNull
    public static final Symbol getPARAM_CLAUSE_0() {
        return f22106f;
    }

    @Nullable
    public static final <R> Object select(@NotNull Function1<? super SelectBuilder<? super R>, Unit> function1, @NotNull Continuation<? super R> continuation) {
        SelectImplementation selectImplementation = new SelectImplementation(continuation.getContext());
        function1.invoke(selectImplementation);
        return selectImplementation.doSelect(continuation);
    }
}
