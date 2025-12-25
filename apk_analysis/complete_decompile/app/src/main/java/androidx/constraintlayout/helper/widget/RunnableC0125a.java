package androidx.constraintlayout.helper.widget;

import androidx.recyclerview.widget.RecyclerView;
import p000.RunnableC0597cl;

/* renamed from: androidx.constraintlayout.helper.widget.a */
/* loaded from: classes.dex */
public final class RunnableC0125a implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Carousel f2683a;

    public RunnableC0125a(Carousel carousel) {
        this.f2683a = carousel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Carousel carousel = this.f2683a;
        carousel.f2618i.setProgress(RecyclerView.f7068F0);
        carousel.m533h();
        carousel.f2614e.onNewItem(carousel.f2617h);
        float velocity = carousel.f2618i.getVelocity();
        if (carousel.f2628s == 2 && velocity > carousel.f2629t && carousel.f2617h < carousel.f2614e.count() - 1) {
            float f = velocity * carousel.f2625p;
            int i = carousel.f2617h;
            if (i == 0 && carousel.f2616g > i) {
                return;
            }
            if (i == carousel.f2614e.count() - 1 && carousel.f2616g < carousel.f2617h) {
                return;
            }
            carousel.f2618i.post(new RunnableC0597cl(this, f));
        }
    }
}
