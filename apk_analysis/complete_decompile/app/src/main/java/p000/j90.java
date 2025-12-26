package p000;

import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j90 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f20427a;

    /* renamed from: b */
    public final ResourceCallback f20428b;

    /* renamed from: c */
    public final /* synthetic */ l90 f20429c;

    public /* synthetic */ j90(l90 l90Var, ResourceCallback resourceCallback, int i) {
        this.f20427a = i;
        this.f20429c = l90Var;
        this.f20428b = resourceCallback;
    }

    /* renamed from: a */
    private final void m5419a() {
        synchronized (this.f20428b.getLock()) {
            synchronized (this.f20429c) {
                try {
                    i12 i12Var = this.f20429c.f22392a;
                    ResourceCallback resourceCallback = this.f20428b;
                    i12Var.getClass();
                    if (((ArrayList) i12Var.f18255b).contains(new k90(resourceCallback, Executors.directExecutor()))) {
                        l90 l90Var = this.f20429c;
                        ResourceCallback resourceCallback2 = this.f20428b;
                        l90Var.getClass();
                        try {
                            resourceCallback2.onLoadFailed(l90Var.f22411t);
                        } catch (Throwable th) {
                            throw new C1875uk(th);
                        }
                    }
                    this.f20429c.m5900b();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f20427a) {
            case 0:
                m5419a();
                return;
            default:
                synchronized (this.f20428b.getLock()) {
                    synchronized (this.f20429c) {
                        try {
                            i12 i12Var = this.f20429c.f22392a;
                            ResourceCallback resourceCallback = this.f20428b;
                            i12Var.getClass();
                            if (((ArrayList) i12Var.f18255b).contains(new k90(resourceCallback, Executors.directExecutor()))) {
                                this.f20429c.f22413v.m6891a();
                                l90 l90Var = this.f20429c;
                                ResourceCallback resourceCallback2 = this.f20428b;
                                l90Var.getClass();
                                try {
                                    resourceCallback2.onResourceReady(l90Var.f22413v, l90Var.f22409r, l90Var.f22416y);
                                    this.f20429c.m5906h(this.f20428b);
                                } catch (Throwable th) {
                                    throw new C1875uk(th);
                                }
                            }
                            this.f20429c.m5900b();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                return;
        }
    }
}
