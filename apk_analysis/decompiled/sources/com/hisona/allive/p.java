package com.hisona.allive;

import com.hisona.allive.TvingLoginDialogFragment;
import com.hisona.allive.Utils;

/* loaded from: classes2.dex */
public final class p implements TvingLoginDialogFragment.OnResultListener {
    public final /* synthetic */ MainFragment a;

    public p(MainFragment mainFragment) {
        this.a = mainFragment;
    }

    @Override // com.hisona.allive.TvingLoginDialogFragment.OnResultListener
    public final void onResult(String str) {
        TvingRowSupportFragment.setAuthKey(str);
        this.a.startServiceIntent(Utils.SiteType.Tving);
    }
}
