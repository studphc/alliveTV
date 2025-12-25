package com.hisona.allive;

import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.google.gson.Gson;
import com.hisona.allive.Utils;
import defpackage.i5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class TvBaseRowsSupportFragment extends RowsSupportFragment implements OnItemViewSelectedListener {
    protected OnKeyListener mKeyListener;
    protected OnItemViewLongClickedListener mLongClickedListener;
    protected CardPresenter mPresenterSelector;
    protected ArrayObjectAdapter mRowsAdapter;
    protected static HashMap<Utils.SiteType, ArrayList<ChannelData>> mChannels = new HashMap<>();
    protected static HashMap<Utils.SiteType, ArrayList<CategoryData>> mCategory = new HashMap<>();
    protected static HashMap<Utils.SiteType, ArrayList<String>> mFavorites = new HashMap<>();
    protected static HashMap<Utils.SiteType, String> mAuthKey = new HashMap<>();
    protected static HashMap<Utils.SiteType, Boolean> mEnable = new HashMap<>();
    public static boolean mLongPress = true;
    public static boolean mVolumeControl = false;
    protected static int mRowIndex = 0;
    protected static int mItemIndex = 0;
    protected Gson mGson = new Gson();
    protected Utils.SiteType mType = Utils.SiteType.None;
    public final ActivityResultLauncher B0 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new i5(22, this));

    public TvBaseRowsSupportFragment() {
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        this.mRowsAdapter = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
        setOnItemViewSelectedListener(this);
    }

    public static String getAuthKey(Utils.SiteType siteType) {
        return mAuthKey.get(siteType);
    }

    public static synchronized ArrayList<ChannelData> getChannelList(Utils.SiteType siteType) {
        synchronized (TvBaseRowsSupportFragment.class) {
            if (mChannels.containsKey(siteType)) {
                return mChannels.get(siteType);
            }
            return null;
        }
    }

    public static Boolean getEnable(Utils.SiteType siteType) {
        return mEnable.get(siteType);
    }

    public static synchronized ArrayList<String> getFavorites(Utils.SiteType siteType) {
        ArrayList<String> arrayList;
        synchronized (TvBaseRowsSupportFragment.class) {
            arrayList = mFavorites.get(siteType);
        }
        return arrayList;
    }

    public static void setAuthKey(Utils.SiteType siteType, String str) {
        mAuthKey.put(siteType, str);
    }

    public static synchronized void setCategoryList(Utils.SiteType siteType, ArrayList<CategoryData> arrayList) {
        ArrayList<CategoryData> arrayList2;
        synchronized (TvBaseRowsSupportFragment.class) {
            try {
                if (mCategory.containsKey(siteType) && (arrayList2 = mCategory.get(siteType)) != null) {
                    arrayList2.clear();
                }
                mCategory.put(siteType, arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void setChannelList(Utils.SiteType siteType, ArrayList<ChannelData> arrayList) {
        ArrayList<ChannelData> arrayList2;
        synchronized (TvBaseRowsSupportFragment.class) {
            try {
                if (mChannels.containsKey(siteType) && (arrayList2 = mChannels.get(siteType)) != null) {
                    arrayList2.clear();
                }
                mChannels.put(siteType, arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setEnable(Utils.SiteType siteType, Boolean bool) {
        mEnable.put(siteType, bool);
    }

    public static synchronized void setFavorites(Utils.SiteType siteType, ArrayList<ChannelData> arrayList, ArrayList<String> arrayList2) {
        ArrayList<String> arrayList3;
        synchronized (TvBaseRowsSupportFragment.class) {
            try {
                ArrayList<String> arrayList4 = new ArrayList<>();
                Iterator<String> it = arrayList2.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!arrayList4.contains(next)) {
                        arrayList4.add(next);
                    }
                }
                Iterator<ChannelData> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChannelData next2 = it2.next();
                    if (arrayList4.contains(next2.getId())) {
                        next2.setFavorite(1);
                    }
                }
                if (mFavorites.containsKey(siteType) && (arrayList3 = mFavorites.get(siteType)) != null) {
                    arrayList3.clear();
                }
                mFavorites.put(siteType, arrayList4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void updateEPG(Utils.SiteType siteType, ArrayList<ChannelData> arrayList) {
        synchronized (TvBaseRowsSupportFragment.class) {
            ArrayList<ChannelData> arrayList2 = mChannels.get(siteType);
            if (arrayList2 == null) {
                return;
            }
            for (int i = 0; i < arrayList2.size(); i++) {
                arrayList2.get(i).setEPG(arrayList.get(i).getEPG());
            }
        }
    }

    public static boolean updateFavoriteList(Utils.SiteType siteType) {
        ArrayList<ChannelData> arrayList = mChannels.get(siteType);
        ArrayList<String> arrayList2 = mFavorites.get(siteType);
        boolean z = false;
        if (arrayList == null) {
            return false;
        }
        if (arrayList2 == null) {
            arrayList2 = new ArrayList<>();
        }
        Iterator<ChannelData> it = arrayList.iterator();
        while (it.hasNext()) {
            ChannelData next = it.next();
            String id = next.getId();
            int favorite = next.getFavorite();
            if (arrayList2.contains(id)) {
                if (favorite == 0) {
                    arrayList2.remove(id);
                    z = true;
                }
            } else if (favorite > 0) {
                arrayList2.add(id);
                z = true;
            }
        }
        return z;
    }

    public void createDefaultRows() {
        CardPresenter cardPresenter = new CardPresenter(getContext());
        this.mPresenterSelector = cardPresenter;
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(cardPresenter);
        this.mRowsAdapter.add(new ListRow(new HeaderItem(getStringById(R.string.dologin_please)), arrayObjectAdapter));
    }

    public abstract void createRows();

    public String getStringById(int i) {
        return getResources().getString(i);
    }

    public boolean isEmptyCategory(Utils.SiteType siteType) {
        ArrayList<CategoryData> arrayList = mCategory.get(siteType);
        if (arrayList != null && !arrayList.isEmpty()) {
            return false;
        }
        return true;
    }

    public abstract void onActivityResult(ActivityResult activityResult);

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createRows();
    }

    public synchronized void refreshItemList() {
        ListRow listRow = (ListRow) this.mRowsAdapter.get(mRowIndex);
        listRow.getAdapter().notifyItemRangeChanged(0, listRow.getAdapter().size());
        setSelectedPosition(mRowIndex, false, new ListRowPresenter.SelectItemViewHolderTask(mItemIndex));
    }

    public synchronized void refreshRowList() {
        ArrayObjectAdapter arrayObjectAdapter = this.mRowsAdapter;
        arrayObjectAdapter.notifyArrayItemRangeChanged(0, arrayObjectAdapter.size());
        setSelectedPosition(mRowIndex, false, new ListRowPresenter.SelectItemViewHolderTask(mItemIndex));
    }

    public abstract void refreshRows();

    public abstract void sendChannelData();

    @Override // androidx.leanback.app.RowsSupportFragment
    public void setExpand(boolean z) {
        super.setExpand(true);
    }

    public void setIndex(int i, int i2) {
        mRowIndex = i;
        mItemIndex = i2;
    }

    public void setOnItemViewLongClickedListener(OnItemViewLongClickedListener onItemViewLongClickedListener) {
        this.mLongClickedListener = onItemViewLongClickedListener;
    }

    public void setOnKeyListener(OnKeyListener onKeyListener) {
        this.mKeyListener = onKeyListener;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (viewHolder == null) {
            return;
        }
        viewHolder.view.setOnLongClickListener(new z(this, viewHolder, obj, viewHolder2, row));
        viewHolder.view.setOnKeyListener(new a0(this));
        if (viewHolder2.getSelectedItem() == null) {
            mRowIndex = 0;
            mItemIndex = 0;
        } else {
            ChannelData channelData = (ChannelData) viewHolder2.getSelectedItem();
            mRowIndex = getSelectedPosition();
            mItemIndex = channelData.getItemIndex();
        }
    }

    public static boolean updateFavoriteList(Utils.SiteType siteType, ArrayList<ChannelData> arrayList) {
        ArrayList<ChannelData> arrayList2 = mChannels.get(siteType);
        ArrayList<String> arrayList3 = mFavorites.get(siteType);
        if (arrayList2 == null) {
            return false;
        }
        if (arrayList3 == null) {
            arrayList3 = new ArrayList<>();
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator<ChannelData> it = arrayList.iterator();
        while (it.hasNext()) {
            ChannelData next = it.next();
            if (next.getSiteType() == siteType.ordinal() && next.getFavorite() > 0 && !arrayList4.contains(next.getId())) {
                arrayList4.add(next.getId());
            }
        }
        Iterator<ChannelData> it2 = arrayList2.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            ChannelData next2 = it2.next();
            String id = next2.getId();
            int favorite = next2.getFavorite();
            if (arrayList4.contains(id)) {
                if (favorite == 0 && !arrayList3.contains(id)) {
                    next2.setFavorite(1);
                    arrayList3.add(id);
                    z = true;
                }
            } else if (favorite > 0) {
                next2.setFavorite(0);
                arrayList3.remove(id);
                z = true;
            }
        }
        return z;
    }
}
