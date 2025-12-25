package kotlinx.coroutines.selects;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1167eq;
import p000.b51;
import p000.yf2;

@Metadata(m5568d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004:\u0001=B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00028\u0000H\u0091@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ5\u0010\u0011\u001a\u00020\u0010*\u00020\u000b2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012JG\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u00028\u00010\u00142\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0015H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0016J[\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0001\u0010\u0017\"\u0004\b\u0002\u0010\u0013*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u00012\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0015H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u001aJ'\u0010\u001e\u001a\u00020\u0010*\f0\u001bR\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J#\u0010(\u001a\u00020\u00102\n\u0010%\u001a\u0006\u0012\u0002\b\u00030$2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0019\u0010+\u001a\u00020\u00102\b\u0010*\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b+\u0010,J!\u0010/\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\u0002012\u0006\u0010-\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b2\u00103J\u001a\u0010\u0011\u001a\u00020\u00102\b\u00105\u001a\u0004\u0018\u000104H\u0096\u0002¢\u0006\u0004\b\u0011\u00106R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0011\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e0;8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, m5569d2 = {"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "doSelect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "reregister", "register", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Z)V", "Lkotlinx/coroutines/DisposableHandle;", "disposableHandle", "disposeOnCompletion", "(Lkotlinx/coroutines/DisposableHandle;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", "", FirebaseAnalytics.Param.INDEX, "invokeOnCancellation", "(Lkotlinx/coroutines/internal/Segment;I)V", "internalResult", "selectInRegistrationPhase", "(Ljava/lang/Object;)V", "clauseObject", "result", "trySelect", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectDetailed", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "", "cause", "(Ljava/lang/Throwable;)V", "a", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/atomicfu/AtomicRef;", "state", "ClauseData", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@PublishedApi
@SourceDebugExtension({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,873:1\n1#2:874\n2624#3,3:875\n1855#3,2:888\n1855#3,2:896\n1855#3,2:898\n314#4,9:878\n323#4,2:890\n19#5:887\n153#6,4:892\n*S KotlinDebug\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n*L\n505#1:875,3\n569#1:888,2\n726#1:896,2\n751#1:898,2\n545#1:878,9\n545#1:890,2\n561#1:887\n711#1:892,4\n*E\n"})
/* loaded from: classes2.dex */
public class SelectImplementation<R> extends CancelHandler implements SelectBuilder<R>, SelectInstanceInternal<R> {

    /* renamed from: f */
    public static final AtomicReferenceFieldUpdater f22090f = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");

    /* renamed from: a, reason: from kotlin metadata */
    public final CoroutineContext context;

    /* renamed from: c */
    public Object f22093c;

    @Volatile
    @Nullable
    private volatile Object state = SelectKt.access$getSTATE_REG$p();

    /* renamed from: b */
    public ArrayList f22092b = new ArrayList(2);

    /* renamed from: d */
    public int f22094d = -1;

    /* renamed from: e */
    public Object f22095e = SelectKt.access$getNO_RESULT$p();

    @Metadata(m5568d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B¸\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012U\u0010\u000b\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003j\u0002`\n\u0012U\u0010\u000e\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003j\u0002`\r\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012g\u0010\u0014\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011\u0018\u00010\u0003j\u0004\u0018\u0001`\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0019\u001a\u00020\u00182\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001f\u001a\u00028\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J1\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010%Ru\u0010\u0014\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011\u0018\u00010\u0003j\u0004\u0018\u0001`\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010)\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, m5569d2 = {"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "clauseObject", "Lkotlin/Function3;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "Lkotlinx/coroutines/selects/SelectInstance;", "select", "param", "", "Lkotlinx/coroutines/selects/RegistrationFunction;", "regFunc", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "processResFunc", "block", "internalResult", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onCancellationConstructor", "<init>", "(Lkotlinx/coroutines/selects/SelectImplementation;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "Lkotlinx/coroutines/selects/SelectImplementation;", "", "tryRegisterAsWaiter", "(Lkotlinx/coroutines/selects/SelectImplementation;)Z", "result", "processResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "argument", "invokeBlock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "()V", "createOnCancellationAction", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "Ljava/lang/Object;", "Lkotlin/jvm/functions/Function3;", "disposableHandleOrSegment", "", "indexInSegment", "I", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation$ClauseData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,873:1\n1#2:874\n*E\n"})
    /* loaded from: classes2.dex */
    public final class ClauseData {

        /* renamed from: a */
        public final Function3 f22096a;

        /* renamed from: b */
        public final Function3 f22097b;

        /* renamed from: c */
        public final Object f22098c;

        @JvmField
        @NotNull
        public final Object clauseObject;

        /* renamed from: d */
        public final Object f22099d;

        @JvmField
        @Nullable
        public Object disposableHandleOrSegment;

        @JvmField
        public int indexInSegment = -1;

        @JvmField
        @Nullable
        public final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onCancellationConstructor;

        /* JADX WARN: Multi-variable type inference failed */
        public ClauseData(@NotNull Object obj, @NotNull Function3<Object, ? super SelectInstance<?>, Object, Unit> function3, @NotNull Function3<Object, Object, Object, ? extends Object> function32, @Nullable Object obj2, @NotNull Object obj3, @Nullable Function3<? super SelectInstance<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> function33) {
            this.clauseObject = obj;
            this.f22096a = function3;
            this.f22097b = function32;
            this.f22098c = obj2;
            this.f22099d = obj3;
            this.onCancellationConstructor = function33;
        }

        @Nullable
        public final Function1<Throwable, Unit> createOnCancellationAction(@NotNull SelectInstance<?> select, @Nullable Object internalResult) {
            Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> function3 = this.onCancellationConstructor;
            if (function3 != null) {
                return function3.invoke(select, this.f22098c, internalResult);
            }
            return null;
        }

        public final void dispose() {
            Object obj = this.disposableHandleOrSegment;
            DisposableHandle disposableHandle = null;
            if (obj instanceof Segment) {
                ((Segment) obj).onCancellation(this.indexInSegment, null, SelectImplementation.this.getContext());
                return;
            }
            if (obj instanceof DisposableHandle) {
                disposableHandle = (DisposableHandle) obj;
            }
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }

        @Nullable
        public final Object invokeBlock(@Nullable Object obj, @NotNull Continuation<? super R> continuation) {
            Object obj2 = this.f22098c;
            Symbol param_clause_0 = SelectKt.getPARAM_CLAUSE_0();
            Object obj3 = this.f22099d;
            if (obj2 == param_clause_0) {
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((Function1) obj3).invoke(continuation);
            }
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function2) obj3).invoke(obj, continuation);
        }

        @Nullable
        public final Object processResult(@Nullable Object result) {
            return this.f22097b.invoke(this.clauseObject, this.f22098c, result);
        }

        public final boolean tryRegisterAsWaiter(@NotNull SelectImplementation<R> select) {
            this.f22096a.invoke(this.clauseObject, select, this.f22098c);
            if (select.f22095e == SelectKt.access$getNO_RESULT$p()) {
                return true;
            }
            return false;
        }
    }

    public SelectImplementation(@NotNull CoroutineContext coroutineContext) {
        this.context = coroutineContext;
    }

    public static final boolean access$getInRegistrationPhase(SelectImplementation selectImplementation) {
        selectImplementation.getClass();
        Object obj = f22090f.get(selectImplementation);
        if (obj != SelectKt.access$getSTATE_REG$p() && !(obj instanceof List)) {
            return false;
        }
        return true;
    }

    public static final boolean access$isCancelled(SelectImplementation selectImplementation) {
        selectImplementation.getClass();
        if (f22090f.get(selectImplementation) == SelectKt.access$getSTATE_CANCELLED$p()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object access$processResultAndInvokeBlockRecoveringException(SelectImplementation selectImplementation, ClauseData clauseData, Object obj, Continuation continuation) {
        C1481a c1481a;
        int i;
        selectImplementation.getClass();
        if (continuation instanceof C1481a) {
            c1481a = (C1481a) continuation;
            int i2 = c1481a.f22112f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1481a.f22112f = i2 - Integer.MIN_VALUE;
                Object obj2 = c1481a.f22110d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1481a.f22112f;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    Object processResult = clauseData.processResult(obj);
                    c1481a.f22112f = 1;
                    obj2 = clauseData.invokeBlock(processResult, c1481a);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return obj2;
            }
        }
        c1481a = new C1481a(selectImplementation, continuation);
        Object obj22 = c1481a.f22110d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1481a.f22112f;
        if (i == 0) {
        }
        return obj22;
    }

    public static final void access$reregisterClause(SelectImplementation selectImplementation, Object obj) {
        ClauseData m5747c = selectImplementation.m5747c(obj);
        Intrinsics.checkNotNull(m5747c);
        m5747c.disposableHandleOrSegment = null;
        m5747c.indexInSegment = -1;
        selectImplementation.register(m5747c, true);
    }

    public static /* synthetic */ void register$default(SelectImplementation selectImplementation, ClauseData clauseData, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            selectImplementation.register(clauseData, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }

    /* renamed from: a */
    public final Object m5745a(Continuation continuation) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22090f;
        Object obj = atomicReferenceFieldUpdater.get(this);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        ClauseData clauseData = (ClauseData) obj;
        Object obj2 = this.f22095e;
        ArrayList arrayList = this.f22092b;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ClauseData clauseData2 = (ClauseData) it.next();
                if (clauseData2 != clauseData) {
                    clauseData2.dispose();
                }
            }
            atomicReferenceFieldUpdater.set(this, SelectKt.access$getSTATE_COMPLETED$p());
            this.f22095e = SelectKt.access$getNO_RESULT$p();
            this.f22092b = null;
        }
        return clauseData.invokeBlock(clauseData.processResult(obj2), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0055 A[PHI: r6
      0x0055: PHI (r6v5 java.lang.Object) = (r6v4 java.lang.Object), (r6v1 java.lang.Object) binds: [B:17:0x0052, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0054 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m5746b(Continuation continuation) {
        yf2 yf2Var;
        Object obj;
        Object coroutine_suspended;
        int i;
        SelectImplementation<R> selectImplementation;
        if (continuation instanceof yf2) {
            yf2Var = (yf2) continuation;
            int i2 = yf2Var.f28942g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                yf2Var.f28942g = i2 - Integer.MIN_VALUE;
                obj = yf2Var.f28940e;
                coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = yf2Var.f28942g;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    selectImplementation = yf2Var.f28939d;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    yf2Var.f28939d = this;
                    yf2Var.f28942g = 1;
                    if (m5749e(yf2Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    selectImplementation = this;
                }
                yf2Var.f28939d = null;
                yf2Var.f28942g = 2;
                obj = selectImplementation.m5745a(yf2Var);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            }
        }
        yf2Var = new yf2(this, continuation);
        obj = yf2Var.f28940e;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = yf2Var.f28942g;
        if (i == 0) {
        }
        yf2Var.f28939d = null;
        yf2Var.f28942g = 2;
        obj = selectImplementation.m5745a(yf2Var);
        if (obj != coroutine_suspended) {
        }
    }

    /* renamed from: c */
    public final ClauseData m5747c(Object obj) {
        ArrayList arrayList = this.f22092b;
        Object obj2 = null;
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ClauseData) next).clauseObject == obj) {
                obj2 = next;
                break;
            }
        }
        ClauseData clauseData = (ClauseData) obj2;
        if (clauseData != null) {
            return clauseData;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    /* renamed from: d */
    public final int m5748d(Object obj, Object obj2) {
        boolean z;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22090f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            boolean z2 = false;
            if (obj3 instanceof CancellableContinuation) {
                ClauseData m5747c = m5747c(obj);
                if (m5747c != null) {
                    Function1<Throwable, Unit> createOnCancellationAction = m5747c.createOnCancellationAction(this, obj2);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, m5747c)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj3) {
                            break;
                        }
                    }
                    this.f22095e = obj2;
                    if (SelectKt.access$tryResume((CancellableContinuation) obj3, createOnCancellationAction)) {
                        return 0;
                    }
                    this.f22095e = null;
                    return 2;
                }
                continue;
            } else {
                if (Intrinsics.areEqual(obj3, SelectKt.access$getSTATE_COMPLETED$p())) {
                    z = true;
                } else {
                    z = obj3 instanceof ClauseData;
                }
                if (z) {
                    return 3;
                }
                if (Intrinsics.areEqual(obj3, SelectKt.access$getSTATE_CANCELLED$p())) {
                    return 2;
                }
                if (Intrinsics.areEqual(obj3, SelectKt.access$getSTATE_REG$p())) {
                    List listOf = AbstractC1167eq.listOf(obj);
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, listOf)) {
                            z2 = true;
                            break;
                        }
                        if (atomicReferenceFieldUpdater.get(this) != obj3) {
                            break;
                        }
                    }
                    if (z2) {
                        return 1;
                    }
                } else if (obj3 instanceof List) {
                    List plus = CollectionsKt___CollectionsKt.plus((Collection<? extends Object>) obj3, obj);
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, plus)) {
                            z2 = true;
                            break;
                        }
                        if (atomicReferenceFieldUpdater.get(this) != obj3) {
                            break;
                        }
                    }
                    if (z2) {
                        return 1;
                    }
                } else {
                    throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                }
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnCompletion(@NotNull DisposableHandle disposableHandle) {
        this.f22093c = disposableHandle;
    }

    @PublishedApi
    @Nullable
    public Object doSelect(@NotNull Continuation<? super R> continuation) {
        if (f22090f.get(this) instanceof ClauseData) {
            return m5745a(continuation);
        }
        return m5746b(continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        r0 = r0.getResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
    
        if (r0 != p000.b51.getCOROUTINE_SUSPENDED()) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
    
        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0081, code lost:
    
        if (r0 != p000.b51.getCOROUTINE_SUSPENDED()) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m5749e(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22090f;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.access$getSTATE_REG$p()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f22090f;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, cancellableContinuationImpl)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
                cancellableContinuationImpl.invokeOnCancellation(this);
                break loop0;
            }
            if (obj instanceof List) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f22090f;
                Symbol access$getSTATE_REG$p = SelectKt.access$getSTATE_REG$p();
                while (true) {
                    if (atomicReferenceFieldUpdater3.compareAndSet(this, obj, access$getSTATE_REG$p)) {
                        Iterator it = ((Iterable) obj).iterator();
                        while (it.hasNext()) {
                            access$reregisterClause(this, it.next());
                        }
                    } else if (atomicReferenceFieldUpdater3.get(this) != obj) {
                        break;
                    }
                }
            } else if (obj instanceof ClauseData) {
                cancellableContinuationImpl.resume(Unit.INSTANCE, ((ClauseData) obj).createOnCancellationAction(this, this.f22095e));
            } else {
                throw new IllegalStateException(("unexpected state: " + obj).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @NotNull
    public CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
        this.f22093c = segment;
        this.f22094d = index;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    @Deprecated(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @ReplaceWith(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
    @LowPriorityInOverloadResolution
    @ExperimentalCoroutinesApi
    public void onTimeout(long j, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        SelectBuilder.DefaultImpls.onTimeout(this, j, function1);
    }

    @JvmName(name = "register")
    public final void register(@NotNull SelectImplementation<R>.ClauseData clauseData, boolean z) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22090f;
        if (atomicReferenceFieldUpdater.get(this) instanceof ClauseData) {
            return;
        }
        if (!z) {
            Object obj = clauseData.clauseObject;
            ArrayList arrayList = this.f22092b;
            Intrinsics.checkNotNull(arrayList);
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((ClauseData) it.next()).clauseObject == obj) {
                        throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
                    }
                }
            }
        }
        if (clauseData.tryRegisterAsWaiter(this)) {
            if (!z) {
                ArrayList arrayList2 = this.f22092b;
                Intrinsics.checkNotNull(arrayList2);
                arrayList2.add(clauseData);
            }
            clauseData.disposableHandleOrSegment = this.f22093c;
            clauseData.indexInSegment = this.f22094d;
            this.f22093c = null;
            this.f22094d = -1;
            return;
        }
        atomicReferenceFieldUpdater.set(this, clauseData);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void selectInRegistrationPhase(@Nullable Object internalResult) {
        this.f22095e = internalResult;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect(@NotNull Object clauseObject, @Nullable Object result) {
        if (m5748d(clauseObject, result) == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public final TrySelectDetailedResult trySelectDetailed(@NotNull Object clauseObject, @Nullable Object result) {
        return SelectKt.access$TrySelectDetailedResult(m5748d(clauseObject, result));
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.DefaultImpls.invoke(this, selectClause2, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(@NotNull SelectClause0 selectClause0, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        register$default(this, new ClauseData(selectClause0.getClauseObject(), selectClause0.getRegFunc(), selectClause0.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), function1, selectClause0.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(@NotNull SelectClause1<? extends Q> selectClause1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        register$default(this, new ClauseData(selectClause1.getClauseObject(), selectClause1.getRegFunc(), selectClause1.getProcessResFunc(), null, function2, selectClause1.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, P p, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        register$default(this, new ClauseData(selectClause2.getClauseObject(), selectClause2.getRegFunc(), selectClause2.getProcessResFunc(), p, function2, selectClause2.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@Nullable Throwable cause) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22090f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.access$getSTATE_COMPLETED$p()) {
                return;
            }
            Symbol access$getSTATE_CANCELLED$p = SelectKt.access$getSTATE_CANCELLED$p();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, access$getSTATE_CANCELLED$p)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            ArrayList arrayList = this.f22092b;
            if (arrayList == null) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ClauseData) it.next()).dispose();
            }
            this.f22095e = SelectKt.access$getNO_RESULT$p();
            this.f22092b = null;
            return;
        }
    }
}
