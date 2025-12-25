package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@InternalCoroutinesApi
@Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, m5569d2 = {"Lkotlinx/coroutines/NonDisposableHandle;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/ChildHandle;", "", "dispose", "()V", "", "cause", "", "childCancelled", "(Ljava/lang/Throwable;)Z", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/Job;", "getParent", "()Lkotlinx/coroutines/Job;", "parent", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class NonDisposableHandle implements DisposableHandle, ChildHandle {

    @NotNull
    public static final NonDisposableHandle INSTANCE = new Object();

    @Override // kotlinx.coroutines.ChildHandle
    public boolean childCancelled(@NotNull Throwable cause) {
        return false;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
    }

    @Override // kotlinx.coroutines.ChildHandle
    @Nullable
    public Job getParent() {
        return null;
    }

    @NotNull
    public String toString() {
        return "NonDisposableHandle";
    }
}
