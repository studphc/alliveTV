package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import p000.ye0;

@Deprecated
/* loaded from: classes.dex */
public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;

    /* renamed from: c */
    public final FragmentManager f4578c;

    /* renamed from: d */
    public final int f4579d;

    /* renamed from: e */
    public FragmentTransaction f4580e;

    /* renamed from: f */
    public final ArrayList f4581f;

    /* renamed from: g */
    public final ArrayList f4582g;

    /* renamed from: h */
    public Fragment f4583h;

    /* renamed from: i */
    public boolean f4584i;

    @Deprecated
    public FragmentStatePagerAdapter(@NonNull FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        ArrayList arrayList;
        Fragment.SavedState savedState;
        Fragment fragment = (Fragment) obj;
        FragmentTransaction fragmentTransaction = this.f4580e;
        FragmentManager fragmentManager = this.f4578c;
        if (fragmentTransaction == null) {
            this.f4580e = fragmentManager.beginTransaction();
        }
        while (true) {
            arrayList = this.f4581f;
            if (arrayList.size() > i) {
                break;
            } else {
                arrayList.add(null);
            }
        }
        if (fragment.isAdded()) {
            savedState = fragmentManager.saveFragmentInstanceState(fragment);
        } else {
            savedState = null;
        }
        arrayList.set(i, savedState);
        this.f4582g.set(i, null);
        this.f4580e.remove(fragment);
        if (fragment.equals(this.f4583h)) {
            this.f4583h = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f4580e;
        if (fragmentTransaction != null) {
            if (!this.f4584i) {
                try {
                    this.f4584i = true;
                    fragmentTransaction.commitNowAllowingStateLoss();
                } finally {
                    this.f4584i = false;
                }
            }
            this.f4580e = null;
        }
    }

    @NonNull
    public abstract Fragment getItem(int i);

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        Fragment fragment;
        ArrayList arrayList = this.f4582g;
        if (arrayList.size() > i && (fragment = (Fragment) arrayList.get(i)) != null) {
            return fragment;
        }
        if (this.f4580e == null) {
            this.f4580e = this.f4578c.beginTransaction();
        }
        Fragment item = getItem(i);
        ArrayList arrayList2 = this.f4581f;
        if (arrayList2.size() > i && (savedState = (Fragment.SavedState) arrayList2.get(i)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (arrayList.size() <= i) {
            arrayList.add(null);
        }
        item.setMenuVisibility(false);
        int i2 = this.f4579d;
        if (i2 == 0) {
            item.setUserVisibleHint(false);
        }
        arrayList.set(i, item);
        this.f4580e.add(viewGroup.getId(), item);
        if (i2 == 1) {
            this.f4580e.setMaxLifecycle(item, Lifecycle.State.STARTED);
        }
        return item;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        if (((Fragment) obj).getView() == view) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            ArrayList arrayList = this.f4581f;
            arrayList.clear();
            ArrayList arrayList2 = this.f4582g;
            arrayList2.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    arrayList.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.f4578c.getFragment(bundle, str);
                    if (fragment != null) {
                        while (arrayList2.size() <= parseInt) {
                            arrayList2.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        arrayList2.set(parseInt, fragment);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key ".concat(str));
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        Bundle bundle;
        ArrayList arrayList = this.f4581f;
        if (arrayList.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[arrayList.size()];
            arrayList.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        int i = 0;
        while (true) {
            ArrayList arrayList2 = this.f4582g;
            if (i < arrayList2.size()) {
                Fragment fragment = (Fragment) arrayList2.get(i);
                if (fragment != null && fragment.isAdded()) {
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    this.f4578c.putFragment(bundle, ye0.m8291k(i, "f"), fragment);
                }
                i++;
            } else {
                return bundle;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f4583h;
        if (fragment != fragment2) {
            FragmentManager fragmentManager = this.f4578c;
            int i2 = this.f4579d;
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (i2 == 1) {
                    if (this.f4580e == null) {
                        this.f4580e = fragmentManager.beginTransaction();
                    }
                    this.f4580e.setMaxLifecycle(this.f4583h, Lifecycle.State.STARTED);
                } else {
                    this.f4583h.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (i2 == 1) {
                if (this.f4580e == null) {
                    this.f4580e = fragmentManager.beginTransaction();
                }
                this.f4580e.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f4583h = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(@NonNull ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public FragmentStatePagerAdapter(@NonNull FragmentManager fragmentManager, int i) {
        this.f4580e = null;
        this.f4581f = new ArrayList();
        this.f4582g = new ArrayList();
        this.f4583h = null;
        this.f4578c = fragmentManager;
        this.f4579d = i;
    }
}
