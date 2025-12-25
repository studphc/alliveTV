package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;

    /* renamed from: a */
    public final DataSetObservable f7582a = new DataSetObservable();

    /* renamed from: b */
    public DataSetObserver f7583b;

    /* renamed from: a */
    public final void m1927a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f7583b = dataSetObserver;
        }
    }

    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        destroyItem((View) viewGroup, i, obj);
    }

    @Deprecated
    public void finishUpdate(@NonNull View view) {
    }

    public abstract int getCount();

    public int getItemPosition(@NonNull Object obj) {
        return -1;
    }

    @Nullable
    public CharSequence getPageTitle(int i) {
        return null;
    }

    public float getPageWidth(int i) {
        return 1.0f;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        return instantiateItem((View) viewGroup, i);
    }

    public abstract boolean isViewFromObject(@NonNull View view, @NonNull Object obj);

    public void notifyDataSetChanged() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.f7583b;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f7582a.notifyChanged();
    }

    public void registerDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        this.f7582a.registerObserver(dataSetObserver);
    }

    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
    }

    @Nullable
    public Parcelable saveState() {
        return null;
    }

    @Deprecated
    public void setPrimaryItem(@NonNull View view, int i, @NonNull Object obj) {
    }

    @Deprecated
    public void startUpdate(@NonNull View view) {
    }

    public void unregisterDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        this.f7582a.unregisterObserver(dataSetObserver);
    }

    @Deprecated
    public void destroyItem(@NonNull View view, int i, @NonNull Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        finishUpdate((View) viewGroup);
    }

    @NonNull
    @Deprecated
    public Object instantiateItem(@NonNull View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        setPrimaryItem((View) viewGroup, i, obj);
    }

    public void startUpdate(@NonNull ViewGroup viewGroup) {
        startUpdate((View) viewGroup);
    }
}
