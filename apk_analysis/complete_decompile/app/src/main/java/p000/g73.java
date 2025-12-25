package p000;

import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class g73 extends zac {

    /* renamed from: a */
    public final WeakReference f17573a;

    public g73(zaaw zaawVar) {
        this.f17573a = new WeakReference(zaawVar);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    public final void zab(zak zakVar) {
        zaaw zaawVar = (zaaw) this.f17573a.get();
        if (zaawVar == null) {
            return;
        }
        c73 c73Var = new c73(zaawVar, zaawVar, zakVar);
        p73 p73Var = zaawVar.f13195a.f13246e;
        p73Var.sendMessage(p73Var.obtainMessage(1, c73Var));
    }
}
