package com.hisona.allive;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.PageRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hisona.allive.FetchChannelResultReceiver;
import com.hisona.allive.Utils;
import com.orhanobut.hawk.Hawk;
import defpackage.re1;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class MainFragment extends BrowseSupportFragment implements FetchChannelResultReceiver.Receiver, OnItemViewClickedListener, OnItemViewSelectedListener {
    public static final /* synthetic */ int H1 = 0;
    public ArrayObjectAdapter A1;
    public ArrayObjectAdapter B1;
    public FirebaseAnalytics F1;
    public FetchChannelResultReceiver z1;
    public final Handler x1 = new Handler(Looper.getMainLooper());
    public final Gson y1 = new Gson();
    public SettingsData C1 = new SettingsData();
    public SpinnerFragment D1 = null;
    public String E1 = "";
    public final ActivityResultLauncher G1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new n(this));

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

    /* loaded from: classes2.dex */
    public class a extends TypeToken<ArrayList<String>> {
    }

    /* loaded from: classes2.dex */
    public class b extends TypeToken<ArrayList<String>> {
    }

    public void createDefaultRows() {
        this.A1.clear();
        this.A1.add(new PageRow(new HeaderItem(Utils.Header.Favorite.ordinal(), z(R.string.favorite))));
        if (this.C1.mWavveSettings.mEnable) {
            this.A1.add(new PageRow(new HeaderItem(Utils.Header.Wavve.ordinal(), z(R.string.wavve))));
        }
        if (this.C1.mTvingSettings.mEnable) {
            this.A1.add(new PageRow(new HeaderItem(Utils.Header.Tving.ordinal(), z(R.string.tving))));
        }
        HeaderItem headerItem = new HeaderItem(Utils.Header.Etc.ordinal(), z(R.string.etc));
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new q(this));
        this.B1 = arrayObjectAdapter;
        arrayObjectAdapter.add(new re1(0, z(R.string.preferences)));
        this.B1.add(new re1(1, z(R.string.help)));
        this.B1.add(new re1(2, z(R.string.opensource)));
        this.B1.add(new re1(3, z(R.string.version_str) + " 4.5"));
        this.A1.add(new ListRow(headerItem, this.B1));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // androidx.leanback.app.BrowseSupportFragment, androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r7) {
        /*
            Method dump skipped, instructions count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hisona.allive.MainFragment.onCreate(android.os.Bundle):void");
    }

    @Override // com.hisona.allive.FetchChannelResultReceiver.Receiver
    public void onReceiveResult(int i, Bundle bundle) {
        Utils.SiteType siteType = (Utils.SiteType) bundle.get(z(R.string.SITETYPE_STR));
        boolean equals = ((String) bundle.get(z(R.string.FETCHMODE_STR))).equals("refresh");
        if (!PlayerActivity.d0 && this.D1 != null) {
            requireActivity().getSupportFragmentManager().beginTransaction().remove(this.D1).commit();
            this.D1 = null;
        }
        int i2 = k.b[Utils.Code.values()[i].ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    String string = bundle.getString(z(R.string.ERRMSG_STR));
                    FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
                    ProfileSelectFragment profileSelectFragment = new ProfileSelectFragment();
                    profileSelectFragment.setClickListener(new o(this, profileSelectFragment));
                    profileSelectFragment.show(supportFragmentManager, z(R.string.PROFILESELECTDIALOG_STR));
                    supportFragmentManager.executePendingTransactions();
                    profileSelectFragment.setData(string);
                    return;
                }
                return;
            }
            String string2 = bundle.getString(z(R.string.ERRMSG_STR));
            int i3 = k.a[siteType.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    Utils.showToast(getContext(), z(R.string.tving_login_fail) + "\n" + string2);
                }
            } else {
                Utils.showToast(getContext(), z(R.string.wavve_login_fail) + "\n" + string2);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("site", siteType.toString());
            bundle2.putString("errmsg", string2);
            this.F1.logEvent(FirebaseAnalytics.Event.LOGIN, bundle2);
            return;
        }
        int i4 = k.a[siteType.ordinal()];
        Gson gson = this.y1;
        if (i4 != 1) {
            if (i4 == 2) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(z(R.string.CHANNELS_STR));
                if (Hawk.contains(z(R.string.TVING_CHANNELS_STR))) {
                    TvingRowSupportFragment.setFavorites(parcelableArrayList, (ArrayList) gson.fromJson((String) Hawk.get(z(R.string.TVING_CHANNELS_STR)), new TypeToken().getType()));
                } else {
                    TvingRowSupportFragment.setFavorites(parcelableArrayList, new ArrayList());
                }
                if (!equals) {
                    TvingRowSupportFragment.setChannelList(parcelableArrayList);
                    TvingRowSupportFragment.setCategoryList(bundle.getParcelableArrayList(z(R.string.CATEGORY_STR)));
                    TvingRowSupportFragment.setAuthKey(bundle.getString(z(R.string.AUTHKEY_STR)));
                    refreshServiceIntent(siteType);
                } else {
                    TvingRowSupportFragment.updateEPG(parcelableArrayList);
                }
            }
        } else {
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(z(R.string.CHANNELS_STR));
            if (Hawk.contains(z(R.string.WAVVE_CHANNELS_STR))) {
                WavveRowSupportFragment.setFavorites(parcelableArrayList2, (ArrayList) gson.fromJson((String) Hawk.get(z(R.string.WAVVE_CHANNELS_STR)), new TypeToken().getType()));
            } else {
                WavveRowSupportFragment.setFavorites(parcelableArrayList2, new ArrayList());
            }
            if (!equals) {
                WavveRowSupportFragment.setChannelList(parcelableArrayList2);
                WavveRowSupportFragment.setCategoryList(bundle.getParcelableArrayList(z(R.string.CATEGORY_STR)));
                WavveRowSupportFragment.setAuthKey(bundle.getString(z(R.string.AUTHKEY_STR)));
                refreshServiceIntent(siteType);
            } else {
                WavveRowSupportFragment.updateEPG(parcelableArrayList2);
            }
        }
        Fragment mainFragment = getMainFragment();
        Utils.SiteType siteType2 = Utils.SiteType.Wavve;
        if (siteType == siteType2 && (mainFragment instanceof WavveRowSupportFragment)) {
            if (PlayerActivity.d0) {
                ((WavveRowSupportFragment) mainFragment).sendChannelData();
            } else if (equals) {
                ((WavveRowSupportFragment) mainFragment).refreshRows();
            } else {
                ((WavveRowSupportFragment) mainFragment).createRows();
            }
        } else if (siteType == Utils.SiteType.Tving && (mainFragment instanceof TvingRowSupportFragment)) {
            if (PlayerActivity.d0) {
                ((TvingRowSupportFragment) mainFragment).sendChannelData();
            } else if (equals) {
                ((TvingRowSupportFragment) mainFragment).refreshRows();
            } else {
                ((TvingRowSupportFragment) mainFragment).createRows();
            }
        }
        if (mainFragment instanceof FavoriteRowSupportFragment) {
            if (siteType != siteType2 || !this.C1.mTvingSettings.mEnable) {
                if (PlayerActivity.d0) {
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
        String json = this.y1.toJson(this.C1);
        String authKey = TvBaseRowsSupportFragment.getAuthKey(siteType);
        intent.putExtra(z(R.string.FETCHCHANNELRESULTRECEIVER_STR), this.z1);
        intent.putExtra(z(R.string.SETTINGSDATA_STR), json);
        intent.putExtra(z(R.string.SITETYPE_STR), siteType);
        intent.putExtra(z(R.string.AUTHKEY_STR), authKey);
        intent.putExtra(z(R.string.FETCHMODE_STR), "refresh");
        intent.putParcelableArrayListExtra(z(R.string.CHANNELS_STR), TvBaseRowsSupportFragment.mChannels.get(siteType));
        intent.putParcelableArrayListExtra(z(R.string.CATEGORY_STR), TvBaseRowsSupportFragment.mCategory.get(siteType));
        FetchChannelService.enqueueWork(getActivity(), intent);
    }

    public void startServiceIntent(Utils.SiteType siteType) {
        if (this.D1 == null) {
            this.D1 = new SpinnerFragment();
            requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.main_browse_fragment, this.D1).commit();
        }
        String json = this.y1.toJson(this.C1);
        String authKey = TvBaseRowsSupportFragment.getAuthKey(siteType);
        if (authKey == null) {
            authKey = "";
        }
        Intent intent = new Intent(getActivity(), (Class<?>) FetchChannelService.class);
        intent.putExtra(z(R.string.FETCHCHANNELRESULTRECEIVER_STR), this.z1);
        intent.putExtra(z(R.string.SETTINGSDATA_STR), json);
        intent.putExtra(z(R.string.SITETYPE_STR), siteType);
        intent.putExtra(z(R.string.AUTHKEY_STR), authKey);
        intent.putExtra(z(R.string.FETCHMODE_STR), "create");
        FetchChannelService.enqueueWork(getActivity(), intent);
    }

    public final String z(int i) {
        return getResources().getString(i);
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof re1) {
            int i = ((re1) obj).b;
            if (i == 0) {
                Intent intent = new Intent(getActivity(), (Class<?>) SettingsActivity.class);
                intent.putExtra(z(R.string.SETTINGSDATA_STR), this.y1.toJson(this.C1));
                this.G1.launch(intent);
            } else if (i == 1) {
                FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
                RemoteInfoDialogFragment.newInstance().show(supportFragmentManager, z(R.string.REMOTEINFODIALOG_STR));
                supportFragmentManager.executePendingTransactions();
            } else if (i == 2) {
                FragmentManager supportFragmentManager2 = requireActivity().getSupportFragmentManager();
                LicensesDialogFragment.newInstance().show(supportFragmentManager2, z(R.string.LICENSESDIALOG_STR));
                supportFragmentManager2.executePendingTransactions();
            }
        }
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (viewHolder != null && (obj instanceof re1)) {
            int i = ((re1) obj).b;
            for (int i2 = 0; i2 < this.B1.size(); i2++) {
                View view = ((re1) this.B1.get(i2)).a;
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
