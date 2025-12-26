package p000;

import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzlw;
import com.google.android.gms.measurement.internal.zzpv;

/* loaded from: classes.dex */
public final class pc3 extends w93 {

    /* renamed from: e */
    public final /* synthetic */ int f25118e;

    /* renamed from: f */
    public final /* synthetic */ hc3 f25119f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ pc3(hc3 hc3Var, hc3 hc3Var2, int i) {
        super(hc3Var2);
        this.f25118e = i;
        this.f25119f = hc3Var;
    }

    @Override // p000.w93
    /* renamed from: b */
    public final void mo3493b() {
        BroadcastOptions makeBasic;
        BroadcastOptions shareIdentityEnabled;
        Bundle bundle;
        switch (this.f25118e) {
            case 0:
                ((zzlw) this.f25119f).zzU();
                return;
            case 1:
                ((zzlw) this.f25119f).zzN();
                return;
            default:
                zzpv zzpvVar = (zzpv) this.f25119f;
                zzpvVar.zzaX().zzg();
                String str = (String) zzpvVar.f14385q.pollFirst();
                if (str != null) {
                    zzpvVar.f14367I = zzpvVar.zzaU().elapsedRealtime();
                    zzpvVar.zzaW().zzj().zzb("Sending trigger URI notification to app", str);
                    Intent intent = new Intent();
                    intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                    intent.setPackage(str);
                    Context zzaT = zzpvVar.zzaT();
                    if (Build.VERSION.SDK_INT >= 34) {
                        makeBasic = BroadcastOptions.makeBasic();
                        shareIdentityEnabled = makeBasic.setShareIdentityEnabled(true);
                        bundle = shareIdentityEnabled.toBundle();
                        zzaT.sendBroadcast(intent, null, bundle);
                    } else {
                        zzaT.sendBroadcast(intent);
                    }
                }
                zzpvVar.m3660w();
                return;
        }
    }
}
