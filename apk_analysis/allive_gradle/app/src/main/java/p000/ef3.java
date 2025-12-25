package p000;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ef3 extends Task {

    /* renamed from: a */
    public final Object f16794a = new Object();

    /* renamed from: b */
    public final C1904vc f16795b;

    /* renamed from: c */
    public boolean f16796c;

    /* renamed from: d */
    public volatile boolean f16797d;

    /* renamed from: e */
    public Object f16798e;

    /* renamed from: f */
    public Exception f16799f;

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, vc] */
    public ef3() {
        ?? obj = new Object();
        obj.f27735b = new Object();
        this.f16795b = obj;
    }

    /* renamed from: a */
    public final void m4713a(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.f16794a) {
            if (!this.f16796c) {
                this.f16796c = true;
                this.f16799f = exc;
            } else {
                throw DuplicateTaskCompletionException.m3750of(this);
            }
        }
        this.f16795b.m7902d(this);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        pb3 pb3Var = new pb3(TaskExecutors.MAIN_THREAD, onCanceledListener);
        this.f16795b.m7901c(pb3Var);
        cf3.m2231a(activity).m2232b(pb3Var);
        m4717e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnCompleteListener(Activity activity, OnCompleteListener onCompleteListener) {
        pb3 pb3Var = new pb3(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.f16795b.m7901c(pb3Var);
        cf3.m2231a(activity).m2232b(pb3Var);
        m4717e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        pb3 pb3Var = new pb3(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.f16795b.m7901c(pb3Var);
        cf3.m2231a(activity).m2232b(pb3Var);
        m4717e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnSuccessListener(Activity activity, OnSuccessListener onSuccessListener) {
        pb3 pb3Var = new pb3(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.f16795b.m7901c(pb3Var);
        cf3.m2231a(activity).m2232b(pb3Var);
        m4717e();
        return this;
    }

    /* renamed from: b */
    public final void m4714b(Object obj) {
        synchronized (this.f16794a) {
            if (!this.f16796c) {
                this.f16796c = true;
                this.f16798e = obj;
            } else {
                throw DuplicateTaskCompletionException.m3750of(this);
            }
        }
        this.f16795b.m7902d(this);
    }

    /* renamed from: c */
    public final void m4715c() {
        synchronized (this.f16794a) {
            try {
                if (this.f16796c) {
                    return;
                }
                this.f16796c = true;
                this.f16797d = true;
                this.f16795b.m7902d(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task continueWith(Continuation continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task continueWithTask(Continuation continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    /* renamed from: d */
    public final boolean m4716d(Object obj) {
        synchronized (this.f16794a) {
            try {
                if (this.f16796c) {
                    return false;
                }
                this.f16796c = true;
                this.f16798e = obj;
                this.f16795b.m7902d(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: e */
    public final void m4717e() {
        synchronized (this.f16794a) {
            try {
                if (!this.f16796c) {
                    return;
                }
                this.f16795b.m7902d(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception getException() {
        Exception exc;
        synchronized (this.f16794a) {
            exc = this.f16799f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Object getResult() {
        Object obj;
        synchronized (this.f16794a) {
            try {
                Preconditions.checkState(this.f16796c, "Task is not yet complete");
                if (!this.f16797d) {
                    Exception exc = this.f16799f;
                    if (exc == null) {
                        obj = this.f16798e;
                    } else {
                        throw new RuntimeExecutionException(exc);
                    }
                } else {
                    throw new CancellationException("Task is already canceled.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isCanceled() {
        return this.f16797d;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.f16794a) {
            z = this.f16796c;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.f16794a) {
            try {
                z = false;
                if (this.f16796c && !this.f16797d && this.f16799f == null) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task onSuccessTask(SuccessContinuation successContinuation) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        ef3 ef3Var = new ef3();
        this.f16795b.m7901c(new pb3(executor, successContinuation, ef3Var));
        m4717e();
        return ef3Var;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task continueWith(Executor executor, Continuation continuation) {
        ef3 ef3Var = new ef3();
        this.f16795b.m7901c(new la3(executor, continuation, ef3Var, 0));
        m4717e();
        return ef3Var;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task continueWithTask(Executor executor, Continuation continuation) {
        ef3 ef3Var = new ef3();
        this.f16795b.m7901c(new la3(executor, continuation, ef3Var, 1));
        m4717e();
        return ef3Var;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnCanceledListener(OnCanceledListener onCanceledListener) {
        addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnCompleteListener(OnCompleteListener onCompleteListener) {
        this.f16795b.m7901c(new pb3(TaskExecutors.MAIN_THREAD, onCompleteListener));
        m4717e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnFailureListener(OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnSuccessListener(OnSuccessListener onSuccessListener) {
        addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task onSuccessTask(Executor executor, SuccessContinuation successContinuation) {
        ef3 ef3Var = new ef3();
        this.f16795b.m7901c(new pb3(executor, successContinuation, ef3Var));
        m4717e();
        return ef3Var;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        this.f16795b.m7901c(new pb3(executor, onCanceledListener));
        m4717e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.f16795b.m7901c(new pb3(executor, onFailureListener));
        m4717e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener) {
        this.f16795b.m7901c(new pb3(executor, onSuccessListener));
        m4717e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task addOnCompleteListener(Executor executor, OnCompleteListener onCompleteListener) {
        this.f16795b.m7901c(new pb3(executor, onCompleteListener));
        m4717e();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Object getResult(Class cls) {
        Object obj;
        synchronized (this.f16794a) {
            try {
                Preconditions.checkState(this.f16796c, "Task is not yet complete");
                if (!this.f16797d) {
                    if (!cls.isInstance(this.f16799f)) {
                        Exception exc = this.f16799f;
                        if (exc == null) {
                            obj = this.f16798e;
                        } else {
                            throw new RuntimeExecutionException(exc);
                        }
                    } else {
                        throw ((Throwable) cls.cast(this.f16799f));
                    }
                } else {
                    throw new CancellationException("Task is already canceled.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
