package p000;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zabf;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;

/* loaded from: classes.dex */
public final class c73 extends r73 {

    /* renamed from: b */
    public final /* synthetic */ int f8282b = 1;

    /* renamed from: c */
    public final /* synthetic */ Object f8283c;

    /* renamed from: d */
    public final /* synthetic */ Object f8284d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c73(zaaw zaawVar, zaaw zaawVar2, zak zakVar) {
        super(zaawVar);
        this.f8283c = zaawVar2;
        this.f8284d = zakVar;
    }

    @Override // p000.r73
    /* renamed from: a */
    public final void mo33a() {
        switch (this.f8282b) {
            case 0:
                ((e73) this.f8284d).f16704c.m3101d((ConnectionResult) this.f8283c);
                return;
            default:
                zaaw zaawVar = (zaaw) this.f8283c;
                if (zaawVar.m3104g(0)) {
                    zak zakVar = (zak) this.f8284d;
                    ConnectionResult zaa = zakVar.zaa();
                    if (zaa.isSuccess()) {
                        zav zavVar = (zav) Preconditions.checkNotNull(zakVar.zab());
                        ConnectionResult zaa2 = zavVar.zaa();
                        if (!zaa2.isSuccess()) {
                            String valueOf = String.valueOf(zaa2);
                            Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
                            zaawVar.m3101d(zaa2);
                            return;
                        }
                        zaawVar.f13208n = true;
                        zaawVar.f13209o = (IAccountAccessor) Preconditions.checkNotNull(zavVar.zab());
                        zaawVar.f13210p = zavVar.zac();
                        zaawVar.f13211q = zavVar.zad();
                        zaawVar.m3103f();
                        return;
                    }
                    if (zaawVar.f13206l && !zaa.hasResolution()) {
                        zaawVar.m3098a();
                        zaawVar.m3103f();
                        return;
                    } else {
                        zaawVar.m3101d(zaa);
                        return;
                    }
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c73(e73 e73Var, zabf zabfVar, ConnectionResult connectionResult) {
        super(zabfVar);
        this.f8284d = e73Var;
        this.f8283c = connectionResult;
    }
}
