package p000;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzdh;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.measurement.internal.zzig;

/* loaded from: classes.dex */
public final class ua3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ String f27176e;

    /* renamed from: f */
    public final /* synthetic */ String f27177f;

    /* renamed from: g */
    public final /* synthetic */ Context f27178g;

    /* renamed from: h */
    public final /* synthetic */ Bundle f27179h;

    /* renamed from: i */
    public final /* synthetic */ zzff f27180i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ua3(zzff zzffVar, String str, String str2, Context context, Bundle bundle) {
        super(zzffVar, true);
        this.f27176e = str;
        this.f27177f = str2;
        this.f27178g = context;
        this.f27179h = bundle;
        this.f27180i = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        boolean z;
        String str;
        String str2;
        String str3;
        boolean z2;
        try {
            zzff zzffVar = this.f27180i;
            String str4 = this.f27176e;
            String str5 = this.f27177f;
            zzffVar.getClass();
            if (str5 != null && str4 != null && !zzffVar.zzT()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str2 = str4;
                str3 = str5;
                str = zzffVar.f13814a;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            Context context = this.f27178g;
            Preconditions.checkNotNull(context);
            zzffVar.f13820g = zzffVar.zzf(context, true);
            if (zzffVar.f13820g == null) {
                Log.w(zzffVar.f13814a, "Failed to connect to measurement client.");
                return;
            }
            int localVersion = DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
            int remoteVersion = DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
            int max = Math.max(localVersion, remoteVersion);
            if (remoteVersion < localVersion) {
                z2 = true;
            } else {
                z2 = false;
            }
            ((zzcv) Preconditions.checkNotNull(zzffVar.f13820g)).initialize(ObjectWrapper.wrap(context), new zzdh(119002L, max, z2, str, str2, str3, this.f27179h, zzig.zza(context)), this.f13747a);
        } catch (Exception e) {
            this.f27180i.m3293a(e, true, false);
        }
    }
}
