package com.hisona.allive;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.CookieManager;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.PageRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hisona.allive.FetchChannelResultReceiver;
import com.hisona.allive.SettingsData;
import com.hisona.allive.Utils;
import com.orhanobut.hawk.Hawk;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import p000.re1;

/* loaded from: classes2.dex */
public class MainFragment extends BrowseSupportFragment implements FetchChannelResultReceiver.Receiver, OnItemViewClickedListener, OnItemViewSelectedListener {

    /* renamed from: H1 */
    public static final /* synthetic */ int f15858H1 = 0;

    /* renamed from: A1 */
    public ArrayObjectAdapter f15859A1;

    /* renamed from: B1 */
    public ArrayObjectAdapter f15860B1;

    /* renamed from: F1 */
    public FirebaseAnalytics f15864F1;

    /* renamed from: z1 */
    public FetchChannelResultReceiver f15868z1;

    /* renamed from: x1 */
    public final Handler f15866x1 = new Handler(Looper.getMainLooper());

    /* renamed from: y1 */
    public final Gson f15867y1 = new Gson();

    /* renamed from: C1 */
    public SettingsData f15861C1 = new SettingsData();

    /* renamed from: D1 */
    public SpinnerFragment f15862D1 = null;

    /* renamed from: E1 */
    public String f15863E1 = "";

