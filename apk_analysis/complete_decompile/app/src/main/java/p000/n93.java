package p000;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final class n93 implements OnSuccessListener, OnFailureListener, OnCanceledListener {

    /* renamed from: a */
    public final Object f23297a = new Object();

    /* renamed from: b */
    public final int f23298b;

    /* renamed from: c */
    public final ef3 f23299c;

    /* renamed from: d */
    public int f23300d;

    /* renamed from: e */
    public int f23301e;

    /* renamed from: f */
    public int f23302f;

    /* renamed from: g */
    public Exception f23303g;

    /* renamed from: h */
    public boolean f23304h;

    public n93(int i, ef3 ef3Var) {
        this.f23298b = i;
        this.f23299c = ef3Var;
    }

    /* renamed from: a */
    public final void m6328a() {
        int i = this.f23300d + this.f23301e + this.f23302f;
        int i2 = this.f23298b;
        if (i == i2) {
            Exception exc = this.f23303g;
            ef3 ef3Var = this.f23299c;
            if (exc != null) {
                ef3Var.m4713a(new ExecutionException(this.f23301e + " out of " + i2 + " underlying tasks failed", this.f23303g));
                return;
            }
            if (this.f23304h) {
                ef3Var.m4715c();
            } else {
                ef3Var.m4714b(null);
            }
        }
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener, com.google.android.gms.tasks.OnTokenCanceledListener
    public final void onCanceled() {
        synchronized (this.f23297a) {
            this.f23302f++;
            this.f23304h = true;
            m6328a();
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.f23297a) {
            this.f23301e++;
            this.f23303g = exc;
            m6328a();
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        synchronized (this.f23297a) {
            this.f23300d++;
            m6328a();
        }
    }
}
