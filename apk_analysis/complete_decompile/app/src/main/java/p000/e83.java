package p000;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.zag;

/* loaded from: classes.dex */
public final class e83 extends zag {

    /* renamed from: a */
    public final /* synthetic */ int f16710a;

    /* renamed from: b */
    public final /* synthetic */ Intent f16711b;

    /* renamed from: c */
    public final /* synthetic */ int f16712c;

    /* renamed from: d */
    public final /* synthetic */ Object f16713d;

    public /* synthetic */ e83(Intent intent, Object obj, int i, int i2) {
        this.f16710a = i2;
        this.f16711b = intent;
        this.f16713d = obj;
        this.f16712c = i;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        switch (this.f16710a) {
            case 0:
                Intent intent = this.f16711b;
                if (intent != null) {
                    ((Activity) this.f16713d).startActivityForResult(intent, this.f16712c);
                    return;
                }
                return;
            default:
                Intent intent2 = this.f16711b;
                if (intent2 != null) {
                    ((Fragment) this.f16713d).startActivityForResult(intent2, this.f16712c);
                    return;
                }
                return;
        }
    }
}
