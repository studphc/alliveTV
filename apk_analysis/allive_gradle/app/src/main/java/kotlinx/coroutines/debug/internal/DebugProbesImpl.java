package kotlinx.coroutines.debug.internal;

import _COROUTINE.ArtificialStackFrames;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import kotlinx.coroutines.internal.ScopeCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1204fq;
import p000.AbstractC1726qj;
import p000.AbstractC1919vr;
import p000.C2000xy;
import p000.C2026yn;
import p000.C2037yy;
import p000.kh1;
import p000.mo2;
import p000.r82;

@Metadata(m5568d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001DJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00152\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0015¢\u0006\u0004\b \u0010!J\u001b\u0010&\u001a\u00020\u00022\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\"H\u0000¢\u0006\u0004\b$\u0010%J\u001b\u0010(\u001a\u00020\u00022\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\"H\u0000¢\u0006\u0004\b'\u0010%J)\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\"\"\u0004\b\u0000\u0010)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0000¢\u0006\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u00020.8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b6\u00100\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\"\u0010=\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u00100\u001a\u0004\b;\u00102\"\u0004\b<\u00104R\u0011\u0010?\u001a\u00020.8G¢\u0006\u0006\u001a\u0004\b>\u00102R\u000b\u0010A\u001a\u00020@8\u0002X\u0082\u0004R\u000b\u0010C\u001a\u00020B8\u0002X\u0082\u0004¨\u0006E"}, m5569d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "", "", "install$kotlinx_coroutines_core", "()V", "install", "uninstall$kotlinx_coroutines_core", "uninstall", "Lkotlinx/coroutines/Job;", "job", "", "hierarchyToString$kotlinx_coroutines_core", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "hierarchyToString", "", "dumpCoroutinesInfoAsJsonAndReferences", "()[Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "info", "enhanceStackTraceWithThreadDumpAsJson", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;)Ljava/lang/String;", "", "dumpCoroutinesInfo", "()Ljava/util/List;", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "dumpDebuggerInfo", "Ljava/io/PrintStream;", "out", "dumpCoroutines", "(Ljava/io/PrintStream;)V", "Ljava/lang/StackTraceElement;", "coroutineTrace", "enhanceStackTraceWithThreadDump", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;Ljava/util/List;)Ljava/util/List;", "Lkotlin/coroutines/Continuation;", TypedValues.AttributesType.S_FRAME, "probeCoroutineResumed$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)V", "probeCoroutineResumed", "probeCoroutineSuspended$kotlinx_coroutines_core", "probeCoroutineSuspended", ExifInterface.GPS_DIRECTION_TRUE, "completion", "probeCoroutineCreated$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "probeCoroutineCreated", "", "e", "Z", "getSanitizeStackTraces$kotlinx_coroutines_core", "()Z", "setSanitizeStackTraces$kotlinx_coroutines_core", "(Z)V", "sanitizeStackTraces", "f", "getEnableCreationStackTraces$kotlinx_coroutines_core", "setEnableCreationStackTraces$kotlinx_coroutines_core", "enableCreationStackTraces", "g", "getIgnoreCoroutinesWithEmptyContext", "setIgnoreCoroutinesWithEmptyContext", "ignoreCoroutinesWithEmptyContext", "isInstalled$kotlinx_coroutines_debug", "isInstalled", "Lkotlinx/atomicfu/AtomicInt;", "installations", "Lkotlinx/atomicfu/AtomicLong;", "sequenceNumber", "CoroutineOwner", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@PublishedApi
@SourceDebugExtension({"SMAP\nDebugProbesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,620:1\n150#1:638\n151#1,4:640\n156#1,5:645\n150#1:650\n151#1,4:652\n156#1,5:657\n1#2:621\n1#2:639\n1#2:651\n766#3:622\n857#3,2:623\n1208#3,2:625\n1238#3,4:627\n1855#3,2:665\n350#3,7:673\n1819#3,8:680\n603#4:631\n603#4:644\n603#4:656\n603#4:662\n1295#4,2:663\n37#5,2:632\n37#5,2:634\n37#5,2:636\n1627#6,6:667\n1735#6,6:688\n*S KotlinDebug\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n245#1:638\n245#1:640,4\n245#1:645,5\n252#1:650\n252#1:652,4\n252#1:657,5\n245#1:639\n252#1:651\n110#1:622\n110#1:623,2\n111#1:625,2\n111#1:627,4\n307#1:665,2\n416#1:673,7\n506#1:680,8\n154#1:631\n245#1:644\n252#1:656\n287#1:662\n288#1:663,2\n211#1:632,2\n212#1:634,2\n213#1:636,2\n355#1:667,6\n558#1:688,6\n*E\n"})
/* loaded from: classes2.dex */
public final class DebugProbesImpl {

