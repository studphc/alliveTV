package com.hisona.allive;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentManager;
import com.hisona.allive.SettingsData;
import com.hisona.allive.Utils;
import com.orhanobut.hawk.Hawk;

/* renamed from: com.hisona.allive.n */
/* loaded from: classes2.dex */
public final class C1081n implements ActivityResultCallback {

    /* renamed from: a */
    public final /* synthetic */ MainFragment f16000a;

    public C1081n(MainFragment mainFragment) {
        this.f16000a = mainFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        Boolean bool;
        Boolean bool2;
        ActivityResult activityResult = (ActivityResult) obj;
        int resultCode = activityResult.getResultCode();
        Intent data = activityResult.getData();
        if (resultCode != 0) {
            int i = MainFragment.f15858H1;
            MainFragment mainFragment = this.f16000a;
            String stringExtra = data.getStringExtra(mainFragment.m4456z(R.string.SETTINGSDATA_STR));
            mainFragment.f15861C1 = (SettingsData) mainFragment.f15867y1.fromJson(stringExtra, SettingsData.class);
            if (resultCode == Utils.Code.WavveSave.ordinal()) {
                if (mainFragment.f15861C1.mWavveSettings.mEnable) {
                    bool2 = Boolean.TRUE;
                } else {
                    bool2 = Boolean.FALSE;
                }
                WavveRowSupportFragment.setEnable(bool2);
                WavveRowSupportFragment.setQualityType(mainFragment.f15861C1.mWavveSettings.mQualityType);
                if (mainFragment.f15861C1.mWavveSettings.mEnable) {
                    mainFragment.startServiceIntent(Utils.SiteType.Wavve);
                }
            } else if (resultCode == Utils.Code.TvingSave.ordinal()) {
                if (mainFragment.f15861C1.mTvingSettings.mEnable) {
                    bool = Boolean.TRUE;
                } else {
                    bool = Boolean.FALSE;
                }
                TvingRowSupportFragment.setEnable(bool);
                TvingRowSupportFragment.setQualityType(mainFragment.f15861C1.mTvingSettings.mQualityType);
                if (mainFragment.f15861C1.mTvingSettings.mEnable) {
                    FragmentManager supportFragmentManager = mainFragment.requireActivity().getSupportFragmentManager();
                    TvingLoginDialogFragment newInstance = TvingLoginDialogFragment.newInstance();
                    newInstance.setResultListener(new C1083p(mainFragment));
                    newInstance.show(supportFragmentManager, mainFragment.m4456z(R.string.TVINGLOGINDIALOG_STR));
                }
            } else if (resultCode == Utils.Code.EtcSave.ordinal()) {
                SettingsData.EtcSettingsData etcSettingsData = mainFragment.f15861C1.mEtcSettings;
                TvBaseRowsSupportFragment.mLongPress = etcSettingsData.mLongPress;
                TvBaseRowsSupportFragment.mVolumeControl = etcSettingsData.mVolumeControl;
            }
            if (!Hawk.put(mainFragment.m4456z(R.string.SETTINGSEX_STR), stringExtra)) {
                Utils.showToast(mainFragment.getContext(), R.string.settingssave_error);
            } else {
                mainFragment.createDefaultRows();
            }
        }
    }
}
