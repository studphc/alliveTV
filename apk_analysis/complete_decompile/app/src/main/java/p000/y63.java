package p000;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zaad;

/* loaded from: classes.dex */
public final class y63 implements PendingResult.StatusListener {

    /* renamed from: a */
    public final /* synthetic */ BasePendingResult f28850a;

    /* renamed from: b */
    public final /* synthetic */ zaad f28851b;

    public y63(zaad zaadVar, BasePendingResult basePendingResult) {
        this.f28851b = zaadVar;
        this.f28850a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        this.f28851b.f13188a.remove(this.f28850a);
    }
}
