package p000;

import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public final class s73 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ t73 f26311a;

    public s73(t73 t73Var) {
        this.f26311a = t73Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Api.Client client = this.f26311a.f26714a.f13259b;
        client.disconnect(client.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
