package p000;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;

/* renamed from: cu */
/* loaded from: classes2.dex */
public final class C1098cu extends o63 {

    /* renamed from: u */
    public final /* synthetic */ int f16110u;

    /* renamed from: v */
    public final Object f16111v;

    public /* synthetic */ C1098cu(int i, Object obj) {
        this.f16110u = i;
        this.f16111v = obj;
    }

    @Override // p000.o63
    /* renamed from: b */
    public final o63 mo4488b(Serializable serializable) {
        switch (this.f16110u) {
            case 0:
                ((PrintStream) this.f16111v).print(serializable);
                return this;
            default:
                ((PrintWriter) this.f16111v).print(serializable);
                return this;
        }
    }
}
