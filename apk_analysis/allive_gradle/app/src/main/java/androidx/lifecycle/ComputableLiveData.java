package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ComputableLiveData;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00028\u0000H%¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u00168\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u00168\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001a\u0010 \u001a\u00020\u001f8\u0000X\u0081\u0004¢\u0006\f\n\u0004\b \u0010!\u0012\u0004\b\"\u0010\tR\u001a\u0010#\u001a\u00020\u001f8\u0000X\u0081\u0004¢\u0006\f\n\u0004\b#\u0010!\u0012\u0004\b$\u0010\t¨\u0006%"}, m5569d2 = {"Landroidx/lifecycle/ComputableLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/util/concurrent/Executor;", "executor", "<init>", "(Ljava/util/concurrent/Executor;)V", "", "invalidate", "()V", "compute", "()Ljava/lang/Object;", "a", "Ljava/util/concurrent/Executor;", "getExecutor$lifecycle_livedata_release", "()Ljava/util/concurrent/Executor;", "Landroidx/lifecycle/LiveData;", "b", "Landroidx/lifecycle/LiveData;", "getLiveData", "()Landroidx/lifecycle/LiveData;", "liveData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInvalid$lifecycle_livedata_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "invalid", "d", "getComputing$lifecycle_livedata_release", "computing", "Ljava/lang/Runnable;", "refreshRunnable", "Ljava/lang/Runnable;", "getRefreshRunnable$lifecycle_livedata_release$annotations", "invalidationRunnable", "getInvalidationRunnable$lifecycle_livedata_release$annotations", "lifecycle-livedata_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class ComputableLiveData<T> {

    /* renamed from: a, reason: from kotlin metadata */
    public final Executor executor;

    /* renamed from: b */
    public final ComputableLiveData$_liveData$1 f6471b;

    /* renamed from: c, reason: from kotlin metadata */
    public final AtomicBoolean invalid;

    /* renamed from: d, reason: from kotlin metadata */
    public final AtomicBoolean computing;

    @JvmField
    @NotNull
    public final Runnable invalidationRunnable;

    @JvmField
    @NotNull
    public final Runnable refreshRunnable;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ComputableLiveData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @VisibleForTesting
    public static /* synthetic */ void getInvalidationRunnable$lifecycle_livedata_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshRunnable$lifecycle_livedata_release$annotations() {
    }

    @WorkerThread
    public abstract T compute();

    @NotNull
    /* renamed from: getComputing$lifecycle_livedata_release, reason: from getter */
    public final AtomicBoolean getComputing() {
        return this.computing;
    }

    @NotNull
    /* renamed from: getExecutor$lifecycle_livedata_release, reason: from getter */
    public final Executor getExecutor() {
        return this.executor;
    }

    @NotNull
    /* renamed from: getInvalid$lifecycle_livedata_release, reason: from getter */
    public final AtomicBoolean getInvalid() {
        return this.invalid;
    }

    @NotNull
    public LiveData<T> getLiveData() {
        return this.f6471b;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.invalidationRunnable);
    }

    @JvmOverloads
    public ComputableLiveData(@NotNull Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.executor = executor;
        this.f6471b = new LiveData<T>() { // from class: androidx.lifecycle.ComputableLiveData$_liveData$1
            @Override // androidx.lifecycle.LiveData
            public void onActive() {
                ComputableLiveData computableLiveData = ComputableLiveData.this;
                computableLiveData.getExecutor().execute(computableLiveData.refreshRunnable);
            }
        };
        this.invalid = new AtomicBoolean(true);
        final int i = 0;
        this.computing = new AtomicBoolean(false);
        this.refreshRunnable = new Runnable(this) { // from class: hu

            /* renamed from: b */
            public final /* synthetic */ ComputableLiveData f18173b;

            {
                this.f18173b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AtomicBoolean atomicBoolean;
                switch (i) {
                    case 0:
                        ComputableLiveData this$0 = this.f18173b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        do {
                            AtomicBoolean atomicBoolean2 = this$0.computing;
                            boolean z = false;
                            boolean compareAndSet = atomicBoolean2.compareAndSet(false, true);
                            atomicBoolean = this$0.invalid;
                            if (compareAndSet) {
                                Object obj = null;
                                boolean z2 = false;
                                while (atomicBoolean.compareAndSet(true, false)) {
                                    try {
                                        obj = this$0.compute();
                                        z2 = true;
                                    } catch (Throwable th) {
                                        atomicBoolean2.set(false);
                                        throw th;
                                    }
                                }
                                if (z2) {
                                    this$0.getLiveData().postValue(obj);
                                }
                                atomicBoolean2.set(false);
                                z = z2;
                            }
                            if (!z) {
                                return;
                            }
                        } while (atomicBoolean.get());
                        return;
                    default:
                        ComputableLiveData this$02 = this.f18173b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        boolean hasActiveObservers = this$02.getLiveData().hasActiveObservers();
                        if (this$02.invalid.compareAndSet(false, true) && hasActiveObservers) {
                            this$02.executor.execute(this$02.refreshRunnable);
                            return;
                        }
                        return;
                }
            }
        };
        final int i2 = 1;
        this.invalidationRunnable = new Runnable(this) { // from class: hu

            /* renamed from: b */
            public final /* synthetic */ ComputableLiveData f18173b;

            {
                this.f18173b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AtomicBoolean atomicBoolean;
                switch (i2) {
                    case 0:
                        ComputableLiveData this$0 = this.f18173b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        do {
                            AtomicBoolean atomicBoolean2 = this$0.computing;
                            boolean z = false;
                            boolean compareAndSet = atomicBoolean2.compareAndSet(false, true);
                            atomicBoolean = this$0.invalid;
                            if (compareAndSet) {
                                Object obj = null;
                                boolean z2 = false;
                                while (atomicBoolean.compareAndSet(true, false)) {
                                    try {
                                        obj = this$0.compute();
                                        z2 = true;
                                    } catch (Throwable th) {
                                        atomicBoolean2.set(false);
                                        throw th;
                                    }
                                }
                                if (z2) {
                                    this$0.getLiveData().postValue(obj);
                                }
                                atomicBoolean2.set(false);
                                z = z2;
                            }
                            if (!z) {
                                return;
                            }
                        } while (atomicBoolean.get());
                        return;
                    default:
                        ComputableLiveData this$02 = this.f18173b;
                        Intrinsics.checkNotNullParameter(this$02, "this$0");
                        boolean hasActiveObservers = this$02.getLiveData().hasActiveObservers();
                        if (this$02.invalid.compareAndSet(false, true) && hasActiveObservers) {
                            this$02.executor.execute(this$02.refreshRunnable);
                            return;
                        }
                        return;
                }
            }
        };
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ComputableLiveData(Executor executor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(executor);
        if ((i & 1) != 0) {
            executor = ArchTaskExecutor.getIOThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(executor, "getIOThreadExecutor()");
        }
    }
}