    /* renamed from: c */
    public static Thread f21525c;

    /* renamed from: h */
    public static final Function1 f21530h;

    /* renamed from: i */
    public static final ConcurrentWeakMap f21531i;

    /* renamed from: j */
    public static final C2000xy f21532j;

    /* renamed from: k */
    public static final C2037yy f21533k;

    @NotNull
    public static final DebugProbesImpl INSTANCE = new Object();

    /* renamed from: a */
    public static final StackTraceElement f21523a = new ArtificialStackFrames().coroutineCreation();

    /* renamed from: b */
    public static final SimpleDateFormat f21524b = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    /* renamed from: d */
    public static final ConcurrentWeakMap f21526d = new ConcurrentWeakMap(false, 1, 0 == true ? 1 : 0);

    /* renamed from: e, reason: from kotlin metadata */
    public static boolean sanitizeStackTraces = true;

    /* renamed from: f, reason: from kotlin metadata */
    public static boolean enableCreationStackTraces = true;

    /* renamed from: g, reason: from kotlin metadata */
    public static boolean ignoreCoroutinesWithEmptyContext = true;

    @Metadata(m5568d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, m5569d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "info", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;)V", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {

        @JvmField
        @NotNull
        public final Continuation<T> delegate;

        @JvmField
        @NotNull
        public final DebugCoroutineInfoImpl info;

