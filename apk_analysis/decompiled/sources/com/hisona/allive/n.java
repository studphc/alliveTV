package com.hisona.allive;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentManager;
import com.hisona.allive.SettingsData;
import com.hisona.allive.Utils;
import com.orhanobut.hawk.Hawk;

/* loaded from: classes2.dex */
public final class n implements ActivityResultCallback {
    public final /* synthetic */ MainFragment a;

    public n(MainFragment mainFragment) {
        this.a = mainFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        Boolean bool;
        Boolean bool2;
        ActivityResult activityResult = (ActivityResult) obj;
        int resultCode = activityResult.getResultCode();
        Intent data = activityResult.getData();
        if (resultCode != 0) {
            int i = MainFragment.H1;
            MainFragment mainFragment = this.a;
            String stringExtra = data.getStringExtra(mainFragment.z(R.string.SETTINGSDATA_STR));
            mainFragment.C1 = (SettingsData) mainFragment.y1.fromJson(stringExtra, SettingsData.class);
            if (resultCode == Utils.Code.WavveSave.ordinal()) {
                if (mainFragment.C1.mWavveSettings.mEnable) {
                    bool2 = Boolean.TRUE;
                } else {
                    bool2 = Boolean.FALSE;
                }
                WavveRowSupportFragment.setEnable(bool2);
                WavveRowSupportFragment.setQualityType(mainFragment.C1.mWavveSettings.mQualityType);
                if (mainFragment.C1.mWavveSettings.mEnable) {
                    mainFragment.startServiceIntent(Utils.SiteType.Wavve);
                }
            } else if (resultCode == Utils.Code.TvingSave.ordinal()) {
                if (mainFragment.C1.mTvingSettings.mEnable) {
                    bool = Boolean.TRUE;
                } else {
                    bool = Boolean.FALSE;
                }
                TvingRowSupportFragment.setEnable(bool);
                TvingRowSupportFragment.setQualityType(mainFragment.C1.mTvingSettings.mQualityType);
                if (mainFragment.C1.mTvingSettings.mEnable) {
                    FragmentManager supportFragmentManager = mainFragment.requireActivity().getSupportFragmentManager();
                    TvingLoginDialogFragment newInstance = TvingLoginDialogFragment.newInstance();
                    newInstance.setResultListener(new p(mainFragment));
                    newInstance.show(supportFragmentManager, mainFragment.z(R.string.TVINGLOGINDIALOG_STR));
                }
            } else if (resultCode == Utils.Code.EtcSave.ordinal()) {
                SettingsData.EtcSettingsData etcSettingsData = mainFragment.C1.mEtcSettings;
                TvBaseRowsSupportFragment.mLongPress = etcSettingsData.mLongPress;
                TvBaseRowsSupportFragment.mVolumeControl = etcSettingsData.mVolumeControl;
            }
            if (!Hawk.put(mainFragment.z(R.string.SETTINGSEX_STR), stringExtra)) {
                Utils.showToast(mainFragment.getContext(), R.string.settingssave_error);
            } else {
                mainFragment.createDefaultRows();
            }
        }
    }
}
