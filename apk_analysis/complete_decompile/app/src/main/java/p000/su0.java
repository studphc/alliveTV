package p000;

import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window$OnFrameMetricsAvailableListener;

/* loaded from: classes.dex */
public final class su0 implements Window$OnFrameMetricsAvailableListener {

    /* renamed from: a */
    public final /* synthetic */ tu0 f26557a;

    public su0(tu0 tu0Var) {
        this.f26557a = tu0Var;
    }

    public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
        tu0 tu0Var = this.f26557a;
        if ((tu0Var.f26961f & 1) != 0) {
            tu0.m7512o(tu0Var.f26962g[0], frameMetrics.getMetric(8));
        }
        tu0 tu0Var2 = this.f26557a;
        if ((tu0Var2.f26961f & 2) != 0) {
            tu0.m7512o(tu0Var2.f26962g[1], frameMetrics.getMetric(1));
        }
        tu0 tu0Var3 = this.f26557a;
        if ((tu0Var3.f26961f & 4) != 0) {
            tu0.m7512o(tu0Var3.f26962g[2], frameMetrics.getMetric(3));
        }
        tu0 tu0Var4 = this.f26557a;
        if ((tu0Var4.f26961f & 8) != 0) {
            tu0.m7512o(tu0Var4.f26962g[3], frameMetrics.getMetric(4));
        }
        tu0 tu0Var5 = this.f26557a;
        if ((tu0Var5.f26961f & 16) != 0) {
            tu0.m7512o(tu0Var5.f26962g[4], frameMetrics.getMetric(5));
        }
        tu0 tu0Var6 = this.f26557a;
        if ((tu0Var6.f26961f & 64) != 0) {
            tu0.m7512o(tu0Var6.f26962g[6], frameMetrics.getMetric(7));
        }
        tu0 tu0Var7 = this.f26557a;
        if ((tu0Var7.f26961f & 32) != 0) {
            tu0.m7512o(tu0Var7.f26962g[5], frameMetrics.getMetric(6));
        }
        tu0 tu0Var8 = this.f26557a;
        if ((tu0Var8.f26961f & 128) != 0) {
            tu0.m7512o(tu0Var8.f26962g[7], frameMetrics.getMetric(0));
        }
        tu0 tu0Var9 = this.f26557a;
        if ((tu0Var9.f26961f & 256) != 0) {
            tu0.m7512o(tu0Var9.f26962g[8], frameMetrics.getMetric(2));
        }
    }
}