        /* JADX WARN: Multi-variable type inference failed */
        public CoroutineOwner(@NotNull Continuation<? super T> continuation, @NotNull DebugCoroutineInfoImpl debugCoroutineInfoImpl) {
            this.delegate = continuation;
            this.info = debugCoroutineInfoImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        @Nullable
        public CoroutineStackFrame getCallerFrame() {
            StackTraceFrame creationStackBottom = this.info.getCreationStackBottom();
            if (creationStackBottom != null) {
                return creationStackBottom.getCallerFrame();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        @NotNull
        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        @Nullable
        public StackTraceElement getStackTraceElement() {
            StackTraceFrame creationStackBottom = this.info.getCreationStackBottom();
            if (creationStackBottom != null) {
                return creationStackBottom.getStackTraceElement();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(@NotNull Object result) {
            DebugProbesImpl.access$probeCoroutineCompleted(DebugProbesImpl.INSTANCE, this);
            this.delegate.resumeWith(result);
        }

        @NotNull
        public String toString() {
            return this.delegate.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.coroutines.debug.internal.DebugProbesImpl, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v10, types: [xy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v11, types: [yy, java.lang.Object] */
    static {
        Object m8512constructorimpl;
        Object obj = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(null);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            m8512constructorimpl = Result.m8512constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(newInstance, 1));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m8512constructorimpl = Result.m8512constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m8517isFailureimpl(m8512constructorimpl)) {
            obj = m8512constructorimpl;
        }
        f21530h = (Function1) obj;
        f21531i = new ConcurrentWeakMap(true);
        f21532j = new Object();
        f21533k = new Object();
    }

    /* renamed from: a */
    public static void m5707a(Job job, LinkedHashMap linkedHashMap, StringBuilder sb, String str) {
        String obj;
        String obj2;
        DebugCoroutineInfoImpl debugCoroutineInfoImpl = (DebugCoroutineInfoImpl) linkedHashMap.get(job);
        if (debugCoroutineInfoImpl == null) {
            if (!(job instanceof ScopeCoroutine)) {
                StringBuilder m7064t = AbstractC1726qj.m7064t(str);
                if (job instanceof JobSupport) {
                    obj2 = ((JobSupport) job).toDebugString();
                } else {
                    obj2 = job.toString();
                }
                m7064t.append(obj2);
                m7064t.append('\n');
                sb.append(m7064t.toString());
                str = str + '\t';
            }
        } else {
            StackTraceElement stackTraceElement = (StackTraceElement) CollectionsKt___CollectionsKt.firstOrNull((List) debugCoroutineInfoImpl.lastObservedStackTrace$kotlinx_coroutines_core());
            String str2 = debugCoroutineInfoImpl.get_state();
            StringBuilder m7064t2 = AbstractC1726qj.m7064t(str);
            if (job instanceof JobSupport) {
                obj = ((JobSupport) job).toDebugString();
            } else {
                obj = job.toString();
            }
            m7064t2.append(obj);
            m7064t2.append(", continuation is ");
            m7064t2.append(str2);
            m7064t2.append(" at line ");
            m7064t2.append(stackTraceElement);
            m7064t2.append('\n');
            sb.append(m7064t2.toString());
            str = str + '\t';
        }
        Iterator<Job> it = job.getChildren().iterator();
        while (it.hasNext()) {
            m5707a(it.next(), linkedHashMap, sb, str);
        }
    }

    public static final boolean access$isFinished(DebugProbesImpl debugProbesImpl, CoroutineOwner coroutineOwner) {
        Job job;
        debugProbesImpl.getClass();
        CoroutineContext context = coroutineOwner.info.getContext();
        if (context == null || (job = (Job) context.get(Job.INSTANCE)) == null || !job.isCompleted()) {
            return false;
        }
        f21526d.remove(coroutineOwner);
        return true;
    }

    public static final void access$probeCoroutineCompleted(DebugProbesImpl debugProbesImpl, CoroutineOwner coroutineOwner) {
        debugProbesImpl.getClass();
        f21526d.remove(coroutineOwner);
        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = coroutineOwner.info.getLastObservedFrame$kotlinx_coroutines_core();
        if (lastObservedFrame$kotlinx_coroutines_core == null) {
            return;
        }
        while (true) {
            lastObservedFrame$kotlinx_coroutines_core = lastObservedFrame$kotlinx_coroutines_core.getCallerFrame();
            if (lastObservedFrame$kotlinx_coroutines_core == null) {
                lastObservedFrame$kotlinx_coroutines_core = null;
                break;
            } else if (lastObservedFrame$kotlinx_coroutines_core.getStackTraceElement() != null) {
                break;
            }
        }
        if (lastObservedFrame$kotlinx_coroutines_core != null) {
            f21531i.remove(lastObservedFrame$kotlinx_coroutines_core);
        }
    }

    /* renamed from: c */
    public static List m5708c(String str, Thread thread, List list) {
        Object m8512constructorimpl;
        Pair m5575to;
        int i;
        if (Intrinsics.areEqual(str, DebugCoroutineInfoImplKt.RUNNING) && thread != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m8512constructorimpl = Result.m8512constructorimpl(thread.getStackTrace());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m8512constructorimpl = Result.m8512constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m8517isFailureimpl(m8512constructorimpl)) {
                m8512constructorimpl = null;
            }
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) m8512constructorimpl;
            if (stackTraceElementArr == null) {
                return list;
            }
            int length = stackTraceElementArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                    if (Intrinsics.areEqual(stackTraceElement.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && Intrinsics.areEqual(stackTraceElement.getMethodName(), "resumeWith") && Intrinsics.areEqual(stackTraceElement.getFileName(), "ContinuationImpl.kt")) {
                        break;
                    }
                    i2++;
                } else {
                    i2 = -1;
                    break;
                }
            }
            int i3 = 0;
            while (true) {
                if (i3 < 3) {
                    INSTANCE.getClass();
                    StackTraceElement stackTraceElement2 = (StackTraceElement) ArraysKt___ArraysKt.getOrNull(stackTraceElementArr, (i2 - 1) - i3);
                    if (stackTraceElement2 != null) {
                        Iterator it = list.iterator();
                        i = 0;
                        while (it.hasNext()) {
                            StackTraceElement stackTraceElement3 = (StackTraceElement) it.next();
                            if (Intrinsics.areEqual(stackTraceElement3.getFileName(), stackTraceElement2.getFileName()) && Intrinsics.areEqual(stackTraceElement3.getClassName(), stackTraceElement2.getClassName()) && Intrinsics.areEqual(stackTraceElement3.getMethodName(), stackTraceElement2.getMethodName())) {
                                break;
                            }
                            i++;
                        }
                    }
                    i = -1;
                    if (i != -1) {
                        m5575to = TuplesKt.m5575to(Integer.valueOf(i), Integer.valueOf(i3));
                        break;
                    }
                    i3++;
                } else {
                    m5575to = TuplesKt.m5575to(-1, 0);
                    break;
                }
            }
            int intValue = ((Number) m5575to.component1()).intValue();
            int intValue2 = ((Number) m5575to.component2()).intValue();
            if (intValue == -1) {
                return list;
            }
            ArrayList arrayList = new ArrayList((((list.size() + i2) - intValue) - 1) - intValue2);
            int i4 = i2 - intValue2;
            for (int i5 = 0; i5 < i4; i5++) {
                arrayList.add(stackTraceElementArr[i5]);
            }
            int size = list.size();
            for (int i6 = intValue + 1; i6 < size; i6++) {
                arrayList.add(list.get(i6));
            }
            return arrayList;
        }
        return list;
    }

    /* renamed from: d */
    public static void m5709d(PrintStream printStream, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            printStream.print("\n\tat " + ((StackTraceElement) it.next()));
        }
    }

    /* renamed from: b */
    public final void m5710b(PrintStream printStream) {
        String str;
        if (isInstalled$kotlinx_coroutines_debug()) {
            printStream.print("Coroutines dump " + f21524b.format(Long.valueOf(System.currentTimeMillis())));
            for (CoroutineOwner coroutineOwner : SequencesKt___SequencesKt.sortedWith(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(f21526d.keySet()), C1422a.f21544b), new Comparator() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return AbstractC1919vr.compareValues(Long.valueOf(((DebugProbesImpl.CoroutineOwner) t).info.sequenceNumber), Long.valueOf(((DebugProbesImpl.CoroutineOwner) t2).info.sequenceNumber));
                }
            })) {
                DebugCoroutineInfoImpl debugCoroutineInfoImpl = coroutineOwner.info;
                List<StackTraceElement> lastObservedStackTrace$kotlinx_coroutines_core = debugCoroutineInfoImpl.lastObservedStackTrace$kotlinx_coroutines_core();
                DebugProbesImpl debugProbesImpl = INSTANCE;
                String str2 = debugCoroutineInfoImpl.get_state();
                Thread thread = debugCoroutineInfoImpl.lastObservedThread;
                debugProbesImpl.getClass();
                List<StackTraceElement> m5708c = m5708c(str2, thread, lastObservedStackTrace$kotlinx_coroutines_core);
                if (Intrinsics.areEqual(debugCoroutineInfoImpl.get_state(), DebugCoroutineInfoImplKt.RUNNING) && m5708c == lastObservedStackTrace$kotlinx_coroutines_core) {
                    str = debugCoroutineInfoImpl.get_state() + " (Last suspension stacktrace, not an actual stacktrace)";
                } else {
                    str = debugCoroutineInfoImpl.get_state();
                }
                printStream.print("\n\nCoroutine " + coroutineOwner.delegate + ", state: " + str);
                if (lastObservedStackTrace$kotlinx_coroutines_core.isEmpty()) {
                    printStream.print("\n\tat " + f21523a);
                    m5709d(printStream, debugCoroutineInfoImpl.getCreationStackTrace());
                } else {
                    m5709d(printStream, m5708c);
                }
            }
            return;
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    @JvmName(name = "dumpCoroutines")
    public final void dumpCoroutines(@NotNull PrintStream out) {
        synchronized (out) {
            INSTANCE.m5710b(out);
        }
    }

