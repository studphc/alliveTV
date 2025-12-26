package p000;

import androidx.core.widget.ContentLoadingProgressBar;

/* renamed from: wv */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC1960wv implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f28342a;

    /* renamed from: b */
    public final /* synthetic */ ContentLoadingProgressBar f28343b;

    public /* synthetic */ RunnableC1960wv(ContentLoadingProgressBar contentLoadingProgressBar, int i) {
        this.f28342a = i;
        this.f28343b = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f28342a) {
            case 0:
                ContentLoadingProgressBar contentLoadingProgressBar = this.f28343b;
                contentLoadingProgressBar.f4044b = false;
                contentLoadingProgressBar.f4043a = -1L;
                contentLoadingProgressBar.setVisibility(8);
                return;
            case 1:
                ContentLoadingProgressBar contentLoadingProgressBar2 = this.f28343b;
                contentLoadingProgressBar2.f4045c = false;
                if (!contentLoadingProgressBar2.f4046d) {
                    contentLoadingProgressBar2.f4043a = System.currentTimeMillis();
                    contentLoadingProgressBar2.setVisibility(0);
                    return;
                }
                return;
            case 2:
                ContentLoadingProgressBar contentLoadingProgressBar3 = this.f28343b;
                contentLoadingProgressBar3.f4043a = -1L;
                contentLoadingProgressBar3.f4046d = false;
                contentLoadingProgressBar3.removeCallbacks(contentLoadingProgressBar3.f4047e);
                contentLoadingProgressBar3.f4044b = false;
                if (!contentLoadingProgressBar3.f4045c) {
                    contentLoadingProgressBar3.postDelayed(contentLoadingProgressBar3.f4048f, 500L);
                    contentLoadingProgressBar3.f4045c = true;
                    return;
                }
                return;
            default:
                ContentLoadingProgressBar contentLoadingProgressBar4 = this.f28343b;
                contentLoadingProgressBar4.f4046d = true;
                contentLoadingProgressBar4.removeCallbacks(contentLoadingProgressBar4.f4048f);
                contentLoadingProgressBar4.f4045c = false;
                long currentTimeMillis = System.currentTimeMillis();
                long j = contentLoadingProgressBar4.f4043a;
                long j2 = currentTimeMillis - j;
                if (j2 < 500 && j != -1) {
                    if (!contentLoadingProgressBar4.f4044b) {
                        contentLoadingProgressBar4.postDelayed(contentLoadingProgressBar4.f4047e, 500 - j2);
                        contentLoadingProgressBar4.f4044b = true;
                        return;
                    }
                    return;
                }
                contentLoadingProgressBar4.setVisibility(8);
                return;
        }
    }
}
