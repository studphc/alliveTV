package androidx.fragment.app;

import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentManager;
import p000.mt2;

/* renamed from: androidx.fragment.app.n */
/* loaded from: classes.dex */
public final class C0259n implements ActivityResultCallback {

    /* renamed from: a */
    public final /* synthetic */ FragmentManager f4685a;

    public C0259n(FragmentManager fragmentManager) {
        this.f4685a = fragmentManager;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        ActivityResult activityResult = (ActivityResult) obj;
        FragmentManager fragmentManager = this.f4685a;
        FragmentManager.LaunchedFragmentInfo launchedFragmentInfo = (FragmentManager.LaunchedFragmentInfo) fragmentManager.f4503H.pollLast();
        if (launchedFragmentInfo == null) {
            Log.w(FragmentManager.TAG, "No Activities were started for result for " + this);
            return;
        }
        mt2 mt2Var = fragmentManager.f4517c;
        String str = launchedFragmentInfo.f4545a;
        Fragment m6251c = mt2Var.m6251c(str);
        if (m6251c == null) {
            Log.w(FragmentManager.TAG, "Activity result delivered for unknown Fragment " + str);
        } else {
            m6251c.onActivityResult(launchedFragmentInfo.f4546b, activityResult.getResultCode(), activityResult.getData());
        }
    }
}
