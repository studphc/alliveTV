package com.hisona.allive;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResult;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.google.gson.Gson;
import com.hisona.allive.Utils;
import com.orhanobut.hawk.Hawk;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class FavoriteRowSupportFragment extends TvBaseRowsSupportFragment implements OnItemViewClickedListener, OnItemViewLongClickedListener, OnKeyListener {
    public LinearLayout C0;
    public boolean D0;

    public FavoriteRowSupportFragment() {
        this.mType = Utils.SiteType.Favorite;
        setOnItemViewClickedListener(this);
        setOnItemViewLongClickedListener(this);
        setOnKeyListener(this);
    }

    public static ArrayList<ChannelData> getChannelList() {
        return TvBaseRowsSupportFragment.getChannelList(Utils.SiteType.Favorite);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // com.hisona.allive.TvBaseRowsSupportFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void createRows() {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hisona.allive.FavoriteRowSupportFragment.createRows():void");
    }

    @Override // com.hisona.allive.TvBaseRowsSupportFragment
    public void onActivityResult(ActivityResult activityResult) {
        boolean z;
        boolean z2;
        int resultCode = activityResult.getResultCode();
        Intent data = activityResult.getData();
        if (resultCode == -1) {
            ArrayList<ChannelData> channelList = getChannelList();
            z = true;
            if (WavveRowSupportFragment.updateFavoriteList(channelList)) {
                if (!Hawk.put(getStringById(R.string.WAVVE_CHANNELS_STR), this.mGson.toJson(WavveRowSupportFragment.getFavorites()))) {
                    return;
                } else {
                    z2 = true;
                }
            } else {
                z2 = false;
            }
            if (TvingRowSupportFragment.updateFavoriteList(channelList)) {
                if (!Hawk.put(getStringById(R.string.TVING_CHANNELS_STR), this.mGson.toJson(TvingRowSupportFragment.getFavorites()))) {
                    return;
                }
            } else {
                z = z2;
            }
        } else {
            z = false;
        }
        if (data != null) {
            ChannelData channelData = TvBaseRowsSupportFragment.mChannels.get(this.mType).get(data.getIntExtra(getStringById(R.string.CURRENTCHANNEL_STR), 0));
            setIndex(channelData.getRowIndex(), channelData.getItemIndex());
        }
        if (z) {
            createRows();
        } else {
            refreshRows();
        }
    }

    @Override // com.hisona.allive.TvBaseRowsSupportFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.C0 = (LinearLayout) getActivity().getWindow().getLayoutInflater().inflate(R.layout.dpad_overlay, (ViewGroup) null);
        getActivity().getWindow().addContentView(this.C0, new LinearLayout.LayoutParams(-1, -1));
        if (this.D0) {
            this.C0.setVisibility(0);
        } else {
            this.C0.setVisibility(4);
        }
    }

    @Override // com.hisona.allive.OnItemViewLongClickedListener
    public boolean onItemLongClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (!TvBaseRowsSupportFragment.mLongPress) {
            return false;
        }
        if (this.mPresenterSelector.getEditMode()) {
            if (((ListRow) this.mRowsAdapter.get(TvBaseRowsSupportFragment.mRowIndex)).getHeaderItem().getName().equals(getStringById(R.string.wavve))) {
                Hawk.put(getStringById(R.string.WAVVE_CHANNELS_STR), new Gson().toJson(TvBaseRowsSupportFragment.mFavorites.get(Utils.SiteType.Wavve)));
            } else {
                Hawk.put(getStringById(R.string.TVING_CHANNELS_STR), new Gson().toJson(TvBaseRowsSupportFragment.mFavorites.get(Utils.SiteType.Tving)));
            }
            this.mPresenterSelector.setEditMode(false);
            setVisibility(false);
        } else {
            this.mPresenterSelector.setEditMode(true);
            if (viewHolder.view.isInTouchMode()) {
                setVisibility(true);
            }
        }
        refreshItemList();
        return true;
    }

    @Override // com.hisona.allive.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        int i2 = 0;
        if (i == 23 || i == 66 || i == 109 || i == 160 || i == 29 || !this.mPresenterSelector.getEditMode()) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (i == 21) {
                ObjectAdapter adapter = ((ListRow) this.mRowsAdapter.get(TvBaseRowsSupportFragment.mRowIndex)).getAdapter();
                int i3 = TvBaseRowsSupportFragment.mItemIndex;
                if (i3 > 0) {
                    ChannelData channelData = (ChannelData) adapter.get(i3);
                    ChannelData channelData2 = (ChannelData) adapter.get(TvBaseRowsSupportFragment.mItemIndex - 1);
                    ChannelData channelData3 = new ChannelData(channelData);
                    channelData.copyFrom(channelData2);
                    channelData2.copyFrom(channelData3);
                    channelData2.setItemIndex(TvBaseRowsSupportFragment.mItemIndex - 1);
                    channelData.setItemIndex(TvBaseRowsSupportFragment.mItemIndex);
                    if (((ListRow) this.mRowsAdapter.get(TvBaseRowsSupportFragment.mRowIndex)).getHeaderItem().getName().equals(getStringById(R.string.wavve))) {
                        arrayList2 = TvBaseRowsSupportFragment.mFavorites.get(Utils.SiteType.Wavve);
                    } else {
                        arrayList2 = TvBaseRowsSupportFragment.mFavorites.get(Utils.SiteType.Tving);
                    }
                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                        arrayList2.clear();
                        while (i2 < adapter.size()) {
                            arrayList2.add(((ChannelData) adapter.get(i2)).getId());
                            i2++;
                        }
                    }
                    TvBaseRowsSupportFragment.mItemIndex--;
                    refreshItemList();
                }
            } else if (i == 22) {
                ObjectAdapter adapter2 = ((ListRow) this.mRowsAdapter.get(TvBaseRowsSupportFragment.mRowIndex)).getAdapter();
                if (TvBaseRowsSupportFragment.mItemIndex < adapter2.size() - 1) {
                    ListRow listRow = (ListRow) this.mRowsAdapter.get(TvBaseRowsSupportFragment.mRowIndex);
                    ChannelData channelData4 = (ChannelData) listRow.getAdapter().get(TvBaseRowsSupportFragment.mItemIndex);
                    ChannelData channelData5 = (ChannelData) listRow.getAdapter().get(TvBaseRowsSupportFragment.mItemIndex + 1);
                    ChannelData channelData6 = new ChannelData(channelData4);
                    channelData4.copyFrom(channelData5);
                    channelData5.copyFrom(channelData6);
                    channelData4.setItemIndex(TvBaseRowsSupportFragment.mItemIndex);
                    channelData5.setItemIndex(TvBaseRowsSupportFragment.mItemIndex + 1);
                    if (((ListRow) this.mRowsAdapter.get(TvBaseRowsSupportFragment.mRowIndex)).getHeaderItem().getName().equals(getStringById(R.string.wavve))) {
                        arrayList = TvBaseRowsSupportFragment.mFavorites.get(Utils.SiteType.Wavve);
                    } else {
                        arrayList = TvBaseRowsSupportFragment.mFavorites.get(Utils.SiteType.Tving);
                    }
                    if (arrayList != null && !arrayList.isEmpty()) {
                        arrayList.clear();
                        while (i2 < adapter2.size()) {
                            arrayList.add(((ChannelData) adapter2.get(i2)).getId());
                            i2++;
                        }
                    }
                    TvBaseRowsSupportFragment.mItemIndex++;
                    refreshItemList();
                }
            } else if (i == 4 || i == 30) {
                if (((ListRow) this.mRowsAdapter.get(TvBaseRowsSupportFragment.mRowIndex)).getHeaderItem().getName().equals(getStringById(R.string.wavve))) {
                    Hawk.put(getStringById(R.string.WAVVE_CHANNELS_STR), new Gson().toJson(TvBaseRowsSupportFragment.mFavorites.get(Utils.SiteType.Wavve)));
                } else {
                    Hawk.put(getStringById(R.string.TVING_CHANNELS_STR), new Gson().toJson(TvBaseRowsSupportFragment.mFavorites.get(Utils.SiteType.Tving)));
                }
                setVisibility(false);
                this.mPresenterSelector.setEditMode(false);
                refreshItemList();
            }
        }
        return true;
    }

    @Override // com.hisona.allive.TvBaseRowsSupportFragment
    public void refreshRows() {
        ArrayList<ChannelData> arrayList = TvBaseRowsSupportFragment.mChannels.get(this.mType);
        if (this.mPresenterSelector.getEditMode()) {
            this.mPresenterSelector.setEditMode(false);
        }
        HashMap<Utils.SiteType, ArrayList<ChannelData>> hashMap = TvBaseRowsSupportFragment.mChannels;
        Utils.SiteType siteType = Utils.SiteType.Wavve;
        ArrayList<ChannelData> arrayList2 = hashMap.get(siteType);
        if (TvBaseRowsSupportFragment.mEnable.get(siteType) == Boolean.TRUE && arrayList2 != null && arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                ChannelData channelData = arrayList.get(i);
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    if (channelData.getId().equals(arrayList2.get(i2).getId())) {
                        channelData.setEPG(arrayList2.get(i2).getEPG(), true);
                    }
                }
            }
        }
        HashMap<Utils.SiteType, ArrayList<ChannelData>> hashMap2 = TvBaseRowsSupportFragment.mChannels;
        Utils.SiteType siteType2 = Utils.SiteType.Tving;
        ArrayList<ChannelData> arrayList3 = hashMap2.get(siteType2);
        if (TvBaseRowsSupportFragment.mEnable.get(siteType2) == Boolean.TRUE && arrayList3 != null && arrayList != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ChannelData channelData2 = arrayList.get(i3);
                for (int i4 = 0; i4 < arrayList3.size(); i4++) {
                    if (channelData2.getId().equals(arrayList3.get(i4).getId())) {
                        channelData2.setEPG(arrayList3.get(i4).getEPG(), true);
                    }
                }
            }
        }
        refreshRowList();
    }

    @Override // com.hisona.allive.TvBaseRowsSupportFragment
    public void sendChannelData() {
        ArrayList<ChannelData> arrayList = TvBaseRowsSupportFragment.mChannels.get(this.mType);
        HashMap<Utils.SiteType, ArrayList<ChannelData>> hashMap = TvBaseRowsSupportFragment.mChannels;
        Utils.SiteType siteType = Utils.SiteType.Wavve;
        ArrayList<ChannelData> arrayList2 = hashMap.get(siteType);
        if (TvBaseRowsSupportFragment.mEnable.get(siteType) == Boolean.TRUE && arrayList2 != null && arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                ChannelData channelData = arrayList.get(i);
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    if (channelData.getId().equals(arrayList2.get(i2).getId())) {
                        channelData.setEPG(arrayList2.get(i2).getEPG(), true);
                    }
                }
            }
        }
        HashMap<Utils.SiteType, ArrayList<ChannelData>> hashMap2 = TvBaseRowsSupportFragment.mChannels;
        Utils.SiteType siteType2 = Utils.SiteType.Tving;
        ArrayList<ChannelData> arrayList3 = hashMap2.get(siteType2);
        if (TvBaseRowsSupportFragment.mEnable.get(siteType2) == Boolean.TRUE && arrayList3 != null && arrayList != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ChannelData channelData2 = arrayList.get(i3);
                for (int i4 = 0; i4 < arrayList3.size(); i4++) {
                    if (channelData2.getId().equals(arrayList3.get(i4).getId())) {
                        channelData2.setEPG(arrayList3.get(i4).getEPG(), true);
                    }
                }
            }
        }
        Intent intent = new Intent(getActivity(), (Class<?>) PlayerActivity.class);
        intent.addFlags(536870912);
        requireActivity().startActivity(intent);
    }

    public void setVisibility(boolean z) {
        this.D0 = z;
        LinearLayout linearLayout = this.C0;
        if (linearLayout != null) {
            if (z) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(4);
            }
        }
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        String str;
        if (this.mPresenterSelector.getEditMode()) {
            if (((ListRow) this.mRowsAdapter.get(TvBaseRowsSupportFragment.mRowIndex)).getHeaderItem().getName().equals(getStringById(R.string.wavve))) {
                Hawk.put(getStringById(R.string.WAVVE_CHANNELS_STR), new Gson().toJson(TvBaseRowsSupportFragment.mFavorites.get(Utils.SiteType.Wavve)));
            } else {
                Hawk.put(getStringById(R.string.TVING_CHANNELS_STR), new Gson().toJson(TvBaseRowsSupportFragment.mFavorites.get(Utils.SiteType.Tving)));
            }
            this.mPresenterSelector.setEditMode(false);
            setVisibility(false);
            refreshItemList();
            return;
        }
        if (obj instanceof ChannelData) {
            int siteType = ((ChannelData) obj).getSiteType();
            Utils.SiteType siteType2 = Utils.SiteType.Wavve;
            if (siteType == siteType2.ordinal()) {
                str = TvBaseRowsSupportFragment.mAuthKey.get(siteType2);
            } else {
                str = TvBaseRowsSupportFragment.mAuthKey.get(Utils.SiteType.Tving);
            }
            if (str != null && str.length() >= 10) {
                ArrayList<ChannelData> arrayList = TvBaseRowsSupportFragment.mChannels.get(this.mType);
                if (arrayList == null) {
                    return;
                }
                int indexOf = arrayList.indexOf(obj);
                if (PlayerActivity.d0) {
                    return;
                }
                Utils.Code.FavoritePlay.ordinal();
                Intent intent = new Intent(getActivity(), (Class<?>) PlayerActivity.class);
                intent.addFlags(536870912);
                intent.putExtra(getStringById(R.string.CURRENTCHANNEL_STR), indexOf);
                ArrayList<String> arrayList2 = new ArrayList<>();
                arrayList2.add(TvBaseRowsSupportFragment.mAuthKey.get(siteType2));
                arrayList2.add(TvBaseRowsSupportFragment.mAuthKey.get(Utils.SiteType.Tving));
                intent.putStringArrayListExtra(getStringById(R.string.AUTHKEY_STR), arrayList2);
                intent.putExtra(getStringById(R.string.SITETYPE_STR), this.mType.ordinal());
                intent.putExtra(getStringById(R.string.SITETYPE_STR), this.mType.ordinal());
                intent.putExtra(getStringById(R.string.VOLUMECONTROL_STR), TvBaseRowsSupportFragment.mVolumeControl);
                this.B0.launch(intent);
                return;
            }
            Utils.showToast(getContext(), getStringById(R.string.nologin_error));
        }
    }
}
