package p000;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes.dex */
public final class xw0 extends CustomTarget {

    /* renamed from: d */
    public final Handler f28749d;

    /* renamed from: e */
    public final int f28750e;

    /* renamed from: f */
    public final long f28751f;

    /* renamed from: g */
    public Bitmap f28752g;

    public xw0(Handler handler, int i, long j) {
        this.f28749d = handler;
        this.f28750e = i;
        this.f28751f = j;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable) {
        this.f28752g = null;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object obj, Transition transition) {
        this.f28752g = (Bitmap) obj;
        Handler handler = this.f28749d;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.f28751f);
    }
}
