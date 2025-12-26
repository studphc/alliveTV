package kotlinx.coroutines;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause0Impl;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;
import p000.g51;
import p000.h51;
import p000.ha0;
import p000.jc2;
import p000.kc2;
import p000.p61;
import p000.p80;
import p000.r61;
import p000.s61;
import p000.t61;
import p000.u61;
import p000.v61;
import p000.w61;
import p000.x61;

@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(m5568d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\n\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0004¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0017\u001a\u00060\u0010j\u0002`\u0011*\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0004¢\u0006\u0004\b\u0017\u0010\u0018J6\u0010 \u001a\u00020\u001f2'\u0010\u001e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t0\u0019j\u0002`\u001d¢\u0006\u0004\b \u0010!JF\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042'\u0010\u001e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t0\u0019j\u0002`\u001d¢\u0006\u0004\b \u0010$J\u0013\u0010%\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0017\u0010+\u001a\u00020\t2\u0006\u0010(\u001a\u00020'H\u0000¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\t2\u000e\u0010\u001c\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0015H\u0014¢\u0006\u0004\b.\u0010/J\u0019\u0010,\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0017¢\u0006\u0004\b,\u00100J\u0017\u00101\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016¢\u0006\u0004\b1\u00102J\u0015\u00104\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0003¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0014H\u0016¢\u0006\u0004\b6\u00100J\u0017\u00107\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b7\u00100J\u0019\u0010;\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u000108H\u0000¢\u0006\u0004\b9\u0010:J(\u0010?\u001a\u00020<2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0080\b¢\u0006\u0004\b=\u0010>J\u0013\u0010@\u001a\u00060\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\b@\u0010\u0013J\u0019\u0010C\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u000108H\u0000¢\u0006\u0004\bB\u0010:J\u001b\u0010F\u001a\u0004\u0018\u0001082\b\u0010A\u001a\u0004\u0018\u000108H\u0000¢\u0006\u0004\bD\u0010EJ\u0015\u0010I\u001a\u00020H2\u0006\u0010G\u001a\u00020\u0002¢\u0006\u0004\bI\u0010JJ\u0017\u0010M\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u0014H\u0010¢\u0006\u0004\bL\u00102J\u0019\u0010\"\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\"\u00102J\u0017\u0010N\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0014H\u0014¢\u0006\u0004\bN\u00100J\u0019\u0010P\u001a\u00020\t2\b\u0010O\u001a\u0004\u0018\u000108H\u0014¢\u0006\u0004\bP\u0010QJ\u0019\u0010R\u001a\u00020\t2\b\u0010O\u001a\u0004\u0018\u000108H\u0014¢\u0006\u0004\bR\u0010QJ\u000f\u0010S\u001a\u00020\u0015H\u0016¢\u0006\u0004\bS\u0010/J\u000f\u0010T\u001a\u00020\u0015H\u0007¢\u0006\u0004\bT\u0010/J\u000f\u0010V\u001a\u00020\u0015H\u0010¢\u0006\u0004\bU\u0010/J\u000f\u0010W\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bW\u0010XJ\u0011\u0010[\u001a\u0004\u0018\u000108H\u0000¢\u0006\u0004\bY\u0010ZJ\u0015\u0010\\\u001a\u0004\u0018\u000108H\u0084@ø\u0001\u0000¢\u0006\u0004\b\\\u0010&R\u0015\u0010`\u001a\u0006\u0012\u0002\b\u00030]8F¢\u0006\u0006\u001a\u0004\b^\u0010_R(\u0010f\u001a\u0004\u0018\u00010H2\b\u0010a\u001a\u0004\u0018\u00010H8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0016\u0010\b\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0016\u0010O\u001a\u0004\u0018\u0001088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bi\u0010ZR\u0014\u0010j\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bj\u0010\rR\u0011\u0010k\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bk\u0010\rR\u0011\u0010l\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bl\u0010\rR\u0016\u0010n\u001a\u0004\u0018\u00010\u00148DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bm\u0010XR\u0014\u0010p\u001a\u00020\u00048DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bo\u0010\rR\u0017\u0010u\u001a\u00020q8F¢\u0006\f\u0012\u0004\bt\u0010\u000f\u001a\u0004\br\u0010sR\u0014\u0010w\u001a\u00020\u00048PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bv\u0010\rR\u0017\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00010x8F¢\u0006\u0006\u001a\u0004\by\u0010zR\u0014\u0010|\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b|\u0010\rR\u0014\u0010~\u001a\u00020\u00048PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b}\u0010\rR\u0011\u0010\u007f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u007f\u0010\rR#\u0010\u0084\u0001\u001a\u0007\u0012\u0002\b\u00030\u0080\u00018DX\u0084\u0004¢\u0006\u000f\u0012\u0005\b\u0083\u0001\u0010\u000f\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0015\u0010\u0086\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010H0\u0085\u00018\u0002X\u0082\u0004R\u0015\u0010\u0087\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u0001080\u0085\u00018\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u008d\u0001"}, m5569d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "<init>", "(Z)V", "parent", "", "initParentJob", "(Lkotlinx/coroutines/Job;)V", "start", "()Z", "onStart", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "", "", "message", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "cause", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/JobNode;", "node", "removeNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/JobNode;)V", "removeNode", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "cancellationExceptionMessage", "()Ljava/lang/String;", "(Ljava/lang/Throwable;)Z", "cancelInternal", "(Ljava/lang/Throwable;)V", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "childCancelled", "cancelCoroutine", "", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "getChildJobCancellationCause", "proposedUpdate", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "makeCompletingOnce", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "exception", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "handleJobException", "state", "onCompletionInternal", "(Ljava/lang/Object;)V", "afterCompletion", "toString", "toDebugString", "nameString$kotlinx_coroutines_core", "nameString", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "awaitInternal", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getParent", "()Lkotlinx/coroutines/Job;", "getState$kotlinx_coroutines_core", "isActive", "isCompleted", "isCancelled", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "onJoin", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "isScopedCoroutine", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isCompletedExceptionally", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwaitInternal", "()Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwaitInternal$annotations", "onAwaitInternal", "Lkotlinx/atomicfu/AtomicRef;", "_parentHandle", "_state", "p61", "q61", "r61", "s61", "t61", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 7 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 8 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n+ 9 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n+ 10 CompletionHandler.common.kt\nkotlinx/coroutines/CompletionHandler_commonKt\n+ 11 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 12 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 13 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,1454:1\n706#1,2:1461\n367#1,2:1471\n369#1,4:1476\n373#1,4:1482\n377#1,2:1489\n367#1,2:1491\n369#1,4:1496\n373#1,4:1502\n377#1,2:1509\n178#1,2:1518\n707#1:1520\n178#1,2:1521\n178#1,2:1540\n178#1,2:1555\n706#1,2:1557\n706#1,2:1559\n178#1,2:1561\n706#1,2:1563\n178#1,2:1565\n178#1,2:1572\n178#1,2:1574\n1#2:1455\n1#2:1480\n1#2:1500\n28#3,4:1456\n28#3,4:1523\n28#3,4:1567\n28#3,4:1576\n20#4:1460\n20#4:1527\n20#4:1571\n20#4:1580\n288#5,2:1463\n288#5,2:1465\n19#6:1467\n163#7:1468\n163#7:1469\n153#7,4:1583\n75#8:1470\n75#8:1481\n75#8:1501\n75#8:1514\n341#9,3:1473\n344#9,3:1486\n341#9,3:1493\n344#9,3:1506\n341#9,3:1511\n344#9,3:1515\n47#10:1528\n22#11:1529\n22#11:1530\n13#11:1551\n13#11:1554\n13#11:1581\n13#11:1582\n13#11:1587\n13#11:1588\n134#12:1531\n73#12,3:1532\n135#12,5:1535\n314#13,9:1542\n323#13,2:1552\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n250#1:1461,2\n332#1:1471,2\n332#1:1476,4\n332#1:1482,4\n332#1:1489,2\n364#1:1491,2\n364#1:1496,4\n364#1:1502,4\n364#1:1509,2\n381#1:1518,2\n426#1:1520\n461#1:1521,2\n553#1:1540,2\n594#1:1555,2\n621#1:1557,2\n630#1:1559,2\n694#1:1561,2\n723#1:1563,2\n736#1:1565,2\n809#1:1572,2\n831#1:1574,2\n332#1:1480\n364#1:1500\n213#1:1456,4\n478#1:1523,4\n739#1:1567,4\n884#1:1576,4\n213#1:1460\n478#1:1527\n739#1:1571\n884#1:1580\n261#1:1463,2\n265#1:1465,2\n273#1:1467\n279#1:1468\n281#1:1469\n1218#1:1583,4\n284#1:1470\n332#1:1481\n364#1:1501\n372#1:1514\n332#1:1473,3\n332#1:1486,3\n364#1:1493,3\n364#1:1506,3\n368#1:1511,3\n368#1:1515,3\n483#1:1528\n495#1:1529\n505#1:1530\n561#1:1551\n577#1:1554\n924#1:1581\n974#1:1582\n1237#1:1587\n1259#1:1588\n526#1:1531\n526#1:1532,3\n526#1:1535,5\n559#1:1542,9\n559#1:1552,2\n*E\n"})
/* loaded from: classes2.dex */
public class JobSupport implements Job, ChildJob, ParentJob {

