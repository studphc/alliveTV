package p000;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class pb3 implements xe3, OnSuccessListener, OnFailureListener, OnCanceledListener {

    /* renamed from: a */
    public final /* synthetic */ int f25108a;

    /* renamed from: b */
    public final Executor f25109b;

    /* renamed from: c */
    public final Object f25110c;

    /* renamed from: d */
    public Object f25111d;

    public pb3(Executor executor, OnCanceledListener onCanceledListener) {
        this.f25108a = 0;
        this.f25110c = new Object();
        this.f25109b = executor;
        this.f25111d = onCanceledListener;
    }

    /* renamed from: b */
    private final void m6899b() {
        synchronized (this.f25110c) {
            this.f25111d = null;
        }
    }

    /* renamed from: c */
    private final void m6900c() {
        synchronized (this.f25110c) {
            this.f25111d = null;
        }
    }

    /* renamed from: d */
    private final void m6901d() {
        synchronized (this.f25110c) {
            this.f25111d = null;
        }
    }

    /* renamed from: e */
    private final void m6902e(Task task) {
        synchronized (this.f25110c) {
            try {
                if (((OnCompleteListener) this.f25111d) == null) {
                    return;
                }
                this.f25109b.execute(new xy1(26, this, task));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: f */
    private final void m6903f(Task task) {
        if (!task.isSuccessful() && !task.isCanceled()) {
            synchronized (this.f25110c) {
                try {
                    if (((OnFailureListener) this.f25111d) == null) {
                        return;
                    }
                    this.f25109b.execute(new xy1(28, this, task));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: g */
    private final void m6904g(Task task) {
        if (task.isSuccessful()) {
            synchronized (this.f25110c) {
                try {
                    if (((OnSuccessListener) this.f25111d) == null) {
                        return;
                    }
                    this.f25109b.execute(new ed3(1, this, task));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // p000.xe3
    /* renamed from: a */
    public final void mo5912a(Task task) {
        switch (this.f25108a) {
            case 0:
                if (task.isCanceled()) {
                    synchronized (this.f25110c) {
                        try {
                            if (((OnCanceledListener) this.f25111d) != null) {
                                this.f25109b.execute(new sn1(21, this));
                            }
                        } finally {
                        }
                    }
                    return;
                }
                return;
            case 1:
                m6902e(task);
                return;
            case 2:
                m6903f(task);
                return;
            case 3:
                m6904g(task);
                return;
            default:
                this.f25109b.execute(new ed3(3, this, task));
                return;
        }
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener, com.google.android.gms.tasks.OnTokenCanceledListener
    public void onCanceled() {
        ((ef3) this.f25111d).m4715c();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        ((ef3) this.f25111d).m4713a(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((ef3) this.f25111d).m4714b(obj);
    }

    @Override // p000.xe3
    public final void zzc() {
        switch (this.f25108a) {
            case 0:
                synchronized (this.f25110c) {
                    this.f25111d = null;
                }
                return;
            case 1:
                m6899b();
                return;
            case 2:
                m6900c();
                return;
            case 3:
                m6901d();
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public pb3(Executor executor, OnCompleteListener onCompleteListener) {
        this.f25108a = 1;
        this.f25110c = new Object();
        this.f25109b = executor;
        this.f25111d = onCompleteListener;
    }

    public pb3(Executor executor, OnFailureListener onFailureListener) {
        this.f25108a = 2;
        this.f25110c = new Object();
        this.f25109b = executor;
        this.f25111d = onFailureListener;
    }

    public pb3(Executor executor, OnSuccessListener onSuccessListener) {
        this.f25108a = 3;
        this.f25110c = new Object();
        this.f25109b = executor;
        this.f25111d = onSuccessListener;
    }

    public pb3(Executor executor, SuccessContinuation successContinuation, ef3 ef3Var) {
        this.f25108a = 4;
        this.f25109b = executor;
        this.f25110c = successContinuation;
        this.f25111d = ef3Var;
    }
}
