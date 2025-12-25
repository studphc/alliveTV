package p000;

import android.content.Intent;
import android.content.IntentSender;
import androidx.activity.result.contract.ActivityResultContracts;

/* renamed from: qt */
/* loaded from: classes.dex */
public final class RunnableC1736qt implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f25740a;

    /* renamed from: b */
    public final /* synthetic */ IntentSender.SendIntentException f25741b;

    /* renamed from: c */
    public final /* synthetic */ C1773rt f25742c;

    public RunnableC1736qt(C1773rt c1773rt, int i, IntentSender.SendIntentException sendIntentException) {
        this.f25742c = c1773rt;
        this.f25740a = i;
        this.f25741b = sendIntentException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f25742c.dispatchResult(this.f25740a, 0, new Intent().setAction(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST).putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_SEND_INTENT_EXCEPTION, this.f25741b));
    }
}
