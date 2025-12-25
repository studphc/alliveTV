package kotlinx.coroutines;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H\u0097@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0017¢\u0006\u0004\b\u000b\u0010\fJ8\u0010\u0015\u001a\u00020\u00142'\u0010\u0013\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\rj\u0002`\u0012H\u0017¢\u0006\u0004\b\u0015\u0010\u0016JH\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032'\u0010\u0013\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\rj\u0002`\u0012H\u0017¢\u0006\u0004\b\u0015\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00062\u000e\u0010\u0011\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001a\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0017¢\u0006\u0004\b\u001a\u0010\u001cJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0017¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u001a\u0010*\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b+\u0010(\u001a\u0004\b*\u0010\u0005R\u001a\u0010,\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b-\u0010(\u001a\u0004\b,\u0010\u0005R\u001a\u0010.\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b/\u0010(\u001a\u0004\b.\u0010\u0005R\u001a\u00104\u001a\u0002008VX\u0097\u0004¢\u0006\f\u0012\u0004\b3\u0010(\u001a\u0004\b1\u00102R \u00109\u001a\b\u0012\u0004\u0012\u00020\u0002058VX\u0097\u0004¢\u0006\f\u0012\u0004\b8\u0010(\u001a\u0004\b6\u00107\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, m5569d2 = {"Lkotlinx/coroutines/NonCancellable;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/Job;", "", "start", "()Z", "", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "cause", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "", "toString", "()Ljava/lang/String;", "getParent", "()Lkotlinx/coroutines/Job;", "getParent$annotations", "()V", "parent", "isActive", "isActive$annotations", "isCompleted", "isCompleted$annotations", "isCancelled", "isCancelled$annotations", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "onJoin", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "getChildren$annotations", "children", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class NonCancellable extends AbstractCoroutineContextElement implements Job {

    @NotNull
    public static final NonCancellable INSTANCE = new AbstractCoroutineContextElement(Job.INSTANCE);

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static /* synthetic */ void getChildren$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static /* synthetic */ void getOnJoin$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static /* synthetic */ void getParent$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static /* synthetic */ void isActive$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static /* synthetic */ void isCancelled$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static /* synthetic */ void isCompleted$annotations() {
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    @NotNull
    public ChildHandle attachChild(@NotNull ChildJob child) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public void cancel(@Nullable CancellationException cause) {
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    @NotNull
    public CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public Sequence<Job> getChildren() {
        return SequencesKt__SequencesKt.emptySequence();
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public SelectClause0 getOnJoin() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    @Nullable
    public Job getParent() {
        return null;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    @NotNull
    public DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> handler) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCompleted() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    @Nullable
    public Object join(@NotNull Continuation<? super Unit> continuation) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    public Job plus(@NotNull Job job) {
        return Job.DefaultImpls.plus((Job) this, job);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public boolean start() {
        return false;
    }

    @NotNull
    public String toString() {
        return "NonCancellable";
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable cause) {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    @NotNull
    public DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, @NotNull Function1<? super Throwable, Unit> handler) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }
}
