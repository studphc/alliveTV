package com.hisona.allive;

import androidx.fragment.app.Fragment;
import com.hisona.allive.SettingsData;
import com.hisona.allive.Utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimerTask;

/* renamed from: com.hisona.allive.l */
/* loaded from: classes2.dex */
public final class C1079l extends TimerTask {

    /* renamed from: a */
    public final /* synthetic */ MainFragment f15998a;

    public C1079l(MainFragment mainFragment) {
        this.f15998a = mainFragment;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        String str;
        String format = new SimpleDateFormat("HH", Locale.US).format(new Date());
        MainFragment mainFragment = this.f15998a;
        if (format.compareTo(mainFragment.f15863E1) != 0) {
            if (mainFragment.getMainFragment() instanceof TvBaseRowsSupportFragment) {
                mainFragment.f15863E1 = format;
                SettingsData.WavveSettingsData wavveSettingsData = mainFragment.f15861C1.mWavveSettings;
                if (wavveSettingsData.mEnable && (str = wavveSettingsData.mId) != null && str.length() > 0) {
                    mainFragment.refreshServiceIntent(Utils.SiteType.Wavve);
                }
                if (mainFragment.f15861C1.mTvingSettings.mEnable) {
                    mainFragment.refreshServiceIntent(Utils.SiteType.Tving);
                    return;
                }
                return;
            }
            return;
        }
        if (!PlayerActivity.f15869d0) {
            Fragment mainFragment2 = mainFragment.getMainFragment();
            if (mainFragment2 instanceof TvBaseRowsSupportFragment) {
                ((TvBaseRowsSupportFragment) mainFragment2).refreshRows();
            }
        }
    }
}