    @NotNull
    public final List<DebugCoroutineInfo> dumpCoroutinesInfo() {
        if (isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.mapNotNull(SequencesKt___SequencesKt.sortedWith(CollectionsKt___CollectionsKt.asSequence(f21526d.keySet()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new Function1<CoroutineOwner<?>, DebugCoroutineInfo>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final DebugCoroutineInfo invoke(@NotNull DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
                    CoroutineContext context;
                    if (DebugProbesImpl.access$isFinished(DebugProbesImpl.INSTANCE, coroutineOwner) || (context = coroutineOwner.info.getContext()) == null) {
                        return null;
                    }
                    return new DebugCoroutineInfo(coroutineOwner.info, context);
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    @NotNull
    public final Object[] dumpCoroutinesInfoAsJsonAndReferences() {
        String str;
        String str2;
        String name;
        List<DebugCoroutineInfo> dumpCoroutinesInfo = dumpCoroutinesInfo();
        int size = dumpCoroutinesInfo.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        ArrayList arrayList3 = new ArrayList(size);
        for (DebugCoroutineInfo debugCoroutineInfo : dumpCoroutinesInfo) {
            CoroutineContext context = debugCoroutineInfo.getContext();
            CoroutineName coroutineName = (CoroutineName) context.get(CoroutineName.INSTANCE);
            Long l = null;
            if (coroutineName != null && (name = coroutineName.getName()) != null) {
                str = DebugProbesImplKt.access$repr(name.toString());
            } else {
                str = null;
            }
            CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) context.get(CoroutineDispatcher.INSTANCE);
            if (coroutineDispatcher != null) {
                str2 = DebugProbesImplKt.access$repr(coroutineDispatcher.toString());
            } else {
                str2 = null;
            }
            StringBuilder m7065u = AbstractC1726qj.m7065u("\n                {\n                    \"name\": ", str, ",\n                    \"id\": ");
            CoroutineId coroutineId = (CoroutineId) context.get(CoroutineId.INSTANCE);
            if (coroutineId != null) {
                l = Long.valueOf(coroutineId.getId());
            }
            m7065u.append(l);
            m7065u.append(",\n                    \"dispatcher\": ");
            m7065u.append(str2);
            m7065u.append(",\n                    \"sequenceNumber\": ");
            m7065u.append(debugCoroutineInfo.getSequenceNumber());
            m7065u.append(",\n                    \"state\": \"");
            m7065u.append(debugCoroutineInfo.getState());
            m7065u.append("\"\n                } \n                ");
            arrayList3.add(mo2.trimIndent(m7065u.toString()));
            arrayList2.add(debugCoroutineInfo.getLastObservedFrame());
            arrayList.add(debugCoroutineInfo.getLastObservedThread());
        }
        return new Object[]{"[" + CollectionsKt___CollectionsKt.joinToString$default(arrayList3, null, null, null, 0, null, null, 63, null) + ']', arrayList.toArray(new Thread[0]), arrayList2.toArray(new CoroutineStackFrame[0]), dumpCoroutinesInfo.toArray(new DebugCoroutineInfo[0])};
    }

    @NotNull
    public final List<DebuggerInfo> dumpDebuggerInfo() {
        if (isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.mapNotNull(SequencesKt___SequencesKt.sortedWith(CollectionsKt___CollectionsKt.asSequence(f21526d.keySet()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new Function1<CoroutineOwner<?>, DebuggerInfo>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final DebuggerInfo invoke(@NotNull DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
                    CoroutineContext context;
                    if (DebugProbesImpl.access$isFinished(DebugProbesImpl.INSTANCE, coroutineOwner) || (context = coroutineOwner.info.getContext()) == null) {
                        return null;
                    }
                    return new DebuggerInfo(coroutineOwner.info, context);
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0058, code lost:
    
        if (r4 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x005a, code lost:
    
        r4 = r4.getCallerFrame();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x005e, code lost:
    
        if (r4 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0065, code lost:
    
        if (r4.getStackTraceElement() == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0069, code lost:
    
        if (r4 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x006b, code lost:
    
        r0.remove(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0068, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0097, code lost:
    
        if (r0 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x009b, code lost:
    
        if ((r0 instanceof kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a1, code lost:
    
        r0 = r0.getCallerFrame();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00a5, code lost:
    
        if (r0 == 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x009d, code lost:
    
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00a8, code lost:
    
        if (r1 != null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00aa, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00af, code lost:
    
        if (isInstalled$kotlinx_coroutines_debug() != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00b2, code lost:
    
        r1.info.updateState$kotlinx_coroutines_core(r8, r7, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00b7, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlin.coroutines.jvm.internal.CoroutineStackFrame] */
    /* JADX WARN: Type inference failed for: r0v15, types: [kotlinx.coroutines.debug.internal.ConcurrentWeakMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9, types: [kotlin.coroutines.jvm.internal.CoroutineStackFrame] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3, types: [kotlin.coroutines.jvm.internal.CoroutineStackFrame] */
    /* JADX WARN: Type inference failed for: r7v4, types: [kotlin.coroutines.jvm.internal.CoroutineStackFrame] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5711e(Continuation continuation, String str) {
        CoroutineOwner coroutineOwner;
        Continuation<?> continuation2;
        CoroutineOwner coroutineOwner2;
        if (!isInstalled$kotlinx_coroutines_debug()) {
            return;
        }
        if (ignoreCoroutinesWithEmptyContext && continuation.getContext() == EmptyCoroutineContext.INSTANCE) {
            return;
        }
        CoroutineOwner coroutineOwner3 = null;
        boolean z = true;
        if (Intrinsics.areEqual(str, DebugCoroutineInfoImplKt.RUNNING)) {
            if (continuation instanceof CoroutineStackFrame) {
                continuation2 = (CoroutineStackFrame) continuation;
            } else {
                continuation2 = 0;
            }
            if (continuation2 != 0 && isInstalled$kotlinx_coroutines_debug()) {
                ?? r0 = f21531i;
                DebugCoroutineInfoImpl debugCoroutineInfoImpl = (DebugCoroutineInfoImpl) r0.remove(continuation2);
                if (debugCoroutineInfoImpl != null) {
                    z = false;
                } else {
                    CoroutineStackFrame coroutineStackFrame = continuation2;
                    while (true) {
                        if (coroutineStackFrame instanceof CoroutineOwner) {
                            coroutineOwner2 = (CoroutineOwner) coroutineStackFrame;
                            break;
                        }
                        coroutineStackFrame = coroutineStackFrame.getCallerFrame();
                        if (coroutineStackFrame == null) {
                            coroutineOwner2 = null;
                            break;
                        }
                    }
                    if (coroutineOwner2 != null && (debugCoroutineInfoImpl = coroutineOwner2.info) != null) {
                        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = debugCoroutineInfoImpl.getLastObservedFrame$kotlinx_coroutines_core();
                    } else {
                        return;
                    }
                }
                Intrinsics.checkNotNull(continuation2, "null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
                debugCoroutineInfoImpl.updateState$kotlinx_coroutines_core(str, continuation2, z);
                while (true) {
                    continuation2 = continuation2.getCallerFrame();
                    if (continuation2 == 0) {
                        break;
                    } else if (continuation2.getStackTraceElement() != null) {
                        coroutineOwner3 = continuation2;
                        break;
                    }
                }
                if (coroutineOwner3 != null) {
                    r0.put(coroutineOwner3, debugCoroutineInfoImpl);
                    return;
                }
                return;
            }
            return;
        }
        if (continuation instanceof CoroutineStackFrame) {
            coroutineOwner = (CoroutineStackFrame) continuation;
        } else {
            coroutineOwner = 0;
        }
    }

    @NotNull
    public final List<StackTraceElement> enhanceStackTraceWithThreadDump(@NotNull DebugCoroutineInfo info, @NotNull List<StackTraceElement> coroutineTrace) {
        return m5708c(info.getState(), info.getLastObservedThread(), coroutineTrace);
    }

    @NotNull
    public final String enhanceStackTraceWithThreadDumpAsJson(@NotNull DebugCoroutineInfo info) {
        String str;
        List<StackTraceElement> enhanceStackTraceWithThreadDump = enhanceStackTraceWithThreadDump(info, info.lastObservedStackTrace());
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : enhanceStackTraceWithThreadDump) {
            StringBuilder sb = new StringBuilder("\n                {\n                    \"declaringClass\": \"");
            sb.append(stackTraceElement.getClassName());
            sb.append("\",\n                    \"methodName\": \"");
            sb.append(stackTraceElement.getMethodName());
            sb.append("\",\n                    \"fileName\": ");
            String fileName = stackTraceElement.getFileName();
            if (fileName != null) {
                str = DebugProbesImplKt.access$repr(fileName.toString());
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(",\n                    \"lineNumber\": ");
            sb.append(stackTraceElement.getLineNumber());
            sb.append("\n                }\n                ");
            arrayList.add(mo2.trimIndent(sb.toString()));
        }
        return "[" + CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null) + ']';
    }

    public final boolean getEnableCreationStackTraces$kotlinx_coroutines_core() {
        return enableCreationStackTraces;
    }

    public final boolean getIgnoreCoroutinesWithEmptyContext() {
        return ignoreCoroutinesWithEmptyContext;
    }

    public final boolean getSanitizeStackTraces$kotlinx_coroutines_core() {
        return sanitizeStackTraces;
    }

    @NotNull
    public final String hierarchyToString$kotlinx_coroutines_core(@NotNull Job job) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            Collection keySet = f21526d.keySet();
            ArrayList arrayList = new ArrayList();
            for (Object obj : keySet) {
                if (((CoroutineOwner) obj).delegate.getContext().get(Job.INSTANCE) != null) {
                    arrayList.add(obj);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(r82.coerceAtLeast(kh1.mapCapacity(AbstractC1204fq.collectionSizeOrDefault(arrayList, 10)), 16));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CoroutineOwner coroutineOwner = (CoroutineOwner) it.next();
                linkedHashMap.put(JobKt.getJob(coroutineOwner.delegate.getContext()), coroutineOwner.info);
            }
            StringBuilder sb = new StringBuilder();
            INSTANCE.getClass();
            m5707a(job, linkedHashMap, sb, "");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    public final void install$kotlinx_coroutines_core() {
        Function1 function1;
        if (C2000xy.f28764a.incrementAndGet(f21532j) > 1) {
            return;
        }
        f21525c = ThreadsKt.thread$default(false, true, null, "Coroutines Debugger Cleaner", 0, C2026yn.f29027d, 21, null);
        if (!AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core() && (function1 = f21530h) != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    @JvmName(name = "isInstalled$kotlinx_coroutines_debug")
    public final boolean isInstalled$kotlinx_coroutines_debug() {
        if (C2000xy.f28764a.get(f21532j) > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        if (r0 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        if ((r0 instanceof kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        r0 = r0.getCallerFrame();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        if (r0 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0024, code lost:
    
        r0 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002f, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        if (kotlinx.coroutines.debug.internal.DebugProbesImpl.enableCreationStackTraces == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0036, code lost:
    
        r0 = new java.lang.Exception().getStackTrace();
        r2 = r0.length;
        r4 = -1;
        r3 = r0.length - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        if (r3 < 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
    
        r5 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0053, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0[r3].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt") == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
    
        if (r5 >= 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:
    
        r4 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        r4 = r4 + 1;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0061, code lost:
    
        if (kotlinx.coroutines.debug.internal.DebugProbesImpl.sanitizeStackTraces != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0063, code lost:
    
        r2 = r2 - r4;
        r3 = new java.util.ArrayList(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0069, code lost:
    
        if (r6 >= r2) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006b, code lost:
    
        r3.add(r0[r6 + r4]);
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d3, code lost:
    
        if (r3.isEmpty() != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d5, code lost:
    
        r0 = r3.listIterator(r3.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e1, code lost:
    
        if (r0.hasPrevious() == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e3, code lost:
    
        r1 = new kotlinx.coroutines.debug.internal.StackTraceFrame(r1, (java.lang.StackTraceElement) r0.previous());
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f0, code lost:
    
        r1 = new kotlinx.coroutines.debug.internal.StackTraceFrame(r1, kotlinx.coroutines.debug.internal.DebugProbesImpl.f21523a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0075, code lost:
    
        r5 = new java.util.ArrayList((r2 - r4) + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x007d, code lost:
    
        if (r4 >= r2) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008c, code lost:
    
        if (p000.ro2.startsWith$default(r0[r4].getClassName(), "kotlinx.coroutines", false, 2, null) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c6, code lost:
    
        r5.add(r0[r4]);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x008e, code lost:
    
        r5.add(r0[r4]);
        r3 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0095, code lost:
    
        if (r3 >= r2) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a1, code lost:
    
        if (p000.ro2.startsWith$default(r0[r3].getClassName(), "kotlinx.coroutines", false, 2, null) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a3, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00a6, code lost:
    
        r7 = r3 - 1;
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a9, code lost:
    
        if (r8 <= r4) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b1, code lost:
    
        if (r0[r8].getFileName() != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b3, code lost:
    
        r8 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b6, code lost:
    
        if (r8 <= r4) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b8, code lost:
    
        if (r8 >= r7) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ba, code lost:
    
        r5.add(r0[r8]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00bf, code lost:
    
        r5.add(r0[r7]);
        r4 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00ce, code lost:
    
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00fc, code lost:
    
        if (isInstalled$kotlinx_coroutines_debug() != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00ff, code lost:
    
        r1 = new kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner(r11, new kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl(r11.getContext(), r1, p000.C2037yy.f29169a.incrementAndGet(kotlinx.coroutines.debug.internal.DebugProbesImpl.f21533k)));
        r11 = java.lang.Boolean.TRUE;
        r0 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f21526d;
        r0.put(r1, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0120, code lost:
    
        if (isInstalled$kotlinx_coroutines_debug() != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0122, code lost:
    
        r0.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0126, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:?, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x002e, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(@NotNull Continuation<? super T> completion) {
        CoroutineStackFrame coroutineStackFrame;
        if (!isInstalled$kotlinx_coroutines_debug()) {
            return completion;
        }
        if (ignoreCoroutinesWithEmptyContext && completion.getContext() == EmptyCoroutineContext.INSTANCE) {
            return completion;
        }
        StackTraceFrame stackTraceFrame = null;
        if (completion instanceof CoroutineStackFrame) {
            coroutineStackFrame = (CoroutineStackFrame) completion;
        } else {
            coroutineStackFrame = null;
        }
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(@NotNull Continuation<?> frame) {
        m5711e(frame, DebugCoroutineInfoImplKt.RUNNING);
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(@NotNull Continuation<?> frame) {
        m5711e(frame, DebugCoroutineInfoImplKt.SUSPENDED);
    }

    public final void setEnableCreationStackTraces$kotlinx_coroutines_core(boolean z) {
        enableCreationStackTraces = z;
    }

    public final void setIgnoreCoroutinesWithEmptyContext(boolean z) {
        ignoreCoroutinesWithEmptyContext = z;
    }

    public final void setSanitizeStackTraces$kotlinx_coroutines_core(boolean z) {
        sanitizeStackTraces = z;
    }

    public final void uninstall$kotlinx_coroutines_core() {
        Function1 function1;
        if (isInstalled$kotlinx_coroutines_debug()) {
            if (C2000xy.f28764a.decrementAndGet(f21532j) != 0) {
                return;
            }
            Thread thread = f21525c;
            if (thread != null) {
                f21525c = null;
                thread.interrupt();
                thread.join();
            }
            f21526d.clear();
            f21531i.clear();
            if (!AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core() && (function1 = f21530h) != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        throw new IllegalStateException("Agent was not installed");
    }
}
