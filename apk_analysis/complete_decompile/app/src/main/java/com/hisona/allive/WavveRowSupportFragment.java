package com.hisona.allive;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.google.gson.Gson;
import com.hisona.allive.SettingsData;
import com.hisona.allive.Utils;
import com.orhanobut.hawk.Hawk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class WavveRowSupportFragment extends TvBaseRowsSupportFragment implements OnItemViewClickedListener, OnItemViewLongClickedListener {
    static {
        SettingsData.WavveQualityType wavveQualityType = SettingsData.WavveQualityType.MD;
    }

    public WavveRowSupportFragment() {
        this.mType = Utils.SiteType.Wavve;
        setOnItemViewClickedListener(this);
        setOnItemViewLongClickedListener(this);
    }

    public static ArrayList<ChannelData> getChannelList() {
        return TvBaseRowsSupportFragment.getChannelList(Utils.SiteType.Wavve);
    }

    public static ArrayList<String> getFavorites() {
        return TvBaseRowsSupportFragment.getFavorites(Utils.SiteType.Wavve);
    }

    public static void setAuthKey(String str) {
        TvBaseRowsSupportFragment.setAuthKey(Utils.SiteType.Wavve, str);
    }

    public static void setCategoryList(ArrayList<CategoryData> arrayList) {
        TvBaseRowsSupportFragment.setCategoryList(Utils.SiteType.Wavve, arrayList);
    }

    public static void setChannelList(ArrayList<ChannelData> arrayList) {
        TvBaseRowsSupportFragment.setChannelList(Utils.SiteType.Wavve, arrayList);
    }

    public static void setEnable(Boolean bool) {
        TvBaseRowsSupportFragment.setEnable(Utils.SiteType.Wavve, bool);
    }

    public static void setFavorites(ArrayList<ChannelData> arrayList, ArrayList<String> arrayList2) {
        TvBaseRowsSupportFragment.setFavorites(Utils.SiteType.Wavve, arrayList, arrayList2);
    }

    public static void setQualityType(SettingsData.WavveQualityType wavveQualityType) {
    }

    public static void updateEPG(ArrayList<ChannelData> arrayList) {
        TvBaseRowsSupportFragment.updateEPG(Utils.SiteType.Wavve, arrayList);
    }

    public static boolean updateFavoriteList() {
        return TvBaseRowsSupportFragment.updateFavoriteList(Utils.SiteType.Wavve);
    }

    @Override // com.hisona.allive.TvBaseRowsSupportFragment
    public void createRows() {
        ArrayList arrayList;
        this.mRowsAdapter.clear();
        this.mPresenterSelector = new CardPresenter(getContext());
        if (isEmptyCategory(this.mType)) {
            createDefaultRows();
            if (getMainFragmentAdapter() != null && getMainFragmentAdapter().getFragmentHost() != null) {
                getMainFragmentAdapter().getFragmentHost().notifyDataReady(getMainFragmentAdapter());
                return;
            }
            return;
        }
        ArrayList<CategoryData> arrayList2 = TvBaseRowsSupportFragment.mCategory.get(this.mType);
        if (TvBaseRowsSupportFragment.mChannels.containsKey(this.mType)) {
            ArrayList<ChannelData> arrayList3 = TvBaseRowsSupportFragment.mChannels.get(this.mType);
            if (arrayList3 != null) {
                arrayList = new ArrayList(arrayList3);
            } else {
                arrayList = new ArrayList();
            }
        } else {
            arrayList = new ArrayList();
        }
        Collections.reverse(arrayList);
        Iterator<CategoryData> it = arrayList2.iterator();
        int i = 0;
        while (it.hasNext()) {
            CategoryData next = it.next();
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(this.mPresenterSelector);
            int i2 = 0;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (next.getId() == ((ChannelData) arrayList.get(size)).getCategoryId()) {
                    ((ChannelData) arrayList.get(size)).setRowIndex(i);
                    ((ChannelData) arrayList.get(size)).setItemIndex(i2);
                    arrayObjectAdapter.add(arrayList.get(size));
                    i2++;
                }
            }
            if (arrayObjectAdapter.size() > 0) {
                this.mRowsAdapter.add(new ListRow(new HeaderItem(next.getTitle()), arrayObjectAdapter));
                i++;
            }
        }
        if (getMainFragmentAdapter() != null) {
            getMainFragmentAdapter().getFragmentHost().notifyDataReady(getMainFragmentAdapter());
        }
    }

    @Override // com.hisona.allive.TvBaseRowsSupportFragment
    public void onActivityResult(ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        Intent data = activityResult.getData();
        if (resultCode == -1 && updateFavoriteList()) {
            if (!Hawk.put(getStringById(R.string.WAVVE_CHANNELS_STR), this.mGson.toJson(getFavorites()))) {
                return;
            }
        }
        if (data != null) {
            ChannelData channelData = TvBaseRowsSupportFragment.mChannels.get(this.mType).get(data.getIntExtra(getStringById(R.string.CURRENTCHANNEL_STR), 0));
            setIndex(channelData.getRowIndex(), channelData.getItemIndex());
        }
        refreshRows();
    }

    @Override // com.hisona.allive.OnItemViewLongClickedListener
    public boolean onItemLongClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (!TvBaseRowsSupportFragment.mLongPress || !(obj instanceof ChannelData)) {
            return false;
        }
        ChannelData channelData = (ChannelData) obj;
        String id = channelData.getId();
        ArrayList<String> arrayList = TvBaseRowsSupportFragment.mFavorites.get(this.mType);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (channelData.getFavorite() > 0) {
            channelData.setFavorite(0);
            arrayList.remove(id);
        } else {
            channelData.setFavorite(1);
            arrayList.add(id);
        }
        Hawk.put(getStringById(R.string.WAVVE_CHANNELS_STR), new Gson().toJson(arrayList));
        refreshItemList();
        return true;
    }

    @Override // com.hisona.allive.TvBaseRowsSupportFragment
    public void refreshRows() {
        refreshRowList();
    }

    @Override // com.hisona.allive.TvBaseRowsSupportFragment
    public void sendChannelData() {
        Intent intent = new Intent(getActivity(), (Class<?>) PlayerActivity.class);
        intent.addFlags(536870912);
        requireActivity().startActivity(intent);
    }

    public static boolean updateFavoriteList(ArrayList<ChannelData> arrayList) {
        return TvBaseRowsSupportFragment.updateFavoriteList(Utils.SiteType.Wavve, arrayList);
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof ChannelData) {
            String str = TvBaseRowsSupportFragment.mAuthKey.get(this.mType);
            if (str != null && str.length() >= 10) {
                ArrayList<ChannelData> arrayList = TvBaseRowsSupportFragment.mChannels.get(this.mType);
                if (arrayList == null) {
                    return;
                }
                int indexOf = arrayList.indexOf(obj);
                if (PlayerActivity.f15869d0) {
                    return;
                }
                Utils.Code.WavvePlay.ordinal();
                Intent intent = new Intent(getActivity(), (Class<?>) PlayerActivity.class);
                intent.addFlags(536870912);
                intent.putExtra(getStringById(R.string.CURRENTCHANNEL_STR), indexOf);
                ArrayList<String> arrayList2 = new ArrayList<>();
                arrayList2.add(TvBaseRowsSupportFragment.mAuthKey.get(Utils.SiteType.Wavve));
                arrayList2.add(TvBaseRowsSupportFragment.mAuthKey.get(Utils.SiteType.Tving));
                intent.putStringArrayListExtra(getStringById(R.string.AUTHKEY_STR), arrayList2);
                intent.putExtra(getStringById(R.string.SITETYPE_STR), this.mType.ordinal());
                intent.putExtra(getStringById(R.string.VOLUMECONTROL_STR), TvBaseRowsSupportFragment.mVolumeControl);
                this.f15952B0.launch(intent);
                return;
            }
            Utils.showToast(getContext(), getStringById(R.string.nologin_error));
        }
    }
}
