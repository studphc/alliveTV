package p000;

import com.bumptech.glide.util.Util;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class d40 implements Executor {

    /* renamed from: b */
    public static final d40 f16238b = new d40(0);

    /* renamed from: a */
    public final /* synthetic */ int f16239a;

    public /* synthetic */ d40(int i) {
        this.f16239a = i;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f16239a) {
            case 0:
                runnable.run();
                return;
            case 1:
                new Thread(runnable).start();
                return;
            case 2:
                Util.postOnUiThread(runnable);
                return;
            case 3:
                runnable.run();
                return;
            default:
                runnable.run();
                return;
        }
    }
}
