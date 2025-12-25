package p000;

import android.hardware.display.DisplayManager;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class i23 implements h23, DisplayManager.DisplayListener {

    /* renamed from: a */
    public final DisplayManager f18276a;

    /* renamed from: b */
    public C1294i5 f18277b;

    public i23(DisplayManager displayManager) {
        this.f18276a = displayManager;
    }

    @Override // p000.h23
    /* renamed from: b */
    public final void mo93b(C1294i5 c1294i5) {
        this.f18277b = c1294i5;
        DisplayManager displayManager = this.f18276a;
        displayManager.registerDisplayListener(this, Util.createHandlerForCurrentLooper());
        c1294i5.onDefaultDisplayChanged(displayManager.getDisplay(0));
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
        C1294i5 c1294i5 = this.f18277b;
        if (c1294i5 != null && i == 0) {
            c1294i5.onDefaultDisplayChanged(this.f18276a.getDisplay(0));
        }
    }

    @Override // p000.h23
    public final void unregister() {
        this.f18276a.unregisterDisplayListener(this);
        this.f18277b = null;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
    }
}
