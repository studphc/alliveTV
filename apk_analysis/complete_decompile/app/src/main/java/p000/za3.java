package p000;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.AbstractRunnableC0781a;
import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzdj;
import com.google.android.gms.internal.measurement.zzff;

/* loaded from: classes.dex */
public final class za3 extends AbstractRunnableC0781a {

    /* renamed from: e */
    public final /* synthetic */ int f29300e;

    /* renamed from: f */
    public final /* synthetic */ Object f29301f;

    /* renamed from: g */
    public final /* synthetic */ Object f29302g;

    /* renamed from: h */
    public final /* synthetic */ Object f29303h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ za3(zzff zzffVar, Object obj, zzcs zzcsVar, int i) {
        super(zzffVar, true);
        this.f29300e = i;
        this.f29302g = obj;
        this.f29303h = zzcsVar;
        this.f29301f = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: a */
    public final void mo46a() {
        Bundle bundle;
        switch (this.f29300e) {
            case 0:
                ((zzcv) Preconditions.checkNotNull(((zzff) this.f29301f).f13820g)).logHealthData(5, (String) this.f29302g, ObjectWrapper.wrap(this.f29303h), ObjectWrapper.wrap(null), ObjectWrapper.wrap(null));
                return;
            case 1:
                ((zzcv) Preconditions.checkNotNull(((zzff) this.f29301f).f13820g)).performAction((Bundle) this.f29302g, (zzcs) this.f29303h, this.f13747a);
                return;
            case 2:
                ((zzcv) Preconditions.checkNotNull(((zzff) this.f29301f).f13820g)).getMaxUserProperties((String) this.f29302g, (zzcs) this.f29303h);
                return;
            case 3:
                Bundle bundle2 = (Bundle) this.f29302g;
                if (bundle2 != null) {
                    bundle = new Bundle();
                    if (bundle2.containsKey("com.google.app_measurement.screen_service")) {
                        Object obj = bundle2.get("com.google.app_measurement.screen_service");
                        if (obj instanceof Bundle) {
                            bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                        }
                    }
                } else {
                    bundle = null;
                }
                zzcv zzcvVar = (zzcv) Preconditions.checkNotNull(((kb3) this.f29301f).f20816a.f13820g);
                Activity activity = (Activity) this.f29303h;
                zzcvVar.onActivityCreatedByScionActivityInfo(zzdj.zza(activity), bundle, this.f13748b);
                return;
            default:
                ((zzcv) Preconditions.checkNotNull(((kb3) this.f29301f).f20816a.f13820g)).onActivitySaveInstanceStateByScionActivityInfo(zzdj.zza((Activity) this.f29302g), (zzcs) this.f29303h, this.f13748b);
                return;
        }
    }

    @Override // com.google.android.gms.internal.measurement.AbstractRunnableC0781a
    /* renamed from: b */
    public void mo47b() {
        switch (this.f29300e) {
            case 1:
                ((zzcs) this.f29303h).zze(null);
                return;
            case 2:
                ((zzcs) this.f29303h).zze(null);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public za3(zzff zzffVar, String str, Object obj) {
        super(zzffVar, false);
        this.f29300e = 0;
        this.f29302g = str;
        this.f29303h = obj;
        this.f29301f = zzffVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public za3(kb3 kb3Var, Activity activity, zzcs zzcsVar) {
        super(kb3Var.f20816a, true);
        this.f29300e = 4;
        this.f29302g = activity;
        this.f29303h = zzcsVar;
        this.f29301f = kb3Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public za3(kb3 kb3Var, Bundle bundle, Activity activity) {
        super(kb3Var.f20816a, true);
        this.f29300e = 3;
        this.f29302g = bundle;
        this.f29303h = activity;
        this.f29301f = kb3Var;
    }
}
