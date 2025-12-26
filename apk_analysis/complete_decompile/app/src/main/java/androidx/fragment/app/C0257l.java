package androidx.fragment.app;

import android.util.Log;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Map;
import p000.mt2;

/* renamed from: androidx.fragment.app.l */
/* loaded from: classes.dex */
public final class C0257l implements ActivityResultCallback {

    /* renamed from: a */
    public final /* synthetic */ FragmentManager f4683a;

    public C0257l(FragmentManager fragmentManager) {
        this.f4683a = fragmentManager;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        int i;
        Map map = (Map) obj;
        String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        ArrayList arrayList = new ArrayList(map.values());
        int[] iArr = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((Boolean) arrayList.get(i2)).booleanValue()) {
                i = 0;
            } else {
                i = -1;
            }
            iArr[i2] = i;
        }
        FragmentManager fragmentManager = this.f4683a;
        FragmentManager.LaunchedFragmentInfo launchedFragmentInfo = (FragmentManager.LaunchedFragmentInfo) fragmentManager.f4503H.pollFirst();
        if (launchedFragmentInfo == null) {
            Log.w(FragmentManager.TAG, "No permissions were requested for " + this);
            return;
        }
        mt2 mt2Var = fragmentManager.f4517c;
        String str = launchedFragmentInfo.f4545a;
        Fragment m6251c = mt2Var.m6251c(str);
        if (m6251c == null) {
            Log.w(FragmentManager.TAG, "Permission request result delivered for unknown Fragment " + str);
            return;
        }
        m6251c.onRequestPermissionsResult(launchedFragmentInfo.f4546b, strArr, iArr);
    }
}
