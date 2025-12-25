package p000;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.zag;

/* loaded from: classes.dex */
public final class j83 extends zag {

    /* renamed from: a */
    public final /* synthetic */ Intent f20424a;

    /* renamed from: b */
    public final /* synthetic */ LifecycleFragment f20425b;

    public j83(Intent intent, LifecycleFragment lifecycleFragment) {
        this.f20424a = intent;
        this.f20425b = lifecycleFragment;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.f20424a;
        if (intent != null) {
            this.f20425b.startActivityForResult(intent, 2);
        }
    }
}
