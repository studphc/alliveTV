package p000;

import android.content.Intent;
import com.hisona.allive.RxJobIntentService;

/* loaded from: classes2.dex */
public final class kd2 implements ld2 {

    /* renamed from: a */
    public final Intent f20828a;

    /* renamed from: b */
    public final int f20829b;

    /* renamed from: c */
    public final /* synthetic */ RxJobIntentService f20830c;

    public kd2(RxJobIntentService rxJobIntentService, Intent intent, int i) {
        this.f20830c = rxJobIntentService;
        this.f20828a = intent;
        this.f20829b = i;
    }

    @Override // p000.ld2
    public final void complete() {
        this.f20830c.stopSelf(this.f20829b);
    }

    @Override // p000.ld2
    public final Intent getIntent() {
        return this.f20828a;
    }
}
