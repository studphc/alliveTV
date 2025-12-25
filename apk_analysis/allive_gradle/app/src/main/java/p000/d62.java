package p000;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.hisona.allive.PlayerActivity;

/* loaded from: classes2.dex */
public final class d62 extends CustomTarget {

    /* renamed from: d */
    public final /* synthetic */ int f16272d;

    /* renamed from: e */
    public final /* synthetic */ PlayerActivity f16273e;

    public /* synthetic */ d62(PlayerActivity playerActivity, int i) {
        this.f16272d = i;
        this.f16273e = playerActivity;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable) {
        int i = this.f16272d;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object obj, Transition transition) {
        switch (this.f16272d) {
            case 0:
                this.f16273e.f15875D.setDefaultArtwork((Drawable) obj);
                return;
            case 1:
                this.f16273e.f15875D.setDefaultArtwork((Drawable) obj);
                return;
            default:
                this.f16273e.f15876E.setDefaultArtwork((Drawable) obj);
                return;
        }
    }

    /* renamed from: a */
    private final void m4533a(Drawable drawable) {
    }

    /* renamed from: b */
    private final void m4534b(Drawable drawable) {
    }

    /* renamed from: c */
    private final void m4535c(Drawable drawable) {
    }
}
