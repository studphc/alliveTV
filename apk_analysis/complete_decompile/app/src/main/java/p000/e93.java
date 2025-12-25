package p000;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zzc;

/* loaded from: classes.dex */
public abstract class e93 extends zzc {

    /* renamed from: d */
    public final /* synthetic */ BaseGmsClient f16726d;
    public final int zza;

    @Nullable
    public final Bundle zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e93(BaseGmsClient baseGmsClient, int i, Bundle bundle) {
        super(baseGmsClient, Boolean.TRUE);
        this.f16726d = baseGmsClient;
        this.zza = i;
        this.zzb = bundle;
    }

    @Override // com.google.android.gms.common.internal.zzc
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        int i = this.zza;
        BaseGmsClient baseGmsClient = this.f16726d;
        PendingIntent pendingIntent = null;
        if (i == 0) {
            if (!zzd()) {
                baseGmsClient.m3139d(null, 1);
                zzb(new ConnectionResult(8, null));
                return;
            }
            return;
        }
        baseGmsClient.m3139d(null, 1);
        Bundle bundle = this.zzb;
        if (bundle != null) {
            pendingIntent = (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT);
        }
        zzb(new ConnectionResult(this.zza, pendingIntent));
    }

    public abstract void zzb(ConnectionResult connectionResult);

    public abstract boolean zzd();

    @Override // com.google.android.gms.common.internal.zzc
    public final void zzc() {
    }
}