    /* renamed from: a */
    public static final AtomicReferenceFieldUpdater f21421a = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");

    /* renamed from: b */
    public static final AtomicReferenceFieldUpdater f21422b = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle");

    @Volatile
    @Nullable
    private volatile Object _parentHandle;

    @Volatile
    @Nullable
    private volatile Object _state;

    public JobSupport(boolean z) {
        this._state = z ? JobSupportKt.f21430f : JobSupportKt.f21429e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        r6.afterCompletion(r6.m5672e(r7, r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0007, code lost:
    
        if (r8 != null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001a, code lost:
    
        if (kotlinx.coroutines.Job.DefaultImpls.invokeOnCompletion$default(r8.childJob, false, false, new p000.q61(r6, r7, r8, r9), 1, null) == kotlinx.coroutines.NonDisposableHandle.INSTANCE) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
    
        r8 = m5666i(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        if (r8 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void access$continueCompleting(JobSupport jobSupport, r61 r61Var, ChildHandleNode childHandleNode, Object obj) {
        jobSupport.getClass();
        ChildHandleNode m5666i = m5666i(childHandleNode);
    }

    public static final Object access$onAwaitInternalProcessResFunc(JobSupport jobSupport, Object obj, Object obj2) {
        jobSupport.getClass();
        if (!(obj2 instanceof CompletedExceptionally)) {
            return obj2;
        }
        throw ((CompletedExceptionally) obj2).cause;
    }

    public static final void access$onAwaitInternalRegFunc(JobSupport jobSupport, SelectInstance selectInstance, Object obj) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = jobSupport.getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                    state$kotlinx_coroutines_core = JobSupportKt.unboxState(state$kotlinx_coroutines_core);
                }
                selectInstance.selectInRegistrationPhase(state$kotlinx_coroutines_core);
                return;
            }
        } while (jobSupport.m5677k(state$kotlinx_coroutines_core) < 0);
        selectInstance.disposeOnCompletion(jobSupport.invokeOnCompletion(new s61(jobSupport, selectInstance)));
    }

    public static final void access$registerSelectForOnJoin(JobSupport jobSupport, SelectInstance selectInstance, Object obj) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = jobSupport.getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
                return;
            }
        } while (jobSupport.m5677k(state$kotlinx_coroutines_core) < 0);
        selectInstance.disposeOnCompletion(jobSupport.invokeOnCompletion(new t61(jobSupport, selectInstance)));
    }

    public static /* synthetic */ JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport jobSupport, String str, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                th = null;
            }
            if (str == null) {
                str = jobSupport.cancellationExceptionMessage();
            }
            return new JobCancellationException(str, th, jobSupport);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
    }

    public static /* synthetic */ void getOnAwaitInternal$annotations() {
    }

    public static /* synthetic */ void getOnJoin$annotations() {
    }

    /* renamed from: i */
    public static ChildHandleNode m5666i(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    /* renamed from: l */
    public static String m5667l(Object obj) {
        if (obj instanceof r61) {
            r61 r61Var = (r61) obj;
            if (r61Var.m7223c()) {
                return "Cancelling";
            }
            if (!r61Var.m7224d()) {
                return "Active";
            }
            return "Completing";
        }
        if (obj instanceof Incomplete) {
            if (((Incomplete) obj).isActive()) {
                return "Active";
            }
            return "New";
        }
        if (obj instanceof CompletedExceptionally) {
            return "Cancelled";
        }
        return "Completed";
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable th, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return jobSupport.toCancellationException(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    /* renamed from: a */
    public final Object m5668a(Continuation continuation) {
        p61 p61Var = new p61(this, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        p61Var.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(p61Var, invokeOnCompletion(new jc2(p61Var)));
        Object result = p61Var.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public void afterCompletion(@Nullable Object state) {
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final ChildHandle attachChild(@NotNull ChildJob child) {
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(this, true, false, new ChildHandleNode(child), 2, null);
        Intrinsics.checkNotNull(invokeOnCompletion$default, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (ChildHandle) invokeOnCompletion$default;
    }

    @Nullable
    public final Object awaitInternal(@NotNull Continuation<Object> continuation) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                    return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
                }
                throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            }
        } while (m5677k(state$kotlinx_coroutines_core) < 0);
        return m5668a(continuation);
    }

    /* renamed from: b */
    public final boolean m5669b(Throwable th) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null && parentHandle$kotlinx_coroutines_core != NonDisposableHandle.INSTANCE) {
            if (parentHandle$kotlinx_coroutines_core.childCancelled(th) || z) {
                return true;
            }
            return false;
        }
        return z;
    }

    /* renamed from: c */
    public final void m5670c(Incomplete incomplete, Object obj) {
        CompletedExceptionally completedExceptionally;
        Throwable th;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
        CompletionHandlerException completionHandlerException = null;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally != null) {
            th = completedExceptionally.cause;
        } else {
            th = null;
        }
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).invoke(th);
                return;
            } catch (Throwable th2) {
                handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
                return;
            }
        }
        NodeList list = incomplete.getList();
        if (list != null) {
            Object next = list.getNext();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, list); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof JobNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    try {
                        jobNode.invoke(th);
                    } catch (Throwable th3) {
                        if (completionHandlerException != null) {
                            ha0.addSuppressed(completionHandlerException, th3);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        Job.DefaultImpls.cancel(this);
    }

    public final boolean cancelCoroutine(@Nullable Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
    
        r0 = kotlinx.coroutines.JobSupportKt.f21425a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
    
        if (r0 != kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        r0 = m5678m(r0, new kotlinx.coroutines.CompletedExceptionally(m5671d(r11), false, 2, null));
        r1 = kotlinx.coroutines.JobSupportKt.f21426b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        if (r0 == r1) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r1 = kotlinx.coroutines.JobSupportKt.f21425a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        if (r0 != r1) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
    
        r1 = getState$kotlinx_coroutines_core();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
    
        if ((r1 instanceof p000.r61) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a6, code lost:
    
        if ((r1 instanceof kotlinx.coroutines.Incomplete) == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a8, code lost:
    
        if (r0 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00aa, code lost:
    
        r0 = m5671d(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ae, code lost:
    
        r6 = (kotlinx.coroutines.Incomplete) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x000c, code lost:
    
        if (getOnCancelComplete$kotlinx_coroutines_core() != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b5, code lost:
    
        if (r6.isActive() == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00db, code lost:
    
        r6 = m5678m(r1, new kotlinx.coroutines.CompletedExceptionally(r0, false, 2, null));
        r7 = kotlinx.coroutines.JobSupportKt.f21425a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e8, code lost:
    
        if (r6 == r7) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ea, code lost:
    
        r1 = kotlinx.coroutines.JobSupportKt.f21426b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ee, code lost:
    
        if (r6 == r1) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f0, code lost:
    
        r0 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000e, code lost:
    
        r0 = getState$kotlinx_coroutines_core();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0109, code lost:
    
        throw new java.lang.IllegalStateException(("Cannot happen in " + r1).toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b7, code lost:
    
        r7 = m5674g(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bb, code lost:
    
        if (r7 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00be, code lost:
    
        r8 = new p000.r61(r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c3, code lost:
    
        r1 = kotlinx.coroutines.JobSupport.f21421a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c9, code lost:
    
        if (r1.compareAndSet(r10, r6, r8) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if ((r0 instanceof kotlinx.coroutines.Incomplete) == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d7, code lost:
    
        if (r1.get(r10) == r6) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00cb, code lost:
    
        m5676j(r7, r0);
        r11 = kotlinx.coroutines.JobSupportKt.f21425a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x006d, code lost:
    
        r0 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010a, code lost:
    
        r11 = kotlinx.coroutines.JobSupportKt.f21427c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0050, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0051, code lost:
    
        r3 = (p000.r61) r1;
        r3.getClass();
        r3 = p000.r61.f25880d.get(r3);
        r6 = kotlinx.coroutines.JobSupportKt.f21428d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0061, code lost:
    
        if (r3 != r6) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0063, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0066, code lost:
    
        if (r3 == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0068, code lost:
    
        r11 = kotlinx.coroutines.JobSupportKt.f21427c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x006c, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0072, code lost:
    
        r3 = ((p000.r61) r1).m7223c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if ((r0 instanceof p000.r61) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0079, code lost:
    
        if (r11 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x007b, code lost:
    
        if (r3 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0089, code lost:
    
        r11 = ((p000.r61) r1).m7222b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0090, code lost:
    
        if (r3 != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0092, code lost:
    
        r2 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0093, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0094, code lost:
    
        if (r2 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0096, code lost:
    
        m5676j(((p000.r61) r1).f25881a, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x009d, code lost:
    
        r11 = kotlinx.coroutines.JobSupportKt.f21425a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x007d, code lost:
    
        if (r0 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x007f, code lost:
    
        r0 = m5671d(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0083, code lost:
    
        ((p000.r61) r1).m7221a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0065, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0110, code lost:
    
        r11 = kotlinx.coroutines.JobSupportKt.f21425a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0114, code lost:
    
        if (r0 != r11) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0128, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
    
        if (((p000.r61) r0).m7224d() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x011a, code lost:
    
        if (r0 != kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x011d, code lost:
    
        r11 = kotlinx.coroutines.JobSupportKt.f21427c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0121, code lost:
    
        if (r0 != r11) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0124, code lost:
    
        afterCompletion(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:?, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean cancelImpl$kotlinx_coroutines_core(@Nullable Object cause) {
        Object obj;
        obj = JobSupportKt.f21425a;
        Throwable th = null;
    }

    public void cancelInternal(@NotNull Throwable cause) {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    @NotNull
    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(@NotNull Throwable cause) {
        if (cause instanceof CancellationException) {
            return true;
        }
        if (cancelImpl$kotlinx_coroutines_core(cause) && getHandlesException()) {
            return true;
        }
        return false;
    }

    public boolean complete(Object obj) {
        return makeCompleting$kotlinx_coroutines_core(obj);
    }

    /* renamed from: d */
    public final Throwable m5671d(Object obj) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof Throwable;
        }
        if (z) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return th;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob) obj).getChildJobCancellationCause();
    }

    @NotNull
    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(@Nullable String message, @Nullable Throwable cause) {
        if (message == null) {
            message = cancellationExceptionMessage();
        }
        return new JobCancellationException(message, cause, this);
    }

    /* renamed from: e */
    public final Object m5672e(r61 r61Var, Object obj) {
        CompletedExceptionally completedExceptionally;
        Throwable th;
        boolean m7223c;
        Throwable m5673f;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally != null) {
            th = completedExceptionally.cause;
        } else {
            th = null;
        }
        synchronized (r61Var) {
            m7223c = r61Var.m7223c();
            ArrayList<Throwable> m7225e = r61Var.m7225e(th);
            m5673f = m5673f(r61Var, m7225e);
            if (m5673f != null && m7225e.size() > 1) {
                Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(m7225e.size()));
                for (Throwable th2 : m7225e) {
                    if (th2 != m5673f && th2 != m5673f && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                        ha0.addSuppressed(m5673f, th2);
                    }
                }
            }
        }
        if (m5673f != null && m5673f != th) {
            obj = new CompletedExceptionally(m5673f, false, 2, null);
        }
        if (m5673f != null && (m5669b(m5673f) || handleJobException(m5673f))) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((CompletedExceptionally) obj).makeHandled();
        }
        if (!m7223c) {
            onCancelling(m5673f);
        }
        onCompletionInternal(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21421a;
        Object boxIncomplete = JobSupportKt.boxIncomplete(obj);
        while (!atomicReferenceFieldUpdater.compareAndSet(this, r61Var, boxIncomplete) && atomicReferenceFieldUpdater.get(this) == r61Var) {
        }
        m5670c(r61Var, obj);
        return obj;
    }

    /* renamed from: f */
    public final Throwable m5673f(r61 r61Var, ArrayList arrayList) {
        Object obj;
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            if (!r61Var.m7223c()) {
                return null;
            }
            return new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (!(((Throwable) obj) instanceof CancellationException)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) Job.DefaultImpls.fold(this, r, function2);
    }

    /* renamed from: g */
    public final NodeList m5674g(Incomplete incomplete) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        NodeList list = incomplete.getList();
        if (list == null) {
            if (incomplete instanceof p80) {
                return new NodeList();
            }
            if (incomplete instanceof JobNode) {
                JobNode jobNode = (JobNode) incomplete;
                jobNode.addOneIfEmpty(new NodeList());
                LockFreeLinkedListNode nextNode = jobNode.getNextNode();
                do {
                    atomicReferenceFieldUpdater = f21421a;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, jobNode, nextNode)) {
                        break;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == jobNode);
                return null;
            }
            throw new IllegalStateException(("State should have list: " + incomplete).toString());
        }
        return list;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) Job.DefaultImpls.get(this, key);
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof r61) {
            Throwable m7222b = ((r61) state$kotlinx_coroutines_core).m7222b();
            if (m7222b != null) {
                CancellationException cancellationException = toCancellationException(m7222b, DebugStringsKt.getClassSimpleName(this) + " is cancelling");
                if (cancellationException != null) {
                    return cancellationException;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                return toCancellationException$default(this, ((CompletedExceptionally) state$kotlinx_coroutines_core).cause, null, 1, null);
            }
            return new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + " has completed normally", null, this);
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.ParentJob
    @NotNull
    public CancellationException getChildJobCancellationCause() {
        CancellationException cancellationException;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        CancellationException cancellationException2 = null;
        if (state$kotlinx_coroutines_core instanceof r61) {
            cancellationException = ((r61) state$kotlinx_coroutines_core).m7222b();
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            cancellationException = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            cancellationException = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + state$kotlinx_coroutines_core).toString());
        }
        if (cancellationException instanceof CancellationException) {
            cancellationException2 = cancellationException;
        }
        if (cancellationException2 == null) {
            return new JobCancellationException("Parent job is ".concat(m5667l(state$kotlinx_coroutines_core)), cancellationException, this);
        }
        return cancellationException2;
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final Sequence<Job> getChildren() {
        return SequencesKt__SequenceBuilderKt.sequence(new u61(this, null));
    }

    public Object getCompleted() {
        return getCompletedInternal$kotlinx_coroutines_core();
    }

    @Nullable
    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
            }
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
        throw new IllegalStateException("This job has not completed yet");
    }

    @Nullable
    public final Throwable getCompletionCause() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof r61) {
            Throwable m7222b = ((r61) state$kotlinx_coroutines_core).m7222b();
            if (m7222b == null) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            return m7222b;
        }
        if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                return ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            }
            return null;
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final boolean getCompletionCauseHandled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if ((state$kotlinx_coroutines_core instanceof CompletedExceptionally) && ((CompletedExceptionally) state$kotlinx_coroutines_core).getHandled()) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Throwable getCompletionExceptionOrNull() {
        CompletedExceptionally completedExceptionally;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                completedExceptionally = (CompletedExceptionally) state$kotlinx_coroutines_core;
            } else {
                completedExceptionally = null;
            }
            if (completedExceptionally == null) {
                return null;
            }
            return completedExceptionally.cause;
        }
        throw new IllegalStateException("This job has not completed yet");
    }

    /* renamed from: getHandlesException$kotlinx_coroutines_core */
    public boolean getHandlesException() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    @NotNull
    public final CoroutineContext.Key<?> getKey() {
        return Job.INSTANCE;
    }

    @NotNull
    public final SelectClause1<?> getOnAwaitInternal() {
        v61 v61Var = v61.f27661h;
        Intrinsics.checkNotNull(v61Var, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(v61Var, 3);
        w61 w61Var = w61.f28083h;
        Intrinsics.checkNotNull(w61Var, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(w61Var, 3), null, 8, null);
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final SelectClause0 getOnJoin() {
        x61 x61Var = x61.f28448h;
        Intrinsics.checkNotNull(x61Var, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new SelectClause0Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(x61Var, 3), null, 4, null);
    }

    @Override // kotlinx.coroutines.Job
    @Nullable
    public Job getParent() {
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            return parentHandle$kotlinx_coroutines_core.getParent();
        }
        return null;
    }

    @Nullable
    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle) f21422b.get(this);
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = f21421a.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    /* renamed from: h */
    public final Object m5675h(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, invokeOnCompletion(new kc2(cancellableContinuationImpl)));
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    public boolean handleJobException(@NotNull Throwable exception) {
        return false;
    }

    public final void initParentJob(@Nullable Job parent) {
        if (parent == null) {
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
            return;
        }
        parent.start();
        ChildHandle attachChild = parent.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(attachChild);
        if (isCompleted()) {
            attachChild.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> handler) {
        return invokeOnCompletion(false, true, handler);
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if ((state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).isActive()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally) && (!(state$kotlinx_coroutines_core instanceof r61) || !((r61) state$kotlinx_coroutines_core).m7223c())) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
    }

    public boolean isScopedCoroutine() {
        return false;
    }

    /* renamed from: j */
    public final void m5676j(NodeList nodeList, Throwable th) {
        onCancelling(th);
        Object next = nodeList.getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.invoke(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ha0.addSuppressed(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
        m5669b(th);
    }

    @Override // kotlinx.coroutines.Job
    @Nullable
    public final Object join(@NotNull Continuation<? super Unit> continuation) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                JobKt.ensureActive(continuation.getContext());
                return Unit.INSTANCE;
            }
        } while (m5677k(state$kotlinx_coroutines_core) < 0);
        Object m5675h = m5675h(continuation);
        if (m5675h == b51.getCOROUTINE_SUSPENDED()) {
            return m5675h;
        }
        return Unit.INSTANCE;
    }

    /* renamed from: k */
    public final int m5677k(Object obj) {
        p80 p80Var;
        boolean z = obj instanceof p80;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21421a;
        if (z) {
            if (!((p80) obj).f25060a) {
                p80Var = JobSupportKt.f21430f;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, p80Var)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        return -1;
                    }
                }
                onStart();
                return 1;
            }
            return 0;
        }
        if (!(obj instanceof InactiveNodeList)) {
            return 0;
        }
        NodeList list = ((InactiveNodeList) obj).getList();
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, list)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        onStart();
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ca, code lost:
    
        if (r1 != null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00dd, code lost:
    
        if (kotlinx.coroutines.Job.DefaultImpls.invokeOnCompletion$default(r1.childJob, false, false, new p000.q61(r9, r2, r1, r11), 1, null) == kotlinx.coroutines.NonDisposableHandle.INSTANCE) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e2, code lost:
    
        r1 = m5666i(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e6, code lost:
    
        if (r1 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
    
        return kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ec, code lost:
    
        return m5672e(r2, r11);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Throwable, T] */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m5678m(Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Symbol symbol;
        r61 r61Var;
        CompletedExceptionally completedExceptionally;
        ChildHandleNode childHandleNode;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        if (!(obj instanceof Incomplete)) {
            symbol5 = JobSupportKt.f21425a;
            return symbol5;
        }
        ChildHandleNode childHandleNode2 = null;
        if (((obj instanceof p80) || (obj instanceof JobNode)) && !(obj instanceof ChildHandleNode) && !(obj2 instanceof CompletedExceptionally)) {
            Incomplete incomplete = (Incomplete) obj;
            Object boxIncomplete = JobSupportKt.boxIncomplete(obj2);
            do {
                atomicReferenceFieldUpdater = f21421a;
                if (atomicReferenceFieldUpdater.compareAndSet(this, incomplete, boxIncomplete)) {
                    onCancelling(null);
                    onCompletionInternal(obj2);
                    m5670c(incomplete, obj2);
                    return obj2;
                }
            } while (atomicReferenceFieldUpdater.get(this) == incomplete);
            symbol = JobSupportKt.f21426b;
            return symbol;
        }
        Incomplete incomplete2 = (Incomplete) obj;
        NodeList m5674g = m5674g(incomplete2);
        if (m5674g == null) {
            symbol4 = JobSupportKt.f21426b;
            return symbol4;
        }
        if (incomplete2 instanceof r61) {
            r61Var = (r61) incomplete2;
        } else {
            r61Var = null;
        }
        if (r61Var == null) {
            r61Var = new r61(m5674g, null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (r61Var) {
            if (r61Var.m7224d()) {
                symbol3 = JobSupportKt.f21425a;
                return symbol3;
            }
            r61.f25878b.set(r61Var, 1);
            if (r61Var != incomplete2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f21421a;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, incomplete2, r61Var)) {
                    if (atomicReferenceFieldUpdater2.get(this) != incomplete2) {
                        symbol2 = JobSupportKt.f21426b;
                        return symbol2;
                    }
                }
            }
            boolean m7223c = r61Var.m7223c();
            if (obj2 instanceof CompletedExceptionally) {
                completedExceptionally = (CompletedExceptionally) obj2;
            } else {
                completedExceptionally = null;
            }
            if (completedExceptionally != null) {
                r61Var.m7221a(completedExceptionally.cause);
            }
            ?? m7222b = !m7223c ? r61Var.m7222b() : 0;
            objectRef.element = m7222b;
            if (m7222b != 0) {
                m5676j(m5674g, m7222b);
            }
            if (incomplete2 instanceof ChildHandleNode) {
                childHandleNode = (ChildHandleNode) incomplete2;
            } else {
                childHandleNode = null;
            }
            if (childHandleNode == null) {
                NodeList list = incomplete2.getList();
                if (list != null) {
                    childHandleNode2 = m5666i(list);
                }
            } else {
                childHandleNode2 = childHandleNode;
            }
        }
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(@Nullable Object proposedUpdate) {
        Object m5678m;
        Symbol symbol;
        Symbol symbol2;
        do {
            m5678m = m5678m(getState$kotlinx_coroutines_core(), proposedUpdate);
            symbol = JobSupportKt.f21425a;
            if (m5678m == symbol) {
                return false;
            }
            if (m5678m != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                symbol2 = JobSupportKt.f21426b;
            } else {
                return true;
            }
        } while (m5678m == symbol2);
        afterCompletion(m5678m);
        return true;
    }

    @Nullable
    public final Object makeCompletingOnce$kotlinx_coroutines_core(@Nullable Object proposedUpdate) {
        Object m5678m;
        Symbol symbol;
        CompletedExceptionally completedExceptionally;
        Symbol symbol2;
        do {
            m5678m = m5678m(getState$kotlinx_coroutines_core(), proposedUpdate);
            symbol = JobSupportKt.f21425a;
            if (m5678m != symbol) {
                symbol2 = JobSupportKt.f21426b;
            } else {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + proposedUpdate;
                Throwable th = null;
                if (proposedUpdate instanceof CompletedExceptionally) {
                    completedExceptionally = (CompletedExceptionally) proposedUpdate;
                } else {
                    completedExceptionally = null;
                }
                if (completedExceptionally != null) {
                    th = completedExceptionally.cause;
                }
                throw new IllegalStateException(str, th);
            }
        } while (m5678m == symbol2);
        return m5678m;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.minusKey(this, key);
    }

    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    public void onCancelling(@Nullable Throwable cause) {
    }

    public void onCompletionInternal(@Nullable Object state) {
    }

    public void onStart() {
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(@NotNull ParentJob parentJob) {
        cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return Job.DefaultImpls.plus(this, coroutineContext);
    }

    public final void removeNode$kotlinx_coroutines_core(@NotNull JobNode node) {
        p80 p80Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof JobNode) {
                if (state$kotlinx_coroutines_core == node) {
                    p80Var = JobSupportKt.f21430f;
                    do {
                        atomicReferenceFieldUpdater = f21421a;
                        if (atomicReferenceFieldUpdater.compareAndSet(this, state$kotlinx_coroutines_core, p80Var)) {
                            return;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == state$kotlinx_coroutines_core);
                } else {
                    return;
                }
            } else {
                if ((state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).getList() != null) {
                    node.mo8899remove();
                    return;
                }
                return;
            }
        }
    }

    public final void setParentHandle$kotlinx_coroutines_core(@Nullable ChildHandle childHandle) {
        f21422b.set(this, childHandle);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int m5677k;
        do {
            m5677k = m5677k(getState$kotlinx_coroutines_core());
            if (m5677k == 0) {
                return false;
            }
        } while (m5677k != 1);
        return true;
    }

    @NotNull
    public final CancellationException toCancellationException(@NotNull Throwable th, @Nullable String str) {
        CancellationException cancellationException;
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            if (str == null) {
                str = cancellationExceptionMessage();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    @InternalCoroutinesApi
    @NotNull
    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + m5667l(getState$kotlinx_coroutines_core()) + '}';
    }

    @NotNull
    public String toString() {
        return toDebugString() + '@' + DebugStringsKt.getHexAddress(this);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable cause) {
        Throwable jobCancellationException;
        if (cause == null || (jobCancellationException = toCancellationException$default(this, cause, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(jobCancellationException);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, @NotNull Function1<? super Throwable, Unit> handler) {
        final JobNode jobNode;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2;
        Throwable th;
        int tryCondAddNext;
        boolean z;
        if (onCancelling) {
            jobNode = handler instanceof JobCancellingNode ? (JobCancellingNode) handler : null;
            if (jobNode == null) {
                jobNode = new g51(handler);
            }
        } else {
            jobNode = handler instanceof JobNode ? (JobNode) handler : null;
            if (jobNode == null) {
                jobNode = new h51(handler);
            }
        }
        jobNode.setJob(this);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof p80) {
                p80 p80Var = (p80) state$kotlinx_coroutines_core;
                if (p80Var.f25060a) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f21421a;
                    while (!atomicReferenceFieldUpdater3.compareAndSet(this, state$kotlinx_coroutines_core, jobNode)) {
                        if (atomicReferenceFieldUpdater3.get(this) != state$kotlinx_coroutines_core) {
                            break;
                        }
                    }
                    return jobNode;
                }
                NodeList nodeList = new NodeList();
                Incomplete inactiveNodeList = p80Var.f25060a ? nodeList : new InactiveNodeList(nodeList);
                do {
                    atomicReferenceFieldUpdater = f21421a;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, p80Var, inactiveNodeList)) {
                        break;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == p80Var);
            } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
                NodeList list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                if (list == null) {
                    Intrinsics.checkNotNull(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    JobNode jobNode2 = (JobNode) state$kotlinx_coroutines_core;
                    jobNode2.addOneIfEmpty(new NodeList());
                    LockFreeLinkedListNode nextNode = jobNode2.getNextNode();
                    do {
                        atomicReferenceFieldUpdater2 = f21421a;
                        if (atomicReferenceFieldUpdater2.compareAndSet(this, jobNode2, nextNode)) {
                            break;
                        }
                    } while (atomicReferenceFieldUpdater2.get(this) == jobNode2);
                } else {
                    DisposableHandle disposableHandle = NonDisposableHandle.INSTANCE;
                    if (onCancelling && (state$kotlinx_coroutines_core instanceof r61)) {
                        synchronized (state$kotlinx_coroutines_core) {
                            try {
                                th = ((r61) state$kotlinx_coroutines_core).m7222b();
                                if (th != null) {
                                    if ((handler instanceof ChildHandleNode) && !((r61) state$kotlinx_coroutines_core).m7224d()) {
                                    }
                                }
                                final Incomplete incomplete = (Incomplete) state$kotlinx_coroutines_core;
                                LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(jobNode) { // from class: kotlinx.coroutines.JobSupport$addLastAtomic$$inlined$addLastIf$1
                                    @Override // kotlinx.coroutines.internal.AtomicOp
                                    @Nullable
                                    public Object prepare(@NotNull LockFreeLinkedListNode affected) {
                                        if (this.getState$kotlinx_coroutines_core() == incomplete) {
                                            return null;
                                        }
                                        return LockFreeLinkedListKt.getCONDITION_FALSE();
                                    }
                                };
                                while (true) {
                                    int tryCondAddNext2 = list.getPrevNode().tryCondAddNext(jobNode, list, condAddOp);
                                    if (tryCondAddNext2 == 1) {
                                        z = true;
                                        break;
                                    }
                                    if (tryCondAddNext2 == 2) {
                                        z = false;
                                        break;
                                    }
                                }
                                if (z) {
                                    if (th == null) {
                                        return jobNode;
                                    }
                                    disposableHandle = jobNode;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } else {
                        th = null;
                    }
                    if (th != null) {
                        if (invokeImmediately) {
                            handler.invoke(th);
                        }
                        return disposableHandle;
                    }
                    final Incomplete incomplete2 = (Incomplete) state$kotlinx_coroutines_core;
                    LockFreeLinkedListNode.CondAddOp condAddOp2 = new LockFreeLinkedListNode.CondAddOp(jobNode) { // from class: kotlinx.coroutines.JobSupport$addLastAtomic$$inlined$addLastIf$1
                        @Override // kotlinx.coroutines.internal.AtomicOp
                        @Nullable
                        public Object prepare(@NotNull LockFreeLinkedListNode affected) {
                            if (this.getState$kotlinx_coroutines_core() == incomplete2) {
                                return null;
                            }
                            return LockFreeLinkedListKt.getCONDITION_FALSE();
                        }
                    };
                    do {
                        tryCondAddNext = list.getPrevNode().tryCondAddNext(jobNode, list, condAddOp2);
                        if (tryCondAddNext == 1) {
                            return jobNode;
                        }
                    } while (tryCondAddNext != 2);
                }
            } else {
                if (invokeImmediately) {
                    CompletedExceptionally completedExceptionally = state$kotlinx_coroutines_core instanceof CompletedExceptionally ? (CompletedExceptionally) state$kotlinx_coroutines_core : null;
                    handler.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
                }
                return NonDisposableHandle.INSTANCE;
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    public Job plus(@NotNull Job job) {
        return Job.DefaultImpls.plus((Job) this, job);
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(@Nullable CancellationException cause) {
        if (cause == null) {
            cause = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cause);
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable exception) {
        throw exception;
    }
}
