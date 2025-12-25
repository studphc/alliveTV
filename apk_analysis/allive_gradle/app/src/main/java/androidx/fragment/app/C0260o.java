package androidx.fragment.app;

import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentManager;
import p000.mt2;

/* renamed from: androidx.fragment.app.o */
/* loaded from: classes.dex */
public final class C0260o implements ActivityResultCallback {

    /* renamed from: a */
    public final /* synthetic */ FragmentManager f4686a;

    public C0260o(FragmentManager fragmentManager) {
        this.f4686a = fragmentManager;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        ActivityResult activityResult = (ActivityResult) obj;
        FragmentManager fragmentManager = this.f4686a;
        FragmentManager.LaunchedFragmentInfo launchedFragmentInfo = (FragmentManager.LaunchedFragmentInfo) fragmentManager.f4503H.pollFirst();
        if (launchedFragmentInfo == null) {
            Log.w(FragmentManager.TAG, "No IntentSenders were started for " + this);
            return;
        }
        mt2 mt2Var = fragmentManager.f4517c;
        String str = launchedFragmentInfo.f4545a;
        Fragment m6251c = mt2Var.m6251c(str);
        if (m6251c == null) {
            Log.w(FragmentManager.TAG, "Intent Sender result delivered for unknown Fragment " + str);
        } else {
            m6251c.onActivityResult(launchedFragmentInfo.f4546b, activityResult.getResultCode(), activityResult.getData());
        }
    }
}
