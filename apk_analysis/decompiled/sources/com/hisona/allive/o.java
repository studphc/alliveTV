package com.hisona.allive;

import android.view.View;
import com.hisona.allive.ProfileSelectFragment;
import com.hisona.allive.Utils;
import com.orhanobut.hawk.Hawk;

/* loaded from: classes2.dex */
public final class o implements ProfileSelectFragment.OnListItemClickListener {
    public final /* synthetic */ ProfileSelectFragment a;
    public final /* synthetic */ MainFragment b;

    public o(MainFragment mainFragment, ProfileSelectFragment profileSelectFragment) {
        this.b = mainFragment;
        this.a = profileSelectFragment;
    }

    @Override // com.hisona.allive.ProfileSelectFragment.OnListItemClickListener
    public final void onItemClick(View view, int i) {
        this.a.dismiss();
        MainFragment mainFragment = this.b;
        mainFragment.C1.mWavveSettings.mProfile = Integer.toString(i);
        if (!Hawk.put(mainFragment.z(R.string.SETTINGSEX_STR), mainFragment.y1.toJson(mainFragment.C1))) {
            Utils.showToast(mainFragment.getContext(), R.string.settingssave_error);
        }
        mainFragment.startServiceIntent(Utils.SiteType.Wavve);
    }
}
