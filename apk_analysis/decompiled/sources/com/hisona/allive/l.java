package com.hisona.allive;

import androidx.fragment.app.Fragment;
import com.hisona.allive.SettingsData;
import com.hisona.allive.Utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public final class l extends TimerTask {
    public final /* synthetic */ MainFragment a;

    public l(MainFragment mainFragment) {
        this.a = mainFragment;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        String str;
        String format = new SimpleDateFormat("HH", Locale.US).format(new Date());
        MainFragment mainFragment = this.a;
        if (format.compareTo(mainFragment.E1) != 0) {
            if (mainFragment.getMainFragment() instanceof TvBaseRowsSupportFragment) {
                mainFragment.E1 = format;
                SettingsData.WavveSettingsData wavveSettingsData = mainFragment.C1.mWavveSettings;
                if (wavveSettingsData.mEnable && (str = wavveSettingsData.mId) != null && str.length() > 0) {
                    mainFragment.refreshServiceIntent(Utils.SiteType.Wavve);
                }
                if (mainFragment.C1.mTvingSettings.mEnable) {
                    mainFragment.refreshServiceIntent(Utils.SiteType.Tving);
                    return;
                }
                return;
            }
            return;
        }
        if (!PlayerActivity.d0) {
            Fragment mainFragment2 = mainFragment.getMainFragment();
            if (mainFragment2 instanceof TvBaseRowsSupportFragment) {
                ((TvBaseRowsSupportFragment) mainFragment2).refreshRows();
            }
        }
    }
}
