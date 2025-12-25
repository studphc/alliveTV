package p000;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.widget.TextView;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* renamed from: z9 */
/* loaded from: classes.dex */
public final class RunnableC2049z9 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f29287a;

    /* renamed from: b */
    public final int f29288b;

    /* renamed from: c */
    public final Object f29289c;

    /* renamed from: d */
    public final /* synthetic */ Object f29290d;

    public /* synthetic */ RunnableC2049z9(Object obj, Object obj2, int i, int i2) {
        this.f29287a = i2;
        this.f29289c = obj;
        this.f29290d = obj2;
        this.f29288b = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f29287a) {
            case 0:
                ((TextView) this.f29289c).setTypeface((Typeface) this.f29290d, this.f29288b);
                return;
            case 1:
                iw0 iw0Var = (iw0) this.f29289c;
                ImmutableList immutableList = (ImmutableList) this.f29290d;
                int i = this.f29288b;
                ListenableFuture listenableFuture = iw0Var.f20288d[i];
                Objects.requireNonNull(listenableFuture);
                iw0Var.f20288d[i] = null;
                for (int i2 = iw0Var.f20289e; i2 < immutableList.size(); i2++) {
                    if (((AbstractFuture) immutableList.get(i2)).setFuture(listenableFuture)) {
                        iw0Var.m5367a();
                        iw0Var.f20289e = i2 + 1;
                        return;
                    }
                }
                iw0Var.f20289e = immutableList.size();
                return;
            default:
                ((ResultReceiver) this.f29290d).onReceiveResult(this.f29288b, (Bundle) this.f29289c);
                return;
        }
    }

    public RunnableC2049z9(ResultReceiver resultReceiver, int i, Bundle bundle) {
        this.f29287a = 2;
        this.f29290d = resultReceiver;
        this.f29288b = i;
        this.f29289c = bundle;
    }
}
