package p000;

import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.internal.BaseGmsClient;

/* loaded from: classes.dex */
public final class t73 implements BaseGmsClient.SignOutCallbacks {

    /* renamed from: a */
    public final /* synthetic */ zabq f26714a;

    public t73(zabq zabqVar) {
        this.f26714a = zabqVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void onSignOutComplete() {
        this.f26714a.f13270m.f13119n.post(new s73(this));
    }
}
