package com.hisona.allive;

import com.hisona.allive.TvingLoginDialogFragment;
import com.hisona.allive.Utils;

/* renamed from: com.hisona.allive.p */
/* loaded from: classes2.dex */
public final class C1083p implements TvingLoginDialogFragment.OnResultListener {

    /* renamed from: a */
    public final /* synthetic */ MainFragment f16003a;

    public C1083p(MainFragment mainFragment) {
        this.f16003a = mainFragment;
    }

    @Override // com.hisona.allive.TvingLoginDialogFragment.OnResultListener
    public final void onResult(String str) {
        TvingRowSupportFragment.setAuthKey(str);
        this.f16003a.startServiceIntent(Utils.SiteType.Tving);
    }
}
