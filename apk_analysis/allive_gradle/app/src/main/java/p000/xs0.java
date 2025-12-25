package p000;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import androidx.emoji2.text.C0243j;
import com.google.android.gms.internal.measurement.zzjh;
import com.google.android.gms.internal.measurement.zzjm;

/* loaded from: classes.dex */
public final class xs0 extends ContentObserver {

    /* renamed from: a */
    public final /* synthetic */ int f28723a;

    /* renamed from: b */
    public final /* synthetic */ Object f28724b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ xs0(int i, Object obj) {
        super(null);
        this.f28723a = i;
        this.f28724b = obj;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        switch (this.f28723a) {
            case 1:
                ((zzjh) this.f28724b).f13829a.set(true);
                return;
            case 2:
                ((zzjm) this.f28724b).zzf();
                return;
            default:
                super.onChange(z);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xs0(C0243j c0243j, Handler handler) {
        super(handler);
        this.f28723a = 0;
        this.f28724b = c0243j;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri) {
        switch (this.f28723a) {
            case 0:
                ((C0243j) this.f28724b).m1086b();
                return;
            default:
                super.onChange(z, uri);
                return;
        }
    }
}
