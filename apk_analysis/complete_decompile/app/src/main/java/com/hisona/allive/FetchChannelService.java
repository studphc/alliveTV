package com.hisona.allive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.hisona.allive.Utils;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class FetchChannelService extends RxJobIntentService {

    /* renamed from: j */
    public SiteProcessor f15827j;

    public static void enqueueWork(Context context, Intent intent) {
        RxJobIntentService.enqueueWork(context, (Class<?>) FetchChannelService.class, 1000, intent);
    }

    /* renamed from: d */
    public final String m4449d(int i) {
        return getResources().getString(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00da, code lost:
    
        if (r14.f15827j.updateProcess() == false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0133  */
    @Override // com.hisona.allive.RxJobIntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onHandleWork(@NonNull Intent intent) {
        int ordinal;
        if (intent != null) {
            ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra(m4449d(R.string.FETCHCHANNELRESULTRECEIVER_STR));
            SettingsData settingsData = (SettingsData) new Gson().fromJson(intent.getStringExtra(m4449d(R.string.SETTINGSDATA_STR)), SettingsData.class);
            Utils.SiteType siteType = (Utils.SiteType) intent.getSerializableExtra(m4449d(R.string.SITETYPE_STR));
            if (siteType == Utils.SiteType.Wavve) {
                this.f15827j = new WavveSiteProcessor(getApplicationContext());
            } else if (siteType == Utils.SiteType.Tving) {
                this.f15827j = new TvingSiteProcessor(getApplicationContext());
            }
            String str = (String) intent.getSerializableExtra(m4449d(R.string.AUTHKEY_STR));
            if (str != null && str.length() != 0) {
                this.f15827j.setAuthKey(str);
            } else {
                this.f15827j.setAuthKey("");
            }
            String str2 = (String) intent.getSerializableExtra(m4449d(R.string.FETCHMODE_STR));
            ArrayList<ChannelData> arrayList = new ArrayList<>();
            ArrayList<CategoryData> arrayList2 = new ArrayList<>();
            boolean z = true;
            if (str2.equals("create")) {
                if (this.f15827j.doProcess(settingsData)) {
                    arrayList = this.f15827j.getChannelList();
                    arrayList2 = this.f15827j.getCategorylList();
                    z = false;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(m4449d(R.string.CHANNELS_STR), arrayList);
                bundle.putParcelableArrayList(m4449d(R.string.CATEGORY_STR), arrayList2);
                bundle.putString(m4449d(R.string.AUTHKEY_STR), this.f15827j.getAuthKey());
                bundle.putSerializable(m4449d(R.string.SITETYPE_STR), siteType);
                bundle.putString(m4449d(R.string.FETCHMODE_STR), str2);
                if (!z) {
                    if (this.f15827j.getErrorCode() == 2) {
                        ordinal = Utils.Code.ServiceIntent_Profile.ordinal();
                    } else {
                        ordinal = Utils.Code.ServiceIntent_Fail.ordinal();
                    }
                    bundle.putString(m4449d(R.string.ERRMSG_STR), this.f15827j.getErrorMessage());
                } else {
                    ordinal = Utils.Code.ServiceIntent_OK.ordinal();
                }
                resultReceiver.send(ordinal, bundle);
            }
            if (str2.equals("refresh")) {
                arrayList = intent.getParcelableArrayListExtra(m4449d(R.string.CHANNELS_STR));
                arrayList2 = intent.getParcelableArrayListExtra(m4449d(R.string.CATEGORY_STR));
                this.f15827j.setChannelList(arrayList);
                this.f15827j.setCategorylList(arrayList2);
            }
            z = false;
            Bundle bundle2 = new Bundle();
            bundle2.putParcelableArrayList(m4449d(R.string.CHANNELS_STR), arrayList);
            bundle2.putParcelableArrayList(m4449d(R.string.CATEGORY_STR), arrayList2);
            bundle2.putString(m4449d(R.string.AUTHKEY_STR), this.f15827j.getAuthKey());
            bundle2.putSerializable(m4449d(R.string.SITETYPE_STR), siteType);
            bundle2.putString(m4449d(R.string.FETCHMODE_STR), str2);
            if (!z) {
            }
            resultReceiver.send(ordinal, bundle2);
        }
    }
}
