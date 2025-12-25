package com.hisona.allive;

import android.content.Context;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class SiteProcessor {
    public final Context a;
    protected String mProfile = "";
    protected String mAuthKey = "";
    protected int mQualityType = 0;
    protected int mErrorCode = 0;
    protected String mErrorMessage = "";
    protected ArrayList<ChannelData> mChannelDatas = new ArrayList<>();
    protected ArrayList<CategoryData> mCategoryDatas = new ArrayList<>();

    public SiteProcessor(Context context) {
        this.a = context;
    }

    public abstract boolean doProcess(SettingsData settingsData);

    public final String getAuthKey() {
        return this.mAuthKey;
    }

    public ArrayList<CategoryData> getCategorylList() {
        return this.mCategoryDatas;
    }

    public ArrayList<ChannelData> getChannelList() {
        return this.mChannelDatas;
    }

    public final int getErrorCode() {
        return this.mErrorCode;
    }

    public final String getErrorMessage() {
        return this.mErrorMessage;
    }

    public final int getIntById(int i) {
        return this.a.getResources().getInteger(i);
    }

    public final String getStringById(int i) {
        return this.a.getResources().getString(i);
    }

    public final void setAuthKey(String str) {
        this.mAuthKey = str;
    }

    public void setCategorylList(ArrayList<CategoryData> arrayList) {
        this.mCategoryDatas.clear();
        this.mCategoryDatas = arrayList;
    }

    public void setChannelList(ArrayList<ChannelData> arrayList) {
        this.mChannelDatas.clear();
        this.mChannelDatas = arrayList;
    }

    public final void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public final void setErrorMessage(String str) {
        this.mErrorMessage = str;
    }

    public abstract boolean updateProcess();
}
