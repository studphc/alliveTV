package androidx.leanback.app;

import android.app.Fragment;
import androidx.annotation.RestrictTo;
import p000.C1351je;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class BackgroundFragment extends Fragment {

    /* renamed from: a */
    public BackgroundManager f4722a;

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BackgroundManager backgroundManager = this.f4722a;
        if (backgroundManager != null) {
            backgroundManager.release();
            backgroundManager.f4725c = null;
            backgroundManager.f4734l = false;
            C1351je c1351je = backgroundManager.f4726d;
            if (c1351je != null) {
                int i = c1351je.f20479c;
                if (i > 0) {
                    int i2 = i - 1;
                    c1351je.f20479c = i2;
                    if (i2 == 0) {
                        c1351je.f20477a = 0;
                        c1351je.f20478b = null;
                    }
                    backgroundManager.f4726d = null;
                    return;
                }
                throw new IllegalStateException("Can't unref, count " + c1351je.f20479c);
            }
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        BackgroundManager backgroundManager = this.f4722a;
        if (backgroundManager != null) {
            backgroundManager.m1256c();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        BackgroundManager backgroundManager = this.f4722a;
        if (backgroundManager != null) {
            backgroundManager.m1258f();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        BackgroundManager backgroundManager = this.f4722a;
        if (backgroundManager != null && backgroundManager.isAutoReleaseOnStop()) {
            backgroundManager.release();
        }
        super.onStop();
    }
}