    /* renamed from: G1 */
    public final ActivityResultLauncher f15865G1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1081n(this));

    /* loaded from: classes2.dex */
    public static class PageRowFragmentFactory extends BrowseSupportFragment.FragmentFactory<Fragment> {
        @Override // androidx.leanback.app.BrowseSupportFragment.FragmentFactory
        public Fragment createFragment(Object obj) {
            Row row = (Row) obj;
            if (row.getHeaderItem().getId() == Utils.Header.Favorite.ordinal()) {
                return new FavoriteRowSupportFragment();
            }
            if (row.getHeaderItem().getId() == Utils.Header.Wavve.ordinal()) {
                return new WavveRowSupportFragment();
            }
            if (row.getHeaderItem().getId() == Utils.Header.Tving.ordinal()) {
                return new TvingRowSupportFragment();
            }
            throw new IllegalArgumentException(String.format("Invalid row %s", obj));
        }
    }

    /* renamed from: com.hisona.allive.MainFragment$a */
    /* loaded from: classes2.dex */
    public class C1062a extends TypeToken<ArrayList<String>> {
    }

    /* renamed from: com.hisona.allive.MainFragment$b */
    /* loaded from: classes2.dex */
    public class C1063b extends TypeToken<ArrayList<String>> {
    }

    public void createDefaultRows() {
        this.f15859A1.clear();
        this.f15859A1.add(new PageRow(new HeaderItem(Utils.Header.Favorite.ordinal(), m4456z(R.string.favorite))));
        if (this.f15861C1.mWavveSettings.mEnable) {
            this.f15859A1.add(new PageRow(new HeaderItem(Utils.Header.Wavve.ordinal(), m4456z(R.string.wavve))));
        }
        if (this.f15861C1.mTvingSettings.mEnable) {
            this.f15859A1.add(new PageRow(new HeaderItem(Utils.Header.Tving.ordinal(), m4456z(R.string.tving))));
        }
        HeaderItem headerItem = new HeaderItem(Utils.Header.Etc.ordinal(), m4456z(R.string.etc));
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new C1084q(this));
        this.f15860B1 = arrayObjectAdapter;
        arrayObjectAdapter.add(new re1(0, m4456z(R.string.preferences)));
        this.f15860B1.add(new re1(1, m4456z(R.string.help)));
        this.f15860B1.add(new re1(2, m4456z(R.string.opensource)));
        this.f15860B1.add(new re1(3, m4456z(R.string.version_str) + " 4.5"));
        this.f15859A1.add(new ListRow(headerItem, this.f15860B1));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // androidx.leanback.app.BrowseSupportFragment, androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        SettingsData.WavveSettingsData wavveSettingsData;
        String str;
        super.onCreate(bundle);
        this.f15864F1 = FirebaseAnalytics.getInstance(getContext());
        C1079l c1079l = new C1079l(this);
        this.f15863E1 = new SimpleDateFormat("HH", Locale.US).format(new Date());
        new Timer().schedule(c1079l, 600000L, 600000L);
        Utils.doFullScreen(getActivity());
        Hawk.init(getContext()).build();
        boolean contains = Hawk.contains(m4456z(R.string.SETTINGSEX_STR));
        Gson gson = this.f15867y1;
        if (!contains && Hawk.contains(m4456z(R.string.SETTINGS_STR))) {
            if (Utils.parseSettingsData((String) Hawk.get(m4456z(R.string.SETTINGS_STR)), this.f15861C1)) {
                if (!Hawk.put(m4456z(R.string.SETTINGSEX_STR), gson.toJson(this.f15861C1))) {
                    Utils.showToast(getContext(), m4456z(R.string.settingssave_error));
                    wavveSettingsData = this.f15861C1.mWavveSettings;
                    if (wavveSettingsData.mEnable && (str = wavveSettingsData.mId) != null && str.length() > 0) {
                        startServiceIntent(Utils.SiteType.Wavve);
                    }
                    if (!this.f15861C1.mTvingSettings.mEnable) {
                        String cookie = CookieManager.getInstance().getCookie("https://www.tving.com/");
                        if (cookie != null && cookie.contains("_tving_token")) {
                            TvingRowSupportFragment.setAuthKey(cookie);
                            startServiceIntent(Utils.SiteType.Tving);
                            return;
                        } else {
                            FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
                            TvingLoginDialogFragment newInstance = TvingLoginDialogFragment.newInstance();
                            newInstance.setResultListener(new C1083p(this));
                            newInstance.show(supportFragmentManager, m4456z(R.string.TVINGLOGINDIALOG_STR));
                            return;
                        }
                    }
                    return;
                }
                Hawk.delete(m4456z(R.string.SETTINGS_STR));
            } else {
                Utils.showToast(getContext(), m4456z(R.string.settingsload_error));
            }
        }
        if (Hawk.contains(m4456z(R.string.SETTINGSEX_STR))) {
            SettingsData settingsData = (SettingsData) gson.fromJson((String) Hawk.get(m4456z(R.string.SETTINGSEX_STR)), SettingsData.class);
            this.f15861C1 = settingsData;
            WavveRowSupportFragment.setEnable(Boolean.valueOf(settingsData.mWavveSettings.mEnable));
            WavveRowSupportFragment.setQualityType(this.f15861C1.mWavveSettings.mQualityType);
            TvingRowSupportFragment.setEnable(Boolean.valueOf(this.f15861C1.mTvingSettings.mEnable));
            TvingRowSupportFragment.setQualityType(this.f15861C1.mTvingSettings.mQualityType);
            SettingsData.EtcSettingsData etcSettingsData = this.f15861C1.mEtcSettings;
            TvBaseRowsSupportFragment.mLongPress = etcSettingsData.mLongPress;
            TvBaseRowsSupportFragment.mVolumeControl = etcSettingsData.mVolumeControl;
        } else {
            SettingsData.WavveSettingsData wavveSettingsData2 = this.f15861C1.mWavveSettings;
            wavveSettingsData2.mEnable = true;
            wavveSettingsData2.mId = "";
            wavveSettingsData2.mPassword = "";
            wavveSettingsData2.mProfile = "";
            wavveSettingsData2.mQualityType = SettingsData.WavveQualityType.SD;
            Boolean bool = Boolean.TRUE;
            WavveRowSupportFragment.setEnable(bool);
            WavveRowSupportFragment.setQualityType(this.f15861C1.mWavveSettings.mQualityType);
            SettingsData.TvingSettingsData tvingSettingsData = this.f15861C1.mTvingSettings;
            tvingSettingsData.mEnable = true;
            tvingSettingsData.mQualityType = SettingsData.TvingQualityType.HD;
            TvingRowSupportFragment.setEnable(bool);
            TvingRowSupportFragment.setQualityType(this.f15861C1.mTvingSettings.mQualityType);
            SettingsData.EtcSettingsData etcSettingsData2 = this.f15861C1.mEtcSettings;
            etcSettingsData2.mLongPress = true;
            etcSettingsData2.mVolumeControl = false;
            TvBaseRowsSupportFragment.mLongPress = true;
            TvBaseRowsSupportFragment.mVolumeControl = false;
        }
        setBadgeDrawable(getResources().getDrawable(R.drawable.allivetv_badge, null));
        setTitle(m4456z(R.string.browse_title));
        setHeadersState(1);
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(ContextCompat.getColor(requireContext(), R.color.fastlane_background));
        setSearchAffordanceColor(ContextCompat.getColor(requireContext(), R.color.search_opaque));
        setHeaderPresenterSelector(new PresenterSelector());
        getMainFragmentRegistry().registerFragment(PageRow.class, new PageRowFragmentFactory());
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        this.f15859A1 = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
        createDefaultRows();
        setOnItemViewClickedListener(this);
        setOnItemViewSelectedListener(this);
        setOnSearchClickedListener(new ViewOnClickListenerC1080m(this));
        FetchChannelResultReceiver fetchChannelResultReceiver = new FetchChannelResultReceiver(this.f15866x1);
        this.f15868z1 = fetchChannelResultReceiver;
        fetchChannelResultReceiver.setReceiver(this);
        wavveSettingsData = this.f15861C1.mWavveSettings;
        if (wavveSettingsData.mEnable) {
            startServiceIntent(Utils.SiteType.Wavve);
        }
        if (!this.f15861C1.mTvingSettings.mEnable) {
        }
    }

    @Override // com.hisona.allive.FetchChannelResultReceiver.Receiver
    public void onReceiveResult(int i, Bundle bundle) {
        Utils.SiteType siteType = (Utils.SiteType) bundle.get(m4456z(R.string.SITETYPE_STR));
        boolean equals = ((String) bundle.get(m4456z(R.string.FETCHMODE_STR))).equals("refresh");
        if (!PlayerActivity.f15869d0 && this.f15862D1 != null) {
            requireActivity().getSupportFragmentManager().beginTransaction().remove(this.f15862D1).commit();
            this.f15862D1 = null;
        }
        int i2 = AbstractC1078k.f15997b[Utils.Code.values()[i].ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    String string = bundle.getString(m4456z(R.string.ERRMSG_STR));
                    FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
                    ProfileSelectFragment profileSelectFragment = new ProfileSelectFragment();
                    profileSelectFragment.setClickListener(new C1082o(this, profileSelectFragment));
                    profileSelectFragment.show(supportFragmentManager, m4456z(R.string.PROFILESELECTDIALOG_STR));
                    supportFragmentManager.executePendingTransactions();
                    profileSelectFragment.setData(string);
                    return;
                }
                return;
            }
            String string2 = bundle.getString(m4456z(R.string.ERRMSG_STR));
            int i3 = AbstractC1078k.f15996a[siteType.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    Utils.showToast(getContext(), m4456z(R.string.tving_login_fail) + "\n" + string2);
                }
            } else {
                Utils.showToast(getContext(), m4456z(R.string.wavve_login_fail) + "\n" + string2);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("site", siteType.toString());
            bundle2.putString("errmsg", string2);
            this.f15864F1.logEvent(FirebaseAnalytics.Event.LOGIN, bundle2);
            return;
        }
        int i4 = AbstractC1078k.f15996a[siteType.ordinal()];
        Gson gson = this.f15867y1;
        if (i4 != 1) {
            if (i4 == 2) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(m4456z(R.string.CHANNELS_STR));
                if (Hawk.contains(m4456z(R.string.TVING_CHANNELS_STR))) {
                    TvingRowSupportFragment.setFavorites(parcelableArrayList, (ArrayList) gson.fromJson((String) Hawk.get(m4456z(R.string.TVING_CHANNELS_STR)), new TypeToken().getType()));
                } else {
                    TvingRowSupportFragment.setFavorites(parcelableArrayList, new ArrayList());
                }
                if (!equals) {
                    TvingRowSupportFragment.setChannelList(parcelableArrayList);
                    TvingRowSupportFragment.setCategoryList(bundle.getParcelableArrayList(m4456z(R.string.CATEGORY_STR)));
                    TvingRowSupportFragment.setAuthKey(bundle.getString(m4456z(R.string.AUTHKEY_STR)));
                    refreshServiceIntent(siteType);
                } else {
                    TvingRowSupportFragment.updateEPG(parcelableArrayList);
                }
            }
        } else {
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(m4456z(R.string.CHANNELS_STR));
            if (Hawk.contains(m4456z(R.string.WAVVE_CHANNELS_STR))) {
                WavveRowSupportFragment.setFavorites(parcelableArrayList2, (ArrayList) gson.fromJson((String) Hawk.get(m4456z(R.string.WAVVE_CHANNELS_STR)), new TypeToken().getType()));
            } else {
                WavveRowSupportFragment.setFavorites(parcelableArrayList2, new ArrayList());
            }
            if (!equals) {
                WavveRowSupportFragment.setChannelList(parcelableArrayList2);
                WavveRowSupportFragment.setCategoryList(bundle.getParcelableArrayList(m4456z(R.string.CATEGORY_STR)));
                WavveRowSupportFragment.setAuthKey(bundle.getString(m4456z(R.string.AUTHKEY_STR)));
                refreshServiceIntent(siteType);
            } else {
                WavveRowSupportFragment.updateEPG(parcelableArrayList2);
            }
        }
        Fragment mainFragment = getMainFragment();
        Utils.SiteType siteType2 = Utils.SiteType.Wavve;
        if (siteType == siteType2 && (mainFragment instanceof WavveRowSupportFragment)) {
            if (PlayerActivity.f15869d0) {
                ((WavveRowSupportFragment) mainFragment).sendChannelData();
            } else if (equals) {
                ((WavveRowSupportFragment) mainFragment).refreshRows();
            } else {
                ((WavveRowSupportFragment) mainFragment).createRows();
            }
        } else if (siteType == Utils.SiteType.Tving && (mainFragment instanceof TvingRowSupportFragment)) {
            if (PlayerActivity.f15869d0) {
                ((TvingRowSupportFragment) mainFragment).sendChannelData();
            } else if (equals) {
                ((TvingRowSupportFragment) mainFragment).refreshRows();
            } else {
                ((TvingRowSupportFragment) mainFragment).createRows();
            }
        }
        if (mainFragment instanceof FavoriteRowSupportFragment) {
            if (siteType != siteType2 || !this.f15861C1.mTvingSettings.mEnable) {
                if (PlayerActivity.f15869d0) {
                    ((FavoriteRowSupportFragment) mainFragment).sendChannelData();
                } else if (equals) {
                    ((FavoriteRowSupportFragment) mainFragment).refreshRows();
                } else {
                    ((FavoriteRowSupportFragment) mainFragment).createRows();
                }
            }
        }
    }

    public void refreshServiceIntent(Utils.SiteType siteType) {
        Intent intent = new Intent(getActivity(), (Class<?>) FetchChannelService.class);
        String json = this.f15867y1.toJson(this.f15861C1);
        String authKey = TvBaseRowsSupportFragment.getAuthKey(siteType);
        intent.putExtra(m4456z(R.string.FETCHCHANNELRESULTRECEIVER_STR), this.f15868z1);
        intent.putExtra(m4456z(R.string.SETTINGSDATA_STR), json);
        intent.putExtra(m4456z(R.string.SITETYPE_STR), siteType);
        intent.putExtra(m4456z(R.string.AUTHKEY_STR), authKey);
        intent.putExtra(m4456z(R.string.FETCHMODE_STR), "refresh");
        intent.putParcelableArrayListExtra(m4456z(R.string.CHANNELS_STR), TvBaseRowsSupportFragment.mChannels.get(siteType));
        intent.putParcelableArrayListExtra(m4456z(R.string.CATEGORY_STR), TvBaseRowsSupportFragment.mCategory.get(siteType));
        FetchChannelService.enqueueWork(getActivity(), intent);
    }

    public void startServiceIntent(Utils.SiteType siteType) {
        if (this.f15862D1 == null) {
            this.f15862D1 = new SpinnerFragment();
            requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.main_browse_fragment, this.f15862D1).commit();
        }
        String json = this.f15867y1.toJson(this.f15861C1);
        String authKey = TvBaseRowsSupportFragment.getAuthKey(siteType);
        if (authKey == null) {
            authKey = "";
        }
        Intent intent = new Intent(getActivity(), (Class<?>) FetchChannelService.class);
        intent.putExtra(m4456z(R.string.FETCHCHANNELRESULTRECEIVER_STR), this.f15868z1);
        intent.putExtra(m4456z(R.string.SETTINGSDATA_STR), json);
        intent.putExtra(m4456z(R.string.SITETYPE_STR), siteType);
        intent.putExtra(m4456z(R.string.AUTHKEY_STR), authKey);
        intent.putExtra(m4456z(R.string.FETCHMODE_STR), "create");
        FetchChannelService.enqueueWork(getActivity(), intent);
    }

    /* renamed from: z */
    public final String m4456z(int i) {
        return getResources().getString(i);
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof re1) {
            int i = ((re1) obj).f25947b;
            if (i == 0) {
                Intent intent = new Intent(getActivity(), (Class<?>) SettingsActivity.class);
                intent.putExtra(m4456z(R.string.SETTINGSDATA_STR), this.f15867y1.toJson(this.f15861C1));
                this.f15865G1.launch(intent);
            } else if (i == 1) {
                FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
                RemoteInfoDialogFragment.newInstance().show(supportFragmentManager, m4456z(R.string.REMOTEINFODIALOG_STR));
                supportFragmentManager.executePendingTransactions();
            } else if (i == 2) {
                FragmentManager supportFragmentManager2 = requireActivity().getSupportFragmentManager();
                LicensesDialogFragment.newInstance().show(supportFragmentManager2, m4456z(R.string.LICENSESDIALOG_STR));
                supportFragmentManager2.executePendingTransactions();
            }
        }
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (viewHolder != null && (obj instanceof re1)) {
            int i = ((re1) obj).f25947b;
            for (int i2 = 0; i2 < this.f15860B1.size(); i2++) {
                View view = ((re1) this.f15860B1.get(i2)).f25946a;
                if (view != null) {
                    if (i2 == i) {
                        view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.selected_background));
                    } else {
                        view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fastlane_background));
                    }
                }
            }
        }
    }
}
