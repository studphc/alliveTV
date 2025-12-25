package p000;

import com.google.android.gms.internal.measurement.zzcy;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* loaded from: classes.dex */
public final class ac3 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f123a;

    /* renamed from: b */
    public final /* synthetic */ zzcy f124b;

    /* renamed from: c */
    public final /* synthetic */ AppMeasurementDynamiteService f125c;

    public /* synthetic */ ac3(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcy zzcyVar, int i) {
        this.f123a = i;
        this.f124b = zzcyVar;
        this.f125c = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f123a) {
            case 0:
                this.f125c.f13971a.zzu().zzD(this.f124b);
                return;
            default:
                AppMeasurementDynamiteService appMeasurementDynamiteService = this.f125c;
                appMeasurementDynamiteService.f13971a.zzw().zzT(this.f124b, appMeasurementDynamiteService.f13971a.zzI());
                return;
        }
    }
}
