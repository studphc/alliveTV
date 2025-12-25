package p000;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class la3 implements xe3, OnSuccessListener, OnFailureListener, OnCanceledListener {

    /* renamed from: a */
    public final /* synthetic */ int f22427a;

    /* renamed from: b */
    public final Executor f22428b;

    /* renamed from: c */
    public final Continuation f22429c;

    /* renamed from: d */
    public final ef3 f22430d;

    public /* synthetic */ la3(Executor executor, Continuation continuation, ef3 ef3Var, int i) {
        this.f22427a = i;
        this.f22428b = executor;
        this.f22429c = continuation;
        this.f22430d = ef3Var;
    }

    @Override // p000.xe3
    /* renamed from: a */
    public final void mo5912a(Task task) {
        switch (this.f22427a) {
            case 0:
                this.f22428b.execute(new xy1(23, this, task));
                return;
            default:
                this.f22428b.execute(new xy1(24, this, task));
                return;
        }
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener, com.google.android.gms.tasks.OnTokenCanceledListener
    public void onCanceled() {
        this.f22430d.m4715c();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        this.f22430d.m4713a(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        this.f22430d.m4714b(obj);
    }

    @Override // p000.xe3
    public final void zzc() {
        switch (this.f22427a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
