package com.hisona.allive;

import android.view.View;
import com.hisona.allive.ProfileSelectFragment;
import com.hisona.allive.Utils;
import com.orhanobut.hawk.Hawk;

/* renamed from: com.hisona.allive.o */
/* loaded from: classes2.dex */
public final class C1082o implements ProfileSelectFragment.OnListItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ ProfileSelectFragment f16001a;

    /* renamed from: b */
    public final /* synthetic */ MainFragment f16002b;

    public C1082o(MainFragment mainFragment, ProfileSelectFragment profileSelectFragment) {
        this.f16002b = mainFragment;
        this.f16001a = profileSelectFragment;
    }

    @Override // com.hisona.allive.ProfileSelectFragment.OnListItemClickListener
    public final void onItemClick(View view, int i) {
        this.f16001a.dismiss();
        MainFragment mainFragment = this.f16002b;
        mainFragment.f15861C1.mWavveSettings.mProfile = Integer.toString(i);
        if (!Hawk.put(mainFragment.m4456z(R.string.SETTINGSEX_STR), mainFragment.f15867y1.toJson(mainFragment.f15861C1))) {
            Utils.showToast(mainFragment.getContext(), R.string.settingssave_error);
        }
        mainFragment.startServiceIntent(Utils.SiteType.Wavve);
    }
}
