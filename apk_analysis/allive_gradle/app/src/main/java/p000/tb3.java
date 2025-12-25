package p000;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzpv;

/* loaded from: classes.dex */
public final class tb3 extends BroadcastReceiver {

    /* renamed from: a */
    public final zzpv f26768a;

    /* renamed from: b */
    public boolean f26769b;

    /* renamed from: c */
    public boolean f26770c;

    public tb3(zzpv zzpvVar) {
        Preconditions.checkNotNull(zzpvVar);
        this.f26768a = zzpvVar;
    }

    /* renamed from: a */
    public final void m7476a() {
        zzpv zzpvVar = this.f26768a;
        zzpvVar.m3644d();
        zzpvVar.zzaX().zzg();
        zzpvVar.zzaX().zzg();
        if (!this.f26769b) {
            return;
        }
        zzpvVar.zzaW().zzj().zza("Unregistering connectivity change receiver");
        this.f26769b = false;
        this.f26770c = false;
        try {
            zzpvVar.zzaT().unregisterReceiver(this);
        } catch (IllegalArgumentException e) {
            zzpvVar.zzaW().zze().zzb("Failed to unregister the network broadcast receiver", e);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzpv zzpvVar = this.f26768a;
        zzpvVar.m3644d();
        String action = intent.getAction();
        zzpvVar.zzaW().zzj().zzb("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzd = zzpvVar.zzp().zzd();
            if (this.f26770c != zzd) {
                this.f26770c = zzd;
                zzpvVar.zzaX().zzq(new sn1(this, zzd));
                return;
            }
            return;
        }
        zzpvVar.zzaW().zzk().zzb("NetworkBroadcastReceiver received unknown action", action);
    }
}
