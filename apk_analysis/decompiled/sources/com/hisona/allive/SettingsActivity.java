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
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.gson.Gson;
import com.hisona.allive.SettingsData;
import com.hisona.allive.Utils;
import defpackage.a80;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SettingsActivity extends FragmentActivity {
    public static SettingsData D;
    public Point C;

    /* loaded from: classes2.dex */
    public static class EtcStepFragment extends GuidedStepSupportFragment {
        @Override // androidx.leanback.app.GuidedStepSupportFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onCreateActions(@NonNull List<GuidedAction> list, Bundle bundle) {
            SettingsData.EtcSettingsData etcSettingsData = SettingsActivity.D.mEtcSettings;
            SettingsActivity.e(getContext(), list, GuidedId.FavoriteEnable.ordinal(), p(R.string.longpress_enable), p(R.string.longpress_desc), etcSettingsData.mLongPress);
            SettingsActivity.e(getContext(), list, GuidedId.VolumeEnable.ordinal(), p(R.string.volumecontrol_enable), p(R.string.volumecontrol_desc), etcSettingsData.mVolumeControl);
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onCreateButtonActions(@NonNull List<GuidedAction> list, Bundle bundle) {
            super.onCreateButtonActions(list, bundle);
            SettingsActivity.d(getContext(), list, GuidedId.EtcSave.ordinal(), p(R.string.set_save), "");
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        @NonNull
        public GuidanceStylist.Guidance onCreateGuidance(@NonNull Bundle bundle) {
            return new GuidanceStylist.Guidance(p(R.string.etcsettings), p(R.string.etcdesc), p(R.string.browse_title), getActivity().getDrawable(R.drawable.settings_icon));
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onGuidedActionClicked(GuidedAction guidedAction) {
            if (guidedAction.getId() == GuidedId.EtcSave.ordinal()) {
                SettingsActivity.D.mEtcSettings.mLongPress = findActionById(GuidedId.FavoriteEnable.ordinal()).isChecked();
                SettingsActivity.D.mEtcSettings.mVolumeControl = findActionById(GuidedId.VolumeEnable.ordinal()).isChecked();
                Intent intent = new Intent();
                intent.putExtra(p(R.string.SETTINGSDATA_STR), new Gson().toJson(SettingsActivity.D));
                getActivity().setResult(Utils.Code.EtcSave.ordinal(), intent);
                getActivity().finishAfterTransition();
            }
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public boolean onSubGuidedActionClicked(GuidedAction guidedAction) {
            return false;
        }

        public final String p(int i) {
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
            SettingsActivity.d(getContext(), list, GuidedId.Wavve.ordinal(), p(R.string.wavvesettings), p(R.string.setdesc));
            SettingsActivity.d(getContext(), list, GuidedId.Tving.ordinal(), p(R.string.tvingsettings), p(R.string.setdesc));
            SettingsActivity.d(getContext(), list, GuidedId.Etc.ordinal(), p(R.string.etcsettings), p(R.string.etcdesc));
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        @NonNull
        public GuidanceStylist.Guidance onCreateGuidance(@NonNull Bundle bundle) {
            return new GuidanceStylist.Guidance(p(R.string.settings_title), p(R.string.settings_desc), p(R.string.browse_title), getActivity().getDrawable(R.drawable.settings_icon));
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

        public final String p(int i) {
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
            SettingsData.TvingSettingsData tvingSettingsData = SettingsActivity.D.mTvingSettings;
            SettingsActivity.e(getContext(), list, GuidedId.TvingEnable.ordinal(), p(R.string.channel_enable), "", tvingSettingsData.mEnable);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new GuidedAction.Builder(getContext()).title(p(R.string.mobile)).id(GuidedId.TvingMD.ordinal()).build());
            arrayList.add(new GuidedAction.Builder(getContext()).title(p(R.string.sd)).id(GuidedId.TvingSD.ordinal()).build());
            arrayList.add(new GuidedAction.Builder(getContext()).title(p(R.string.hd)).id(GuidedId.TvingHD.ordinal()).build());
            arrayList.add(new GuidedAction.Builder(getContext()).title(p(R.string.fullhd)).id(GuidedId.TvingFHD.ordinal()).build());
            SettingsData.TvingQualityType tvingQualityType = tvingSettingsData.mQualityType;
            if (tvingQualityType == null) {
                obj = "";
            } else {
                obj = tvingQualityType.toString();
            }
            SettingsActivity.f(getContext(), list, GuidedId.TvingQuality.ordinal(), p(R.string.quality_set), obj, arrayList);
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onCreateButtonActions(@NonNull List<GuidedAction> list, Bundle bundle) {
            super.onCreateButtonActions(list, bundle);
            SettingsActivity.d(getContext(), list, GuidedId.TvingSave.ordinal(), p(R.string.set_save), "");
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        @NonNull
        public GuidanceStylist.Guidance onCreateGuidance(@NonNull Bundle bundle) {
            return new GuidanceStylist.Guidance(p(R.string.tvingsettings), p(R.string.setdesc), p(R.string.browse_title), getActivity().getDrawable(R.drawable.tving_icon));
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment, androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onGuidedActionClicked(GuidedAction guidedAction) {
            if (guidedAction.getId() == GuidedId.TvingSave.ordinal()) {
                boolean isChecked = findActionById(GuidedId.TvingEnable.ordinal()).isChecked();
                SettingsData.TvingSettingsData tvingSettingsData = SettingsActivity.D.mTvingSettings;
                tvingSettingsData.mEnable = isChecked;
                if (tvingSettingsData.mQualityType == null) {
                    tvingSettingsData.mQualityType = SettingsData.TvingQualityType.SD;
                }
                Intent intent = new Intent();
                intent.putExtra(p(R.string.SETTINGSDATA_STR), new Gson().toJson(SettingsActivity.D));
                getActivity().setResult(Utils.Code.TvingSave.ordinal(), intent);
                getActivity().finishAfterTransition();
            }
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public boolean onSubGuidedActionClicked(GuidedAction guidedAction) {
            if (guidedAction.getId() == GuidedId.TvingMD.ordinal()) {
                SettingsActivity.D.mTvingSettings.mQualityType = SettingsData.TvingQualityType.MD;
            } else if (guidedAction.getId() == GuidedId.TvingSD.ordinal()) {
                SettingsActivity.D.mTvingSettings.mQualityType = SettingsData.TvingQualityType.SD;
            } else if (guidedAction.getId() == GuidedId.TvingHD.ordinal()) {
                SettingsActivity.D.mTvingSettings.mQualityType = SettingsData.TvingQualityType.HD;
            } else if (guidedAction.getId() == GuidedId.TvingFHD.ordinal()) {
                SettingsActivity.D.mTvingSettings.mQualityType = SettingsData.TvingQualityType.FHD;
            }
            String obj = SettingsActivity.D.mTvingSettings.mQualityType.toString();
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

        public final String p(int i) {
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
            SettingsData.WavveSettingsData wavveSettingsData = SettingsActivity.D.mWavveSettings;
            SettingsActivity.e(getContext(), list, GuidedId.WavveEnable.ordinal(), p(R.string.channel_enable), "", wavveSettingsData.mEnable);
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
            list.add(new GuidedAction.Builder(context).id(GuidedId.WavveId.ordinal()).title(p(R.string.id)).descriptionEditable(true).descriptionInputType(1).description(str).build());
            Context context2 = getContext();
            list.add(new GuidedAction.Builder(context2).id(GuidedId.WavvePw.ordinal()).title(p(R.string.password)).description("").editDescription(str3).descriptionEditInputType(TsExtractor.TS_STREAM_TYPE_AC3).descriptionEditable(true).build());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new GuidedAction.Builder(getContext()).title(p(R.string.mobile)).id(GuidedId.WavveMobile.ordinal()).build());
            arrayList.add(new GuidedAction.Builder(getContext()).title(p(R.string.sd)).id(GuidedId.WavveSD.ordinal()).build());
            arrayList.add(new GuidedAction.Builder(getContext()).title(p(R.string.hd)).id(GuidedId.WavveHD.ordinal()).build());
            arrayList.add(new GuidedAction.Builder(getContext()).title(p(R.string.fullhd)).id(GuidedId.WavveFHD.ordinal()).build());
            SettingsData.WavveQualityType wavveQualityType = wavveSettingsData.mQualityType;
            if (wavveQualityType != null) {
                str2 = wavveQualityType.toString();
            }
            SettingsActivity.f(getContext(), list, GuidedId.WavveQuality.ordinal(), p(R.string.quality_set), str2, arrayList);
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onCreateButtonActions(@NonNull List<GuidedAction> list, Bundle bundle) {
            super.onCreateButtonActions(list, bundle);
            SettingsActivity.d(getContext(), list, GuidedId.WavveSave.ordinal(), p(R.string.set_save), "");
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        @NonNull
        public GuidanceStylist.Guidance onCreateGuidance(@NonNull Bundle bundle) {
            return new GuidanceStylist.Guidance(p(R.string.wavvesettings), p(R.string.setdesc), p(R.string.browse_title), getActivity().getDrawable(R.drawable.wavve_icon));
        }

        @Override // androidx.leanback.app.GuidedStepSupportFragment
        public void onGuidedActionClicked(GuidedAction guidedAction) {
            if (guidedAction.getId() == GuidedId.WavveSave.ordinal()) {
                boolean isChecked = findActionById(GuidedId.WavveEnable.ordinal()).isChecked();
                String charSequence = findActionById(GuidedId.WavveId.ordinal()).getDescription().toString();
                String charSequence2 = findActionById(GuidedId.WavvePw.ordinal()).getEditDescription().toString();
                if (charSequence.length() != 0 && charSequence2.length() != 0) {
                    SettingsData.WavveSettingsData wavveSettingsData = SettingsActivity.D.mWavveSettings;
                    wavveSettingsData.mEnable = isChecked;
                    wavveSettingsData.mId = charSequence.trim();
                    SettingsActivity.D.mWavveSettings.mPassword = charSequence2.trim();
                    SettingsData.WavveSettingsData wavveSettingsData2 = SettingsActivity.D.mWavveSettings;
                    wavveSettingsData2.mProfile = "";
                    if (wavveSettingsData2.mQualityType == null) {
                        wavveSettingsData2.mQualityType = SettingsData.WavveQualityType.MD;
                    }
                    Intent intent = new Intent();
                    intent.putExtra(p(R.string.SETTINGSDATA_STR), new Gson().toJson(SettingsActivity.D));
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
                SettingsActivity.D.mWavveSettings.mQualityType = SettingsData.WavveQualityType.MD;
            } else if (guidedAction.getId() == GuidedId.WavveSD.ordinal()) {
                SettingsActivity.D.mWavveSettings.mQualityType = SettingsData.WavveQualityType.SD;
            } else if (guidedAction.getId() == GuidedId.WavveHD.ordinal()) {
                SettingsActivity.D.mWavveSettings.mQualityType = SettingsData.WavveQualityType.HD;
            } else if (guidedAction.getId() == GuidedId.WavveFHD.ordinal()) {
                SettingsActivity.D.mWavveSettings.mQualityType = SettingsData.WavveQualityType.FHD;
            }
            String obj = SettingsActivity.D.mWavveSettings.mQualityType.toString();
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

        public final String p(int i) {
            return getResources().getString(i);
        }
    }

    public static void d(Context context, List list, long j, String str, String str2) {
        list.add(new GuidedAction.Builder(context).id(j).title(str).description(str2).build());
    }

    public static void e(Context context, List list, long j, String str, String str2, boolean z) {
        GuidedAction build = new GuidedAction.Builder(context).id(j).title(str).description(str2).checkSetId(-1).build();
        build.setChecked(z);
        list.add(build);
    }

    public static void f(Context context, List list, long j, String str, String str2, ArrayList arrayList) {
        list.add(new GuidedAction.Builder(context).id(j).title(str).description(str2).subActions(arrayList).build());
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
            D = (SettingsData) new Gson().fromJson(getIntent().getStringExtra(getResources().getString(R.string.SETTINGSDATA_STR)), SettingsData.class);
            GuidedStepSupportFragment.addAsRoot(this, new MainStepFragment(), android.R.id.content);
        }
        this.C = Utils.getDisplaySize(this);
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
        if (motionEvent.getAction() == 1 && motionEvent.getX() < this.C.x * 0.9d) {
            Utils.doFullScreen(this);
        }
        return super.onTouchEvent(motionEvent);
    }
}
