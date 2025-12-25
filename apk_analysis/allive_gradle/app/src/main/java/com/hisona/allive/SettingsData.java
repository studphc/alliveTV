package com.hisona.allive;

/* loaded from: classes2.dex */
public class SettingsData {
    public WavveSettingsData mWavveSettings = new WavveSettingsData();
    public TvingSettingsData mTvingSettings = new TvingSettingsData();
    public EtcSettingsData mEtcSettings = new EtcSettingsData();

    /* loaded from: classes2.dex */
    public class BaseSettingsData {
        public boolean mEnable = false;

        public BaseSettingsData() {
        }
    }

    /* loaded from: classes2.dex */
    public class EtcSettingsData {
        public boolean mLongPress = true;
        public boolean mVolumeControl = false;

        public EtcSettingsData() {
        }
    }

    /* loaded from: classes2.dex */
    public enum TvingQualityType {
        MD,
        SD,
        HD,
        FHD
    }

    /* loaded from: classes2.dex */
    public class TvingSettingsData extends BaseSettingsData {
        public TvingQualityType mQualityType;

        public TvingSettingsData() {
            super();
            this.mQualityType = TvingQualityType.SD;
        }
    }

    /* loaded from: classes2.dex */
    public enum WavveQualityType {
        MD,
        SD,
        HD,
        FHD
    }

    /* loaded from: classes2.dex */
    public class WavveSettingsData extends BaseSettingsData {
        public String mId;
        public String mPassword;
        public String mProfile;
        public WavveQualityType mQualityType;

        public WavveSettingsData() {
            super();
            this.mQualityType = WavveQualityType.MD;
            this.mId = "";
            this.mPassword = "";
            this.mProfile = "0";
        }
    }
}
