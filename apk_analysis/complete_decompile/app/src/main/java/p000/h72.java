package p000;

import android.os.Handler;
import android.os.Message;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.request.target.PreloadTarget;

/* loaded from: classes.dex */
public final class h72 implements Handler.Callback {

    /* renamed from: a */
    public final /* synthetic */ int f17967a;

    public /* synthetic */ h72(int i) {
        this.f17967a = i;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f17967a) {
            case 0:
                if (message.what == 1) {
                    PreloadTarget preloadTarget = (PreloadTarget) message.obj;
                    preloadTarget.f9123d.clear(preloadTarget);
                    return true;
                }
                return false;
            default:
                if (message.what == 1) {
                    ((Resource) message.obj).recycle();
                    return true;
                }
                return false;
        }
    }
}
