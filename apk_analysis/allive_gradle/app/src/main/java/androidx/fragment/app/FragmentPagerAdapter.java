package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

@Deprecated
/* loaded from: classes.dex */
public abstract class FragmentPagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;

    /* renamed from: c */
    public final FragmentManager f4558c;

    /* renamed from: d */
    public final int f4559d;

    /* renamed from: e */
    public FragmentTransaction f4560e;

    /* renamed from: f */
    public Fragment f4561f;

    /* renamed from: g */
    public boolean f4562g;

    @Deprecated
    public FragmentPagerAdapter(@NonNull FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f4560e == null) {
            this.f4560e = this.f4558c.beginTransaction();
        }
        this.f4560e.detach(fragment);
        if (fragment.equals(this.f4561f)) {
            this.f4561f = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f4560e;
        if (fragmentTransaction != null) {
            if (!this.f4562g) {
                try {
                    this.f4562g = true;
                    fragmentTransaction.commitNowAllowingStateLoss();
                } finally {
                    this.f4562g = false;
                }
            }
            this.f4560e = null;
        }
    }

    @NonNull
    public abstract Fragment getItem(int i);

    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        FragmentTransaction fragmentTransaction = this.f4560e;
        FragmentManager fragmentManager = this.f4558c;
        if (fragmentTransaction == null) {
            this.f4560e = fragmentManager.beginTransaction();
        }
        long itemId = getItemId(i);
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag("android:switcher:" + viewGroup.getId() + ":" + itemId);
        if (findFragmentByTag != null) {
            this.f4560e.attach(findFragmentByTag);
        } else {
            findFragmentByTag = getItem(i);
            this.f4560e.add(viewGroup.getId(), findFragmentByTag, "android:switcher:" + viewGroup.getId() + ":" + itemId);
        }
        if (findFragmentByTag != this.f4561f) {
            findFragmentByTag.setMenuVisibility(false);
            if (this.f4559d == 1) {
                this.f4560e.setMaxLifecycle(findFragmentByTag, Lifecycle.State.STARTED);
            } else {
                findFragmentByTag.setUserVisibleHint(false);
            }
        }
        return findFragmentByTag;
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
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f4561f;
        if (fragment != fragment2) {
            FragmentManager fragmentManager = this.f4558c;
            int i2 = this.f4559d;
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (i2 == 1) {
                    if (this.f4560e == null) {
                        this.f4560e = fragmentManager.beginTransaction();
                    }
                    this.f4560e.setMaxLifecycle(this.f4561f, Lifecycle.State.STARTED);
                } else {
                    this.f4561f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (i2 == 1) {
                if (this.f4560e == null) {
                    this.f4560e = fragmentManager.beginTransaction();
                }
                this.f4560e.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f4561f = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(@NonNull ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public FragmentPagerAdapter(@NonNull FragmentManager fragmentManager, int i) {
        this.f4560e = null;
        this.f4561f = null;
        this.f4558c = fragmentManager;
        this.f4559d = i;
    }
}
