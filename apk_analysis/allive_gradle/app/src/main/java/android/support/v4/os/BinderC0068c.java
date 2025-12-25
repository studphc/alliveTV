package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.os.IResultReceiver;
import p000.RunnableC2049z9;

/* renamed from: android.support.v4.os.c */
/* loaded from: classes.dex */
public final class BinderC0068c extends IResultReceiver.Stub {

    /* renamed from: a */
    public final /* synthetic */ ResultReceiver f453a;

    public BinderC0068c(ResultReceiver resultReceiver) {
        this.f453a = resultReceiver;
    }

    @Override // android.support.v4.os.IResultReceiver
    public final void send(int i, Bundle bundle) {
        ResultReceiver resultReceiver = this.f453a;
        Handler handler = resultReceiver.f449b;
        if (handler != null) {
            handler.post(new RunnableC2049z9(resultReceiver, i, bundle));
        } else {
            resultReceiver.onReceiveResult(i, bundle);
        }
    }
}
