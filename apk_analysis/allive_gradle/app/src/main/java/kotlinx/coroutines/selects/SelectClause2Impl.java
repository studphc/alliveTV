package kotlinx.coroutines.selects;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B¨\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012U\u0010\u000e\u001aQ\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0005\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006j\u0002`\r\u0012U\u0010\u0011\u001aQ\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006j\u0002`\u0010\u0012i\b\u0002\u0010\u0016\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u0013\u0018\u00010\u0006j\u0004\u0018\u0001`\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cRi\u0010\u000e\u001aQ\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0005\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006j\u0002`\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 Ri\u0010\u0011\u001aQ\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006j\u0002`\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R{\u0010\u0016\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u0013\u0018\u00010\u0006j\u0004\u0018\u0001`\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 ¨\u0006%"}, m5569d2 = {"Lkotlinx/coroutines/selects/SelectClause2Impl;", "P", "Q", "Lkotlinx/coroutines/selects/SelectClause2;", "", "clauseObject", "Lkotlin/Function3;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "Lkotlinx/coroutines/selects/SelectInstance;", "select", "param", "", "Lkotlinx/coroutines/selects/RegistrationFunction;", "regFunc", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "processResFunc", "internalResult", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onCancellationConstructor", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)V", "a", "Ljava/lang/Object;", "getClauseObject", "()Ljava/lang/Object;", "b", "Lkotlin/jvm/functions/Function3;", "getRegFunc", "()Lkotlin/jvm/functions/Function3;", "c", "getProcessResFunc", "d", "getOnCancellationConstructor", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class SelectClause2Impl<P, Q> implements SelectClause2<P, Q> {

    /* renamed from: a, reason: from kotlin metadata */
    public final Object clauseObject;

    /* renamed from: b, reason: from kotlin metadata */
    public final Function3 regFunc;

    /* renamed from: c, reason: from kotlin metadata */
    public final Function3 processResFunc;

    /* renamed from: d, reason: from kotlin metadata */
    public final Function3 onCancellationConstructor;

    public SelectClause2Impl(@NotNull Object obj, @NotNull Function3<Object, ? super SelectInstance<?>, Object, Unit> function3, @NotNull Function3<Object, Object, Object, ? extends Object> function32, @Nullable Function3<? super SelectInstance<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> function33) {
        this.clauseObject = obj;
        this.regFunc = function3;
        this.processResFunc = function32;
        this.onCancellationConstructor = function33;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    @NotNull
    public Object getClauseObject() {
        return this.clauseObject;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    @Nullable
    public Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> getOnCancellationConstructor() {
        return this.onCancellationConstructor;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    @NotNull
    public Function3<Object, Object, Object, Object> getProcessResFunc() {
        return this.processResFunc;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    @NotNull
    public Function3<Object, SelectInstance<?>, Object, Unit> getRegFunc() {
        return this.regFunc;
    }

    public /* synthetic */ SelectClause2Impl(Object obj, Function3 function3, Function3 function32, Function3 function33, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, function3, function32, (i & 8) != 0 ? null : function33);
    }
}
