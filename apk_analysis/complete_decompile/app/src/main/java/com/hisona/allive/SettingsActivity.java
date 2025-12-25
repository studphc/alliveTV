package com.hisona.allive;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.leanback.app.GuidedStepSupportFragment;
import androidx.leanback.widget.GuidanceStylist;
import androidx.leanback.widget.GuidedAction;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.gson.Gson;
import com.hisona.allive.SettingsData;
import com.hisona.allive.Utils;
import java.util.ArrayList;
import java.util.List;
import p000.a80;

/* loaded from: classes2.dex */
public class SettingsActivity extends FragmentActivity {

    /* renamed from: D */
    public static SettingsData f15928D;

    /* renamed from: C */
    public Point f15929C;

    /* loaded from: classes2.dex */
    public static class EtcStepFragment extends GuidedStepSupportFragment {
        @Override // androidx.leanback.app.GuidedStepSupportFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onCreateActions(@NonNull List<GuidedAction> list, Bundle bundle) {
            SettingsData.EtcSettingsData etcSettingsData = SettingsActivity.f15928D.mEtcSettings;
            SettingsActivity.m4470e(getContext(), list, GuidedId.FavoriteEnable.ordinal(), m4472p(R.string.longpress_enable), m4472p(R.string.longpress_desc), etcSettingsData.mLongPress);
            SettingsActivity.m4470e(getContext(), list, GuidedId.VolumeEnable.ordinal(), m4472p(R.string.volumecontrol_enable), m4472p(R.string.volumecontrol_desc), etcSettingsData.mVolumeControl);
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onCreateButtonActions(@NonNull List<GuidedAction> list, Bundle bundle) {
            super.onCreateButtonActions(list, bundle);
            SettingsActivity.m4469d(getContext(), list, GuidedId.EtcSave.ordinal(), m4472p(R.string.set_save), "");
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        @NonNull
        public GuidanceStylist.Guidance onCreateGuidance(@NonNull Bundle bundle) {
            return new GuidanceStylist.Guidance(m4472p(R.string.etcsettings), m4472p(R.string.etcdesc), m4472p(R.string.browse_title), getActivity().getDrawable(R.drawable.settings_icon));
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onGuidedActionClicked(GuidedAction guidedAction) {
            if (guidedAction.getId() == GuidedId.EtcSave.ordinal()) {
                SettingsActivity.f15928D.mEtcSettings.mLongPress = findActionById(GuidedId.FavoriteEnable.ordinal()).isChecked();
                SettingsActivity.f15928D.mEtcSettings.mVolumeControl = findActionById(GuidedId.VolumeEnable.ordinal()).isChecked();
                Intent intent = new Intent();
                intent.putExtra(m4472p(R.string.SETTINGSDATA_STR), new Gson().toJson(SettingsActivity.f15928D));
                getActivity().setResult(Utils.Code.EtcSave.ordinal(), intent);
                getActivity().finishAfterTransition();
            }
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public boolean onSubGuidedActionClicked(GuidedAction guidedAction) {
            return false;
        }

        /* renamed from: p */
        public final String m4472p(int i) {
            return getResources().getString(i);
        }
    }

    /* loaded from: classes2.dex */
    public enum GuidedId {
        Wavve,
        WavveEnable,
        WavveId,
        WavvePw,
        WavveQuality,
        WavveMobile,
        WavveSD,
        WavveHD,
        WavveFHD,
        WavveSave,
        Tving,
        TvingEnable,
        TvingQuality,
        TvingMD,
        TvingSD,
        TvingHD,
        TvingFHD,
        TvingSave,
        Etc,
        FavoriteEnable,
        VolumeEnable,
        EtcSave
    }

    /* loaded from: classes2.dex */
    public static class MainStepFragment extends GuidedStepSupportFragment {
        @Override // androidx.leanback.app.GuidedStepSupportFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onCreateActions(@NonNull List<GuidedAction> list, Bundle bundle) {
            SettingsActivity.m4469d(getContext(), list, GuidedId.Wavve.ordinal(), m4473p(R.string.wavvesettings), m4473p(R.string.setdesc));
            SettingsActivity.m4469d(getContext(), list, GuidedId.Tving.ordinal(), m4473p(R.string.tvingsettings), m4473p(R.string.setdesc));
            SettingsActivity.m4469d(getContext(), list, GuidedId.Etc.ordinal(), m4473p(R.string.etcsettings), m4473p(R.string.etcdesc));
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        @NonNull
        public GuidanceStylist.Guidance onCreateGuidance(@NonNull Bundle bundle) {
            return new GuidanceStylist.Guidance(m4473p(R.string.settings_title), m4473p(R.string.settings_desc), m4473p(R.string.browse_title), getActivity().getDrawable(R.drawable.settings_icon));
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onGuidedActionClicked(GuidedAction guidedAction) {
            FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
            if (guidedAction.getId() == GuidedId.Wavve.ordinal()) {
                GuidedStepSupportFragment.add(supportFragmentManager, new WavveStepFragment());
            } else if (guidedAction.getId() == GuidedId.Tving.ordinal()) {
                GuidedStepSupportFragment.add(supportFragmentManager, new TvingStepFragment());
            } else if (guidedAction.getId() == GuidedId.Etc.ordinal()) {
                GuidedStepSupportFragment.add(supportFragmentManager, new EtcStepFragment());
            }
        }

        /* renamed from: p */
        public final String m4473p(int i) {
            return getResources().getString(i);
        }
    }

    /* loaded from: classes2.dex */
    public static class TvingStepFragment extends GuidedStepSupportFragment {
        @Override // androidx.leanback.app.GuidedStepSupportFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onCreateActions(@NonNull List<GuidedAction> list, Bundle bundle) {
            String obj;
            SettingsData.TvingSettingsData tvingSettingsData = SettingsActivity.f15928D.mTvingSettings;
            SettingsActivity.m4470e(getContext(), list, GuidedId.TvingEnable.ordinal(), m4474p(R.string.channel_enable), "", tvingSettingsData.mEnable);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new GuidedAction.Builder(getContext()).title(m4474p(R.string.mobile)).m1437id(GuidedId.TvingMD.ordinal()).build());
            arrayList.add(new GuidedAction.Builder(getContext()).title(m4474p(R.string.sd)).m1437id(GuidedId.TvingSD.ordinal()).build());
            arrayList.add(new GuidedAction.Builder(getContext()).title(m4474p(R.string.hd)).m1437id(GuidedId.TvingHD.ordinal()).build());
            arrayList.add(new GuidedAction.Builder(getContext()).title(m4474p(R.string.fullhd)).m1437id(GuidedId.TvingFHD.ordinal()).build());
            SettingsData.TvingQualityType tvingQualityType = tvingSettingsData.mQualityType;
            if (tvingQualityType == null) {
                obj = "";
            } else {
                obj = tvingQualityType.toString();
            }
            SettingsActivity.m4471f(getContext(), list, GuidedId.TvingQuality.ordinal(), m4474p(R.string.quality_set), obj, arrayList);
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onCreateButtonActions(@NonNull List<GuidedAction> list, Bundle bundle) {
            super.onCreateButtonActions(list, bundle);
            SettingsActivity.m4469d(getContext(), list, GuidedId.TvingSave.ordinal(), m4474p(R.string.set_save), "");
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        @NonNull
        public GuidanceStylist.Guidance onCreateGuidance(@NonNull Bundle bundle) {
            return new GuidanceStylist.Guidance(m4474p(R.string.tvingsettings), m4474p(R.string.setdesc), m4474p(R.string.browse_title), getActivity().getDrawable(R.drawable.tving_icon));
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment, androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onGuidedActionClicked(GuidedAction guidedAction) {
            if (guidedAction.getId() == GuidedId.TvingSave.ordinal()) {
                boolean isChecked = findActionById(GuidedId.TvingEnable.ordinal()).isChecked();
                SettingsData.TvingSettingsData tvingSettingsData = SettingsActivity.f15928D.mTvingSettings;
                tvingSettingsData.mEnable = isChecked;
                if (tvingSettingsData.mQualityType == null) {
                    tvingSettingsData.mQualityType = SettingsData.TvingQualityType.SD;
                }
                Intent intent = new Intent();
                intent.putExtra(m4474p(R.string.SETTINGSDATA_STR), new Gson().toJson(SettingsActivity.f15928D));
                getActivity().setResult(Utils.Code.TvingSave.ordinal(), intent);
                getActivity().finishAfterTransition();
            }
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public boolean onSubGuidedActionClicked(GuidedAction guidedAction) {
            if (guidedAction.getId() == GuidedId.TvingMD.ordinal()) {
                SettingsActivity.f15928D.mTvingSettings.mQualityType = SettingsData.TvingQualityType.MD;
            } else if (guidedAction.getId() == GuidedId.TvingSD.ordinal()) {
                SettingsActivity.f15928D.mTvingSettings.mQualityType = SettingsData.TvingQualityType.SD;
            } else if (guidedAction.getId() == GuidedId.TvingHD.ordinal()) {
                SettingsActivity.f15928D.mTvingSettings.mQualityType = SettingsData.TvingQualityType.HD;
            } else if (guidedAction.getId() == GuidedId.TvingFHD.ordinal()) {
                SettingsActivity.f15928D.mTvingSettings.mQualityType = SettingsData.TvingQualityType.FHD;
            }
            String obj = SettingsActivity.f15928D.mTvingSettings.mQualityType.toString();
            List<GuidedAction> actions = getActions();
            for (int i = 0; i < actions.size(); i++) {
                GuidedAction guidedAction2 = actions.get(i);
                if (guidedAction2.getId() == GuidedId.TvingQuality.ordinal()) {
                    guidedAction2.setDescription(obj);
                    notifyActionChanged(i);
                    return true;
                }
            }
            return true;
        }

        /* renamed from: p */
        public final String m4474p(int i) {
            return getResources().getString(i);
        }
    }

    /* loaded from: classes2.dex */
    public static class WavveStepFragment extends GuidedStepSupportFragment {
        @Override // androidx.leanback.app.GuidedStepSupportFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onCreateActions(@NonNull List<GuidedAction> list, Bundle bundle) {
            SettingsData.WavveSettingsData wavveSettingsData = SettingsActivity.f15928D.mWavveSettings;
            SettingsActivity.m4470e(getContext(), list, GuidedId.WavveEnable.ordinal(), m4475p(R.string.channel_enable), "", wavveSettingsData.mEnable);
            String str = wavveSettingsData.mId;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            String str3 = wavveSettingsData.mPassword;
            if (str3 == null) {
                str3 = "";
            }
            Context context = getContext();
            list.add(new GuidedAction.Builder(context).m1437id(GuidedId.WavveId.ordinal()).title(m4475p(R.string.id)).descriptionEditable(true).descriptionInputType(1).description(str).build());
            Context context2 = getContext();
            list.add(new GuidedAction.Builder(context2).m1437id(GuidedId.WavvePw.ordinal()).title(m4475p(R.string.password)).description("").editDescription(str3).descriptionEditInputType(TsExtractor.TS_STREAM_TYPE_AC3).descriptionEditable(true).build());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new GuidedAction.Builder(getContext()).title(m4475p(R.string.mobile)).m1437id(GuidedId.WavveMobile.ordinal()).build());
            arrayList.add(new GuidedAction.Builder(getContext()).title(m4475p(R.string.sd)).m1437id(GuidedId.WavveSD.ordinal()).build());
            arrayList.add(new GuidedAction.Builder(getContext()).title(m4475p(R.string.hd)).m1437id(GuidedId.WavveHD.ordinal()).build());
            arrayList.add(new GuidedAction.Builder(getContext()).title(m4475p(R.string.fullhd)).m1437id(GuidedId.WavveFHD.ordinal()).build());
            SettingsData.WavveQualityType wavveQualityType = wavveSettingsData.mQualityType;
            if (wavveQualityType != null) {
                str2 = wavveQualityType.toString();
            }
            SettingsActivity.m4471f(getContext(), list, GuidedId.WavveQuality.ordinal(), m4475p(R.string.quality_set), str2, arrayList);
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onCreateButtonActions(@NonNull List<GuidedAction> list, Bundle bundle) {
            super.onCreateButtonActions(list, bundle);
            SettingsActivity.m4469d(getContext(), list, GuidedId.WavveSave.ordinal(), m4475p(R.string.set_save), "");
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        @NonNull
        public GuidanceStylist.Guidance onCreateGuidance(@NonNull Bundle bundle) {
            return new GuidanceStylist.Guidance(m4475p(R.string.wavvesettings), m4475p(R.string.setdesc), m4475p(R.string.browse_title), getActivity().getDrawable(R.drawable.wavve_icon));
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onGuidedActionClicked(GuidedAction guidedAction) {
            if (guidedAction.getId() == GuidedId.WavveSave.ordinal()) {
                boolean isChecked = findActionById(GuidedId.WavveEnable.ordinal()).isChecked();
                String charSequence = findActionById(GuidedId.WavveId.ordinal()).getDescription().toString();
                String charSequence2 = findActionById(GuidedId.WavvePw.ordinal()).getEditDescription().toString();
                if (charSequence.length() != 0 && charSequence2.length() != 0) {
                    SettingsData.WavveSettingsData wavveSettingsData = SettingsActivity.f15928D.mWavveSettings;
                    wavveSettingsData.mEnable = isChecked;
                    wavveSettingsData.mId = charSequence.trim();
                    SettingsActivity.f15928D.mWavveSettings.mPassword = charSequence2.trim();
                    SettingsData.WavveSettingsData wavveSettingsData2 = SettingsActivity.f15928D.mWavveSettings;
                    wavveSettingsData2.mProfile = "";
                    if (wavveSettingsData2.mQualityType == null) {
                        wavveSettingsData2.mQualityType = SettingsData.WavveQualityType.MD;
                    }
                    Intent intent = new Intent();
                    intent.putExtra(m4475p(R.string.SETTINGSDATA_STR), new Gson().toJson(SettingsActivity.f15928D));
                    getActivity().setResult(Utils.Code.WavveSave.ordinal(), intent);
                    getActivity().finishAfterTransition();
                    return;
                }
                Utils.showToast(getContext(), R.string.input_error);
            }
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public boolean onSubGuidedActionClicked(GuidedAction guidedAction) {
            if (guidedAction.getId() == GuidedId.WavveMobile.ordinal()) {
                SettingsActivity.f15928D.mWavveSettings.mQualityType = SettingsData.WavveQualityType.MD;
            } else if (guidedAction.getId() == GuidedId.WavveSD.ordinal()) {
                SettingsActivity.f15928D.mWavveSettings.mQualityType = SettingsData.WavveQualityType.SD;
            } else if (guidedAction.getId() == GuidedId.WavveHD.ordinal()) {
                SettingsActivity.f15928D.mWavveSettings.mQualityType = SettingsData.WavveQualityType.HD;
            } else if (guidedAction.getId() == GuidedId.WavveFHD.ordinal()) {
                SettingsActivity.f15928D.mWavveSettings.mQualityType = SettingsData.WavveQualityType.FHD;
            }
            String obj = SettingsActivity.f15928D.mWavveSettings.mQualityType.toString();
            List<GuidedAction> actions = getActions();
            for (int i = 0; i < actions.size(); i++) {
                GuidedAction guidedAction2 = actions.get(i);
                if (guidedAction2.getId() == GuidedId.WavveQuality.ordinal()) {
                    guidedAction2.setDescription(obj);
                    notifyActionChanged(i);
                    return true;
                }
            }
            return true;
        }

        /* renamed from: p */
        public final String m4475p(int i) {
            return getResources().getString(i);
        }
    }

    /* renamed from: d */
    public static void m4469d(Context context, List list, long j, String str, String str2) {
        list.add(new GuidedAction.Builder(context).m1437id(j).title(str).description(str2).build());
    }

    /* renamed from: e */
    public static void m4470e(Context context, List list, long j, String str, String str2, boolean z) {
        GuidedAction build = new GuidedAction.Builder(context).m1437id(j).title(str).description(str2).checkSetId(-1).build();
        build.setChecked(z);
        list.add(build);
    }

    /* renamed from: f */
    public static void m4471f(Context context, List list, long j, String str, String str2, ArrayList arrayList) {
        list.add(new GuidedAction.Builder(context).m1437id(j).title(str).description(str2).subActions(arrayList).build());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setRequestedOrientation(0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(0);
        setContentView(R.layout.activity_settings);
        if (bundle == null) {
            f15928D = (SettingsData) new Gson().fromJson(getIntent().getStringExtra(getResources().getString(R.string.SETTINGSDATA_STR)), SettingsData.class);
            GuidedStepSupportFragment.addAsRoot(this, new MainStepFragment(), android.R.id.content);
        }
        this.f15929C = Utils.getDisplaySize(this);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onSettingButtonClick(View view) {
        int id = view.getId();
        if (id == R.id.upButton) {
            new Thread(new a80(15)).start();
            return;
        }
        if (id == R.id.downButton) {
            new Thread(new a80(16)).start();
            return;
        }
        if (id == R.id.leftButton) {
            new Thread(new a80(17)).start();
            return;
        }
        if (id == R.id.rightButton) {
            new Thread(new a80(18)).start();
        } else if (id == R.id.selectButton) {
            new Thread(new a80(19)).start();
        } else if (id == R.id.backButton) {
            new Thread(new a80(20)).start();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getX() < this.f15929C.x * 0.9d) {
            Utils.doFullScreen(this);
        }
        return super.onTouchEvent(motionEvent);
    }
}
